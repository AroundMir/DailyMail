package com.mir.news.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Article. This utility wraps
 * {@link com.mir.news.service.impl.ArticleLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ArticleLocalService
 * @see com.mir.news.service.base.ArticleLocalServiceBaseImpl
 * @see com.mir.news.service.impl.ArticleLocalServiceImpl
 * @generated
 */
public class ArticleLocalServiceUtil {
    private static ArticleLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.mir.news.service.impl.ArticleLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the article to the database. Also notifies the appropriate model listeners.
    *
    * @param article the article
    * @return the article that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.mir.news.model.Article addArticle(
        com.mir.news.model.Article article)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addArticle(article);
    }

    /**
    * Creates a new article with the primary key. Does not add the article to the database.
    *
    * @param articleId the primary key for the new article
    * @return the new article
    */
    public static com.mir.news.model.Article createArticle(long articleId) {
        return getService().createArticle(articleId);
    }

    /**
    * Deletes the article with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param articleId the primary key of the article
    * @return the article that was removed
    * @throws PortalException if a article with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.mir.news.model.Article deleteArticle(long articleId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteArticle(articleId);
    }

    /**
    * Deletes the article from the database. Also notifies the appropriate model listeners.
    *
    * @param article the article
    * @return the article that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.mir.news.model.Article deleteArticle(
        com.mir.news.model.Article article)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteArticle(article);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static com.mir.news.model.Article fetchArticle(long articleId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchArticle(articleId);
    }

    /**
    * Returns the article with the primary key.
    *
    * @param articleId the primary key of the article
    * @return the article
    * @throws PortalException if a article with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.mir.news.model.Article getArticle(long articleId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getArticle(articleId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<com.mir.news.model.Article> getArticles(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getArticles(start, end);
    }

    /**
    * Returns the number of articles.
    *
    * @return the number of articles
    * @throws SystemException if a system exception occurred
    */
    public static int getArticlesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getArticlesCount();
    }

    /**
    * Updates the article in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param article the article
    * @return the article that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.mir.news.model.Article updateArticle(
        com.mir.news.model.Article article)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateArticle(article);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void addReviewArticle(long reviewId, long articleId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().addReviewArticle(reviewId, articleId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void addReviewArticle(long reviewId,
        com.mir.news.model.Article article)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().addReviewArticle(reviewId, article);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void addReviewArticles(long reviewId, long[] articleIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().addReviewArticles(reviewId, articleIds);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void addReviewArticles(long reviewId,
        java.util.List<com.mir.news.model.Article> Articles)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().addReviewArticles(reviewId, Articles);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void clearReviewArticles(long reviewId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().clearReviewArticles(reviewId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void deleteReviewArticle(long reviewId, long articleId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteReviewArticle(reviewId, articleId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void deleteReviewArticle(long reviewId,
        com.mir.news.model.Article article)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteReviewArticle(reviewId, article);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void deleteReviewArticles(long reviewId, long[] articleIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteReviewArticles(reviewId, articleIds);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void deleteReviewArticles(long reviewId,
        java.util.List<com.mir.news.model.Article> Articles)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteReviewArticles(reviewId, Articles);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.mir.news.model.Article> getReviewArticles(
        long reviewId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getReviewArticles(reviewId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.mir.news.model.Article> getReviewArticles(
        long reviewId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getReviewArticles(reviewId, start, end);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.mir.news.model.Article> getReviewArticles(
        long reviewId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .getReviewArticles(reviewId, start, end, orderByComparator);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static int getReviewArticlesCount(long reviewId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getReviewArticlesCount(reviewId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static boolean hasReviewArticle(long reviewId, long articleId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().hasReviewArticle(reviewId, articleId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static boolean hasReviewArticles(long reviewId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().hasReviewArticles(reviewId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void setReviewArticles(long reviewId, long[] articleIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().setReviewArticles(reviewId, articleIds);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

<<<<<<< HEAD
    public static java.util.List<com.mir.news.model.Review> getArticleReviews(
        long articleId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getArticleReviews(articleId);
    }

=======
>>>>>>> 816e3130999f956bdec64fcf78b511dbf024c3e4
    public static void clearService() {
        _service = null;
    }

    public static ArticleLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ArticleLocalService.class.getName());

            if (invokableLocalService instanceof ArticleLocalService) {
                _service = (ArticleLocalService) invokableLocalService;
            } else {
                _service = new ArticleLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(ArticleLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(ArticleLocalService service) {
    }
}
