package controller;
import java.io.BufferedInputStream;
import java.io.IOException;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class NoticeSound {
	public static final String CAMERA = "sounds/camera.wav";
	public static final String CASH = "sounds/cash.wav";
	public static final String CHANGE = "sounds/change.wav";
	public static final String CHIMES = "sounds/chimes.wav";
	public static final String CLICK = "sounds/click.wav";
	public static final String LASER = "sounds/laser.wav";
	public static final String SUCCESS = "sounds/success.wav";
	public static final String WHOOSH = "sounds/whoosh.wav";
	
	private static NoticeSound sound;
	
	private NoticeSound(String url){
		try {
			BufferedInputStream bfile = new BufferedInputStream(getClass().getResourceAsStream(url));
			AudioStream bgMusic = new AudioStream(bfile);
			AudioPlayer.player.start(bgMusic);
		} catch(IOException error){
			error.printStackTrace();
		}
	}
	
	public static NoticeSound camera(){
		sound = new NoticeSound(CAMERA);
		return sound;
	}
	
	public static NoticeSound cash(){
		sound = new NoticeSound(CASH);
		return sound;
	}
	
	public static NoticeSound change(){
		sound = new NoticeSound(CHANGE);
		return sound;
	}
	
	public static NoticeSound chimes(){
		sound = new NoticeSound(CHIMES);
		return sound;
	}
	
	public static NoticeSound click(){
		sound = new NoticeSound(CLICK);
		return sound;
	}
	
	public static NoticeSound laser(){
		sound = new NoticeSound(LASER);
		return sound;
	}

	public static NoticeSound success(){
		sound = new NoticeSound(SUCCESS);
		return sound;
	}
	
	public static NoticeSound whoosh(){
		sound = new NoticeSound(WHOOSH);
		return sound;
	}

}
