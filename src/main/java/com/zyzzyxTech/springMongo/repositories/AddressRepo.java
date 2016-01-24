package com.zyzzyxTech.springMongo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.zyzzyxTech.springMongo.entities.Address;

/**
 * Created by Ken on 1/23/2016.
 */
public interface AddressRepo extends CrudRepository<Address, Long>{
}
