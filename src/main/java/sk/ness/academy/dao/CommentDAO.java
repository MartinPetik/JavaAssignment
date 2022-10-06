package sk.ness.academy.dao;

import sk.ness.academy.domain.Article;
import sk.ness.academy.domain.Comment;

import java.util.List;

public interface CommentDAO {

	  /**
       * Returns {@link Article} with provided ID
       */
	  Comment findByID(Integer commentId);

	  /**
	   * Returns all available {@link Article}s
	   */
	  List<Comment> findAll();

	  /** Persists {@link Article} into the DB */
	  void persist(Comment comment);

	/** Delete  {Article} with provided ID */
	  void delete(final Integer comment);

	}
