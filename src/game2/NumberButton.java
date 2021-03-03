package game2;

import view.BufferedImageButton;

public class NumberButton extends BufferedImageButton {

	private static final long serialVersionUID = 1L;
	
	private int value;
	
	public NumberButton() {
		super();
	}

	public NumberButton(String img1, String img2, int width, int height, int value) {
		super(img1, img2, width, height);
		this.value = value;
	}

	public int getValue(){
		return value;
	}
	
}
