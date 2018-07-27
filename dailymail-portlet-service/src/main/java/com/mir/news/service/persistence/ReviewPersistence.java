package com.mir.news.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.mir.news.model.Review;

/**
 * The persistence interface for the review service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReviewPersistenceImpl
 * @see ReviewUtil
 * @generated
 */
public interface ReviewPersistence extends BasePersistence<Review> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ReviewUtil} to access the review persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the review in the entity cache if it is enabled.
    *
    * @param review the review
    */
    public void cacheResult(com.mir.news.model.Review review);

    /**
    * Caches the reviews in the entity cache if it is enabled.
    *
    * @param reviews the reviews
    */
    public void cacheResult(java.util.List<com.mir.news.model.Review> reviews);

    /**
    * Creates a new review with the primary key. Does not add the review to the database.
    *
    * @param reviewId the primary key for the new review
    * @return the new review
    */
    public com.mir.news.model.Review create(long reviewId);

    /**
    * Removes the review with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param reviewId the primary key of the review
    * @return the review that was removed
    * @throws com.mir.news.NoSuchReviewException if a review with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.mir.news.model.Review remove(long reviewId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.mir.news.NoSuchReviewException;

    public com.mir.news.model.Review updateImpl(
        com.mir.news.model.Review review)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the review with the primary key or throws a {@link com.mir.news.NoSuchReviewException} if it could not be found.
    *
    * @param reviewId the primary key of the review
    * @return the review
    * @throws com.mir.news.NoSuchReviewException if a review with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.mir.news.model.Review findByPrimaryKey(long reviewId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.mir.news.NoSuchReviewException;

    /**
    * Returns the review with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param reviewId the primary key of the review
    * @return the review, or <code>null</code> if a review with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.mir.news.model.Review fetchByPrimaryKey(long reviewId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the reviews.
    *
    * @return the reviews
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.mir.news.model.Review> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.mir.news.model.Review> findAll(int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.mir.news.model.Review> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the reviews from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of reviews.
    *
    * @return the number of reviews
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the articles associated with the review.
    *
    * @param pk the primary key of the review
    * @return the articles associated with the review
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.mir.news.model.Article> getArticles(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.mir.news.model.Article> getArticles(long pk,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.mir.news.model.Article> getArticles(long pk,
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of articles associated with the review.
    *
    * @param pk the primary key of the review
    * @return the number of articles associated with the review
    * @throws SystemException if a system exception occurred
    */
    public int getArticlesSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the article is associated with the review.
    *
    * @param pk the primary key of the review
    * @param articlePK the primary key of the article
    * @return <code>true</code> if the article is associated with the review; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsArticle(long pk, long articlePK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the review has any articles associated with it.
    *
    * @param pk the primary key of the review to check for associations with articles
    * @return <code>true</code> if the review has any articles associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsArticles(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the review and the article. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the review
    * @param articlePK the primary key of the article
    * @throws SystemException if a system exception occurred
    */
    public void addArticle(long pk, long articlePK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the review and the article. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the review
    * @param article the article
    * @throws SystemException if a system exception occurred
    */
    public void addArticle(long pk, com.mir.news.model.Article article)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the review and the articles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the review
    * @param articlePKs the primary keys of the articles
    * @throws SystemException if a system exception occurred
    */
    public void addArticles(long pk, long[] articlePKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the review and the articles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the review
    * @param articles the articles
    * @throws SystemException if a system exception occurred
    */
    public void addArticles(long pk,
        java.util.List<com.mir.news.model.Article> articles)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Clears all associations between the review and its articles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the review to clear the associated articles from
    * @throws SystemException if a system exception occurred
    */
    public void clearArticles(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the review and the article. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the review
    * @param articlePK the primary key of the article
    * @throws SystemException if a system exception occurred
    */
    public void removeArticle(long pk, long articlePK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the review and the article. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the review
    * @param article the article
    * @throws SystemException if a system exception occurred
    */
    public void removeArticle(long pk, com.mir.news.model.Article article)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the review and the articles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the review
    * @param articlePKs the primary keys of the articles
    * @throws SystemException if a system exception occurred
    */
    public void removeArticles(long pk, long[] articlePKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the review and the articles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the review
    * @param articles the articles
    * @throws SystemException if a system exception occurred
    */
    public void removeArticles(long pk,
        java.util.List<com.mir.news.model.Article> articles)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Sets the articles associated with the review, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the review
    * @param articlePKs the primary keys of the articles to be associated with the review
    * @throws SystemException if a system exception occurred
    */
    public void setArticles(long pk, long[] articlePKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Sets the articles associated with the review, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the review
    * @param articles the articles to be associated with the review
    * @throws SystemException if a system exception occurred
    */
    public void setArticles(long pk,
        java.util.List<com.mir.news.model.Article> articles)
        throws com.liferay.portal.kernel.exception.SystemException;
}
