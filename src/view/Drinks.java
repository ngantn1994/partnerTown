package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drinks extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private static final String BGIMG = "images/drinks/drinks.png";
	private static final String MAP1 = "images/buttons/map1.png";
	private static final String MAP2 = "images/buttons/map2.png";
	
	private static final String TITLE = "Drinks";
	
	private BufferedImageButton mapButton;
	
	private static Drinks view = new Drinks();
	
	public static Drinks getInstance(){
		return view;
	}
	
	private Drinks(){
		super();
		
		this.setResizable(false);
		this.setTitle(TITLE);
		this.setBounds(150, 5, 1000, 720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new FlowLayout());
		
		ImagePanel bgPanel = new ImagePanel(BGIMG);
		bgPanel.setLayout(new BorderLayout(0, 0));
		
		mapButton = new BufferedImageButton(MAP1, MAP2, 300, 100);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		buttonPanel.setPreferredSize(new Dimension(1000, 100));
		buttonPanel.setLayout(new BorderLayout(0, 0));
		
		buttonPanel.add(mapButton, BorderLayout.EAST);
		
		bgPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		setContentPane(bgPanel);
	}
	
	public void setMapButtonListerner(ActionListener listerner){
		mapButton.addActionListener(listerner);
	}

}
