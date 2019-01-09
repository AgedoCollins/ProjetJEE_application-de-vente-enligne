package Servlets;

import java.io.IOException;
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

/**
 * Servlet implementation class Ajouter_Article_Panier
 */
@WebServlet("/Ajouter_Article_Panier")
public class Ajouter_Article_Panier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajouter_Article_Panier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		Article article = null;
		HttpSession session = request.getSession();
		Panier panier = (Panier) session.getAttribute("panier");
		Article art = new Article();
		
		try {
			article = art.findArticle(id);
		} catch (JSONException | JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//Panier panier;
		if(panier.getListArticles().size()==0)
		{
			panier = new Panier();
			
		}
			//panier.setListArticles(listArticles);
			panier.ajouterArticle(article);
		
		
		request.setAttribute("panier", panier);
		session.setAttribute("panier", panier);
		/*request.setAttribute("article", article);
		session.setAttribute("article", article);*/
		request.setAttribute("msg", "Cet article a bien été ajouté au panier.");
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
