package game1;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Image bgImage;
	private String imgName;
	private int level; 
	public ImagePanel(String image, int k){
		this.level = k;
		this.imgName = image;
		ImageIcon bgIcon = new ImageIcon(getClass().getResource(imgName));
		this.bgImage = bgIcon.getImage();
		Dimension size = new Dimension(bgImage.getWidth(null), bgImage.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
		setVisible(true);
	}
	
	public int getLevel(){
		return this.level;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(bgImage, 0, 0, null);
	}
}
