import java.util.List;

public interface Transaction {
	

	void deposit(CustomerData customer);
	void withdraw(CustomerData customers);
	void showAccounts(List<CustomerData> customers);

}
