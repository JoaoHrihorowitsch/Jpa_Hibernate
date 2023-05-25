package Principal;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Pessoa.Pessoa;

public class Pricipal {

	public static void main(String[] args) {
		
		Pessoa pnew = new Pessoa ();
		Pessoa p;
		int opçao = 0;
		Scanner sc = new Scanner (System.in);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicio_jpa");
		EntityManager em = emf.createEntityManager();
		
		while(opçao != 6) {	
			System.out.println("");
			System.out.println("Selecione a opção desejada:");
			System.out.println("");
	        System.out.println("1 - Consultar");
	        System.out.println("2 - Consultar por id");
	        System.out.println("3 - inserir");
	        System.out.println("4 - Alterar");
	        System.out.println("5 - Excluir");
	        System.out.println("6 - Desconectar");
	        
	        
	        opçao = sc.nextInt();
	        
	        switch(opçao) {
	        
	          case 1:
	        	  String jpql = "SELECT p FROM Pessoa p";
	        	  TypedQuery<Pessoa> query = em.createQuery(jpql, Pessoa.class);
	        	  List<Pessoa> pessoas = query.getResultList();
	        	  for (Pessoa pessoa : pessoas) {
	        	        System.out.println(pessoa);
	        	    }
	        	 
	        	  //System.out.println(pessoas);
	        	
	        	  break;
	        
	          case 2:
	        	  em.getTransaction().begin();
	        	  System.out.println("Informe o id: ");
	        	  int id = sc.nextInt();	
		      	  p = em.find(Pessoa.class, id);
		    	  System.out.println(p);
		    	  em.getTransaction().commit();
	              break;
	        	  
	          case 3:
	        	  em.getTransaction().begin();
	        	  String nome;
	        	  String email;
	        	  
	        	  System.out.println("Informe um nome : ");
	        	  sc.nextLine();
	        	  nome = sc.nextLine();
	        	  System.out.println("Informe o email : ");
	        	  email = sc.nextLine();
	        	  pnew = new Pessoa(null, nome, email);
	        	  em.persist(pnew);
	        	  System.out.println("Inserido com sucesso");
	        	  em.getTransaction().commit();
	        	  break;
	        	  
	          case 4:
	        	  em.getTransaction().begin();
	        	  System.out.println("Informe o id: ");
	        	  int id2 = sc.nextInt();	
		      	  p = em.find(Pessoa.class, id2);
		    	  System.out.println("Id selecionado" + p);
		    	  System.out.println("Informe um novo nome : ");
	        	  sc.nextLine();
	        	  nome = sc.nextLine();
	        	  p.setEmail(nome);
	        	  System.out.println("Informe o novo email : ");
	        	  email = sc.nextLine();
	        	  p.setEmail(email);
	        	  System.out.println( p + " Id alterado com sucesso");
	        	  em.getTransaction().commit();
	        	  break;
	        	  
	          case 5:
	        	  em.getTransaction().begin();
	        	  System.out.println("Informe o id que deseja excluir: ");
	        	  int id3 = sc.nextInt();	
		      	  p = em.find(Pessoa.class, id3);
		    	  System.out.println("Id selecionado" + p);
		    	  em.remove(p);
		    	  System.out.println("Id excluido com sucesso");
		    	  em.getTransaction().commit();
	        	  
                  break;
                  
	          case 6:
		      	  System.out.println("Desconectado");
		    	  em.close();
		    	  emf.close();
	        	  break;
	        	  
	        }
	        
		}
		
		sc.close();
		
		//em.getTransaction().begin();
		
		//em.persist(p1);
		//em.persist(p2);
		//em.persist(p3);
		//em.persist(p4);
		
		
		//p = em.find(Pessoa.class, 1);
		//System.out.println(p);
		
		//p.setNome("?");
		//p.setEmail("?");
	
		//em.remove(p);
		//em.getTransaction().commit();
		
		//System.out.println(p);
		//System.out.println("Concluido");
		//em.close();
		//emf.close();
		

	}

}
