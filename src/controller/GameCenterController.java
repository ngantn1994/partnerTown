package controller;

import game1.Game1Controller;
import game2.Game2Controller;
import game3.Game3Controller;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.UserDAO;
import view.GameCenter;
import view.MainMap;
import view.View;

public class GameCenterController {
	
	public static final String ERROR = "Không \u0111\u1EE7 Energy \u0111\u1EC3 ch\u01A1i game này.";
	public static final String ERROR_TITLE = "Thông báo";
	
	private GameCenter view;
	private UserDAO model;
	
	private static GameCenterController ctrl = new GameCenterController();
	
	private GameCenterController(){
		GameCenter.changeMoney(Information.getInstance().getUser().getMoney());
		view = GameCenter.getInstance();

		view.setGame1ButtonListener(getGame1ActionListener());
		view.setGame2ButtonListener(getGame2ActionListener());
		view.setGame3ButtonListener(getGame3ActionListener());
		view.setInventoryButtonListerner(getInventoryActionListener());
		view.setMapButtonListerner(getMapActionListener());
		model = UserDAO.getInstance();
	}
	
	private ActionListener getGame1ActionListener(){
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Information.getInstance().getUser().decEnergyByTen()){
					model.updateEnergy(Information.getInstance().getUser());
					View.updateEnergyBar();
					Game1Controller.getInstance();
				} else {
					NoticeSound.click();
					JOptionPane.showMessageDialog(null, ERROR, ERROR_TITLE, JOptionPane.INFORMATION_MESSAGE);
				}
			}
		};
		return listener;
	}
	
	private ActionListener getGame2ActionListener(){
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Information.getInstance().getUser().decEnergyByFive()){
					model.updateEnergy(Information.getInstance().getUser());
					View.updateEnergyBar();
					Game2Controller.getInstance();
				} else {
					NoticeSound.click();
					JOptionPane.showMessageDialog(null, ERROR, ERROR_TITLE, JOptionPane.INFORMATION_MESSAGE);
				}
			}
		};
		return listener;
	}
	
	private ActionListener getGame3ActionListener(){
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Information.getInstance().getUser().decEnergyByTwo()){
					model.updateEnergy(Information.getInstance().getUser());
					View.updateEnergyBar();
					Game3Controller.getInstance();
				} else {
					NoticeSound.click();
					JOptionPane.showMessageDialog(null, ERROR, ERROR_TITLE, JOptionPane.INFORMATION_MESSAGE);
				}
			}
		};
		return listener;
	}

	private ActionListener getInventoryActionListener(){
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new InventoryController();
			}
		};
		return listener;
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
		GameCenter.reAddEnergybar();
		GameCenter.changeMoney(Information.getInstance().getUser().getMoney());
		return ctrl.view.getContentPane();
	}
	
}
