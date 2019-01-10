package Bean;

import java.io.IOException;
import java.io.Serializable;

import javax.xml.bind.JAXBException;

import org.json.JSONException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public abstract class Utilisateur implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nom;
	private String prenom;
	private String dateNaissance;
	private String telephone;
	private String email;
	private String password;

	public Utilisateur() {

	}

	public Utilisateur(int id, String nom, String prenom, String dateNaissance, String telephone, String email,
			String password) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.telephone = telephone;
		this.email = email;
		this.password = password;
	}

	public Utilisateur(String nom, String prenom, String dateNaissance, String telephone, String email,
			String password) {
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

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
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

	public abstract Utilisateur findLogin(Utilisateur utilisateur) throws JAXBException, JsonParseException, JsonMappingException, IOException;
	
	public abstract String create(Utilisateur utilisateur);

	public abstract boolean alreadyExist(Utilisateur utilisateur) throws JsonParseException, JsonMappingException, IOException, JSONException;
	
	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", telephone=" + telephone + ", email=" + email + ", password=" + password + "]";
	}

}
