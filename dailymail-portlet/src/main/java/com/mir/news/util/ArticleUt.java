package com.mir.news.util;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.mir.news.consts.ArticleStatus;
import com.mir.news.consts.Roles;
import com.mir.news.model.Article;
import com.mir.news.service.ArticleLocalServiceUtil;
import com.mir.news.service.entity_srv.ArticleServiceImpl;
import com.mir.news.service.entity_srv.ArticleSrv;

public class ArticleUt {
	private final ArticleSrv articleService = ArticleServiceImpl.getInstance();
	private static ArticleUt articleUtil = null;
	private final CommonUt commonUt = CommonUt.getInstance();

	public static ArticleUt getInstance() {

		if (articleUtil == null) {
			articleUtil = new ArticleUt();
		}
		return articleUtil;
	}

	/**
	 * Set articles with status 'PUBLISHED' in request
	 * 
	 * @param renderRequest
	 * @param renderResponse
	 * @throws SystemException
	 */
	public void setPublishedArticles(ActionRequest actionRequest) throws SystemException {

		List<Article> allArticles = articleService.findAll();
<<<<<<< HEAD
		List<Article> publishedArticles = new ArrayList<Article>();
=======
		List<Article> publishedArticles = new ArrayList<>();
>>>>>>> 816e3130999f956bdec64fcf78b511dbf024c3e4
		for (Article article : allArticles) {
			if (ArticleStatus.getStatusByString(article.getStatus()) == ArticleStatus.PUBLISHED) {
				publishedArticles.add(article);
			}
		}
		actionRequest.setAttribute("articles", publishedArticles);
	}
	

	/**
	 * Get all articles influencing the author by author ID Set articles with
	 * status 'CONFIRMATION' in request
	 * 
	 * @param actionRequest
	 * @throws SystemException
	 */
	public void setArticlesOnConfirmation(ActionRequest actionRequest) throws SystemException {

		Enum<Roles> role = commonUt.getCurrentUserRole(actionRequest);
		long userId = commonUt.getCurrentUserId(actionRequest);

		if (role == Roles.AUTHOR) {
			List<Article> authorArticles = getAuthorArticles(userId, articleService.findAll());
			List<Article> finalAuthorArticles = new ArrayList<Article>();

			for (Article article : authorArticles) {
				String status = article.getStatus();
				if (ArticleStatus.getStatusByString(status) == ArticleStatus.CONFIRMATION) {
					finalAuthorArticles.add(article);
				}
			}
			actionRequest.setAttribute("articles", finalAuthorArticles);
		}
		if (role == Roles.EDITOR) {
			List<Article> allArticles = articleService.findAll();
			List<Article> confirmArticles = new ArrayList<Article>();

			for (Article article : allArticles) {
				String status = article.getStatus();
				if (ArticleStatus.getStatusByString(status) == ArticleStatus.CONFIRMATION) {
					confirmArticles.add(article);
				}
			}
			actionRequest.setAttribute("articles", confirmArticles);
		}
	}

	/**
	 * Set articles with status 'EDITING' in request
	 * 
	 * @param actionRequest
	 * @throws SystemException
	 */

	public void setEditingAuthorArticles(ActionRequest actionRequest) throws SystemException {

		ThemeDisplay themeDisp = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long authorId = themeDisp.getUserId();
		List<Article> authorArticles = getAuthorArticles(authorId, articleService.findAll());
		List<Article> finalAuthorArticles = new ArrayList<Article>();

		for (Article article : authorArticles) {
			String status = article.getStatus();
			if (ArticleStatus.getStatusByString(status) == ArticleStatus.EDITING) {
				finalAuthorArticles.add(article);
			}
		}
		actionRequest.setAttribute("articles", finalAuthorArticles);
	}
	/**
	 * Set
	 * @param actionRequest
	 * @return
	 * @throws NumberFormatException
	 * @throws PortalException
	 * @throws SystemException
	 */

	public Article setPublishedStatus(ActionRequest actionRequest) throws NumberFormatException, PortalException, SystemException {

		String articleId = actionRequest.getParameter("articleId");
		Article article = ArticleLocalServiceUtil.getArticle(Long.parseLong(articleId));
		article.setStatus(ArticleStatus.PUBLISHED.toString());
		ArticleLocalServiceUtil.updateArticle(article);
		return article;
	}
	
	public Article setConfirmationStatus(ActionRequest actionRequest) throws NumberFormatException, PortalException, SystemException {

		String articleId = actionRequest.getParameter("articleId");
		Article article = ArticleLocalServiceUtil.getArticle(Long.parseLong(articleId));
		article.setStatus(ArticleStatus.CONFIRMATION.toString());
		ArticleLocalServiceUtil.updateArticle(article);
		return article;
	}
	

	public Article setEditStatus(ActionRequest actionRequest) throws NumberFormatException, PortalException, SystemException {

		String articleId = actionRequest.getParameter("articleId");
		Article article = ArticleLocalServiceUtil.getArticle(Long.parseLong(articleId));
		article.setStatus(ArticleStatus.EDITING.toString());
		ArticleLocalServiceUtil.updateArticle(article);
		return article;
	}
	

	/**
	 * get articles by AuthorId
	 * 
	 * @param authorId
	 * @param articles
	 * @return
	 */

	public List<Article> getAuthorArticles(Long authorId, List<Article> articles) {

		List<Article> authorArticles = new ArrayList<Article>();
		for (Article article : articles) {
			if (article.getAuthorId() == authorId) {
				authorArticles.add(article);
			}
		}
		return authorArticles;
	}

	

}
