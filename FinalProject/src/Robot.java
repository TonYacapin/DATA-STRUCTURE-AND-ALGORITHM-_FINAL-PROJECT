
public class Robot {
	
	private int x;
	private int y;

	public Robot() {

	this.x = 0;
	this.y = 0;

	}

	public void moveUp() {
		Map.MoveRobot(y, x);
	this.x--;
	Map.SpawnRobot(y,x);


	}

	public void moveDown() {
		Map.MoveRobot(y, x);
	this.x++;
	Map.SpawnRobot(y,x);
	

	}

	public void moveLeft() {
		Map.MoveRobot(y, x);
	this.y--;
	
	Map.SpawnRobot(y,x);
	

	}

	public void moveRight() {
		
	
		Map.MoveRobot(y, x);
	this.y++;
	
	Map.SpawnRobot(y,x);
	

	}

	public int getX() {

	return this.x;
	

	}

	public int getY() {

	return this.y;

	}
	
	public void SetXYRobot(int x, int y) {
		
		this.x = x;
		this.y = y;
		
		Map.SpawnRobot(y,x);
		
		
	}

	}

