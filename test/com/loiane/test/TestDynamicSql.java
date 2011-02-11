package com.loiane.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.loiane.dao.ArticleDAO;
import com.loiane.model.Article;

/**
 * Test Case
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
public class TestDynamicSql {

	private static ArticleDAO articleDAO;
	
	@BeforeClass
	public static  void runBeforeClass() {
		articleDAO = new ArticleDAO();
	}

	@AfterClass
	public static void runAfterClass() {
		articleDAO = null;
	}
	
	
	/**
	 * Test method for {@link com.loiane.dao.ArticleDAO#selectArticleByTitle()}.
	 */
	@Test
	@Ignore
	public void testSelectArticleByTitle() {
		
		//Article parameter is not null, so it should return all the Article instances
		//from database
		List<Article> list = articleDAO.selectArticleByTitle(null);
		
		assertNotNull(list);
		assertEquals(3, list.size());
		
		System.out.println("Article = null");
		
		for (Article article : list){
			System.out.println(article.toString());
		}
		
		//Article parameter is not null, so it should return 1 Article instances
		//from database - matches with "Getting Started" title
		Article art = new Article();
		art.setTitle("Getting Started with ibatis");
		
		list = articleDAO.selectArticleByTitle(art);
		
		assertNotNull(list);
		assertEquals(1, list.size());
		
		System.out.println("Article != null");
		
		for (Article article : list){
			System.out.println(article.toString());
		}
	}
	
	/**
	 * Test method for {@link com.loiane.dao.ArticleDAO#selectArticleByTitleAndAuthor()}.
	 */
	@Test
	@Ignore
	public void testSelectArticleByTitleAndAuthor() {
		
		//Article parameter not null, so it should return all the Article instances
		//from database
		List<Article> list = articleDAO.selectArticleByTitle(null);
		
		assertNotNull(list);
		assertEquals(3, list.size());
		
		System.out.println("Article = null");
		
		for (Article article : list){
			System.out.println(article.toString());
		}
		
		//Article parameter is not null, so it should return 1 Article instances
		//from database - matches with title and author
		Article art = new Article();
		art.setTitle("Getting Started with ibatis");
		art.setAuthor("Loiane Groner");
		
		list = articleDAO.selectArticleByTitleAndAuthor(art);
		
		assertNotNull(list);
		assertEquals(1, list.size());
		
		System.out.println("Article != null");
		
		for (Article article : list){
			System.out.println(article.toString());
		}
		
		//Article parameter is not null, so it should return 0 Article instances
		//from database - matches with title and author
		art.setTitle("Getting Started with ibatis");
		art.setAuthor("John");
		
		list = articleDAO.selectArticleByTitleAndAuthor(art);
		
		assertNotNull(list);
		assertEquals(0, list.size());
		
		System.out.println("Article != null - title and author does not match");
		
		for (Article article : list){
			System.out.println(article.toString());
		}
	}
	
	/**
	 * Test method for {@link com.loiane.dao.ArticleDAO#selectArticleByTitleOrAuthorOrCategory()}.
	 */
	@Test
	@Ignore
	public void testSelectArticleByTitleOrAuthorOrCategory() {
		
		//Article parameter is null, so it should return all the Article instances
		//from database that belongs to IBatis category (id = 1)
		List<Article> list = articleDAO.selectArticleByTitleOrAuthorOrCategory(null);
		
		assertNotNull(list);
		assertEquals(1, list.size());
		
		System.out.println("Article = null");
		
		for (Article article : list){
			System.out.println(article.toString());
		}
		
		//Article parameter is not null, so it should return 1 Article instances
		//from database - matches with "Getting Started" title
		Article art = new Article();
		art.setTitle("Getting Started with ibatis");
		
		list = articleDAO.selectArticleByTitleOrAuthorOrCategory(art);
		
		assertNotNull(list);
		assertEquals(1, list.size());
		
		System.out.println("Article != null - title is not null");
		
		for (Article article : list){
			System.out.println(article.toString());
		}
		
		//Article parameter is not null, so it should return 1 Article instances
		//from database - matches with title
		art.setTitle("Getting Started with ibatis");
		art.setAuthor("Loiane Groner");
		
		list = articleDAO.selectArticleByTitleOrAuthorOrCategory(art);
		
		assertNotNull(list);
		assertEquals(1, list.size());
		
		System.out.println("Article != null - title and author are not null");
		
		for (Article article : list){
			System.out.println(article.toString());
		}
		
		//Article parameter is not null, so it should return 1 Article instances
		//from database - matches with author
		art.setTitle(null);
		art.setAuthor("Loiane Groner");
		
		list = articleDAO.selectArticleByTitleOrAuthorOrCategory(art);
		
		assertNotNull(list);
		assertEquals(2, list.size());
		
		System.out.println("Article != null - title is null");
		
		for (Article article : list){
			System.out.println(article.toString());
		}
	}

	/**
	 * Test method for {@link com.loiane.dao.ArticleDAO#selectArticleByTitleOrAuthorOrCategory()}.
	 */
	@Test
	@Ignore
	public void testSelectArticleByTitleAndAuthorDynamic() {
		
		//Article parameter is null, so it should return all the Article instances
		//from database that belongs to IBatis category (id = 1)
		List<Article> list = articleDAO.selectArticleByTitleAndAuthorDynamic(null);
		
		assertNotNull(list);
		assertEquals(3, list.size());
		
		System.out.println("Article = null");
		
		for (Article article : list){
			System.out.println(article.toString());
		}
		
		//Article parameter is not null, so it should return 1 Article instances
		//from database - matches with "Getting Started" title
		Article art = new Article();
		art.setTitle("Getting Started with ibatis");
		art.setAuthor("Loiane Groner");
		
		list = articleDAO.selectArticleByTitleAndAuthorDynamic(art);
		
		assertNotNull(list);
		assertEquals(1, list.size());
		
		System.out.println("Article != null - title is not null");
		
		for (Article article : list){
			System.out.println(article.toString());
		}
	}
	
	/**
	 * Test method for {@link com.loiane.dao.ArticleDAO#selectArticleByTitleOrAuthorOrCategory()}.
	 */
	@Test
	public void testSelectArticleByListCategories() {
		
		List<Integer> categories = new ArrayList<Integer>();
		categories.add(1);
		categories.add(2);
		categories.add(3);
		
		//Article parameter is null, so it should return all the Article instances
		//from database that belongs to IBatis category (id = 1)
		List<Article> list = articleDAO.selectArticleByListCategories(categories);
		
		assertNotNull(list);
		assertEquals(2, list.size());
		
		System.out.println("Article = null");
		
		for (Article article : list){
			System.out.println(article.toString());
		}
	}
}
