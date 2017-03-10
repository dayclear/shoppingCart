package cartServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import dao.PhonesDAO;
import vo.PhoneVO;


public class AddInCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddInCart() {
        super();
    }

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		PhonesDAO phoneDao=new PhonesDAO();
		PhoneVO vo=phoneDao.getPhonesById(id);
		
		PrintWriter writer=response.getWriter();
		response.setContentType("application/json");
		JSONObject res=new JSONObject();
		
		if(vo!=null){
			vo.setNum(1);
			Map<Integer,PhoneVO> phoneMap=new HashMap<Integer,PhoneVO>();
			HttpSession session=request.getSession();
			if(session.getAttribute("SHOPPING_CART")!=null){
				phoneMap=(Map<Integer,PhoneVO>)session.getAttribute("SHOPPING_CART");
				if(phoneMap.containsKey(id)){
					vo=phoneMap.get(id);
					vo.setNum(vo.getNum()+1);
				}
			}
			phoneMap.put(id, vo);
			session.setAttribute("SHOPPING_CART", phoneMap);
			
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
