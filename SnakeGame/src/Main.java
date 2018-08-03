import processing.core.PApplet;

public class Main extends PApplet{
	Snake s;
	Food f;
	float scl = 20;
	int speed = 5;
	// keeping track of which direction the snake is going
	// it starts going to the right
	//[up,down,right,left]
	boolean[] direc = {false,false,true,false};
	public static void main(String[] args) {
		PApplet.main("Main");
	}

	public void settings() {
		size(600, 600);
	}

	public void setup() {
		// fill(120,50,240);
		background(0);
		s = new Snake(this,scl);
		f = new Food(this,10,scl);
		frameRate(speed);
	}

	public void draw() {
		background(0);
		s.update();
		s.show();
		f.show();
		if(collision(s, f)){
			System.out.println("Collision!");
		}
	}
	public boolean collision(Snake snake, Food food){
		//if(Snake.)
		
		if(snake.getX() == food.getX()) {
			return true;
		}
		return false;
	}
	
	/*
	 * @Override public void keyPressed() { // TODO Auto-generated method stub
	 * super.keyPressed(); if(keyCode == UP_ARROW){
	 * 
	 * } }
	 */
	@Override 
	public void keyPressed() {
		if (key == CODED) {
			if (keyCode == UP && !direc[1]) {
				up();
			} else if (keyCode == DOWN && !direc[0]) {
				down();
			}else if (keyCode == RIGHT && !direc[3]) {
				right();
			}
			else if (keyCode == LEFT && !direc[2]){
				left();
			} 
		}

	}
	private void up() {
		s.dir(0,-20);
		boolean[] temp = {true,false,false,false};
		direc = temp;
	}
	private void down() {
		s.dir(0,20);
		boolean[] temp = {false,true,false,false};
		direc = temp;

	}
	private void right() {
		s.dir(20,0);
		boolean[] temp = {false,false,true,false};
		direc = temp;

	}
	private void left() {
		s.dir(-20,0);
		boolean[] temp = {false,false,false,true};
		direc = temp;

	}
}
