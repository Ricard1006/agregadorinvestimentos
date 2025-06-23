package tech.buildrun.agregadorinvestimentos.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tech.buildrun.agregadorinvestimentos.repository.UserRepository;
import tech.buildrun.agregadorinvestimentos.service.UserService;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class UserControllerTest {


    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Nested
    class createUser{
        @Test
        @DisplayName("Should create a user succes")
        void should() {
        }
    }

}