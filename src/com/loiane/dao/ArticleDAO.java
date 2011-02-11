package com.loiane.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.loiane.model.Article;

/**
 * Article DAO - xml configuration
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
public class ArticleDAO {

	/**
	 * Returns the list of all Article instances from the database filtered by title.
	 * @return the list of all Article instances from the database filtered by title.
	 */
	@SuppressWarnings("unchecked")
	public List<Article> selectArticleByTitle(Article article){

		SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<Article> list = session.selectList("Article.selectArticleByTitle", article);
			return list;
		} finally {
			session.close();
		}
	}
	
	/**
	 * Returns the list of all Article instances from the database filtered
	 * by title and author.
	 * @return the list of all Article instances from the database filtered
	 * by title and author.
	 */
	@SuppressWarnings("unchecked")
	public List<Article> selectArticleByTitleAndAuthor(Article article){

		SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<Article> list = session.selectList("Article.selectArticleByTitleAndAuthor", article);
			return list;
		} finally {
			session.close();
		}
	}
	
	/**
	 * Returns the list of all Article instances from the database filtered
	 * by title or author, in case there is no filter, it is going to return
	 * all the article from ibatis category.
	 * @return the list of all Article instances from the database.
	 */
	@SuppressWarnings("unchecked")
	public List<Article> selectArticleByTitleOrAuthorOrCategory(Article article){

		SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<Article> list = session.selectList("Article.selectArticleByTitleOrAuthorOrCategory", article);
			return list;
		} finally {
			session.close();
		}
	}
	
	/**
	 * Returns the list of all Article instances from the database filtered
	 * by title or author or both or none.
	 * @return the list of all Article instances from the database.
	 */
	@SuppressWarnings("unchecked")
	public List<Article> selectArticleByTitleAndAuthorDynamic(Article article){

		SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<Article> list = session.selectList("Article.selectArticleByTitleAndAuthorDynamic", article);
			return list;
		} finally {
			session.close();
		}
	}
	
	/**
	 * Returns the list of all Article instances from the database filtered
	 * by title or author, in case there is no filter, it is going to return
	 * all the articles from ibatis category.
	 * @return the list of all Article instances from the database.
	 */
	@SuppressWarnings("unchecked")
	public List<Article> selectArticleByListCategories(List<Integer> categories){

		SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<Article> list = session.selectList("Article.selectArticleByListCategories", categories);
			return list;
		} finally {
			session.close();
		}
	}
	
}
