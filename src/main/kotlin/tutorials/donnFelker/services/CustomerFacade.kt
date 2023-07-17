package tutorials.donnFelker.services

class CustomerFacade(customerService: CustomerService) {

    init {
        val customer = customerService.customerFromSocial("@exampleusername")

        val customers = customerService.processedCustomers()
    }

}