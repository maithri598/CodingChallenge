import java.util.List;
import java.util.Scanner;

public class Customer implements Transaction {

	CurrencyValidation currencycheck = new CurrencyValidation();

	Scanner input = new Scanner(System.in);

	public CustomerData createAccount(CustomerData customerData)
	{
		System.out.println("Enter customer name:\n");
		customerData.setName(input.next()); 
		System.out.printf("Enter account number :\n");
		customerData.setAccount_number(input.nextInt());
		System.out.println("Enter balance:\n");
		customerData.setBalance(input.nextInt());
		return customerData;
	}
	
	@Override
	public void showAccounts(List<CustomerData> customers)
	{
		customers.stream().forEach(customerData -> {
			System.out.println("Name : " + customerData.getName() + ", AccountNumber : " + customerData.getAccount_number()+", Balance : " + customerData.getBalance()+" CAD");
		});
	}

	@Override
	public void deposit(CustomerData customer) {
		// TODO Auto-generated method stub
		float amt;
		System.out.println("Enter currency : ");
		String cur = input.next();
		float currentBalance = customer.getBalance();
		System.out.println("Enter amount you want to deposit : ");
		amt=input.nextFloat();
		customer.setBalance(currentBalance + currencycheck.isValid(cur,amt));
		System.out.println("Name : " + customer.getName() + ", AccountNumber : " + customer.getAccount_number()+", Balance : " + customer.getBalance()+" CAD");

	}

	@Override
	public void withdraw(CustomerData customer) {
		// TODO Auto-generated method stub
		float amt;
		System.out.println("Enter currency : ");
		String cur = input.next();
		System.out.println("Enter amount you want to withdraw : ");
		amt=input.nextLong();
		if(customer.getBalance() >= currencycheck.isValid(cur,amt))
		{
		  customer.setBalance(customer.getBalance() - currencycheck.isValid(cur,amt));
			System.out.println("Name : " + customer.getName() + ", AccountNumber : " + customer.getAccount_number()+", Balance : " + customer.getBalance()+" CAD");
		}
		else {
			System.out.println("Insufficient funds to withdraw ");
		}
		
}
}

