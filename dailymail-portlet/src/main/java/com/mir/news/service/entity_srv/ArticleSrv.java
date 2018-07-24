package com.mir.news.service.entity_srv;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.mir.news.model.Article;

public interface ArticleSrv {
	
	public Article create(ActionRequest request) throws SystemException;
	
	public Article delete(ActionRequest request) throws SystemException, NumberFormatException, PortalException;
	
	public Article update(ActionRequest request) throws SystemException, PortalException;
	
	public Article find(RenderRequest request) throws SystemException, NumberFormatException, PortalException;
	
	public List<Article> findAll() throws SystemException;
}
