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
import Bean.Commande;

import Modele.ModeleCommande;


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
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		int id =Integer.parseInt( request.getParameter("index"));
		ModeleCommande modeleCommande = new ModeleCommande();
		try {
			modeleCommande.updateTraite(id);
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
