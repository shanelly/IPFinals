import javax.swing.JFrame;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.*;



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
		else if(e.getKeyCode()== KeyEvent.VK_DOWN){
			drawing.hide();
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE){
			drawing.attack();
			System.out.println("attack");
		}
		else if(e.getKeyCode() == KeyEvent.VK_Z){
			drawing.spawnEnemy();

	}
}

	public void keyReleased(KeyEvent e){

	}

	public void keyTyped(KeyEvent e){

	}


	public static void main(String[] args){
		MyFrame gameFrame= new MyFrame();
		gameFrame.setBackground(Color.BLACK);
		gameFrame.setSize(800,560);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setVisible(true);
		gameFrame.getContentPane().add(drawing);
		gameFrame.addKeyListener(gameFrame);

	}
}