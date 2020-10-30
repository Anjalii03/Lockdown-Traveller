package Server;
/*
*
* PRIYANSHI DIXIT
*
*/
import java.sql.*;
import Client.*;
import java.util.ArrayList;
public class DatabaseManager {
	private static Connection con;
	private static Statement st;
    public void setConnection(){             // connecting to db
        try{ 
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("success");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3308/softablitz","root","");  //edit 3306 in your case
        st=con.createStatement();
        System.out.println("connected to database");
        }
        catch(ClassNotFoundException e){
        System.out.println(e);
        }
        catch(SQLException e){
        System.out.println(e+"not connected to db");
       }
    }
    public void CloseConnection(){
        try {
	con.close();
        st.close();
	}
	catch(SQLException e) {
	System.out.println(e);
	}
    }
    public boolean Register(RegisterRequest r){
        try{
            PreparedStatement ps = con.prepareStatement("INSERT INTO user (first_name,last_name,dob,gender,phone_no,email,username,password) "
                      + "values(?,?,?,?,?,?,?,?) ");
		ps.setString(1, r.getFirstNmae());
		ps.setString(2, r.getLastNmae());
		ps.setString(3, r.getDOB());
		ps.setString(4, r.getGender());
                ps.setString(5, r.getContact());
                ps.setString(6, r.getEmail());
                ps.setString(7, r.getUsername());
                ps.setString(8, r.getPassword());
		ps.executeUpdate();	
                return true;
        }catch(Exception e){
            System.out.println(e);
        }		
        return false;
    }
    public boolean Checklogin(LoginRequest l) {
        try{
            String sql="Select username,password from user";      
            ResultSet rs = st.executeQuery(sql);
            boolean flag=false;
            while(rs.next()) {
                String datausername=rs.getString("username");
                String datapassword=rs.getString("password");
                if (datausername.equals(l.getusername())&&datapassword.equals(l.getpassword())){  
                    System.out.println("found in db "+datausername+" "+datapassword);
                    flag=true;
                    return true;
                }
            }
            if(flag==false){
                System.out.println("not found");    
            }
            
        }catch(SQLException e){
            System.out.println(e);
        }
        return false;
    }    
    public ArrayList CheckTrains(TrainsBetweenRequest t) {
    
        try
        {
            String sql = "select source,train_id,train_no,departure,kilometers from TrainStatus";
            ResultSet rs = st.executeQuery(sql);
            boolean flag=false;
            while(rs.next()) {
                String datasource = rs.getString("source");
                String s_id = String.valueOf(rs.getInt("train_id"));
                String s_no = String.valueOf(rs.getInt("train_no"));
                String departure = rs.getString("departure");
                int dis=rs.getInt("kilometers");
                if(datasource.equals(t.getSource()))
                {
                    String sq = "select destination,train_id,train_no,arrival,kilometers from TrainStatus";
                    ResultSet r = st.executeQuery(sq);
                    int dist=0;
                    dist=dist+dis;
                    while(r.next())
                    {
                        String datadestination = r.getString("destination");
                        String d_id = String.valueOf(r.getInt("train_id"));
                        String d_no = String.valueOf(r.getInt("train_no"));
                        String arrival = r.getString("arrival");
                        if(Integer.parseInt(s_id)-Integer.parseInt(d_id)==-1){
                            dist=dist+r.getInt("kilometers");
                        }
                         if(Integer.parseInt(s_id)-Integer.parseInt(d_id)==-2){
                            dist=dist+r.getInt("kilometers");
                        }
                        if(datadestination.equals(t.getDestination()) && s_no.equals(d_no) && (s_id.compareTo(d_id) <= 0))
                        {
                           
                            int SID=Integer.parseInt(s_id);
                            int DID=Integer.parseInt(d_id);
                            String NO=s_no;
                            System.out.println("found in db "+datasource+" "+datadestination);
                            flag=true;
                              ArrayList<String> list=new ArrayList<String>(); 
                              list.add(s_no);
                              list.add(datasource);
                              list.add(datadestination);
                              list.add(departure);
                              list.add(arrival);
                             System.out.println("1St condition");
                            String sql1="select * from availability";
                            ResultSet r1 = st.executeQuery(sql1);
                            int SeAC=1000,SeSL=1000;
                            while(r1.next()){
                                int Tr_id=(r1.getInt("train_id"));
                                String d_date=String.valueOf(r1.getDate("date"));
                                int seats_ac=(r1.getInt("seats_in_ac"));
                                int seats_sl=(r1.getInt("seats_in_sleeper"));
                                if(d_date.equals(t.getDate())&&Tr_id==(SID+1)&&DID-SID==2){
                                SeAC=Math.min(SeAC,seats_ac);
                                System.out.println("fis if");
                                SeSL=Math.min(SeSL,seats_sl);
                                }
                                if(d_date.equals(t.getDate())&&(Tr_id==(SID))||Tr_id==(DID)){
                                  SeAC=Math.min(SeAC,seats_ac);
                                  System.out.println("sec if");
                                  SeSL=Math.min(SeSL,seats_sl);
                                }
                            }
                             list.add(String.valueOf(SeAC));
                             list.add(String.valueOf(SeSL));
                            String sql2="select * from train";
                            ResultSet r2 = st.executeQuery(sql2);
                            while(r2.next()){
                                String TrainNo=String.valueOf(r2.getInt("train_no"));
                                int fare_ac=(r2.getInt("fare_for_ac_per_km"));
                                int fare_sl=(r2.getInt("fare_for_sleeper_per_km"));
                                if(TrainNo.equals(NO)){
                                    System.out.println(dist);
                                    int ac_cost=fare_ac*dist;
                                    int sl_cost=fare_sl*dist;
                                    list.add(String.valueOf(ac_cost));
                                    list.add(String.valueOf(sl_cost));

                                }
                            }
                        return list;
                        }
                    }
                   
                }
            }
             
            if(flag==false){
                System.out.println("not found");    
            }
            
        }catch(SQLException e){
            System.out.println(e);
        }
        return null;    
    }
    public boolean addPassenger(BookingRequest br){
        try{
            int coach;
            if(br.getCoach().equals("AC")){
                coach=1;
            }
            else{
                coach=2;
            }
            PreparedStatement ps = con.prepareStatement("INSERT INTO passengers (user_id,name,age,gender,status,coach_no,source,desrination,date) "
                    + "values(?,?,?,?,?,?,?,?) ");
                ps.setString(1, br.getUsername());
		ps.setString(2, br.getName());
		ps.setString(3, br.getAge());
		ps.setString(4, br.getGender());
                ps.setString(5, "CNF");
                ps.setInt(6, coach);
                ps.setString(7, br.getSource());
                ps.setString(8, br.getDestination());
                ps.setString(9, br.getDate());
		ps.executeUpdate();	
                return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public int ConfirmSeats(SeatsConfirmation sc){
        try{
            String sql = "select source,train_id,train_no,destination from TrainStatus";
            ResultSet rs = st.executeQuery(sql);
            int SID=0,DID=0;
            while(rs.next()) {
                String datasource = rs.getString("source");
                int id = (rs.getInt("train_id"));
                String destination = rs.getString("destination");
                if(datasource.equals(sc.getSource()))
                {
                    SID=id;
                    System.out.println("sid --"+SID);
                }
                if(destination.equals(sc.getDestination()))
                {
                    DID=id;
                    System.out.println("did --"+DID);
                }
            }
            String sql1 = "select * from Availability";
            ResultSet rs1 = st.executeQuery(sql1);
            while(rs1.next()){
                int ac_ct=rs1.getInt("seats_in_ac");
                int sl_ct=rs1.getInt("seats_in_sleeper");
                int trid=rs1.getInt("train_id");
                String date=String.valueOf(rs1.getDate("date"));
                if(DID==trid&&SID==trid&&date.equals(sc.getDate())){
                        if(sc.getCoach().equals("AC")){
                           int s= ac_ct-Integer.parseInt(sc.getNoPassg());
                           st.executeUpdate("update Availability set seats_in_ac="+s+" where date='"+date+"' and train_id="+SID);
                           System.out.println("if1 sub if");
                           return ac_ct;
                        }
                        else{
                            int s= sl_ct-Integer.parseInt(sc.getNoPassg());
                            st.executeUpdate("update Availability set seats_in_sleeper="+s+" where date='"+date+"' and train_id="+SID);
                            System.out.println("if 1 else -");
                            return sl_ct;
                        }
                        
                    }
                else if(DID-SID==1&&(trid==DID||trid==SID)&&date.equals(sc.getDate())){
                    if(sc.getCoach().equals("AC")){
                           int s= ac_ct-Integer.parseInt(sc.getNoPassg());
                           st.executeUpdate("update Availability set seats_in_ac="+s+" where date='"+date+"' and (train_id="+SID+" or train_id="+DID+")");
                            System.out.println("if 2 sub if");
                            return ac_ct;
                    }
                    else{
                            int s= sl_ct-Integer.parseInt(sc.getNoPassg());
                            st.executeUpdate("update Availability set seats_in_sleeper="+s+" where date='"+date+"' and (train_id="+SID+" or train_id="+DID+")");
                             System.out.println("if2 sub else");
                             return sl_ct;
                        }
                }
                else if(DID-SID==2&&(trid==DID||trid==SID||trid==SID+1)&&date.equals(sc.getDate())){
                    int sid1=SID+1;
                    if(sc.getCoach().equals("AC")){
                           int s= ac_ct-Integer.parseInt(sc.getNoPassg());
                           st.executeUpdate("update Availability set seats_in_ac="+s+" where date='"+date+"' and (train_id="+SID+" or train_id="+DID+" or train_id="+sid1+")");
                            System.out.println("if3 sub if");
                            return ac_ct;
                    }
                    else{
                            int s= sl_ct-Integer.parseInt(sc.getNoPassg());
                            st.executeUpdate("update Availability set seats_in_sleeper="+s+" where date='"+date+"' and (train_id="+SID+" or train_id="+DID+" or train_id="+sid1+")");
                             System.out.println("if3 sub else");
                              return sl_ct;
                        }
                }
                   
                }
         
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    public static void main(String[] args) {    
        
    } 
}
