package entidades;

public class PessoaJuridica extends Contribuinte{
	private Integer numeroDeEmpregados;

	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(String nome, Double rendaAnual, Integer numeroDeEmpregados) {
		super(nome, rendaAnual);
		this.numeroDeEmpregados = numeroDeEmpregados;
	}

	public Integer getnumeroDeEmpregados() {
		return numeroDeEmpregados;
	}

	public void setnumeroDeEmpregados(Integer numeroDeEmpregados) {
		this.numeroDeEmpregados = numeroDeEmpregados;
	}
	
	@Override
	public Double calculoImposto() {
		if (numeroDeEmpregados > 10) {
			return super.getRendaAnual() * 0.14;
		}
		else {
			return super.getRendaAnual() * 0.16;
		}		
	}
}
