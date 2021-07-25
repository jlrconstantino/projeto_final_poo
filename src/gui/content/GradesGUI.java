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

/** Interface das notas e m�dias */
public class GradesGUI extends JPanel {

	// Constantes
	private static final long serialVersionUID = 7L;
	private static final String[] TABLE_LABELS = {"Atividade", "Nota"};
	private static final int ASSESSMENTS=0, WORKS=1, OTHERS=2, FINAL=3;
	private static final String[] MEAN_LABELS = {
		"M�dia das provas: ", "M�dia dos trabalhos: ", 
		"M�dia das demais atividades: ", "M�dia final: "
	};
	
	// Refer�ncia da disciplina atual
	private Discipline currentDiscipline;
	
	// Tabelas de notas
	private JPanel assessmentsTable;
	private JPanel worksTable;
	private JPanel othersTable;
	
	// R�tulos vari�veis
	private JLabel disciplineLabel;
	private JLabel assessmentsMeanLabel;
	private JLabel worksMeanLabel;
	private JLabel othersMeanLabel;
	private JLabel finalMeanLabel;
	
	// Construtor do painel
	public GradesGUI() {
		
		// Layout vertical
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// R�tulo do quadro
		JLabel mainLabel = new JLabel("Notas");
		mainLabel.setForeground(Color.WHITE);
		mainLabel.setFont(new Font(mainLabel.getFont().getName(), Font.BOLD, 14));
		
		// Painel de rotula��o do quadro
		JPanel labelPanel = new JPanel();
		labelPanel.setBackground(Color.BLACK);
		labelPanel.setMaximumSize(new Dimension(760, 30));
		labelPanel.add(mainLabel);
		this.add(labelPanel);
		
		// R�tulo da disciplina
		disciplineLabel = new JLabel("Disciplina");
		disciplineLabel.setForeground(new Color(230, 230, 230));
		disciplineLabel.setFont(new Font(disciplineLabel.getFont().getName(), Font.BOLD, 12));
		
		// Painel de rotula��o da disciplina
		JPanel disciplineLabelPanel = new JPanel();
		disciplineLabelPanel.setBackground(new Color(110, 110, 110));
		disciplineLabelPanel.setMaximumSize(new Dimension(760, 30));
		disciplineLabelPanel.add(disciplineLabel, JLabel.CENTER);
		this.add(disciplineLabelPanel);
		
		// Painel intermedi�rio
		JPanel container = new JPanel(new GridBagLayout());
		container.setMaximumSize(new Dimension(760, 160));
		container.setBackground(Color.LIGHT_GRAY);
		this.add(container);
		
		// Ajusta a adi��o no cont�iner
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridy = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(0, 5, 0, 5);
		
		// Tabelas de notas
		assessmentsTable = new JPanel(new GridLayout(0, 2));
		worksTable = new JPanel(new GridLayout(0, 2));
		othersTable = new JPanel(new GridLayout(0, 2));
		
		// R�tulos das m�dias
		assessmentsMeanLabel = new JLabel(MEAN_LABELS[ASSESSMENTS] + "0.0");
		assessmentsMeanLabel.setForeground(Color.WHITE);
		worksMeanLabel = new JLabel(MEAN_LABELS[WORKS] + "0.0");
		worksMeanLabel.setForeground(Color.WHITE);
		othersMeanLabel = new JLabel(MEAN_LABELS[OTHERS] + "0.0");
		othersMeanLabel.setForeground(Color.WHITE);
		
		// Mostradores das notas
		container.add(createGradePanel("Provas", assessmentsTable, assessmentsMeanLabel), gbc);
		container.add(createGradePanel("Trabalhos", worksTable, worksMeanLabel), gbc);
		container.add(createGradePanel("Outros", othersTable, othersMeanLabel), gbc);
		
		// R�tulo da nota
		finalMeanLabel = new JLabel(MEAN_LABELS[FINAL] + "0.0");
		finalMeanLabel.setForeground(Color.WHITE);
		
		// Mostrador da nota
		JPanel finalGradePanel = new JPanel();
		finalGradePanel.setBackground(new Color(120, 120, 120));
		finalGradePanel.setMaximumSize(new Dimension(760, 30));
		finalGradePanel.add(finalMeanLabel, JLabel.CENTER);
		this.add(finalGradePanel);
	}
	
	
	// Cria um painel mostrador de uma nota
	private JPanel createGradePanel(String label, JPanel table, JLabel meanLabel) {
		
		// Painel com layout vertical
		JPanel output = new JPanel();
		output.setLayout(new BoxLayout(output, BoxLayout.Y_AXIS));
		output.setMaximumSize(new Dimension(242, 160));
		
		// R�tulo
		JLabel mainLabel = new JLabel(label);
		mainLabel.setFont(new Font(mainLabel.getFont().getName(), Font.BOLD, 12));
		mainLabel.setForeground(Color.WHITE);
		
		// Painel do r�tulo
		JPanel labelPanel = new JPanel();
		labelPanel.setPreferredSize(new Dimension(242, 30));
		labelPanel.setMaximumSize(new Dimension(242, 30));
		labelPanel.setBackground(Color.BLACK);
		labelPanel.add(mainLabel, JLabel.CENTER);
		output.add(labelPanel);
		
		// R�tulos da tabela
		output.add(new TableLabeler(242, 28, TABLE_LABELS, 2));
		
		// Rolagem da tabela
		JScrollPane scroller = new JScrollPane(table);
		scroller.setPreferredSize(new Dimension(242, 60));
		scroller.setMaximumSize(new Dimension(242, 60));
		scroller.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		output.add(scroller);
		
		// Mostrador da m�dia
		JPanel meanLabelPanel = new JPanel();
		meanLabelPanel.setMaximumSize(new Dimension(242, 30));
		meanLabelPanel.setBackground(new Color(140, 140, 140));
		meanLabelPanel.add(meanLabel, JLabel.CENTER);
		meanLabelPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		output.add(meanLabelPanel);
		
		return output;
	}
	
	
	// Cria��o de uma c�lula para a tabela
	private void addCell(JPanel table, String label) {
		JPanel output = new JPanel();
		output.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		output.setLayout(new BorderLayout());
		output.add(new JLabel(label, JLabel.CENTER), BorderLayout.CENTER);
		table.add(output);
	}
	
	
	// Atualiza a m�dia das atividades do tipo "avalia��o"
	private void updateAssessmentsMean(float value) {
		assessmentsMeanLabel.setText(MEAN_LABELS[ASSESSMENTS] + value);
	}
	
