package donnFelker.services;

import com.sun.istack.internal.NotNull;
import models.Customer;
import models.StringExtensions;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    /* @NotNull annotation is used so that 'Customer' stops being a
    *  platform type(Customer!) when called in kotlin */
    @NotNull
    public Customer customerFromSocial(String handle) {
        Customer c = new Customer("Bob");
        // calling a kotlin extension function from java
        String initials = StringExtensions.initials(c.getName());
        return c;
    }

    @NotNull
    public List<Customer> processedCustomers() {
        return new ArrayList<>();
    }

    /* calling kotlin from java */
    public void processCustomer(Customer customer) {
        customer.customerHasLongName();
    }
}
