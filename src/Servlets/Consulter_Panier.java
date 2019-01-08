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
import javax.xml.bind.JAXBException;

import org.json.JSONException;

import Bean.Article;
import Bean.Panier;
import Modele.ModeleArticle;

/**
 * Servlet implementation class Consulter_Panier
 */
@WebServlet("/Consulter_Panier")
public class Consulter_Panier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Consulter_Panier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		Panier panier = (Panier) session.getAttribute("panier");
		/*int index =Integer.parseInt((String) request.getParameter("index"));
		Commande commande = listCommandes.get(index);*/
		/*session.setAttribute("id", commande.getId());
		session.setAttribute("dateCommande", commande.getDateCommande());
		session.setAttribute("etat", commande.getEtat());*/
		
		List<Article> listArticles = new ArrayList<>();
		//Commande commande = null;
		//Panier pan = new Panier();
		if(panier.getListArticles().size()!=0)
		{
			listArticles = panier.getListArticles();
			request.setAttribute("listArticlesPanier", listArticles);
			session.setAttribute("listArticlesPanier", listArticles);
		}
		
		double prixTotal = 0.0;
		for(Article article : panier.getListArticles())
		{
			prixTotal += article.getPrix();
		}
		
		if(panier.getListArticles().size()>0)
		{
			request.setAttribute("msg", "");
			request.setAttribute("prixTotal", prixTotal);
		}
		else
		{
			request.setAttribute("msg", "Votre panier est vide.");
			request.setAttribute("prixTotal", "");
		}
		this.getServletContext().getRequestDispatcher("/vues/Consulter_Panier.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
