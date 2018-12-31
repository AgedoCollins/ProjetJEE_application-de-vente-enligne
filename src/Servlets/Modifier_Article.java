package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Vendeur;

/**
 * Servlet implementation class Modifier_Article
 */
@WebServlet("/Modifier_Article")
public class Modifier_Article extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Modifier_Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("id", request.getParameter("id"));
		this.getServletContext().getRequestDispatcher("/vues/Modifier_Article.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("id"));
		String libelle = (String) request.getParameter("libelle");
		double prix = Double.parseDouble(request.getParameter("prix"));
		String descriptif = (String) request.getParameter("descriptif");
		String nomImage = "";
		Vendeur vendeur = (Vendeur) session.getAttribute("vendeur");
		doGet(request, response);

	}
}
