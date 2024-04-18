package com.workintech.backend.dto;

public record CardResponse(Long card_id,Long card_no,Long card_expire_month,Long card_expire_year,Long card_ccv,String card_name) {
}
