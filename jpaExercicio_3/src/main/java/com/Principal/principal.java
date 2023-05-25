package com.Principal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.Entidades.*;

public class principal {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaExercicio_3");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		
		Classe cl = new Classe(null, "Matemática");
		Classe cl2 = new Classe(null, "Português");
		Classe cl3 = new Classe(null, "Ciências");
		
		em.persist(cl);
		em.persist(cl2);
		em.persist(cl3);
		
		List<Classe> clSet1 = new ArrayList();
		clSet1.add(cl);
		
		List<Classe> clSet2 = new ArrayList();
		clSet2.add(cl2);
		
		List<Classe> clSet3 = new ArrayList();
		clSet3.add(cl3);
		
		Professor pf1 = new Professor();
		pf1.setPnome("Lucas");
		pf1.setClasseSet(clSet3);
		
		Professor pf2 = new Professor();
		pf2.setPnome("Andre");
		pf2.setClasseSet(clSet1);
		
		Professor pf3 = new Professor();
		pf3.setPnome("Deivisson");
		pf3.setClasseSet(clSet2);
		

		em.persist(pf1);
		em.persist(pf2);
		em.persist(pf3);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	
	}


}

