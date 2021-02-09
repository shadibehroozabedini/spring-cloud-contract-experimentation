package be.ordina.shbe.carfactoryjava;


import be.ordina.shbe.carfactoryjava.controller.ProducerController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = CarfactoryjavaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class ContractVerifierBase {

    @Autowired
    private ProducerController controller;

    @BeforeEach
    public void setUp() {
        StandaloneMockMvcBuilder standaloneMockMvcBuilder
                = MockMvcBuilders.standaloneSetup(controller);
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
    }
}
