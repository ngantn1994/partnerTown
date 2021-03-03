package view;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Button which display a png or gif image.
 * */

public class ImageButton extends JButton {

	private static final long serialVersionUID = 1L;

	private ImageIcon defaultIcon;
	private ImageIcon hoverIcon;
	
	/**
	 * Create a normal JButton.
	 * */
	
	public ImageButton(){
		super();
	}
	
	/**
	 * Create a new ImageButton Object.
	 * @param img1 url of normal image of the button
	 * @param img2 url hover image of the button
	 * @param width button width
	 * @param height button height
	 * */
	
	public ImageButton(String img1, String img2, int width, int height){
		super();
		defaultIcon = new ImageIcon(getClass().getResource(img1));
		hoverIcon = new ImageIcon(getClass().getResource(img2));
		setIcon(defaultIcon);
		setRolloverIcon(hoverIcon);
		setPreferredSize(new Dimension(width,height));
		setBorder(null);
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
	}
	
	/**
	 * Hover the button.
	 * */
	
	public void hover(){
		hoverIcon.getImage().flush();
	}

}