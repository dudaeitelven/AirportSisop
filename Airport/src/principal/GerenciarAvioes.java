package principal;

import java.util.ArrayList;
import java.util.Random;

public class GerenciarAvioes {
	static ArrayList<Aviao> aHangar = new ArrayList<Aviao>();
	static ArrayList<Aviao> aFilaDecolagem = new ArrayList<Aviao>();
	static ArrayList<Aviao> aFilaAterrissar = new ArrayList<Aviao>();
	static ArrayList<Aviao> aAirway10000 = new ArrayList<Aviao>();
	static ArrayList<Aviao> aAirway15000 = new ArrayList<Aviao>();
	static ArrayList<Aviao> aAirway20000 = new ArrayList<Aviao>();

	public ArrayList<Aviao> getaHangar() {
		return aHangar;
	}

	public void setaHangar(ArrayList<Aviao> aHangar) {
		this.aHangar = aHangar;
	}

	public ArrayList<Aviao> getaFilaDecolagem() {
		return aFilaDecolagem;
	}

	public void setaFilaDecolagem(ArrayList<Aviao> aFilaDecolagem) {
		this.aFilaDecolagem = aFilaDecolagem;
	}

	public ArrayList<Aviao> getaFilaAterrissar() {
		return aFilaAterrissar;
	}

	public void setaFilaAterrissar(ArrayList<Aviao> aFilaAterrissar) {
		this.aFilaAterrissar = aFilaAterrissar;
	}

	public ArrayList<Aviao> getaAirway10000() {
		return aAirway10000;
	}

	public void setaAirway10000(ArrayList<Aviao> aAirway10000) {
		this.aAirway10000 = aAirway10000;
	}

	public ArrayList<Aviao> getaAirway15000() {
		return aAirway15000;
	}

	public void setaAirway15000(ArrayList<Aviao> aAirway15000) {
		this.aAirway15000 = aAirway15000;
	}

	public ArrayList<Aviao> getaAirway20000() {
		return aAirway20000;
	}

	public void setaAirway20000(ArrayList<Aviao> aAirway20000) {
		this.aAirway20000 = aAirway20000;
	}

	public void iniciar() {
		for (int i = 1; i <= 20; i++) {
			Aviao aviao = new Aviao(i, 200, false, true);
			aHangar.add(aviao);
		}

		/* Thread Hangar -> aFilaDecolagem */
		Thread t1 = new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);

						synchronized (this) {

							if ((aHangar.size() - 1) >= 0) {
								Random rand = new Random();
								int randomNum = rand.nextInt((aHangar.size() - 1) + 1);

								if (aHangar.get(randomNum).getSubir() == true) {
									/* Add FILA PARA DECOLAGEM */
									aFilaDecolagem.add(aHangar.get(randomNum));
									aHangar.remove(randomNum);
								}

							}
						}
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
						synchronized (this) {
							if ((aFilaDecolagem.size() - 1) >= 0) {
								if (aFilaDecolagem.get(0).getSubir() == true) {
									try {
										aFilaDecolagem.get(0).start();
										aFilaDecolagem.get(0).setAlternar(true);
									} catch (Exception e) {
									}
									aAirway10000.add(aFilaDecolagem.get(0));
									aFilaDecolagem.remove(0);
								}
							}
						}
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

						synchronized (this) {
							if ((aAirway10000.size() - 1) >= 0) {

								for (int i = 0; i < aAirway10000.size(); i++) {
									if (aAirway10000.get(i).getSubir() == true) {
										aAirway10000.get(i).setTempoAirway(200);
										aAirway10000.get(i).setAlternar(true);
										aAirway15000.add(aAirway10000.get(i));
										aAirway10000.remove(i);
									}
								}
							}
						}
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

						synchronized (this) {
							if ((aAirway15000.size() - 1) >= 0) {
								for (int i = 0; i < aAirway15000.size(); i++) {
									if (aAirway15000.get(i).getSubir() == true) {
										aAirway15000.get(i).setTempoAirway(200);
										aAirway15000.get(i).setAlternar(true);
										aAirway20000.add(aAirway15000.get(i));
										aAirway15000.remove(i);
									}
								}
							}
						}
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

						synchronized (this) {
							if ((aAirway20000.size() - 1) >= 0) {
								for (int i = 0; i < aAirway20000.size(); i++) {
									if (aAirway20000.get(i).getSubir() == true) {
										aAirway20000.get(i).setSubir(false);
										aAirway20000.get(i).setTempoAirway(200);
										aAirway20000.get(i).setAlternar(true);
										aAirway15000.add(aAirway20000.get(i));
										aAirway20000.remove(i);
										// break;
									}
								}
							}
						}
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

						synchronized (this) {
							if ((aAirway15000.size() - 1) >= 0) {
								for (int i = 0; i < aAirway15000.size(); i++) {
									if (aAirway15000.get(i).getSubir() == false) {
										aAirway15000.get(i).setTempoAirway(200);
										aAirway15000.get(i).setAlternar(true);
										aAirway10000.add(aAirway15000.get(i));
										aAirway15000.remove(i);
										// break;
									}
								}
							}
						}
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

						synchronized (this) {
							if ((aAirway10000.size() - 1) >= 0) {
								for (int i = 0; i < aAirway10000.size(); i++) {
									if (aAirway10000.get(i).getSubir() == false) {
										aAirway10000.get(i).setTempoAirway(200);
										aAirway10000.get(i).setAlternar(true);
										aFilaAterrissar.add(aAirway10000.get(i));
										aAirway10000.remove(i);
										// break;
									}
								}
							}
						}
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
						Thread.sleep(500);

						synchronized (this) {
							if ((aFilaAterrissar.size() - 1) >= 0) {
								for (int i = 0; i < aFilaAterrissar.size(); i++) {
									if (aFilaAterrissar.get(i).getSubir() == false) {
										aHangar.add(aFilaAterrissar.get(i));
										aHangar.get(i).setSubir(true);
										aFilaAterrissar.remove(i);
									}
								}
							}
						}
					} catch (InterruptedException e) {
					}
				}
			}
		};

//		/* Printa TELA */
//		Thread t9 = new Thread() {
//			@Override
//			public void run() {
//				while (true) {
//					try {
//						Thread.sleep(500);
//
//						synchronized (this) {
//
//							System.out.println("\n-----HANGAR-----");
//							for (Aviao aHangar : aHangar) {
//								System.out.print(aHangar.getIdentificador() + " ");
//							}
//							System.out.println("\n---DECOLAGEM----");
//							for (Aviao aPista : aFilaDecolagem) {
//								System.out.print(aPista.getIdentificador() + " ");
//							}
//							System.out.println("\n--ATERRISSAGEM--");
//							for (Aviao aPista : aFilaAterrissar) {
//								System.out.print(aPista.getIdentificador() + " ");
//							}
//							System.out.println("\n--AIRWAY 10000--");
//
//							for (Aviao aWay1000 : aAirway10000) {
//								System.out.print(aWay1000.getIdentificador() + " ");
//							}
//							System.out.println("\n--AIRWAY 15000--");
//							for (Aviao aWay1000 : aAirway15000) {
//								System.out.print(aWay1000.getIdentificador() + " ");
//							}
//							System.out.println("\n--AIRWAY 20000--");
//							for (Aviao aWay1000 : aAirway20000) {
//								System.out.print(aWay1000.getIdentificador() + " ");
//							}
//							System.out.println("\n----------------");
//						}
//					} catch (InterruptedException e) {
//					}
//				}
//			}
//		};
//
//		t9.start();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();

	}

}
