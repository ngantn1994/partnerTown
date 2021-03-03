import java.net.MalformedURLException;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import view.SplashScreen;


public class Main {
	
	public static void main(String[] args) {
		 try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.invokeLater(new Runnable() {

	            @Override
	            public void run() {
	                try {
	                	new SplashScreen().initUI();
	                } catch (MalformedURLException e) {
	                    e.printStackTrace();
	                }
	            }
	        });
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		} catch (InstantiationException e){
			e.printStackTrace();
		} catch (IllegalAccessException e){
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e){
			e.printStackTrace();
		}
	}
}