package cartServlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.PhoneVO;

/**
 * 修改数量
 */
public class UpdatePhoneNum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdatePhoneNum() {
        super();
    }

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		int num=Integer.parseInt(request.getParameter("num"));
		Map<Integer,PhoneVO> phones=new HashMap<Integer,PhoneVO>();
		HttpSession session=request.getSession();
		if(session.getAttribute("SHOPPING_CART")!=null){
			phones=(Map<Integer,PhoneVO>)session.getAttribute("SHOPPING_CART");
			if(phones.containsKey(id)){
				PhoneVO p=phones.get(id);
				p.setNum(num);
				phones.put(id,p);
				session.setAttribute("SHOPPING_CART",phones);
			}
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
