package denglu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
 
public class DAO {
    public user login(Connection con,user user) throws Exception{
        user resultUser=null;
        String sql="select * from t_user where userName=? and password=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1, user.getUserName());
        pstmt.setString(2, user.getPassword());
        ResultSet rs=pstmt.executeQuery();
        if(rs.next()){
            resultUser=new user();
            resultUser.setUserName(rs.getString("userName"));
            resultUser.setPassword(rs.getString("password"));
        }
        return resultUser;
    }
    public boolean register(Connection con,user user) throws Exception{
        boolean flag=false;
        PreparedStatement pstmt = null;
        String sql="INSERT INTO t_user(userName,password)VALUES(?,?)";
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1, user.getUserName());
        pstmt.setString(2, user.getPassword());
        if (pstmt.executeUpdate() > 0) {
            flag = true;
        }
        return flag;
    }
}
 