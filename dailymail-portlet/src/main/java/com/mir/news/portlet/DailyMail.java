package com.mir.news.portlet;

import java.io.IOException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.mir.news.consts.Roles;
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
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)  {
		
		setArticleAttribute(renderRequest);
		commonUtil.setCurrentUserRoleName(renderRequest);
		String viewPath = commonUtil.getViewPath(renderRequest, renderResponse);
		try {
      include(viewPath, renderRequest, renderResponse);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (PortletException e) {
      e.printStackTrace();
    }
	}
	
	/**
	 * Set published Articles in request
	 * 
	 * @param renderRequest
	 * @param renderResponse
	 */
	public void checkPublishedArticles(ActionRequest actionRequest, ActionResponse actionResponse) {
		try {
			articleUtil.setPublishedArticles(actionRequest);
		} catch (SystemException e) {
			log.info("Error get Published Articles from database", e);
		}
	}

	/**
	 * Set confirmation Articles in request
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void checkConfirmationArticles(ActionRequest actionRequest, ActionResponse actionResponse) {
		try {
			articleUtil.setArticlesOnConfirmation(actionRequest);
		} catch (SystemException e) {
			log.info("Error get Published Articles from database", e);
		}
	}

	/**
	 * Update article status on CONFIRMATION
	 * @param actionRequest
	 * @param actionResponse
	 * @throws NumberFormatException
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void setArticleConfirmationStatus(ActionRequest actionRequest, ActionResponse actionResponse) throws NumberFormatException,
			PortalException, SystemException {
		articleUtil.setConfirmationStatus(actionRequest);
	}

	public void setArticlePublishStatus(ActionRequest actionRequest, ActionResponse actionResponse) throws NumberFormatException, PortalException, SystemException {
		articleUtil.setPublishedStatus(actionRequest);
	}

	public void setArticleEditStatus(ActionRequest actionRequest, ActionResponse actionResponse) throws NumberFormatException, PortalException, SystemException {
		articleUtil.setEditStatus(actionRequest);
	}
	
	/**
	 * Set editing Articles in request
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws SystemException
	 */
	public void checkEditingArticles(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException {
		articleUtil.setEditingAuthorArticles(actionRequest);
	}

	public void addArticle(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException {
		articleService.create(actionRequest);
	}

	public void deleteArticle(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, NumberFormatException,
			PortalException {
		articleService.delete(actionRequest);
	}

	public void updateArticle(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException {
		try {
			articleService.update(actionRequest);
		} catch (PortalException e) {

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
			Article article = articleService.find(renderRequest);
			renderRequest.setAttribute("article", article);
		} catch (NumberFormatException e) {

		} catch (SystemException e) {
			log.info("SystemException ", e);
		} catch (PortalException e) {
			log.info("PortalException ", e);
		}
	}

	/**
	 * Change article status to "CONFIRMATION"
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws NumberFormatException
	 * @throws PortalException
	 * @throws SystemException
	 */

	public void addReview(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, NumberFormatException, PortalException {
		reviewService.create(actionRequest);
	}

	public void deleteReview(ActionRequest actionRequest, ActionResponse actionResponse) throws NumberFormatException, SystemException,
			PortalException {
		reviewService.delete(actionRequest);
	}
}
