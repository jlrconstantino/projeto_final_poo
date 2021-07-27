package gui.content;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.SemesterController;
import dto.Activity;
import dto.Discipline;
import utils.ActivityType;

public class ActivityAdderGUI extends JPanel implements ActionListener {

	// ID
	private static final long serialVersionUID = 11L;
	
	// Atributos de apresentação de rótulo
	private JLabel mainLabel;
	private static final String ADDER = "Adicionar Disciplina";
	private static final String MODIFIER = "Modificar Disciplina";
	
	// Converte datas
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	// Semestre atual
	private SemesterController currentSemester;
	
	// Atributos do painel: interação com o usuário
	private JTextField nameSelector;
	private JTextField dateSelector;
	private JComboBox<String> disciplineSelector;
	private ButtonGroup typeSelector;
	private JTextField statusSelector;
	private JTextField gradeSelector;
	private JTextField weightSelector;
	
	// Controle de modificações
	private Activity activity;
	
	// Construtor do painel
	public ActivityAdderGUI() {
		
		// Características do painel
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(new EmptyBorder(18, 0, 0, 0));
		
		// Rótulo do quadro
		mainLabel = new JLabel("Adicionar Atividade");
		mainLabel.setForeground(Color.WHITE);
		mainLabel.setFont(new Font(mainLabel.getFont().getName(), Font.BOLD, 14));
		
		// Painel de rotulação do quadro
		JPanel labelPanel = new JPanel();
		labelPanel.setBackground(Color.BLACK);
		labelPanel.setPreferredSize(new Dimension(470, 30));
		labelPanel.setMaximumSize(new Dimension(470, 30));
		labelPanel.add(mainLabel);
		this.add(labelPanel);
		
		// Painel envelopante
		JPanel wrapper = new JPanel(new GridBagLayout());
		wrapper.setBackground(Color.LIGHT_GRAY);
		wrapper.setPreferredSize(new Dimension(470, 460));
		wrapper.setMaximumSize(new Dimension(470, 460));
		this.add(wrapper);
		
		// Determina as regras de inserção no envelope
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 10, 0);
		
		// Nome da atividade
		JPanel nameWrapper = createWrapperSubpanel();
		JPanel namePanel = createLabelPanel("Nome");
		nameSelector = createTextField();
		nameWrapper.add(namePanel);
		nameWrapper.add(nameSelector);
		wrapper.add(nameWrapper, gbc);
		
		// Data da atividade
		JPanel dateWrapper = createWrapperSubpanel();
		JPanel datePanel = createLabelPanel("Data (dd/mm/aaaa)");
		dateSelector = createTextField();
		dateWrapper.add(datePanel);
		dateWrapper.add(dateSelector);
		wrapper.add(dateWrapper, gbc);
		
		// ID da disciplina da atividade
		JPanel disciplineWrapper = createWrapperSubpanel();
		JPanel disciplinePanel = createLabelPanel("Disciplina");
		disciplineSelector = new JComboBox<String>();
		disciplineSelector.setBackground(new Color(220, 220, 220));
		disciplineWrapper.add(disciplinePanel);
		disciplineWrapper.add(disciplineSelector);
		wrapper.add(disciplineWrapper, gbc);
		
		// Tipo da atividade
		JPanel typeWrapper = createWrapperSubpanel();
		JPanel typeOptionsWrapper = new JPanel(new GridBagLayout());
		GridBagConstraints typeGBC = new GridBagConstraints();
		typeGBC.insets = new Insets(0, 40, 0, 40);
		typeOptionsWrapper.setBackground(new Color(220, 220, 220));
		JPanel typePanel = createLabelPanel("Tipo");
		typeSelector = new ButtonGroup();
		JRadioButton button = createRadioButton("Avaliação", true);
		typeSelector.add(button);
		typeOptionsWrapper.add(button, typeGBC);
		button = createRadioButton("Trabalho", false);
		typeSelector.add(button);
		typeOptionsWrapper.add(button, typeGBC);
		button = createRadioButton("Outro", false);
		typeSelector.add(button);
		typeOptionsWrapper.add(button, typeGBC);
		typeWrapper.add(typePanel);
		typeWrapper.add(typeOptionsWrapper);
		wrapper.add(typeWrapper, gbc);
		
		// Status da atividade
		JPanel statusWrapper = createWrapperSubpanel();
		JPanel statusPanel = createLabelPanel("Status");
		statusSelector = createTextField();
		statusWrapper.add(statusPanel);
		statusWrapper.add(statusSelector);
		wrapper.add(statusWrapper, gbc);
		
		// Nota da atividade
		JPanel gradeWrapper = createWrapperSubpanel();
		JPanel gradePanel = createLabelPanel("Nota");
		gradeSelector = createTextField();
		gradeWrapper.add(gradePanel);
		gradeWrapper.add(gradeSelector);
		wrapper.add(gradeWrapper, gbc);
		
		// Peso da atividade
		JPanel weightWrapper = createWrapperSubpanel();
		JPanel weightPanel = createLabelPanel("Peso");
		weightSelector = createTextField();
		weightWrapper.add(weightPanel);
		weightWrapper.add(weightSelector);
		wrapper.add(weightWrapper, gbc);
		
