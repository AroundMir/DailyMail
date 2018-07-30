package com.mir.news.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ArticleLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ArticleLocalService
 * @generated
 */
public class ArticleLocalServiceWrapper implements ArticleLocalService,
    ServiceWrapper<ArticleLocalService> {
    private ArticleLocalService _articleLocalService;

    public ArticleLocalServiceWrapper(ArticleLocalService articleLocalService) {
        _articleLocalService = articleLocalService;
    }

    /**
    * Adds the article to the database. Also notifies the appropriate model listeners.
    *
    * @param article the article
    * @return the article that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.mir.news.model.Article addArticle(
        com.mir.news.model.Article article)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _articleLocalService.addArticle(article);
    }

    /**
    * Creates a new article with the primary key. Does not add the article to the database.
    *
    * @param articleId the primary key for the new article
    * @return the new article
    */
    @Override
    public com.mir.news.model.Article createArticle(long articleId) {
        return _articleLocalService.createArticle(articleId);
    }

    /**
    * Deletes the article with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param articleId the primary key of the article
    * @return the article that was removed
    * @throws PortalException if a article with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.mir.news.model.Article deleteArticle(long articleId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _articleLocalService.deleteArticle(articleId);
    }

    /**
    * Deletes the article from the database. Also notifies the appropriate model listeners.
    *
    * @param article the article
    * @return the article that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.mir.news.model.Article deleteArticle(
        com.mir.news.model.Article article)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _articleLocalService.deleteArticle(article);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _articleLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _articleLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.mir.news.model.impl.ArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _articleLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.mir.news.model.impl.ArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _articleLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _articleLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _articleLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public com.mir.news.model.Article fetchArticle(long articleId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _articleLocalService.fetchArticle(articleId);
    }

    /**
    * Returns the article with the primary key.
    *
    * @param articleId the primary key of the article
    * @return the article
    * @throws PortalException if a article with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.mir.news.model.Article getArticle(long articleId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _articleLocalService.getArticle(articleId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _articleLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the articles.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.mir.news.model.impl.ArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of articles
    * @param end the upper bound of the range of articles (not inclusive)
    * @return the range of articles
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.mir.news.model.Article> getArticles(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _articleLocalService.getArticles(start, end);
    }

    /**
    * Returns the number of articles.
    *
    * @return the number of articles
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getArticlesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _articleLocalService.getArticlesCount();
    }

    /**
    * Updates the article in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param article the article
    * @return the article that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.mir.news.model.Article updateArticle(
        com.mir.news.model.Article article)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _articleLocalService.updateArticle(article);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void addReviewArticle(long reviewId, long articleId)
        throws com.liferay.portal.kernel.exception.SystemException {
        _articleLocalService.addReviewArticle(reviewId, articleId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void addReviewArticle(long reviewId,
        com.mir.news.model.Article article)
        throws com.liferay.portal.kernel.exception.SystemException {
        _articleLocalService.addReviewArticle(reviewId, article);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void addReviewArticles(long reviewId, long[] articleIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        _articleLocalService.addReviewArticles(reviewId, articleIds);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void addReviewArticles(long reviewId,
        java.util.List<com.mir.news.model.Article> Articles)
        throws com.liferay.portal.kernel.exception.SystemException {
        _articleLocalService.addReviewArticles(reviewId, Articles);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void clearReviewArticles(long reviewId)
        throws com.liferay.portal.kernel.exception.SystemException {
        _articleLocalService.clearReviewArticles(reviewId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void deleteReviewArticle(long reviewId, long articleId)
        throws com.liferay.portal.kernel.exception.SystemException {
        _articleLocalService.deleteReviewArticle(reviewId, articleId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void deleteReviewArticle(long reviewId,
        com.mir.news.model.Article article)
        throws com.liferay.portal.kernel.exception.SystemException {
        _articleLocalService.deleteReviewArticle(reviewId, article);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void deleteReviewArticles(long reviewId, long[] articleIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        _articleLocalService.deleteReviewArticles(reviewId, articleIds);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void deleteReviewArticles(long reviewId,
        java.util.List<com.mir.news.model.Article> Articles)
        throws com.liferay.portal.kernel.exception.SystemException {
        _articleLocalService.deleteReviewArticles(reviewId, Articles);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.mir.news.model.Article> getReviewArticles(
        long reviewId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _articleLocalService.getReviewArticles(reviewId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.mir.news.model.Article> getReviewArticles(
        long reviewId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _articleLocalService.getReviewArticles(reviewId, start, end);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.mir.news.model.Article> getReviewArticles(
        long reviewId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _articleLocalService.getReviewArticles(reviewId, start, end,
            orderByComparator);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getReviewArticlesCount(long reviewId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _articleLocalService.getReviewArticlesCount(reviewId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public boolean hasReviewArticle(long reviewId, long articleId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _articleLocalService.hasReviewArticle(reviewId, articleId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public boolean hasReviewArticles(long reviewId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _articleLocalService.hasReviewArticles(reviewId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void setReviewArticles(long reviewId, long[] articleIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        _articleLocalService.setReviewArticles(reviewId, articleIds);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _articleLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _articleLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _articleLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public java.util.List<com.mir.news.model.Review> getArticleReviews(
        long articleId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _articleLocalService.getArticleReviews(articleId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ArticleLocalService getWrappedArticleLocalService() {
        return _articleLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedArticleLocalService(
        ArticleLocalService articleLocalService) {
        _articleLocalService = articleLocalService;
    }

    @Override
    public ArticleLocalService getWrappedService() {
        return _articleLocalService;
    }

    @Override
    public void setWrappedService(ArticleLocalService articleLocalService) {
        _articleLocalService = articleLocalService;
    }
}
