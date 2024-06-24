package com.backend.eventbooking.dto.response;

import com.backend.eventbooking.dto.Response;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class FailAuthenticationResponse extends Response {
    private String status;
    private Object data;

    public FailAuthenticationResponse(String message, String status, Object data) {
        super(message);
        this.status = status;
        this.data = data;
    }
}
