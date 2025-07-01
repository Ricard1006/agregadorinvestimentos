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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Captor
    private ArgumentCaptor<User> userArgumentCaptor;

    @Nested
    class CreateUser {

        @Test
        @DisplayName("Deve criar um usuário com sucesso")
        void shouldCreateUserSuccessfully() {
            // Arrange
            var input = new CreateUserDto(
                    "username",
                    "email@email.com",
                    "123"
            );

            // Simula o retorno esperado do repositório
            var savedUser = new User(
                    UUID.randomUUID(),
                    input.username(),
                    input.email(),
                    input.password(),
                    Instant.now(),
                    null
            );

            when(userRepository.save(any(User.class))).thenReturn(savedUser);

            // Act
            var output = userService.createUser(input);

            // Assert
            assertNotNull(output);
            verify(userRepository).save(userArgumentCaptor.capture());
            var capturedUser = userArgumentCaptor.getValue();
            assertEquals(input.username(), capturedUser.getUsername());
            assertEquals(input.email(), capturedUser.getEmail());
            assertEquals(input.password(), capturedUser.getPassword());
        }
    }
}