package bankapplication;

public class Account {

	private int id;
	private static int uid = 0;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	private double balance;
	
	public Account(String firstName, String lastName, String phoneNumber, String address){
	    this.firstName = firstName;
	    this.lastName = lastName;
	    this.phoneNumber = phoneNumber;
	    this.address = address;
	    this.balance = 0.0;
	    uid++;
	    this.id = uid;
	}

	/*
	 * Getters
	 */
	public int getId() {
		return id;
	}

	public static int getUid() {
		return uid;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public double getBalance() {
		return balance;
	}

	/*
	 * Setters
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	
	/*
	 * Methods
	 */
	
	/**
	 * @param depositAmount
	 * 
	 * this deposit Amount Method aims to take a specific amount
	 * make the right check before proceeding.
	 * if the Amount is positive we add to the current balance the Amount provided
	 * Otherwise we throw a message asking for a valid Amount.
	 */
	public void depositMoney(double depositAmount) {
			if(depositAmount<=0) {
				System.out.println("Sorry we can not proceed. Give a positive value for the Amount.");
			}else {
				this.balance += depositAmount;
				System.out.println("You have made a deposit of " + depositAmount + " USD ($) to your Account." + "\n" 
									+ "Your balance is now: " + this.balance + " USD ($). ");
			}
	}
	
	/**
	 * @param withdrawalAmount
	 * 
	 * this withdrawal Amount Method aims to take a specific amount
	 * make the right check before proceeding.
	 * if the Amount is positive we retrieve to the current balance the Amount provided
	 * Otherwise we throw a message asking for a valid Amount.
	 */
	public void withdrawalMoney(double withdrawalAmount) {
		if(this.balance <= withdrawalAmount) {
			System.out.println("We're sorry your funds are not enough for that operation");
			System.out.println("This is your current balance" + this.balance);		
		}else {
			this.balance -= withdrawalAmount;
			System.out.println("You have made a withdraw of "+ withdrawalAmount +" USD ($) to your Account." + "\n" 
					+ "Your balance is now: " + this.balance + " USD ($). ");
		}
	}
	
	public void moneyTransfer(Account thisAccount, Account toAccount, double amountToTransfer){
	    if(thisAccount.getBalance() > 0) {
	        toAccount.setBalance(toAccount.balance += amountToTransfer);
	        thisAccount.setBalance(this.balance -= amountToTransfer);
	    } else {
	        System.out.println("You don't have enough funds");
	    }
	}

	@Override
	public String toString(){
	    return 	"ID: " + getId() + "\n" +
	    		"Name: " + getFirstName() + "\n" +
	            "Last name: " +getLastName() +"\n" +
	            "Balance: " + getBalance() + "\n";
	            

	}
	
}
	
	

