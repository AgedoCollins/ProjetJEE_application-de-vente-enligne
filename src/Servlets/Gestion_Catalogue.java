package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;

import Bean.Article;
import Bean.Catalogue;

/**
 * Servlet implementation class Gestion_Catalogue
 */
@WebServlet("/Gestion_Catalogue")
public class Gestion_Catalogue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Gestion_Catalogue() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Article article = new Article();
		Catalogue listArticles = new Catalogue();
		try {
			
			listArticles.setListArticles(article.findAll());
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*try {
			listArticles = modeleVendeur.findArticleByVendeur(vendeur);
		} catch (JSONException e) {
			e.printStackTrace();
		}*/
		request.setAttribute("listArticles", listArticles);
		session.setAttribute("listArticles", listArticles);
		if(listArticles.getListArticles().size()>0)
			request.setAttribute("msg", "");
		else
			request.setAttribute("msg", "Le catalogue ne comporte aucun article.");
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
