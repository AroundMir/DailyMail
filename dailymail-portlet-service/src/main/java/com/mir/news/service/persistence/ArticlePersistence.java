package com.mir.news.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.mir.news.model.Article;

/**
 * The persistence interface for the article service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ArticlePersistenceImpl
 * @see ArticleUtil
 * @generated
 */
public interface ArticlePersistence extends BasePersistence<Article> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ArticleUtil} to access the article persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the article in the entity cache if it is enabled.
    *
    * @param article the article
    */
    public void cacheResult(com.mir.news.model.Article article);

    /**
    * Caches the articles in the entity cache if it is enabled.
    *
    * @param articles the articles
    */
    public void cacheResult(java.util.List<com.mir.news.model.Article> articles);

    /**
    * Creates a new article with the primary key. Does not add the article to the database.
    *
    * @param articleId the primary key for the new article
    * @return the new article
    */
    public com.mir.news.model.Article create(long articleId);

    /**
    * Removes the article with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param articleId the primary key of the article
    * @return the article that was removed
    * @throws com.mir.news.NoSuchArticleException if a article with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.mir.news.model.Article remove(long articleId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.mir.news.NoSuchArticleException;

    public com.mir.news.model.Article updateImpl(
        com.mir.news.model.Article article)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the article with the primary key or throws a {@link com.mir.news.NoSuchArticleException} if it could not be found.
    *
    * @param articleId the primary key of the article
    * @return the article
    * @throws com.mir.news.NoSuchArticleException if a article with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.mir.news.model.Article findByPrimaryKey(long articleId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.mir.news.NoSuchArticleException;

    /**
    * Returns the article with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param articleId the primary key of the article
    * @return the article, or <code>null</code> if a article with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.mir.news.model.Article fetchByPrimaryKey(long articleId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the articles.
    *
    * @return the articles
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.mir.news.model.Article> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.mir.news.model.Article> findAll(int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.mir.news.model.Article> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the articles from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of articles.
    *
    * @return the number of articles
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the reviews associated with the article.
    *
    * @param pk the primary key of the article
    * @return the reviews associated with the article
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.mir.news.model.Review> getReviews(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.mir.news.model.Review> getReviews(long pk,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.mir.news.model.Review> getReviews(long pk,
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of reviews associated with the article.
    *
    * @param pk the primary key of the article
    * @return the number of reviews associated with the article
    * @throws SystemException if a system exception occurred
    */
    public int getReviewsSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the review is associated with the article.
    *
    * @param pk the primary key of the article
    * @param reviewPK the primary key of the review
    * @return <code>true</code> if the review is associated with the article; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsReview(long pk, long reviewPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the article has any reviews associated with it.
    *
    * @param pk the primary key of the article to check for associations with reviews
    * @return <code>true</code> if the article has any reviews associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsReviews(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the article and the review. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the article
    * @param reviewPK the primary key of the review
    * @throws SystemException if a system exception occurred
    */
    public void addReview(long pk, long reviewPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the article and the review. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the article
    * @param review the review
    * @throws SystemException if a system exception occurred
    */
    public void addReview(long pk, com.mir.news.model.Review review)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the article and the reviews. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the article
    * @param reviewPKs the primary keys of the reviews
    * @throws SystemException if a system exception occurred
    */
    public void addReviews(long pk, long[] reviewPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the article and the reviews. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the article
    * @param reviews the reviews
    * @throws SystemException if a system exception occurred
    */
    public void addReviews(long pk,
        java.util.List<com.mir.news.model.Review> reviews)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Clears all associations between the article and its reviews. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the article to clear the associated reviews from
    * @throws SystemException if a system exception occurred
    */
    public void clearReviews(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the article and the review. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the article
    * @param reviewPK the primary key of the review
    * @throws SystemException if a system exception occurred
    */
    public void removeReview(long pk, long reviewPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the article and the review. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the article
    * @param review the review
    * @throws SystemException if a system exception occurred
    */
    public void removeReview(long pk, com.mir.news.model.Review review)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the article and the reviews. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the article
    * @param reviewPKs the primary keys of the reviews
    * @throws SystemException if a system exception occurred
    */
    public void removeReviews(long pk, long[] reviewPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the article and the reviews. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the article
    * @param reviews the reviews
    * @throws SystemException if a system exception occurred
    */
    public void removeReviews(long pk,
        java.util.List<com.mir.news.model.Review> reviews)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Sets the reviews associated with the article, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the article
    * @param reviewPKs the primary keys of the reviews to be associated with the article
    * @throws SystemException if a system exception occurred
    */
    public void setReviews(long pk, long[] reviewPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Sets the reviews associated with the article, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the article
    * @param reviews the reviews to be associated with the article
    * @throws SystemException if a system exception occurred
    */
    public void setReviews(long pk,
        java.util.List<com.mir.news.model.Review> reviews)
        throws com.liferay.portal.kernel.exception.SystemException;
}
