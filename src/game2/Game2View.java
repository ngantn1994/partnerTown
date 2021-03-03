package game2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import view.BufferedImageButton;
import view.ImagePanel;

public class Game2View extends JDialog {
	
	private static final long serialVersionUID = 1L;
	
	private static final String STARTBG = "images/game2/start.jpg";
	private static final String MAINBG = "images/game2/bg.jpg";
	private static final String OVERBG = "images/game2/over.jpg";
	private static final String START1 = "images/game2/start1.png";
	private static final String START2 = "images/game2/start2.png";
	private static final String BACK1 = "images/game2/back1.png";
	private static final String BACK2 = "images/game2/back2.png";
	
	private static final Font BIGGER_FONT = new Font(Font.SERIF, Font.PLAIN, 40);
	private int fgValue = Integer.parseInt( "FEC49C", 16);
	private Color fgColor = new Color(fgValue);
	private int fgValueGO = Integer.parseInt( "1F0E02", 16);
	private Color fgColorGO = new Color(fgValueGO);

	private ImagePanel bgPanel;
	private JPanel cardPanel;
	private JPanel buttonPanel;
	
	private JProgressBar timeBar;
	private JLabel scoreLabel;
	private JLabel card1;
	private JLabel card2;
	private List<NumberButton> buttons;
	
	private BufferedImageButton startButton;
	private BufferedImageButton backButton;
	
	private List<ImageIcon> icons;
	
	private int score = 0;
	
	private static Game2View view = new Game2View();
	
	public static Game2View getInstance(){
		view.resetScore();
		view.setTimeBarValue(100);
		return view;
	}
	
	private Game2View() {
		this.setResizable(false);
		this.setTitle("Fruit Plus");
		this.setBounds(150, 5, 1000, 720);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		bgPanel = new ImagePanel(STARTBG);
		bgPanel.setLayout(null);
		
		startButton = new BufferedImageButton(START1, START2, 100, 50);
		startButton.setBounds(445, 450, 100, 50);
		
		backButton = new BufferedImageButton(BACK1, BACK2, 300, 120);
		backButton.setBounds(350, 355, 300, 120);
		
		buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.setPreferredSize(new Dimension(395, 200));
		
		buttons = new ArrayList<NumberButton>();
		
		for(int i=0;i<20;i++){
			int temp = i+1;
			NumberButton button = new NumberButton(temp+".png","0"+temp+".png",50,50,i+1);
			buttons.add(button);
			buttonPanel.add(buttons.get(i));
		}
		
		icons = new ArrayList<ImageIcon>();
		
		for(int i=0;i<10;i++){
			try {
				int temp = i+1;
				BufferedImage image = ImageIO.read(getClass().getResource(temp+".jpg"));
				ImageIcon icon = new ImageIcon(image);
				icons.add(icon);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		cardPanel = new JPanel();
		cardPanel.setOpaque(false);
		cardPanel.setLayout(new GridLayout());
		cardPanel.setPreferredSize(new Dimension(700, 200));
		
		ImageIcon plusIcon = new ImageIcon(getClass().getResource("0.jpg"));
		
		card1 = new JLabel(plusIcon);
		cardPanel.add(card1);
		
		JLabel plus = new JLabel(plusIcon);
		cardPanel.add(plus);
		
		card2 = new JLabel(plusIcon);
		cardPanel.add(card2);
		
		scoreLabel = new JLabel("$", JLabel.CENTER);
		scoreLabel.setOpaque(false);
		scoreLabel.setPreferredSize(new Dimension(900,50));
		scoreLabel.setFont(BIGGER_FONT);
		
		timeBar = new JProgressBar();
		timeBar.setMaximumSize(new Dimension(750, 30));
		timeBar.setMinimumSize(new Dimension(750, 30));
		timeBar.setPreferredSize(new Dimension(750, 30));
		timeBar.setValue(100);
		timeBar.setAlignmentX(0f);
		
		bgPanel.add(startButton);
		
		this.setContentPane(bgPanel);
	}
	
	public void startAgain(){
		bgPanel.setVisible(false);
		resetScore();
		
		bgPanel = new ImagePanel(STARTBG);
		bgPanel.setLayout(null);
		
		bgPanel.add(startButton);
		
		bgPanel.setVisible(true);
		this.setContentPane(bgPanel);
	}
	
	public void play(){
		bgPanel.setVisible(false);
		
		bgPanel = new ImagePanel(MAINBG);
		bgPanel.setLayout(new FlowLayout());
		
		JLabel emptyLabel0 = new JLabel();
		emptyLabel0.setPreferredSize(new Dimension(900,10));
		emptyLabel0.setOpaque(false);
		bgPanel.add(emptyLabel0);
		
		scoreLabel.setForeground(fgColor);
		bgPanel.add(scoreLabel);
		
		timeBar.setValue(100);
		bgPanel.add(timeBar);
		
		JLabel emptyLabel1 = new JLabel();
		emptyLabel1.setPreferredSize(new Dimension(900,100));
		emptyLabel1.setOpaque(false);
		bgPanel.add(emptyLabel1);
		
		bgPanel.add(cardPanel);
		
		JLabel emptyLabel2 = new JLabel();
		emptyLabel2.setPreferredSize(new Dimension(900,50));
		emptyLabel2.setOpaque(false);
		bgPanel.add(emptyLabel2);
		
		bgPanel.add(buttonPanel);
		
		bgPanel.setVisible(true);
		this.setContentPane(bgPanel);
	}
	
	public void gameOver(){
		bgPanel.setVisible(false);
		
		bgPanel = new ImagePanel(OVERBG);
		bgPanel.setLayout(null);
			
		scoreLabel.setForeground(fgColorGO);
		scoreLabel.setBounds(150, 303, 900, 50);		
		
		bgPanel.add(scoreLabel);
		
		bgPanel.add(backButton);
		bgPanel.setVisible(true);
		this.setContentPane(bgPanel);
	}
	
	public int getScore(){
		return score;
	}
	
	public void resetScore(){
		score = 0;
	}
	
	public void incScore(int a){
		score = score + a;
	}

	public void refreshScore(){
		scoreLabel.setText(score + "$");
	}

	public int getTimeBarValue(){
		return timeBar.getValue();
	}
	
	public void setTimeBarValue(int a){
		timeBar.setValue(a);
	}
	
	public void setStartListener (ActionListener listener){
		startButton.addActionListener(listener);
	}
	
	public void setBackListener (ActionListener listener){
		backButton.addActionListener(listener);
	}
	
	public void setButtonsListener (ActionListener listener, int i){
		buttons.get(i).addActionListener(listener);
	}
	
	public void changeCard1Icon(int i){
		card1.setIcon(icons.get(i-1));
	}
	
	public void changeCard2Icon(int i){
		card2.setIcon(icons.get(i-1));
	}
	
	public int getButtonValue(int i){
		return buttons.get(i).getValue();
	}
}
