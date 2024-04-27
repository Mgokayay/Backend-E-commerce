package com.workintech.backend.dto;

import java.time.LocalDateTime;

public record OrderResponse(Long id, LocalDateTime order_date,Long user_id,AddressResponse addressResponse,CardResponse cardResponse) {
}
