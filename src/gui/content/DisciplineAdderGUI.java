package gui.content;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import gui.listeners.ConfirmDisciplineButtonListener;

/** Painel de adição de disciplina */
public class DisciplineAdderGUI extends JPanel {

	// Atributos
	private static final long serialVersionUID = 10L;
	private JButton btnAdd = new JButton("Adicionar disciplina");
	private JTextField nameField = new JTextField();
	private JTextField codeField = new JTextField();
	private JComboBox<String> cbMean;
	private JPanel offeringPanel;
	private Vector<JTextField> hours = new Vector<JTextField>();
	private Vector<JTextField> minutes = new Vector<JTextField>();
	private Vector<JComboBox<String>> days = new Vector<JComboBox<String>>();


	// Construtor do painel
	public DisciplineAdderGUI(LeftMenuGUI leftMenu, CentralPanelGUI centralPanel) {

		// Layout vertical
		this.setBorder(new EmptyBorder(65, 0, 0, 0));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// Rótulo do quadro
		JLabel mainLabel = new JLabel("Adicionar disciplina ao semestre", JLabel.CENTER);
		mainLabel.setForeground(Color.WHITE);
		mainLabel.setFont(new Font(mainLabel.getFont().getName(), Font.BOLD, 14));
		
		// Painel de rotulação do quadro
		JPanel labelPanel = new JPanel(new BorderLayout());
		labelPanel.setBackground(Color.BLACK);
		labelPanel.setMaximumSize(new Dimension(760, 30));
		labelPanel.add(mainLabel, BorderLayout.CENTER);
		this.add(labelPanel);
		
		// Painel da média
		JPanel meanPanel = new JPanel(new FlowLayout());
		meanPanel.setBackground(Color.LIGHT_GRAY);
		meanPanel.setMaximumSize(new Dimension(760, 60));
		JLabel meanLabel = new JLabel("Tipo de cálculo de média:", JLabel.CENTER);
		String[] meanTypes = {"Média Aritmética", "Média Ponderada", "Média Harmônica"};
		this.cbMean = new JComboBox<String>(meanTypes);
		meanPanel.add(meanLabel);
		meanPanel.add(cbMean);
		this.add(meanPanel);
		
		// 
		JPanel textForm = new JPanel();
		textForm.setBackground(Color.LIGHT_GRAY);
		textForm.setLayout(new GridLayout(0, 2, 2, 5));
		textForm.setMaximumSize(new Dimension(760, 70));

		JLabel lblDisciplineName = new JLabel("Nome da disciplina:");
		
		
		nameField.setMaximumSize(new Dimension(760, 30));
		nameField.add(lblDisciplineName);

		textForm.add(lblDisciplineName);
		textForm.add(this.nameField);

		JLabel lblDisciplineCode = new JLabel("Código da disciplina:");
		
		codeField.setMaximumSize(new Dimension(760, 30));

		this.btnAdd.addActionListener(new ConfirmDisciplineButtonListener(leftMenu, centralPanel, this));

		//Secao de horarios de oferecimento
		textForm.add(lblDisciplineCode);
		textForm.add(this.codeField);
		this.add(textForm);

		
		// Painel de oferecimentos
		offeringPanel = new JPanel();
		offeringPanel.setBackground(Color.LIGHT_GRAY);
		offeringPanel.setLayout(new BoxLayout(offeringPanel, BoxLayout.Y_AXIS));
		JLabel offeringLabel = new JLabel("Data e horários de oferecimento:");
		offeringPanel.add(offeringLabel);
		this.add(offeringPanel);
		this.addOffering();
		this.add(this.btnAdd);
	}

	public void addOffering()
	{
		String[] days = {"segunda-feira", "terça-feira", "quarta-feira", "quinta-feira", "sexta-feira", "sabado", "domingo"};
		JLabel lblDay = new JLabel("Dia da semana:");
		JLabel lblBegining = new JLabel("Horário de início");
		JLabel lblEnd = new JLabel("fim:");
		JLabel lblColon = new JLabel(":");

		JTextField txtBegHour = new JTextField(2);
		JTextField txtBegMinutes = new JTextField(2);
		
		JTextField txtEndHour = new JTextField(2);
		txtEndHour.setBorder(new EmptyBorder(0, 5, 0, 0));
		JTextField txtEndMinutes = new JTextField(2);
		
		JComboBox<String> cbDays = new JComboBox<String>(days);
		
		
		JPanel newOfferingPanel = new JPanel();
		newOfferingPanel.setLayout(new BoxLayout(newOfferingPanel, BoxLayout.Y_AXIS));
		newOfferingPanel.setMaximumSize(new Dimension(760, 100));
		
		JPanel hourPanel = new JPanel();
		hourPanel.setLayout(new FlowLayout());
		hourPanel.add(lblBegining);
		hourPanel.add(txtBegHour);
		hourPanel.add(lblColon);
		hourPanel.add(txtBegMinutes);
		
		hourPanel.add(lblEnd);
		hourPanel.add(txtEndHour);
		hourPanel.add(lblColon);
		hourPanel.add(txtEndMinutes);
		
		JPanel dayPanel = new JPanel();
		dayPanel.setLayout(new FlowLayout());
		dayPanel.add(lblDay);
		dayPanel.add(cbDays);
		
		this.days.add(cbDays);
		
		this.hours.add(txtBegHour);
		this.hours.add(txtEndHour);
		
		this.minutes.add(txtBegMinutes);
		this.minutes.add(txtBegHour);
		
		newOfferingPanel.add(dayPanel);
		newOfferingPanel.add(hourPanel);

		this.offeringPanel.add(newOfferingPanel);		
	}

	public String getDisciplineName(){
		String text = "";
		try{
			text = this.nameField.getText();
			return text;
		}
		catch(Exception e)
		{
			return "";
		}
	}

	public String getDisciplineCode(){
		String text = "";
		try{
			text = this.codeField.getText();
			return text;
		}
		catch(Exception e)
		{
			return "";
		}
	}
	
	public String getSelectedMeanType()
	{
		return this.cbMean.getSelectedItem().toString();
	}
	
	public Vector<JTextField> getHoursVector()
	{
		return this.hours;
	}
	
	public Vector<JTextField> getMinutesVector()
	{
		return this.minutes;
	}

	public Vector<JComboBox<String>> getDaysVector()
	{
		return this.days;
	}
	public void clearInputs()
	{
		this.codeField.setText("");
		this.nameField.setText("");
	}
}
