package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrdersController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/OrdersController" })
public class OrdersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		for(int i=0; i<20; i++) {
			String stocks = request.getParameter("stocks[" + i + "]");
            String title = request.getParameter("title_" + i);
            String product = request.getParameter("product_" + i);
            String totalPrice = request.getParameter("total_" + i);
            if(stocks==null) {
            	break;
            }
            
   		 	System.out.println("Product " + (i + 1) + " - Stocks: " + stocks + ", Title: " + title + ", Product ID: " + product + "" +" Total Price"+ totalPrice);

		}
        
		doGet(request, response);
	}

}
