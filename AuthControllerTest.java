// tetsta autenticação
// backend/src/test/java/com/amipet/controller/AuthControllerTest.java

package com.amipet.controller;

import com.amipet.model.User;
import com.amipet.service.UserService;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

public class AuthControllerTest {

    @Test
    void loginShouldSuccede() {
        UserService service = mock(UserService.class);
        AuthController controller = new AuthController(service);
        User user = new User("user@email.com", "1234");

        when(service.authenticate("user@email.com", "1234")).thenReturn(true);

        ResponseEntity<?> response = controller.login(user);
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void loginShouldFail() {
        UserService service = mock(UserService.class);
        AuthController controller = new AuthController(service);
        User user = new User("user@email.com", "qualquerciosaa");

        when(service.authenticate("user@email.com", "qualquercoisaa")).thenReturn(false);

        ResponseEntity<?> response = controller.login(user);
        assertEquals(401, response.getStatusCodeValue());
    }
}
