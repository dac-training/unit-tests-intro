package pl.infoshare.junit5._13_exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Optional;


/**
 * Ćwiczenie 12. Napisz test jednostkowy, który dostarczy tymczasowy plik do repozytorium.
 */
public class PatientFileRepository {

    private final Path savePath;

    public PatientFileRepository(Path savePath) {
        this.savePath = savePath;
    }

    public void save(Patient patient) throws IOException {
        Files.write(savePath, patient.asString().getBytes(), StandardOpenOption.APPEND);
    }

    public Optional<Patient> findById(Integer id) throws IOException {
        return Files.lines(savePath)
                .map(Patient::fromString)
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }
}
