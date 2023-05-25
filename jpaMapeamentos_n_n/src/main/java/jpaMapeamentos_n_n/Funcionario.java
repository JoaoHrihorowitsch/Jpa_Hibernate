package jpaMapeamentos_n_n;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Funcionario {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int eid;
	private String enome;
	private double salario;
	private String funcao;
	
	@ManyToMany(targetEntity=Departamento.class)
	@JoinColumn(name="eid", referencedColumnName = "id")
	private List departamentoSet;

	public Funcionario(int eid, String enome, double salario, String funcao, List departamentoSet) {
		super();
		this.eid = eid;
		this.enome = enome;
		this.salario = salario;
		this.funcao = funcao;
		this.departamentoSet = departamentoSet;
	}

	public Funcionario() {
		super();
		
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEnome() {
		return enome;
	}

	public void setEnome(String enome) {
		this.enome = enome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public List getDepartamentoSet() {
		return departamentoSet;
	}

	public void setDepartamentoSet(List departamentoSet) {
		this.departamentoSet = departamentoSet;
	}
	
	
}
