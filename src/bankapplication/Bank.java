package bankapplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {
	
	private List<Account> bankAccounts;
	private Scanner sc;
	
	public Bank() {
		bankAccounts = new ArrayList<>();
		sc = new Scanner(System.in);
	}
	
	
	public Account isAccountExist(int accountId, String phoneNumber) {
	    for (Account account : bankAccounts) {
	        if (account.getId() == accountId && account.getPhoneNumber() == phoneNumber) {
	            return account;
	        }
	    }
	    return null;
	}
	
	public Account isAccountExist(String phoneNumber) {
	    for (Account account : bankAccounts) {
	        if (account.getPhoneNumber().equals(phoneNumber)) {
	            return account;
	        }
	    }
	    System.out.println("One of the details is incorrect");
	    return null;
	}
		
	
	public void registerAccount() {
	    System.out.println("First name ? ");
	    String firstName = sc.next();
	    System.out.println("Last name ? ");
	    String lastName = sc.next();
	    System.out.println("Phone number ? (10 - digits Please :)");
	    String phoneNumber = sc.next();
	    System.out.println("Address ? ");
	    String address = sc.next();
	    if (isPhoneNumberCorrect(phoneNumber)) {
	        bankAccounts.add(new Account(firstName, lastName, phoneNumber, address));
	        System.out.println("You have created account successfully!" + "\n" +
	                "Your account ID is: " + bankAccounts.get(bankAccounts.size() - 1).getId());

	    }
	}
	
	
	public void loginAccount() {

		System.out.println("Please enter your ID:");
	    int accountId = sc.nextInt();
	    System.out.println("Please enter your phone number:");
	    String phoneNumber = sc.next();
	    if (isPhoneNumberCorrect(phoneNumber)) {
	        Account selectedAccount = isAccountExist(accountId, phoneNumber);
	        Service printService = new Service();
	        boolean exitRequested = false;
	        while (!exitRequested) {
	            printService.existAccountMenu();
	            int choice = Integer.parseInt(sc.next());
	            switch (choice) {
	                case 1:
	                    System.out.println(selectedAccount);
	                    break;
	                case 2:
	                    System.out.println("Please enter deposit amount:");
	                    double depositAmount = sc.nextDouble();
	                    selectedAccount.depositMoney(depositAmount);
	                    break;
	                case 3:
	                    System.out.println("Please enter withdrawal amount:");
	                    double withdrawalAmount = sc.nextDouble();
	                    selectedAccount.withdrawalMoney(withdrawalAmount);
	                    break;
	                case 4:
	                    System.out.println("Please enter the phone number of the account you want to transfer to: ");
	                    String accountPhoneNumber = sc.next();
	                    if (isPhoneNumberCorrect(accountPhoneNumber)) {
	                        Account accountToTransfer = isAccountExist(accountPhoneNumber);
	                        System.out.println("Enter the amount of money you would like to transfer:");
	                        double moneyToTransfer = sc.nextDouble();
	                        selectedAccount.moneyTransfer(selectedAccount, accountToTransfer, moneyToTransfer);
	                        break;
	                    }
	                        case 5:
	                            exitRequested = true;
	                            break;
	                        default:
	                            System.out.println("Wrong input");
	                            break;
	                    }
	            }
	        }
		
	}


	public static boolean isPhoneNumberCorrect(String phoneNumber){
	    if(phoneNumber.length() != 10){
	        System.out.println("Phone number must be 10 digits.");
	        return false;

	} else {
	        return true;
	    }
	}
	

}
