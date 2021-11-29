package com.skni.workshopspring3.repo;

import com.skni.workshopspring3.repo.entity.Person;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<Person, Long> {

	@Override
	List<Person> findAll();

	@Override
	Optional<Person> findById(Long id);

	List<Person> findAllByNameAndLastname(String name, String surname);

	@Query(
			value = "SELECT distinct p.* FROM person p JOIN address a ON p.address_id = a.id WHERE p.gender = ?1 " +
					"AND a.country = ?2",
			nativeQuery = true)
	List<Person> findAllByGenderAndCountry(String gender, String country);
}
