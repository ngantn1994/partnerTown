package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import model.UserDAO;
import view.View;

public class Controller extends Thread {
	private static Timer timer;
	
	private static Controller ctrl = new Controller();
	
	private Controller(){
		super();
	}
	
	public static void getInstance(){
		ctrl.start();
	}
	
	private void addTimeBarListener(){
		ActionListener updateProBar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				Information.getInstance().getUser().incEnergy(Information.getInstance().getPets().size());
				View.updateEnergyBar();
				UserDAO.getInstance().updateEnergy(Information.getInstance().getUser());
			}
		};
		
		timer = new Timer(60000, updateProBar);
	}
	
	private void startTimeBar(){
		addTimeBarListener();
		timer.start();
	}

	@Override
    public void run(){
    	startTimeBar();
    }
}
