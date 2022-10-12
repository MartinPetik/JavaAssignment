package sk.ness.academy.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import sk.ness.academy.dao.ArticleDAO;
import sk.ness.academy.domain.Article;
import sk.ness.academy.service.ArticleService;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BlogControllerTest {

    @InjectMocks
    BlogController blogController;

    @Mock
    ArticleDAO articleDAO;
    @Mock
    ArticleService articleService;

    private List<Article> articles;

    @Test
    void getAllArticles() {
//        Mockito.when(articleService.findAll()).thenReturn(articles);
//
//        List<Article> result = blogController.getAllArticles();
//
//        assertEquals(2, result.size());

    }

    @Test
    void getArticle() {
    }

    @Test
    void deleteArticle() {
    }

    @Test
    void searchArticle() {
    }

    @Test
    void addArticle() {
    }

    @Test
    void getAllAuthors() {
    }

    @Test
    void authorStats() {
    }

    @Test
    void addComment() {
    }

    @Test
    void deleteComment() {
    }

    @Test
    void getAllComment() {
    }

    @BeforeEach
    private void init() {
        final Article article1 = new Article();
        article1.setAuthor("Michal");
        article1.setId(10);
        article1.setTitle("Extending the Stream API to Maps");
        article1.setText("One of the bigest features in Java 8");


        final Article article2 = new Article();
        article2.setAuthor("Martin");
        article2.setId(11);
        article2.setTitle("One Small Error in Java Code");
        article2.setText("In this series of posts I am covering some");

//        articles = new ArrayList<>();
//        articles.add(article1);
//        articles.add(article2);

    }

}