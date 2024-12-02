package pe.edu.upeu.LP2_clase01.dto;

import lombok.Data;

@Data
public class AuthResponseDto {
    private String accessToken;
    private String tokenType = "Bearer"; 
}
