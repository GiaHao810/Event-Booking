package com.backend.eventbooking.modelDTO;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuccessAuthenticationResponse extends Response {
    private String token;
    private long expiresAt;
}
