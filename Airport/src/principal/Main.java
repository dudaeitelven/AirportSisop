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
		
		 
		/* Thread decolagem */
		Thread t1 = new Thread() {
			@Override
			public void run() {
				while ((aHangar.size()) != 0) {
					try {
						Thread.sleep(500);

						Random rand = new Random();
						int randomNum = rand.nextInt(aHangar.size());
						
						/*Add FILA PARA DECOLAGEM*/
						aPistaDecolagem.add(aHangar.get(randomNum));
						aHangar.remove(randomNum);
						
						System.out.println("--Pista decolagem --");
						
						for (Aviao aPista : aPistaDecolagem) {
							System.out.println(aPista.getIdentificador());
						}
						
						System.out.println("--------");
						
					} catch (InterruptedException e) {
					}

				}

			}
		};

		/* Thread Way10000 */
		Thread t2 = new Thread() {
			@Override
			public void run() {
				while ((aPistaDecolagem.size()) != 0) {
					try {
						Thread.sleep(1000);

						aAirway10000.add(aPistaDecolagem.get(0));
						aPistaDecolagem.remove(0);
						
						System.out.println("--Airway10000--");
						
						for (Aviao aAirway : aAirway10000) {
							System.out.println(aAirway.getIdentificador());
						}
						
						System.out.println("--------");
						
					} catch (InterruptedException e) {
					}

				}

			}
		};
		
		/* Thread Way15000 */
		Thread t3 = new Thread() {
			@Override
			public void run() {
				while ((aAirway10000.size()) != 0) {
					try {
						Thread.sleep(2000);

						
						aAirway15000.add(aAirway10000.get(0));
						aAirway10000.remove(0);
						
						System.out.println("--Airway15000--");
						
						for (Aviao aAirway : aAirway15000) {
							System.out.println(aAirway.getIdentificador());
						}
						
						System.out.println("--------");
						
					} catch (InterruptedException e) {
					}

				}

			}
		};
		
		/* Thread Way20000 */
		Thread t4 = new Thread() {
			@Override
			public void run() {
				while ((aAirway15000.size()) != 0) {
					try {
						Thread.sleep(4000);

						aAirway20000.add(aAirway15000.get(0));
						aAirway15000.remove(0);
						
						
						System.out.println("--Airway20000--");
						
						for (Aviao aAirway : aAirway20000) {
							System.out.println(aAirway.getIdentificador());
						}
						
						System.out.println("--------");
						
					} catch (InterruptedException e) {
					}

				}

			}
		};
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		System.out.println(" ** 20.000 **");
		for (Aviao aAirway : aAirway20000) {
			System.out.println(aAirway.getIdentificador());
		}

	}


}
