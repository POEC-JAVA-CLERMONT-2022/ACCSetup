package com.ipme.poec.ACCSetup;

import com.ipme.poec.ACCSetup.Model.User;
import com.ipme.poec.ACCSetup.Repository.UserRepository;
import com.ipme.poec.ACCSetup.Service.UserService;
import com.ipme.poec.ACCSetup.Service.dto.user.UserDTO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@Transactional
public class UserMockServiceTest {


    @InjectMocks
    UserService userService;

    @Mock
    private UserRepository mockUserRepository;

    void beforeEach() {
        this.userService.deleteAllUsers();
    }

    @AfterEach
    void afterEach() {
    }


//    @Test
//    void getUserTest() {
//        userService.createUser("mockName", "mockPassword");
//        userService.createUser("mockName2", "mockPassword2");
//        userService.createUser("mockName3", "mockPassword3");
//
//        List<User> users = userService.findAll();
//
//        when(mockUserRepository.findAll()).thenReturn(users);
//        List<UserDTO> usersDTO = userService.convertUsersToDTO(users);
//
//        assertEquals(users.size(), usersDTO.size());
//        UserDTO userDTO = usersDTO.get(1);
//        assertNotNull(userDTO.getName());
//
//    }
}
