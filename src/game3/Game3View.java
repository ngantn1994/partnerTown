package game3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import view.BufferedImageButton;
import view.ImagePanel;

public class Game3View extends JDialog {
	
	private static final long serialVersionUID = 1L;
	
	private static final String STARTBG = "images/game3/start.jpg";
	private static final String MAINBG = "images/game3/mainbg.jpg";
	private static final String OVERBG = "images/game3/gameover.jpg";
	private static final String YOUWON = "images/game3/youwon.jpg";
	private static final String START1 = "images/game3/start1.png";
	private static final String START2 = "images/game3/start2.png";
	private static final String BACK1 = "images/game3/back1.png";
	private static final String BACK2 = "images/game3/back2.png";
	private static final String BACK3 = "images/game3/back3.png";
	private static final String BACK4 = "images/game3/back4.png";
	private static final String MALE1 = "images/game3/male1.png";
	private static final String MALE2 = "images/game3/male2.png";
	private static final String FEMALE1 = "images/game3/female1.png";
	private static final String FEMALE2 = "images/game3/female2.png";
	private static final String POLICE1 = "images/game3/police1.png";
	private static final String POLICE2 = "images/game3/police2.png";
	private static final String WAITING[] = {"male.jpg","female.jpg","pervert.jpg"};
	
	private static final Font BIGGER_FONT = new Font(Font.SERIF, Font.PLAIN, 40);
	private int fgValue = Integer.parseInt( "F1F1F3", 16);
	private Color fgColor = new Color(fgValue);
	private int fgValueWin = Integer.parseInt( "7F3A59", 16);
	private Color fgColorWin = new Color(fgValueWin);
	private int fgValueGO = Integer.parseInt( "000000", 16);
	private Color fgColorGO = new Color(fgValueGO);

	private ImagePanel bgPanel;
	private JPanel playPanel;
	
	private JProgressBar timeBar;
	private JLabel scoreLabel;
	private JLabel waiting;
	private BufferedImageButton maleButton;
	private BufferedImageButton femaleButton;
	private BufferedImageButton policeButton;
	
	private BufferedImageButton startButton;
	private BufferedImageButton backWinButton;
	private BufferedImageButton backGOButton;
	
	private List<ImageIcon> waitingIcon;
	
	private int score = 0;
	
	private static Game3View view = new Game3View();
	
	public static Game3View getInstance(){
		view.resetScore();
		view.setTimeBarValue(100);
		return view;
	}
	
	private Game3View() {
		this.setResizable(false);
		this.setTitle("Toilet Rush");
		this.setBounds(150, 5, 1000, 720);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		bgPanel = new ImagePanel(STARTBG);
		bgPanel.setLayout(null);
		
		startButton = new BufferedImageButton(START1, START2, 100, 50);
		startButton.setBounds(445, 600, 100, 50);
		
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
		
		playPanel = new JPanel();
		playPanel.setOpaque(false);
		playPanel.setLayout(null);
		playPanel.setPreferredSize(new Dimension(900, 550));
		
		maleButton = new BufferedImageButton(MALE1, MALE2, 250, 250);
		maleButton.setBounds(50, 0, 250, 250);
		playPanel.add(maleButton);
		
		femaleButton = new BufferedImageButton(FEMALE1, FEMALE2, 250, 250);
		femaleButton.setBounds(650, 0, 250, 250);
		playPanel.add(femaleButton);
		
		policeButton = new BufferedImageButton(POLICE1, POLICE2, 250, 250);
		policeButton.setBounds(360, 270, 250, 250);
		playPanel.add(policeButton);
		
		waitingIcon = new ArrayList<ImageIcon>();
		
		for(int i=0;i<WAITING.length;i++){
			ImageIcon icon = new ImageIcon(getClass().getResource(WAITING[i]));
			waitingIcon.add(icon);
		}
		
		waiting = new JLabel();
		waiting.setIcon(waitingIcon.get(2));
		waiting.setPreferredSize(new Dimension(250, 250));
		waiting.setBounds(360, 0, 250, 250);
		playPanel.add(waiting);
		
		backGOButton = new BufferedImageButton(BACK1, BACK2, 300, 120);
		backGOButton.setBounds(380, 550, 300, 120);
		
		backWinButton = new BufferedImageButton(BACK3, BACK4, 300, 120);
		backWinButton.setBounds(480, 550, 300, 120);
		
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
		
		scoreLabel.setForeground(fgColor);
		bgPanel.add(scoreLabel);
		
		timeBar.setValue(100);
		bgPanel.add(timeBar);
		
		JLabel emptyLabel = new JLabel();
		emptyLabel.setPreferredSize(new Dimension(900, 50));
		emptyLabel.setOpaque(false);
		bgPanel.add(emptyLabel);
		
		bgPanel.add(playPanel);
		
		bgPanel.setVisible(true);
		this.setContentPane(bgPanel);
		
	}
	
	public void gameOver(){
		bgPanel.setVisible(false);
		
		bgPanel = new ImagePanel(OVERBG);
		bgPanel.setLayout(null);
		
		scoreLabel.setForeground(fgColorGO);
		scoreLabel.setBounds(300, 480, 900, 50);
		bgPanel.add(scoreLabel);
		
		bgPanel.add(backGOButton);
		
		bgPanel.setVisible(true);
		this.setContentPane(bgPanel);
	}
	
	public void youWon(){
		bgPanel.setVisible(false);
		
		bgPanel = new ImagePanel(YOUWON);
		bgPanel.setLayout(null);
		
		scoreLabel.setForeground(fgColorWin);
		scoreLabel.setBounds(220, 330, 900, 50);
		bgPanel.add(scoreLabel);
		
		bgPanel.add(backWinButton);
		
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
	
	public void setBackGOListener (ActionListener listener){
		backGOButton.addActionListener(listener);
	}
	
	public void setBackWinListener (ActionListener listener){
		backWinButton.addActionListener(listener);
	}
	
	public void setMaleButtonListener (ActionListener listener){
		maleButton.addActionListener(listener);
	}
	
	public void setFemaleButtonListener (ActionListener listener){
		femaleButton.addActionListener(listener);
	}
	
	public void setPoliceButtonListener (ActionListener listener){
		policeButton.addActionListener(listener);
	}
	
	public void changeWaiting(int i){
		waiting.setIcon(waitingIcon.get(i));
	}
}
