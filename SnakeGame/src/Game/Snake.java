package Game;

import java.util.ArrayList;

import processing.core.PApplet;

public class Snake {
	float x = 10;
	float y = 10; 
	float xspeed = 20;
	float yspeed = 0;
	float scl = 20;
	PApplet parrent;
	
	ArrayList<Integer> snakeXLength = new ArrayList<Integer>();
	ArrayList<Integer> snakeYLength = new ArrayList<Integer>();
	private int lengthOfSnake = 3;
	
	
	public Snake(PApplet p, float scl) {
		this.scl = scl;
		parrent = p;
		this.x = p.width/2;
		this.y = p.height/2;
	}
	
	//Getter and setters
	public float getX(){
		return x;
	}
	public float getY(){
		return y;
	}
	
	public void update(){
		if( x >= 590) {
			x = 0;
		}
		else if (x <= 10) {
			x = 600;
		}
		
		if( y >= 590) {
			y = 0;
		}
		else if (y <= 10) {
			y = 600;
		}
		
		x = x+ xspeed;
		y = y+yspeed;
	}
	
	public void show(){
		parrent.fill(255);
		parrent.rect(x,y,scl,scl);
	}
	
	public void dir(int x, int y){
		xspeed = x;
		yspeed = y;
	}
}
