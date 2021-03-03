package game1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import view.GameCenter;
import model.UserDAO;
import controller.Information;

public class Game1Controller {
	private static int level = 0;
	private static boolean flag = false;
	private static boolean mode = true;
	private static Timer[] timer = new Timer[6];
	
	private static int u;
	private static int v;
	
	private static final int second = 50;
	
	private static Game1View view = Game1View.getInstance();
	private static Game1Controller ctrl = new Game1Controller();
	
	private static UserDAO model = UserDAO.getInstance();
	
	public static Game1Controller getInstance(){
		for(int i=0;i<6;i++){
			timer[i].stop();
		}
		view.startAgain();
		view.setVisible(true);
		view.setModal(true);
		getBackWinListener(view);
		getBackGOListener(view);
		return ctrl;
	}
	
	public static int getSize(){
		switch(level){
		case 1: return 2;
		case 2: return 4;
		case 3: return 8;
		case 4: return 12;
		case 5: return 16;
		case 6: return 20;
		}
		return 0;
	}
	
	private Game1Controller(){
		for(int i=1; i<=6; i++){
			addTimeBarListener(view, i);	
		}
		addStartListener(view);
	}
	
	public static void incSize(){
		u = 1;
		v = 1;
		level++;
	}
	
	public static void addStartButtonListener(final Game1View scr){

		ActionListener imageButtonListener = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				for(int i = 0; i<scr.buttonsLength();i++){
					if(scr.equalToButtonI(arg0.getSource(),i)){ 
						if(flag == false)
						{
							scr.deleteBorder(u);
							scr.deleteBorder(v);
							u = i;
							scr.redlineBorder(u);
							flag = true;
							return;
						} else {
							v = i;
							scr.redlineBorder(v);
							if(scr.sameKindOfButton(u, v))
							{
								if(u == v)
								{
									flag = false;
									return;
								} else {
									scr.disableButton(u);
									scr.disableButton(v);
									flag = false;
									scr.incScore(5);
									scr.refreshScore();
									scr.incCount();
								}
								if(scr.getCount() == getSize())
								{
									incSize();
									if(level == 7)
									{
										timer[level-2].stop();
										scr.incScore(scr.getTimeBarValue());
										scr.incScore(500);
										scr.youWin();
										return;
									}
									timer[level-2].stop();
									timer[level-1].restart();
									System.gc();
									scr.incScore(scr.getTimeBarValue());
									scr.incScore(50);
									scr.addLevel(level);
									addStartButtonListener(scr);
									System.gc();
								}
								return;
							} else {
								flag = false;
								return;
							}
						}
					}
				}
			}
		};
		scr.setButtonListener(imageButtonListener);
	}
	
	public static void addTimeBarListener(final Game1View scr, final int a){
		ActionListener updateProBar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				
				int val = scr.getTimeBarValue();
				if (val <= 0 && mode == true && level == a) {
					scr.gameOver();
					for(int i=0;i<6;i++){
						timer[i].stop();
					}
					System.gc();
					return;
				}
				scr.setTimeBarValue(--val);
			}
		};
		int t = a*a*second;
		
		timer[a-1] = new Timer(t, updateProBar);
	}
	
	public static void addStartListener(final Game1View scr){
		ActionListener startGame = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				level = 0;
				scr.resetScore();
				incSize();
				timer[level-1].restart();
				scr.addLevel(level);
				addStartButtonListener(scr);
				flag = false;
				System.gc();
				for(int i=1;i<6;i++){
					timer[i].stop();
				}
				mode = true;
			}
		};
		scr.setStartListener(startGame);
	}
	
	public static void getBackWinListener(final Game1View scr){
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Information.getInstance().getUser().incMoney(scr.getScore());
				model.updateMoney(Information.getInstance().getUser());
				GameCenter.changeMoney(Information.getInstance().getUser().getMoney());
				scr.dispose();
			}
		};
		scr.setBackWinListener(listener);
	}
	
	public static void getBackGOListener(final Game1View scr){
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Information.getInstance().getUser().incMoney(scr.getScore());
				model.updateMoney(Information.getInstance().getUser());
				GameCenter.changeMoney(Information.getInstance().getUser().getMoney());
				scr.dispose();
			}
		};
		scr.setBackGOListener(listener);
	}
}
