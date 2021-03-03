package controller;

import java.io.BufferedInputStream;
import java.io.IOException;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class PlaySound {
	private boolean isPlaying = false;
	private AudioStream bgMusic;
	private BufferedInputStream bfile;
	private String fileLocation;
	
	public PlaySound(String fileLocation){
		try {
			this.fileLocation = fileLocation;
			this.bfile = new BufferedInputStream(getClass().getClassLoader().getResourceAsStream(this.fileLocation));
			this.bgMusic = new AudioStream(bfile);
			AudioPlayer.player.start(bgMusic);
		} catch(IOException error){
			error.printStackTrace();
		}
	}
	
	public void musicOn(){
		AudioPlayer.player.start(bgMusic);
		this.setPlaying(true);
	}
	
	public void musicOff(){
		AudioPlayer.player.stop(bgMusic);
		this.setPlaying(false);
	}

	public void setPlaying(boolean isPlaying) {
		this.isPlaying = isPlaying;
	}

	public boolean isPlaying() {
		return isPlaying;
	}

}
