package pl.infoshare.junit5._1_exercise.notes;

import org.springframework.stereotype.Component;
import pl.infoshare.junit5._1_exercise.notes.domain.NoteRepository;

@Component
public class NoteDeleteService {

    private final NoteRepository noteRepository;

    public NoteDeleteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public void deleteNote(Integer id) {
        noteRepository.deleteById(id);
    }
}
