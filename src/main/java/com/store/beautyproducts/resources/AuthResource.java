package com.store.beautyproducts.resources;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.store.beautyproducts.Security.JWTUtil;
import com.store.beautyproducts.Security.UserSS;
import com.store.beautyproducts.dto.EmailDTO;
import com.store.beautyproducts.services.AuthService;
import com.store.beautyproducts.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {
    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthService service;

    @RequestMapping(value = "/refresh_token", method = RequestMethod.POST)
    public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
        UserSS user = UserService.authenticate();
        String token = jwtUtil.generateToken(user.getUsername());
        response.addHeader("Authorization", "Bearer " + token);
        response.addHeader("access-control-expose-headers","Authorization");
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/forgot", method = RequestMethod.POST)
    public ResponseEntity<Void> forgot(@Valid @RequestBody EmailDTO objDTO) {
        service.sendNewPassword(objDTO.getEmail());
        return ResponseEntity.noContent().build();
    }
}
