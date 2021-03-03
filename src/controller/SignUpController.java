package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.SignUpModel;
import view.SignUp;

public class SignUpController {
	
	private static final String ERROR_TITLE = "\u0110\u0103ng ký không thành công";
	private static final String ERROR_USERNAME1 = "Tên \u0111\u0103ng nh\u1EADp không \u0111\u01B0\u1EE3c \u0111\u1EC3 tr\u1ED1ng.";
	private static final String ERROR_USERNAME2 = "Tên \u0111\u0103ng nh\u1EADp này \u0111ã có ng\u01B0\u1EDDi dùng.";
	private static final String ERROR_USERNAME3 = "Tên \u0111\u0103ng nh\u1EADp ph\u1EA3i n\u1EB1m trong kho\u1EA3ng t\u1EEB 6 \u0111\u1EBFn 32 ký t\u1EF1.";
	private static final String ERROR_USERNAME4 = "Tên \u0111\u0103ng nh\u1EADp không \u0111\u01B0\u1EE3c ch\u1EE9a d\u1EA5u cách.";
	private static final String ERROR_PASSWORD1 = "M\u1EADt kh\u1EA9u ph\u1EA3i n\u1EB1m trong kho\u1EA3ng t\u1EEB 6 \u0111\u1EBFn 16 ký t\u1EF1.";
	private static final String ERROR_PASSWORD2 = "M\u1EADt kh\u1EA9u không \u0111\u01B0\u1EE3c ch\u1EE9a d\u1EA5u cách.";
	private static final String ERROR_PASSWORD3 = "M\u1EADt kh\u1EA9u và m\u1EADt kh\u1EA9u gõ l\u1EA1i ph\u1EA3i trùng nhau.";
	
	private SignUp view;
	private SignUpModel model;
	
	public SignUpController(){
		view = SignUp.getInstance();
		view.setModal(true);
		view.addDoneButtonListener(getDoneActionListener());
		view.addRedoButtonListener(getRedoActionListener());
		model = new SignUpModel();
		NoticeSound.laser();
		view.setVisible(true);
	}
	
	private ActionListener getDoneActionListener(){
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int u = checkUserName();
				int v = view.isMatchPassword();
				if (u == 0 && v == 0){
					model.signUp(view.getUser());
					NoticeSound.success();
					view.dispose();
				} else {
					NoticeSound.click();
					switch (u) {
					case 0:{
						switch(v) {
						case 1:
							JOptionPane.showMessageDialog(null, ERROR_PASSWORD1, ERROR_TITLE, JOptionPane.INFORMATION_MESSAGE);
							return;
						case 2:
							JOptionPane.showMessageDialog(null, ERROR_PASSWORD2, ERROR_TITLE, JOptionPane.INFORMATION_MESSAGE);
							return;
						case 3:
							JOptionPane.showMessageDialog(null, ERROR_PASSWORD3, ERROR_TITLE, JOptionPane.INFORMATION_MESSAGE);
							return;
						default:
							return;
						}
					}
					case 1:
						JOptionPane.showMessageDialog(null, ERROR_USERNAME1, ERROR_TITLE, JOptionPane.INFORMATION_MESSAGE);
						return;
					case 2:
						JOptionPane.showMessageDialog(null, ERROR_USERNAME2, ERROR_TITLE, JOptionPane.INFORMATION_MESSAGE);
						return;
					case 3:
						JOptionPane.showMessageDialog(null, ERROR_USERNAME3, ERROR_TITLE, JOptionPane.INFORMATION_MESSAGE);
						return;
					case 4:
						JOptionPane.showMessageDialog(null, ERROR_USERNAME4, ERROR_TITLE, JOptionPane.INFORMATION_MESSAGE);
						return;
					default:
						return;
					}
				}
			}
		};
		return listener;
	}
	
	private ActionListener getRedoActionListener(){
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				NoticeSound.click();
				view.redoAllField();
			}
		};
		return listener;
	}
	
	private int checkUserName(){
		String temp = view.getUserName();
		
		if(temp.isEmpty()){
			return 1;
		}
		
		if(model.checkAvaible(temp) == false){
			return 2;
		}
		
		if(temp.length() > 32 || temp.length() < 6){
			return 3;
		}
		
		for(int i=0;i<temp.length();i++){
			if(temp.charAt(i) == ' '){
				return 4;
			}
		}
		
		return 0;
	}

}
