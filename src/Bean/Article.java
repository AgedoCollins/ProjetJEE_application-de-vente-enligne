package Bean;

import java.io.Serializable;

public class Article implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String libelle;
	private double prix;
	private String descriptif;
	private String nomImage;

	public Article() {

	}

	public Article(int id, String libelle, double prix, String descriptif, String nomImage) {
		this.id = id;
		this.libelle = libelle;
		this.prix = prix;
		this.descriptif = descriptif;
		this.nomImage = nomImage;
	}

	public Article(String libelle, double prix, String descriptif, String nomImage) {
		this.libelle = libelle;
		this.prix = prix;
		this.descriptif = descriptif;
		this.nomImage = nomImage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getDescriptif() {
		return descriptif;
	}

	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}

	public String getNomImage() {
		return nomImage;
	}

	public void setNomImage(String nomImage) {
		this.nomImage = nomImage;
	}

	public void creerArticle() {

	}

	public void modifierArticle() {

	}

	public void supprimerArticle() {

	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", libelle=" + libelle + ", prix=" + prix + ", descriptif=" + descriptif
				+ ", nomImage=" + nomImage + "]";
	}
	
	
}
