package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.Post;
import com.crud.Status;

import dao.PostDAOImpl;

public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		PostDAOImpl impl = new PostDAOImpl();
		Status s = new Status();
		try {
			Post post = impl.insert(new Post(0, request.getParameter("body"), request.getParameter("title")));
			// no exception means Query success !
			request.setAttribute("status", true);
			request.setAttribute("msg", "Post added successfully");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("status", false);
			request.setAttribute("msg", "Post couldn't be added");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}

	}

}
