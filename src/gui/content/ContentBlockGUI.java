package gui.content;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.SemesterController;
import dto.Activity;
import generic.interfaces.Filter;
import utils.TableLabeler;

public abstract class ContentBlockGUI extends JPanel {

	// Atributos
	private static final long serialVersionUID = 1492406342347023333L;
	private SemesterController currentSemester;
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
		labelPanel.add(mainLabel, JLabel.CENTER);
		this.add(labelPanel);
		
		// Rótulos da tabela
		this.add(new TableLabeler(760, 28, tableLabels, tableColumns));
		
		// Tabela
		table = new JPanel(new GridLayout(0, tableColumns));
		
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
		output.setLayout(new BorderLayout());
		output.add(new JLabel(label, JLabel.CENTER), BorderLayout.CENTER);
		table.add(output);
	}
	
	// Criação de uma célula para a tabela
	protected void addCell(String label, Color background, Color foreground) {
		JPanel output = new JPanel();
		output.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		output.setBackground(background);
		output.setForeground(foreground);
		output.setLayout(new BorderLayout());
		output.add(new JLabel(label, JLabel.CENTER), BorderLayout.CENTER);
		table.add(output);
	}
	
	// Verificação de semestre atual
	protected boolean isCurrentSemester(SemesterController sc) {
		return currentSemester == sc;
	}
	
	// Atualiza o semestre atual
	protected void setCurrentSemester(SemesterController sc) {
		currentSemester = sc;
	}
	
	// Retorna iterador para as atividades do semestre atual
	protected Iterator<Activity> getActivitiesIterator(){
		return currentSemester.getActivitiesIterator();
	}
	
	// Retorna iterador filtrado para as atividades do semestre atual
	protected Iterator<Activity> getActivitiesIterator(Filter<Activity> filter){
		return currentSemester.getActivitiesIterator(filter);
	}
	
	// Implementa visualização gráfica do semestre informado
	public abstract void displaySemester(SemesterController sc);
}
