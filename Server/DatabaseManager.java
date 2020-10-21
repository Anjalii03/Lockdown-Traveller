package Server;
/*
*
* PRIYANSHI DIXIT
*
*/
import java.sql.*;

public class DatabaseManager {
	private static Connection con;
	private static Statement st;
    DatabaseManager(){
        try{ 
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("success");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3308/softablitz","root","");
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
	}
	catch(SQLException e) {
	System.out.println(e);
	}
    }
    public boolean Checklogin(String inputuspass) {
        try{
            String sql="Select username,password from user";      
            ResultSet rs = st.executeQuery(sql);
            boolean flag=false;
            while(rs.next()) {
                String userpass=rs.getString("username")+" "+rs.getString("password");
                if (userpass.equals(inputuspass)){  
                    System.out.println("found in db "+userpass);
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
