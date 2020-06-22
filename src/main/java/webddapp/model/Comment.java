package webddapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String commentAuthor;
    @NotEmpty
    private String commentContent;
    private LocalDateTime commentCreationTime;

    public Comment(){
        this.commentCreationTime = LocalDateTime.now();
    }

    public Comment(@NotEmpty String commentAuthor, @NotEmpty String commentContent, LocalDateTime commentCreationTime) {
        this.commentAuthor = commentAuthor;
        this.commentContent = commentContent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentAuthor() {
        return commentAuthor;
    }

    public void setCommentAuthor(String commentAuthor) {
        this.commentAuthor = commentAuthor;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getCommentCreationTime() {
        return commentCreationTime.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public void setCommentCreationTime(LocalDateTime commentCreationTime) {
        this.commentCreationTime = commentCreationTime;
    }
}
