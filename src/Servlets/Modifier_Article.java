package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Article;

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
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<Article> listArticle = (List<Article>)session.getAttribute("listArticles");
		int index =Integer.parseInt((String) request.getParameter("index"));
		Article article = listArticle.get(index);
		session.setAttribute("id", article.getId());
		session.setAttribute("libelle", article.getLibelle());
		session.setAttribute("prix", article.getPrix());
		session.setAttribute("descriptif", article.getDescriptif());
		this.getServletContext().getRequestDispatcher("/vues/Modifier_Article.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
