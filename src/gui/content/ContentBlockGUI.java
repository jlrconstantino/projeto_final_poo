package gui.content;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.SemesterController;
import dto.Activity;
import generic.interfaces.Filter;
import gui.listeners.ModifyActivityListener;
import utils.TableLabeler;

public abstract class ContentBlockGUI extends JPanel {

	// ID
	private static final long serialVersionUID = 1492406342347023333L;
	
	// Controle do painel
	private SemesterController currentSemester;
	private JPanel table;
	
	// Referências para os botões
	private CentralPanelGUI centralPanel;
	private ActivityAdderGUI activityAdder;
	
	// Construtor privado do painel
	private ContentBlockGUI (
		CentralPanelGUI centralPanel, 
		ActivityAdderGUI activityAdder, 
		String blockLabel, 
		String[] tableLabels, 
		int tableColumns, 
		int tableHeight, 
		String buttonLabel, 
		ActionListener listener
	){
		// Captura das referências
		this.centralPanel = centralPanel;
		this.activityAdder = activityAdder;
		
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
		scroller.setPreferredSize(new Dimension(760, tableHeight));
		scroller.setMaximumSize(new Dimension(760, tableHeight));
		scroller.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(scroller);
		
		// Botão de adicionar algo
		if(buttonLabel != null && listener != null) {
			
			// Rótulo
			JLabel buttonLabeler = new JLabel(buttonLabel, JLabel.CENTER);
			
			// Botão
			JButton button = new JButton();
			button.setLayout(new BorderLayout());
			button.setBackground(Color.LIGHT_GRAY);
			button.add(buttonLabeler, BorderLayout.CENTER);
			button.setPreferredSize(new Dimension(760, 30));
			button.setMaximumSize(new Dimension(760, 30));
			button.addActionListener(listener);
			
			// Painel
			JPanel buttonPanel = new JPanel(new BorderLayout());
			buttonPanel.setMaximumSize(new Dimension(760, 30));
			buttonPanel.add(button, BorderLayout.CENTER);
			buttonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			this.add(buttonPanel);
		}
	}
	
	// Construtores públicos do painel
	public ContentBlockGUI (
		String blockLabel, 
		String[] tableLabels, 
		int tableColumns
	){
		this(null, null, blockLabel, tableLabels, tableColumns, 190, null, null);
	}
	public ContentBlockGUI (
		CentralPanelGUI centralPanel, 
		ActivityAdderGUI activityAdder, 
		String blockLabel, 
		String[] tableLabels, 
		int tableColumns, 
		String buttonLabel, 
		ActionListener listener
	){
		this(centralPanel, activityAdder, blockLabel, tableLabels, tableColumns, 160, buttonLabel, listener);
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
	protected void addCell(Activity activity) {
		JLabel label = new JLabel(activity.getName(), JLabel.CENTER);
		JButton button = new JButton();
		button.setLayout(new BorderLayout());
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.add(label, BorderLayout.CENTER);
		button.addActionListener(new ModifyActivityListener(centralPanel, activityAdder, activity));
		JPanel output = new JPanel();
		output.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		output.setLayout(new BorderLayout());
		output.add(button, BorderLayout.CENTER);
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
