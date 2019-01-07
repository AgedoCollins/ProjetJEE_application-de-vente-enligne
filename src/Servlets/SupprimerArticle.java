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
import Bean.Vendeur;
import Modele.ModeleArticle;

/**
 * Servlet implementation class SupprimerArticle
 */
@WebServlet("/SupprimerArticle")
public class SupprimerArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			@SuppressWarnings("unchecked")
			List<Article> listArticle = (List<Article>)session.getAttribute("listArticles");
			int index =Integer.parseInt((String) request.getParameter("index"));
			Article article = listArticle.get(index);
			ModeleArticle modeleArticle = new ModeleArticle();
			Vendeur vendeur = (Vendeur)session.getAttribute("vendeur");
			if(modeleArticle.delete(article)) {
				request.setAttribute("msg", "L'article a bien été supprimé.");
				/*Vendeur vendeur = (Vendeur)session.getAttribute("vendeur");
				ModeleVendeur modeleVendeur = new ModeleVendeur();
				List<Article> listArticles = modeleVendeur.findArticleVendeur(vendeur);*/
				List<Article> listArticles = modeleArticle.findArticlesByVendeur(vendeur);
				request.setAttribute("listArticles", listArticles);
				session.setAttribute("listArticles", listArticles);
				/*if(listArticles.size()>0)
					request.setAttribute("msg", "");
				else
					request.setAttribute("msg",index+"");*/
				this.getServletContext().getRequestDispatcher("/vues/Gestion_Articles.jsp").forward(request, response);
			}
			else {
				request.setAttribute("msg", " L'article " + index + " n'a pas été supprimé.");
				this.getServletContext().getRequestDispatcher("/vues/Gestion_Articles.jsp").forward(request, response);
			}
		}catch(Exception ex) {}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
