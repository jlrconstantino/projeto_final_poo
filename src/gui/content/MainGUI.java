package gui.content;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

/** Quadro principal da aplicação. */
public class MainGUI extends JFrame {

	// ID do quadro
	private static final long serialVersionUID = 1L;
	
	// Construtor do quadro
	public MainGUI (
		TopMenuGUI topMenu, 
		LeftMenuGUI leftMenu, 
		CentralPanelGUI centralPanel
	) throws IOException {

		// Tamanho e localização da janela
		this.setSize(1024, 640);
		this.setLocation(60, 60);
		
		// Operações de fechamento e de redimensionamento
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		// Menu superior
		this.add(topMenu);

		// Quadro inferior
		JPanel bottomPanel = new JPanel(new BorderLayout());
		
		// Menu lateral
		bottomPanel.add(leftMenu, BorderLayout.LINE_START);
		
		// Painel central
		bottomPanel.add(centralPanel, BorderLayout.CENTER);
		
		// Adição do quadro inferior
		this.add(bottomPanel);
	}
}
