package gui.content;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import generic.collections.Treap;
import gui.listeners.AddDisciplineButtonListener;
import gui.listeners.ConfirmDisciplineButtonListener;

/** Painel de adi��o de disciplina */
public class DisciplineAdderGUI extends JPanel {

	private JButton btnAdd = new JButton("Adicionar disciplina");
	private JTextField nameField = new JTextField();
	private JTextField codeField = new JTextField();
	private JComboBox<String> cbMean;
	private MainGUI mainGUI;
	private JPanel offeringPanel;
	private Vector<JTextField> hours = new Vector<JTextField>();
	private Vector<JTextField> minutes = new Vector<JTextField>();
	private Vector<JComboBox<String>> days = new Vector<JComboBox<String>>();


	// Construtor do painel
	public DisciplineAdderGUI(MainGUI mainGUI) {

		this.mainGUI = mainGUI;

		// Layout vertical
		//this.setBorder(new EmptyBorder(70, 20, 0, 0));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// R�tulo do quadro
		JLabel mainLabel = new JLabel("Adicionar materia ao semestre");
		mainLabel.setForeground(Color.WHITE);
		mainLabel.setFont(new Font(mainLabel.getFont().getName(), Font.BOLD, 14));
		
		// Painel de rotula��o do quadro
		JPanel labelPanel = new JPanel();
		labelPanel.setBackground(Color.BLACK);
		labelPanel.setMaximumSize(new Dimension(760, 40));
		labelPanel.add(mainLabel);
		this.add(labelPanel);
		
		JPanel meanPanel = new JPanel();
		meanPanel.setLayout(new FlowLayout());
		meanPanel.setMaximumSize(new Dimension(760, 60));
		JLabel meanLabel = new JLabel("Tipo de cálculo de média:");
		String[] meanTypes = {"Média Aritmética", "Média Harmônica"};
		this.cbMean = new JComboBox<String>(meanTypes);
		meanPanel.add(meanLabel);
		meanPanel.add(cbMean);
		this.add(meanPanel);
		
		JPanel textForm = new JPanel();
		textForm.setLayout(new GridLayout(0, 2, 5, 10));
		textForm.setBorder(new EmptyBorder(10, 0, 0, 0));
		textForm.setMaximumSize(new Dimension(760, 100));

		JLabel lblDisciplineName = new JLabel("Nome da disciplina:");
		
		
		nameField.setMaximumSize(new Dimension(760, 60));

		textForm.add(lblDisciplineName);
		textForm.add(this.nameField);

		JLabel lblDisciplineCode = new JLabel("Codigo da disciplina:");
		
		codeField.setMaximumSize(new Dimension(760, 300));

		this.btnAdd.addActionListener(new ConfirmDisciplineButtonListener(this, this.mainGUI));

		//Secao de horarios de oferecimento
		textForm.add(lblDisciplineCode);
		textForm.add(this.codeField);
		this.add(textForm);


		offeringPanel = new JPanel();
		offeringPanel.setLayout(new BoxLayout(offeringPanel, BoxLayout.Y_AXIS));
		offeringPanel.setMaximumSize(new Dimension(760, 760));
		offeringPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
		
		

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
