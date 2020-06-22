package webddapp.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webddapp.model.Article;


@Repository
public interface ArticleDataRepository extends JpaRepository<Article, Long> {

}
