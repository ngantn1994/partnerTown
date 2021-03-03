package controller;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.UserDAO;
import view.Home;
import view.HomeDialog;
import view.MainMap;
import view.View;

public class HomeController {
	
	private static final String ERROR_TITLE = "Thông báo";
	private static final String ERROR_PASSWORD1 = "Sai m\u1EADt kh\u1EA9u.";
	private static final String ERROR_PASSWORD2 = "M\u1EADt kh\u1EA9u m\u1EDBi ph\u1EA3i n\u1EB1m trong kho\u1EA3ng t\u1EEB 6 \u0111\u1EBFn 16 ký t\u1EF1.";
	private static final String ERROR_PASSWORD3 = "M\u1EADt kh\u1EA9u m\u1EDBi không \u0111\u01B0\u1EE3c ch\u1EE9a d\u1EA5u cách.";
	private static final String ERROR_PASSWORD4 = "M\u1EADt kh\u1EA9u và m\u1EADt kh\u1EA9u gõ l\u1EA1i ph\u1EA3i trùng nhau.";
	
	private Home view; 
	private UserDAO model;
	private HomeDialog dialog;
	
	private static HomeController ctrl = new HomeController();
	
	private HomeController(){
		view = Home.getInstance();
		view.setSaveButtonListener(getSaveActionListener());
		view.setUndoButtonListener(getUndoActionListener());
		view.setChangePasswordButtonListener(getChangePasswordActionListener());
		view.setSettingButtonListerner(getSettingActionListener());
		view.setInventoryButtonListerner(getInventoryActionListener());
		view.setMapButtonListerner(getMapActionListener());
		getInformation();
		model = UserDAO.getInstance();
	}
	
	private void getInformation(){
		view.setEmail(Information.getInstance().getUser().getEmail());
		view.setAddress(Information.getInstance().getUser().getAddress());
		view.setSex(Information.getInstance().getUser().isSex());
	}
	
	private void updateInformation(){
		Information.getInstance().getUser().setEmail(view.getEmail());
		Information.getInstance().getUser().setAddress(view.getAddress());
		Information.getInstance().getUser().setSex(view.isSex());
		model.updateInformation(Information.getInstance().getUser());
	}

	private ActionListener getSaveActionListener(){
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				updateInformation();
				NoticeSound.change();
			}
		};
		return listener;
	}
	
	private ActionListener getUndoActionListener(){
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getInformation();
				NoticeSound.whoosh();
			}
		};
		return listener;
	}
	
	private ActionListener getChangePasswordActionListener(){
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog = new HomeDialog();
				dialog.addSaveButtonActionListener(getDialogSaveActionListener());
				dialog.addExitButtonActionListener(getDialogExitActionListener());
				dialog.setModal(true);
				NoticeSound.laser();
				dialog.setVisible(true);
			}
		};
		return listener;
	}
	
	private ActionListener getSettingActionListener(){
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new SettingController();
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
		ctrl.changeInformation();
		return ctrl.view.getContentPane();
	}
	
	private void changeInformation(){
		Home.reAddEnergybar();
		getInformation();
	}
	
	private int checkPassword(){
		if(!Information.getInstance().getUser().getPassword().equals(dialog.getOldPassword())){
			return 1;
		}
		String temp = dialog.getNewPassword();
		if(temp.length()<6||temp.length()>16){
			return 2;
		}
		for(int i=0; i<temp.length(); i++){
			if(temp.charAt(i)==' '){
				return 3;
			}
		}
		if(!dialog.getNewPassword().equals(dialog.getRetypePassword())){
			return 4;
		}
		return 0;
	}
	
	private ActionListener getDialogSaveActionListener(){
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int t = checkPassword();
				if(t == 0){
					Information.getInstance().getUser().setPassword(dialog.getNewPassword());
					model.updatePassword(Information.getInstance().getUser());
					NoticeSound.change();
					dialog.dispose();
				} else {
					NoticeSound.click();
					switch(t) {
					case 1:
						JOptionPane.showMessageDialog(null, ERROR_PASSWORD1, ERROR_TITLE, JOptionPane.INFORMATION_MESSAGE);
						return;
					case 2:
						JOptionPane.showMessageDialog(null, ERROR_PASSWORD2, ERROR_TITLE, JOptionPane.INFORMATION_MESSAGE);
						return;
					case 3:
						JOptionPane.showMessageDialog(null, ERROR_PASSWORD3, ERROR_TITLE, JOptionPane.INFORMATION_MESSAGE);
						return;
					case 4:
						JOptionPane.showMessageDialog(null, ERROR_PASSWORD4, ERROR_TITLE, JOptionPane.INFORMATION_MESSAGE);
						return;
					default:
						return;
					}
				}
			}
		};
		return listener;
	}
	
	private ActionListener getDialogExitActionListener(){
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
				NoticeSound.whoosh();
			}
		};
		return listener;
	}
	
}
