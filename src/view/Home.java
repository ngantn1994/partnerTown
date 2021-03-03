package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;

	private static final Font BIGGER_FONT = new Font(Font.SERIF, Font.BOLD, 30);
	private static final Font SMALLER_FONT = new Font(Font.SERIF, Font.PLAIN, 20);
	private int fgValue = Integer.parseInt( "870001", 16);
	private Color fgColor = new Color(fgValue);
	
	private static final String TITLE = "Nh\u00e0 ri\u00eang";
	private static final String HEADER1 = "Th\u00f4ng tin t\u00e0i kho\u1ea3n";
	private static final String HEADER2 = "Th\u00f4ng tin c\u00e1 nh\u00e2n";
	private static final String EMAIL = "E-mail";
	private static final String ADDRESS = "\u0110\u1ecba ch\u1ec9";
	private static final String SEX = "Gi\u1edbi t\u00ednh";
	private static final String MALE = "Nam";
	private static final String FEMALE = "N\u1eef";
	
	private static final String BGIMG = "images/home/background.png";
	private static final String PASSWORD1 = "images/home/password1.png";
	private static final String PASSWORD2 = "images/home/password2.png";
	private static final String SETTING1 = "images/buttons/setting1.png";
	private static final String SETTING2 = "images/buttons/setting2.png";
	private static final String INVENTORY1 = "images/buttons/inventory1.png";
	private static final String INVENTORY2 = "images/buttons/inventory2.png";
	private static final String MAP1 = "images/buttons/map1.png";
	private static final String MAP2 = "images/buttons/map2.png";
	
	private static PatternProgressBar energyBar;
	private static JPanel fixedLabel;
	
	private BufferedImageButton settingButton;
	private BufferedImageButton inventoryButton;
	private BufferedImageButton mapButton;
	
	private JTextField emailTextField;
	private JTextField addressTextField;
	private JRadioButton maleRB;
	private JRadioButton femaleRB;
	private BufferedImageButton saveButton;
	private BufferedImageButton undoButton;
	private BufferedImageButton changePasswordButton;
	
	private static final String SAVE1 = "images/home/save1.png";
	private static final String SAVE2 = "images/home/save2.png";
	private static final String UNDO1 = "images/home/undo1.png";
	private static final String UNDO2 = "images/home/undo2.png";
	
	private static Home home = new Home(View.getEnergyBar());
	
	public static Home getInstance(){
		return home;
	}
	
	private Home(PatternProgressBar bar){
		this.setResizable(false);
		this.setTitle(TITLE);
		this.setBounds(150, 5, 1000, 720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new FlowLayout());
		
		ImagePanel bgPanel = new ImagePanel(BGIMG);
		bgPanel.setLayout(new BorderLayout(0, 0));
		
		fixedLabel = new JPanel();
		fixedLabel.setBorder(new TitledBorder(new LineBorder(fgColor), "Energy", TitledBorder.CENTER, TitledBorder.TOP, null, fgColor));
		fixedLabel.setPreferredSize(new Dimension(550,100));
		fixedLabel.setOpaque(false);
		fixedLabel.setLayout(new FlowLayout());
		fixedLabel.setForeground(new Color(0, 0, 128));
		bgPanel.add(fixedLabel, BorderLayout.NORTH);
		
		energyBar = bar;
		fixedLabel.add(energyBar);

		JPanel centerPanel = new JPanel(new FlowLayout());
		centerPanel.setOpaque(false);
		centerPanel.setPreferredSize(new Dimension(900,400));
		
		JLabel emptyLabel = new JLabel();
		emptyLabel.setOpaque(false);
		emptyLabel.setPreferredSize(new Dimension(1000, 30));
		centerPanel.add(emptyLabel);
		
		JLabel header2Label = new JLabel(HEADER2, JLabel.CENTER);
		header2Label.setOpaque(false);
		header2Label.setFont(BIGGER_FONT);
		header2Label.setForeground(fgColor);
		header2Label.setPreferredSize(new Dimension(1000, 50));
		centerPanel.add(header2Label);
		
		JLabel emailLabel = new JLabel(EMAIL, JLabel.CENTER);
		emailLabel.setOpaque(false);
		emailLabel.setFont(SMALLER_FONT);
		emailLabel.setForeground(fgColor);
		emailLabel.setPreferredSize(new Dimension(380, 35));
		centerPanel.add(emailLabel);
		
		emailTextField = new JTextField();
		emailTextField.setFont(SMALLER_FONT);
		emailTextField.setForeground(fgColor);
		emailTextField.setPreferredSize(new Dimension(500, 35));
		centerPanel.add(emailTextField);
		
		JLabel addressLabel = new JLabel(ADDRESS, JLabel.CENTER);
		addressLabel.setOpaque(false);
		addressLabel.setFont(SMALLER_FONT);
		addressLabel.setForeground(fgColor);
		addressLabel.setPreferredSize(new Dimension(380, 35));
		centerPanel.add(addressLabel);
		
		addressTextField = new JTextField();
		addressTextField.setFont(SMALLER_FONT);
		addressTextField.setForeground(fgColor);
		addressTextField.setPreferredSize(new Dimension(500, 35));
		centerPanel.add(addressTextField);
		
		JLabel sexLabel = new JLabel(SEX, JLabel.CENTER);
		sexLabel.setOpaque(false);
		sexLabel.setFont(SMALLER_FONT);
		sexLabel.setForeground(fgColor);
		sexLabel.setPreferredSize(new Dimension(380, 35));
		centerPanel.add(sexLabel);
		
		JPanel sexPanel = new JPanel();
		sexPanel.setOpaque(false);
		sexPanel.setPreferredSize(new Dimension(500, 35));
		sexPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		ButtonGroup group = new ButtonGroup();
		
		maleRB = new JRadioButton(MALE);
		maleRB.setSelected(true);
		maleRB.setOpaque(false);
		maleRB.setFont(SMALLER_FONT);
		maleRB.setForeground(fgColor);
		group.add(maleRB);
		sexPanel.add(maleRB);
		
		femaleRB = new JRadioButton(FEMALE);
		femaleRB.setOpaque(false);
		femaleRB.setFont(SMALLER_FONT);
		femaleRB.setForeground(fgColor);
		group.add(femaleRB);
		sexPanel.add(femaleRB);
		
		centerPanel.add(sexPanel);
		
		JPanel button1 = new JPanel();
		button1.setOpaque(false);
		button1.setPreferredSize(new Dimension(1000, 60));
		saveButton = new BufferedImageButton(SAVE1, SAVE2, 150, 50);
		button1.add(saveButton);
		undoButton = new BufferedImageButton(UNDO1, UNDO2, 150, 50);
		button1.add(undoButton);
		
		centerPanel.add(button1);
		
		JLabel emptyLabel2 = new JLabel();
		emptyLabel2.setOpaque(false);
		emptyLabel2.setPreferredSize(new Dimension(1000, 30));
		centerPanel.add(emptyLabel2);
		
		JLabel header1Label = new JLabel(HEADER1, JLabel.CENTER);
		header1Label.setOpaque(false);
		header1Label.setFont(BIGGER_FONT);
		header1Label.setForeground(fgColor);
		header1Label.setPreferredSize(new Dimension(500, 50));
		centerPanel.add(header1Label);
		
		JPanel button2 = new JPanel();
		button2.setOpaque(false);
		button2.setPreferredSize(new Dimension(1000, 60));
		changePasswordButton = new BufferedImageButton(PASSWORD1, PASSWORD2, 300, 50);
		button2.add(changePasswordButton);
		
		bgPanel.add(centerPanel, BorderLayout.CENTER);
		
		centerPanel.add(button2);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		buttonPanel.setPreferredSize(new Dimension(1000, 100));
		buttonPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		settingButton = new BufferedImageButton(SETTING1, SETTING2, 300, 100);
		buttonPanel.add(settingButton);
		
		inventoryButton = new BufferedImageButton(INVENTORY1, INVENTORY2, 300, 100);
		buttonPanel.add(inventoryButton);
		
		mapButton = new BufferedImageButton(MAP1, MAP2, 300, 100);
		buttonPanel.add(mapButton);
		
		bgPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		setContentPane(bgPanel);
	}
	
	public String getEmail() {
		return emailTextField != null ? emailTextField.getText() : "";
	}

	public void setEmail(String email) {
		if(emailTextField != null){
			emailTextField.setText(email != null ? email : "");
		}
	}

	public String getAddress() {
		return addressTextField != null ? addressTextField.getText() : "";
	}

	public void setAddress(String address) {
		if(addressTextField != null){
			addressTextField.setText(address != null ? address : "");
		}
	}

	public boolean isSex() {
		if (maleRB != null)
			return maleRB.isSelected();
		return false;
	}

	public void setSex(boolean sex) {
		if (maleRB != null && femaleRB != null) {
			maleRB.setSelected(sex);
			femaleRB.setSelected(!sex);
		}
	}
	
	public void setSaveButtonListener(ActionListener listener){
		saveButton.addActionListener(listener);
	}
	
	public void setUndoButtonListener(ActionListener listener){
		undoButton.addActionListener(listener);
	}
	
	public void setChangePasswordButtonListener(ActionListener listener){
		changePasswordButton.addActionListener(listener);
	}
	
	public void setSettingButtonListerner(ActionListener listerner){
		settingButton.addActionListener(listerner);
	}
	
	public void setInventoryButtonListerner(ActionListener listerner){
		inventoryButton.addActionListener(listerner);
	}
	
	public void setMapButtonListerner(ActionListener listerner){
		mapButton.addActionListener(listerner);
	}
	
	public static void reAddEnergybar(){
		energyBar = View.getEnergyBar();
		fixedLabel.add(energyBar);
	}
}
