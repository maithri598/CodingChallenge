
public class CustomerData {
	
	private String name;
	private long account_number;
	private float balance;
	
	public CustomerData() {
		super();
	}


	public CustomerData(String name, long account_number, float balance) {
		super();
		this.name = name;
		this.account_number = account_number;
		this.balance = balance;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public long getAccount_number() {
		return account_number;
	}


	public void setAccount_number(long account_number) {
		this.account_number = account_number;
	}


	public float getBalance() {
		return balance;
	}


	public void setBalance(float balance) {
		this.balance = balance;
	}


	@Override
	public String toString() {
		return "CustomerData [name=" + name + ", account_number=" + account_number + ", balance=" + balance + "]";
	}
	
	
}
