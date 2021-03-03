package view;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BufferedImageButton extends JButton {
	private static final long serialVersionUID = 1L;

	private ImageIcon defaultIcon;
	private ImageIcon hoverIcon;
	
	/**
	 * Create a normal JButton.
	 * */
	
	public BufferedImageButton(){
		super();
	}
	
	/**
	 * Create a newHoverButton Object.
	 * @param img1 url of normal image of the button
	 * @param img2 url hover image of the button
	 * @param width button width
	 * @param height button height
	 * */
	
	public BufferedImageButton(String img1, String img2, int width, int height){
		super();
		try {
			BufferedImage defaultImg = ImageIO.read(getClass().getResource(img1));
			BufferedImage hoverImg = ImageIO.read(getClass().getResource(img2));
			defaultIcon = new ImageIcon(defaultImg);
			hoverIcon = new ImageIcon(hoverImg);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
