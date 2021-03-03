package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RenameDialog extends JDialog {
	
	private static final long serialVersionUID = 1L;

	private static final String TITLE = "\u0110\u1ED5i tên partner";
	private static final String RENAME = "Tên m\u1EDBi:";
	
	private static final Font BIGGER_FONT = new Font(Font.SERIF, Font.BOLD, 30);
	private static final Font SMALLER_FONT = new Font(Font.SERIF, Font.PLAIN, 20);
	private int fgValue = Integer.parseInt( "FED7D8", 16);
	private Color fgColor = new Color(fgValue);
	private int bgValue = Integer.parseInt( "88593E", 16);
	private Color bgColor = new Color(bgValue);
	
	private JTextField renameField;
	private BufferedImageButton saveButton;
	private BufferedImageButton exitButton;
	
	private static final String SAVE1 = "images/home/save1.png";
	private static final String SAVE2 = "images/home/save2.png";
	private static final String EXIT1 = "images/home/exit1.png";
	private static final String EXIT2 = "images/home/exit2.png";
	
	public RenameDialog(){
		setTitle(TITLE);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(350, 50, 500, 185);

		JPanel contentPanel = new JPanel(new FlowLayout());
		contentPanel.setPreferredSize(new Dimension(500, 160));
		contentPanel.setBackground(bgColor);
		contentPanel.setForeground(fgColor);
		
		JLabel header = new JLabel(TITLE, JLabel.CENTER);
		header.setFont(BIGGER_FONT);
		header.setOpaque(false);
		header.setPreferredSize(new Dimension(480,50));
		header.setForeground(fgColor);
		contentPanel.add(header);
		
		JLabel renameLabel = new JLabel(RENAME, JLabel.CENTER);
		renameLabel.setOpaque(false);
		renameLabel.setFont(SMALLER_FONT);
		renameLabel.setPreferredSize(new Dimension(130, 35));
		renameLabel.setForeground(fgColor);
		contentPanel.add(renameLabel);
		
		renameField = new JTextField();
		renameField.setFont(SMALLER_FONT);
		renameField.setPreferredSize(new Dimension(350, 35));
		contentPanel.add(renameField);
			
		JPanel buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		buttonPanel.setPreferredSize(new Dimension(320, 50));
		buttonPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		saveButton = new BufferedImageButton(SAVE1, SAVE2, 150, 50);
		buttonPanel.add(saveButton);
		
		exitButton = new BufferedImageButton(EXIT1, EXIT2, 150, 50);
		buttonPanel.add(exitButton);
		
		contentPanel.add(buttonPanel);
		
		setContentPane(contentPanel);
	}
	
	public String getNewName(){
		return renameField.getText();
	}
	
	public void addSaveButtonActionListener(ActionListener listener){
		saveButton.addActionListener(listener);
	}
	
	public void addExitButtonActionListener(ActionListener listener){
		exitButton.addActionListener(listener);
	}

}
