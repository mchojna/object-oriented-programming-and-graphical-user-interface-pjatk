package mvc;

public class Model {
	
	private int x;
	
	public Model(int x) {
		this.x = x;
	}
	
	public int getX() {
		return this.x;
	}
	
	public void setX(int x) {
		this.x += x;
	}
}
