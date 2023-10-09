import java.util.Scanner;

 class User
{
    private double accountBalance;

    public User(double initialBalance)
    {
        this.accountBalance = initialBalance;
    }

    public void withdrawAmount(double amount) 
    {
        if (amount <= 0) 
		{
            System.out.println("Invalid amount. Please enter a positive value.");
        } 
		else if (amount > accountBalance) 
		{
            System.out.println("Insufficient funds.");
        } 
		else 
		{
            accountBalance = accountBalance-amount;
            System.out.println("Withdrawal successful. Remaining balance: $" + accountBalance);
        }
    }

    public void creditAmount(double amount)
    {
        if (amount <= 0) 
	{
            System.out.println("Invalid amount. Please enter a positive value.");
        } 
	else 
	{
            accountBalance= accountBalance+amount;
            System.out.println("Deposit successful. New balance: $" + accountBalance);
        }
    }


    public void checkBalance() 
    {
        System.out.println("Your account balance is: $" + accountBalance);
    }

   
}

 class Bank
{
	 public static void main(String[] args)
	{
        Scanner scanner = new Scanner(System.in);
        User user_name = new User(1000.0);
        int ch;

        do
	{
            System.out.println("\nATM Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the withdrawal amount: $");
                    double withdrawAmount = scanner.nextDouble();
                    user_name.withdrawAmount(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter the deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    user_name.creditAmount(depositAmount);
                    break;
                case 3:
                    user_name.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
			System.out.println("do you want to perform next operation 1/0");
			ch=scanner.nextInt();
        }while(ch==1);
    }
}