package teste_drive.automoveis;

public class Carro {
	
	private String numChassi;
	private Double velocidadeMaxima;
	private Double quilometragem;
	private Double potencia;
	private String cor;
	private Integer quantidadePortas;
	private Double velocidade;
	private Integer marcha;
	private Boolean ligado;
	
	public Carro() {
		
	}
	
	public Carro(String numChassi) {
		this.numChassi = numChassi;
		this.velocidadeMaxima = 180.00;
		this.quilometragem = 0.0;
		this.potencia = 80.00;
		this.cor = "branco";
		this.quantidadePortas = 4;
		this.velocidade = 0.0;
		this.marcha = 0;
		this.ligado = false;
	}
	
	public void ligar() {
		this.ligado = true;
	}
	
	public void desligar() {
		this.ligado = false;
	}
	
	public void acelerar() {
		if(ligado) {
			this.velocidade+=5.0;
		}
	}
	
	public void frear() {
		if(ligado) {
			this.velocidade-=5.0;
		}
	}
	
	public void reduzirMarcha() {
		if(!(this.marcha<=0)) {
			this.marcha--;
		}
	}
	
	public void subirMarcha() {
		if(this.marcha<5) {
			this.marcha++;
		}
	}

	public String getNumChassi() {
		return numChassi;
	}

	public void setNumChassi(String numChassi) {
		this.numChassi = numChassi;
	}

	public Double getVelocidadeMaxima() {
		return velocidadeMaxima;
	}

	public void setVelocidadeMaxima(Double velocidadeMaxima) {
		this.velocidadeMaxima = velocidadeMaxima;
	}

	public Double getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(Double quilometragem) {
		this.quilometragem = quilometragem;
	}

	public Double getPotencia() {
		return potencia;
	}

	public void setPotencia(Double potencia) {
		this.potencia = potencia;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Integer getQuantidadePortas() {
		return quantidadePortas;
	}

	public void setQuantidadePortas(Integer quantidadePortas) {
		this.quantidadePortas = quantidadePortas;
	}

	public Double getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(Double velocidade) {
		this.velocidade = velocidade;
	}

	public Integer getMarcha() {
		return marcha;
	}

	public void setMarcha(Integer marcha) {
		this.marcha = marcha;
	}

	public Boolean getLigado() {
		return ligado;
	}

	public void setLigado(Boolean ligado) {
		this.ligado = ligado;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Carro " 
				+ this.cor
				+ "	|	"
				+ this.marcha
				+ "° marcha	|	"
				+ this.velocidade
				+ "km/h";
	}
	
}
