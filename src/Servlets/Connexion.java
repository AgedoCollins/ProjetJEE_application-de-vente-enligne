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
import Bean.Client;
import Bean.Panier;
import Bean.Utilisateur;
import Bean.Vendeur;

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/Connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Connexion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/Connexion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = (String) request.getParameter("email");
		String password = (String) request.getParameter("password");
		String msg = "";
		HttpSession session = request.getSession();
		
		Utilisateur util;
		
		session.setAttribute("email", email);
		session.setAttribute("password", password);
	
		if (email.equals("") || password.equals("")) {
			msg = "Veuillez entrer tous les champs.";
		} else {
			// Récuperer le client s'il existe dans la session
			Client client;
			try {
				util = new Client();
				util.setEmail(email);
				util.setPassword(password);
				client = (Client) util.findLogin(util);
				if (client == null) {
					util = new Vendeur();
					util.setEmail(email);
					util.setPassword(password);
					Vendeur vendeur = null;
					vendeur = (Vendeur) util.findLogin(util);
					if (vendeur == null)
					{
						msg = "Login et/ou mot de passe incorrect.";
					}
					else {
						session.setAttribute("vendeur", vendeur);
						this.getServletContext().getRequestDispatcher("/vues/Accueil_Vendeur.jsp").forward(request,
								response);
					}
				} else {
					Panier panier = new Panier();
					panier.setListArticles(new ArrayList<Article>());
				    String filePath = getServletContext().getInitParameter("path_image");
					session.setAttribute("client", client);
					Article article = new Article();
					List<Article> listeArticles = article.findAll();
					session.setAttribute("path_image", filePath);
					session.setAttribute("listeArticles", listeArticles);
					session.setAttribute("panier", panier);
					request.setAttribute("listeArticles", listeArticles);
					this.getServletContext().getRequestDispatcher("/vues/Accueil_Client.jsp").forward(request,
							response);
				}
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("msg", msg);
		this.getServletContext().getRequestDispatcher("/Connexion.jsp").forward(request, response);
	}

}
