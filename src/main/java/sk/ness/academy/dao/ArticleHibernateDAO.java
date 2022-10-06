package sk.ness.academy.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import sk.ness.academy.domain.Article;

@Repository
public class ArticleHibernateDAO implements ArticleDAO {

  @Resource(name = "sessionFactory")
  private SessionFactory sessionFactory;

  @Override
  public Article findByID(final Integer articleId) {
    return (Article) this.sessionFactory.getCurrentSession().get(Article.class, articleId);
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Article> findAll() {
    return this.sessionFactory.getCurrentSession().createSQLQuery("select * from articles").addEntity(Article.class).list();
  }

  @Override
  public void persist(final Article article) {
    this.sessionFactory.getCurrentSession().saveOrUpdate(article);
  }

  @Override
  public void delete(final Integer articleId) {
    this.sessionFactory.getCurrentSession().delete(findByID(articleId));
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Article> search(String word) {
    return this.sessionFactory.getCurrentSession()
            .createSQLQuery("select * from articles where author like :txt or title like :txt or text like :txt")
            .setParameter("txt","%"+word+"%").addEntity(Article.class).list();
  }

}



