package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.UserDAO;
import view.Inventory;
import view.View;

public class InventoryController {

	private UserDAO model;
	private Inventory view;
	
	public InventoryController(){
		super();
		model = UserDAO.getInstance();
		view = new Inventory(Information.getInstance().getStock());
		view.addGrapeActionListener(getGrapeActionListener());
		view.addMangoActionListener(getMangoActionListener());
		view.setModal(true);
		NoticeSound.laser();
		view.setVisible(true);
	}
	
	private ActionListener getGrapeActionListener(){
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Information.getInstance().getStock().getGrape()>0){	
					Information.getInstance().getUser().incEnergyByOne();
					View.updateEnergyBar();
					Information.getInstance().getStock().decGrape();
					model.updateEnergy1(Information.getInstance().getStock());
					view.updateGrape();
					NoticeSound.whoosh();
				} else {
					NoticeSound.click();
				}
			}
		};
		
		return listener;
	}
	
	private ActionListener getMangoActionListener(){
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Information.getInstance().getStock().getMango()>0){	
					Information.getInstance().getUser().incEnergyByFive();
					View.updateEnergyBar();
					Information.getInstance().getStock().decMango();
					model.updateEnergy5(Information.getInstance().getStock());
					view.updateMango();
					NoticeSound.whoosh();
				} else {
					NoticeSound.click();
				}
			}
		};
		
		return listener;
	}
	
}
