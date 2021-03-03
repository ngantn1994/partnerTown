package game3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import model.UserDAO;
import view.GameCenter;
import controller.Information;

public class Game3Controller {
	private static Game3View view = Game3View.getInstance();
	private static Game3Model model = Game3Model.getInstance();
	
	private static Timer timer;
	
	private static Game3Controller ctrl = new Game3Controller();
	
	private static UserDAO dao = UserDAO.getInstance();
	
	public static Game3Controller getInstance(){
		timer.stop();
		view.resetScore();
		view.refreshScore();
		view.startAgain();
		model.newEquation();
		ctrl.changeCard();
		view.setVisible(true);
		return ctrl;
	}
	
	private Game3Controller(){
		addTimeBarListener();
		timer.start();
		timer.stop();
		view.setStartListener(getStartButtonListener());
		view.setBackGOListener(getBackButtonListener());
		view.setBackWinListener(getBackButtonListener());
		view.setMaleButtonListener(getWaitingActionListener(0));
		view.setFemaleButtonListener(getWaitingActionListener(1));
		view.setPoliceButtonListener(getWaitingActionListener(2));
	}
	
	private ActionListener getStartButtonListener(){
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				view.play();
				timer.restart();
			}
		};
		return listener;
	}
	
	private ActionListener getBackButtonListener(){
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Information.getInstance().getUser().incMoney(view.getScore());
				dao.updateMoney(Information.getInstance().getUser());
				GameCenter.changeMoney(Information.getInstance().getUser().getMoney());
				view.dispose();
			}
		};
		return listener;
	}
	
	private static void addTimeBarListener(){
		ActionListener updateProBar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				
				int val = view.getTimeBarValue();
				if (val <= 0) {
					view.youWon();
					timer.stop();
					return;
				}
				view.setTimeBarValue(--val);
			}
		};
		
		timer = new Timer(750, updateProBar);
	}
	
	private void changeCard(){
		view.changeWaiting(model.getValue());
	}
	
	private ActionListener getWaitingActionListener(final int k){
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(model.check(k)){
					model.newEquation();
					view.incScore(5);
					view.refreshScore();
					changeCard();
				} else {
					view.gameOver();
					timer.stop();
				}
			}
		};
		return listener;
	}

}
