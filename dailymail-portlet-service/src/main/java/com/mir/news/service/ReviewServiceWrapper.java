package com.mir.news.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ReviewService}.
 *
 * @author Brian Wing Shun Chan
 * @see ReviewService
 * @generated
 */
public class ReviewServiceWrapper implements ReviewService,
    ServiceWrapper<ReviewService> {
    private ReviewService _reviewService;

    public ReviewServiceWrapper(ReviewService reviewService) {
        _reviewService = reviewService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _reviewService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _reviewService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _reviewService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ReviewService getWrappedReviewService() {
        return _reviewService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedReviewService(ReviewService reviewService) {
        _reviewService = reviewService;
    }

    @Override
    public ReviewService getWrappedService() {
        return _reviewService;
    }

    @Override
    public void setWrappedService(ReviewService reviewService) {
        _reviewService = reviewService;
    }
}
