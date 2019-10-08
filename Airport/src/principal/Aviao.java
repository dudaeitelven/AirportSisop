package principal;

import java.util.Random;

public class Aviao extends Thread{
	private int identificador;
	private int tempoSubir;
	private int tempoDescer;
	private boolean subir;
	private boolean descer;
	public Aviao(int identificador,int tempoSubir,int tempoDescer,boolean subir,boolean descer) {
		super();
		this.identificador = identificador;
		this.tempoSubir = tempoSubir;
		this.tempoDescer = tempoDescer;
		this.subir = subir;
		this.descer = descer;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	
	

	public int getTempoSubir() {
		return tempoSubir;
	}

	public void setTempoSubir(int tempoSubir) {
		this.tempoSubir = tempoSubir;
	}

	public int getTempoDescer() {
		return tempoDescer;
	}

	public void setTempoDescer(int tempoDescer) {
		this.tempoDescer = tempoDescer;
	}

	public boolean getSubir() {
		return subir;
	}

	public void setSubir(boolean subir) {
		this.subir = subir;
	}
	
	public boolean getDescer() {
		return descer;
	}

	public void setDescer(boolean descer) {
		this.descer = descer;
	}


	public void run() {
		long count = 0;

		while (true) {
			try {
				Thread.sleep(30);
				//this.mover();
	
				
				if(subir==false) {
					tempoSubir = tempoSubir -1;
					if((tempoSubir == 0)) {
						subir = true;						
					}
				}

				if(descer==false) {
					tempoDescer = tempoDescer -1;
					if((tempoDescer == 0)) {
						descer = true;					
					}
				}
				
				
				
			} catch (InterruptedException e) {
			}
			
		}
	}
	
	
	
}
