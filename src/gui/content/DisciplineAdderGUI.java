package gui.content;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import gui.listeners.AddDisciplineButtonListener;
import gui.listeners.ConfirmDisciplineButtonListener;

/** Painel de adi��o de disciplina */
public class DisciplineAdderGUI extends JPanel {

	private JButton btnAdd = new JButton("Adicionar disciplina");

	// Construtor do painel
	public DisciplineAdderGUI() {

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
		
		JPanel textForm = new JPanel();
		textForm.setLayout(new GridLayout(0, 2, 5, 10));
		textForm.setBorder(new EmptyBorder(10, 0, 0, 0));
		textForm.setMaximumSize(new Dimension(760, 100));

		JLabel lblDisciplineName = new JLabel("Nome da disciplina:");
		
		JTextField nameField = new JTextField();
		nameField.setMaximumSize(new Dimension(760, 60));

		textForm.add(lblDisciplineName);
		textForm.add(nameField);

		JLabel lblDisciplineCode = new JLabel("Codigo da disciplina:");
		
		JTextField codeField = new JTextField();
		nameField.setMaximumSize(new Dimension(760, 60));

		textForm.add(lblDisciplineCode);
		textForm.add(codeField);
		textForm.add(btnAdd);
		

		this.add(textForm);
	}

	public void setSemester(MainGUI mainGUI){
		btnAdd.addActionListener(new ConfirmDisciplineButtonListener(mainGUI));
	}
}
