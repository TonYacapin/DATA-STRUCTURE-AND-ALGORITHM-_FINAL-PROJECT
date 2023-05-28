import java.util.Random;
import java.util.Scanner;


class ListNode {
	 String data;
	 ListNode next;
	 public ListNode(String data) {
	 this.data = data;
	 this.next = null;
	 }
	}


 



public class RobotMain {
	char again = 'y';
	public ListNode head = null;
	public ListNode tail = null; 
	 

	public void main(String[] args) {
		
		
		RobotMain list = new RobotMain();
		
		Random rand = new Random();
		int x = rand.nextInt(39);
        int y = rand.nextInt(5);
		
		Map map = new Map();
		Robot robot = new Robot();
		
		Map.GenerateMap();
		Map.SpawnHazards();
		
		Map.SpawnCasualty();
		
		
		robot.SetXYRobot(y,x);
	
		Map.ShowMap();
		char again = 'y';
		
		
		Scanner MoveAgain = new Scanner (System.in);
		int step = 0;
		boolean valid = false;
		
		
		 while (again == 'y' || again =='Y' && Map.gameover !=true) {
					String cmd = getcmd();	
			String nav = cmd.substring(0,1);
			String van = cmd.substring(0,1);
			
			if(cmd.length() >2) {
				
				step =Integer.parseInt(cmd.substring(1,2).concat(cmd.substring(2,3)));
				
			}else {
				if(cmd.length() >1) {
					step =Integer.parseInt(cmd.substring(1,2));
				}else {step=0;}
				
				
				
				
				switch (van) {
				case "R":
					if(robot.getY()+step<=40){ valid = true;}
					list.addNodeEnd(cmd);
					break;
				case "L":
					if(robot.getY()-step>=0) {valid = true;}
					list.addNodeEnd(cmd);
					break;
				case "D":
					if(robot.getX()+step<=5) {valid = true;}
					list.addNodeEnd(cmd);
					break;
				case "U":
					if(robot.getX()-step>=0) {valid = true;}
					list.addNodeEnd(cmd);
					break;
				default:
					System.out.println("Move Invalid");
					break;
				}
				
				
			}

			if(valid ==true && cmd.length()>0) {
				
				
				switch (nav) {
				case "R":
					for (int i = 0; i < step; i++) {
						if (Map.gameover !=true) {
						robot.moveRight();
						}
					}
				
				
					Map.ShowMap();
					break;
				case "L":
					for (int i = 0; i < step; i++) {
						if (Map.gameover !=true) {
						robot.moveLeft();
						}
					}
					
				
					Map.ShowMap();
					break;
				case "D":
					for (int i = 0; i < step; i++) {
						if (Map.gameover !=true) {
						robot.moveDown();
						}
							
					}
				
					Map.ShowMap();
					break;
				case "U":
					for (int i = 0; i < step; i++) {
						if (Map.gameover !=true) {
						robot.moveUp();
						}
					}
				
					Map.ShowMap();
					break;
				default:
					System.out.println("Move Invalid");
					Map.ShowMap();
					break;
			
				}
			
				
			
				
			}
			if (Map.gameover != true) {
				
			
			System.out.println("Move Again? Y/N");
			again = MoveAgain.next().charAt(0);
			}
			else {
				
			list.display();
			return;
			}
			}
	
			
		
	}
	
	public static String getcmd() {
		Scanner getMove = new Scanner(System.in);
		System.out.println("Enter Command => ");
		String c = getMove.next();
	
		return c.toUpperCase();	
	
	}
	
	public void addNodeEnd(String data) {
		 //Create a new node
		 ListNode newNode = new ListNode(data);
		 //Checks if the list is empty
		 if(head == null) {
		//If list is empty, both head and tail will point to new node
		 head = newNode;
		 tail = newNode;
		 }
		 else {
		//newNode will be added after tail such that tail's next will point to newNode
		 tail.next = newNode;
		 //newNode will become new tail of the list
		 tail = newNode;
		 }
		} 
	
	public void display() {
		 //Node current will point to head
		 ListNode current = head;

		 if(head == null) {
		 System.out.println("Move list is Empty");
		 return;
		 }
		 System.out.println("List of Robot's Move:  ");
		 while(current != null) {
		 //Prints each node by incrementing pointer
		 System.out.print(current.data + " ");
		 current = current.next;
		 }
		 System.out.println();
		}
	
	
	

}
 

