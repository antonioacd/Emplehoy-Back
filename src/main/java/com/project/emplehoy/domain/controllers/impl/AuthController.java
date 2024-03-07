package com.project.emplehoy.domain.controllers.impl;


import com.project.emplehoy.domain.dto.AuthResponseDTO;
import com.project.emplehoy.domain.dto.LoginDTO;
import com.project.emplehoy.domain.dto.RegisterDTO;
import com.project.emplehoy.domain.services.impl.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    /**
     * Handles user login.
     *
     * @param loginDTO The login data transfer object.
     * @return ResponseEntity containing the authentication response data transfer object.
     */
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDTO loginDTO) {
        System.out.println("Entro al login");

        return authService.login(loginDTO);
    }

    /**
     * Handles user registration.
     *
     * @param registerDTO The registration data transfer object.
     * @return ResponseEntity containing a message indicating the success or failure of the registration.
     */
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDTO) {
        System.out.println("Entro al metodo");
        return authService.register(registerDTO);
    }
}
