package com.workintech.backend.controller;

import com.workintech.backend.dto.AddressResponse;
import com.workintech.backend.entity.Address;
import com.workintech.backend.entity.User;
import com.workintech.backend.service.AddressService;
import com.workintech.backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@AllArgsConstructor
public class AddressController {

    private final AddressService addressService;
    private final UserService userService;


    @GetMapping("/")
    public List<AddressResponse> findAll(){
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public AddressResponse findById(@PathVariable Long id){
        return addressService.findById(id);
    }

    @PostMapping("/{userId}")
    public AddressResponse save(@RequestBody Address address,@PathVariable Long userId){
        User user = userService.findByUserId(userId);
        address.setUser(user);
        user.getAddresses().add(address);
        return addressService.save(address);
    }

    @DeleteMapping("/{id}")
    public AddressResponse delete(@PathVariable Long id){
        return addressService.delete(id);
    }
}
