package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;
import model.User;
import service.ProductDao;
import utils.PageURL;

/**
 * Servlet implementation class UserCartController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/user/cart" })
public class UserCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
 
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		try {
			
			
			int cartID=Integer.parseInt(request.getParameter("deleteCartID"));      
			ProductDao productDao = ProductDao.getInstance();
			productDao.deleteCartProduct(cartID);
			System.out.println("deleted");
		} catch (NumberFormatException e) {
			System.out.print("user have no cart items");
		}
		finally {
			
			ProductDao productDao = ProductDao.getInstance();

	HttpSession userS = request.getSession();
			User user = (User)userS.getAttribute("user");
			int userID = user.getuserId();
			
			try {
				List<Product>cartProduct=productDao.viewCart(userID);
				request.setAttribute("inCart", cartProduct);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
        request.getRequestDispatcher(PageURL.CART.getUrl()).forward(request, response);
	}


}
