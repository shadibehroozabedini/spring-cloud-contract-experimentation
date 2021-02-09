package be.ordina.cardealer.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@AutoConfigureStubRunner(
        stubsMode = StubRunnerProperties.StubsMode.LOCAL,
        ids = {"be.ordina.shbe:carfactoryjava:+:stubs:8085","be.ordina.shbe:carfactory:+:stubs:8080"})
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void givenOrder_whenQuantityIsLessThanMinimumRequired_thenOrderIsRefused() throws Exception {
        this.mockMvc.perform(get("/orders/?quantity=20")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andDo(print())
                .andExpect(content().string("refused"));
    }

    @Test
    void givenOrder_whenQuantityIsGreaterThanMinimumRequired_thenOrderIsAccepted() throws Exception {
        this.mockMvc.perform(get("/orders/?quantity=1000")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andDo(print())
                .andExpect(content().string("accepted"));
    }
}
