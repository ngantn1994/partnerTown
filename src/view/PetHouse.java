package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import model.UserPet;

public class PetHouse extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private static final String TITLE = "Nh\u00e0 ri\u00eang";
	
	private static final Font BIGGER_FONT = new Font(Font.SERIF, Font.BOLD, 30);
	private static final Font SMALLER_FONT = new Font(Font.SERIF, Font.PLAIN, 20);
	private int fgValue = Integer.parseInt( "88593E", 16);
	private Color fgColor = new Color(fgValue);
	private int bgValue = Integer.parseInt( "FED7D8", 16);
	private Color bgColor = new Color(bgValue);
	
	private static final String BGIMG = "images/pethouse/background.png";
	private static final String FEED1 = "images/pethouse/feed1.png";
	private static final String FEED2 = "images/pethouse/feed2.png";
	private static final String POKE1 = "images/pethouse/poke1.png";
	private static final String POKE2 = "images/pethouse/poke2.png";
	private static final String WASH1 = "images/pethouse/wash1.png";
	private static final String WASH2 = "images/pethouse/wash2.png";
	private static final String CHANGENAME1 = "images/pethouse/changename1.png";
	private static final String CHANGENAME2 = "images/pethouse/changename2.png";
	
	private static final String SETTING1 = "images/buttons/setting1.png";
	private static final String SETTING2 = "images/buttons/setting2.png";
	private static final String INVENTORY1 = "images/buttons/inventory1.png";
	private static final String INVENTORY2 = "images/buttons/inventory2.png";
	private static final String MAP1 = "images/buttons/map1.png";
	private static final String MAP2 = "images/buttons/map2.png";
	
	private PatternProgressBar energyBar;
	private BufferedImageButton settingButton;
	private BufferedImageButton inventoryButton;
	private BufferedImageButton mapButton;
	
	private BufferedImageButton feedButton;
	private BufferedImageButton pokeButton;
	private BufferedImageButton washButton;
	private BufferedImageButton changeNameButton;
	private JTabbedPane tabbedPane;
	private List<JPanel> petPanel;
	private List<JLabel> nameLabel;
	private List<JLabel> spLabel;
	private List<JLabel> iconsLabel;
	private List<ImagePanel> wc;
	private List<JLabel> happyLabel;
	
	private List<UserPet> pets;
	
	private List<Integer> recentLvs;
	
	private static final String NONE0 = "Thông báo";
	private static final String NONE1 = "B\u1EA1n ch\u01B0a có partner nào c\u1EA3.";
	private static final String NONE2 = "\u0110\u1EBFn Partner Center \u0111ón ngay 1 bé nào!";

	public PetHouse(PatternProgressBar bar, List<UserPet> allPets){
		this.setResizable(false);
		this.setTitle(TITLE);
		this.setBounds(150, 5, 1000, 720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pets = new ArrayList<UserPet>();
		for (int i=0;i<allPets.size();i++){
			UserPet temp = allPets.get(i);
			if(temp.getVisible()){
				pets.add(temp);
			}
		}

		getContentPane().setLayout(new FlowLayout());
		
		ImagePanel bgPanel = new ImagePanel(BGIMG);
		bgPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel fixedLabel = new JPanel();
		fixedLabel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 128)), "Energy", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 128)));
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
		buttonPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		settingButton = new BufferedImageButton(SETTING1, SETTING2, 300, 100);
		buttonPanel.add(settingButton);
		
		inventoryButton = new BufferedImageButton(INVENTORY1, INVENTORY2, 300, 100);
		buttonPanel.add(inventoryButton);
		
		mapButton = new BufferedImageButton(MAP1, MAP2, 300, 100);
		buttonPanel.add(mapButton);
		
		bgPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		setContentPane(bgPanel);
		
		JPanel controlPanel = new JPanel();
		controlPanel.setOpaque(false);
		controlPanel.setPreferredSize(new Dimension(180, 400));
		controlPanel.setLayout(new FlowLayout());
		
		feedButton = new BufferedImageButton(FEED1, FEED2, 150, 60);
		controlPanel.add(feedButton);
		
		pokeButton = new BufferedImageButton(POKE1, POKE2, 150, 60);
		controlPanel.add(pokeButton);
		
		washButton = new BufferedImageButton(WASH1, WASH2, 150, 60);
		controlPanel.add(washButton);
		
		changeNameButton = new BufferedImageButton(CHANGENAME1, CHANGENAME2, 150, 60);
		controlPanel.add(changeNameButton);
		
		bgPanel.add(controlPanel, BorderLayout.EAST);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setPreferredSize(new Dimension(400, 250));
		centerPanel.setOpaque(false);
		centerPanel.setLayout(new FlowLayout());
		
		tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setBackground(bgColor);
		tabbedPane.setFont(SMALLER_FONT);
		tabbedPane.setForeground(fgColor);
		centerPanel.add(tabbedPane);
		
		bgPanel.add(centerPanel, BorderLayout.CENTER);
		
		petPanel = new ArrayList<JPanel>();
		nameLabel = new ArrayList<JLabel>();
		spLabel = new ArrayList<JLabel>();
		iconsLabel= new ArrayList<JLabel>();
		wc = new ArrayList<ImagePanel>();
		happyLabel= new ArrayList<JLabel>();
		recentLvs = new ArrayList<Integer>();
		
		if(pets.size()>0){
			for(int i=0;i<pets.size();i++){
				JPanel panel = new JPanel();
				panel.setBackground(bgColor);
				panel.setLayout(new BorderLayout(0, 0));

				ImagePanel wcPanel = new ImagePanel("images/pethouse/wc" + pets.get(i).getWC() + ".png");
				wcPanel.setPreferredSize(new Dimension(250, 250));
				wcPanel.setLayout(new FlowLayout());
				
				wc.add(wcPanel);
				
				JLabel nameLabel = new JLabel(pets.get(i).getPetName(), JLabel.CENTER);
				nameLabel.setOpaque(false);
				nameLabel.setFont(BIGGER_FONT);
				nameLabel.setForeground(fgColor);
				nameLabel.setPreferredSize(new Dimension(250,50));
				
				this.nameLabel.add(nameLabel);
				
				wc.get(i).add(this.nameLabel.get(i));
				
				JLabel iconLabel = new JLabel();
				iconLabel.setIcon(new AnimatedIcon(new ImageIcon(getClass().getResource("pettype/"+pets.get(i).getPetID()+"/"+pets.get(i).getCurrentLv()+".gif"))));
				iconLabel.setOpaque(false);
				iconsLabel.add(iconLabel);
				
				recentLvs.add(pets.get(i).getCurrentLv());
				
				wc.get(i).add(iconsLabel.get(i));
				
				JLabel spLabel = new JLabel("SP = "+pets.get(i).getSP(), JLabel.CENTER);
				spLabel.setOpaque(false);
				spLabel.setFont(BIGGER_FONT);
				spLabel.setForeground(fgColor);
				spLabel.setPreferredSize(new Dimension(250,50));
				
				this.spLabel.add(spLabel);
				
				wc.get(i).add(this.spLabel.get(i));
				
				panel.add(wc.get(i), BorderLayout.WEST);
				
				JLabel happy = new JLabel();
				happy.setOpaque(false);
				
				happyLabel.add(happy);
				happyLabel.get(i).setIcon(View.getHappy(pets.get(i).getHappy()));
				
				panel.add(happyLabel.get(i), BorderLayout.EAST);
											
				petPanel.add(panel);
				tabbedPane.addTab("Partner #"+(i+1), null, petPanel.get(i), null);
			}
		} else {
			JPanel panel = new JPanel();
			panel.setBackground(bgColor);
			panel.setLayout(new FlowLayout());
			panel.setPreferredSize(new Dimension(400, 300));
			
			JLabel none1 = new JLabel(NONE1, JLabel.CENTER);
			none1.setOpaque(false);
			none1.setFont(SMALLER_FONT);
			none1.setForeground(fgColor);
			none1.setPreferredSize(new Dimension(350, 50));
			panel.add(none1);
			
			JLabel none2 = new JLabel(NONE2, JLabel.CENTER);
			none2.setOpaque(false);
			none2.setFont(SMALLER_FONT);
			none2.setForeground(fgColor);
			none2.setPreferredSize(new Dimension(350, 50));
			panel.add(none2);
			
			tabbedPane.addTab(NONE0, null, panel, null);
		}
		
		
	}
	
	public void updateName(int i, UserPet pet){
		nameLabel.get(i).setText(pet.getPetName());
	}
	
	public void updateSP(int i, UserPet pet){
		spLabel.get(i).setText("SP = "+pet.getSP());
	}
	
	public void updateLevel(int i, UserPet pet){
		if(pet.getCurrentLv() == recentLvs.get(i)){
			return;
		}
		AnimatedIcon temp = new AnimatedIcon(new ImageIcon(getClass().getResource("pettype/"+pet.getPetID()+"/"+pet.getCurrentLv()+".gif")));
		iconsLabel.get(i).setIcon(temp);
	}
	
	public void updateWash(int i, UserPet pet){
		wc.get(i).changeBg(View.getWC(pet.getWC()));
	}
	
	public void updateHappy(int i, UserPet pet){
		int temp = pet.getHappy();
		if(temp > 0){
			happyLabel.get(i).setIcon(View.getHappy(temp));
		}
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
	
	public int getSelectedTab(){
		return tabbedPane.getSelectedIndex();
	}
	
	public int getSelectedID(){
		return pets.get(tabbedPane.getSelectedIndex()).getStockID();
	}
	
	public void addFeedActionListerner(ActionListener listener){
		feedButton.addActionListener(listener);
	}
	
	public void addPokeActionListerner(ActionListener listener){
		pokeButton.addActionListener(listener);
	}
	
	public void addWashActionListerner(ActionListener listener){
		washButton.addActionListener(listener);
	}
	
	public void addChangeNameActionListerner(ActionListener listener){
		changeNameButton.addActionListener(listener);
	}
	
	public boolean checkAvaible(){
		if(pets.size() >0){
			return true;
		} else {
			return false;
		}
	}
	
	
}
