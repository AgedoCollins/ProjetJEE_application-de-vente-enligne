package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import Bean.Article;
import Bean.Commande;

/**
 * Servlet implementation class Traiter_Commande
 */
@WebServlet("/Traiter_Commande")
public class Traiter_Commande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Traiter_Commande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Article article = new Article();
		
		
		article.setId(Integer.parseInt( request.getParameter("index_article")));
		article.setId_commande(Integer.parseInt( request.getParameter("index_commande")));
		Commande commande = new Commande();
		try {
			commande.updateTraite(article);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("msg", "L'article a bien été traitée.");
		this.getServletContext().getRequestDispatcher("/vues/Gestion_Commandes_Vendeur.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
