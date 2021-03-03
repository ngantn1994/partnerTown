package game1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import view.BufferedImageButton;

public class Game1View extends JDialog {
	
	private static final long serialVersionUID = 1L;
	
	private static final String START1 = "images/game1/start1.png";
	private static final String START2 = "images/game1/start2.png";
	private static final String BACK1 = "images/game1/back1.png";
	private static final String BACK2 = "images/game1/back2.png";
	private static final String BACK3 = "images/game1/back3.png";
	private static final String BACK4 = "images/game1/back4.png";

	private static final Font BIGGER_FONT = new Font(Font.SERIF, Font.PLAIN, 40);
	private static final Font SMALLER_FONT = new Font(Font.SERIF, Font.PLAIN, 30);
	private static final Color marked = Color.RED;
	private int fgValueWin = Integer.parseInt( "FDFEF8", 16);
	private Color fgColorWin = new Color(fgValueWin);
	private int fgValueGO = Integer.parseInt( "22272D", 16);
	private Color fgColorGO = new Color(fgValueGO);
	
	private ImagePanel bgPanel;
	private JPanel buttonPanel;
	private JPanel timePanel;
	private JProgressBar timeBar;
	private JLabel timeLabel;
	private JLabel scoreLabel;
	private game1.ImageButton buttons[];
	private BufferedImageButton startButton;
	
	private BufferedImageButton backWinButton;
	private BufferedImageButton backGOButton;
	
	private int score = 0;
	private int count = 0;
	
	private static Game1View view = new Game1View();
	
	public static Game1View getInstance(){
		view.resetScore();
		view.setTimeBarValue(100);
		return view;
	}
	
	private Game1View() {
		this.setResizable(false);
		this.setTitle("Flip Flop");
		this.setBounds(150, 5, 1000, 720);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		bgPanel = new ImagePanel("start.jpg", 0);
		bgPanel.setLayout(null);
		
		startButton = new BufferedImageButton(START1, START2, 100, 50);
		startButton.setBounds(130, 600, 100, 50);
		
		bgPanel.add(startButton);
		
		this.setContentPane(bgPanel);
		
		backWinButton = new BufferedImageButton(BACK1, BACK2, 300, 120);
		backWinButton.setBounds(250, 400, 300, 120);
		
		backGOButton = new BufferedImageButton(BACK3, BACK4, 300, 120);
		backGOButton.setBounds(350, 550, 300, 120);
		
		timePanel = new JPanel(new FlowLayout());
		timePanel.setOpaque(false);
		
		timeLabel = new JLabel("Time", JLabel.CENTER);
		timeLabel.setBorder(null);
		timeLabel.setFont(SMALLER_FONT);
		timeLabel.setOpaque(false);
		timeLabel.setForeground(marked);
		timePanel.add(timeLabel);
		
		timeBar = new JProgressBar();
		timeBar.setMaximumSize(new Dimension(750, 30));
		timeBar.setMinimumSize(new Dimension(750, 30));
		timeBar.setPreferredSize(new Dimension(750, 30));
		timeBar.setValue(100);
		timeBar.setAlignmentX(0f);
		timePanel.add(timeBar);
	}
	
	public void startAgain(){
		bgPanel.setVisible(false);
		resetScore();
		
		bgPanel = new ImagePanel("start.jpg", 0);
		bgPanel.setLayout(null);
		
		bgPanel.add(startButton);
		
		bgPanel.setVisible(true);
		this.setContentPane(bgPanel);
	}
	
	public void addLevel(int a){
		this.count = 0;
		bgPanel.setVisible(false);
		
		bgPanel = new ImagePanel("lv"+a+".jpg", a);
		bgPanel.setLayout(new FlowLayout());
		
		timeBar.setValue(100);
		bgPanel.add(timePanel);
		
		scoreLabel = new JLabel(score+"$",JLabel.CENTER);
		scoreLabel.setBorder(null);
		scoreLabel.setFont(BIGGER_FONT);
		scoreLabel.setOpaque(false);
		scoreLabel.setForeground(marked);
		scoreLabel.setPreferredSize(new Dimension(1000,40));
		bgPanel.add(scoreLabel);
		
		JLabel emptyLabel = new JLabel();
		emptyLabel.setBorder(null);
		emptyLabel.setOpaque(false);
		emptyLabel.setPreferredSize(new Dimension(1000,5));
		bgPanel.add(emptyLabel);
		
		int u = levelHeight(a);
		int v = levelWidth(a);
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(u,v,0,0));
		buttonPanel.setOpaque(false);
		bgPanel.add(buttonPanel);
		
