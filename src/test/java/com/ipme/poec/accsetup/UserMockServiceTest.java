package com.ipme.poec.accsetup;

import com.ipme.poec.accsetup.model.User;
import com.ipme.poec.accsetup.repository.UserRepository;
import com.ipme.poec.accsetup.service.UserService;
import com.ipme.poec.accsetup.service.dto.UserDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@Transactional
class UserMockServiceTest {


    @Autowired
    UserService userService;

    @Mock
    private UserRepository mockUserRepository;

    @BeforeEach
    void beforeEach() {
        this.userService.deleteAllUsers();
    }

    @AfterEach
    void afterEach() {
    }


    @Test
    void getUserTest() {
        userService.createUser("mockName", "mockPassword");
        userService.createUser("mockName2", "mockPassword2");
        userService.createUser("mockName3", "mockPassword3");

        List<User> users = userService.findAll();

        when(mockUserRepository.findAll()).thenReturn(users);
        List<UserDTO> usersDTO = userService.convertUsersToDTO(users);

        assertEquals(users.size(), usersDTO.size());
        UserDTO userDTO = usersDTO.get(1);
        assertNotNull(userDTO.getName());
        System.out.println(usersDTO);
    }
}
