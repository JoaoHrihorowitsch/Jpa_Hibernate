package Principal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpaMapeamentos_n_n.*;

public class ManyToMany {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaMapeamentos_n_n");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		
		Departamento dp = new Departamento(null, "Desenvolvimento");
		Departamento dp2 = new Departamento(null, "Vendas");
		Departamento dp3 = new Departamento(null, "Administracao");
		
		em.persist(dp);
		em.persist(dp2);
		em.persist(dp3);
		
		List<Departamento> dpSet1 = new ArrayList();
		dpSet1.add(dp);
		
		List<Departamento> dpSet2 = new ArrayList();
		dpSet2.add(dp2);
		
		List<Departamento> dpSet3 = new ArrayList();
		dpSet3.add(dp3);
		
		Funcionario fc1 = new Funcionario();
		fc1.setEnome("José");
		fc1.setFuncao("Desenvolver");
		fc1.setSalario(50000.0);
		fc1.setDepartamentoSet(dpSet1);
		
		Funcionario fc2 = new Funcionario();
		fc2.setEnome("Gabriel");
		fc2.setFuncao("Gerente");
		fc2.setSalario(40000.0);
		fc2.setDepartamentoSet(dpSet2);
		
		Funcionario fc3 = new Funcionario();
		fc3.setEnome("Césa");
		fc3.setFuncao("Contator");
		fc3.setSalario(45000.0);
		fc3.setDepartamentoSet(dpSet3);
		

		em.persist(fc1);
		em.persist(fc2);
		em.persist(fc3);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	

	}

}
