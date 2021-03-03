package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JProgressBar;

public class PatternProgressBar extends JProgressBar {

	private static final long serialVersionUID = 1L;

	private BufferedImage bgImage;
	private BufferedImage potionBar;
	
	public PatternProgressBar(String image){
		try {
            bgImage = ImageIO.read(getClass().getResource(image));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
		setOpaque(false);
		setPreferredSize(new Dimension(500,30));
		setBackground(Color.WHITE);
		setValue(100);
	}
	
	@Override
    public void invalidate() {
        super.invalidate();
        potionBar = null;
    }
	
	protected void createPotionBar() {

        if (potionBar == null) {
            if (getWidth() > 0 && getHeight() > 0) {
                int height = getHeight();
                potionBar = new BufferedImage(getWidth(), height, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = potionBar.createGraphics();
                int x = 0;
                int y = (height - bgImage.getHeight());
                while (x < getWidth()) {
                    g2d.drawImage(bgImage, x, y, this);
                    x += bgImage.getWidth();
                }
                g2d.dispose();
            }
        }
    }
	
	 @Override
     protected void paintComponent(Graphics g) {
         createPotionBar();
         super.paintComponent(g);

         int width = getWidth() - 4;
         int height = getHeight() - 4;
         int x = 2;
         int y = 2;

         g.setColor(getBackground());
         g.fillRect(x, y, width, height);
         g.setColor(getForeground());
         g.drawRect(x, y, width, height);

         if (getValue() != 0){
        	 int progressWidth = (int) (width * getValue()/100);
        	 BufferedImage progressImage = potionBar.getSubimage(0, 0, progressWidth, potionBar.getHeight());
        	 g.drawImage(progressImage, x, y, this);
         }
               
         FontMetrics fm = g.getFontMetrics();
         String value = ""+getValue()/2+"/50";
         x = x + ((width - fm.stringWidth(value)) / 2);
         y = y + ((height - fm.getHeight()) / 2);

         g.setColor(getForeground());
         g.drawString(value, x, y + fm.getAscent());

     }
	
}
