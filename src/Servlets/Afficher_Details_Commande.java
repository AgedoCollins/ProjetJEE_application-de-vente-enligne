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

/**
 * Servlet implementation class Afficher_Details_Commande
 */
@WebServlet("/Afficher_Details_Commande")
public class Afficher_Details_Commande extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Afficher_Details_Commande() {
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
		List<Commande> listCommandes = (List<Commande>) session.getAttribute("listCommandes");
		int index = Integer.parseInt((String) request.getParameter("index"));
		Commande commande = listCommandes.get(index);

		Commande comm = new Commande();
		List<Article> listArticles = new ArrayList<>();
		try {
			listArticles = comm.findArticlesByCommande(commande);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		double prixTotal = 0.0;

		for (Article article : listArticles) {
			
			prixTotal += article.getPrix();
		}

		request.setAttribute("listArticles", listArticles);
		session.setAttribute("listArticles", listArticles);
		session.setAttribute("path_image", getServletContext().getInitParameter("path_image"));
		if (listArticles.size() > 0) {
			request.setAttribute("msg", "");
			request.setAttribute("prixTotal", prixTotal);

		} else {
			request.setAttribute("msg", "Cette commande ne contient aucun article.");
			request.setAttribute("prixTotal", "");
		}
		this.getServletContext().getRequestDispatcher("/vues/Afficher_Details_Commande.jsp").forward(request, response);
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
