package pe.edu.upeu.LP2_clase01.controller;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.LP2_clase01.dto.AuthResponseDto;
import pe.edu.upeu.LP2_clase01.dto.LoginDto;
import pe.edu.upeu.LP2_clase01.service.AuthService;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // Build Login REST API
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto){

        //01 - Receive the token from AuthService
        String token = authService.login(loginDto);

        //02 - Set the token as a response using JwtAuthResponse Dto class
        AuthResponseDto authResponseDto = new AuthResponseDto();
        authResponseDto.setAccessToken(token);

        //03 - Return the response to the user
        return new ResponseEntity<>(authResponseDto, HttpStatus.OK);
    }
}
