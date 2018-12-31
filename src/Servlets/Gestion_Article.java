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

import org.json.JSONException;

import Bean.Vendeur;
import Bean.Article;
import Modele.ModeleArticle;
import Modele.ModeleVendeur;



/**
 * Servlet implementation class Article
 */
@WebServlet("/Article")
public class Gestion_Article extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Gestion_Article() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Vendeur vendeur = (Vendeur)session.getAttribute("vendeur");
		ModeleVendeur modeleVendeur = new ModeleVendeur();
		ModeleArticle modeleArticle = new ModeleArticle();
		List<Article> listArticles = new ArrayList<>();
		try {
			listArticles = modeleArticle.findArticlesByVendeur(vendeur);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*try {
			listArticles = modeleVendeur.findArticleByVendeur(vendeur);
		} catch (JSONException e) {
			e.printStackTrace();
		}*/
		request.setAttribute("listArticles", listArticles);
		session.setAttribute("listArticles", listArticles);
		if(listArticles.size()>0)
			request.setAttribute("msg", "");
		else
			request.setAttribute("msg", "Vous n'avez pas d'article.");
		this.getServletContext().getRequestDispatcher("/vues/Gestion_Articles.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
