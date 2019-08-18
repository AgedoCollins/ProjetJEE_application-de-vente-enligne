package Servlets;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.json.JSONException;

import Bean.Article;
import Bean.Client;
import Bean.Commande;
import Bean.Panier;

/**
 * Servlet implementation class Passer_Commande
 */
@WebServlet("/Passer_Commande")
public class Passer_Commande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Passer_Commande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Panier panier = (Panier) session.getAttribute("panier");
		Client client = (Client)session.getAttribute("client");
		Commande commande = new Commande();
		@SuppressWarnings("unused")
		String msg = new String();
		double prixTotale;
		
		/*java.util.Date date = new java.util.Date();
		Date laDate = new Date(date.getTime());
		String laDateString = laDate.toString();
		String laDateStringCorrige = "\"" + laDateString + "\"";*/
		String matrice = "dd/MM/yyyy";
		Instant laDate = Instant.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern(matrice);
		ZoneId fuseau = ZoneId.systemDefault();
		ZonedDateTime dateSurFuseau = laDate.atZone(fuseau);
		String date = format.format(dateSurFuseau);
		Commande comma = new Commande();
		comma.setDateCommande(date);
		comma.setPrixTotale(Double.parseDouble(request.getParameter("hidden_prixTotale")));
		//JOptionPane.showMessageDialog(null, comma.getPrixTotale());
		msg = panier.payer(comma, client);

		ArrayList<Integer> listQuantites = new ArrayList<>();
		for(int i=0;i<panier.getListArticles().size();i++)
		{
			listQuantites.add(Integer.parseInt(request.getParameter("quantite" + i)));
		}
		
		Iterator<Integer> it = listQuantites.iterator();
		try {
			int lastId = commande.findLastId();
			for(Article article : panier.getListArticles())
			{
				
				commande.setId(lastId);
				commande.createLigneCommande(commande, article,it.next());
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(panier.getListArticles().size()!=0)
		{
			panier.getListArticles().clear();
		}
		request.setAttribute("msg", "La commande a bien été passée.");
		this.getServletContext().getRequestDispatcher("/vues/Gestion_Catalogue.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
