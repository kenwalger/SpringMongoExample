package com.zyzzyxTech.springMongo.repositories;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.zyzzyxTech.springMongo.entities.Person;

/**
 * Created by Ken on 1/23/2016.
 */
public interface PersonRepo extends CrudRepository<Person, Long>{

    @Query("{'name': ?0}")
    Iterable<Person> searchByName(String personName);
}
