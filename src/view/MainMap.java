package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.Color;

import javax.swing.border.LineBorder;

public class MainMap extends JFrame {

	private static final long serialVersionUID = 1L;

	private static final String TITLE = "B\u1EA3n \u0111\u1ED3";
	private static final String BGIMG = "images/map/background.png";
	private static final String HOME = "images/map/home.png";
	private static final String PARTNERCENTER = "images/map/petcenter.gif";
	private static final String PARTNERHOUSE = "images/map/partnerhouse.png";
	private static final String SHOP = "images/map/shop.png";
	private static final String GAMECENTER = "images/map/gamecenter.png";
	private static final String DRINKS = "images/map/drinks.png";
	
	private ImageButton homeButton;
	private ImageButton pncenterButton;
	private ImageButton pnhouseButton;
	private ImageButton shopButton;
	private ImageButton gamecenterButton;
	private ImageButton drinksButton;
	
	private static JPanel fixedLabel;
	private static PatternProgressBar energyBar;
	
	private static MainMap map = new MainMap(View.getEnergyBar());
	
	private MainMap(PatternProgressBar bar){
		this.setResizable(false);
		this.setTitle(TITLE);
		this.setBounds(150, 5, 1000, 720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new FlowLayout());
		
		ImagePanel bgPanel = new ImagePanel(BGIMG);
		bgPanel.setLayout(new FlowLayout());
		
		fixedLabel = new JPanel();
		fixedLabel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 128)), "Energy", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 128)));
		fixedLabel.setPreferredSize(new Dimension(550,57));
		fixedLabel.setOpaque(false);
		fixedLabel.setLayout(new FlowLayout());
		fixedLabel.setForeground(new Color(0, 0, 128));
		bgPanel.add(fixedLabel);
		
		energyBar = bar;
		fixedLabel.add(energyBar);
		
		JLabel emptyLabel = new JLabel();
		emptyLabel.setPreferredSize(new Dimension(1000,10));
		emptyLabel.setOpaque(false);
		bgPanel.add(emptyLabel);
		
		JPanel bodyPanel = new JPanel(new FlowLayout());
		bodyPanel.setPreferredSize(new Dimension(1000, 600));
		bodyPanel.setOpaque(false);
		
		homeButton = new ImageButton(HOME, HOME, 300, 300);
		bodyPanel.add(homeButton);
		
		pncenterButton = new ImageButton(PARTNERCENTER, PARTNERCENTER, 380, 300);
		bodyPanel.add(pncenterButton);
		
		pnhouseButton = new ImageButton(PARTNERHOUSE, PARTNERHOUSE, 300, 300);
		bodyPanel.add(pnhouseButton);

		shopButton = new ImageButton(SHOP, SHOP, 300, 300);
		bodyPanel.add(shopButton);
		
		gamecenterButton = new ImageButton(GAMECENTER, GAMECENTER, 300, 300);
		bodyPanel.add(gamecenterButton);
		
		drinksButton = new ImageButton(DRINKS, DRINKS, 300, 300);
		bodyPanel.add(drinksButton);
		
		bgPanel.add(bodyPanel);
		this.setContentPane(bgPanel);
	}
	
	public static MainMap getInstance(){
		return map;
	}
	
	public void addHomeButtonListener(ActionListener listener){
		homeButton.addActionListener(listener);
	}
	
	public void addPetCenterButtonListener(ActionListener listener){
		pncenterButton.addActionListener(listener);
	}
	
	public void addPetHouseButtonListener(ActionListener listener){
		pnhouseButton.addActionListener(listener);
	}
	
	public void addShopButtonListener(ActionListener listener){
		shopButton.addActionListener(listener);
	}
	
	public void addGameCenterButtonListener(ActionListener listener){
		gamecenterButton.addActionListener(listener);
	}
	
	public void addDrinksButtonListener(ActionListener listener){
		drinksButton.addActionListener(listener);
	}
	
	public static void reAddEnergybar(){
		energyBar = View.getEnergyBar();
		fixedLabel.add(energyBar);
	}
	
}
