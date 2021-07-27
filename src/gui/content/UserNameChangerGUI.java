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

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/** Interface de alteração de nome de usuário. */
public class UserNameChangerGUI extends JPanel implements ActionListener {

	// ID
	private static final long serialVersionUID = 12L;
	
	// Mantém referência para o menu superior
	private TopMenuGUI topMenu;
	
	// Campo de inserção do novo nome
	private JTextField textField;

	// Construtor do painel
	public UserNameChangerGUI() {
		
		// Características do painel
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(new EmptyBorder(18, 0, 0, 0));
		
		// Rótulo do quadro
		JLabel mainLabel = new JLabel("Alterar nome de usuário");
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
		wrapper.setPreferredSize(new Dimension(470, 75));
		wrapper.setMaximumSize(new Dimension(470, 75));
		this.add(wrapper);
		
		// Determina as regras de inserção no envelope
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(2, 0, 2, 0);
		
		// Campo de texto
		JPanel textFieldPanel = new JPanel(new BorderLayout());
		textFieldPanel.setPreferredSize(new Dimension(460, 30));
		textField = new JTextField();
		textField.setBackground(new Color(220, 220, 220));
		textFieldPanel.add(textField, BorderLayout.CENTER);
		wrapper.add(textFieldPanel, gbc);
		
		// Botão de alterar nome
		JLabel buttonLabel = new JLabel("Alterar", JLabel.CENTER);
		JButton button = new JButton();
		button.setLayout(new BorderLayout());
		button.setBackground(new Color(160, 160, 160));
		button.addActionListener(this);
		button.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		button.setPreferredSize(new Dimension(460, 35));
		button.add(buttonLabel, BorderLayout.CENTER);
		
		// Painel do botão adicionador de atividades
		JPanel buttonPanel = new JPanel(new BorderLayout());
		buttonPanel.add(button, BorderLayout.CENTER);
		wrapper.add(buttonPanel, gbc);
	}
	
	
	// Necessário para adicionar referência ao menu superior
	public void setTopMenu(TopMenuGUI topMenu) {
		this.topMenu = topMenu;
	}
	
	
	// Adiciona texto personalizado ao campo seletor
	public void setText(String text) {
		textField.setText(text);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(topMenu != null) {
			topMenu.setUserName(textField.getText());
		}
	}
}
