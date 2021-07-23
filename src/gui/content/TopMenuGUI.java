package gui.content;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.EmptyBorder;

import utils.ImageResizer;

/** Quadro de menu superior da aplicação. */
public class TopMenuGUI extends JMenuBar {
		
	// Atributos do quadro
	private static final long serialVersionUID = 2L;
	private JLabel userLabel;
	private JMenu semesterMenu;
	private int semestersAmount = 0;

	// Construtor do menu
	public TopMenuGUI(String userName) throws IOException {
		
		// Layout de fluxo
		this.setLayout(new BorderLayout());
		
		// Cor de fundo
		this.setBackground(Color.BLACK);
		
		// Tamanho da janela
		this.setSize(1024, 50);
		
		// Alinha à direita
		JLabel aligner = new JLabel();
		aligner.setBorder(new EmptyBorder(0, 420, 0, 0));
		this.add(aligner, BorderLayout.LINE_START);
				
		// Mostrador de semestres
		semesterMenu = new JMenu("Semestre X");
		semesterMenu.setForeground(Color.WHITE);
		semesterMenu.setFont(new Font(semesterMenu.getFont().getName(), Font.BOLD, 18));
		this.add(semesterMenu, BorderLayout.CENTER);
	
		// Mostrador de usuário
		URL userIconURL = getClass().getResource("../images/user.png");
		ImageIcon userIcon = ImageResizer.getAndResize(userIconURL, userName, 25, 25);
		userLabel = new JLabel(userName, userIcon, JLabel.CENTER);
		userLabel.setForeground(Color.WHITE);
		userLabel.setBorder(new EmptyBorder(0, 30, 0, 30));
		this.add(userLabel, BorderLayout.LINE_END);
	}
	
	
	// Mudança de nome de usuário
	public void setUserName(String userName) {
		userLabel.setText(userName);
	}
	
	
	// Adição de semestre
	public void addSemester() {
		++semestersAmount;
		String semesterName = "Semestre " + semestersAmount;
		JMenuItem semester = new JMenuItem(semesterName);
		semester.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {	
				semesterMenu.setText(semesterName);
			}
		});
		semesterMenu.add(semester);
	}
}
