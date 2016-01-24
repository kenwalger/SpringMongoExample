package com.zyzzyxTech.springMongo.repositories;

import com.zyzzyxTech.springMongo.entities.Address;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ken on 1/23/2016.
 */
public interface AddressRepo extends CrudRepository<Address, Long> {
}
