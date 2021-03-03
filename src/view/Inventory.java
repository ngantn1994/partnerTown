package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;

import model.UserStock;

public class Inventory extends JDialog {
	
	private static final long serialVersionUID = 1L;

	private int fgValue = Integer.parseInt( "F9EDD5", 16);
	private Color fgColor = new Color(fgValue);
	private static final Font SMALLER_FONT = new Font(Font.SERIF, Font.BOLD, 20);

	private static final String TITLE = "Túi cá nhân";
	private static final String BGIMG = "images/inventory/background.png";
	private static final String USE1 = "images/inventory/use1.png";
	private static final String USE2 = "images/inventory/use2.png";
	
	private JLabel milkLabel;
	private JLabel grapeLabel;
	private JLabel mangoLabel;
	
	private BufferedImageButton useGrape;
	private BufferedImageButton useMango;
	private UserStock stock;
	
	public Inventory(UserStock stock){
		setTitle(TITLE);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(350, 50, 500, 530);
		this.stock = stock;
		
		ImagePanel bgPanel = new ImagePanel(BGIMG);
		bgPanel.setPreferredSize(new Dimension(500,500));
		
		setContentPane(bgPanel);
		
		milkLabel = new JLabel(stock.getMilk()+"");
		milkLabel.setOpaque(false);
		milkLabel.setFont(SMALLER_FONT);
		milkLabel.setForeground(fgColor);
		milkLabel.setBounds(330, 210, 50, 30);
		bgPanel.add(milkLabel);
		
		grapeLabel = new JLabel(stock.getGrape()+"");
		grapeLabel.setOpaque(false);
		grapeLabel.setFont(SMALLER_FONT);
		grapeLabel.setForeground(fgColor);
		grapeLabel.setBounds(330, 313, 50, 30);
		bgPanel.add(grapeLabel);
		
		mangoLabel = new JLabel(stock.getMango()+"");
		mangoLabel.setOpaque(false);
		mangoLabel.setFont(SMALLER_FONT);
		mangoLabel.setForeground(fgColor);
		mangoLabel.setBounds(330, 416, 50, 30);
		bgPanel.add(mangoLabel);
		
		useGrape = new BufferedImageButton(USE1, USE2, 100, 50);
		useGrape.setBounds(390, 329, 100, 50);
		bgPanel.add(useGrape);
		
		useMango = new BufferedImageButton(USE1, USE2, 100, 50);
		useMango.setBounds(390, 432, 100, 50);
		bgPanel.add(useMango);
	}
	
	public void updateGrape(){
		grapeLabel.setText(stock.getGrape()+"");
	}
	
	public void updateMango(){
		mangoLabel.setText(stock.getMango()+"");
	}
	
	public void addGrapeActionListener(ActionListener listener){
		useGrape.addActionListener(listener);
	}

	public void addMangoActionListener(ActionListener listener){
		useMango.addActionListener(listener);
	}
}
