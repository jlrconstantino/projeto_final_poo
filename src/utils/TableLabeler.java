package utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/** Classe utilitária que cria um painel de rótulos para uma tabela */
public class TableLabeler extends JPanel {
	
	// Atributos
	private static final long serialVersionUID = -7495953093988741785L;
	private static final Border panelBorder = BorderFactory.createLineBorder(Color.BLACK);
	
	// Construtor do painel
	public TableLabeler(int width, int height, String[] labels, int len) {
		
		// Características
		this.setLayout(new GridLayout(1, len));
		this.setMaximumSize(new Dimension(width, height));
		this.setBackground(Color.BLACK);
		
		// Adição dos paineis de rotulação
		for(int i = 0; i < len; ++i)
			this.add(createPanel(labels[i]));	
	}
	
	// Cria um novo painel rotulado
	private JPanel createPanel(String label) {
		JPanel output = new JPanel();
		output.setBorder(panelBorder);
		output.setBackground(new Color(160, 160, 160));
		output.setForeground(new Color(40, 40, 40));
		output.add(new JLabel(label));
		return output;
	}
}
