package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Client;
import Bean.Commande;
import Modele.ModeleClient;
import Modele.ModeleCommande;

/**
 * Servlet implementation class Gestion_Commandes_Client
 */
@WebServlet("/Gestion_Commandes_Client")
public class Gestion_Commandes_Client extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Gestion_Commandes_Client() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Client client = (Client)session.getAttribute("client");
		ModeleClient modeleClient = new ModeleClient();
		ModeleCommande modeleCommande = new ModeleCommande();
		List<Commande> listCommandes = modeleClient.findCommandesClient(client);
		/*try {
			listArticles = modeleVendeur.findArticleByVendeur(vendeur);
		} catch (JSONException e) {
			e.printStackTrace();
		}*/
		
		request.setAttribute("listCommandes", listCommandes);
		session.setAttribute("listCommandes", listCommandes);
		
		if(listCommandes.size()>0)
			this.getServletContext().getRequestDispatcher("/vues/Gestion_Commandes_Client.jsp").forward(request, response);
		else
			request.setAttribute("msg", "Vous n'avez pas de commande.");
			this.getServletContext().getRequestDispatcher("/vues/Gestion_Commandes_Client.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
