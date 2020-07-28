package com.firstapp.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstapp.todo.TodoService;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

		private LoginService uservalidation=new LoginService();
		private TodoService todoservice=new TodoService();
		protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}
		protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			String name=request.getParameter("name");
			String password=request.getParameter("password");
			
			boolean isUservalid=uservalidation.isUservalid(name, password);
			
			if(isUservalid) {
				request.getSession().setAttribute("name", name);
			response.sendRedirect("/list-todos.do");
			}
			else {
				request.setAttribute("errorMessage", "InvalidCredentials");
				request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
			}
		}
}
