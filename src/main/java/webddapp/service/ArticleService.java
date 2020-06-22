package webddapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webddapp.data.ArticleDataRepository;
import webddapp.model.Article;
import java.util.Collections;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleDataRepository articleDataRepository;

    public List<Article> getNewestPostes() {
        List<Article> allArticles = articleDataRepository.findAll();
        Collections.reverse(allArticles);
        return allArticles;
    }

    public void saveArticle(Article article) {
        articleDataRepository.save(article);
    }
}
