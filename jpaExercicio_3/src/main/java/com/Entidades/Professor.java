package com.Entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Professor {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int pid;
	private String pnome;
	
	@ManyToMany(targetEntity=Classe.class)
	@JoinColumn(name="pid", referencedColumnName = "cid")
	private List classeSet;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPnome() {
		return pnome;
	}
	public void setPnome(String pnome) {
		this.pnome = pnome;
	}

	public void setClasseSet(List classeSet) {
		this.classeSet = classeSet;
	}
	
}
