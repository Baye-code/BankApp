package bankapplication;

public class Service {
	
	public static void printMenu() {
		for(int i=0; i<=43; i++) {
			System.out.print("*");
			try {
				Thread.sleep(80);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("");
		System.out.println("    Hello dear welcome to your Bank App    ");
		System.out.println("********************************************");
		System.out.println("\n");
		System.out.println("Please choose one option among listed above" + "\n");
		System.out.println("\r" + "1. Register " + "\n" +
							"\r" + "2. Log in " + "\n" +
							 "\r" + "3. Exit " + "\n");	
		System.out.println("\n" + ">>");
	}
	
	public static void MenuAfterRegister() {
		System.out.println("Please choose one option among listed above" + "\n");
		System.out.println("\r" + "1. Register " + "\n" +
							"\r" + "2. Log in " + "\n" +
							 "\r" + "3. Exit " + "\n");	
		System.out.println("\n" + ">>");
	}
	
	public static void existAccountMenu() {
		System.out.println("What would you like to do ?" + "\n" +
                "\r" + "1. Info" + "\n" +
                "\r" + "2. Deposit money" + "\n" +
                "\r" + "3. Withdrawal money" + "\n" +
                "\r" + "4. Money transferring" + "\n" +
                "\r" + "5. Exit");
	}

}
