package com.maitq2.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maitq2.web.dao.UserDao;
import com.maitq2.web.model.User;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	UserDao userDao = new UserDao();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getServletPath();
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				 insertUser(request, response);
				 break;
			case "/delete":
				 deleteUser(request, response);
				 break;
			case "/edit":
				 editUser(request, response);
				 break;
			case "/update":
				updateUser(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {

		request.setCharacterEncoding("UTF-8"); //Cái này dùng để có thể input được tiếng Việt
		int id = Integer.parseInt(request.getParameter("id"));
		String nameString = request.getParameter("name");
		String emailString = request.getParameter("email");
		String countString = request.getParameter("country");
		
		userDao.updateUser(id, nameString, emailString, countString);
		response.sendRedirect("list");
		
	}

	private void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		int idString = Integer.parseInt(request.getParameter("id"));
		User user = userDao.getUser(idString);
		request.setAttribute("book", user);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("userForm.jsp");
		requestDispatcher.forward(request, response);
	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {

		request.setCharacterEncoding("UTF-8");
		String nameString = request.getParameter("name");
		String emailString = request.getParameter("email");
		String countryString = request.getParameter("country");
		
		userDao.insertUser(nameString, emailString, countryString);
		response.sendRedirect("list");
		
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {

		int id = Integer.parseInt(request.getParameter("id"));
		userDao.deleteUser(id);
		response.sendRedirect("list");
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("userForm.jsp");
		requestDispatcher.forward(request, response);
		
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

		List<User> listAllUser = userDao.listAllUser();
		request.setAttribute("listAllUser", listAllUser);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("showUser.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
