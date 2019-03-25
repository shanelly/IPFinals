import javax.swing.JFrame;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;



public class MyFrame extends JFrame implements KeyListener{

	static Draw drawing =new Draw();

	public void keyPressed(KeyEvent e){
		
		if(e.getKeyCode()== KeyEvent.VK_LEFT){
			drawing.moveLeft();	
		}

		else if(e.getKeyCode()== KeyEvent.VK_RIGHT){
			drawing.moveRight();
		}
		else if(e.getKeyCode()== KeyEvent.VK_UP){
			drawing.jump();
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE){
			 try {

                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sword.wav").getAbsoluteFile());
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    }catch(Exception x) { x.printStackTrace(); }
                    drawing.attack();
		}
		else if(e.getKeyCode() == KeyEvent.VK_S){
			drawing.spawnEnemy();
			try {

                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("slime.wav").getAbsoluteFile());
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    }catch(Exception x) { x.printStackTrace(); }

	}
}

	public void keyReleased(KeyEvent e){

	}

	public void keyTyped(KeyEvent e){

	}


	public static void main(String[] args)throws Exception{
		MyFrame gameFrame= new MyFrame();
		gameFrame.setBackground(Color.BLACK);
		gameFrame.setSize(800,560);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setVisible(true);
		gameFrame.getContentPane().add(drawing);
		gameFrame.addKeyListener(gameFrame);

		URL url = MyFrame.class.getResource("music.wav");
		AudioClip clip = Applet.newAudioClip(url);
		AudioClip clip2 = Applet.newAudioClip(url);
		clip.play();
		Thread.sleep(1000);
		clip2.loop();
		Thread.sleep(20000);
		clip2.stop();
	}
}