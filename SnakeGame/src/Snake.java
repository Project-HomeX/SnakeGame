import java.util.ArrayList;

import processing.core.PApplet;

/**
 * Snake class
 * 
 *
 */
public class Snake {
	float x = 0;
	float y = 0;

	float xspeed = 10;
	float yspeed = 0;
	static float total = 0;
	
	ArrayList<PVector> tail = new ArrayList<PVector>();
	PApplet parrent;

	public Snake(PApplet p) {
		// TODO Auto-generated constructor stub
		this.x = 300;
		this.y = 300;
		this.xspeed = 20;
		this.yspeed = 0;
		parrent = p;
	}
	/**
	 * update the snakes location.
	 */
	public void update() {
		if (total > 0) {
			if (total == tail.size() && !tail.isEmpty()) {
				tail.remove(0);
			} 
				tail.add(new PVector(x, y));
		}
		if (x >= 590) {
			x = 0;
		}
		// I changed this to neg. 10 to fix the flickering bug at the adge of
		// window.
		else if (x <= -10) {
			x = 600;
		}

		if (y >= 590) {
			y = 0;
		}
		// same
		else if (y <= -10) {
			y = 600;
		}
		
		this.x = x + xspeed;
		this.y = y + yspeed;
	}
	public ArrayList<PVector> getTail(){
		return this.tail;
	}
	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	/**
	 * show the updated snake at its now location.
	 */
	public void show() {
		parrent.fill(255);
		for (PVector v : tail) {
			parrent.rect(v.x, v.y, 20, 20);
		}
		parrent.rect(x, y, 20, 20);
	}

	public void dir(float x, float y) {
		// if((x<0 && xspeed>0) || (y<0 && yspeed > 0))
		xspeed = x * 20;
		yspeed = y * 20;
	}
}