		RandomArray array = new RandomArray(u, v);
		buttons = new game1.ImageButton[array.getLength()];
		
		for(int i=0;i<array.getLength();i++){
			buttons[i] = new game1.ImageButton(array.getNumber(i));
			buttonPanel.add(buttons[i]);
		}
		bgPanel.setVisible(true);
		this.setContentPane(bgPanel);
	}
	
	public int getCount() {
		return count;
	}

	public void incCount() {
		this.count++;
	}

	public void setButtonListener(ActionListener listener) {
		for(int i = 0; i<buttons.length;i++){
			 buttons[i].addActionListener(listener);
		}
	}
	
	public void setStartListener (ActionListener listener){
		startButton.addActionListener(listener);
	}
	
	public void setBackWinListener (ActionListener listener){
		backWinButton.addActionListener(listener);
	}
	
	public void setBackGOListener (ActionListener listener){
		backGOButton.addActionListener(listener);
	}
	
	public void youWin(){
		bgPanel.setVisible(false);
		bgPanel = new ImagePanel("youwin.jpg",0);
		bgPanel.setLayout(null);
		
		scoreLabel = new JLabel(score+"$",JLabel.CENTER);
		scoreLabel.setBorder(null);
		scoreLabel.setFont(BIGGER_FONT);
		scoreLabel.setForeground(fgColorWin);
		scoreLabel.setBounds(25, 355, 1000, 40);
		bgPanel.add(scoreLabel);
		
		bgPanel.add(backWinButton);

		bgPanel.setVisible(true);
		this.setContentPane(bgPanel);
	}
	
	public void gameOver(){
		bgPanel.setVisible(false);
		bgPanel = new ImagePanel("gameover.jpg",0);
		
		bgPanel.setLayout(null);
		
		scoreLabel = new JLabel(score+"$",JLabel.CENTER);
		scoreLabel.setBorder(null);
		scoreLabel.setFont(BIGGER_FONT);
		scoreLabel.setForeground(fgColorGO);
		scoreLabel.setBounds(170, 170, 1000, 40);
		bgPanel.add(scoreLabel);
		
		bgPanel.add(backGOButton);
		
		bgPanel.setVisible(true);
		this.setContentPane(bgPanel);
	}
	
		

	public int buttonsLength(){
		return this.buttons.length;
	}
	
	public boolean equalToButtonI(Object object, int i){
		if (object.equals(buttons[i])){
			return true;
		} else {
			return false;
		}
	}

	public boolean isUp(int i){
		return buttons[i].isUp();
	}
	
	public void redlineBorder(int i){
		buttons[i].up();
	}
	
	public void deleteBorder(final int i){
		buttons[i].down();
	}
	
	public boolean sameKindOfButton(int i, int j){
		try {
			int u = buttons[i].getNumber();
			int v =  buttons[j].getNumber();
			if(u == v){
				return true;
			} else {
				return false;
			}
		} catch (ArrayIndexOutOfBoundsException error){
			error.printStackTrace();
		}
		return rootPaneCheckingEnabled;
		
	}

	public void disableButton(int i){
		buttons[i].setVisible(false);
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
	
	public int levelWidth(int i){
		switch (i) {
		case 1: return 4;
		case 2: return 4;
		case 3: return 8;
		case 4: return 8;
		case 5: return 8;
		case 6: return 8;
		}
		return 0;
	}
	
	public int levelHeight(int i){
		switch (i) {
		case 1: return 1;
		case 2: return 2;
		case 3: return 2;
		case 4: return 3;
		case 5: return 4;
		case 6: return 5;
		}
		return 0;
	}

}
