package com.workintech.backend.service;

import com.workintech.backend.dto.AddressResponse;
import com.workintech.backend.entity.Address;
import com.workintech.backend.entity.User;

import java.util.List;

public interface AddressService {

    List<AddressResponse> findAll();

    AddressResponse findById(Long id);

    AddressResponse save(Address address);

    AddressResponse delete(Long id);

    Address findByAddressId(Long addressId);
}
