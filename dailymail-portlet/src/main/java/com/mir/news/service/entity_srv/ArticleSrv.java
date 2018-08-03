package com.mir.news.service.entity_srv;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.mir.news.model.Article;

public interface ArticleSrv {
	
	 Article createArticle(ActionRequest request) throws SystemException;
	
	 Article deleteArticle(ActionRequest request) throws SystemException, NumberFormatException, PortalException;
	
	 Article updateArticle(ActionRequest request) throws SystemException, PortalException;
	
	 Article findArticle(RenderRequest request) throws SystemException, NumberFormatException, PortalException;
	
	 List<Article> findAllArticles() throws SystemException;
}
