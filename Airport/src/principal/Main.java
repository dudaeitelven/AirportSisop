package principal;

import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static void main(String[] args) {

		ArrayList<Aviao> aHangar = new ArrayList<Aviao>();
		ArrayList<Aviao> aFilaDecolagem = new ArrayList<Aviao>();
		ArrayList<Aviao> aFilaAterrissar = new ArrayList<Aviao>();
		ArrayList<Aviao> aAirway10000 = new ArrayList<Aviao>();
		ArrayList<Aviao> aAirway15000 = new ArrayList<Aviao>();
		ArrayList<Aviao> aAirway20000 = new ArrayList<Aviao>();

		for (int i = 1; i <= 1; i++) {
			Aviao aviao = new Aviao(i, 200,200, false,true);
			// aviao.start();
			aHangar.add(aviao);

		}

//		System.out.println(" -- Hangar --");
//		for (Aviao Hangar : aHangar) {
//			System.out.println(Hangar.getIdentificador());
//		}
//		System.out.println(" -- Fim Hangar --");
//		

		/* Thread Hangar -> aFilaDecolagem */

		Thread t1 = new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);

						if ((aHangar.size() - 1) >= 0) {
							Random rand = new Random();
							int randomNum = rand.nextInt((aHangar.size() - 1) + 1);

							/* Add FILA PARA DECOLAGEM */

							aFilaDecolagem.add(aHangar.get(randomNum));
							aHangar.remove(randomNum);
						}
//						System.out.println("--Pista Sul--");
//						
//						
//						for (Aviao aPista : aFilaDecolagem) {
//							System.out.print(aPista.getIdentificador()+" ");
//						}
//						System.out.println("\n--------");

					} catch (InterruptedException e) {
					}

				}

			}
		};

		/* Thread aFilaDecolagem -> Way10000 */
		Thread t2 = new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(2000);

						// PISTA DECOLAGEM
						if ((aFilaDecolagem.size() - 1) >= 0) {
							try {
								aFilaDecolagem.get(0).start();
								aFilaDecolagem.get(0).setSubir(true);
							} catch (Exception e) {
								// TODO: handle exception
							}
							aAirway10000.add(aFilaDecolagem.get(0));
							aFilaDecolagem.remove(0);
						}
//						System.out.println("--Airway10000--");
//						
//						for (Aviao aAirway : aAirway10000) {
//							System.out.print(aAirway.getIdentificador()+" ");
//						}
//						
//						System.out.println("\n--------");
//						
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

						if ((aAirway10000.size() - 1) >= 0) {

							for (int i = 0; i < aAirway10000.size(); i++) {
								if (aAirway10000.get(i).getSubir() == true) {
									aAirway10000.get(i).setTempoSubir(200);
									aAirway10000.get(i).setSubir(false);
									aAirway15000.add(aAirway10000.get(i));
									aAirway10000.remove(i);
									// break;
								}
							}
						}
//						
//						System.out.println("--Airway15000--");
//						
//						for (Aviao aAirway : aAirway15000) {
//							System.out.print(aAirway.getIdentificador()+" ");
//						}
//						
//						System.out.println("\n--------");

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

						/*
						 * if((aAirway15000.size()-1)>= 0) { aAirway20000.add(aAirway15000.get(0));
						 * aAirway15000.remove(0); }
						 */

						if ((aAirway15000.size() - 1) >= 0) {
							for (int i = 0; i < aAirway15000.size(); i++) {
								if (aAirway15000.get(i).getSubir() == true) {
									aAirway15000.get(i).setTempoSubir(200);
									aAirway15000.get(i).setSubir(false);
									//aAirway15000.get(i).setDescer(false);
									aAirway20000.add(aAirway15000.get(i));
									aAirway15000.remove(i);
									// break;
								}
							}
						}

//						System.out.println("--Airway20000--");
//						
//						for (Aviao aAirway : aAirway20000) {
//							System.out.print(aAirway.getIdentificador()+" ");
//						}
//						
//						System.out.println("\n--------");

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

						/*
						 * if((aAirway20000.size()-1)>= 0) { aAirway15000.add(aAirway20000.get(0));
						 * aAirway20000.remove(0); }
						 */

						if ((aAirway20000.size() - 1) >= 0) {
							for (int i = 0; i < aAirway20000.size(); i++) {
								if (aAirway20000.get(i).getDescer() == true) {
									aAirway20000.get(i).setTempoDescer(200);
									aAirway20000.get(i).setDescer(false);
									aAirway15000.add(aAirway20000.get(i));
									aAirway20000.remove(i);
									// break;
								}
							}
						}
