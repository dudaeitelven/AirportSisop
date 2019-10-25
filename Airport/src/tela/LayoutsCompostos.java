package tela;

import java.awt.*;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

class Tela extends JPanel {

	GridBagConstraints restricoes = new GridBagConstraints();

	public Tela() {

		setLayout(new GridBagLayout());

		restricoes.gridx = 0;

		restricoes.gridy = 0;

		restricoes.fill = 1;

		add(new JLabel("Simulação Aeroporto - Aeroporto S.O. Ltda"), restricoes);

		restricoes.gridx = 0;

		restricoes.gridy = 1;

		restricoes.fill = 1;

		add(new JLabel("AirWay 20.000"), restricoes);

		restricoes.gridx = 0;

		restricoes.gridy = 2;

		restricoes.fill = 1;

		add(new PainelTipoFlow(), restricoes);

		restricoes.gridx = 0;

		restricoes.gridy = 3;

		restricoes.fill = 1;

		add(new JLabel("AirWay 15.000"), restricoes);

		restricoes.gridx = 0;

		restricoes.gridy = 4;

		restricoes.fill = 1;

		add(new PainelTipoFlow(), restricoes);

		restricoes.gridx = 0;

		restricoes.gridy = 5;

		restricoes.fill = 1;

		add(new JLabel("AirWay 10.000"), restricoes);

		restricoes.gridx = 0;

		restricoes.gridy = 6;

		restricoes.fill = 1;

		add(new PainelTipoFlow(), restricoes);

		restricoes.gridx = 0;

		restricoes.gridy = 7;

		restricoes.fill = 1;

		add(new JLabel("Pista de Pouso"), restricoes);

		restricoes.gridx = 0;

		restricoes.gridy = 8;

		restricoes.fill = 1;

		add(new PainelTipoFlow(), restricoes);

		restricoes.gridx = 0;

		restricoes.gridy = 9;

		restricoes.fill = 1;

		add(new JLabel("Pista de Decolagem"), restricoes);

		restricoes.gridx = 0;

		restricoes.gridy = 10;

		restricoes.fill = 1;

		add(new PainelTipoFlow(), restricoes);

		restricoes.gridx = 0;

		restricoes.gridy = 11;

		restricoes.fill = 1;

		add(new JLabel("Hangar"), restricoes);

		restricoes.gridx = 0;

		restricoes.gridy = 12;

		restricoes.fill = 1;

		add(new PainelTipoFlow(), restricoes);

	}

}

class PainelTipoFlow extends JPanel {

	ArrayList<JButton> aTelaHangar = new ArrayList<JButton>();
	JButton bAviao = new JButton();
	Icon icone = new ImageIcon("C:\\Users\\Alex\\Desktop\\SisOP\\aviao.png");
	//Icon icone = new ImageIcon("aviao.png");

	public PainelTipoFlow() {

		setLayout(new FlowLayout());

		for (int i = 0; i < 20; i++) {
			aTelaHangar.add(new JButton(String.format("%d", i),icone));
			
			//aTelaHangar.add(new JButton(String.format("%d", i)));

		}
		
		for (int i = 0; i < aTelaHangar.size(); i++) {

			add(aTelaHangar.get(i));

		}

	}

}

class LayoutsCompostos extends JFrame {

	public LayoutsCompostos() {

		addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {

				System.exit(0);

			}

		});

		setSize(1300, 500);

		setLocation(150, 150);

		setTitle("Layouts Compostos");

		Container ct = getContentPane();

		ct.add(new Tela());

	}

	public static void main(String[] args) {

		LayoutsCompostos fr = new LayoutsCompostos();

		fr.setVisible(true);

	}

}