package com.backend.eventbooking.dto.response;

import com.backend.eventbooking.dto.Response;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuccessAuthenticationResponse extends Response {
    private String token;
    private long expiresAt;

    public SuccessAuthenticationResponse(String message, String token, long expiresAt) {
        super(message);
        this.token = token;
        this.expiresAt = expiresAt;
    }
}
