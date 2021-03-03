package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

import model.User;

public class SignUp extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private static final Font BIGGER_FONT = new Font(Font.SERIF, Font.BOLD, 30);
	private static final Font SMALLER_FONT = new Font(Font.SERIF, Font.PLAIN, 20);
	private int fgValue1 = Integer.parseInt( "F3F781", 16);
	private Color fgColor1 = new Color(fgValue1);
	private int fgValue2 = Integer.parseInt( "870001", 16);
	private Color fgColor2 = new Color(fgValue2);
	
	private static final String TITLE = "\u0110\u0103ng k\u00fd";
	private static final String HEADER1 = "Th\u00f4ng tin t\u00e0i kho\u1ea3n";
	private static final String USERNAME = "T\u00ean \u0111\u0103ng nh\u1eadp";
	private static final String PASSWORD = "M\u1eadt kh\u1ea9u";
	private static final String RETYPE = "Nh\u1eadp l\u1ea1i m\u1eadt kh\u1ea9u";
	private static final String HEADER2 = "Th\u00f4ng tin c\u00e1 nh\u00e2n";
	private static final String EMAIL = "E-mail";
	private static final String ADRESS = "\u0110\u1ecba ch\u1ec9";
	private static final String SEX = "Gi\u1edbi t\u00ednh";
	private static final String MALE = "Nam";
	private static final String FEMALE = "N\u1eef";
	
	private static final String BGIMG = "images/signup/register.png";
	private static final String TITLEIMG = "images/signup/title.png";
	private static final String DONEIMG1 = "images/signup/done1.png";
	private static final String DONEIMG2 = "images/signup/done2.png";
	private static final String REDOIMG1 = "images/signup/redo1.png";
	private static final String REDOIMG2 = "images/signup/redo2.png";
	
	private JTextField usernameTextField;
	private StringPasswordField passwordField;
	private StringPasswordField retypePasswordField;
	private JTextField emailTextField;
	private JTextField addressTextField;
	private JRadioButton maleRB;
	private JRadioButton femaleRB;
	private BufferedImageButton doneButton;
	private BufferedImageButton redoButton;
	
	private static SignUp signUp = new SignUp();
	
	private SignUp(){
		setTitle(TITLE);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(350, 50, 500, 570);
		
		ImagePanel bgPanel = new ImagePanel(BGIMG);
		bgPanel.setPreferredSize(new Dimension(500,570));
		bgPanel.setForeground(fgColor1);
		
		setContentPane(bgPanel);
		bgPanel.setLayout(new BorderLayout(0, 0));
		
		ImageIcon titleImg = new ImageIcon(getClass().getResource(TITLEIMG));
		JLabel titleLabel = new JLabel(titleImg, JLabel.CENTER);
		titleLabel.setPreferredSize(new Dimension(500,120));
		titleLabel.setOpaque(false);
		bgPanel.add(titleLabel, BorderLayout.NORTH);
		
		JPanel bodyPanel = new JPanel(new FlowLayout());
		bodyPanel.setOpaque(false);
		
		JLabel header1Label = new JLabel(HEADER1, JLabel.CENTER);
		header1Label.setOpaque(false);
		header1Label.setFont(BIGGER_FONT);
		header1Label.setForeground(fgColor1);
		header1Label.setPreferredSize(new Dimension(500, 50));
		bodyPanel.add(header1Label);
		
		JLabel usernameLabel = new JLabel(USERNAME, JLabel.CENTER);
		usernameLabel.setOpaque(false);
		usernameLabel.setFont(SMALLER_FONT);
		usernameLabel.setForeground(fgColor1);
		usernameLabel.setPreferredSize(new Dimension(180, 35));
		bodyPanel.add(usernameLabel);
		
		usernameTextField = new JTextField();
		usernameTextField.setFont(SMALLER_FONT);
		usernameTextField.setForeground(fgColor2);
		usernameTextField.setPreferredSize(new Dimension(300, 35));
		bodyPanel.add(usernameTextField);
		
		JLabel passwordLabel = new JLabel(PASSWORD, JLabel.CENTER);
		passwordLabel.setOpaque(false);
		passwordLabel.setFont(SMALLER_FONT);
		passwordLabel.setForeground(fgColor1);
		passwordLabel.setPreferredSize(new Dimension(180, 35));
		bodyPanel.add(passwordLabel);
		
		passwordField = new StringPasswordField();
		passwordField.setFont(SMALLER_FONT);
		passwordField.setForeground(fgColor2);
		passwordField.setPreferredSize(new Dimension(300, 35));
		bodyPanel.add(passwordField);
		
		JLabel retypepasswordLabel = new JLabel(RETYPE, JLabel.CENTER);
		retypepasswordLabel.setOpaque(false);
		retypepasswordLabel.setFont(SMALLER_FONT);
		retypepasswordLabel.setForeground(fgColor1);
		retypepasswordLabel.setPreferredSize(new Dimension(180,35));
		bodyPanel.add(retypepasswordLabel);
		
		retypePasswordField = new StringPasswordField();
		retypePasswordField.setFont(SMALLER_FONT);
		retypePasswordField.setForeground(fgColor2);
		retypePasswordField.setPreferredSize(new Dimension(300, 35));
		bodyPanel.add(retypePasswordField);
		
		JLabel header2Label = new JLabel(HEADER2, JLabel.CENTER);
		header2Label.setOpaque(false);
		header2Label.setFont(BIGGER_FONT);
		header2Label.setForeground(fgColor1);
		header2Label.setPreferredSize(new Dimension(500, 50));
		bodyPanel.add(header2Label);
		
		JLabel emailLabel = new JLabel(EMAIL, JLabel.CENTER);
		emailLabel.setOpaque(false);
		emailLabel.setFont(SMALLER_FONT);
		emailLabel.setForeground(fgColor1);
		emailLabel.setPreferredSize(new Dimension(180, 35));
		bodyPanel.add(emailLabel);
		
		emailTextField = new JTextField();
		emailTextField.setFont(SMALLER_FONT);
		emailTextField.setForeground(fgColor2);
		emailTextField.setPreferredSize(new Dimension(300, 35));
		bodyPanel.add(emailTextField);
		
		JLabel addressLabel = new JLabel(ADRESS, JLabel.CENTER);
		addressLabel.setOpaque(false);
		addressLabel.setFont(SMALLER_FONT);
		addressLabel.setForeground(fgColor1);
		addressLabel.setPreferredSize(new Dimension(180, 35));
		bodyPanel.add(addressLabel);
		
		addressTextField = new JTextField();
		addressTextField.setFont(SMALLER_FONT);
		addressTextField.setForeground(fgColor2);
		addressTextField.setPreferredSize(new Dimension(300, 35));
		bodyPanel.add(addressTextField);
		
		JLabel sexLabel = new JLabel(SEX, JLabel.CENTER);
		sexLabel.setOpaque(false);
		sexLabel.setFont(SMALLER_FONT);
		sexLabel.setForeground(fgColor1);
		sexLabel.setPreferredSize(new Dimension(180, 35));
		bodyPanel.add(sexLabel);
		
		JPanel sexPanel = new JPanel();
		sexPanel.setOpaque(false);
		sexPanel.setPreferredSize(new Dimension(300, 35));
		sexPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		ButtonGroup group = new ButtonGroup();
		
		maleRB = new JRadioButton(MALE);
		maleRB.setSelected(true);
		maleRB.setOpaque(false);
		maleRB.setFont(SMALLER_FONT);
		maleRB.setForeground(fgColor2);
		group.add(maleRB);
		sexPanel.add(maleRB);
		
		femaleRB = new JRadioButton(FEMALE);
		femaleRB.setOpaque(false);
		femaleRB.setFont(SMALLER_FONT);
		femaleRB.setForeground(fgColor2);
		group.add(femaleRB);
		sexPanel.add(femaleRB);
		
		bodyPanel.add(sexPanel);
		
		bgPanel.add(bodyPanel, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		buttonPanel.setPreferredSize(new Dimension(300, 70));
		buttonPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		doneButton = new BufferedImageButton(DONEIMG1, DONEIMG2, 200, 80);
		buttonPanel.add(doneButton);
		
		redoButton = new BufferedImageButton(REDOIMG1, REDOIMG2, 200, 80);
		buttonPanel.add(redoButton);
		
		bgPanel.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	public static SignUp getInstance(){
		return signUp;
	}

	public void addDoneButtonListener(ActionListener listener){
		doneButton.addActionListener(listener);
	}
	
	public void addRedoButtonListener(ActionListener listener){
		redoButton.addActionListener(listener);
	}
	
	public String getUserName(){
		return usernameTextField.getText() != null ? usernameTextField.getText() : "";
	}
	
	public int isMatchPassword(){
		int temp = passwordField.getLength();
		String s = passwordField.getValue();
		if(temp<6 || temp >16){
			return 1;
		}
		for(int i=0;i<temp;i++){
			if(s.charAt(i) == ' '){
				return 2;
			}
		}
		if(passwordField.isMatch(retypePasswordField.getValue()) == false){
			return 3;
		}
		return 0;
	}
	
	public User getUser(){
		return new User(usernameTextField.getText(), passwordField.getValue(), emailTextField.getText(), 
				addressTextField.getText(), maleRB.isSelected(), 0, 900, 50);
	}
	
	public void redoAllField(){
		usernameTextField.setText("");
		passwordField.setText("");
		retypePasswordField.setText("");
		emailTextField.setText("");
		addressTextField.setText("");
		maleRB.setSelected(true);
	}
}
