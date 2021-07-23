package GUI.content;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import utils.TableLabeler;

public abstract class ContentBlockGUI extends JPanel {

	// Atributos
	private static final long serialVersionUID = 1492406342347023333L;
	private JPanel table;
	
	// Construtor do painel
	public ContentBlockGUI (
		String blockLabel, 
		String[] tableLabels, 
		int tableColumns
	){
		// Layout vertical
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// Rótulo superior
		JLabel mainLabel = new JLabel(blockLabel);
		mainLabel.setForeground(Color.WHITE);
		mainLabel.setFont(new Font(mainLabel.getFont().getName(), Font.BOLD, 14));
		
		// Painel superior de rotulação
		JPanel labelPanel = new JPanel();
		labelPanel.setBackground(Color.BLACK);
		labelPanel.setPreferredSize(new Dimension(760, 30));
		labelPanel.setMaximumSize(new Dimension(760, 30));
		labelPanel.add(mainLabel);
		this.add(labelPanel);
		
		// Rótulos da tabela
		TableLabeler tableLabeler = new TableLabeler (
			760, 28, tableLabels, tableColumns
		);
		this.add(tableLabeler);
		
		// Tabela
		table = new JPanel(new GridLayout(0, 5));
		table.setBackground(Color.LIGHT_GRAY);
		
		// Rolagem da tabela
		JScrollPane scroller = new JScrollPane(table);
		scroller.setMaximumSize(new Dimension(760, 190));
		scroller.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(scroller);
	}
	
	// Limpeza dos dados da tabela
	public void clean() {
		table.removeAll();
		table.repaint();
	}
	
	// Criação de uma célula para a tabela
	protected void addCell(String label) {
		JPanel output = new JPanel();
		output.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		output.add(new JLabel(label));
		table.add(output);
	}
}
