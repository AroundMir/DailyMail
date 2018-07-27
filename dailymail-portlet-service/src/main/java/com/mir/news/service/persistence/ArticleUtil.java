package com.mir.news.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.mir.news.model.Article;

import java.util.List;

/**
 * The persistence utility for the article service. This utility wraps {@link ArticlePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ArticlePersistence
 * @see ArticlePersistenceImpl
 * @generated
 */
public class ArticleUtil {
    private static ArticlePersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(Article article) {
        getPersistence().clearCache(article);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<Article> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Article> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Article> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Article update(Article article) throws SystemException {
        return getPersistence().update(article);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Article update(Article article, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(article, serviceContext);
    }

    /**
    * Caches the article in the entity cache if it is enabled.
    *
    * @param article the article
    */
    public static void cacheResult(com.mir.news.model.Article article) {
        getPersistence().cacheResult(article);
    }

    /**
    * Caches the articles in the entity cache if it is enabled.
    *
    * @param articles the articles
    */
    public static void cacheResult(
        java.util.List<com.mir.news.model.Article> articles) {
        getPersistence().cacheResult(articles);
    }

    /**
    * Creates a new article with the primary key. Does not add the article to the database.
    *
    * @param articleId the primary key for the new article
    * @return the new article
    */
    public static com.mir.news.model.Article create(long articleId) {
        return getPersistence().create(articleId);
    }

    /**
    * Removes the article with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param articleId the primary key of the article
    * @return the article that was removed
    * @throws com.mir.news.NoSuchArticleException if a article with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.mir.news.model.Article remove(long articleId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.mir.news.NoSuchArticleException {
        return getPersistence().remove(articleId);
    }

    public static com.mir.news.model.Article updateImpl(
        com.mir.news.model.Article article)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(article);
    }

    /**
    * Returns the article with the primary key or throws a {@link com.mir.news.NoSuchArticleException} if it could not be found.
    *
    * @param articleId the primary key of the article
    * @return the article
    * @throws com.mir.news.NoSuchArticleException if a article with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.mir.news.model.Article findByPrimaryKey(long articleId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.mir.news.NoSuchArticleException {
        return getPersistence().findByPrimaryKey(articleId);
    }

    /**
    * Returns the article with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param articleId the primary key of the article
    * @return the article, or <code>null</code> if a article with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.mir.news.model.Article fetchByPrimaryKey(long articleId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(articleId);
    }

    /**
    * Returns all the articles.
    *
    * @return the articles
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.mir.news.model.Article> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.mir.news.model.Article> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the articles.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.mir.news.model.impl.ArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of articles
    * @param end the upper bound of the range of articles (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of articles
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.mir.news.model.Article> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the articles from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of articles.
    *
    * @return the number of articles
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    /**
    * Returns all the reviews associated with the article.
    *
    * @param pk the primary key of the article
    * @return the reviews associated with the article
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.mir.news.model.Review> getReviews(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getReviews(pk);
    }

    /**
    * Returns a range of all the reviews associated with the article.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.mir.news.model.impl.ArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param pk the primary key of the article
    * @param start the lower bound of the range of articles
    * @param end the upper bound of the range of articles (not inclusive)
    * @return the range of reviews associated with the article
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.mir.news.model.Review> getReviews(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getReviews(pk, start, end);
    }

    /**
    * Returns an ordered range of all the reviews associated with the article.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.mir.news.model.impl.ArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param pk the primary key of the article
    * @param start the lower bound of the range of articles
    * @param end the upper bound of the range of articles (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of reviews associated with the article
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.mir.news.model.Review> getReviews(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getReviews(pk, start, end, orderByComparator);
    }

    /**
    * Returns the number of reviews associated with the article.
    *
    * @param pk the primary key of the article
    * @return the number of reviews associated with the article
    * @throws SystemException if a system exception occurred
    */
    public static int getReviewsSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getReviewsSize(pk);
    }

    /**
    * Returns <code>true</code> if the review is associated with the article.
    *
    * @param pk the primary key of the article
    * @param reviewPK the primary key of the review
    * @return <code>true</code> if the review is associated with the article; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsReview(long pk, long reviewPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsReview(pk, reviewPK);
    }

    /**
    * Returns <code>true</code> if the article has any reviews associated with it.
    *
    * @param pk the primary key of the article to check for associations with reviews
    * @return <code>true</code> if the article has any reviews associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsReviews(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsReviews(pk);
    }

    /**
    * Adds an association between the article and the review. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the article
    * @param reviewPK the primary key of the review
    * @throws SystemException if a system exception occurred
    */
    public static void addReview(long pk, long reviewPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addReview(pk, reviewPK);
    }

    /**
    * Adds an association between the article and the review. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the article
    * @param review the review
    * @throws SystemException if a system exception occurred
    */
    public static void addReview(long pk, com.mir.news.model.Review review)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addReview(pk, review);
    }

    /**
    * Adds an association between the article and the reviews. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the article
    * @param reviewPKs the primary keys of the reviews
    * @throws SystemException if a system exception occurred
    */
    public static void addReviews(long pk, long[] reviewPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addReviews(pk, reviewPKs);
    }

    /**
    * Adds an association between the article and the reviews. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the article
    * @param reviews the reviews
    * @throws SystemException if a system exception occurred
    */
    public static void addReviews(long pk,
        java.util.List<com.mir.news.model.Review> reviews)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addReviews(pk, reviews);
    }

    /**
    * Clears all associations between the article and its reviews. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the article to clear the associated reviews from
    * @throws SystemException if a system exception occurred
    */
    public static void clearReviews(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().clearReviews(pk);
    }

    /**
    * Removes the association between the article and the review. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the article
    * @param reviewPK the primary key of the review
    * @throws SystemException if a system exception occurred
    */
    public static void removeReview(long pk, long reviewPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeReview(pk, reviewPK);
    }

    /**
    * Removes the association between the article and the review. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the article
    * @param review the review
    * @throws SystemException if a system exception occurred
    */
    public static void removeReview(long pk, com.mir.news.model.Review review)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeReview(pk, review);
    }

    /**
    * Removes the association between the article and the reviews. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the article
    * @param reviewPKs the primary keys of the reviews
    * @throws SystemException if a system exception occurred
    */
    public static void removeReviews(long pk, long[] reviewPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeReviews(pk, reviewPKs);
    }

    /**
    * Removes the association between the article and the reviews. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the article
    * @param reviews the reviews
    * @throws SystemException if a system exception occurred
    */
    public static void removeReviews(long pk,
        java.util.List<com.mir.news.model.Review> reviews)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeReviews(pk, reviews);
    }

    /**
    * Sets the reviews associated with the article, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the article
    * @param reviewPKs the primary keys of the reviews to be associated with the article
    * @throws SystemException if a system exception occurred
    */
    public static void setReviews(long pk, long[] reviewPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().setReviews(pk, reviewPKs);
    }

    /**
    * Sets the reviews associated with the article, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the article
    * @param reviews the reviews to be associated with the article
    * @throws SystemException if a system exception occurred
    */
    public static void setReviews(long pk,
        java.util.List<com.mir.news.model.Review> reviews)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().setReviews(pk, reviews);
    }

    public static ArticlePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ArticlePersistence) PortletBeanLocatorUtil.locate(com.mir.news.service.ClpSerializer.getServletContextName(),
                    ArticlePersistence.class.getName());

            ReferenceRegistry.registerReference(ArticleUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(ArticlePersistence persistence) {
    }
}
