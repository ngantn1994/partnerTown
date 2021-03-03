package game1;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ImageButton extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int number;
	private boolean up;
	
	private ImageIcon defaultIcon = new ImageIcon(getClass().getResource("00.jpg"));
	private ImageIcon numberIcon;
	
	public ImageButton(){
		super();
	}
	
	public ImageButton(int k){
		super();
		this.number = k;
		this.up = false;
		this.setIcon(defaultIcon);
		this.numberIcon = new ImageIcon(getClass().getResource(""+number+".jpg"));
		this.setPreferredSize(new Dimension(75,100));
		
	}
	
	public void up(){
		this.setIcon(numberIcon);
		this.up = true;
	}
	
	public void down(){
		this.setIcon(defaultIcon);
		this.up = false;
	}
	
	public boolean isUp(){
		return up;
	}
	
	public int getNumber(){
		return number;
	}

}