package pl.infoshare.junit5._1_exercise.comments;

import org.springframework.stereotype.Component;
import pl.infoshare.junit5._1_exercise.EntityNotFoundException;
import pl.infoshare.junit5._1_exercise.comments.domain.Comment;
import pl.infoshare.junit5._1_exercise.comments.domain.CommentRepository;
import pl.infoshare.junit5._1_exercise.model.CommentCreateRequest;
import pl.infoshare.junit5._1_exercise.notes.domain.NoteRepository;

@Component
public class CommentCreateService {

    private final NoteRepository noteRepository;
    private final CommentRepository commentRepository;

    public CommentCreateService(NoteRepository noteRepository, CommentRepository commentRepository) {
        this.noteRepository = noteRepository;
        this.commentRepository = commentRepository;
    }

    public Comment createComment(Integer noteId, CommentCreateRequest commentCreateRequest) {
        var note = noteRepository.findById(noteId).orElseThrow(EntityNotFoundException::new);

        var newComment = new Comment();
        newComment.setNote(note);
        newComment.setValue(commentCreateRequest.getValue());

        return commentRepository.save(newComment);
    }
}
