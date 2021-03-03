package controller;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.PetCenterSellModel;
import model.UserPet;
import model.UserPetDAO;
import view.MainMap;
import view.PetCenterSell;
import view.View;

public class PetCenterSellController {

	public static final String CONFIRM_TITLE = "Xác nh\u1EADn";
	public static final String ERROR_TITLE = "Thông báo";
	public static final String CONFIRM = "B\u1EA1n ch\u1EAFc ch\u1EAFn mu\u1ED1n bán partner này ch\u1EE9?";
	public static final String SUCESS = "Bán l\u1EA1i thành công!";
	private static final String NOT_SELECTED = "Ch\u01b0a c\u00f3 partner n\u00e0o \u0111\u01b0\u1ee3c ch\u1ecdn.";
	private PetCenterSell view;
	private PetCenterSellModel model;
	
	public PetCenterSellController(){
		model = new PetCenterSellModel(Information.getInstance().getUser());
		view = new PetCenterSell(View.getEnergyBar(), model);
		view.changeMoney(Information.getInstance().getUser().getMoney());
		view.setSellButtonListerner(getSellActionListener());
		view.setBackButtonListerner(getBackActionListener());
	}
	
	private ActionListener getSellActionListener(){
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UserPet pet = view.getSelectedPet();
				if(pet == null){
					NoticeSound.click();
					JOptionPane.showMessageDialog(null, NOT_SELECTED, ERROR_TITLE, JOptionPane.INFORMATION_MESSAGE);
				} else {
					int reply = JOptionPane.showConfirmDialog(null, CONFIRM, CONFIRM_TITLE, JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION){
						model.sell(pet, Information.getInstance().getUser());
						Information.getInstance().setPets(UserPetDAO.getInstance().getAllUserPet(Information.getInstance().getUser().getUsername()));
						view.setUserPet(model.getPets(Information.getInstance().getUser().getUsername()));
						view.changeMoney(Information.getInstance().getUser().getMoney());
						NoticeSound.cash();
						JOptionPane.showMessageDialog(null, SUCESS, CONFIRM_TITLE, JOptionPane.INFORMATION_MESSAGE);
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
	
	public Container getContentPane(){
		return view.getContentPane();
	}
}
