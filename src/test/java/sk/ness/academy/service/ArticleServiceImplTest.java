package sk.ness.academy.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import sk.ness.academy.dao.ArticleDAO;
import sk.ness.academy.domain.Article;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
class ArticleServiceImplTest {

    private List<Article> articles;
    @InjectMocks
    private ArticleServiceImpl articleService;
    @Mock
    private ArticleDAO articleHibernateDAO;

    @Test
    public void contextLoadsArticle() throws Exception {
        assertThat(articles).isNotNull();
    }

    @Test
    public void contextLoadsArticleServiceImpl() throws Exception {
        assertThat(articleService).isNotNull();
    }

    @Test
    public void contextLoadsArticleDAO() throws Exception {
        assertThat(articleHibernateDAO).isNotNull();
    }


    @Test
    void findByID() {
        final Integer id = 10;
        Mockito.when(articleHibernateDAO.findByID(id)).thenReturn(articles.get(0));
        final Article articleDAOS = articleService.findByID(id);
        assertEquals(10, articleDAOS.getId());
    }

    @Test
    void findAll() {
        Mockito.when(articleService.findAll()).thenReturn(articles);

        final List<Article> articleDAOS = articleService.findAll();

        assertEquals(2, articleDAOS.size());
        assertEquals("Michal", articleDAOS.get(0).getAuthor());
        assertEquals("Martin", articleDAOS.get(1).getAuthor());
    }

    @Test
    void createArticle() {
        //Mockito.when(articleHibernateDAO.persist(articles.)).thenReturn(articles.get(0));

    }

    @Test
    void ingestArticles() {
    }

    @Test
    void deleteArticle() {
    }

    @Test
    void search() {
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

        articles = new ArrayList<>();
        articles.add(article1);
        articles.add(article2);

    }

}