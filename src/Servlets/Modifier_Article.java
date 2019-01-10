package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Article;
import Bean.Vendeur;

/**
 * Servlet implementation class Modifier_Article2
 */
@WebServlet("/Modifier_Article2")
public class Modifier_Article extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modifier_Article() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<Article> listArticle = (List<Article>)session.getAttribute("listArticles");
		int index =Integer.parseInt((String) request.getParameter("index"));
		Article article = listArticle.get(index);
		session.setAttribute("id", article.getId());
		session.setAttribute("libelle", article.getLibelle());
		session.setAttribute("prix", article.getPrix());
		session.setAttribute("descriptif", article.getDescriptif());
		this.getServletContext().getRequestDispatcher("/vues/Modifier_Article.jsp").forward(request, response);
		this.getServletContext().getRequestDispatcher("/vues/Modifier_Article.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			int id = (int) session.getAttribute("id");
			String libelle=(String) request.getParameter("libelle");
			double prix=Double.parseDouble(request.getParameter("prix"));
			String descriptif=(String) request.getParameter("descriptif");
			String nomImage="";
			Vendeur vendeur = (Vendeur)session.getAttribute("vendeur");
			Article article = new Article();
			article.setId(id);
			article.setLibelle(libelle);
			article.setPrix(prix);
			article.setDescriptif(descriptif);
			article.setNomImage(nomImage);
			String msg=article.update(article);
			switch(msg) {
			case "-2" : 
				request.setAttribute("msg", "Le libelle est vide.");
				this.getServletContext().getRequestDispatcher("/vues/Gestion_Articles.jsp").forward(request, response);
			break;	
			case "1" :
				List<Article> listArticles = article.findArticlesByVendeur(vendeur);
				request.setAttribute("msg", "L'article a bien été modifié.");
				session.setAttribute("listArticles", listArticles);
				request.setAttribute("listArticles", listArticles);
				this.getServletContext().getRequestDispatcher("/vues/Gestion_Articles.jsp").forward(request, response);
				break;
				default : 
					request.setAttribute("msg", msg);
					this.getServletContext().getRequestDispatcher("/vues/Gestion_Articles.jsp").forward(request, response);
				break;
			}
		}catch(Exception ex) {
			request.setAttribute("msg", "Le prix doit être un nombre.");
			this.getServletContext().getRequestDispatcher("/vues/Modifier_Article.jsp").forward(request, response);
		}
	}

}
