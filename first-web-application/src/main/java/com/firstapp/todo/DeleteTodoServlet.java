package com.firstapp.todo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/delete-todo.do")
public class DeleteTodoServlet extends HttpServlet {
	 private TodoService todoservice=new TodoService();

	 protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		todoservice.deleteTodo(new Todo(request.getParameter("todo"), request.getParameter("category")));
		response.sendRedirect("/list-todos.do");	
	 }
	 
		
}
