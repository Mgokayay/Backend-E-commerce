package com.workintech.backend.dto;

import java.util.List;

public record UserResponse(Long id, String name, String email, List<AddressResponse> addresses) {
}
