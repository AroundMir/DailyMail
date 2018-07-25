package com.mir.news.service.entity_srv;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;


import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.mir.news.model.Article;
import com.mir.news.service.ArticleLocalServiceUtil;

public class ArticleServiceImpl implements ArticleSrv {
	private static ArticleServiceImpl articleSrv = null;

	private ArticleServiceImpl() {
	}

	public static ArticleServiceImpl getInstance() {
		if (articleSrv == null) {
			articleSrv = new ArticleServiceImpl();
		}
		return articleSrv;
	}

	
	public Article create(ActionRequest actionRequest) throws SystemException {

		String articleName = actionRequest.getParameter("name");
		String articleText = actionRequest.getParameter("text");

		long id = CounterLocalServiceUtil.increment(Article.class.getName());
		Article article = ArticleLocalServiceUtil.createArticle(id);
		article.setName(articleName);
		article.setText(articleText);
		article.setStatus("EDITING");

		ThemeDisplay themeDisp = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userID = themeDisp.getUserId();

		article.setAuthorId(userID);
		article = ArticleLocalServiceUtil.addArticle(article);
		return article;
	}

	public Article delete(ActionRequest actionRequest) throws NumberFormatException, PortalException, SystemException {

		String articleId = actionRequest.getParameter("articleId");
		if (articleId != null) {
			Article article = ArticleLocalServiceUtil.deleteArticle(Long.parseLong(articleId));
			return article;
		}
		return null;
	}

	public Article update(ActionRequest actionRequest) throws PortalException, SystemException {
		
		String articleName = actionRequest.getParameter("name");
		String articleText = actionRequest.getParameter("text");
		String articleId = actionRequest.getParameter("articleId");
		if (articleId != null) {
			Article article = ArticleLocalServiceUtil.getArticle(Long.parseLong(articleId));
			article.setName(articleName);
			article.setText(articleText);
			article = ArticleLocalServiceUtil.updateArticle(article);
			return article;
		}
		return null;
	}

	public Article find(RenderRequest renderRequest) throws NumberFormatException, PortalException, SystemException {

		String articleId = renderRequest.getParameter("articleId");
		if (articleId != null) {
			Article article = ArticleLocalServiceUtil.getArticle(Long.parseLong(articleId));
			return article;
		}
		return null;
	}

	public List<Article> findAll() throws SystemException {

		long articleCount = ArticleLocalServiceUtil.getArticlesCount();
		List<Article> articles = ArticleLocalServiceUtil.getArticles(0, (int) articleCount);
		return articles;
	}
}
