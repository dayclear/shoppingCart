package userServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import dao.PhonesDAO;
import vo.PhoneVO;

public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String text=request.getParameter("text");
		PhonesDAO dao=new PhonesDAO();
	    List<PhoneVO> list=new ArrayList<PhoneVO>();
	    list=dao.getPhonesByName(text);
	    HttpSession session=request.getSession();
	    if(list.size()>0){
	    	session.setAttribute("list",list);
	    }else{
	    	session.removeAttribute("list");
	    }
		PrintWriter writer=response.getWriter();
		response.setContentType("application/json");
		JSONObject res=new JSONObject();
		try {
			res.put("result", true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.write(res.toString());
		writer.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
