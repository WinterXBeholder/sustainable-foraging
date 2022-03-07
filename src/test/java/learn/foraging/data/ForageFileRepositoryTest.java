package learn.foraging.data;

import learn.foraging.domain.Result;
import learn.foraging.models.Forage;
import learn.foraging.models.Forager;
import learn.foraging.models.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ForageFileRepositoryTest {

    static final String SEED_FILE_PATH = "./data/forage-seed-2020-06-26.csv";
    static final String TEST_FILE_PATH = "./data/forage_data_test/2020-06-26.csv";
    static final String TEST_DIR_PATH = "./data/forage_data_test";
    static final int FORAGE_COUNT = 54;

    final LocalDate date = LocalDate.of(2020, 6, 26);

    ForageFileRepository repository;

    @BeforeEach
    void setup() throws IOException {
        Path seedPath = Paths.get(SEED_FILE_PATH);
        Path testPath = Paths.get(TEST_FILE_PATH);
        Files.copy(seedPath, testPath, StandardCopyOption.REPLACE_EXISTING);
        repository = new ForageFileRepository(TEST_DIR_PATH);
    }

    @Test
    void shouldFindByDate() {
        List<Forage> forages = repository.findByDate(date);
        assertEquals(FORAGE_COUNT, forages.size());
    }

    @Test
    void shouldAdd() throws DataException {
        Forage forage = new Forage();
        forage.setDate(date);
        forage.setKilograms(0.75);

        Item item = new Item();
        item.setId(12);
        forage.setItem(item);

        Forager forager = new Forager();
        forager.setId("AAAA-1111-2222-FFFF");
        forage.setForager(forager);

        forage = repository.add(forage);

        assertEquals(36, forage.getId().length());
    }

    @Test
    void shouldUpdate() throws DataException, IOException {
        Path newSeedPath = Paths.get("./data/forage-update-seed-2022-01-01.csv");
        Path newTestPath = Paths.get("./data/forage_data_test/2022-01-01.csv");
        Files.copy(newSeedPath, newTestPath, StandardCopyOption.REPLACE_EXISTING);


        LocalDate newDate = LocalDate.of(2022, 01, 01);
        Forage forage = new Forage();
        forage.setDate(newDate);
        forage.setForager(ForagerRepositoryDouble.FORAGER);
        forage.setItem(ItemRepositoryDouble.ITEM);
        forage.setKilograms(0.5);

        List<Forage> forages = repository.findByDate(newDate);
        assertEquals(0, forages.size());

        Forage result1 = repository.add(forage);
        assertEquals(0.5, result1.getKilograms());
        forages = repository.findByDate(newDate);
        assertEquals(1, forages.size());

        forage.setKilograms(1);
        Boolean result2 = repository.update(forage);
        forages = repository.findByDate(newDate);
        assertEquals(1, forages.size());
        assertTrue(result2);
        assertEquals(1, forage.getKilograms());
        assertEquals(1, forages.get(0).getKilograms());

        boolean result = repository.update(forage);


    }


}






























