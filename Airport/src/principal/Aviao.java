package principal;

public class Aviao extends Thread{
	private int identificador;
	private int tempoAirway;
	private boolean alternar;
	private boolean subir;

	public Aviao(int identificador,int tempoAirway,boolean alternar,boolean subir) {
		super();
		this.identificador = identificador;
		this.tempoAirway = tempoAirway;
		this.alternar = alternar;
		this.subir = subir;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public int getTempoAirway() {
		return tempoAirway;
	}

	public void setTempoAirway(int tempoAirway) {
		this.tempoAirway = tempoAirway;
	}

	public boolean getAlternar() {
		return alternar;
	}

	public void setAlternar(boolean alternar) {
		this.alternar = alternar;
	}

	public boolean getSubir() {
		return subir;
	}

	public void setSubir(boolean subir) {
		this.subir = subir;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(tempoAirway > 0 ? tempoAirway : tempoAirway * -1);
				
				tempoAirway = tempoAirway -1;
				if((tempoAirway == 0)) {
					alternar = true;						
				}
				
			} catch (InterruptedException e) {
			}
			
		}
	}
	
	
	
}