		// Botão de adicionar atividade
		JLabel buttonLabel = new JLabel("Adicionar", JLabel.CENTER);
		JButton adderButton = new JButton();
		adderButton.setLayout(new BorderLayout());
		adderButton.setBackground(new Color(160, 160, 160));
		adderButton.addActionListener(this);
		adderButton.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		adderButton.setPreferredSize(new Dimension(60, 35));
		adderButton.add(buttonLabel, BorderLayout.CENTER);
		
		// Painel do botão adicionador de atividades
		JPanel buttonPanel = new JPanel(new BorderLayout());
		buttonPanel.add(adderButton, BorderLayout.CENTER);
		wrapper.add(buttonPanel, gbc);
	}
	
	
	// Cria um painel padronizado com um rótulo
	private JPanel createLabelPanel(String label) {
		JLabel jLabel = new JLabel(label, JLabel.CENTER);
		jLabel.setForeground(Color.WHITE);
		jLabel.setFont(new Font(jLabel.getFont().getName(), Font.BOLD, 12));
		JPanel panel = new JPanel();
		panel.setBackground(new Color(160, 160, 160));
		panel.add(jLabel);
		return panel;
	}
	
	
	// Cria um painel para envelopar um subitem
	private JPanel createWrapperSubpanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		return panel;
	}
	
	
	// Cria um campo de texto
	private JTextField createTextField() {
		JTextField field = new JTextField();
		field.setBackground(new Color(220, 220, 220));
		return field;
	}
	
	
	// Cria um botão de seleção de tipo
	private JRadioButton createRadioButton(String label, boolean selectAsDefault) {
		JRadioButton button = new JRadioButton(label);
		button.setBackground(new Color(220, 220, 220));
		button.setSelected(selectAsDefault);
		button.setActionCommand(label);
		return button;
	}
	
	
	// Limpa os seletores
	private void clean() {
		nameSelector.setText("");
		dateSelector.setText("");
		statusSelector.setText("");
		gradeSelector.setText("");
		weightSelector.setText("");
		disciplineSelector.removeAllItems();
	}
	
	
	// Preenche os seletores com os dados de certa atividade
	private void fill(Activity a) {
		nameSelector.setText(a.getName());
		dateSelector.setText(a.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		statusSelector.setText(a.getStatus());
		gradeSelector.setText("" + a.getGrade());
		weightSelector.setText("" + a.getWeight());
		disciplineSelector.removeAllItems();
	}
	
	
	/** Remonta o painel a partir do semestre corrente. */
	public void rebuild() {
		clean();
		mainLabel.setText(ADDER);
		activity = null;
		Iterator<Discipline> iterator = currentSemester.getDisciplineIterator();
		while(iterator.hasNext())
			disciplineSelector.addItem(iterator.next().getId());
		disciplineSelector.setSelectedIndex(0);
	}
	
	
	/** Remonta o painel a partir do semestre corrente. Ajusta-se para modificação. */
	public void rebuild(Activity activity) {
		fill(activity);
		mainLabel.setText(MODIFIER);
		this.activity = activity;
		Iterator<Discipline> iterator = currentSemester.getDisciplineIterator();
		while(iterator.hasNext())
			disciplineSelector.addItem(iterator.next().getId());
		disciplineSelector.setSelectedItem(activity.getDisciplineId());
	}

	
	// Adiciona atividade
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Seleciona o tipo de atividade
		ActivityType type;
		switch(typeSelector.getSelection().getActionCommand()) {
			case "Avaliação":
				type = ActivityType.ASSESSMENT;
				break;
			case "Trabalho":
				type = ActivityType.WORK;
				break;
			default:
				type = ActivityType.OTHER;
				break;
		}
		
		// Cria atividade nova se estiver no modo de adição
		if(activity == null) {
			activity = new Activity(
				nameSelector.getText(), 
				LocalDate.parse(dateSelector.getText(), formatter), 
				disciplineSelector.getSelectedItem().toString(), 
				type, 
				statusSelector.getText(), 
				Float.parseFloat(gradeSelector.getText()), 
				Float.parseFloat(weightSelector.getText())
			);
		}
		
		// Modifica uma atividade pré-existente se não
		else {
			activity.setName(nameSelector.getText());
			activity.setDate(LocalDate.parse(dateSelector.getText(), formatter));
			activity.setDisciplineId(disciplineSelector.getSelectedItem().toString());
			activity.setType(type);
			activity.setStatus(statusSelector.getText());
			activity.setGrade(Float.parseFloat(gradeSelector.getText()));
			activity.setWeight(Float.parseFloat(weightSelector.getText()));
		}
		
		// Adiciona a atividade e limpa os seletores
		currentSemester.addActivity(activity);
		activity = null;
		clean();
	}
	
	
	// Atualiza o semestre atual
	public void setCurrentSemester(SemesterController currentSemester) {
		this.currentSemester = currentSemester;
	}
}
