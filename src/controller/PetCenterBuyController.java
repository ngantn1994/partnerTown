package controller;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.PetCenterBuyModel;
import model.PetType;
import view.MainMap;
import view.PetCenterBuy;
import view.View;

public class PetCenterBuyController {
	
	public static final String CONFIRM_TITLE = "Xác nh\u1EADn";
	public static final String ERROR_TITLE = "Thông báo";
	public static final String CONFIRM = "B\u1EA1n ch\u1EAFc ch\u1EAFn mu\u1ED1n mua partner này ch\u1EE9?";
	public static final String SUCESS = "Mua m\u1EDBi thành công!";
	public static final String FAIL = "B\u1EA1n không có \u0111\u1EE7 ti\u1EC1n \u0111\u1EC3 mua partner này.";
	private static final String NOT_SELECTED = "Ch\u01b0a c\u00f3 partner n\u00e0o \u0111\u01b0\u1ee3c ch\u1ecdn.";
	private PetCenterBuy view;
	private PetCenterBuyModel model;
	
	private static PetCenterBuyController ctrl = new PetCenterBuyController();
	
	private PetCenterBuyController(){
		model = new PetCenterBuyModel();
		view = new PetCenterBuy(View.getEnergyBar(), model);
		view.changeMoney(Information.getInstance().getUser().getMoney());
		view.setBuyButtonListerner(getBuyActionListener());
		view.setBackButtonListerner(getBackActionListener());
	}
	
	private ActionListener getBuyActionListener(){
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PetType type = view.getSelectedPetType();
				if(type == null){
					NoticeSound.click();
					JOptionPane.showMessageDialog(null, NOT_SELECTED, ERROR_TITLE, JOptionPane.INFORMATION_MESSAGE);
				} else {
					int reply = JOptionPane.showConfirmDialog(null, CONFIRM, CONFIRM_TITLE, JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION){
						if(Information.getInstance().getUser().getMoney() < type.getPrice()){
							NoticeSound.click();
							JOptionPane.showMessageDialog(null, FAIL, ERROR_TITLE, JOptionPane.INFORMATION_MESSAGE);
						} else {
							model.buy(type.getID(), Information.getInstance().getUser());
							view.changeMoney(Information.getInstance().getUser().getMoney());
							NoticeSound.cash();
							JOptionPane.showMessageDialog(null, SUCESS, CONFIRM_TITLE, JOptionPane.INFORMATION_MESSAGE);
						}
					} else {
						NoticeSound.click();
					}
					
				}
			}
		};
		return listener;
	}

	private ActionListener getBackActionListener(){
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainMap.reAddEnergybar();
				View.changeContentPane(PetCenterStartController.getContentPane());
			}
		};
		return listener;
	}
	
	public static Container getContentPane(){
		ctrl.view.changeMoney(Information.getInstance().getUser().getMoney());
		return ctrl.view.getContentPane();
	}

}
