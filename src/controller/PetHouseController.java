package controller;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.UserPet;
import model.UserPetDAO;
import view.MainMap;
import view.PetHouse;
import view.RenameDialog;
import view.View;

public class PetHouseController {
	
	private static final String NOTICE_TITLE = "Thông báo";
	private static final String NOTICE = "B\u1EA1n không còn h\u1ED9p s\u1EEFa nào. \u0110\u1EBFn ngay c\u1EEDa hàng \u0111\u1EC3 mua nhé!";
	private static final String ERROR = "Tên Partner không \u0111\u01B0\u1EE3c b\u1ECF tr\u1ED1ng hay ch\u1EC9 ch\u1EE9a d\u1EA5u cách.";

	private PetHouse view;
	private UserPetDAO model;
	private RenameDialog dialog;
	
	private static PetHouseController ctrl = new PetHouseController();
	
	private PetHouseController(){
		model = UserPetDAO.getInstance();
		view = null;
		System.gc();
		view = new PetHouse(View.getEnergyBar(), model.getAllUserPet(Information.getInstance().getUser().getUsername()));
		if(view.checkAvaible()){
			view.addFeedActionListerner(getFeedActionListener());
			view.addPokeActionListerner(getPokeActionListener());
			view.addWashActionListerner(getWashActionListener());
			view.addChangeNameActionListerner(getChangeNameActionListener());
		}
		view.setSettingButtonListerner(getSettingActionListener());
		view.setInventoryButtonListerner(getInventoryActionListener());
		view.setMapButtonListerner(getMapActionListener());
	}
	
	
	
	private ActionListener getFeedActionListener(){
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Information.getInstance().getStock().decMilk()){	
					int id = view.getSelectedID();
					int temp = Information.getInstance().getPets().size();
					int i = 0;
					while (i<temp){
						if(Information.getInstance().getPets().get(i).getStockID() == id){
							UserPet pet = Information.getInstance().getPets().get(i);
							pet.incHP();
							pet.incSP();
							pet.decWC();
							model.updateSP(pet);
							model.updateHP(pet);
							model.updateWC(pet);
							model.updateHappy(pet);
							model.updateLevel(pet);
							model.updateVisible(pet);
							view.updateSP(view.getSelectedTab(), pet);
							view.updateLevel(view.getSelectedTab(), pet);
							view.updateWash(view.getSelectedTab(), pet);
							view.updateHappy(view.getSelectedTab(), pet);
							NoticeSound.change();
							i = temp;
							break;
						} else {
							i++;
						}
					}
					Information.getInstance().setPets(model.getAllUserPet(Information.getInstance().getUser().getUsername()));
				} else {
					NoticeSound.click();
					JOptionPane.showMessageDialog(null, NOTICE, NOTICE_TITLE, JOptionPane.INFORMATION_MESSAGE);
				}
			}
		};
		return listener;
	}
	
	private ActionListener getPokeActionListener(){
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id = view.getSelectedID();
				int temp = Information.getInstance().getPets().size();
				int i = 0;
				while (i<temp){
					if(Information.getInstance().getPets().get(i).getStockID() == id){
						UserPet pet = Information.getInstance().getPets().get(i);
						pet.incHappy();
						model.updateHappy(pet);
						view.updateHappy(view.getSelectedTab(), pet);
						NoticeSound.change();
						i = temp;
						break;
					} else {
						i++;
					}
				}
				Information.getInstance().setPets(model.getAllUserPet(Information.getInstance().getUser().getUsername()));
			}
		};
		return listener;
	}
	
	private ActionListener getWashActionListener(){
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id = view.getSelectedID();
				int temp = Information.getInstance().getPets().size();
				int i = 0;
				while (i<temp){
					if(Information.getInstance().getPets().get(i).getStockID() == id){
						UserPet pet = Information.getInstance().getPets().get(i);
						pet.incWC();
						model.updateWC(pet);
						view.updateWash(view.getSelectedTab(), pet);
						NoticeSound.change();
						i = temp;
						break;
					} else {
						i++;
					}
				}
				Information.getInstance().setPets(model.getAllUserPet(Information.getInstance().getUser().getUsername()));
			}
		};
		return listener;
	}
	
	private ActionListener getChangeNameActionListener(){
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog = new RenameDialog();
				dialog.addSaveButtonActionListener(getDialogSaveActionListener());
				dialog.addExitButtonActionListener(getDialogExitActionListener());
				NoticeSound.laser();
				dialog.setVisible(true);
			}
		};
		return listener;
	}
	
	private ActionListener getDialogSaveActionListener(){
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String s = dialog.getNewName();
				if(checkNewName(s)){
					int id = view.getSelectedID();
					int temp = Information.getInstance().getPets().size();
					int i = 0;
					while (i<temp){
						if(Information.getInstance().getPets().get(i).getStockID() == id){
							UserPet pet = Information.getInstance().getPets().get(i);
							pet.setPetName(s);
							model.updateName(pet);
							view.updateName(view.getSelectedTab(), pet);
							NoticeSound.change();
							dialog.dispose();
							i = temp;
							break;
						} else {
							i++;
						}
					}
					Information.getInstance().setPets(model.getAllUserPet(Information.getInstance().getUser().getUsername()));
				} else {
					NoticeSound.click();
					JOptionPane.showMessageDialog(null, ERROR, NOTICE_TITLE, JOptionPane.INFORMATION_MESSAGE);
				}
			}
		};
		return listener;
	}
	
	private boolean checkNewName(String s){
		if(s.isEmpty()){
			return false;
		}
		int d=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i) == ' '){
				d++;
			}
		}
		if(d==s.length()){
			return false;
		}
		return true;
	}
	
	private ActionListener getDialogExitActionListener(){
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
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
		ctrl.resetHouse();
		return ctrl.view.getContentPane();
	}
	
	private void resetHouse(){
		view = null;
		System.gc();
		view = new PetHouse(View.getEnergyBar(), model.getAllUserPet(Information.getInstance().getUser().getUsername()));
		if(view.checkAvaible()){
			view.addFeedActionListerner(getFeedActionListener());
			view.addPokeActionListerner(getPokeActionListener());
			view.addWashActionListerner(getWashActionListener());
			view.addChangeNameActionListerner(getChangeNameActionListener());
		}
		view.setSettingButtonListerner(getSettingActionListener());
		view.setInventoryButtonListerner(getInventoryActionListener());
		view.setMapButtonListerner(getMapActionListener());
	}
}
