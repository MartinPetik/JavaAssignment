package sk.ness.academy.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sk.ness.academy.domain.Article;
import sk.ness.academy.domain.Comment;
import sk.ness.academy.dto.Author;
import sk.ness.academy.dto.AuthorStats;
import sk.ness.academy.exception.ApiRequestException;
import sk.ness.academy.service.ArticleService;
import sk.ness.academy.service.AuthorService;
import sk.ness.academy.service.CommentService;

@RestController
public class BlogController {

  @Resource
  private ArticleService articleService;

  @Resource
  private AuthorService authorService;

  @Resource
  private CommentService commentService;

  // ~~ Article
  @RequestMapping(value = "articles", method = RequestMethod.GET)
  public List<Article> getAllArticles() {
	  return this.articleService.findAll();
  }

  @RequestMapping(value = "articles/{articleId}", method = RequestMethod.GET)
  public Article getArticle(@PathVariable final Integer articleId) {
	  Article A = this.articleService.findByID(articleId);
      if (A == null) {
        throw new ApiRequestException("Article with ID: " + articleId + " does not exist");
      } else return this.articleService.findByID(articleId);
  }

  @RequestMapping(value = "articles/{articleId}", method = RequestMethod.DELETE)
  public void deleteArticle(@PathVariable final Integer articleId) {
    Article A = this.articleService.findByID(articleId);
    if (A == null) {
      throw new ApiRequestException("Article with ID: " + articleId + " does not exist");
    } else this.articleService.deleteArticle(articleId);
  }

  @RequestMapping(value = "articles/search/{searchText}", method = RequestMethod.GET)
  public List<Article> searchArticle(@PathVariable final String searchText) {
      return this.articleService.search(searchText);
	  //throw new UnsupportedOperationException("Full text search not implemented.");
  }

  @RequestMapping(value = "articles", method = RequestMethod.PUT)
  public void addArticle(@RequestBody final Article article) {
	  this.articleService.createArticle(article);
  }

  // ~~ Author
  @RequestMapping(value = "authors", method = RequestMethod.GET)
  public List<Author> getAllAuthors() {
	  return this.authorService.findAll();
  }

  @RequestMapping(value = "authors/stats", method = RequestMethod.GET)
  public List<AuthorStats> authorStats() {
    return this.authorService.stats();
  }

   // Comment
  @RequestMapping(value = "articles/{articleId}/comment", method = RequestMethod.PUT)
  public void addComment(@PathVariable final Integer articleId,@RequestBody final Comment comment) {
    Article A = this.articleService.findByID(articleId);
    if (A == null) {
      throw new ApiRequestException("Comment with ID: " + articleId + " does not exist");
    } else this.commentService.createComment(comment,articleId);
    //throw new UnsupportedOperationException("Comments are not implemented.");
  }

  @RequestMapping(value = "comment/{commentId}", method = RequestMethod.DELETE)
  public void deleteComment(@PathVariable final Integer commentId) {
    Comment A = this.commentService.findByID(commentId);
    if (A == null) {
      throw new ApiRequestException("Comment with ID: " + commentId + " does not exist");
    } else this.commentService.deleteComment(commentId);
   // throw new UnsupportedOperationException("Comments are not implemented.");
  }
  @RequestMapping(value = "comment", method = RequestMethod.GET)
  public List<Comment> getAllComment() {
    return this.commentService.findAll();
  }
}
