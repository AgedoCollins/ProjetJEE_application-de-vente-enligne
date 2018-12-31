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
import Modele.ModeleArticle;

/**
 * Servlet implementation class Ajouter_Article
 */
@WebServlet("/Ajouter_Article")
public class Ajouter_Article extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajouter_Article() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/vues/Ajouter_Article.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*	HttpSession session = request.getSession();
		try {
			String libelle=(String) request.getParameter("libelle");
			double prix=Double.parseDouble(request.getParameter("prix"));
			String descriptif=(String) request.getParameter("descriptif");
			String nomImage="";
			ModeleArticle modeleArticle = new ModeleArticle();
			String msg=modeleArticle.create(libelle, prix, descriptif,nomImage);
			switch(msg) {
			case "-2" : 
				request.setAttribute("msg", "Le libelle est vide.");
				this.getServletContext().getRequestDispatcher("/vues/Gestion_Articles.jsp").forward(request, response);
			break;	
			case "1" :
				List<Article> listArticles = modeleArticle.findAll();
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
			request.setAttribute("msg", "Vérifier le prix");
			this.getServletContext().getRequestDispatcher("/vues/Gestion_Articles.jsp").forward(request, response);
		}*/
	}
}
