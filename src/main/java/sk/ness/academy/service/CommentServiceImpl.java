package sk.ness.academy.service;

import org.springframework.stereotype.Service;
import sk.ness.academy.dao.ArticleDAO;
import sk.ness.academy.dao.CommentDAO;
import sk.ness.academy.domain.Article;
import sk.ness.academy.domain.Comment;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

  @Resource
  private CommentDAO commentDAO;
  @Resource
  private ArticleDAO articleDao;


  @Override
  public Comment findByID(final Integer articleId) {return this.commentDAO.findByID(articleId);}

  @Override
  public List<Comment> findAll() {
	  return this.commentDAO.findAll();
  }

  @Override
  public void createComment(Comment comment, Integer articleId) {
    Article article = this.articleDao.findByID(articleId);
    comment.setArticle(article);
    article.setComment(Collections.singletonList(comment));
    this.commentDAO.persist(comment);
  }

  @Override
  public void deleteComment(final Integer articleId){
    this.commentDAO.delete(articleId);
  }

}
