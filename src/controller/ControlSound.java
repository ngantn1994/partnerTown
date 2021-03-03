package controller;

public class ControlSound {
	
	private LoopSound sound;
	
	public ControlSound(){
		sound = new LoopSound("controller\\sounds\\bgMusic.wav");
		sound.musicStart();
	}

	public void musicOn(){
		sound.musicOn();
	}
	
	public void musicOff() {
		sound.musicOff();
	}
	
	public boolean isOn(){
		return sound.isPlaying();
	}
}
