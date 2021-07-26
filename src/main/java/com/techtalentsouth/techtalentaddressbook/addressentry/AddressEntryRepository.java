package com.techtalentsouth.techtalentaddressbook.addressentry;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressEntryRepository extends CrudRepository<AddressEntry, Long>{

}
