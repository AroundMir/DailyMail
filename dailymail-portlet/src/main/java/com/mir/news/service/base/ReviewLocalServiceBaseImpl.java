package com.mir.news.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import com.mir.news.model.Review;
import com.mir.news.service.ReviewLocalService;
import com.mir.news.service.persistence.ArticlePersistence;
import com.mir.news.service.persistence.ReviewPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the review local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.mir.news.service.impl.ReviewLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.mir.news.service.impl.ReviewLocalServiceImpl
 * @see com.mir.news.service.ReviewLocalServiceUtil
 * @generated
 */
public abstract class ReviewLocalServiceBaseImpl extends BaseLocalServiceImpl
    implements ReviewLocalService, IdentifiableBean {
    @BeanReference(type = com.mir.news.service.ArticleLocalService.class)
    protected com.mir.news.service.ArticleLocalService articleLocalService;
    @BeanReference(type = com.mir.news.service.ArticleService.class)
    protected com.mir.news.service.ArticleService articleService;
    @BeanReference(type = ArticlePersistence.class)
    protected ArticlePersistence articlePersistence;
    @BeanReference(type = com.mir.news.service.ReviewLocalService.class)
    protected com.mir.news.service.ReviewLocalService reviewLocalService;
    @BeanReference(type = com.mir.news.service.ReviewService.class)
    protected com.mir.news.service.ReviewService reviewService;
    @BeanReference(type = ReviewPersistence.class)
    protected ReviewPersistence reviewPersistence;
    @BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
    protected com.liferay.counter.service.CounterLocalService counterLocalService;
    @BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
    protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
    @BeanReference(type = com.liferay.portal.service.UserLocalService.class)
    protected com.liferay.portal.service.UserLocalService userLocalService;
    @BeanReference(type = com.liferay.portal.service.UserService.class)
    protected com.liferay.portal.service.UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    private String _beanIdentifier;
    private ClassLoader _classLoader;
    private ReviewLocalServiceClpInvoker _clpInvoker = new ReviewLocalServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link com.mir.news.service.ReviewLocalServiceUtil} to access the review local service.
     */

    /**
     * Adds the review to the database. Also notifies the appropriate model listeners.
     *
     * @param review the review
     * @return the review that was added
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public Review addReview(Review review) throws SystemException {
        review.setNew(true);

        return reviewPersistence.update(review);
    }

    /**
     * Creates a new review with the primary key. Does not add the review to the database.
     *
     * @param reviewId the primary key for the new review
     * @return the new review
     */
    @Override
    public Review createReview(long reviewId) {
        return reviewPersistence.create(reviewId);
    }

    /**
     * Deletes the review with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param reviewId the primary key of the review
     * @return the review that was removed
     * @throws PortalException if a review with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public Review deleteReview(long reviewId)
        throws PortalException, SystemException {
        return reviewPersistence.remove(reviewId);
    }

    /**
     * Deletes the review from the database. Also notifies the appropriate model listeners.
     *
     * @param review the review
     * @return the review that was removed
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public Review deleteReview(Review review) throws SystemException {
        return reviewPersistence.remove(review);
    }

    @Override
    public DynamicQuery dynamicQuery() {
        Class<?> clazz = getClass();

        return DynamicQueryFactoryUtil.forClass(Review.class,
            clazz.getClassLoader());
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
    public List dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return reviewPersistence.findWithDynamicQuery(dynamicQuery);
    }

    /**
     * Performs a dynamic query on the database and returns a range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.mir.news.model.impl.ReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return reviewPersistence.findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * Performs a dynamic query on the database and returns an ordered range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.mir.news.model.impl.ReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return reviewPersistence.findWithDynamicQuery(dynamicQuery, start, end,
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
    public long dynamicQueryCount(DynamicQuery dynamicQuery)
        throws SystemException {
        return reviewPersistence.countWithDynamicQuery(dynamicQuery);
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
    public long dynamicQueryCount(DynamicQuery dynamicQuery,
        Projection projection) throws SystemException {
        return reviewPersistence.countWithDynamicQuery(dynamicQuery, projection);
    }

    @Override
    public Review fetchReview(long reviewId) throws SystemException {
        return reviewPersistence.fetchByPrimaryKey(reviewId);
    }

    /**
     * Returns the review with the primary key.
     *
     * @param reviewId the primary key of the review
     * @return the review
     * @throws PortalException if a review with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Review getReview(long reviewId)
        throws PortalException, SystemException {
        return reviewPersistence.findByPrimaryKey(reviewId);
    }

    @Override
    public PersistedModel getPersistedModel(Serializable primaryKeyObj)
        throws PortalException, SystemException {
        return reviewPersistence.findByPrimaryKey(primaryKeyObj);
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
    @Override
    public List<Review> getReviews(int start, int end)
        throws SystemException {
        return reviewPersistence.findAll(start, end);
    }

    /**
     * Returns the number of reviews.
     *
     * @return the number of reviews
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getReviewsCount() throws SystemException {
        return reviewPersistence.countAll();
    }

    /**
     * Updates the review in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
     *
     * @param review the review
     * @return the review that was updated
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public Review updateReview(Review review) throws SystemException {
        return reviewPersistence.update(review);
    }

    /**
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addArticleReview(long articleId, long reviewId)
        throws SystemException {
        articlePersistence.addReview(articleId, reviewId);
    }

    /**
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addArticleReview(long articleId, Review review)
        throws SystemException {
        articlePersistence.addReview(articleId, review);
    }

    /**
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addArticleReviews(long articleId, long[] reviewIds)
        throws SystemException {
        articlePersistence.addReviews(articleId, reviewIds);
    }

    /**
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addArticleReviews(long articleId, List<Review> Reviews)
        throws SystemException {
        articlePersistence.addReviews(articleId, Reviews);
    }

    /**
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void clearArticleReviews(long articleId) throws SystemException {
        articlePersistence.clearReviews(articleId);
    }

    /**
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void deleteArticleReview(long articleId, long reviewId)
        throws SystemException {
        articlePersistence.removeReview(articleId, reviewId);
    }

    /**
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void deleteArticleReview(long articleId, Review review)
        throws SystemException {
        articlePersistence.removeReview(articleId, review);
    }

    /**
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void deleteArticleReviews(long articleId, long[] reviewIds)
        throws SystemException {
        articlePersistence.removeReviews(articleId, reviewIds);
    }

    /**
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void deleteArticleReviews(long articleId, List<Review> Reviews)
        throws SystemException {
        articlePersistence.removeReviews(articleId, Reviews);
    }

    /**
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Review> getArticleReviews(long articleId)
        throws SystemException {
        return articlePersistence.getReviews(articleId);
    }

    /**
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Review> getArticleReviews(long articleId, int start, int end)
        throws SystemException {
        return articlePersistence.getReviews(articleId, start, end);
    }

    /**
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Review> getArticleReviews(long articleId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return articlePersistence.getReviews(articleId, start, end,
            orderByComparator);
    }

    /**
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getArticleReviewsCount(long articleId) throws SystemException {
        return articlePersistence.getReviewsSize(articleId);
    }

    /**
     * @throws SystemException if a system exception occurred
     */
    @Override
    public boolean hasArticleReview(long articleId, long reviewId)
        throws SystemException {
        return articlePersistence.containsReview(articleId, reviewId);
    }

    /**
     * @throws SystemException if a system exception occurred
     */
    @Override
    public boolean hasArticleReviews(long articleId) throws SystemException {
        return articlePersistence.containsReviews(articleId);
    }

    /**
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void setArticleReviews(long articleId, long[] reviewIds)
        throws SystemException {
        articlePersistence.setReviews(articleId, reviewIds);
    }

    /**
     * Returns the article local service.
     *
     * @return the article local service
     */
    public com.mir.news.service.ArticleLocalService getArticleLocalService() {
        return articleLocalService;
    }

    /**
     * Sets the article local service.
     *
     * @param articleLocalService the article local service
     */
    public void setArticleLocalService(
        com.mir.news.service.ArticleLocalService articleLocalService) {
        this.articleLocalService = articleLocalService;
    }

    /**
     * Returns the article remote service.
     *
     * @return the article remote service
     */
    public com.mir.news.service.ArticleService getArticleService() {
        return articleService;
    }

    /**
     * Sets the article remote service.
     *
     * @param articleService the article remote service
     */
    public void setArticleService(
        com.mir.news.service.ArticleService articleService) {
        this.articleService = articleService;
    }

    /**
     * Returns the article persistence.
     *
     * @return the article persistence
     */
    public ArticlePersistence getArticlePersistence() {
        return articlePersistence;
    }

    /**
     * Sets the article persistence.
     *
     * @param articlePersistence the article persistence
     */
    public void setArticlePersistence(ArticlePersistence articlePersistence) {
        this.articlePersistence = articlePersistence;
    }

    /**
     * Returns the review local service.
     *
     * @return the review local service
     */
    public com.mir.news.service.ReviewLocalService getReviewLocalService() {
        return reviewLocalService;
    }

    /**
     * Sets the review local service.
     *
     * @param reviewLocalService the review local service
     */
    public void setReviewLocalService(
        com.mir.news.service.ReviewLocalService reviewLocalService) {
        this.reviewLocalService = reviewLocalService;
    }

    /**
     * Returns the review remote service.
     *
     * @return the review remote service
     */
    public com.mir.news.service.ReviewService getReviewService() {
        return reviewService;
    }

    /**
     * Sets the review remote service.
     *
     * @param reviewService the review remote service
     */
    public void setReviewService(
        com.mir.news.service.ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    /**
     * Returns the review persistence.
     *
     * @return the review persistence
     */
    public ReviewPersistence getReviewPersistence() {
        return reviewPersistence;
    }

    /**
     * Sets the review persistence.
     *
     * @param reviewPersistence the review persistence
     */
    public void setReviewPersistence(ReviewPersistence reviewPersistence) {
        this.reviewPersistence = reviewPersistence;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(
        com.liferay.counter.service.CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        com.liferay.portal.service.ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public com.liferay.portal.service.UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(
        com.liferay.portal.service.UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public com.liferay.portal.service.UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(
        com.liferay.portal.service.UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public void afterPropertiesSet() {
        Class<?> clazz = getClass();

        _classLoader = clazz.getClassLoader();

        PersistedModelLocalServiceRegistryUtil.register("com.mir.news.model.Review",
            reviewLocalService);
    }

    public void destroy() {
        PersistedModelLocalServiceRegistryUtil.unregister(
            "com.mir.news.model.Review");
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    @Override
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    @Override
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    @Override
    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        if (contextClassLoader != _classLoader) {
            currentThread.setContextClassLoader(_classLoader);
        }

        try {
            return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
        } finally {
            if (contextClassLoader != _classLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    protected Class<?> getModelClass() {
        return Review.class;
    }

    protected String getModelClassName() {
        return Review.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = reviewPersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
