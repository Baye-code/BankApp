package bankapplication;
import java.util.Scanner;

public class BankAppRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean exitEquested = false;
		
		Scanner sc = new Scanner(System.in);
		
		Bank bank = new Bank();
		Service service = new Service();
		
		service.printMenu();
		
		while(!exitEquested) {
			
			int choice = Integer.parseInt(sc.next());
			
			switch (choice) {
			case 1:
				bank.registerAccount();
				service.MenuAfterRegister();
				break;
			case 2:
				bank.loginAccount();
				break;
			case 3:
				exitEquested = false;
				break;
			default:
				System.out.println("Wrong Input");
				System.out.println("Please choose a number between those listed above ");
				break;
			}
			
		}

	}

}
