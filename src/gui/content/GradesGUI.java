package gui.content;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import dto.Activity;
import dto.Discipline;
import utils.TableLabeler;

/** Interface das notas e médias */
public class GradesGUI extends JPanel {

	// Constantes
	private static final long serialVersionUID = 7L;
	private static final String[] TABLE_LABELS = {"Atividade", "Nota"};
	private static final String MEAN_LABEL = new String("Média final: ");
	
	// Referência da disciplina atual
	private Discipline currentDiscipline;
	
	// Tabelas de notas
	private JPanel assessmentsTable;
	private JPanel worksTable;
	private JPanel othersTable;
	
	// Rótulos variáveis
	private JLabel disciplineLabel;
	private JLabel meanLabel;
	
	// Construtor do painel
	public GradesGUI() {
		
		// Layout vertical
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// Rótulo do quadro
		JLabel mainLabel = new JLabel("Notas");
		mainLabel.setForeground(Color.WHITE);
		mainLabel.setFont(new Font(mainLabel.getFont().getName(), Font.BOLD, 14));
		
		// Painel de rotulação do quadro
		JPanel labelPanel = new JPanel();
		labelPanel.setBackground(Color.BLACK);
		labelPanel.setMaximumSize(new Dimension(760, 30));
		labelPanel.add(mainLabel);
		this.add(labelPanel);
		
		// Rótulo da disciplina
		disciplineLabel = new JLabel("Disciplina");
		disciplineLabel.setForeground(new Color(230, 230, 230));
		disciplineLabel.setFont(new Font(disciplineLabel.getFont().getName(), Font.BOLD, 12));
		
		// Painel de rotulação da disciplina
		JPanel disciplineLabelPanel = new JPanel();
		disciplineLabelPanel.setBackground(new Color(110, 110, 110));
		disciplineLabelPanel.setMaximumSize(new Dimension(760, 30));
		disciplineLabelPanel.add(disciplineLabel, JLabel.CENTER);
		this.add(disciplineLabelPanel);
		
		// Painel intermediário
		JPanel container = new JPanel(new GridBagLayout());
		container.setMaximumSize(new Dimension(760, 160));
		container.setBackground(Color.LIGHT_GRAY);
		this.add(container);
		
		// Ajusta a adição no contêiner
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridy = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(0, 5, 0, 5);
		
		// Tabelas de notas
		assessmentsTable = new JPanel(new GridLayout(0, 2));
		worksTable = new JPanel(new GridLayout(0, 2));
		othersTable = new JPanel(new GridLayout(0, 2));
		
		// Mostradores das notas
		container.add(createGradePanel("Provas", assessmentsTable), gbc);
		container.add(createGradePanel("Trabalhos", worksTable), gbc);
		container.add(createGradePanel("Outros", othersTable), gbc);
		
		// Rótulo da nota
		meanLabel = new JLabel(MEAN_LABEL + "0.0");
		meanLabel.setForeground(Color.WHITE);
		
		// Mostrador da nota
		JPanel finalGradePanel = new JPanel();
		finalGradePanel.setBackground(new Color(120, 120, 120));
		finalGradePanel.setMaximumSize(new Dimension(760, 30));
		finalGradePanel.add(meanLabel, JLabel.CENTER);
		this.add(finalGradePanel);
	}
	
	
	// Cria um painel mostrador de uma nota
	private JPanel createGradePanel(String label, JPanel table) {
		
		// Painel com layout vertical
		JPanel output = new JPanel();
		output.setLayout(new BoxLayout(output, BoxLayout.Y_AXIS));
		output.setMaximumSize(new Dimension(242, 160));
		
		// Rótulo
		JLabel mainLabel = new JLabel(label);
		mainLabel.setFont(new Font(mainLabel.getFont().getName(), Font.BOLD, 12));
		mainLabel.setForeground(Color.WHITE);
		
		// Painel do rótulo
		JPanel labelPanel = new JPanel();
		labelPanel.setPreferredSize(new Dimension(242, 30));
		labelPanel.setMaximumSize(new Dimension(242, 30));
		labelPanel.setBackground(Color.BLACK);
		labelPanel.add(mainLabel, JLabel.CENTER);
		output.add(labelPanel);
		
		// Rótulos da tabela
		output.add(new TableLabeler(242, 28, TABLE_LABELS, 2));
		
		// Rolagem da tabela
		JScrollPane scroller = new JScrollPane(table);
		scroller.setPreferredSize(new Dimension(242, 90));
		scroller.setMaximumSize(new Dimension(242, 90));
		scroller.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		output.add(scroller);
		
		return output;
	}
	
	
	// Criação de uma célula para a tabela
	private void addCell(JPanel table, String label) {
		JPanel output = new JPanel();
		output.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		output.setLayout(new BorderLayout());
		output.add(new JLabel(label, JLabel.CENTER), BorderLayout.CENTER);
		table.add(output);
	}
	
	
	// Atualiza a média final
	private void updateMean(Discipline d, Iterator<Activity> activities) {
		while(activities.hasNext())
			d.addGrade(activities.next().getGrade());
		float mean = d.getMean();
		meanLabel.setText(MEAN_LABEL + mean);
	}

	
	// Adiciona uma atividade à tabela correspondente
	private void addActivity(Activity a) {
		switch(a.getType()) {
		
			// Avaliação
			case ASSESSMENT:
				addCell(assessmentsTable, a.getName());
				addCell(assessmentsTable, "" + a.getGrade());
				break;
				
			// Trabalho
			case WORK:
				addCell(worksTable, a.getName());
				addCell(worksTable, "" + a.getGrade());
				break;
				
			// Outros
			default:
				addCell(othersTable, a.getName());
				addCell(othersTable, "" + a.getGrade());
				break;
		}
	}
	
	
	// Limpeza dos dados das tabelas
	private void clean() {
		assessmentsTable.removeAll();
		assessmentsTable.repaint();
		worksTable.removeAll();
		worksTable.repaint();
		othersTable.removeAll();
		othersTable.repaint();
		meanLabel.setText(MEAN_LABEL + "0.0");
	}
	
	
	/** Ativa visualização de uma disciplina. 
	 * @param discipline = referência para a disciplina de interesse;
	 * @param activities = iterador para as atividades da disciplina informada. */
	public void displayDiscipline(Discipline discipline, Iterator<Activity> activities) {
		if(currentDiscipline != discipline) {
			currentDiscipline = discipline;
			clean();
			disciplineLabel.setText(discipline.getName());
			while(activities.hasNext()) {
				Activity a = activities.next();
				discipline.addGrade(a.getGrade(), a.getWeight());
				addActivity(a);
			}
			updateMean(discipline, activities);
		}
	}
}
