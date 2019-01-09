package Servlets;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONException;

import Bean.Article;
import Bean.Vendeur;

/**
 * Servlet implementation class ajoutArticleCorrect
 */
@WebServlet("/ajoutArticleCorrect")
public class Ajouter_Article2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String filePath = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajouter_Article2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/vues/Gestion_Articles.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session = request.getSession();
		/*try {
			String libelle=(String) request.getParameter("libelle");
			double prix=Double.parseDouble(request.getParameter("prix"));
			String descriptif=(String) request.getParameter("descriptif");
			String nomImage="";
			Vendeur vendeur = (Vendeur)session.getAttribute("vendeur");
			ModeleArticle modeleArticle = new ModeleArticle();
			String msg=modeleArticle.create(libelle, prix, descriptif,nomImage,vendeur);
			/*switch(msg) {
			case "-2" : 
				request.setAttribute("msg", "Le libelle est vide.");
				this.getServletContext().getRequestDispatcher("/vues/Gestion_Articles.jsp").forward(request, response);
			break;	
			case "1" :
				List<Article> listArticles = modeleArticle.findArticlesByVendeur(vendeur);
				request.setAttribute("msg", "L'article a bien été ajouté.");
				session.setAttribute("listArticles", listArticles);
				request.setAttribute("listArticles", listArticles);
				this.getServletContext().getRequestDispatcher("/vues/Gestion_Articles.jsp").forward(request, response);
				break;
				default : 
					request.setAttribute("msg", msg);
					this.getServletContext().getRequestDispatcher("/vues/Gestion_Articles.jsp").forward(request, response);
				break;
			}*/
			
			
		/*}catch(Exception ex) {
			
			request.setAttribute("msg", "Le prix doit être un nombre." + request.getParameter("prix"));
			this.getServletContext().getRequestDispatcher("/vues/Gestion_Articles.jsp").forward(request, response);
		}*/
		
		// Create a factory for disk-based file items
				DiskFileItemFactory factory = new DiskFileItemFactory();

				// Configure a repository (to ensure a secure temp location is used)
				ServletContext servletContext = this.getServletConfig().getServletContext();
				File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
				factory.setRepository(repository);

				// Create a new file upload handler
				ServletFileUpload upload = new ServletFileUpload(factory);

				// Parse the request
				List<FileItem> items = new ArrayList<>();
				try {
					items = upload.parseRequest(request);
				} catch (FileUploadException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String msg = new String();
				double prix = -1;
				filePath = getServletContext().getInitParameter("path_image");
				String libelle = "";
				String descriptif = "";
				String fileNameS = new String();
				 String fileName ="";
				Iterator<FileItem> iter = items.iterator();
				while (iter.hasNext()) {
				    FileItem item = iter.next();

				    if (item.isFormField()) {
				        String name = item.getFieldName();
				        String value = item.getString();
				        switch (name) {
				        case "libelle":
				        	libelle = value;
				        	break; 
				        case "descriptif":
				        	descriptif = value;
				        	break;
				        case "prix":
				        	try {
				        		prix = Double.parseDouble(value);
				        	}catch (Exception err) {
				        		msg = "Prix invalide";
				        		request.setAttribute("msg", msg);
				        		this.getServletContext().getRequestDispatcher("/vues/Ajouter_Article.jsp").forward(request, response);
				        	}
				        	break;
		        }
				    } else {
				        //si c'est un fichier
				    	 fileName = item.getName();
				    	 fileNameS = fileName;
				    	 StringTokenizer tok = new StringTokenizer(fileName,"\\");
				    	 while (tok.hasMoreTokens()) {
				    		 String tmp = tok.nextToken();
				    		 if(!tok.hasMoreTokens()) {
				    			 fileName = tmp;
				    		 }
				    	 } 
				    	 File uploadedFile = new File( filePath +"\\"+fileName);
				    	 try {
							item.write(uploadedFile);
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							msg = "Le fichier existe déjà. Veuillez changer le nom du fichier";
			        		request.setAttribute("msg", msg);
			        		this.getServletContext().getRequestDispatcher("/vues/Ajouter_Article.jsp").forward(request, response);
						}
				    }
				}
				if(prix>0 && !descriptif.equals("") && !libelle.equals("") && !fileNameS.equals("")) {
					
					// Appel de l'ajout à la db
					Article article = new Article();
					HttpSession session = request.getSession();
					Vendeur vendeur = (Vendeur)session.getAttribute("vendeur");
					//msg = modele_Article.create(libelle,descriptif,fileNameS,prix,vend.getId()); problème de co
					msg = article.create(libelle,prix,descriptif,fileName,vendeur);
					request.setAttribute("msg", msg);
					List<Article> listArticles = new ArrayList<>();
					try {
						listArticles = article.findArticlesByVendeur(vendeur);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					request.setAttribute("msg", "L'article a bien été ajouté.");
					session.setAttribute("libelle", libelle);
					session.setAttribute("prix", prix);
					session.setAttribute("descriptif", descriptif);
					session.setAttribute("listArticles", listArticles);
					request.setAttribute("listArticles", listArticles);
					this.getServletContext().getRequestDispatcher("/vues/Gestion_Articles.jsp").forward(request, response);
				}
				else {
					msg = "Les champs (*) sont obligatoires";
					request.setAttribute("msg", msg);
					this.getServletContext().getRequestDispatcher("/vues/Ajouter_Article.jsp").forward(request, response);
				}
	}

}
