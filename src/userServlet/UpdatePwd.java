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

public class UpdatePwd extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdatePwd() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pwd=request.getParameter("pwd");
		String newPwd=request.getParameter("newPwd");
		
		HttpSession session=request.getSession();
		UserVO vo=(UserVO)session.getAttribute("SHOPPING_USER");
		String user=vo.getUser();
		
		PrintWriter writer=response.getWriter();
		response.setContentType("application/json");
		JSONObject res=new JSONObject();
		
		if(vo.getPwd().equals(pwd)){
			UserVO newVO=new UserVO(user,newPwd);
			UserDAO dao=new UserDAO();
			boolean b=dao.update(newVO);
			if(b==true){
				try {
					res.put("result", true);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
