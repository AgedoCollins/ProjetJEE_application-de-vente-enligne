package Bean;

import java.util.Date;

public class Utilisateur implements Iauthentifier {
	private int id;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String telephone;
	private String email;
	private String password;
	private String nomImage;

	public Utilisateur() {

	}

	public Utilisateur(int id, String nom, String prenom, Date dateNaissance, String telephone, String email,
			String password, String nomImage) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.telephone = telephone;
		this.email = email;
		this.password = password;
	}

	public Utilisateur(String nom, String prenom, Date dateNaissance, String telephone, String email, String password,
			String nomImage) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.telephone = telephone;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNomImage() {
		return nomImage;
	}

	public void setNomImage(String nomImage) {
		this.nomImage = nomImage;
	}

	@Override
	public void consulterProfil() {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifierProfil() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", telephone=" + telephone + ", email=" + email + ", password=" + password + ", nomImage=" + nomImage
				+ "]";
	}
}
