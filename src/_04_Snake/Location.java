package _04_Snake;

public class Location {
	
	private int x;
	private int y;
	
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean equals(Location loc) {
		if (this.x == loc.x && this.y == loc.y) {
			return true;
		}
		else {
			return false;
		}
	}
}
