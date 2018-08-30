import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;
/**
 * Main class where the game starts running.
 * @author Project-X
 * 
 */
public class Main extends PApplet {

	Food food;
	boolean flagU;
	boolean flagD;
	boolean flagR = true;
	boolean flagL;
	//
	float scl = 20;
	int speed = 10;
	Snake snake;
	public static void main(String[] args) {
		PApplet.main("Main");
	}
	public void settings() {
		size(600, 600);
	}
 	public void setup() {	
		frameRate(speed);
		snake=new Snake(this);
		food = new Food(this);		
	}
	//this is a loop method... it loads every U second (I don't know the exact second so a called it U). 
	public void draw() {
		background(0);
		collision();
		
		
		food.show();
		selfEat();
		snake.update();
		snake.show();
		//this is a built in collision ditection in Processing. So don't worry about it.
		}
	public boolean collision(){
		float r = dist(food.getX(),food.getY(),snake.getX(),snake.getY());
		if(r<1){
			food.update();
			snake.total++;
			return true;
		}
		return false;
	}
	public void selfEat(){
		ArrayList<PVector> t = snake.getTail();
		if(snake.total>0){
			if(snake.getTail().size()>0){
				for (int i = 0; i < t.size(); i++) {
					float d = dist(snake.x, snake.y, snake.tail.get(i).x,snake.tail.get(i).y);
					if(d<1){
						snake.getTail().clear();
						snake.total = 0;
					}
				}
			}
		}
	}
	/**
	 * flagU,flagR... stuff is to prevent opposite direction movement. 
	 * some one else has written this one better
	 *
	 **/
	@Override 
	public void keyPressed() {
		if (key == CODED) {
			if (keyCode == UP && flagU==false) {
					snake.dir(0,-1);
					flagR = false;
					flagL = false;
					flagD = true;
			} else if (keyCode == DOWN && flagD == false) {
				snake.dir(0,1);
				flagR = false;
				flagL = false;
				flagU = true;
			}else if (keyCode == RIGHT && flagR == false) {
				snake.dir(1,0);
				flagD = false;
				flagU = false;
				flagL = true;
			}
			else if (keyCode == LEFT && flagL == false) {
				snake.dir(-1,0);
				flagD = false;
				flagU = false;
				flagR = true;
			}
		}
	}
}
