package com.example.entrevueSpringBoot;

import com.tbuglc.film.entity.Acteur;
import com.tbuglc.film.exception.BadRequest;
import com.tbuglc.film.repository.ActeurRepository;
import com.tbuglc.film.service.ActeurService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RunWith(SpringRunner.class)
@SpringBootTest
class ActeurServiceUnitTest {

    private List<Acteur> acteurs;
    private String acteurNom = "Mocked";
    private Acteur mockedActeur = new Acteur((long) 1, acteurNom, "Acteur");
    @Autowired
    private ActeurService acteurService;

    @SpyBean
    private ActeurRepository acteurRepository;


    @BeforeEach
    void setUp() {

        acteurs = Arrays.asList(new Acteur(acteurNom, "Mocked"));
        Mockito.clearInvocations(acteurRepository);
    }

    @AfterEach
    void cleanUp() {
        Mockito.clearInvocations(acteurRepository);
    }

    @Test
    void doNotDuplicateActeur() {
        Mockito.when(acteurRepository.findByNom(acteurNom)).thenReturn(mockedActeur);

        List<Acteur> myActeurs = acteurService.addFilmActeur(acteurs);

        assertThat(myActeurs.size()).isGreaterThan(0);
        assertThat(myActeurs.get(0).getId()).isEqualTo(1);
        assertThat(myActeurs.get(0).getNom()).isEqualTo(acteurNom);

    }

    @Test
    void saveNewActeur() {

        Mockito.when(acteurRepository.save(mockedActeur)).thenReturn(mockedActeur);

        List<Acteur> myActeurs = acteurService.addFilmActeur(Arrays.asList(new Acteur((long) 2, "Some", "Random")));

        assertThat(myActeurs.size()).isGreaterThan(0);
        assertThat(myActeurs.get(0).getId()).isEqualTo(2);
        assertThat(myActeurs.get(0).getNom()).isEqualTo("Some");
        assertThat(myActeurs.get(0).getPrenom()).isEqualTo("Random");
    }

    @Test
    void saveNewActeurError() throws BadRequest {

        assertThatThrownBy(() -> {
            acteurService.addFilmActeur(null);
        }).hasMessage("Acteurs should not be null");

    }
}