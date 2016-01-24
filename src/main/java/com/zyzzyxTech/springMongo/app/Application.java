package com.zyzzyxTech.springMongo.app;

import com.zyzzyxTech.springMongo.entities.Address;
import com.zyzzyxTech.springMongo.entities.Person;
import com.zyzzyxTech.springMongo.repositories.AddressRepo;
import com.zyzzyxTech.springMongo.repositories.PersonRepo;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.util.List;

/**
 * Created by Ken on 1/23/2016.
 */
public class Application {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(new ClassPathResource("spring-config.xml").getPath());
        PersonRepo personRepo = context.getBean(PersonRepo.class);
        AddressRepo addressRepo = context.getBean(AddressRepo.class);

        Person personKen = new Person();
        personKen.setPersonId(1L);
        personKen.setName("Ken");
        personRepo.save(personKen);

        Person personJenny = new Person();
        personJenny.setPersonId(2L);
        personJenny.setName("Jenny");
        personRepo.save(personJenny);

        Address address = new Address(1L, "555 Main ST", "Keizer", "OR", 55555L);
        List<Address> addresses = personJenny.getAddresses();
        addresses.add(address);
        personKen.setAddresses(addresses);

        addressRepo.save(address);
        personRepo.save(personJenny);

        Iterable<Person> personList = personRepo.findAll();
        System.out.println("Person List : ");
        for (Person person : personList) {
            System.out.println(person);
        }

        System.out.println("Person Record with name Jenny is "
                + personRepo.searchByName("Jenny"));

        context.close();
    }
}
