package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	private int id;
	private String nom;
	private String prix;
	private String description;
	private String image;
	private int cartflag ;
	private String longdescription;
	
	public int getCartflag() {
		return cartflag;
	}
	public void setCartflag(int cartflag) {
		this.cartflag = cartflag;
	}
	public String getLongdescription() {
		return longdescription;
	}
	public void setLongdescription(String longdescription) {
		this.longdescription = longdescription;
	}
	public String getImage() {
		return image;
	}
	public Product(int id, String nom, String prix) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
	}
	public Product() {
		super();
		
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getCartFlag() {
		return cartflag;
	}
	public void setCartFlag(int cartFlag) {
		this.cartflag = cartFlag;
	}
	public String getPrix() {
		return prix;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLienImage() {
		return image;
	}
	public void setLienImage(String lienImage) {
		this.image = lienImage;
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
	@Override
	public String toString() {
		return "Product [id=" + id + ", nom=" + nom + ", prix=" + prix + ", description=" + description + ", image="
				+ image + ", cartflag=" + cartflag + ", longdescription=" + longdescription + "]";
	}
		
	
}
