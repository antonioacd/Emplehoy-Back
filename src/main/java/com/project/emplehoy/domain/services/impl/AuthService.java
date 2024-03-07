package com.project.emplehoy.domain.services.impl;

import com.project.emplehoy.domain.dto.AuthResponseDTO;
import com.project.emplehoy.domain.dto.LoginDTO;
import com.project.emplehoy.domain.dto.RegisterDTO;
import com.project.emplehoy.domain.entities.LocationEntity;
import com.project.emplehoy.domain.entities.RoleEntity;
import com.project.emplehoy.domain.entities.UserEntity;
import com.project.emplehoy.domain.repositories.LocationRepository;
import com.project.emplehoy.domain.repositories.RoleRepository;
import com.project.emplehoy.domain.repositories.UserRepository;
import com.project.emplehoy.domain.security.JwtGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * Service class for handling authentication-related operations.
 */
@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final LocationRepository locationRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtGenerator jwtGenerator;

    /**
     * Authenticates a user based on the provided login credentials.
     *
     * @param loginDTO The DTO containing user login information.
     * @return ResponseEntity containing the authentication token upon successful authentication.
     */
    public ResponseEntity<AuthResponseDTO> login(LoginDTO loginDTO) {
        System.out.println("1 Entro al metodo del servicio");
        try {
            System.out.println("2 Dentro del try");
            // Attempt to authenticate the user
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDTO.getEmail(),
                            loginDTO.getPassword()));

            System.out.println("3 Paso el autentication");

            // Set the authentication in the SecurityContext
            SecurityContextHolder.getContext().setAuthentication(authentication);

            System.out.println("4 Paso el context holder");

            // Generate a JWT token
            String token = jwtGenerator.generateToken(authentication);

            System.out.println("5 Paso el generador de token");

            // Return the token in the response
            return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
        } catch (Exception e) {
            // Handle authentication failure
            System.out.println("Cojo el error: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * Registers a new user with the provided registration details.
     *
     * @param registerDTO The DTO containing user registration information.
     * @return ResponseEntity with a success message upon successful registration.
     */
    public ResponseEntity<String> register(RegisterDTO registerDTO) {
        // Check if the email is already taken
        if (userRepository.existsByEmail(registerDTO.getEmail())) {
            return new ResponseEntity<>("Username is taken!", HttpStatus.BAD_REQUEST);
        }

        // Create a new user entity and populate it with registration details
        UserEntity user = new UserEntity();
        user.setName(registerDTO.getName());
        user.setSurname(registerDTO.getSurname());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        user.setNumber("Sin numero");
        user.setAge(18);
        user.setOccupation("Sin ocupación");
        user.setImage("imagen");
        user.setDescription("Sin Descripción");
        user.setRating(5);

        LocationEntity locationEntity = locationRepository.findById(1L)
                .orElseThrow(() -> new IllegalStateException("Location not found"));

        user.setLocation(locationEntity);

        // Retrieve the "USER" role from the database or throw an exception if not found
        RoleEntity userRole = roleRepository.findByRole("ROLE_USER")
                .orElseThrow(() -> new IllegalStateException("Role 'ROLE_USER' not found"));

        // Assign the role to the user
        user.setRoles(Collections.singletonList(userRole));

        // Save the user in the database
        userRepository.save(user);

        // Return a success message in the response
        return new ResponseEntity<>("User registered success!", HttpStatus.OK);
    }
}
