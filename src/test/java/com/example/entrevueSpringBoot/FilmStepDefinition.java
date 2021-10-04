package com.example.entrevueSpringBoot;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FilmStepDefinition {
    @Given("New Film")
    public void newFilm() {
        //TODO: Provide implementation
    }

    @When("Post new film")
    public void postNewFilm() {
        //TODO: Provide implementation
    }

    @Then("I should save film with actors")
    public void iShouldSaveFilmWithActors() {
        //TODO: Provide implementation
    }
}
