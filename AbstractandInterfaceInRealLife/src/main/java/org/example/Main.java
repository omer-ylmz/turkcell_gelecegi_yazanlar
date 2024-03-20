package org.example;

import Abstract.BaseCustomerManager;
import Abstract.IEntity;
import Adapters.MernisServiceAdaptor;
import Concreate.CustomerCheckManager;
import Concreate.NeroCustomerManager;
import Concreate.StarbucksCustomerManager;
import entities.Customer;

import java.time.LocalDate;
import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        LocalDate birthdate = LocalDate.of(2002, 2, 18);

        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setFirstName("Ömer");
        customer1.setLastName("Yılmaz");
        customer1.setDateOfBirth(birthdate);
        customer1.setNationlyId("12668228702");

        BaseCustomerManager customerManager = new StarbucksCustomerManager(new MernisServiceAdaptor());


        customerManager.save(customer1);
        System.out.println(customer1.getFirstName().toUpperCase());
        System.out.println(customer1.getLastName().toUpperCase());
        System.out.println(customer1.getNationlyId());


        System.out.println(customer1.getDateOfBirth().getYear());


    }
}