package com.example.uniassist.service;


import com.example.uniassist.service.impl.UserServiceImpl;
import com.example.uniassist.model.User;
import com.example.uniassist.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author ragcrix
 */
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @TestConfiguration
    static class StudentServiceImplTestContextConfiguration {
        @Bean
        public UserService userService() {
            return new UserServiceImpl();
        }
    }

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    private User ragcrix;
    private User yigit;

    private final Long ragcrixUserNumber = 23L;
    private final Long yigitUserNumber = 91L;
    private final String ragcrixEmail = "ragcrix@rg.com";
    private final String yigitEmail = "yigit@ygt.com";
    private final List<User> users = new ArrayList<>();

    @Before
    public void setup() {
        ragcrix = new User();
        ragcrix.setUserName("aBc123");
        ragcrix.setName("ragcrix");
        ragcrix.setEmail(ragcrixEmail);
        ragcrix.setUserNumber(ragcrixUserNumber);
        ragcrix.setCourseList(Arrays.asList("Math", "Science"));


        yigit = new User();
        yigit.setUserName("dEf345");
        yigit.setName("yigit");
        yigit.setEmail(yigitEmail);
        yigit.setUserNumber(yigitUserNumber);
        yigit.setCourseList(Arrays.asList("Turkish", "German"));


        users.add(ragcrix);
        users.add(yigit);

        Mockito.when(userRepository.findAll()).thenReturn(users);

        Mockito.when(userRepository.findByUserNumber(ragcrixUserNumber))
                .thenReturn(ragcrix);

        Mockito.when(userRepository.findByEmail(yigitEmail))
                .thenReturn(yigit);


        Mockito.when(userRepository.save(ragcrix)).thenReturn(ragcrix);
    }

    @Test
    public void testFindAll_thenUserListShouldBeReturned() {
        List<User> foundUsers = userService.findAll();

        assertNotNull(foundUsers);
        assertEquals(2, foundUsers.size());
    }

    @Test
    public void testFindByUserNumber23_thenRagcrixShouldBeReturned() {
        User found = userService.findByUserNumber(ragcrixUserNumber);

        assertNotNull(found);
        assertEquals(ragcrix.getName(), found.getName());
        assertEquals(ragcrix.getUserName(), found.getUserName());
    }

    @Test
    public void testFindByEmail_thenYigitShouldBeReturned() {
        User found = userService.findByEmail(yigitEmail);

        assertNotNull(found);
        assertEquals(yigit.getName(), found.getName());
        assertEquals(yigit.getUserName(), found.getUserName());
    }



    @Test
    public void testSaveOrUpdateUser_thenUserShouldBeReturned() {
        User found = userService.saveOrUpdateUser(ragcrix);

        assertNotNull(found);
        assertEquals(ragcrix.getName(), found.getName());
        assertEquals(ragcrix.getUserName(), found.getUserName());
    }

    @Test
    public void testDeleteUserById() {
        userService.deleteUserById(ragcrix.getUserName());

        Mockito.verify(userRepository, Mockito.times(1))
                .deleteById(ragcrix.getUserName());
    }

}
