package com.store.beautyproducts.resources;

import javax.servlet.http.HttpServletResponse;

import com.store.beautyproducts.Security.JWTUtil;
import com.store.beautyproducts.Security.UserSS;
import com.store.beautyproducts.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= "/auth")
public class AuthResource {
    @Autowired
    private JWTUtil jwtUtil;

@RequestMapping(value="/refresh_token", method=RequestMethod.POST)
public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
UserSS user = UserService.authenticate();
String token = jwtUtil.generateToken(user.getUsername());
response.addHeader("Authorization", "Bearer " + token);
return ResponseEntity.noContent().build();
}   

}
