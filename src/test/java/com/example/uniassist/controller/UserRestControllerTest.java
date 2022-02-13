package com.example.uniassist.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.example.uniassist.model.User;
import com.example.uniassist.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author ragcrix
 */
@RunWith(SpringRunner.class)
@WebMvcTest
public class UserRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    private ObjectMapper objectMapper = new ObjectMapper();

    private User ragcrix;
    private User yigit;

    private final Long ragcrixUserNumber = 23L;
    private final Long yigitUserNumber = 91L;

    @Before
    public void setup() {
        ragcrix = new User();
        ragcrix.setUserName("aBc123");
        ragcrix.setName("ragcrix");
        ragcrix.setEmail("ragcrix@rg.com");
        ragcrix.setUserNumber(ragcrixUserNumber);
        ragcrix.setCourseList(Arrays.asList("Math", "Science"));


        yigit = new User();
        yigit.setUserName("dEf345");
        yigit.setName("yigit");
        yigit.setEmail("yigit@ygt.com");
        yigit.setUserNumber(yigitUserNumber);
        yigit.setCourseList(Arrays.asList("Turkish", "German"));

    }

    @Test
    public void givenUsers_whenGetAllUsers_thenReturnJsonArray() throws Exception {
        given(userService.findAll()).willReturn(Arrays.asList(ragcrix));

        mvc.perform(get("/students/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(ragcrix.getName())));
    }

    @Test
    public void givenUser_whenFindByUserNumber_thenReturnJsonArray() throws Exception {
        given(userService.findByUserNumber(ragcrixUserNumber)).willReturn(ragcrix);

        mvc.perform(get("/students/byUserNumber/{studentNumber}", ragcrixUserNumber)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(ragcrix.getName())));
    }



    @Test
    public void saveUser_itShouldReturnStatusOk() throws Exception {
        given(userService.saveOrUpdateUser(any(User.class))).willReturn(yigit);

        String jsonString = objectMapper.writeValueAsString(yigit);

        mvc.perform(post("/students/save/")
                .contentType(MediaType.APPLICATION_JSON).content(jsonString))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteUserByUserNumber_itShouldReturnStatusOk() throws Exception {
        given(userService.findByUserNumber(ragcrixUserNumber)).willReturn(ragcrix);
        Mockito.doNothing().when(userService).deleteUserById(any(String.class));

        mvc.perform(delete("/students/delete/{studentNumber}", ragcrixUserNumber)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
