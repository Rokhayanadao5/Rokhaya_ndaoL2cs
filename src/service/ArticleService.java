package service;

import entity.Article;
import java.util.ArrayList;
import java.util.List;

public class ArticleService {

    public List<Article> initialiserArticles() {
        List<Article> articles = new ArrayList<>();
        articles.add(new Article(1, "Stylo"));
        articles.add(new Article(2, "Cahier"));
        articles.add(new Article(3, "Livre"));
        // Ajoute d'autres articles si besoin
        return articles;
    }
}
