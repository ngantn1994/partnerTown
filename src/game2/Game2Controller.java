package game2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import view.GameCenter;
import controller.Information;
import model.UserDAO;

public class Game2Controller {
	
	private static Game2View view = Game2View.getInstance();
	private static Game2Model model = Game2Model.getInstance();
	
	private static Timer timer;
	
	private static Game2Controller ctrl = new Game2Controller();
	
	private static UserDAO dao = UserDAO.getInstance();
	
	public static Game2Controller getInstance(){
		timer.stop();
		view.resetScore();
		view.refreshScore();
		view.startAgain();
		model.newEquation();
		ctrl.changeCard();
		view.setVisible(true);
		return ctrl;
	}
	
	private Game2Controller(){
		addTimeBarListener();
		timer.start();
		timer.stop();
		view.setStartListener(getStartButtonListener());
		view.setBackListener(getBackButtonListener());
		for(int i=0;i<19;i++){
			view.setButtonsListener(getButtonsActionListener(view.getButtonValue(i)), i);
		}
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
					view.gameOver();
					timer.stop();
					return;
				}
				view.setTimeBarValue(--val);
			}
		};
		
		timer = new Timer(1500, updateProBar);
	}
	
	private void changeCard(){
		view.changeCard1Icon(model.getValue1());
		view.changeCard2Icon(model.getValue2());
	}
	
	private ActionListener getButtonsActionListener(final int k){
		
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(model.check(k)){
					model.newEquation();
					view.incScore(10);
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
