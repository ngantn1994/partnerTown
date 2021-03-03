package controller;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainMap;
import view.PetCenterStart;
import view.View;

public class PetCenterStartController {
	
	private static PetCenterSellController ctrl;
	
	private static ActionListener getBuyActionListener(){
		
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				View.changeContentPane(PetCenterBuyController.getContentPane());
			}
		};
		
		return listener;
	}
	
	private static ActionListener getSellActionListener(){
		
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl = null;
				System.gc();
				ctrl = new PetCenterSellController();
				View.changeContentPane(ctrl.getContentPane());
			}
		};
		
		return listener;
	}

	private static ActionListener getMapActionListener(){
	
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
		PetCenterStart.getInstance().setBuyButtonListerner(getBuyActionListener());
		PetCenterStart.getInstance().setSellButtonListerner(getSellActionListener());
		PetCenterStart.getInstance().setMapButtonListerner(getMapActionListener());
		return PetCenterStart.getInstance().getContentPane();
	}

}
