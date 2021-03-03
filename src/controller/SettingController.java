package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Setting;
import view.View;

public class SettingController {
	
	private Setting view;
	
	public SettingController(){
		super();
		view = new Setting(View.isOn());
		view.addSoundButtonListener(getSoundActionListener());
		view.addDoneButtonListener(getDoneActionListener());
		view.setModal(true);
		NoticeSound.laser();
		view.setVisible(true);
	}

	private ActionListener getSoundActionListener(){
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				view.clicked();
				if(View.isOn()){
					View.musicOff();
				} else {
					View.musicOn();
				}
			}
		};
		return listener;
	}
	
	private ActionListener getDoneActionListener(){
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				view.dispose();
				NoticeSound.whoosh();
			}
		};
		return listener;
	}
	
}
