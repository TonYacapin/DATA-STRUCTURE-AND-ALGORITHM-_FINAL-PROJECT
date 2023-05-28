import java.util.Scanner;


public class MenuMain {

	public static void main(String[] args) {
		
		RobotMain Prog1 = new RobotMain();
		
		ConversionMain Prog2 = new ConversionMain(); 
		
		int choice;
		
		Scanner sc = new Scanner(System.in);
		
		char ans = 'y';
		do {
			System.out.println("Choose a Program to Run");
			System.out.println("1. RescueRobot\n2. ExpressionConversion\n3. Exit");

			choice = sc.nextInt();

			switch (choice) {

			case 1:
				Prog1.main(args);
				break;

			case 2:
				Prog2.main(args);
				break;

			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice!");
				break;
			}
			System.out.println("Choose Another Program? (Y/N)");
	    	ans = sc.next().charAt(0);
		} while (ans == 'y' || ans == 'Y');
	}
}