	// Atualiza a m�dia das atividades do tipo "trabalho"
	private void updateWorksMean(float value) {
		worksMeanLabel.setText(MEAN_LABELS[WORKS] + value);
	}
	
	// Atualiza a m�dia das atividades de demais tipos
	private void updateOthersMean(float value) {
		othersMeanLabel.setText(MEAN_LABELS[OTHERS] + value);
	}
	
	// Atualiza a m�dia final
	private void updateFinalMean(Discipline d, Iterator<Activity> activities) {
		while(activities.hasNext())
			d.addGrade(activities.next().getGrade());
		float mean = d.getMean();
		finalMeanLabel.setText(MEAN_LABELS[FINAL] + mean);
	}

	
	// Adiciona uma atividade � tabela correspondente
	private void addActivity(Activity a) {
		switch(a.getType()) {
		
			// Avalia��o
			case ASSESSMENT:
				addCell(assessmentsTable, a.getName());
				addCell(assessmentsTable, "" + a.getGrade());
				updateAssessmentsMean((float) 0.0);
				break;
				
			// Trabalho
			case WORK:
				addCell(worksTable, a.getName());
				addCell(worksTable, "" + a.getGrade());
				updateWorksMean((float) 0.0);
				break;
				
			// Outros
			default:
				addCell(othersTable, a.getName());
				addCell(othersTable, "" + a.getGrade());
				updateOthersMean((float) 0.0);
				break;
		}
	}
	
	
	// Limpeza dos dados das tabelas
	private void clean() {
		assessmentsTable.removeAll();
		assessmentsTable.repaint();
		updateAssessmentsMean((float) 0.0);
		worksTable.removeAll();
		worksTable.repaint();
		updateWorksMean((float) 0.0);
		othersTable.removeAll();
		othersTable.repaint();
		updateOthersMean((float) 0.0);
	}
	
	
	/** Ativa visualiza��o de uma disciplina. 
	 * @param discipline = refer�ncia para a disciplina de interesse;
	 * @param activities = iterador para as atividades da disciplina informada. */
	public void displayDiscipline(Discipline discipline, Iterator<Activity> activities) {
		if(currentDiscipline != discipline) {
			currentDiscipline = discipline;
			clean();
			disciplineLabel.setText(discipline.getName());
			while(activities.hasNext())
				addActivity(activities.next());
			updateFinalMean(discipline, activities);
		}
	}
}
