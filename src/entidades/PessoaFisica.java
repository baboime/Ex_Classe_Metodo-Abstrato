package entidades;

public class PessoaFisica extends Contribuinte {
	
	private Double  gastosComSaude;

	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, Double rendaAnual, Double gastosComSaude) {
		super(nome, rendaAnual);
		this.gastosComSaude = gastosComSaude;
	}

	public Double getGastosComSaude() {
		return gastosComSaude;
	}

	public void setGastosComSaude(Double gastosComSaude) {
		this.gastosComSaude = gastosComSaude;
	}
	
	@Override
	public Double calculoImposto() {
		if (super.getRendaAnual() < 20000.0) {
			return super.getRendaAnual() * 0.15 - gastosComSaude * 0.5;
		}
		else {
			return super.getRendaAnual() * 0.25 - gastosComSaude * 0.5;
		}
	}	
}
