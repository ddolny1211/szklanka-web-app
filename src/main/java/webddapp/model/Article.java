package webddapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String articleTitle;
    @NotEmpty
    private String articleContent;
    @NotEmpty
    private String author;
    private LocalDateTime creationTime;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Comment commentsList;

    public Article(){
        this.creationTime= LocalDateTime.now();
    }

    public Article(String articleTitle, String articleContent, String author) {
        this.articleTitle = articleTitle;
        this.articleContent = articleContent;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCreationTime() {
        return creationTime.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public Comment getCommentsList() {
        return commentsList;
    }

    //    public List<Comment> getCommentsList() {
//        return commentsList;
//    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }
}
