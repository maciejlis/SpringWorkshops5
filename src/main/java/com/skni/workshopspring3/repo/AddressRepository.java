package com.skni.workshopspring3.repo;

import com.skni.workshopspring3.repo.entity.Address;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
	Optional<Address> findFirstByCity(String city);
}
