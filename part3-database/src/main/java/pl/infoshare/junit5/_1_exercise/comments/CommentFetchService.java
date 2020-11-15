package pl.infoshare.junit5._1_exercise.comments;

import org.springframework.stereotype.Component;
import pl.infoshare.junit5._1_exercise.EntityNotFoundException;
import pl.infoshare.junit5._1_exercise.comments.domain.Comment;
import pl.infoshare.junit5._1_exercise.comments.domain.CommentRepository;
import pl.infoshare.junit5._1_exercise.notes.domain.NoteRepository;

import java.util.List;

@Component
public class CommentFetchService {

    private final NoteRepository noteRepository;
    private final CommentRepository commentRepository;

    public CommentFetchService(NoteRepository noteRepository, CommentRepository commentRepository) {
        this.noteRepository = noteRepository;
        this.commentRepository = commentRepository;
    }

    public List<Comment> fetchComments(Integer noteId) {
        return noteRepository.findById(noteId)
                .map(commentRepository::findAllByNote)
                .orElseThrow(EntityNotFoundException::new);
    }

}
