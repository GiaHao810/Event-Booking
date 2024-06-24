package com.backend.eventbooking.dto.request;

import lombok.Builder;

@Builder
public record AuthenticationRequest(String mail, String password) {
}
