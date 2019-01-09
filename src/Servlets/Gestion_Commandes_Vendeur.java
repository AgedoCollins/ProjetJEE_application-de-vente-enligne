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

import Bean.Article;
import Bean.Commande;
import Bean.Vendeur;

/**
 * Servlet implementation class Gestion_Commandes
 */
@WebServlet("/Gestion_Commandes")
public class Gestion_Commandes_Vendeur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Gestion_Commandes_Vendeur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Vendeur vendeur = (Vendeur)session.getAttribute("vendeur");
		Commande commande = new Commande();
		List<Article> listArticles = new ArrayList<>();
		try {
			listArticles = commande.findAll(vendeur);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			request.setAttribute("msg", "Il n'y a pas de commande.");
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
