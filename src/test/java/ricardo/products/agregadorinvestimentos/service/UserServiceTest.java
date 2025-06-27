package ricardo.products.agregadorinvestimentos.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ricardo.products.agregadorinvestimentos.controller.CreateUserDto;
import ricardo.products.agregadorinvestimentos.entity.User;
import ricardo.products.agregadorinvestimentos.repository.UserRepository;

import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {


    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Captor
    private ArgumentCaptor<User> userArgumentCaptor;

    @Nested
    class createUser{

        @Test
        @DisplayName("Should create a user succes")

        void should() {

            //Arange
            var user = new User(
                    UUID.randomUUID(),
                    "username",
                    "email@email.com",
                    "password",
                    Instant.now(),
                    null
            );
            doThrow(new RuntimeException()).when(userRepository).save(userArgumentCaptor.capture());
            var input = new CreateUserDto(
                    "username",
                    "email@email.com",
                    "123"
            );

            var output = userService.createUser(input);
            //Act
            assertNull(output);
            var userCapture = userArgumentCaptor.getValue();
            assertEquals(input.username(), userCapture.getUsername());
            assertEquals(input.email(), userCapture.getEmail());
            assertEquals(input.password(), userCapture.getPassword());
        }
    }

}//