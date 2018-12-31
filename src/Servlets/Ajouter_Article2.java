package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;

import Bean.Article;
import Bean.Vendeur;
import Modele.ModeleArticle;

/**
 * Servlet implementation class ajoutArticleCorrect
 */
@WebServlet("/ajoutArticleCorrect")
public class Ajouter_Article2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajouter_Article2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/vues/Gestion_Articles.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			String libelle=(String) request.getParameter("libelle");
			double prix=Double.parseDouble(request.getParameter("prix"));
			String descriptif=(String) request.getParameter("descriptif");
			String nomImage="";
			Vendeur vendeur = (Vendeur)session.getAttribute("vendeur");
			ModeleArticle modeleArticle = new ModeleArticle();
			String msg=modeleArticle.create(libelle, prix, descriptif,nomImage,vendeur);
			switch(msg) {
			case "-2" : 
				request.setAttribute("msg", "Le libelle est vide.");
				this.getServletContext().getRequestDispatcher("/vues/Gestion_Articles.jsp").forward(request, response);
			break;	
			case "1" :
				List<Article> listArticles = modeleArticle.findArticlesByVendeur(vendeur);
				request.setAttribute("msg", "L'article a bien été ajouté.");
				session.setAttribute("listArticles", listArticles);
				request.setAttribute("listArticles", listArticles);
				this.getServletContext().getRequestDispatcher("/vues/Gestion_Articles.jsp").forward(request, response);
				break;
				default : 
					request.setAttribute("msg", msg);
					this.getServletContext().getRequestDispatcher("/vues/Gestion_Articles.jsp").forward(request, response);
				break;
			}
		}catch(Exception ex) {
			request.setAttribute("msg", "Le prix doit être un nombre.");
			this.getServletContext().getRequestDispatcher("/vues/Gestion_Articles.jsp").forward(request, response);
		}
	}

}
