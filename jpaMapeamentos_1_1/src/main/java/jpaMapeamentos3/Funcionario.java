package jpaMapeamentos3;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Funcionario {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer eid;
	private String enome;
	private double salario;
	private String funcao;
	
	@OneToOne
	private Departamento departamento;

	public Funcionario(Integer eid, String enome, double salario, String funcao) {
		this.eid = eid;
		this.enome = enome;
		this.salario = salario;
		this.funcao = funcao;
	}

	public Funcionario() {

	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
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

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	
	@Override
	public String toString() {
		return "Funcionario [eid=" + eid + ", enome=" + enome + ", salario=" + salario + ", funcao=" + funcao
				+ ", departamento=" + departamento + "]";
	}

	

}
