package learn.foraging.data;

import learn.foraging.models.Forager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ForagerFileRepositoryTest {

    static final String SEED_FILE_PATH = "./data/foragers-seed.csv";
    static final String TEST_FILE_PATH = "./data/forage_data_test/foragers-test.csv";
    static final int FORAGERS_COUNT = 1000;

    private ForagerFileRepository repo;

    @BeforeEach
    void setup() throws IOException {
        Path seedPath = Paths.get(SEED_FILE_PATH);
        Path testPath = Paths.get(TEST_FILE_PATH);
        Files.copy(seedPath, testPath, StandardCopyOption.REPLACE_EXISTING);
        repo = new ForagerFileRepository(TEST_FILE_PATH);
    }

    @Test
    void shouldAddOne() throws DataException {
        Forager forager = ForagerRepositoryDouble.FORAGER;
        repo.add(forager);
        List<Forager> all = repo.findAll();
        assertEquals(FORAGERS_COUNT+1, all.size());
    }

    @Test
    void shouldFindOriginalSize() {
        List<Forager> all = repo.findAll();
        assertEquals(FORAGERS_COUNT, all.size());
    }
}