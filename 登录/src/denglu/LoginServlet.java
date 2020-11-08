package denglu;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName=req.getParameter("userName");
        
        String password=req.getParameter("password");
        
        DbUtil db= new DbUtil();
        user user=new user(userName,password);
        DAO dao=new DAO();
        try {
            Connection con=db.getCon();
            
            if(dao.login(con, user)!=null) {
                resp.sendRedirect("ok.jsp");
            }else {
                resp.sendRedirect("register.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}