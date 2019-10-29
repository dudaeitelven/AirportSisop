package principal;

import java.awt.*;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

class Tela extends JPanel {

	GridBagConstraints restricoes = new GridBagConstraints();
	GerenciarAvioes gerAviao = new GerenciarAvioes();

	public Tela() {

		setLayout(new GridLayout(15,3));

		restricoes.gridx = 1;

		restricoes.gridy = 2;

		restricoes.fill = 1;

		add(new JLabel("Simulação Aeroporto - Aeroporto S.O. Ltda"), restricoes);

		restricoes.gridx = 0;

		restricoes.gridy = 1;

		restricoes.fill = 1;

		add(new JLabel("AirWay 20.000"), restricoes);

		restricoes.gridx = 0;

		restricoes.gridy = 2;

		restricoes.fill = 1;

		add(new PainelTipoFlow(gerAviao.getaAirway20000()), restricoes);

		restricoes.gridx = 0;

		restricoes.gridy = 3;

		restricoes.fill = 1;

		add(new JLabel("AirWay 15.000"), restricoes);

		restricoes.gridx = 0;

		restricoes.gridy = 4;

		restricoes.fill = 1;

		add(new PainelTipoFlow(gerAviao.getaAirway15000()), restricoes);

		restricoes.gridx = 0;

		restricoes.gridy = 5;

		restricoes.fill = 1;

		add(new JLabel("AirWay 10.000"), restricoes);

		restricoes.gridx = 0;

		restricoes.gridy = 6;

		restricoes.fill = 1;

		add(new PainelTipoFlow(gerAviao.getaAirway10000()), restricoes);

		restricoes.gridx = 0;

		restricoes.gridy = 7;

		restricoes.fill = 1;

		add(new JLabel("Pista de Pouso"), restricoes);

		restricoes.gridx = 0;

		restricoes.gridy = 8;

		restricoes.fill = 1;

		add(new PainelTipoFlow(gerAviao.getaFilaAterrissar()), restricoes);

		restricoes.gridx = 0;

		restricoes.gridy = 9;

		restricoes.fill = 1;

		add(new JLabel("Pista de Decolagem"), restricoes);

		restricoes.gridx = 0;

		restricoes.gridy = 10;

		restricoes.fill = 1;

		add(new PainelTipoFlow(gerAviao.getaFilaDecolagem()), restricoes);

		restricoes.gridx = 0;

		restricoes.gridy = 11;

		restricoes.fill = 1;

		add(new JLabel("Hangar"), restricoes);

		restricoes.gridx = 0;

		restricoes.gridy = 12;

		restricoes.fill = 1;

		add(new PainelTipoFlow(gerAviao.getaHangar()), restricoes);

	}

}

class PainelTipoFlow extends JPanel {

	// ArrayList<JButton> aTela = new ArrayList<JButton>();
	JButton bAviao = new JButton();
	Icon icone = new ImageIcon("C:\\Users\\Alex\\Desktop\\SisOP\\aviao.png");

	public PainelTipoFlow(ArrayList<Aviao> aAviao) {

		new Thread() {

			@Override
			public void run() {
				while (true) {
					synchronized (this) {
						try {

							setLayout(new FlowLayout());
							ArrayList<JButton> aTela = new ArrayList<JButton>();
							Icon icone = new ImageIcon("C:\\Users\\Alex\\Desktop\\SisOP\\aviao.png");
							for (int i = 0; i < aAviao.size(); i++) {
								bAviao = new JButton();
								bAviao.setText(String.format("%d", aAviao.get(i).getIdentificador()));
								bAviao.setIcon(icone);
								aTela.add(bAviao);
//							aTela.add(new JButton(String.format("%d", aAviao.get(i).getIdentificador(),icone)));
//								//aTela.add(new JButton(String.format("%d", aAviao.get(i).getIdentificador(),("C:\\Users\\Alex\\Desktop\\SisOP\\aviao.jpg"))));
								// aTelaHangar.add(new JButton(String.format("%d", i)));
							}

							for (int i = 0; i < aTela.size(); i++) {

								add(aTela.get(i));
							}
							sleep(500);
							for (int i= 0; i < aTela.size(); i++) {
								remove(aTela.get(i));	
							}
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			}
		}.start();

	}

}

class TelaProg extends JFrame {

	public TelaProg() {

		addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {

				System.exit(0);

			}

		});

		setSize(1000, 500);

		setLocation(150, 150);

		setTitle("Simulação Aeroporto");

		Container ct = getContentPane();

		ct.add(new Tela());

	}

	public void MostraTela() {

		TelaProg fr = new TelaProg();

		new Thread() {

			@Override
			public void run() {
				while (true) {
					fr.setVisible(true);
					fr.repaint();
					fr.validate();
				}

			}
		}.start();

	}

}