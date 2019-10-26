import java.util.List;

public class CurrencyValidation {
	
	public CustomerData findAccount(
			long account,List<CustomerData> customers) {

		for (CustomerData customer : customers) {
			if (customer.getAccount_number() == account) {
				return customer;
			}
		}
		return null;
	}

	public float isValid(String type, float amount)
	{
		boolean isValid = false;
		try {
			CurrencyType.valueOf(type); 
			isValid = true;
			if(isValid) {   

				switch(CurrencyType.valueOf(type))
				{
				case CAD:
					break;
				case USD:
					amount = (float) (amount / 0.5);
					break;
				case PESO:
					amount = (float) (amount / 10);
					break;
				}
				
			} 
			
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid currency");
		}
		return amount;
	}
}


