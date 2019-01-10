package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBException;

import org.json.JSONException;

import Bean.Article;

/**
 * Servlet implementation class Afficher_Article
 */
@WebServlet("/Afficher_Article")
public class Afficher_Article extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Afficher_Article() {
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
		Article art = new Article();
		art.setId(Integer.parseInt(id));
		try {
			article = art.findArticle(art);
		} catch (JSONException | JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		request.setAttribute("article", article);
		session.setAttribute("article", article);
		session.setAttribute("path_image", getServletContext().getInitParameter("path_image"));
		this.getServletContext().getRequestDispatcher("/vues/Afficher_Article.jsp").forward(request, response);
	}
		
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
