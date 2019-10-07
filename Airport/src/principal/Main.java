package principal;

import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Aviao> aHangar = new ArrayList<Aviao>();
		ArrayList<Aviao> aPistaDecolagem = new ArrayList<Aviao>();
		ArrayList<Aviao> aPistaNorte = new ArrayList<Aviao>();
		ArrayList<Aviao> aAirway10000 = new ArrayList<Aviao>();
		ArrayList<Aviao> aAirway15000 = new ArrayList<Aviao>();
		ArrayList<Aviao> aAirway20000 = new ArrayList<Aviao>();
		
		 for (int i = 1; i <= 5; i++)
        {
        	aHangar.add(new Aviao(i));
        }
			
		System.out.println(" -- Hangar --");
		for (Aviao Hangar : aHangar) {
			System.out.println(Hangar.getIdentificador());
		}
		System.out.println(" -- Fim Hangar --");
		
/* Thread Hangar -> PistaSul */
		
		Thread t1 = new Thread() {
			@Override
			public void run() {
				while (true) {				
					try {
						Thread.sleep(1000);

						
						if((aHangar.size()-1)>= 0){
							Random rand = new Random();
							int randomNum = rand.nextInt((aHangar.size() - 1) +1);
							
							/*Add FILA PARA DECOLAGEM*/
							
							aPistaDecolagem.add(aHangar.get(randomNum));
							aHangar.remove(randomNum);
						}			
						System.out.println("--Pista Sul--");
						
						for (Aviao aPista : aPistaDecolagem) {
							System.out.print(aPista.getIdentificador()+" ");
						}
						System.out.println("\n--------");
						
					} catch (InterruptedException e) {
					}

				}

			}
		};
		

		/* Thread PistalSul -> Way10000 */
		Thread t2 = new Thread() {
			@Override
			public void run() {
				while (true) {
				try {
						Thread.sleep(2000);

						if((aPistaDecolagem.size()-1)>= 0){
						aAirway10000.add(aPistaDecolagem.get(0));
						aPistaDecolagem.remove(0);
						}
						System.out.println("--Airway10000--");
						
						for (Aviao aAirway : aAirway10000) {
							System.out.print(aAirway.getIdentificador()+" ");
						}
						
						System.out.println("\n--------");
						
					} catch (InterruptedException e) {
					}

				}

			}
		};
		
		/* Thread Way10000 -> Way15000 */
		Thread t3 = new Thread() {
			@Override
			public void run() {
				while (true) {
				try {
						Thread.sleep(3000);

						if((aAirway10000.size()-1)>=0){
							aAirway15000.add(aAirway10000.get(0));
							aAirway10000.remove(0);
						}
						System.out.println("--Airway15000--");
						
						for (Aviao aAirway : aAirway15000) {
							System.out.print(aAirway.getIdentificador()+" ");
						}
						
						System.out.println("\n--------");
						
					} catch (InterruptedException e) {
					}

				}

			}
		};
		
		/* Thread Way15000 -> Way20000 */
		Thread t4 = new Thread() {
			@Override
			public void run() {
				while (true) {
				try {
						Thread.sleep(4000);

						
						if((aAirway15000.size()-1)>= 0) {
							aAirway20000.add(aAirway15000.get(0));
							aAirway15000.remove(0);
						}
						
						System.out.println("--Airway20000--");
						
						for (Aviao aAirway : aAirway20000) {
							System.out.print(aAirway.getIdentificador()+" ");
						}
						
						System.out.println("\n--------");
						
					} catch (InterruptedException e) {
					}

				}

			}
		};
		
		
		/* Thread Way20000 -> Way15000 */
		Thread t5 = new Thread() {
			@Override
			public void run() {
				while (true) {
				try {
						Thread.sleep(5000);

						
						if((aAirway20000.size()-1)>= 0) {
							aAirway15000.add(aAirway20000.get(0));
							aAirway20000.remove(0);
						}
						
						System.out.println("--Airway15000--");
						
						for (Aviao aAirway : aAirway15000) {
							System.out.print(aAirway.getIdentificador()+" ");
						}
						
						System.out.println("\n--------");
						
					} catch (InterruptedException e) {
					}

				}

			}
		};
		
		/* Thread Way15000 -> Way10000 */
		Thread t6 = new Thread() {
			@Override
			public void run() {
				while (true) {
				try {
						Thread.sleep(6000);

						
						if((aAirway15000.size()-1)>= 0) {
							aAirway10000.add(aAirway15000.get(0));
							aAirway15000.remove(0);
						}
						
						System.out.println("--Airway10000--");
						
						for (Aviao aAirway : aAirway10000) {
							System.out.print(aAirway.getIdentificador()+" ");
						}
						
						System.out.println("\n--------");
						
					} catch (InterruptedException e) {
					}

				}

			}
		};
		
		/* Thread Way10000 -> pistaNorte */
		Thread t7 = new Thread() {
			@Override
			public void run() {
				while (true) {
				try {
						Thread.sleep(7000);

						
						if((aAirway10000.size()-1)>= 0) {
							aPistaNorte.add(aAirway10000.get(0));
							aAirway10000.remove(0);
						}
						
						System.out.println("--PistaNorte--");
						
						for (Aviao aPNorte : aPistaNorte) {
							System.out.print(aPNorte.getIdentificador()+" ");
						}
						
						System.out.println("\n--------");
						
					} catch (InterruptedException e) {
					}

				}

			}
		};
		
		/* Thread Way10000 -> pistaNorte */
		Thread t8 = new Thread() {
			@Override
			public void run() {
				while (true) {
				try {
						Thread.sleep(8000);

						
						if((aPistaNorte.size()-1)>= 0) {
							aHangar.add(aPistaNorte.get(0));
							aPistaNorte.remove(0);
						}
						
						System.out.println("--Hangar--");
						
						for (Aviao aHangar : aHangar) {
							System.out.print(aHangar.getIdentificador()+" ");
						}
						
						System.out.println("\n--------");
						
					} catch (InterruptedException e) {
					}

				}

			}
		};
		
		
		
		
		
		
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		
		
		
		/*
		System.out.println(" ** Final ** 20.000 **");
		for (Aviao aAirway : aAirway20000) {
			System.out.println(aAirway.getIdentificador());
		}
		*/
	

	}

}