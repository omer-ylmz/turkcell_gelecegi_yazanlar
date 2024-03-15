package Adapters;

import Abstract.ICustomerCheckService;

import entities.Customer;
import mernisReference.KHRKPSPublicSoap;


public class MernisServiceAdaptor implements ICustomerCheckService {


    @Override
    public boolean CheckIfRealPerson(Customer customer) throws Exception {
        KHRKPSPublicSoap client = new KHRKPSPublicSoap();
        return client.TCKimlikNoDogrula( Long.parseLong(customer.getNationlyId())  ,customer.getFirstName().toUpperCase(),
                customer.getLastName().toUpperCase(),customer.getDateOfBirth().getYear());

    }
}






