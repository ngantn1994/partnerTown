package controller;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import model.LogInModel;
import model.User;
import model.UserPet;
import model.UserStock;
import view.LogInScreen;
import view.View;

public class LogInController {

	private LogInScreen view;
	private static LogInModel model;
	
	private static final String NOTICETITLE = "\u0110\u0103ng nh\u1eadp th\u1ea5t b\u1ea1i";
	private static final String NOTICE = "T\u00ean \u0111\u0103ng nh\u1eadp ho\u1eb7c m\u1eadt kh\u1ea9u kh\u00f4ng \u0111\u00fang.";
	
	private static LogInController ctrl = new LogInController();
	
	private LogInController(){
		view = LogInScreen.getInstance();
		view.addLogInButtonListener(getLogInActionListener());
		view.addRegisterButtonListener(getRegisterActionListener());
		model = new LogInModel();	
	}
	
	private ActionListener getLogInActionListener(){
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(model.checkLogIn(view.getUsername(), view.getPassword())){
					NoticeSound.chimes();
					View.changeContentPane(MainMapController.getContentPane());
					View.updateEnergyBar();
					Controller.getInstance();
				} else {
					NoticeSound.click();
					JOptionPane.showMessageDialog(null, NOTICE, NOTICETITLE, JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		};
		
		return listener;
	}
	
	private ActionListener getRegisterActionListener(){
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				NoticeSound.click();
				@SuppressWarnings("unused")
				SignUpController ctrl = new SignUpController();				
			}
		};
		
		return listener;
	}
	
	public static Container getContentPane(){
		return ctrl.view.getContentPane();
	}
	
	public static String getUserName(){
		return model.getUsername();
	}
	
	public static User getUser(){
		return model.getUser();
	}
	
	public static List<UserPet> getPets(){
		return model.getPets();
	}
	
	public static UserStock getStock(){
		return model.getStock();
	}
	
}
