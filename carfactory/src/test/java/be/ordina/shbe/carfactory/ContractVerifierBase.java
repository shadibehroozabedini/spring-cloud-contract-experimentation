package be.ordina.shbe.carfactory;

import be.ordina.shbe.carfactory.controller.OrderController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(MockitoExtension.class)//(SpringExtension.class) //instead of run with
@SpringBootTest(classes = CarfactoryApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class ContractVerifierBase {

    @Autowired
    private WebApplicationContext context;

    @MockBean
    private OrderController controller;

    @Test
    public void contextLoads() {
    }

    @BeforeEach
    public void setUp() {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(context);
        RestAssuredMockMvc.standaloneSetup(builder);
        //Mockito.when(controller.processOrder()).thenReturn("");
    }
}
