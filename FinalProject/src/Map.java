import java.util.Random;

public class Map {
	
	static Random rand = new Random();
	static int x;
	static int y;
	static String [][] arr = new String [5][40];
	static boolean gameover = false;
	
	public static void GenerateMap() {
		
			        for (int i=0; i<5; i++) {
			            for (int j=0; j<40; j++) {
			                arr[i][j] = "=";
			            }
			            
			            
			        }

			        
			     
			    }
			public static void generateCoordinates() {
				
				 y = (int) (Math.random() * (6 - 1)) ;
				 x = (int) (Math.random() * (40 - 1)) + 1 ;
				
			}
			
			public static void SpawnRobot(int x,int y) {
				
					if (arr[y][x] == "=") {
			        arr[y][x] = "R";
			        
			        
			        System.out.println("ROBOT NAVIGATION - " + "[" + x + "]" +"[" + y + "]");
			     
					}
					else if (arr[y][x] == "X") {
						
						System.out.println("GameOver!");
						gameover = true;
						
						
					}
					else if (arr[y][x] == "C") {
						
						
						System.out.println("Rescue Succesfull");
						gameover = true;
					}
			        
				
			}
			public static void MoveRobot(int x,int y) {
				
				
		        arr[y][x] = "+";
		        
		}
			
			public static void SpawnHazards() {
			
						for (int i = 0; i < 20; i++) {
							
						
			        	generateCoordinates();
			        arr[y][x] = "X";
			     
						}
				
				
			}
			public  static void SpawnCasualty() {
			  generateCoordinates();
		        arr[y][x] = "C";
			}
			public static void ShowMap() {
				
				  for (int i=0; i<5; i++) {
			            for (int j=0; j<40; j++) {
			                System.out.print(arr[i][j]);
			            }
			            System.out.println();
			        }
				
				
			}
			
			public static void showRobotNavigation() {
				
				
				 System.out.println("ROBOT NAVIGATION - " + "[" + x + "]" +"[" + y + "]");
			}
}
