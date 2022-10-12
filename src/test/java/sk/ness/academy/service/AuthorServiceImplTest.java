package sk.ness.academy.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import sk.ness.academy.dao.ArticleDAO;
import sk.ness.academy.dao.AuthorDAO;
import sk.ness.academy.domain.Article;
import sk.ness.academy.dto.Author;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AuthorServiceImplTest {

    private List<Author> articles;
    @InjectMocks
    private AuthorServiceImpl authorService;
    @Mock
    private AuthorDAO authorDAO;

    @Test
    public void contextLoadsArticle() throws Exception {
        assertThat(articles).isNotNull();
    }

    @Test
    public void contextLoadsAuthorServiceImpl() throws Exception {
        assertThat(authorService).isNotNull();
    }

    @Test
    public void contextLoadsAuthorDAO() throws Exception {
        assertThat(authorDAO).isNotNull();
    }

    @Test
    void findAll() {
        Mockito.when(authorService.findAll()).thenReturn(articles);

        final List<Author> articleDAOS = authorDAO.findAll();

        assertEquals(2, articleDAOS.size());
        assertEquals("Michal", articleDAOS.get(0).getName());
        assertEquals("Martin", articleDAOS.get(1).getName());
    }

    @BeforeEach
    private void init() {
        final Author article1 = new Author();
        article1.setName("Michal");


        final Author article2 = new Author();
        article2.setName("Martin");

        articles = new ArrayList<>();
        articles.add(article1);
        articles.add(article2);

    }
}