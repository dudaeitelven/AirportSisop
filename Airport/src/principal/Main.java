package principal;

import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Aviao> aHangar =      new ArrayList<Aviao>();
		ArrayList<Aviao> aPistaSul =    new ArrayList<Aviao>();
		ArrayList<Aviao> aPistaNorte =  new ArrayList<Aviao>();
		ArrayList<Aviao> aAirway10000 = new ArrayList<Aviao>();
		ArrayList<Aviao> aAirway15000 = new ArrayList<Aviao>();
		ArrayList<Aviao> aAirway20000 = new ArrayList<Aviao>();

		Aviao av1 = new Aviao(1);
		Aviao av2 = new Aviao(2);
		Aviao av3 = new Aviao(3);
		Aviao av4 = new Aviao(4);
		Aviao av5 = new Aviao(5);
//		Aviao av6 = new Aviao(6);
//		Aviao av7 = new Aviao(7);
//		Aviao av8 = new Aviao(8);
//		Aviao av9 = new Aviao(9);
//		Aviao av10 = new Aviao(10);
//		Aviao av11 = new Aviao(11);
//		Aviao av12 = new Aviao(12);
//		Aviao av13 = new Aviao(13);
//		Aviao av14 = new Aviao(14);
//		Aviao av15 = new Aviao(15);
//		Aviao av16 = new Aviao(16);
//		Aviao av17 = new Aviao(17);
//		Aviao av18 = new Aviao(18);
//		Aviao av19 = new Aviao(19);
//		Aviao av20 = new Aviao(20);

		aHangar.add(av1);
		aHangar.add(av2);
		aHangar.add(av3);
		aHangar.add(av4);
		aHangar.add(av5);
//		aHangar.add(av6);
//		aHangar.add(av7);
//		aHangar.add(av8);
//		aHangar.add(av9);
//		aHangar.add(av10);
//		aHangar.add(av11);
//		aHangar.add(av12);
//		aHangar.add(av13);
//		aHangar.add(av14);
//		aHangar.add(av15);
//		aHangar.add(av16);
//		aHangar.add(av17);
//		aHangar.add(av18);
//		aHangar.add(av19);
//		aHangar.add(av20);


		/* Thread decolagem */
		
		Thread t1 = new Thread() {
			@Override
			public void run() {
				while ((aHangar.size()-1)!= 0) {
					try {
						Thread.sleep(500);

						Random rand = new Random();
						int randomNum = rand.nextInt((aHangar.size() - 1) +1);
						
						/*Add FILA PARA DECOLAGEM*/
						aPistaSul.add(aHangar.get(randomNum));
						aHangar.remove(randomNum);
						
						System.out.println("--Pista Sul--");
						
						for (Aviao aPista : aPistaSul) {
							System.out.println(aPista.getIdentificador());
						}
						
						System.out.println("--------");
						
					} catch (InterruptedException e) {
					}

				}

			}
		};
		t1.start();

		/* Thread Way10000 */
		Thread t2 = new Thread() {
			@Override
			public void run() {
				while ((aPistaSul.size()-1)!= 0) {
					try {
						Thread.sleep(2000);

						
						aAirway10000.add(aPistaSul.get(0));
						aPistaSul.remove(0);
						
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
		t2.start();
		
		/* Thread Way15000 */
		Thread t3 = new Thread() {
			@Override
			public void run() {
				while ((aAirway10000.size()-1)!= 0) {
					try {
						Thread.sleep(3000);

						
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
		t3.start();
		
		/* Thread Way20000 */
		Thread t4 = new Thread() {
			@Override
			public void run() {
				while ((aAirway15000.size()-1)!= 0) {
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
		t4.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			t4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(" ** Final ** 20.000 **");
		for (Aviao aAirway : aAirway20000) {
			System.out.println(aAirway.getIdentificador());
		}
	

	}

}
