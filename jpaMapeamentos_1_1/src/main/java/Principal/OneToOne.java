package Principal;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import jpaMapeamentos3.*;

public class OneToOne {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaMapeamentos_1_1");
		EntityManager em = emf.createEntityManager();
		
		Funcionario fnew = new Funcionario ();
		Funcionario f;
		Departamento dp = new Departamento ();
		String dp1;
		String nome;
    	String funcao;
    	double salario;
		int opçao = 0;
		Scanner sc = new Scanner (System.in);
		
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
	        	  String jpql = "SELECT f FROM Funcionario f";
	        	  TypedQuery<Funcionario> query = em.createQuery(jpql, Funcionario.class);
	        	  List<Funcionario> pessoas = query.getResultList();
	        	  for (Funcionario pessoa : pessoas) {
	        	        System.out.println(pessoa);
	        	    }
	        	 
	        	  //System.out.println(pessoas);
	        	
	        	  break;
	        
	          case 2:
	        	  em.getTransaction().begin();
	        	  System.out.println("Informe o id: ");
	        	  int id = sc.nextInt();	
		      	  f = em.find(Funcionario.class, id);
		    	  System.out.println(f);
		    	  em.getTransaction().commit();
	              break;
	        	  
	          case 3:
	        	  em.getTransaction().begin();
	        	  
	        	  System.out.println("Informe um nome : ");
	        	  sc.nextLine();
	        	  nome = sc.nextLine();
	        	  System.out.println("Informe a salário : ");
	        	  salario = sc.nextDouble();
	        	  sc.nextLine();
	        	  System.out.println("Informe o funcao : ");
	        	  funcao = sc.nextLine();
	        	  System.out.println("Informe o departamento: ");
	        	  dp1 = sc.nextLine();
	        	  dp = new Departamento(null, dp1);
	        	  fnew = new Funcionario(null, nome, salario, funcao);
	        	  em.persist(dp);
	        	  em.persist(fnew);
	        	  fnew.setDepartamento(dp);
	        	  System.out.println("Inserido com sucesso");
	        	  
	        	  em.getTransaction().commit();
	        	  break;
	        	  
	          case 4:
	        	  em.getTransaction().begin();
	        	  System.out.println("Informe o id: ");
	        	  int id2 = sc.nextInt();	
		      	  f = em.find(Funcionario.class, id2);
		    	  System.out.println("Id selecionado" + f);
		    	  System.out.println("Informe um novo nome : ");
	        	  sc.nextLine();
	        	  nome = sc.nextLine();
	        	  f.setEnome(nome);
	        	  System.out.println("Informe o novo salário : ");
	        	  salario = sc.nextDouble();
	        	  f.setSalario(salario);
	        	  sc.nextLine();
	        	  System.out.println("Informe a nova função : ");
	        	  funcao = sc.nextLine();
	        	  f.setFuncao(funcao);
	        	  System.out.println("Informe o novo departamento: ");
	        	  String nDp = sc.nextLine();
	        	  f.getDepartamento().setName(nDp);
	        	  em.getTransaction().commit();
	        	  System.out.println( f + " Id alterado com sucesso");
	        	  
	        	  break;
	        	  
	          case 5:
	        	  em.getTransaction().begin();
	        	  System.out.println("Informe o id que deseja excluir: ");
	        	  int id3 = sc.nextInt();	
		      	  f = em.find(Funcionario.class, id3);
		    	  System.out.println("Id selecionado" + f);
		    	  em.remove(f);
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
		
		//Departamento dp = new Departamento ();
		//dp.setName("Desenvolvimento");		
		//em.persist(dp);
		
		//Funcionario func = new Funcionario();
		//func.setEnome("Jose");
		//func.setSalario(52000.0);
		//func.setFuncao("Desenvolvedor");
		//func.setDepartamento(dp);		
		//em.persist(func);
		
		//em.getTransaction().commit();
		//em.close();
		//emf.close();
	}

}
