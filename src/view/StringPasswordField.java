package view;

import javax.swing.JPasswordField;

public class StringPasswordField extends JPasswordField{

	private static final long serialVersionUID = 1L;
	
	public StringPasswordField(){
		super();
	}
	
	public String getValue(){
		char[] temp = getPassword();
		String password = ("");
		for(int i=0;i<temp.length;i++){
			password = password + temp[i];
		}
		return password;	
	}
	
	public int getLength(){
		char[] temp = getPassword();
		return temp.length;
	}
	
	public boolean isMatch(String another){
		if(getValue() == null||another == null){
			return false;
		}
		if(getValue().equalsIgnoreCase(another)){
			return true;
		} else {
			return false;
		}
	}
}
