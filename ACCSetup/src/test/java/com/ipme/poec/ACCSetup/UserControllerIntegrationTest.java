package com.ipme.poec.ACCSetup;

import com.ipme.poec.ACCSetup.Controller.UserController;
import com.ipme.poec.ACCSetup.Repository.UserRepository;
import com.ipme.poec.ACCSetup.Service.UserService;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenPostRequestToUsersAndValidUser_thenCorrectResponse() throws Exception { //test d'utilisateur valide
        MediaType textPlainUtf8 = new MediaType(MediaType.TEXT_PLAIN, StandardCharsets.UTF_8);
        String user = "{\"userName\": \"Patrick Balkany\", \"userPassword\" : \"Le Magnifique\"}"; //on tente d'entrer un faux utilisateur valide
        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                        .content(user)                                              //On tente l'injection du faux utilisateur
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())                   //on attend que l'utilisateur soit valide
                .andExpect(MockMvcResultMatchers.content()                          //on attend du test que le résultat contienne les données du faux utilisateur qu'on charge via le test
                        .contentType(textPlainUtf8));
    }

    @Test
    public void whenPostRequestToUsersAndInValidUser_thenCorrectResponse() throws Exception { //test d'utilisateur invalide
        String user = "{\"userName\": \"\", \"userPassword\" : \"Labitenbois\"}";   //on tente d'entrer un faux utilisateur invalide, puisque le nom est vide
        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                        .content(user)                                              //On tente l'injection du faux utilisateur
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())           //On attend que la requête d'injection plante
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Is.is("Name is mandatory")))    //Et qu'il nous renvoie le message d'erreur prévu dans le modèle
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8));
    }

}
