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
 * 删除物品
 */
public class DeletePhone extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeletePhone() {
        super();
    }

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		Map<Integer,PhoneVO> phones=new HashMap<Integer,PhoneVO>();
		HttpSession session=request.getSession();
		if(session.getAttribute("SHOPPING_CART")!=null){
			phones=(Map<Integer,PhoneVO>)session.getAttribute("SHOPPING_CART");
			if(phones.containsKey(id)){
				phones.remove(id);
				session.setAttribute("SHOPPING_CART",phones);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
