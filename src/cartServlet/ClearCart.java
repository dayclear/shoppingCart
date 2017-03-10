package cartServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 清空购物车
 */
public class ClearCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ClearCart() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("SHOPPING_CART")!=null){
			System.out.println(session.getAttribute("SHOPPING_CART"));
			session.removeAttribute("SHOPPING_CART");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
