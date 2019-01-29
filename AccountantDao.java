package feeReport;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountantDao {
	public static Connection getCon(){
		Connection con=null;
		try{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/deepak","root","Dee@1999");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	public static boolean validate(String name,String password){
		boolean status=false;
		try{
			Connection con=getCon();
			PreparedStatement ps=con.prepareStatement("select * from feereport_accountant where name=? and password=?");
			ps.setString(1,name);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		
		
		return status;
	}
	public static int save(Accountant a){
		int status=0;
		try{
			Connection con=getCon();
			PreparedStatement ps=con.prepareStatement("insert into feereport_accountant(name,password,email,contactno) values(?,?,?,?)");
			ps.setString(1,a.getName());
			ps.setString(2,a.getPassword());
			ps.setString(3,a.getEmail());
			ps.setString(4,a.getContactno());
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static void view(){
		try{
			Connection con=getCon();
			PreparedStatement ps=con.prepareStatement("select * from feereport_accountant");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Accountant a=new Accountant();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));

				a.setPassword(rs.getString(3));
				a.setEmail(rs.getString(4));
			
				
				a.setContactno(rs.getString(5));
				System.out.println(a);
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
	}

	public static boolean delete(String name){
		boolean status=false;
		try{
			Connection con=getCon();
			PreparedStatement ps=con.prepareStatement("DELETE FROM feereport_accountant WHERE name=?");
			ps.setString(1,name);
			ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		
		
		return status;
	}






}
