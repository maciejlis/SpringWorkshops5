package com.skni.workshopspring3.service;

import com.skni.workshopspring3.repo.PersonRepository;
import com.skni.workshopspring3.repo.entity.Address;
import com.skni.workshopspring3.repo.entity.GenderEnum;
import com.skni.workshopspring3.repo.entity.Person;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonService {

	private final PersonRepository personRepository;

	public boolean deletePersonById(Long id){
		Optional<Person> person = personRepository.findById(id);
		if(person.isPresent()){
			personRepository.delete(person.get());
			return true;
		}
		return false;
	}

	public Person addPerson(String name, String lastname, LocalDate birthdate, GenderEnum gender, Address address){
		//Person person = new Person(name, lastname, birthdate, gender, address);

		Person person = Person.builder()
				.name(name)
				.lastname(lastname)
				.birthdate(birthdate)
				.gender(gender)
				.address(address)
				.build();

		//nadanie ID
		return personRepository.save(person);
	}

	public List<Person> getAllPeople(){
		//możemy filtrować na stream-ie
		return personRepository.findAll();
	}

	public Optional<Person> getPersonById(Long id){
		return personRepository.findById(id);
	}

}
