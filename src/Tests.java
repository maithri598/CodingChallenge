import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Tests {

		@Test
		public void testAccountAvailability() {
			CurrencyValidation currencycheck = new CurrencyValidation();
			List<CustomerData> customers = new ArrayList<>();
			CustomerData CustomerData = new CustomerData();
			CustomerData.setAccount_number(1234);
			CustomerData.setBalance(100);
			CustomerData.setName("sam");
			customers.add(CustomerData);
			CustomerData selectedCustomer = currencycheck.findAccount(1234, customers);
			assertThat(CustomerData,is(selectedCustomer));
		}

}
