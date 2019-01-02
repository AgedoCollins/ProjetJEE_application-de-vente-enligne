package Servlets;

import java.io.IOException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import Modele.ModeleClient;
import Modele.ModeleVendeur;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Inscription() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/vues\\Inscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nom = (String) request.getParameter("nom");
		String prenom = (String) request.getParameter("prenom");
		String dateNaissance = (String) request.getParameter("dateNaissance");
		String telephone = (String) request.getParameter("telephone");
		String email = (String) request.getParameter("email");
		String password = (String) request.getParameter("password");
		String confirmerPassword = (String) request.getParameter("confirmerPassword");
		String utilisateur = (String) request.getParameter("utilisateur");
		String msg = "";
		
		HttpSession session = request.getSession();
		session.setAttribute("nom", nom);
		session.setAttribute("prenom", prenom);
		session.setAttribute("dateNaissance", dateNaissance);
		session.setAttribute("telephone", telephone);
		session.setAttribute("email", email);
		session.setAttribute("password", password);
		session.setAttribute("confirmerPassword", confirmerPassword);
		
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		
		if (utilisateur != null) {
		if(nom.equals("") || prenom.equals("") || dateNaissance.equals("") || telephone.equals("") || email.equals("") || password.equals("") || confirmerPassword.equals(""))
		{
			request.setAttribute("msg", "Tous les champs (*) sont obligatoires.");
			this.getServletContext().getRequestDispatcher("/vues/Inscription.jsp").forward(request,
					response);
		}
		
		else if (!(matcher.matches())) {
			request.setAttribute("msg", "Veuillez entrer un email valide.");
			this.getServletContext().getRequestDispatcher("/vues/Inscription.jsp").forward(request,
					response);
		}
		
		else if (!password.equals(confirmerPassword)) {
			request.setAttribute("msg", "Les mots de passes doivent être identiques.");
			this.getServletContext().getRequestDispatcher("/vues/Inscription.jsp").forward(request,
					response);
		}
		
		if (utilisateur.compareTo("client") == 0) {
			ModeleClient modele_Client = new ModeleClient();
			msg = modele_Client.create(nom, prenom, dateNaissance, telephone, email, password);
			this.getServletContext().getRequestDispatcher("/Connexion.jsp").forward(request,
					response);
		} else {
			ModeleVendeur modele_Vendeur = new ModeleVendeur();
			msg = modele_Vendeur.create(nom, prenom, dateNaissance, telephone, email, password);
			this.getServletContext().getRequestDispatcher("/Connexion.jsp").forward(request,
					response);
		}
			
		
			/*switch (msg) {

			case "1": // inscription reussie
				request.setAttribute("nouveauUtilisateur", "compte crée...");
				this.getServletContext().getRequestDispatcher("/vues/Dashboard_Client.jsp").forward(request,
						response);
				break;
			case "0": // le compte existe deja
				request.setAttribute("msg", "le compte existe deja");
				this.getServletContext().getRequestDispatcher("/vues/Dashboard_Client.jsp").forward(request,
						response);
				break;
			case "-2":// informations manquantes
				request.setAttribute("msg", "Tous les champs (*) sont obligatoires");
				this.getServletContext().getRequestDispatcher("/vues/Inscription.jsp").forward(request,
						response);
				break;
			default: // autres problemes
				request.setAttribute("msg", msg);
				this.getServletContext().getRequestDispatcher("/vues/Inscription.jsp").forward(request,
						response);
			}*/

		} else {
			request.setAttribute("msg", "Veuillez sélectionner un type d'utilisateur");
			this.getServletContext().getRequestDispatcher("/vues/Inscription.jsp").forward(request, response);
		}

	}

}
