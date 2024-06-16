package com.backend.eventbooking.modelDTO;

import lombok.Builder;

@Builder
public record RegisterRequest(String mail, String name, String password) {
}
