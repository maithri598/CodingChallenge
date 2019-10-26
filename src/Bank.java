import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {

	public Bank() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Customer customer = new Customer();

		CustomerData selectedCustomer = new CustomerData();

		List<CustomerData> customers = new ArrayList<>();

		CurrencyValidation currencycheck = new CurrencyValidation();

		long account;

		Scanner input = new Scanner(System.in);

		try {
			if(customers.isEmpty())
			{
				int choice;
				do
				{
					System.out.println("Main Menu\n 1.Add customers\n 2.Display All\n 3.Search By Account\n 4.Deposit\n 5.Withdrawal\n 6.Exit");
					System.out.println("Choose an action :");
					choice=input.nextInt();
					switch(choice)
					{ 
					case 1:
						System.out.println("Add Customers");
						
						System.out.print("How many customers to create accounts for :\n ");
						int noOfCustomers = input.nextInt();
						for(int i=0;i<noOfCustomers;i++) {
							CustomerData customerData = new CustomerData();
							customerData = customer.createAccount(customerData);
							if(currencycheck.findAccount(customerData.getAccount_number(), customers) != null) 
								System.out.println("Account number already exists.Please enter a different account number.");
							else
								customers.add(customerData);
						}
						break;
					case 2:
						if(customers!=null)
							customer.showAccounts(customers);
						else
							System.out.println("No customers in bank. Please add customers to view accounts.");
						break;

					case 3:
						System.out.println("Enter account number you want to search ");
						account = input.nextLong();
						selectedCustomer = currencycheck.findAccount(account, customers);
						if(selectedCustomer!=null)
							System.out.println("Name : " + selectedCustomer.getName() + ", AccountNumber : " + selectedCustomer.getAccount_number()+", Balance : " + selectedCustomer.getBalance()+" CAD");
						else
							System.out.println("Search Failed..Account doesn't Exist..");
						break;

					case 4:
						System.out.println("enter account you want to deposit");
						account = input.nextLong();
						selectedCustomer = currencycheck.findAccount(account, customers);
						if(selectedCustomer!=null)
							customer.deposit(selectedCustomer);
						else
							System.out.println("Search Failed..Account Not Exist..");
						break;

					case 5:
						System.out.println("enter account you want to withdraw");
						account = input.nextLong();
						selectedCustomer = currencycheck.findAccount(account, customers);
						if(selectedCustomer!=null)
							customer.withdraw(selectedCustomer);
						else
							System.out.println("Search Failed..Account Not Exist..");
						break;
					
					case 6:
						System.out.println("Good Bye..");
						break;
					}
				}
				while(choice!=6);
			}
			else
				throw new Exception();

		}

		catch(Exception e)
		{
			System.out.println("No accounts in bank. Please restart program");

			}
		input.close();
	}
}

