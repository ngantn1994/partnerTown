package view;

import java.awt.Container;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controller.Information;
import controller.LoopSound;

public class View extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private static final String TITLE = "Th\u1ECB tr\u1EA5n thú c\u01B0ng";
	private static final String ENERGYBARPATTERN = "images/buttons/progressbarpattern.png";
	
	private static final String WC[] = {"images/pethouse/wc0.png", "images/pethouse/wc1.png", 
		"images/pethouse/wc2.png", "images/pethouse/wc3.png"};
	
	private static final String HAPPY[] = {"images/pethouse/1.png", "images/pethouse/2.png",
		"images/pethouse/3.png", "images/pethouse/4.png", "images/pethouse/5.png"};
	
	private static PatternProgressBar energyBar = new PatternProgressBar(ENERGYBARPATTERN);
	
	private static View view = new View();
	
	public static LoopSound sound = new LoopSound("controller/sounds/bgMusic.wav");
	
	private static List<AnimatedIcon> icons;
	
	private static List<ImageIcon> happyIcon;
	private static List<Image> wcIcon;
	
	private View(){
		this.setResizable(false);
		this.setTitle(TITLE);
		this.setBounds(150, 5, 1000, 720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		icons = new ArrayList<AnimatedIcon>();
		for(int i=1;i<105;i++){
			AnimatedIcon icon = new AnimatedIcon(new ImageIcon(getClass().getResource("pettype/"+i+"/1.gif")));
			icons.add(icon);
		}
		
		happyIcon = new ArrayList<ImageIcon>();
		for(int i=0;i<HAPPY.length;i++){
			ImageIcon icon = new ImageIcon(getClass().getResource(HAPPY[i]));
			happyIcon.add(icon);
		}
		
		wcIcon = new ArrayList<Image>();
		for(int i=0;i<WC.length;i++){
			try {
				Image icon = ImageIO.read(getClass().getResource(WC[i]));
				wcIcon.add(icon);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void getInstance(){
		sound.musicStart();
		view.setVisible(true);
	}
	
	public static void musicOn(){
		sound.musicOn();
	}
	
	public static void musicOff() {
		sound.musicOff();
	}
	
	public static boolean isOn(){
		return sound.isPlaying();
	}
	
	public static void changeContentPane(Container bgPanel){
		view.getContentPane().setVisible(false);
		System.gc();
		bgPanel.setVisible(true);
		view.setContentPane(bgPanel);
	}
	
	public static PatternProgressBar getEnergyBar(){
		return energyBar;
	}
	
	public static void updateEnergyBar(){
		energyBar.setValue(Information.getInstance().getUser().getEnergy()*2);
	}
	
	public static AnimatedIcon getIcon(int i){
		return icons.get(i);
	}
	
	public static Image getWC(int i){
		return wcIcon.get(i);
	}
	
	public static ImageIcon getHappy(int i){
		if(i<1){
			return happyIcon.get(0);
		}
		return happyIcon.get(i-1);
	}
}
