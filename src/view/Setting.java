package view;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

public class Setting extends JDialog {
	
	private static final long serialVersionUID = 1L;
	
	private static final String TITLE = "Cài \u0111\u1EB7t";
	private static final String BGIMG = "images/setting/background.png";
	private static final String DONE1 = "images/setting/done1.png";
	private static final String DONE2 = "images/setting/done2.png";
	
	private SoundButton soundButton;
	private BufferedImageButton doneButton;
	
	public Setting(boolean isOn){
		setTitle(TITLE);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(350, 50, 500, 530);
		
		ImagePanel bgPanel = new ImagePanel(BGIMG);
		bgPanel.setPreferredSize(new Dimension(500,500));
		
		setContentPane(bgPanel);
		
		soundButton = new SoundButton(isOn);
		soundButton.setBounds(260, 71, 64, 64);
		bgPanel.add(soundButton);
		
		doneButton = new BufferedImageButton(DONE1, DONE2, 150, 50);
		doneButton.setBounds(170, 440, 150, 50);
		bgPanel.add(doneButton);
		
		getRootPane().setDefaultButton(doneButton);
	}
	
	public void clicked(){
		soundButton.click();
	}
	
	public void addSoundButtonListener(ActionListener listener){
		soundButton.addActionListener(listener);
	}
	
	public void addDoneButtonListener(ActionListener listener){
		doneButton.addActionListener(listener);
	}
}
