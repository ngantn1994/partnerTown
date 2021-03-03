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

public class HomeDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	private static final String TITLE = "Thay \u0111\u1ed5i m\u1eadt kh\u1ea9u";
	private static final String PASSWORD = "M\u1EADt kh\u1EA9u hi\u1EC7n t\u1EA1i:";
	private static final String NEWPASSWORD = "M\u1EADt kh\u1EA9u m\u1EDBi:";
	private static final String RETYPENEWPASSWORD = "Nh\u1EADp l\u1EA1i m\u1EADt kh\u1EA9u m\u1EDBi:";
	
	private static final Font BIGGER_FONT = new Font(Font.SERIF, Font.BOLD, 30);
	private static final Font SMALLER_FONT = new Font(Font.SERIF, Font.PLAIN, 20);
	private int fgValue = Integer.parseInt( "F3F781", 16);
	private Color fgColor = new Color(fgValue);
	private int bgValue = Integer.parseInt( "870001", 16);
	private Color bgColor = new Color(bgValue);
	
	private StringPasswordField oldPassword;
	private StringPasswordField newPassword;
	private StringPasswordField retypeNewPassword;
	private BufferedImageButton saveButton;
	private BufferedImageButton exitButton;
	
	private static final String SAVE1 = "images/home/save1.png";
	private static final String SAVE2 = "images/home/save2.png";
	private static final String EXIT1 = "images/home/exit1.png";
	private static final String EXIT2 = "images/home/exit2.png";
	
	public HomeDialog(){
		setTitle(TITLE);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(350, 50, 600, 265);

		JPanel contentPanel = new JPanel(new FlowLayout());
		contentPanel.setPreferredSize(new Dimension(600, 225));
		contentPanel.setBackground(bgColor);
		contentPanel.setForeground(fgColor);
		
		JLabel header = new JLabel(TITLE, JLabel.CENTER);
		header.setFont(BIGGER_FONT);
		header.setOpaque(false);
		header.setPreferredSize(new Dimension(580,50));
		header.setForeground(fgColor);
		contentPanel.add(header);
		
		JLabel oldPasswordLabel = new JLabel(PASSWORD, JLabel.CENTER);
		oldPasswordLabel.setOpaque(false);
		oldPasswordLabel.setFont(SMALLER_FONT);
		oldPasswordLabel.setPreferredSize(new Dimension(230, 35));
		oldPasswordLabel.setForeground(fgColor);
		contentPanel.add(oldPasswordLabel);
		
		oldPassword = new StringPasswordField();
		oldPassword.setFont(SMALLER_FONT);
		oldPassword.setPreferredSize(new Dimension(350, 35));
		contentPanel.add(oldPassword);
		
		JLabel newPasswordLabel = new JLabel(NEWPASSWORD, JLabel.CENTER);
		newPasswordLabel.setOpaque(false);
		newPasswordLabel.setFont(SMALLER_FONT);
		newPasswordLabel.setPreferredSize(new Dimension(230, 35));
		newPasswordLabel.setForeground(fgColor);
		contentPanel.add(newPasswordLabel);
		
		newPassword = new StringPasswordField();
		newPassword.setFont(SMALLER_FONT);
		newPassword.setPreferredSize(new Dimension(350, 35));
		contentPanel.add(newPassword);
		
		JLabel retypeNewPasswordLabel = new JLabel(RETYPENEWPASSWORD, JLabel.CENTER);
		retypeNewPasswordLabel.setOpaque(false);
		retypeNewPasswordLabel.setFont(SMALLER_FONT);
		retypeNewPasswordLabel.setPreferredSize(new Dimension(230, 35));
		retypeNewPasswordLabel.setForeground(fgColor);
		contentPanel.add(retypeNewPasswordLabel);
		
		retypeNewPassword = new StringPasswordField();
		retypeNewPassword.setFont(SMALLER_FONT);
		retypeNewPassword.setPreferredSize(new Dimension(350, 35));
		contentPanel.add(retypeNewPassword);
		
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
	
	public String getOldPassword(){
		return oldPassword.getValue();
	}
	
	public String getNewPassword(){
		return newPassword.getValue();
	}
	
	public String getRetypePassword(){
		return retypeNewPassword.getValue();
	}
	
	public void addSaveButtonActionListener(ActionListener listener){
		saveButton.addActionListener(listener);
	}
	
	public void addExitButtonActionListener(ActionListener listener){
		exitButton.addActionListener(listener);
	}
}
