package com.mir.news.service.entity_srv;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.mir.news.model.Review;

public interface ReviewSrv {

	Review create(ActionRequest request) throws SystemException, NumberFormatException, PortalException;

	Review delete(ActionRequest request) throws SystemException, NumberFormatException, PortalException;

	Review update(ActionRequest request) throws SystemException, NumberFormatException, PortalException;

	Review find(ActionRequest request) throws SystemException;

	List<Review> findAll() throws SystemException;

	Review find(RenderRequest renderRequest) throws NumberFormatException, PortalException, SystemException;
}
