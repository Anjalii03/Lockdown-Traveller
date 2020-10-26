package Server;
/*
*
* PRIYANSHI DIXIT
*
*/
import java.sql.*;
import Client.*;
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
    public static void main(String[] args) {    
        
    } 
}
