package com.skni.workshopspring3.controller;

import com.skni.workshopspring3.dto.AddressRequest;
import com.skni.workshopspring3.dto.AddressResponse;
import com.skni.workshopspring3.repo.AddressRepository;
import com.skni.workshopspring3.repo.entity.Address;
import com.skni.workshopspring3.service.AddressService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class AddressController {

    private final AddressRepository addressRepository;
    private final AddressService addressService;
    private final ModelMapper modelMapper;

    @GetMapping("/address")
    public List<AddressResponse> getAddresses() {
        return addressService.getAllAddresses();
    }

    @GetMapping("/address/{id}")
    public ResponseEntity<Address> getAddress(@PathVariable Long id) {
        Optional<Address> result = addressRepository.findById(id);

        if(result.isPresent())
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping("/address")
    public void addAddress(@Valid @RequestBody AddressRequest address) {
        Address newAddress = modelMapper.map(address, Address.class);
        addressRepository.save(newAddress);
    }

    @DeleteMapping("/address/{id}")
    public ResponseEntity<?> addAddress(@PathVariable Long id) {
       if(addressRepository.findById(id).isPresent()){
           addressRepository.deleteById(id);
           return new ResponseEntity<>(HttpStatus.OK);
       }
       else {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }

    @PatchMapping("/address/{id}")
    public ResponseEntity<?> updateAddress(@PathVariable Long id, @RequestBody Address address) {
        if(addressService.updateAddress(id, address)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // https://www.baeldung.com/spring-boot-bean-validation
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
