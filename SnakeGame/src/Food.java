import processing.core.PApplet;
/**
 * Food class. food appears at a random place
 * on the grid.
 * @author Project-X
 *
 */
public class Food {
	float x;
	float y;
	PApplet p;
	public Food(PApplet p) {
		// TODO Auto-generated constructor stub
		this.p = p;
		update();
	}
	public float getX(){
		return x;
	}
	public float getY(){
		return y;
	}
	public void show(){
		p.fill(255,0,0);
		p.rect(x, y, 20, 20);
	}
	public void update(){
		this.x = p.floor(p.random(600/20))*20;
		this.y =p.floor(p.random(600/20))*20;
	}
	
}
