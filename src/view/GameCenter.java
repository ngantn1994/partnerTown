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

public class GameCenter extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private static final String TITLE = "Shop";

	private static final Font BIGGER_FONT = new Font(Font.SERIF, Font.BOLD, 30);
	private int fgValue = Integer.parseInt( "FF3D67", 16);
	private Color fgColor = new Color(fgValue);
		
	private static final String BGIMG = "images/gamecenter/background.png";
	private static final String INVENTORY1 = "images/buttons/inventory1.png";
	private static final String INVENTORY2 = "images/buttons/inventory2.png";
	private static final String MAP1 = "images/buttons/map1.png";
	private static final String MAP2 = "images/buttons/map2.png";
	
	private static PatternProgressBar energyBar;
	private JPanel fixedLabel;
	
	private static JLabel moneyLabel;
	private BufferedImageButton inventoryButton;
	private BufferedImageButton mapButton;
	
	private static final String ICON1 = "images/gamecenter/icon1.png";
	private static final String ICON1_BEFORE = "images/gamecenter/icon1_before.png";
	private static final String LABEL1 = "images/gamecenter/label1.png";
	
	private static final String ICON2 = "images/gamecenter/icon2.png";
	private static final String ICON2_BEFORE = "images/gamecenter/icon2_before.png";
	private static final String LABEL2 = "images/gamecenter/label2.png";
	
	private static final String ICON3 = "images/gamecenter/icon3.png";
	private static final String ICON3_BEFORE = "images/gamecenter/icon3_before.png";
	private static final String LABEL3 = "images/gamecenter/label3.png";
	
	private static final String MONEYIMG = "images/petcenter/money.png";
	private static final String MONEY = "S\u1ED1 ti\u1EC1n hi\u1EC7n có: ";
	
	private BufferedImageButton game1;
	private BufferedImageButton game2;
	private BufferedImageButton game3;
	
	private static GameCenter center = new GameCenter(View.getEnergyBar());
	
	private GameCenter(PatternProgressBar bar){
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
		
		GridBagConstraints gbc_buyButton = new GridBagConstraints();
		gbc_buyButton.insets = new Insets(0, 0, 0, 5);
		gbc_buyButton.gridx = 1;
		gbc_buyButton.gridy = 0;
		buttonPanel.add(inventoryButton, gbc_buyButton);
		
		GridBagConstraints gbc_mapButton = new GridBagConstraints();
		gbc_mapButton.gridx = 2;
		gbc_mapButton.gridy = 0;
		buttonPanel.add(mapButton, gbc_mapButton);
		
		bgPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		JPanel centerPanel = new JPanel(new FlowLayout());
		centerPanel.setOpaque(false);
		centerPanel.setPreferredSize(new Dimension(900,400));
		
		JPanel game1Panel = new JPanel(new FlowLayout());
		game1Panel.setOpaque(false);
		game1Panel.setPreferredSize(new Dimension(150,250));
		
		game1 = new BufferedImageButton(ICON1_BEFORE, ICON1, 150, 150);
		game1Panel.add(game1);
		
		JLabel label1 = new JLabel(new ImageIcon(getClass().getResource(LABEL1)));
		game1Panel.add(label1);
		
		centerPanel.add(game1Panel);
		
		JPanel game2Panel = new JPanel(new FlowLayout());
		game2Panel.setOpaque(false);
		game2Panel.setPreferredSize(new Dimension(150,250));
		
		game2 = new BufferedImageButton(ICON2_BEFORE, ICON2, 150, 150);
		game2Panel.add(game2);
		
		JLabel label2 = new JLabel(new ImageIcon(getClass().getResource(LABEL2)));
		game2Panel.add(label2);
		
		centerPanel.add(game2Panel);
		
		JPanel game3Panel = new JPanel(new FlowLayout());
		game3Panel.setOpaque(false);
		game3Panel.setPreferredSize(new Dimension(150,250));
		
		game3 = new BufferedImageButton(ICON3_BEFORE, ICON3, 150, 150);
		game3Panel.add(game3);
		
		JLabel label3 = new JLabel(new ImageIcon(getClass().getResource(LABEL3)));
		game3Panel.add(label3);
		
		centerPanel.add(game3Panel);
		
		bgPanel.add(centerPanel, BorderLayout.CENTER);
		
		setContentPane(bgPanel);
		
	}

	public void setGame1ButtonListener(ActionListener listener){
		game1.addActionListener(listener);
	}
	
	public void setGame2ButtonListener(ActionListener listener){
		game2.addActionListener(listener);
	}
	
	public void setGame3ButtonListener(ActionListener listener){
		game3.addActionListener(listener);
	}
	
	public static void changeMoney(int money){
		moneyLabel.setText(MONEY + money + "$");
	}
	
	public void setInventoryButtonListerner(ActionListener listerner){
		inventoryButton.addActionListener(listerner);
	}
	
	public void setMapButtonListerner(ActionListener listerner){
		mapButton.addActionListener(listerner);
	}
	
	public static GameCenter getInstance(){
		return center;
	}
	
	public static void reAddEnergybar(){
		energyBar = View.getEnergyBar();
		center.fixedLabel.add(energyBar);
	}

}
