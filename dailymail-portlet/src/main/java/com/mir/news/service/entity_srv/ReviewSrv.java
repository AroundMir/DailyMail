package com.mir.news.service.entity_srv;

import java.util.List;
import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.mir.news.model.Review;

public interface ReviewSrv {

	Review createReview(ActionRequest request) throws SystemException, NumberFormatException, PortalException;

	Review deleteReview(ActionRequest request) throws SystemException, NumberFormatException, PortalException;

	Review updateReview(ActionRequest request) throws SystemException, NumberFormatException, PortalException;

	Review findReview(RenderRequest renderRequest) throws NumberFormatException, PortalException,
    SystemException;

	List<Review> findAllReviews() throws SystemException;
}