//						
//						System.out.println("--Airway15000--");
//						
//						for (Aviao aAirway : aAirway15000) {
//							System.out.print(aAirway.getIdentificador()+" ");
//						}
//						
//						System.out.println("\n--------");
//						
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

						/*
						 * if((aAirway15000.size()-1)>= 0) { aAirway10000.add(aAirway15000.get(0));
						 * aAirway15000.remove(0); }
						 */
						if ((aAirway15000.size() - 1) >= 0) {
							for (int i = 0; i < aAirway15000.size(); i++) {
								if (aAirway15000.get(i).getDescer() == true) {
									aAirway15000.get(i).setTempoDescer(200);
									aAirway15000.get(i).setDescer(false);
									aAirway10000.add(aAirway15000.get(i));
									aAirway15000.remove(i);
									// break;
								}
							}
						}
//						System.out.println("--Airway10000--");
//						
//						for (Aviao aAirway : aAirway10000) {
//							System.out.print(aAirway.getIdentificador()+" ");
//						}
//						
//						System.out.println("\n--------");

					} catch (InterruptedException e) {
					}

				}

			}
		};

		/* Thread Way10000 -> aFilaAterrissar */
		Thread t7 = new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(7000);

						/*
						 * if((aAirway10000.size()-1)>= 0) { aFilaAterrissar.add(aAirway10000.get(0));
						 * aAirway10000.remove(0); }
						 */
						if ((aAirway10000.size() - 1) >= 0) {
							for (int i = 0; i < aAirway10000.size(); i++) {
								if (aAirway10000.get(i).getDescer() == true) {
									aAirway10000.get(i).setTempoDescer(200);
									aAirway10000.get(i).setDescer(false);
									aFilaAterrissar.add(aAirway10000.get(i));
									aAirway10000.remove(i);
									// break;
								}
							}
						}

//						System.out.println("--PistaNorte--");
//						
//						for (Aviao aPNorte : aFilaAterrissar) {
//							System.out.print(aPNorte.getIdentificador()+" ");
//						}
//						
//						System.out.println("\n--------");

					} catch (InterruptedException e) {
					}

				}

			}
		};

		/* Thread aFilaAterrissar-> aHangar */
		Thread t8 = new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(3000);

						if ((aFilaAterrissar.size() - 1) >= 0) {
							aHangar.add(aFilaAterrissar.get(0));
							aFilaAterrissar.remove(0);
							
						}

//						System.out.println("--Hangar--");
//						
//						for (Aviao aHangar : aHangar) {
//							System.out.print(aHangar.getIdentificador()+" ");
//						}
//						
//						System.out.println("\n--------");
//						
					} catch (InterruptedException e) {
					}

				}

			}
		};

		/* Printa TELA */
		Thread t9 = new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(500);

						System.out.println("\n--HANGAR--");
						for (Aviao aHangar : aHangar) {
							System.out.print(aHangar.getIdentificador() + " ");
						}
						System.out.println("\n--DECOLAGEM--");
						for (Aviao aPista : aFilaDecolagem) {
							System.out.print(aPista.getIdentificador() + " ");
						}
						System.out.println("\n--Aterrissagem--");
						for (Aviao aWay1000 : aAirway20000) {
							System.out.print(aWay1000.getIdentificador() + " ");
						}
						System.out.println("\n--AIRWAY 10000--");

						for (Aviao aWay1000 : aAirway10000) {
							System.out.print(aWay1000.getIdentificador() + " ");
						}
						System.out.println("\n--AIRWAY 15000--");
						for (Aviao aWay1000 : aAirway15000) {
							System.out.print(aWay1000.getIdentificador() + " ");
						}
						System.out.println("\n--AIRWAY 20000--");
						for (Aviao aWay1000 : aAirway20000) {
							System.out.print(aWay1000.getIdentificador() + " ");
						}

						System.out.println("\n--------");

					} catch (InterruptedException e) {
					}

				}

			}
		};

		t9.start();

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();

//		t1.start();
//		try {
//			t1.join();
//			t2.start();
//			t2.join();
//			t3.start();
//			t3.join();
//			t4.start();
//			t4.join();
//			t5.start();
//			t5.join();
//			t6.start();
//			t6.join();
//			t7.start();
//			t7.join();
//			//t8.start();
//			//t8.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		t8.start();
		
		
		
		
		
		
		
		
		/*
		 * System.out.println(" ** Final ** 20.000 **"); for (Aviao aAirway :
		 * aAirway20000) { System.out.println(aAirway.getIdentificador()); }
		 */

	}

}