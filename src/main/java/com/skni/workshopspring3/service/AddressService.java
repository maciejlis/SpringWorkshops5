package com.skni.workshopspring3.service;

import com.skni.workshopspring3.repo.AddressRepository;
import com.skni.workshopspring3.repo.entity.Address;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AddressService {

	private final AddressRepository addressRepository;

	public boolean deleteAddressById(Long id){
		Optional<Address> address = addressRepository.findById(id);
		if(address.isPresent()){
			addressRepository.delete(address.get());
			return true;
		}
		return false;
	}

	public Address addAddress(String street, String city, String country){
		Address address = Address.builder()
				.street(street)
				.city(city)
				.country(country)
				.build();

		return addressRepository.save(address);
	}

	public Optional<Address> getAddressByCity(String city){
		return addressRepository.findFirstByCity(city);
	}

	public boolean updateAddress(long id, Address updatedAddress) {
		Optional<Address> currentAddress = addressRepository.findById(id);
		if(currentAddress.isPresent()) {
			Address newAddress = currentAddress.get();
			if(updatedAddress.getCity() != null) {
				newAddress.setCity(updatedAddress.getCity());
			}
			if(updatedAddress.getStreet() != null) {
				newAddress.setStreet(updatedAddress.getStreet());
			}
			if(updatedAddress.getCountry() != null) {
				newAddress.setCountry(updatedAddress.getCountry());
			}
			newAddress.setId(id);
			addressRepository.save(newAddress);
			return true;
		}
		return false;
	}
}
