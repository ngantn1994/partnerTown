package view;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SoundButton extends JButton {
	private static final long serialVersionUID = 1L;	
	
	private ImageIcon normalIcon;
	private ImageIcon muteIcon;

	public SoundButton(boolean isOn){
		super();
		try {
			BufferedImage normal = ImageIO.read(getClass().getResource("images/setting/sound1.png"));
			BufferedImage mute = ImageIO.read(getClass().getResource("images/setting/sound2.png"));
			normalIcon = new ImageIcon(normal);
			muteIcon = new ImageIcon(mute);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(isOn){
			setIcon(normalIcon);
		} else {
			setIcon(muteIcon);
		}
		setPreferredSize(new Dimension(64,64));
		setBorder(null);
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
	}
	
	public void click(){
		if(getIcon().equals(normalIcon)){
			setIcon(muteIcon);
		} else {
			setIcon(normalIcon);
		}
	}
	
}