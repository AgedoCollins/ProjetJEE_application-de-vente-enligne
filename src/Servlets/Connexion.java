package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBException;

import Bean.Client;
import Bean.Vendeur;
import Modele.ModeleClient;
import Modele.ModeleVendeur;

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
		
		session.setAttribute("email", email);
		session.setAttribute("password", password);
	
		if (email.equals("") || password.equals("")) {
			msg = "Veuillez entrer tous les champs.";
		} else {
			// Récuperer le client s'il existe dans la session
			Client client;
			try {
				ModeleClient modeleClient = new ModeleClient();
				client = modeleClient.findLogin(email, password);
				if (client == null) {
					ModeleVendeur modeleVendeur = new ModeleVendeur();
					Vendeur vendeur = null;
					vendeur = modeleVendeur.findLogin(email, password);
					if (vendeur == null)
					{
						msg = "Login et/ou mot de passe incorrect.";
					}
					else {
						session.setAttribute("vendeur", vendeur);
						this.getServletContext().getRequestDispatcher("/vues/Dashboard_Vendeur.jsp").forward(request,
								response);
					}
				} else {
					session.setAttribute("client", client);
					this.getServletContext().getRequestDispatcher("/vues/Dashboard_Client.jsp").forward(request,
							response);
				}
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("msg", msg);
		this.getServletContext().getRequestDispatcher("/Connexion.jsp").forward(request, response);
	}

}
