package com.Entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Classe {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer cid;
	private String cnome;
	
	@ManyToMany(targetEntity=Professor.class)
	private List professorSet;
	
	public Classe() {
		
	}
	
	public Classe(Integer cid, String cnome) {
		super();
		this.cid = cid;
		this.cnome = cnome;
	}
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCnome() {
		return cnome;
	}
	public void setCnome(String cnome) {
		this.cnome = cnome;
	}
	

}
