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

/**
 * Servlet implementation class ModifCli
 */
@WebServlet("/modifcli")
public class ModifCli extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifCli() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/vues/ModifierProfilClient.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String DateNaissance = request.getParameter("dateNaissance");
		String Password= request.getParameter("password");
		String ConfirmerPassword = (String) request.getParameter("confirmerPassword");
		String Email = request.getParameter("email");
		String Nom = request.getParameter("nom");
		String Prenom = request.getParameter("prenom");
		String Telephone = request.getParameter("telephone");
		Client cli = (Client) session.getAttribute("client");
		int id = cli.getId();
		try {
		}
		catch (Exception err) {
		    request.setAttribute("msg","Format de date incorrect");
			this.getServletContext().getRequestDispatcher("/vues/ModifierProfilClient.jsp").forward(request, response);
			
		}
		
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(Email);
		
		if(!DateNaissance.equals("") && !Password.equals("") && !Email.equals("") && !Nom.equals("") && !Prenom.equals("") && !Telephone.equals("") && !ConfirmerPassword.equals("") && id > 0) 
		{
			if (!(matcher.matches())) {
				request.setAttribute("msg", "Veuillez entrer un email valide.");
				this.getServletContext().getRequestDispatcher("/vues/ModifierProfilClient.jsp").forward(request, response);
			}
			if (!Password.equals(ConfirmerPassword)) {
				request.setAttribute("msg", "Les mots de passes doivent être identiques.");
				this.getServletContext().getRequestDispatcher("/vues/ModifierProfilClient.jsp").forward(request, response);
			}
			Client c = new Client();
			Client client = new Client();
			client.setNom(Nom);
			client.setPrenom(Prenom);
			client.setDateNaissance(DateNaissance);
			client.setTelephone(Telephone);
			client.setEmail(Email);
			client.setPassword(Password);
			client.setId(id);
			session.setAttribute("client", client);
			try {
				if(client.alreadyExist(client))
				{
					request.setAttribute("msg", "Cet adresse e-mail existe déjà.");
					this.getServletContext().getRequestDispatcher("/vues/ModifierProfilClient.jsp").forward(request, response);
				}
				else
				{
					c.update(Nom, Prenom, DateNaissance, Telephone, Email, Password, id);
					request.setAttribute("msg", "Modifications effectuées");
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			this.getServletContext().getRequestDispatcher("/vues/Accueil_Client.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("msg","Les champs (*) sont obligatoires");
			this.getServletContext().getRequestDispatcher("/vues/ModifierProfilClient.jsp").forward(request, response);
		}
		
		
	}

}