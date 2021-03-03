package controller;

import java.io.BufferedInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class LoopSound{
	
	private volatile boolean isPlaying = false;
	
	private SourceDataLine soundLine = null;
    private int BUFFER_SIZE = 64*1024;
    private BufferedInputStream soundFile;
    private AudioInputStream audioInputStream;
    private String fileLocation;

    private OpenSound s;
    
    public LoopSound(String fileLocation){
    	this.fileLocation = fileLocation;
    	s = new OpenSound();
    }

    public void musicStart(){
    	isPlaying = true;
    	s.start();
    }
    
    public void musicOn(){
    	s = new OpenSound();
		isPlaying = true;
		s.start();
	}
    
	public void musicOff(){
		isPlaying = false;
	}

	public boolean isPlaying() {
		return isPlaying;
	}

    class OpenSound extends Thread {
    	
    	public OpenSound(){
    		super();
    	}
    	
    	public void initialize(){
        	try {
        		soundFile = new BufferedInputStream(getClass().getClassLoader().getResourceAsStream(fileLocation));
        		audioInputStream = AudioSystem.getAudioInputStream(soundFile);
                AudioFormat audioFormat = audioInputStream.getFormat();
                DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
                soundLine = (SourceDataLine) AudioSystem.getLine(info);
                soundLine.open(audioFormat);
                soundLine.start();
                int nBytesRead = 0;
                byte[] sampledData = new byte[BUFFER_SIZE];
                while (nBytesRead != -1&&isPlaying) {
                	nBytesRead = audioInputStream.read(sampledData, 0, sampledData.length);
                	if (nBytesRead >= 0) {
    	            	soundLine.write(sampledData, 0, nBytesRead);
                	}
                }
        	} catch (IOException e) {
    			e.printStackTrace();
    		} catch (LineUnavailableException e) {
                e.printStackTrace();
            } catch (UnsupportedAudioFileException e) {
    			e.printStackTrace();
    		} finally {
            	soundLine.drain();
            	soundLine.close();
            }
    	}
        
        @Override
        public void run(){
        	while(isPlaying){
        		initialize();
        	}
        }
    	
    }
}


