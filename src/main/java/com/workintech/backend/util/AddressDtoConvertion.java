package com.workintech.backend.util;

import com.workintech.backend.dto.AddressResponse;
import com.workintech.backend.entity.Address;

import java.util.ArrayList;
import java.util.List;

public class AddressDtoConvertion {



    public static List<AddressResponse> convertAddressList(List<Address> addresses ){
        List<AddressResponse> addressResponses = new ArrayList<>();
        addresses.stream().forEach(address -> addressResponses.add(new AddressResponse(address.getId(),address.getCity(),
                address.getDistrict(),address.getName(),address.getPhone(),address.getTitle(),address.getNeighborhood(),address.getAddress())));
        return addressResponses;
    }

    public static AddressResponse convertAddress(Address address){
        return new AddressResponse(address.getId(),address.getCity(),
                address.getDistrict(),address.getName(),address.getPhone(),address.getTitle(),address.getNeighborhood(),address.getAddress());
    }
}
