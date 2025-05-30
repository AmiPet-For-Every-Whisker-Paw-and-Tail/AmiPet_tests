// Testa existencia do usuário
// backend/src/test/java/com/amipet/UserServiceTest.java

package com.amipet.service;

import com.amipet.model.User;
import com.amipet.repository.UserRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Test
    void returnUser_ifExists() {
        UserRepository repo = mock(UserRepository.class);
        UserService service = new UserService(repo);
        User user = new User("user@email.com", "1234");

        when(repo.findByEmail("user@email.com")).thenReturn(user);

        User result = service.findByEmail("user@email.com");
        assertNotNull(result);
        assertEquals("user@email.com", result.getEmail());
    }
}
