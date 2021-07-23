package GUI.content;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** Interface das notas e m�dias */
public class GradesGUI extends JPanel {

	// Atributos
	private static final long serialVersionUID = 7L;
	
	// Construtor do painel
	public GradesGUI() {
		
		// Layout vertical
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// R�tulo superior
		JLabel mainLabel = new JLabel("Grade Hor�ria");
		mainLabel.setForeground(Color.WHITE);
		mainLabel.setFont(new Font(mainLabel.getFont().getName(), Font.BOLD, 14));
		
		// Painel superior de rotula��o
		JPanel labelPanel = new JPanel();
		labelPanel.setBackground(Color.BLACK);
		labelPanel.setPreferredSize(new Dimension(760, 30));
		labelPanel.setMaximumSize(new Dimension(760, 30));
		labelPanel.add(mainLabel);
		this.add(labelPanel);
		
		// Painel inferior de conte�do
		JPanel content = new JPanel();
		content.setBackground(Color.LIGHT_GRAY);
		content.setMaximumSize(new Dimension(760, 210));
		this.add(content);
	}
}
