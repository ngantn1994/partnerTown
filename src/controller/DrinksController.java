package controller;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Drinks;
import view.MainMap;
import view.View;

public class DrinksController {
	
	private Drinks view;
	
	private static DrinksController ctrl = new DrinksController();
	
	public static DrinksController getInstance(){
		return ctrl;
	}
	
	private DrinksController(){
		view = Drinks.getInstance();
		view.setMapButtonListerner(getMapActionListener());
	}
	
	private ActionListener getMapActionListener(){
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainMap.reAddEnergybar();
				View.changeContentPane(MainMapController.getContentPane());
			}
		};
		return listener;
	}
	
	public static Container getContentPane(){
		return ctrl.view.getContentPane();
	}

}
