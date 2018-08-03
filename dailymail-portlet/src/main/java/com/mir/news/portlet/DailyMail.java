package com.mir.news.portlet;

import java.io.IOException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.mir.news.model.Article;
import com.mir.news.service.entity_srv.ArticleServiceImpl;
import com.mir.news.service.entity_srv.ArticleSrv;
import com.mir.news.service.entity_srv.ReviewServiceImpl;
import com.mir.news.service.entity_srv.ReviewSrv;
import com.mir.news.util.ArticleUt;
import com.mir.news.util.CommonUt;

public class DailyMail extends MVCPortlet {
  private static final Log log = LogFactoryUtil.getLog(DailyMail.class);
  private final ArticleUt articleUtil = ArticleUt.getInstance();
  private final CommonUt commonUtil = CommonUt.getInstance();
  private final ArticleSrv articleService = ArticleServiceImpl.getInstance();
  private final ReviewSrv reviewService = ReviewServiceImpl.getInstance();

  @Override
  public void render(RenderRequest renderRequest, RenderResponse renderResponse) {

    setArticleAttribute(renderRequest);
    commonUtil.setCurrentUserRoleName(renderRequest);
    String viewPath = commonUtil.getViewPath(renderRequest, renderResponse);
    try {
      include(viewPath, renderRequest, renderResponse);
    } catch (IOException e) {
      log.error(e.getMessage());
    } catch (PortletException e) {
      log.error(e.getMessage());
    }
  }

  /**
   * Set published Articles in request
   * 
   * @param renderRequest
   * @param renderResponse
   */
  public void setPublishedArticles(ActionRequest actionRequest, ActionResponse actionResponse) {
    try {
      articleUtil.setPublishedArticles(actionRequest);
    } catch (SystemException e) {
      log.error(e.getMessage());
    }
  }

  /**
   * Set confirmation Articles in request
   * 
   * @param actionRequest
   * @param actionResponse
   */
  public void setConfirmationArticles(ActionRequest actionRequest, ActionResponse actionResponse) {
    try {
      articleUtil.setArticlesOnConfirmation(actionRequest);
    } catch (SystemException e) {
      log.error(e.getMessage());
    }
  }

  /**
   * Update article status on CONFIRMATION
   * 
   * @param actionRequest
   * @param actionResponse
   * @throws NumberFormatException
   * @throws PortalException
   * @throws SystemException
   */
  public void setArticleConfirmationStatus(ActionRequest actionRequest,
      ActionResponse actionResponse) throws NumberFormatException, PortalException, SystemException {
    articleUtil.setConfirmationStatus(actionRequest);
  }

  /**
   * Update article status on UPDATE
   * 
   * @param actionRequest
   * @param actionResponse
   * @throws NumberFormatException
   * @throws PortalException
   * @throws SystemException
   */

  public void setArticlePublishStatus(ActionRequest actionRequest, ActionResponse actionResponse)
      throws NumberFormatException, PortalException, SystemException {
    articleUtil.setPublishedStatus(actionRequest);
  }

  /**
   * Update article status on EDIT
   * 
   * @param actionRequest
   * @param actionResponse
   * @throws NumberFormatException
   * @throws PortalException
   * @throws SystemException
   */

  public void setArticleEditStatus(ActionRequest actionRequest, ActionResponse actionResponse)
      throws NumberFormatException, PortalException, SystemException {
    articleUtil.setEditStatus(actionRequest);
  }

  /**
   * Set editing Articles in request
   * 
   * @param actionRequest
   * @param actionResponse
   * @throws SystemException
   */
  public void setEditingArticles(ActionRequest actionRequest, ActionResponse actionResponse)
      throws SystemException {
    articleUtil.setEditingAuthorArticles(actionRequest);
  }
  
  /**
   * Add new Article
   * @param actionRequest
   * @param actionResponse
   * @throws SystemException
   */

  public void addArticle(ActionRequest actionRequest, ActionResponse actionResponse)
      throws SystemException {
    articleService.createArticle(actionRequest);
  }
  /**
   * Delete article by Id;
   * @param actionRequest
   * @param actionResponse
   * @throws SystemException
   * @throws NumberFormatException
   * @throws PortalException
   */

  public void deleteArticle(ActionRequest actionRequest, ActionResponse actionResponse)
      throws SystemException, NumberFormatException, PortalException {
    articleService.deleteArticle(actionRequest);
  }
  
  /**
   * Update article
   * @param actionRequest
   * @param actionResponse
   * @throws SystemException
   */

  public void updateArticle(ActionRequest actionRequest, ActionResponse actionResponse)
      throws SystemException {
    try {
      articleService.updateArticle(actionRequest);
    } catch (PortalException e) {
      log.error(e.getMessage());
    }
  }

  /**
   * Find Article entity by id and set in renderRequest attribute
   * 
   * @param renderRequest
   * @return
   * @throws SystemException
   */
  public void setArticleAttribute(RenderRequest renderRequest) {
    try {
      Article article = articleService.findArticle(renderRequest);
      renderRequest.setAttribute("article", article);
    } catch (NumberFormatException e) {

    } catch (SystemException e) {
      log.error(e.getMessage());
    } catch (PortalException e) {
      log.error(e.getMessage());
    }
  }
  
  /**
   * Add new review 
   * @param actionRequest
   * @param actionResponse
   * @throws SystemException
   * @throws NumberFormatException
   * @throws PortalException
   */

  public void addReview(ActionRequest actionRequest, ActionResponse actionResponse)
      throws SystemException, NumberFormatException, PortalException {
    reviewService.createReview(actionRequest);
  }
  
  /**
   * Delete review
   * @param actionRequest
   * @param actionResponse
   * @throws NumberFormatException
   * @throws SystemException
   * @throws PortalException
   */

  public void deleteReview(ActionRequest actionRequest, ActionResponse actionResponse)
      throws NumberFormatException, SystemException, PortalException {
    reviewService.deleteReview(actionRequest);
  }
}
