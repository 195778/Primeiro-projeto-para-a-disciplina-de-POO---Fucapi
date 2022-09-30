package teste_drive;

import teste_drive.automoveis.Carro;

public class Program {
	
	public static void atingirVelocidade(Carro carro, double velocidadeASerAtingida) throws InterruptedException {
		
		double velocidadeMaxima = carro.getVelocidadeMaxima();
		double velocidade = carro.getVelocidade();
		int marchaAtual = carro.getMarcha();
		
		//Ligar o carro caso esteja desligado
		if(carro.getLigado() == false) {
			carro.ligar();
			
		}
		
		if (velocidade < velocidadeMaxima && velocidadeASerAtingida < velocidadeMaxima) {
			if(marchaAtual == 0) {
				carro.subirMarcha();
			}
			while(!(carro.getVelocidade()>=velocidadeASerAtingida)) {
				Thread.sleep(1000);
				carro.acelerar();
				if(carro.getVelocidade()>=20.0 && carro.getMarcha()<2) {
					carro.subirMarcha();
				}else if(carro.getVelocidade()>=30.0 && carro.getMarcha()<3) {
					carro.subirMarcha();
				}else if(carro.getVelocidade()>=40.0 && carro.getMarcha()<4) {
					carro.subirMarcha();
				}else if(carro.getVelocidade()>=65.0 && carro.getMarcha()<5) {
					carro.subirMarcha();
				}
				System.out.println(carro);
			}
			System.out.println();
		}else {
			System.out.println("O carro " + carro.getCor() + " ja está acima da velocidade a ser atingida.");
			System.out.println();
		}		
	}
	
	public static void main(String[] args) throws InterruptedException {
		Carro carroVermelho = new Carro();
		Carro carroPreto = new Carro("09872130964720");
		carroPreto.setCor("preto");
		
		carroVermelho.setVelocidadeMaxima(180.00);
		carroVermelho.setQuilometragem(0.0);
		carroVermelho.setPotencia(80.0);
		carroVermelho.setCor("vermelho");
		carroVermelho.setQuantidadePortas(2);
		carroVermelho.setVelocidade(0.0);
		carroVermelho.setMarcha(0);
		carroVermelho.setLigado(false);
		
		atingirVelocidade(carroVermelho, 90.0);
		atingirVelocidade(carroPreto, 90.0);
		
	}
}
