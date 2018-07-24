package com.mir.news.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ArticleService}.
 *
 * @author Brian Wing Shun Chan
 * @see ArticleService
 * @generated
 */
public class ArticleServiceWrapper implements ArticleService,
    ServiceWrapper<ArticleService> {
    private ArticleService _articleService;

    public ArticleServiceWrapper(ArticleService articleService) {
        _articleService = articleService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _articleService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _articleService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _articleService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ArticleService getWrappedArticleService() {
        return _articleService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedArticleService(ArticleService articleService) {
        _articleService = articleService;
    }

    @Override
    public ArticleService getWrappedService() {
        return _articleService;
    }

    @Override
    public void setWrappedService(ArticleService articleService) {
        _articleService = articleService;
    }
}
