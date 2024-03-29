package com.project.emplehoy.domain.dto;

import com.project.emplehoy.domain.security.SecurityConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AuthResponseDTO {

    private String accessToken;
    private static final String TOKEN_TYPE = SecurityConstants.TOKEN_TYPE;

    public String getTokenType() {
        return TOKEN_TYPE;
    }
}
