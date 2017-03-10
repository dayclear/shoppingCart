package userServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import dao.UserDAO;
import vo.UserVO;

/**
 * 
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=request.getParameter("user");
		String pwd=request.getParameter("pwd");
		UserDAO userDao=new UserDAO();
		UserVO vo=new UserVO(user,pwd);
		boolean b=userDao.login(vo);
		
		//向前端返回数据*
		PrintWriter writer=response.getWriter();
		response.setContentType("application/json");
		JSONObject res=new JSONObject();
		
		if(b==true){
			HttpSession session=request.getSession();
			session.setAttribute("SHOPPING_USER", vo);
			try {
				res.put("result", true);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			try {
				res.put("result", false);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		writer.write(res.toString());
		writer.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
