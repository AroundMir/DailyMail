package com.mir.news.service.entity_srv;

import java.util.List;
import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.mir.news.consts.ArticleStatus;
import com.mir.news.model.Article;
import com.mir.news.service.ArticleLocalServiceUtil;

public class ArticleServiceImpl implements ArticleSrv {
  
  private static ArticleServiceImpl instance = null;
  
  private ArticleServiceImpl() {}

  public static ArticleServiceImpl getInstance() {
    if (instance == null) {
      instance = new ArticleServiceImpl();
    }
    return instance;
  }


  /**
   * Create new Article with status EDITING
   */

  public Article createArticle(ActionRequest actionRequest) throws SystemException {

    ThemeDisplay themeDisp = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
    long userID = themeDisp.getUserId();
    
    String articleName = actionRequest.getParameter("name");
    String articleText = actionRequest.getParameter("text");

    long id = CounterLocalServiceUtil.increment(Article.class.getName());
    Article article = ArticleLocalServiceUtil.createArticle(id);
    article.setName(articleName);
    article.setText(articleText);
    article.setStatus(ArticleStatus.EDITING.toString());
    article.setAuthorId(userID);
    article = ArticleLocalServiceUtil.addArticle(article);
    return article;
  }
  
  /**
   * Delete article by Id
   */

  public Article deleteArticle(ActionRequest actionRequest) throws NumberFormatException, PortalException,
      SystemException {

    long articleId = ParamUtil.getLong(actionRequest, "articleId", 0);
    if (articleId != 0) {
      Article article = ArticleLocalServiceUtil.deleteArticle(articleId);
      return article;
    }
    return null;
  }
  
  /**
   * Update Article. If "Editor Comment =! null" change 
   * article status to Editing
   */

  public Article updateArticle(ActionRequest actionRequest) throws PortalException, SystemException {

    String articleName = actionRequest.getParameter("name");
    String articleText = actionRequest.getParameter("text");
    String editorComment = actionRequest.getParameter("editorComment");
    long articleId = ParamUtil.getLong(actionRequest, "articleId", 0);
    
    if (articleId != 0) {
      Article article = ArticleLocalServiceUtil.getArticle(articleId);
      if (articleName != null) {
        article.setName(articleName);
      }
      if (articleText != null) {
        article.setText(articleText);
      }
      if (editorComment != null) {
        article.setEditorComment(editorComment);
        article.setStatus(ArticleStatus.EDITING.toString());
      }
      article = ArticleLocalServiceUtil.updateArticle(article);
      return article;
    }
    return null;
  }

  public Article findArticle(RenderRequest renderRequest) throws NumberFormatException, PortalException,
      SystemException {

    long articleId = ParamUtil.getLong(renderRequest, "articleId", 0);
    if (articleId != 0) {
      Article article = ArticleLocalServiceUtil.getArticle(articleId);
      return article;
    }
    return null;
  }

  public List<Article> findAllArticles() throws SystemException {

    long articleCount = ArticleLocalServiceUtil.getArticlesCount();
    List<Article> articles = ArticleLocalServiceUtil.getArticles(0, (int) articleCount);
    return articles;
  }
}
