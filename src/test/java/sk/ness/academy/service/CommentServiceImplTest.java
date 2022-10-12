package sk.ness.academy.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import sk.ness.academy.dao.ArticleDAO;
import sk.ness.academy.dao.AuthorDAO;
import sk.ness.academy.dao.CommentDAO;
import sk.ness.academy.domain.Article;
import sk.ness.academy.domain.Comment;
import sk.ness.academy.dto.Author;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CommentServiceImplTest {

    private List<Comment> comments;
    @InjectMocks
    private CommentServiceImpl commentService;
    @Mock
    private CommentDAO commentDAO;

    @Test
    public void contextLoadsComment() throws Exception {
        assertThat(comments).isNotNull();
    }

    @Test
    public void contextLoadsCommentServiceImpl() throws Exception {
        assertThat(commentService).isNotNull();
    }

    @Test
    public void contextLoadsCommentDAO() throws Exception {
        assertThat(commentDAO).isNotNull();
    }


    @Test
    void findByID() {
        final Integer id = 10;
        Mockito.when(commentDAO.findByID(id)).thenReturn(comments.get(0));
        final Comment articleDAOS = commentService.findByID(id);
        assertEquals(10, articleDAOS.getId());
    }

    @Test
    void findAll() {
        Mockito.when(commentService.findAll()).thenReturn(comments);

        final List<Comment> articleDAOS = commentService.findAll();

        assertEquals(2, articleDAOS.size());
        assertEquals("Michal", articleDAOS.get(0).getAuthor());
        assertEquals("Martin", articleDAOS.get(1).getAuthor());
    }

    @Test
    void createComment() {
    }

    @Test
    void deleteComment() {
    }

    @BeforeEach
    private void init() {
        final Comment comment1 = new Comment();
        comment1.setAuthor("Michal");
        comment1.setId(10);


        final Comment comment2 = new Comment();
        comment2.setAuthor("Martin");
        comment2.setId(11);

        comments = new ArrayList<>();
        comments.add(comment1);
        comments.add(comment2);

    }
}