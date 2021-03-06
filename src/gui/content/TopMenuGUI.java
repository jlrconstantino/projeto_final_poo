package gui.content;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.SemesterController;
import gui.listeners.SemesterCreatorListener;
import gui.listeners.SemesterSelectionListener;
import gui.listeners.UserNameChangerListener;
import utils.ImageResizer;

/** Quadro de menu superior da aplicação. */
public class TopMenuGUI extends JMenuBar {
		
	// Constante de identificação
	private static final long serialVersionUID = 2L;
	
	// Referências para demais GUIs
	private LeftMenuGUI leftMenu;
	private ContentGUI content;
	private CentralPanelGUI centralPanel;
	
	// Atributos do painel
	private JLabel userLabel;
	private JMenu semesterMenu;
	private int semestersAmount = 0;

	// Construtor do menu
	public TopMenuGUI(
		LeftMenuGUI leftMenu, 
		ContentGUI content, 
		CentralPanelGUI centralPanel, 
		UserNameChangerGUI userNameChangerGUI, 
		String userName
	) throws IOException {
		
		// Captura das referências
		this.leftMenu = leftMenu;
		this.content = content;
		this.centralPanel = centralPanel;
		
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
		
		// Opção de adicionar semestre
		JMenuItem semesterCreator = new JMenuItem("Novo...");
		semesterCreator.addActionListener(new SemesterCreatorListener(content, this, centralPanel));
		semesterMenu.addSeparator();
		semesterMenu.add(semesterCreator);
	
		// Nome de usuário
		URL userIconURL = getClass().getResource("../images/user.png");
		ImageIcon userIcon = ImageResizer.getAndResize(userIconURL, userName, 25, 25);
		userLabel = new JLabel(userName, userIcon, JLabel.CENTER);
		userLabel.setForeground(Color.WHITE);
		
		// Botão de modificação de usuário
		JButton button = new JButton();
		button.setLayout(new BorderLayout());
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setPreferredSize(new Dimension(240, 30));
		button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		button.add(userLabel, BorderLayout.CENTER);
		button.addActionListener(new UserNameChangerListener(centralPanel, userNameChangerGUI, userLabel));
		
		// Painel de usuário
		JPanel userPanel = new JPanel(new BorderLayout());
		userPanel.setBackground(Color.BLACK);
		userPanel.setMaximumSize(new Dimension(240, 30));
		userPanel.add(button, BorderLayout.CENTER);
		this.add(userPanel, BorderLayout.LINE_END);
	}
	
	
	// Mudança de nome de usuário
	public void setUserName(String userName) {
		userLabel.setText(userName);
	}
	
	
	// Visualização de um semestre
	private void showSemester(SemesterController semester, String name) {
		centralPanel.showContent();
		leftMenu.displaySemester(semester);
		content.displaySemester(semester);
		semesterMenu.setText(name);
	}
	
	
	// Adição de semestre
	public void addSemester(SemesterController semester){
		++semestersAmount;
		String semesterName = "Semestre " + semestersAmount;
		JMenuItem semesterButton = new JMenuItem(semesterName);
		semesterButton.addActionListener (
			new SemesterSelectionListener(
				semester, 
				leftMenu, 
				content, 
				centralPanel, 
				semesterMenu, 
				semesterName
			)
		);
		semesterMenu.insert(semesterButton, 0);
		showSemester(semester, semesterName);
	}
}
