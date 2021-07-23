package utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/** Classe utilit�ria que cria um painel de r�tulos para uma tabela */
public class TableLabeler extends JPanel {
	
	// Atributos
	private static final long serialVersionUID = -7495953093988741785L;
	private static final Border panelBorder = BorderFactory.createLineBorder(Color.BLACK);
	
	// Construtor do painel
	public TableLabeler(int width, int height, String[] labels, int len) {
		
		// Caracter�sticas
		this.setLayout(new GridLayout(1, len));
		this.setMaximumSize(new Dimension(width, height));
		this.setBackground(Color.BLACK);
		
		// Adi��o dos paineis de rotula��o
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
