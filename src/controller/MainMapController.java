package controller;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainMap;
import view.View;

public class MainMapController {
	
	private static ActionListener getHomeActionListener(){
		
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				View.changeContentPane(HomeController.getContentPane());
			}
		};
	
		return listener;
	}
	
	private static ActionListener getPetCenterActionListener(){
		
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				View.changeContentPane(PetCenterStartController.getContentPane());
			}
		};
	
		return listener;
	}
	
	private static ActionListener getPetHouseActionListener(){
		
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				View.changeContentPane(PetHouseController.getContentPane());				
			}
		};
	
		return listener;
	}
	
	private static ActionListener getShopActionListener(){
		
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				View.changeContentPane(ShopController.getContentPane());
			}
		};
	
		return listener;
	}
	
	private static ActionListener getGameCenterActionListener(){
		
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				View.changeContentPane(GameCenterController.getContentPane());
			}
		};
	
		return listener;
	}
	
	private static ActionListener getDrinksActionListener(){
		
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				View.changeContentPane(DrinksController.getContentPane());
			}
		};
	
		return listener;
	}
	
	public static Container getContentPane(){
		MainMap.getInstance().addHomeButtonListener(getHomeActionListener());
		MainMap.getInstance().addPetCenterButtonListener(getPetCenterActionListener());
		MainMap.getInstance().addPetHouseButtonListener(getPetHouseActionListener());
		MainMap.getInstance().addShopButtonListener(getShopActionListener());
		MainMap.getInstance().addGameCenterButtonListener(getGameCenterActionListener());
		MainMap.getInstance().addDrinksButtonListener(getDrinksActionListener());
		return MainMap.getInstance().getContentPane();
	}

}
