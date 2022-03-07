package learn.foraging.domain;

import learn.foraging.data.DataException;
import learn.foraging.data.ForageRepositoryDouble;
import learn.foraging.data.ForagerRepositoryDouble;
import learn.foraging.data.ItemRepositoryDouble;
import learn.foraging.models.Category;
import learn.foraging.models.Forage;
import learn.foraging.models.Forager;
import learn.foraging.models.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ForageServiceTest {


    ForageService service;

    @BeforeEach
    void setup() {
        service = new ForageService(
                new ForageRepositoryDouble(),
                new ForagerRepositoryDouble(),
                new ItemRepositoryDouble());
    }

    @Test
    void shouldAdd() throws DataException {
        Forage forage = new Forage();
        LocalDate date = LocalDate.now();
        forage.setDate(date);
        forage.setForager(ForagerRepositoryDouble.FORAGER);
        forage.setItem(ItemRepositoryDouble.ITEM);
        forage.setKilograms(0.5);

        Result<Forage> result = service.add(forage);
        assertTrue(result.isSuccess());
        assertNotNull(result.getPayload());
        assertEquals(36, result.getPayload().getId().length());
        assertEquals(1, service.findByDate(date).size());
    }

    @Test
    void shouldUpdateExistingForage() throws DataException {
        LocalDate date = LocalDate.of(2022, 01, 01);
        Forage forage = new Forage();
        forage.setDate(date);
        forage.setForager(ForagerRepositoryDouble.FORAGER);
        forage.setItem(ItemRepositoryDouble.ITEM);
        forage.setKilograms(0.5);

        List<Forage> forages = service.findByDate(date);
        assertEquals(0, forages.size());

        Result<Forage> result = service.add(forage);
        forages = service.findByDate(date);
        assertEquals(1, forages.size());
        assertEquals(0.5, forages.get(0).getKilograms());

        forage.setKilograms(1);
        result = service.add(forage);
        forages = service.findByDate(date);
        assertEquals(1, forages.size());
        assertEquals(1, forages.get(0).getKilograms());

        assertTrue(result.isSuccess());
        assertNotNull(result.getPayload());
        assertEquals(1, result.getPayload().getKilograms());
    }

    @Test
    void shouldNotAddWhenForagerNotFound() throws DataException {

        Forager forager = new Forager();
        forager.setId("30816379-188d-4552-913f-9a48405e8c08");
        forager.setFirstName("Ermengarde");
        forager.setLastName("Sansom");
        forager.setState("NM");

        Forage forage = new Forage();
        forage.setDate(LocalDate.now());
        forage.setForager(forager);
        forage.setItem(ItemRepositoryDouble.ITEM);
        forage.setKilograms(0.5);

        Result<Forage> result = service.add(forage);
        assertFalse(result.isSuccess());
    }

    @Test
    void shouldNotAddWhenItemNotFound() throws DataException {

        Item item = new Item(11, "Dandelion", Category.EDIBLE, new BigDecimal("0.05"));

        Forage forage = new Forage();
        forage.setDate(LocalDate.now());
        forage.setForager(ForagerRepositoryDouble.FORAGER);
        forage.setItem(item);
        forage.setKilograms(0.5);

        Result<Forage> result = service.add(forage);
        assertFalse(result.isSuccess());
    }


}