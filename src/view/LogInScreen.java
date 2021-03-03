package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Log In Frame of the Program.
 * Including Username field, Password Field and buttons.
 * 
 * @author Fuuka_Adachi
 */

public class LogInScreen extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private static final Font SMALLER_FONT = new Font(Font.SERIF, Font.PLAIN, 20);

	private JTextField usernameTextfield;
	private StringPasswordField passwordField;
	
	private BufferedImageButton logInButton;
	private BufferedImageButton registerButton;
	
	private static LogInScreen screen = new LogInScreen();
	
	private static final String BGIMAGE = "images/login/login_background.png";
	private static final String BANNER_IMG = "images/login/banner.png";
	private static final String USERNAMEFIELD_IMG = "images/login/usernamefield.png";
	private static final String PASSWORDFIELD_IMG = "images/login/passwordfield.png";
	private static final String LOGIN_IMG1 = "images/login/login_1.png";
	private static final String LOGIN_IMG2 = "images/login/login_2.png";
	private static final String REGISTER_IMG1 = "images/login/register_1.png";
	private static final String REGISTER_IMG2 = "images/login/register_2.png";
		
	private static final String LOGIN = "\u0110\u0103ng nh\u1eadp";
	
	private LogInScreen(){
		this.setResizable(false);
		this.setTitle(LOGIN);
		this.setBounds(150, 5, 1000, 720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		ImagePanel bgPanel = new ImagePanel(BGIMAGE);
		bgPanel.setLayout(new FlowLayout());
		
		ImageIcon bannerImg = new ImageIcon(getClass().getResource(BANNER_IMG));
		JLabel bannerLabel = new JLabel(bannerImg);
		bannerLabel.setPreferredSize(new Dimension(1000,350));
		bannerLabel.setOpaque(false);
		bgPanel.add(bannerLabel);
				
		JPanel bodyPanel = new JPanel(new FlowLayout());
		bodyPanel.setPreferredSize(new Dimension(400, 260));
		bodyPanel.setOpaque(false);
						
		ImageIcon usernameImg = new ImageIcon(getClass().getResource(USERNAMEFIELD_IMG));
		JLabel usernameLabel = new JLabel(usernameImg);
		usernameLabel.setPreferredSize(new Dimension(400,40));
		usernameLabel.setOpaque(false);
		bodyPanel.add(usernameLabel);
		
		usernameTextfield = new JTextField();
		usernameTextfield.setFont(SMALLER_FONT);
		usernameTextfield.setPreferredSize(new Dimension(400,40));
		bodyPanel.add(usernameTextfield);
		
		ImageIcon passwordImg = new ImageIcon(getClass().getResource(PASSWORDFIELD_IMG));
		JLabel passwordLabel = new JLabel(passwordImg);
		passwordLabel.setPreferredSize(new Dimension(400,40));
		passwordLabel.setOpaque(false);
		bodyPanel.add(passwordLabel);
		
		passwordField = new StringPasswordField();
		passwordField.setFont(SMALLER_FONT);
		passwordField.setPreferredSize(new Dimension(400,40));
		bodyPanel.add(passwordField);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		buttonPanel.setPreferredSize(new Dimension(400,75));
		buttonPanel.setLayout(new GridLayout(1,2));
		
		logInButton = new BufferedImageButton(LOGIN_IMG1, LOGIN_IMG2,200,75);
		buttonPanel.add(logInButton);
		
		registerButton = new BufferedImageButton(REGISTER_IMG1,REGISTER_IMG2,200,75);
		buttonPanel.add(registerButton);
		
		bodyPanel.add(buttonPanel);
		
		bgPanel.add(bodyPanel);
				
		getRootPane().setDefaultButton(logInButton);
		
		this.setContentPane(bgPanel);
	}
	
	public static LogInScreen getInstance(){
		return screen;
	}

	public String getUsername(){
		return usernameTextfield.getText() != null ? usernameTextfield.getText() : "";
	}
	
	public StringPasswordField getPassword(){
		return passwordField;
	}
	
	public void addLogInButtonListener(ActionListener listener){
		logInButton.addActionListener(listener);
	}
	
	public void addRegisterButtonListener(ActionListener listener){
		registerButton.addActionListener(listener);
	}

}
