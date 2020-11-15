package pl.infoshare.junit5._1_exercise.notes;

import org.springframework.stereotype.Component;
import pl.infoshare.junit5._1_exercise.EntityNotFoundException;
import pl.infoshare.junit5._1_exercise.notes.domain.Note;
import pl.infoshare.junit5._1_exercise.notes.domain.NoteRepository;

import java.util.List;
import java.util.Objects;

@Component
public class NoteFetchService {

    private final NoteRepository noteRepository;

    public NoteFetchService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> fetchNotes(List<String> tags) {
        if (Objects.isNull(tags) || tags.isEmpty()) {
            return noteRepository.findAll();
        }

        return noteRepository.findAllByTags(tags);

    }

    public Note fetch(Integer id) {
        return noteRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}
