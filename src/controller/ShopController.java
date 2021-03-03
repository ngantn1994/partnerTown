package controller;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.User;
import model.UserDAO;
import view.MainMap;
import view.Shop;
import view.View;

public class ShopController {
	
	public static final String ERROR_TITLE = "Thông báo";
	public static final String ERROR = "Không có \u0111\u1EE7 ti\u1EC1n \u0111\u1EC3 mua v\u1EADt ph\u1EA9m này.";
	
	private Shop view;
	private UserDAO model;

	private static ShopController ctrl = new ShopController();
	
	private ShopController(){
		view = Shop.getInstance();
		model = UserDAO.getInstance();
		view.setMilkButtonListener(getMilkActionListener());
		view.setGrapeButtonListener(getGrapeActionListener());
		view.setMangoPasswordButtonListener(getMangoActionListener());
		view.setInventoryButtonListerner(getInventoryActionListener());
		view.setMapButtonListerner(getMapActionListener());
		
	}
	
	private ActionListener getMilkActionListener(){
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(buy(25, Information.getInstance().getUser())){
					Information.getInstance().getStock().incMilk();
					model.updateFood(Information.getInstance().getStock());
					view.changeMoney(Information.getInstance().getUser().getMoney());
					NoticeSound.cash();
				} else {
					NoticeSound.click();
					JOptionPane.showMessageDialog(null, ERROR, ERROR_TITLE, JOptionPane.INFORMATION_MESSAGE);
				}
			}
		};
		return listener;
	}
	
	private ActionListener getGrapeActionListener(){
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(buy(100, Information.getInstance().getUser())){
					Information.getInstance().getStock().incGrape();
					model.updateEnergy1(Information.getInstance().getStock());
					view.changeMoney(Information.getInstance().getUser().getMoney());
					NoticeSound.cash();
				} else {
					NoticeSound.click();
					JOptionPane.showMessageDialog(null, ERROR, ERROR_TITLE, JOptionPane.INFORMATION_MESSAGE);
				}
			}
		};
		return listener;
	}
	
	private ActionListener getMangoActionListener(){
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(buy(450, Information.getInstance().getUser())){
					Information.getInstance().getStock().incMango();
					model.updateEnergy5(Information.getInstance().getStock());
					view.changeMoney(Information.getInstance().getUser().getMoney());
					NoticeSound.cash();
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
	
	private boolean buy(int money, User user){
		if(user.getMoney()<money){
			return false;
		} else {
			user.decMoney(money);
			model.updateMoney(user);
			return true;
		}
	}
	
	public static Container getContentPane(){
		ctrl.changeMoney();
		return ctrl.view.getContentPane();
	}
	
	private void changeMoney(){
		Shop.reAddEnergybar();
		view.changeMoney(Information.getInstance().getUser().getMoney());
	}

}
