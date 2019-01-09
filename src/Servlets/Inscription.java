package Servlets;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;

import Bean.Client;
import Bean.Vendeur;

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
		String dateNaissance = request.getParameter("dateNaissance");
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
		String regex2 = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
		Pattern pattern = Pattern.compile(regex);
		Pattern pattern2 = Pattern.compile(regex2);
		Matcher matcher = pattern.matcher(email);
		Matcher matcher2 = pattern2.matcher(dateNaissance);

		if (utilisateur != null) {
			if (nom.equals("") || prenom.equals("") || dateNaissance.equals("") || telephone.equals("")
					|| email.equals("") || password.equals("") || confirmerPassword.equals("")) {
				request.setAttribute("msg", "Tous les champs (*) sont obligatoires.");
				this.getServletContext().getRequestDispatcher("/vues/Inscription.jsp").forward(request, response);
			}

			else if (!(matcher.matches())) {
				request.setAttribute("msg", "Veuillez entrer un email valide.");
				this.getServletContext().getRequestDispatcher("/vues/Inscription.jsp").forward(request, response);
			}

			else if (!password.equals(confirmerPassword)) {
				request.setAttribute("msg", "Les mots de passes doivent être identiques.");
				this.getServletContext().getRequestDispatcher("/vues/Inscription.jsp").forward(request, response);
			}

			else if (!(matcher2.matches())) {
				request.setAttribute("msg", "Format de date \"dd/MM/YY\" attendu.");
				this.getServletContext().getRequestDispatcher("/vues/Inscription.jsp").forward(request, response);
			}

			if (utilisateur.compareTo("client") == 0) {
				Client client = new Client();
				client.setNom(nom);
				client.setPrenom(prenom);
				client.setDateNaissance(dateNaissance);
				client.setTelephone(telephone);
				client.setEmail(email);
				client.setPassword(password);
				try {
					if(client.alreadyExist(client, email))
					{
						request.setAttribute("msg", "Cette adresse e-mail existe déjà.");
						this.getServletContext().getRequestDispatcher("/vues/Inscription.jsp").forward(request, response);
					}
					else
					{
						msg = client.create(client);
						this.getServletContext().getRequestDispatcher("/Connexion.jsp").forward(request, response);
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				Vendeur vendeur = new Vendeur();
				try {
					if(vendeur.alreadyExist(email))
					{
						request.setAttribute("msg", "Cette adresse e-mail existe déjà.");
						this.getServletContext().getRequestDispatcher("/vues/Inscription.jsp").forward(request, response);
					}
					else
					{
						msg = vendeur.create(nom, prenom, dateNaissance, telephone, email, password);
						this.getServletContext().getRequestDispatcher("/Connexion.jsp").forward(request, response);
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			/*
			 * switch (msg) {
			 * 
			 * case "1": // inscription reussie request.setAttribute("nouveauUtilisateur",
			 * "compte crée...");
			 * this.getServletContext().getRequestDispatcher("/vues/Dashboard_Client.jsp").
			 * forward(request, response); break; case "0": // le compte existe deja
			 * request.setAttribute("msg", "le compte existe deja");
			 * this.getServletContext().getRequestDispatcher("/vues/Dashboard_Client.jsp").
			 * forward(request, response); break; case "-2":// informations manquantes
			 * request.setAttribute("msg", "Tous les champs (*) sont obligatoires");
			 * this.getServletContext().getRequestDispatcher("/vues/Inscription.jsp").
			 * forward(request, response); break; default: // autres problemes
			 * request.setAttribute("msg", msg);
			 * this.getServletContext().getRequestDispatcher("/vues/Inscription.jsp").
			 * forward(request, response); }
			 */

		} else {
			request.setAttribute("msg", "Veuillez sélectionner un type d'utilisateur");
			this.getServletContext().getRequestDispatcher("/vues/Inscription.jsp").forward(request, response);
		}
	}

}
