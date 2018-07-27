package com.mir.news.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.mir.news.model.Review;

import java.util.List;

/**
 * The persistence utility for the review service. This utility wraps {@link ReviewPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReviewPersistence
 * @see ReviewPersistenceImpl
 * @generated
 */
public class ReviewUtil {
    private static ReviewPersistence _persistence;

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
    public static void clearCache(Review review) {
        getPersistence().clearCache(review);
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
    public static List<Review> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Review> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Review> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Review update(Review review) throws SystemException {
        return getPersistence().update(review);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Review update(Review review, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(review, serviceContext);
    }

    /**
    * Caches the review in the entity cache if it is enabled.
    *
    * @param review the review
    */
    public static void cacheResult(com.mir.news.model.Review review) {
        getPersistence().cacheResult(review);
    }

    /**
    * Caches the reviews in the entity cache if it is enabled.
    *
    * @param reviews the reviews
    */
    public static void cacheResult(
        java.util.List<com.mir.news.model.Review> reviews) {
        getPersistence().cacheResult(reviews);
    }

    /**
    * Creates a new review with the primary key. Does not add the review to the database.
    *
    * @param reviewId the primary key for the new review
    * @return the new review
    */
    public static com.mir.news.model.Review create(long reviewId) {
        return getPersistence().create(reviewId);
    }

    /**
    * Removes the review with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param reviewId the primary key of the review
    * @return the review that was removed
    * @throws com.mir.news.NoSuchReviewException if a review with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.mir.news.model.Review remove(long reviewId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.mir.news.NoSuchReviewException {
        return getPersistence().remove(reviewId);
    }

    public static com.mir.news.model.Review updateImpl(
        com.mir.news.model.Review review)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(review);
    }

    /**
    * Returns the review with the primary key or throws a {@link com.mir.news.NoSuchReviewException} if it could not be found.
    *
    * @param reviewId the primary key of the review
    * @return the review
    * @throws com.mir.news.NoSuchReviewException if a review with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.mir.news.model.Review findByPrimaryKey(long reviewId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.mir.news.NoSuchReviewException {
        return getPersistence().findByPrimaryKey(reviewId);
    }

    /**
    * Returns the review with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param reviewId the primary key of the review
    * @return the review, or <code>null</code> if a review with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.mir.news.model.Review fetchByPrimaryKey(long reviewId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(reviewId);
    }

    /**
    * Returns all the reviews.
    *
    * @return the reviews
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.mir.news.model.Review> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the reviews.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.mir.news.model.impl.ReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of reviews
    * @param end the upper bound of the range of reviews (not inclusive)
    * @return the range of reviews
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.mir.news.model.Review> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the reviews.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.mir.news.model.impl.ReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of reviews
    * @param end the upper bound of the range of reviews (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of reviews
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.mir.news.model.Review> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the reviews from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of reviews.
    *
    * @return the number of reviews
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    /**
    * Returns all the articles associated with the review.
    *
    * @param pk the primary key of the review
    * @return the articles associated with the review
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.mir.news.model.Article> getArticles(
        long pk) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getArticles(pk);
    }

    /**
    * Returns a range of all the articles associated with the review.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.mir.news.model.impl.ReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param pk the primary key of the review
    * @param start the lower bound of the range of reviews
    * @param end the upper bound of the range of reviews (not inclusive)
    * @return the range of articles associated with the review
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.mir.news.model.Article> getArticles(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getArticles(pk, start, end);
    }

    /**
    * Returns an ordered range of all the articles associated with the review.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.mir.news.model.impl.ReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param pk the primary key of the review
    * @param start the lower bound of the range of reviews
    * @param end the upper bound of the range of reviews (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of articles associated with the review
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.mir.news.model.Article> getArticles(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getArticles(pk, start, end, orderByComparator);
    }

    /**
    * Returns the number of articles associated with the review.
    *
    * @param pk the primary key of the review
    * @return the number of articles associated with the review
    * @throws SystemException if a system exception occurred
    */
    public static int getArticlesSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getArticlesSize(pk);
    }

    /**
    * Returns <code>true</code> if the article is associated with the review.
    *
    * @param pk the primary key of the review
    * @param articlePK the primary key of the article
    * @return <code>true</code> if the article is associated with the review; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsArticle(long pk, long articlePK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsArticle(pk, articlePK);
    }

    /**
    * Returns <code>true</code> if the review has any articles associated with it.
    *
    * @param pk the primary key of the review to check for associations with articles
    * @return <code>true</code> if the review has any articles associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsArticles(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsArticles(pk);
    }

    /**
    * Adds an association between the review and the article. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the review
    * @param articlePK the primary key of the article
    * @throws SystemException if a system exception occurred
    */
    public static void addArticle(long pk, long articlePK)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addArticle(pk, articlePK);
    }

    /**
    * Adds an association between the review and the article. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the review
    * @param article the article
    * @throws SystemException if a system exception occurred
    */
    public static void addArticle(long pk, com.mir.news.model.Article article)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addArticle(pk, article);
    }

    /**
    * Adds an association between the review and the articles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the review
    * @param articlePKs the primary keys of the articles
    * @throws SystemException if a system exception occurred
    */
    public static void addArticles(long pk, long[] articlePKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addArticles(pk, articlePKs);
    }

    /**
    * Adds an association between the review and the articles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the review
    * @param articles the articles
    * @throws SystemException if a system exception occurred
    */
    public static void addArticles(long pk,
        java.util.List<com.mir.news.model.Article> articles)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addArticles(pk, articles);
    }

    /**
    * Clears all associations between the review and its articles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the review to clear the associated articles from
    * @throws SystemException if a system exception occurred
    */
    public static void clearArticles(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().clearArticles(pk);
    }

    /**
    * Removes the association between the review and the article. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the review
    * @param articlePK the primary key of the article
    * @throws SystemException if a system exception occurred
    */
    public static void removeArticle(long pk, long articlePK)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeArticle(pk, articlePK);
    }

    /**
    * Removes the association between the review and the article. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the review
    * @param article the article
    * @throws SystemException if a system exception occurred
    */
    public static void removeArticle(long pk, com.mir.news.model.Article article)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeArticle(pk, article);
    }

    /**
    * Removes the association between the review and the articles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the review
    * @param articlePKs the primary keys of the articles
    * @throws SystemException if a system exception occurred
    */
    public static void removeArticles(long pk, long[] articlePKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeArticles(pk, articlePKs);
    }

    /**
    * Removes the association between the review and the articles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the review
    * @param articles the articles
    * @throws SystemException if a system exception occurred
    */
    public static void removeArticles(long pk,
        java.util.List<com.mir.news.model.Article> articles)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeArticles(pk, articles);
    }

    /**
    * Sets the articles associated with the review, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the review
    * @param articlePKs the primary keys of the articles to be associated with the review
    * @throws SystemException if a system exception occurred
    */
    public static void setArticles(long pk, long[] articlePKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().setArticles(pk, articlePKs);
    }

    /**
    * Sets the articles associated with the review, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the review
    * @param articles the articles to be associated with the review
    * @throws SystemException if a system exception occurred
    */
    public static void setArticles(long pk,
        java.util.List<com.mir.news.model.Article> articles)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().setArticles(pk, articles);
    }

    public static ReviewPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ReviewPersistence) PortletBeanLocatorUtil.locate(com.mir.news.service.ClpSerializer.getServletContextName(),
                    ReviewPersistence.class.getName());

            ReferenceRegistry.registerReference(ReviewUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(ReviewPersistence persistence) {
    }
}
