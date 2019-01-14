package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Article;
import Bean.Panier;

/**
 * Servlet implementation class SupprimerArticleFromPanier
 */
@WebServlet("/SupprimerArticleFromPanier")
public class SupprimerArticleFromPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SupprimerArticleFromPanier() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Panier panier = (Panier) session.getAttribute("panier");
		int id_article = Integer.parseInt(request.getParameter("id_article"));

		List<Article> listArticles = new ArrayList<>();

		listArticles = panier.getListArticles();
		
		listArticles.remove(id_article);
		request.setAttribute("listArticlesPanier", listArticles);
		session.setAttribute("listArticlesPanier", listArticles);

		this.getServletContext().getRequestDispatcher("/vues/Consulter_Panier.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
