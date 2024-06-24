package com.backend.eventbooking.dto.request;

import lombok.Builder;

@Builder
public record RegisterRequest(String mail, String name, String password) {
}
