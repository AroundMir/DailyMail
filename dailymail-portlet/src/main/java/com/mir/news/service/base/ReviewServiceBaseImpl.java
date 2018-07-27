package com.mir.news.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import com.mir.news.model.Review;
import com.mir.news.service.ReviewService;
import com.mir.news.service.persistence.ArticlePersistence;
import com.mir.news.service.persistence.ReviewPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the review remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.mir.news.service.impl.ReviewServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.mir.news.service.impl.ReviewServiceImpl
 * @see com.mir.news.service.ReviewServiceUtil
 * @generated
 */
public abstract class ReviewServiceBaseImpl extends BaseServiceImpl
    implements ReviewService, IdentifiableBean {
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
    private ReviewServiceClpInvoker _clpInvoker = new ReviewServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link com.mir.news.service.ReviewServiceUtil} to access the review remote service.
     */

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
    }

    public void destroy() {
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