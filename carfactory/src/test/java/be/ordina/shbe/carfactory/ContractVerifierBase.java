package be.ordina.shbe.carfactory;

import be.ordina.shbe.carfactory.controller.OrderController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

@ExtendWith(MockitoExtension.class)//(SpringExtension.class) //instead of run with
@SpringBootTest(classes = CarfactoryApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class ContractVerifierBase {

    @Autowired
    private OrderController controller;

    @BeforeEach
    public void setUp() {
       /* DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(context);
        RestAssuredMockMvc.standaloneSetup(builder);*/
        StandaloneMockMvcBuilder standaloneMockMvcBuilder
                = MockMvcBuilders.standaloneSetup(controller);
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
    }
}
