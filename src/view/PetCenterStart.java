package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PetCenterStart extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private static final String TITLE = "Partner Center";
	
	private static final  String FIRSTBG = "images/petcenter/firstbg.png";
	private static final  String BANNER = "images/petcenter/banner.png";
	private static final  String BUY1 = "images/petcenter/buy1.png";
	private static final  String BUY2 = "images/petcenter/buy2.png";
	private static final  String SELL1 = "images/petcenter/sell1.png";
	private static final  String SELL2 = "images/petcenter/sell2.png";

	private static final String MAP1 = "images/buttons/map1.png";
	private static final String MAP2 = "images/buttons/map2.png";
	
	private BufferedImageButton buyButton;
	private BufferedImageButton sellButton;
	
	private BufferedImageButton mapButton;
	
	private static PetCenterStart screen = new PetCenterStart();
	
	private PetCenterStart(){
		this.setResizable(false);
		this.setTitle(TITLE);
		this.setBounds(150, 5, 1000, 720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new FlowLayout());
		
		ImagePanel bgPanel = new ImagePanel(FIRSTBG);
		bgPanel.setLayout(new BorderLayout(0, 0));
		
		ImageIcon bannerImg = new ImageIcon(getClass().getResource(BANNER));
		JLabel bannerLabel = new JLabel(bannerImg);
		bannerLabel.setOpaque(false);
		bgPanel.add(bannerLabel, BorderLayout.NORTH);
		
		JPanel button1 = new JPanel();
		button1.setOpaque(false);
		buyButton = new BufferedImageButton(BUY1, BUY2, 250, 250);
		button1.add(buyButton);
		sellButton = new BufferedImageButton(SELL1, SELL2, 250, 250);
		button1.add(sellButton);
		
		bgPanel.add(button1, BorderLayout.CENTER);
		
		JPanel button2 = new JPanel(new BorderLayout(0, 0));
		button2.setOpaque(false);
		mapButton = new BufferedImageButton(MAP1, MAP2, 300, 100);
		button2.add(mapButton, BorderLayout.EAST);
		
		bgPanel.add(button2, BorderLayout.SOUTH);
		
		setContentPane(bgPanel);
	}
	
	public void setBuyButtonListerner(ActionListener listerner){
		buyButton.addActionListener(listerner);
	}
	
	public void setSellButtonListerner(ActionListener listerner){
		sellButton.addActionListener(listerner);
	}
	
	public void setMapButtonListerner(ActionListener listerner){
		mapButton.addActionListener(listerner);
	}
	
	public static PetCenterStart getInstance(){
		return screen;
	}
}
