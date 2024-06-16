package com.backend.eventbooking.modelDTO;

import lombok.*;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class FailAuthenticationResponse extends Response{
    private String message;
}
