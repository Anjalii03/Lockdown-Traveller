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
            String sql = "select source,train_id,train_no,departure from TrainStatus";
            ResultSet rs = st.executeQuery(sql);
            boolean flag=false;
            while(rs.next()) {
                String datasource = rs.getString("source");
                String s_id = String.valueOf(rs.getInt("train_id"));
                String s_no = String.valueOf(rs.getInt("train_no"));
                String departure = rs.getString("departure");
                if(datasource.equals(t.getSource()))
                {
                    String sq = "select destination,train_id,train_no,arrival from TrainStatus";
                    ResultSet r = st.executeQuery(sq);
                    while(r.next())
                    {
                        String datadestination = r.getString("destination");
                        String d_id = String.valueOf(r.getInt("train_id"));
                        String d_no = String.valueOf(r.getInt("train_no"));
                        String arrival = r.getString("arrival");
                        
                        if(datadestination.equals(t.getDestination()) && s_no.equals(d_no) && (s_id.compareTo(d_id) <= 0))
                        {
                            System.out.println("found in db "+datasource+" "+datadestination);
                            flag=true;
                              ArrayList<String> list=new ArrayList<String>(); 
                              list.add(s_no);
                              list.add(datasource);
                              list.add(datadestination);
                              list.add(departure);
                              list.add(arrival);
                           
                            String sql1="select seats_in_ac,seats_in_sleeper from availability where train_id ='"+d_id+"' and date='"+t.getDate()+"'";
                            ResultSet r1 = st.executeQuery(sql1);
                            while(r1.next()){
                                String seats_ac=String.valueOf(r1.getInt("seats_in_ac"));
                                String seats_sl=String.valueOf(r1.getInt("seats_in_sleeper"));
                                list.add(seats_ac);
                                list.add(seats_sl);
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
    public static void main(String[] args) {    
        
    } 
}
