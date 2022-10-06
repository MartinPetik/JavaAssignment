package sk.ness.academy.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import sk.ness.academy.dao.ArticleDAO;
import sk.ness.academy.domain.Article;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

  @Resource
  private ArticleDAO articleDAO;

  @Override
  public Article findByID(final Integer articleId) {
	  return this.articleDAO.findByID(articleId);
  }

  @Override
  public List<Article> findAll() {
	  return this.articleDAO.findAll();
  }

  @Override
  public void createArticle(final Article article) {
	  this.articleDAO.persist(article);
  }

  @Override
  public void ingestArticles(final String jsonArticles) {

    try {
      List<Article> objectList = new ObjectMapper().readValue(jsonArticles, new TypeReference<ArrayList<Article>>(){});

      for(Article obj : objectList) {
        this.articleDAO.persist(obj);
      }
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void deleteArticle(final Integer articleId){
    this.articleDAO.delete(articleId);
  }


  public List<Article> search(String text) {
    return this.articleDAO.search(text);
  }
}
