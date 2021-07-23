package GUI.content;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
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
		ContentGUI content
	) throws IOException {

		// Tamanho e localização
		this.setSize(1024, 640);
		this.setLocation(60, 60);
		
		// Operações de fechamento e de redimensionamento
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		// Menu superior
		this.add(topMenu);
		
		// Quadro inferior
		JPanel bottomPanel = new JPanel(new BorderLayout());
		bottomPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		bottomPanel.add(leftMenu, BorderLayout.LINE_START);
		bottomPanel.add(content, BorderLayout.CENTER);
		this.add(bottomPanel);
	}
}
