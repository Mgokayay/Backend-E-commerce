package com.workintech.backend.service;

import com.workintech.backend.dto.AddressResponse;
import com.workintech.backend.entity.Address;
import com.workintech.backend.exceptions.CommonException;
import com.workintech.backend.repository.AddressRepository;
import com.workintech.backend.util.AddressDtoConvertion;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService{


    private AddressRepository addressRepository;
    @Override
    public List<AddressResponse> findAll() {
        List<Address> address = addressRepository.findAll();
        return AddressDtoConvertion.convertAddressList(address);
        //return AddressDtoConvertion.convertAddressList(addressRepository.findAll());
    }

    @Override
    public AddressResponse findById(Long id) {
        Optional<Address> addressOptional = addressRepository.findById(id);
        if(addressOptional.isPresent()){

            return AddressDtoConvertion.convertAddress(addressOptional.get());
        }

        throw new CommonException("Address is not found with given id " + id, HttpStatus.NOT_FOUND);

    }

    @Override
    public AddressResponse save(Address address) {
        addressRepository.save(address);
        return AddressDtoConvertion.convertAddress(address);
    }

    @Override
    public AddressResponse delete(Long id) {
        Optional<Address> addressOptional = addressRepository.findById(id);
        if(addressOptional.isPresent()){
           addressRepository.delete(addressOptional.get());
           return AddressDtoConvertion.convertAddress(addressOptional.get());
        }
        throw new CommonException("Address is not found with given id " + id, HttpStatus.NOT_FOUND);

    }

    @Override
    public Address findByAddressId(Long addressId) {
        Optional<Address> addressOptional = addressRepository.findById(addressId);
        if(addressOptional.isPresent()){
            return addressOptional.get();
        }

        throw new CommonException("Address is not found with given id " + addressId, HttpStatus.NOT_FOUND);

    }
}
