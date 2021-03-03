package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Shop extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private static final String TITLE = "Shop";
	private static final String MONEY = "S\u1ED1 ti\u1EC1n hi\u1EC7n có: ";

	private int fgValue = Integer.parseInt( "870001", 16);
	private Color fgColor = new Color(fgValue);
	
	private static final Font BIGGER_FONT = new Font(Font.SERIF, Font.BOLD, 30);
	
	private static final String BGIMG = "images/shop/background.png";
	private static final String INVENTORY1 = "images/buttons/inventory1.png";
	private static final String INVENTORY2 = "images/buttons/inventory2.png";
	private static final String MAP1 = "images/buttons/map1.png";
	private static final String MAP2 = "images/buttons/map2.png";
	
	private static PatternProgressBar energyBar;
	private JPanel fixedLabel;
	
	private JLabel moneyLabel;
	private BufferedImageButton inventoryButton;
	private BufferedImageButton mapButton;
	
	private static final String MONEYIMG = "images/petcenter/money.png";
	
	private static final String ICON_MILK = "images/shop/milk.png";
	private static final String ICON_ENERGY1 = "images/shop/energy1.png";
	private static final String ICON_ENERGY2 = "images/shop/energy2.png";
	
	private static final String BUTTON1_MILK = "images/shop/milk_buy1.png";
	private static final String BUTTON2_MILK = "images/shop/milk_buy2.png";
	private static final String BUTTON1_ENERGY1 = "images/shop/energy1_buy1.png";
	private static final String BUTTON2_ENERGY1 = "images/shop/energy1_buy2.png";
	private static final String BUTTON1_ENERGY2 = "images/shop/energy2_buy1.png";
	private static final String BUTTON2_ENERGY2 = "images/shop/energy2_buy2.png";
	
	private static final String LABEL_MILK = "images/shop/milk_des.png";
	private static final String LABEL_ENERGY1 = "images/shop/energy1_des.png";
	private static final String LABEL_ENERGY2 = "images/shop/energy2_des.png";
	
	private BufferedImageButton milkButton;
	private BufferedImageButton energy1Button;
	private BufferedImageButton energy2Button;
	
	private static Shop shop = new Shop(View.getEnergyBar());
	
	private Shop(PatternProgressBar bar){
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
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		buttonPanel.setPreferredSize(new Dimension(1000, 100));
		
		ImagePanel moneyPanel = new ImagePanel(MONEYIMG);
		moneyPanel.setLayout(new FlowLayout());
		moneyPanel.setPreferredSize(new Dimension(370, 100));
		
		JLabel emptyLabel = new JLabel();
		emptyLabel.setOpaque(false);
		emptyLabel.setPreferredSize(new Dimension(370,10));
		moneyPanel.add(emptyLabel);
		
		moneyLabel = new JLabel(MONEY + "1000$", JLabel.CENTER);
		moneyLabel.setForeground(fgColor);
		moneyLabel.setFont(BIGGER_FONT);
		moneyLabel.setOpaque(false);
		moneyPanel.add(moneyLabel);
		
		inventoryButton = new BufferedImageButton(INVENTORY1, INVENTORY2, 300, 100);
		
		mapButton = new BufferedImageButton(MAP1, MAP2, 300, 100);
		
		GridBagLayout gbl_buttonPanel = new GridBagLayout();
		gbl_buttonPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_buttonPanel.rowHeights = new int[]{0, 0};
		gbl_buttonPanel.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_buttonPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		buttonPanel.setLayout(gbl_buttonPanel);
		
		GridBagConstraints gbc_moneyLabel = new GridBagConstraints();
		gbc_moneyLabel.insets = new Insets(0, 0, 0, 5);
		gbc_moneyLabel.gridx = 0;
		gbc_moneyLabel.gridy = 0;
		buttonPanel.add(moneyPanel, gbc_moneyLabel);
		
		GridBagConstraints gbc_inventoryButton = new GridBagConstraints();
		gbc_inventoryButton.insets = new Insets(0, 0, 0, 5);
		gbc_inventoryButton.gridx = 1;
		gbc_inventoryButton.gridy = 0;
		buttonPanel.add(inventoryButton, gbc_inventoryButton);
		
		GridBagConstraints gbc_mapButton = new GridBagConstraints();
		gbc_mapButton.gridx = 2;
		gbc_mapButton.gridy = 0;
		buttonPanel.add(mapButton, gbc_mapButton);
		
		bgPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		JPanel centerPanel = new JPanel(new FlowLayout());
		centerPanel.setOpaque(false);
		centerPanel.setPreferredSize(new Dimension(900,400));
		
		JPanel milkPanel = new JPanel(new FlowLayout());
		milkPanel.setOpaque(false);
		milkPanel.setPreferredSize(new Dimension(250,400));
		
		ImageIcon milkImg = new ImageIcon(getClass().getResource(ICON_MILK));
		JLabel milkIcon = new JLabel(milkImg, JLabel.CENTER);
		milkIcon.setOpaque(false);
		milkIcon.setPreferredSize(new Dimension(75, 100));
		milkPanel.add(milkIcon);
		
		milkButton = new BufferedImageButton(BUTTON1_MILK, BUTTON2_MILK, 250, 50);
		milkPanel.add(milkButton);
		
		ImageIcon milkLabelImg = new ImageIcon(getClass().getResource(LABEL_MILK));
		JLabel milkLabel = new JLabel(milkLabelImg, JLabel.CENTER);
		milkLabel.setOpaque(false);
		milkLabel.setPreferredSize(new Dimension(250,150));
		milkPanel.add(milkLabel);
		
		centerPanel.add(milkPanel);
		
		JPanel energy1Panel = new JPanel(new FlowLayout());
		energy1Panel.setOpaque(false);
		energy1Panel.setPreferredSize(new Dimension(250,400));
		
		ImageIcon energy1Img = new ImageIcon(getClass().getResource(ICON_ENERGY1));
		JLabel energy1Icon = new JLabel(energy1Img, JLabel.CENTER);
		energy1Icon.setOpaque(false);
		energy1Icon.setPreferredSize(new Dimension(75, 100));
		energy1Panel.add(energy1Icon);
		
		energy1Button = new BufferedImageButton(BUTTON1_ENERGY1, BUTTON2_ENERGY1, 250, 50);
		energy1Panel.add(energy1Button);
		
		ImageIcon energy1LabelImg = new ImageIcon(getClass().getResource(LABEL_ENERGY1));
		JLabel energy1Label = new JLabel(energy1LabelImg, JLabel.CENTER);
		energy1Label.setOpaque(false);
		energy1Label.setPreferredSize(new Dimension(250,150));
		energy1Panel.add(energy1Label);
		
		centerPanel.add(energy1Panel);
		
		JPanel energy2Panel = new JPanel(new FlowLayout());
		energy2Panel.setOpaque(false);
		energy2Panel.setPreferredSize(new Dimension(250,400));
		
		ImageIcon energy2Img = new ImageIcon(getClass().getResource(ICON_ENERGY2));
		JLabel energy2Icon = new JLabel(energy2Img, JLabel.CENTER);
		energy2Icon.setOpaque(false);
		energy2Icon.setPreferredSize(new Dimension(75, 100));
		energy2Panel.add(energy2Icon);
		
		energy2Button = new BufferedImageButton(BUTTON1_ENERGY2, BUTTON2_ENERGY2, 250, 50);
		energy2Panel.add(energy2Button);
		
		ImageIcon energy2LabelImg = new ImageIcon(getClass().getResource(LABEL_ENERGY2));
		JLabel energy2Label = new JLabel(energy2LabelImg, JLabel.CENTER);
		energy2Label.setOpaque(false);
		energy2Label.setPreferredSize(new Dimension(250,150));
		energy2Panel.add(energy2Label);
		
		centerPanel.add(energy2Panel);
		
		bgPanel.add(centerPanel, BorderLayout.CENTER);
		
		setContentPane(bgPanel);
		
	}

	public void setMilkButtonListener(ActionListener listener){
		milkButton.addActionListener(listener);
	}
	
	public void setGrapeButtonListener(ActionListener listener){
		energy1Button.addActionListener(listener);
	}
	
	public void setMangoPasswordButtonListener(ActionListener listener){
		energy2Button.addActionListener(listener);
	}
	
	public void setInventoryButtonListerner(ActionListener listerner){
		inventoryButton.addActionListener(listerner);
	}
	
	public void setMapButtonListerner(ActionListener listerner){
		mapButton.addActionListener(listerner);
	}
	
	public static Shop getInstance(){
		return shop;
	}
	
	public static void reAddEnergybar(){
		energyBar = View.getEnergyBar();
		shop.fixedLabel.add(energyBar);
	}
	
	public void changeMoney(int money){
		moneyLabel.setText(MONEY + money + "$");
	}
	
}
