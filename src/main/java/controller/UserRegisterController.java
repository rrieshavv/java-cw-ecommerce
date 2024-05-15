package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.UserDao;
import utils.PageURL;

/**
 * Servlet implementation class UserRegisterController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/register" })
public class UserRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserRegisterController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(PageURL.REGISTER.getUrl()).forward(request, response); // forward the request and response to register page
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User(); // creating instance user object 
		UserDao userM = new UserDao(); // creating instance of userDao 
		String password = request.getParameter("Password"); // getting data from frontend !!! by using name
		String conformpassword = request.getParameter("confirmPassword");//''''

		// checking password and conform password are same or not
		if (!password.equals(conformpassword)) {
			request.setAttribute("error", "password not match");
			doGet(request, response);
			// this condtion is use for password verification
		}

		else {

			try {
				// setting parameters to user object (User)
				user.setFirstname(request.getParameter("Firstname"));
				user.setLastname(request.getParameter("Lastname"));
				user.setNumber(request.getParameter("Number"));
				user.setUsername(request.getParameter("Username"));
				user.setEmail(request.getParameter("Email"));
				user.setAddress(request.getParameter("Address"));
				user.setGender(request.getParameter("Gender"));
				user.setDob(request.getParameter("Date"));
				user.setPassword(request.getParameter("Password"));
				userM.addUser(user);
				// display success message if register successful
				request.setAttribute("success", "User registered successfully");
				// calling do get method
				doGet(request, response);
			} catch (SQLIntegrityConstraintViolationException e) {// this execption occure when  Volitation occure in database constraint
				String errorMessage = e.getMessage();
				int startindeXField = errorMessage.indexOf("users.") + "users.".length(); // taking out text from error message from exception

				int endIndexField = errorMessage.indexOf("'", startindeXField);
				String duplicateEntryField = errorMessage.substring(startindeXField, endIndexField);// taking starting and ending index from error message
				request.setAttribute("error", duplicateEntryField + " already existe choose another ");
				doGet(request, response);

			}

			catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute("error", "something went wrong please try again later");
				doGet(request, response);

			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("error", "some thing went wrong try again");
				doGet(request, response);
			}

		}

	}

}
