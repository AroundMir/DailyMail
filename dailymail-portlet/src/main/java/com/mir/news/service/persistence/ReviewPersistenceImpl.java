package com.mir.news.service.persistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.service.persistence.impl.TableMapper;
import com.liferay.portal.service.persistence.impl.TableMapperFactory;

import com.mir.news.NoSuchReviewException;
import com.mir.news.model.Review;
import com.mir.news.model.impl.ReviewImpl;
import com.mir.news.model.impl.ReviewModelImpl;
import com.mir.news.service.persistence.ArticlePersistence;
import com.mir.news.service.persistence.ReviewPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the review service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReviewPersistence
 * @see ReviewUtil
 * @generated
 */
public class ReviewPersistenceImpl extends BasePersistenceImpl<Review>
    implements ReviewPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ReviewUtil} to access the review persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ReviewImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ReviewModelImpl.ENTITY_CACHE_ENABLED,
            ReviewModelImpl.FINDER_CACHE_ENABLED, ReviewImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ReviewModelImpl.ENTITY_CACHE_ENABLED,
            ReviewModelImpl.FINDER_CACHE_ENABLED, ReviewImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ReviewModelImpl.ENTITY_CACHE_ENABLED,
            ReviewModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_REVIEW = "SELECT review FROM Review review";
    private static final String _SQL_COUNT_REVIEW = "SELECT COUNT(review) FROM Review review";
    private static final String _ORDER_BY_ENTITY_ALIAS = "review.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Review exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ReviewPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "text"
            });
    private static Review _nullReview = new ReviewImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Review> toCacheModel() {
                return _nullReviewCacheModel;
            }
        };

    private static CacheModel<Review> _nullReviewCacheModel = new CacheModel<Review>() {
            @Override
            public Review toEntityModel() {
                return _nullReview;
            }
        };

    @BeanReference(type = ArticlePersistence.class)
    protected ArticlePersistence articlePersistence;
    protected TableMapper<Review, com.mir.news.model.Article> reviewToArticleTableMapper;

    public ReviewPersistenceImpl() {
        setModelClass(Review.class);
    }

    /**
     * Caches the review in the entity cache if it is enabled.
     *
     * @param review the review
     */
    @Override
    public void cacheResult(Review review) {
        EntityCacheUtil.putResult(ReviewModelImpl.ENTITY_CACHE_ENABLED,
            ReviewImpl.class, review.getPrimaryKey(), review);

        review.resetOriginalValues();
    }

    /**
     * Caches the reviews in the entity cache if it is enabled.
     *
     * @param reviews the reviews
     */
    @Override
    public void cacheResult(List<Review> reviews) {
        for (Review review : reviews) {
            if (EntityCacheUtil.getResult(
                        ReviewModelImpl.ENTITY_CACHE_ENABLED, ReviewImpl.class,
                        review.getPrimaryKey()) == null) {
                cacheResult(review);
            } else {
                review.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all reviews.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ReviewImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ReviewImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the review.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Review review) {
        EntityCacheUtil.removeResult(ReviewModelImpl.ENTITY_CACHE_ENABLED,
            ReviewImpl.class, review.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Review> reviews) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Review review : reviews) {
            EntityCacheUtil.removeResult(ReviewModelImpl.ENTITY_CACHE_ENABLED,
                ReviewImpl.class, review.getPrimaryKey());
        }
    }

    /**
     * Creates a new review with the primary key. Does not add the review to the database.
     *
     * @param reviewId the primary key for the new review
     * @return the new review
     */
    @Override
    public Review create(long reviewId) {
        Review review = new ReviewImpl();

        review.setNew(true);
        review.setPrimaryKey(reviewId);

        return review;
    }

    /**
     * Removes the review with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param reviewId the primary key of the review
     * @return the review that was removed
     * @throws com.mir.news.NoSuchReviewException if a review with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Review remove(long reviewId)
        throws NoSuchReviewException, SystemException {
        return remove((Serializable) reviewId);
    }

    /**
     * Removes the review with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the review
     * @return the review that was removed
     * @throws com.mir.news.NoSuchReviewException if a review with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Review remove(Serializable primaryKey)
        throws NoSuchReviewException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Review review = (Review) session.get(ReviewImpl.class, primaryKey);

            if (review == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchReviewException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(review);
        } catch (NoSuchReviewException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Review removeImpl(Review review) throws SystemException {
        review = toUnwrappedModel(review);

        reviewToArticleTableMapper.deleteLeftPrimaryKeyTableMappings(review.getPrimaryKey());

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(review)) {
                review = (Review) session.get(ReviewImpl.class,
                        review.getPrimaryKeyObj());
            }

            if (review != null) {
                session.delete(review);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (review != null) {
            clearCache(review);
        }

        return review;
    }

    @Override
    public Review updateImpl(com.mir.news.model.Review review)
        throws SystemException {
        review = toUnwrappedModel(review);

        boolean isNew = review.isNew();

        Session session = null;

        try {
            session = openSession();

            if (review.isNew()) {
                session.save(review);

                review.setNew(false);
            } else {
                session.merge(review);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(ReviewModelImpl.ENTITY_CACHE_ENABLED,
            ReviewImpl.class, review.getPrimaryKey(), review);

        return review;
    }

    protected Review toUnwrappedModel(Review review) {
        if (review instanceof ReviewImpl) {
            return review;
        }

        ReviewImpl reviewImpl = new ReviewImpl();

        reviewImpl.setNew(review.isNew());
        reviewImpl.setPrimaryKey(review.getPrimaryKey());

        reviewImpl.setReviewId(review.getReviewId());
        reviewImpl.setReviewerId(review.getReviewerId());
        reviewImpl.setName(review.getName());
        reviewImpl.setText(review.getText());

        return reviewImpl;
    }

    /**
     * Returns the review with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the review
     * @return the review
     * @throws com.mir.news.NoSuchReviewException if a review with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Review findByPrimaryKey(Serializable primaryKey)
        throws NoSuchReviewException, SystemException {
        Review review = fetchByPrimaryKey(primaryKey);

        if (review == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchReviewException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return review;
    }

    /**
     * Returns the review with the primary key or throws a {@link com.mir.news.NoSuchReviewException} if it could not be found.
     *
     * @param reviewId the primary key of the review
     * @return the review
     * @throws com.mir.news.NoSuchReviewException if a review with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Review findByPrimaryKey(long reviewId)
        throws NoSuchReviewException, SystemException {
        return findByPrimaryKey((Serializable) reviewId);
    }

    /**
     * Returns the review with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the review
     * @return the review, or <code>null</code> if a review with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Review fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Review review = (Review) EntityCacheUtil.getResult(ReviewModelImpl.ENTITY_CACHE_ENABLED,
                ReviewImpl.class, primaryKey);

        if (review == _nullReview) {
            return null;
        }

        if (review == null) {
            Session session = null;

            try {
                session = openSession();

                review = (Review) session.get(ReviewImpl.class, primaryKey);

                if (review != null) {
                    cacheResult(review);
                } else {
                    EntityCacheUtil.putResult(ReviewModelImpl.ENTITY_CACHE_ENABLED,
                        ReviewImpl.class, primaryKey, _nullReview);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(ReviewModelImpl.ENTITY_CACHE_ENABLED,
                    ReviewImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return review;
    }

    /**
     * Returns the review with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param reviewId the primary key of the review
     * @return the review, or <code>null</code> if a review with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Review fetchByPrimaryKey(long reviewId) throws SystemException {
        return fetchByPrimaryKey((Serializable) reviewId);
    }

    /**
     * Returns all the reviews.
     *
     * @return the reviews
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Review> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<Review> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
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
    @Override
    public List<Review> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Review> list = (List<Review>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_REVIEW);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_REVIEW;

                if (pagination) {
                    sql = sql.concat(ReviewModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Review>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Review>(list);
                } else {
                    list = (List<Review>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the reviews from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Review review : findAll()) {
            remove(review);
        }
    }

    /**
     * Returns the number of reviews.
     *
     * @return the number of reviews
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_REVIEW);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the articles associated with the review.
     *
     * @param pk the primary key of the review
     * @return the articles associated with the review
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<com.mir.news.model.Article> getArticles(long pk)
        throws SystemException {
        return getArticles(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
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
    @Override
    public List<com.mir.news.model.Article> getArticles(long pk, int start,
        int end) throws SystemException {
        return getArticles(pk, start, end, null);
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
    @Override
    public List<com.mir.news.model.Article> getArticles(long pk, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        return reviewToArticleTableMapper.getRightBaseModels(pk, start, end,
            orderByComparator);
    }

    /**
     * Returns the number of articles associated with the review.
     *
     * @param pk the primary key of the review
     * @return the number of articles associated with the review
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getArticlesSize(long pk) throws SystemException {
        long[] pks = reviewToArticleTableMapper.getRightPrimaryKeys(pk);

        return pks.length;
    }

    /**
     * Returns <code>true</code> if the article is associated with the review.
     *
     * @param pk the primary key of the review
     * @param articlePK the primary key of the article
     * @return <code>true</code> if the article is associated with the review; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    @Override
    public boolean containsArticle(long pk, long articlePK)
        throws SystemException {
        return reviewToArticleTableMapper.containsTableMapping(pk, articlePK);
    }

    /**
     * Returns <code>true</code> if the review has any articles associated with it.
     *
     * @param pk the primary key of the review to check for associations with articles
     * @return <code>true</code> if the review has any articles associated with it; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    @Override
    public boolean containsArticles(long pk) throws SystemException {
        if (getArticlesSize(pk) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds an association between the review and the article. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the review
     * @param articlePK the primary key of the article
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addArticle(long pk, long articlePK) throws SystemException {
        reviewToArticleTableMapper.addTableMapping(pk, articlePK);
    }

    /**
     * Adds an association between the review and the article. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the review
     * @param article the article
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addArticle(long pk, com.mir.news.model.Article article)
        throws SystemException {
        reviewToArticleTableMapper.addTableMapping(pk, article.getPrimaryKey());
    }

    /**
     * Adds an association between the review and the articles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the review
     * @param articlePKs the primary keys of the articles
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addArticles(long pk, long[] articlePKs)
        throws SystemException {
        for (long articlePK : articlePKs) {
            reviewToArticleTableMapper.addTableMapping(pk, articlePK);
        }
    }

    /**
     * Adds an association between the review and the articles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the review
     * @param articles the articles
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addArticles(long pk, List<com.mir.news.model.Article> articles)
        throws SystemException {
        for (com.mir.news.model.Article article : articles) {
            reviewToArticleTableMapper.addTableMapping(pk,
                article.getPrimaryKey());
        }
    }

    /**
     * Clears all associations between the review and its articles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the review to clear the associated articles from
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void clearArticles(long pk) throws SystemException {
        reviewToArticleTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
    }

    /**
     * Removes the association between the review and the article. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the review
     * @param articlePK the primary key of the article
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeArticle(long pk, long articlePK)
        throws SystemException {
        reviewToArticleTableMapper.deleteTableMapping(pk, articlePK);
    }

    /**
     * Removes the association between the review and the article. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the review
     * @param article the article
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeArticle(long pk, com.mir.news.model.Article article)
        throws SystemException {
        reviewToArticleTableMapper.deleteTableMapping(pk,
            article.getPrimaryKey());
    }

    /**
     * Removes the association between the review and the articles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the review
     * @param articlePKs the primary keys of the articles
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeArticles(long pk, long[] articlePKs)
        throws SystemException {
        for (long articlePK : articlePKs) {
            reviewToArticleTableMapper.deleteTableMapping(pk, articlePK);
        }
    }

    /**
     * Removes the association between the review and the articles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the review
     * @param articles the articles
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeArticles(long pk,
        List<com.mir.news.model.Article> articles) throws SystemException {
        for (com.mir.news.model.Article article : articles) {
            reviewToArticleTableMapper.deleteTableMapping(pk,
                article.getPrimaryKey());
        }
    }

    /**
     * Sets the articles associated with the review, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the review
     * @param articlePKs the primary keys of the articles to be associated with the review
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void setArticles(long pk, long[] articlePKs)
        throws SystemException {
        Set<Long> newArticlePKsSet = SetUtil.fromArray(articlePKs);
        Set<Long> oldArticlePKsSet = SetUtil.fromArray(reviewToArticleTableMapper.getRightPrimaryKeys(
                    pk));

        Set<Long> removeArticlePKsSet = new HashSet<Long>(oldArticlePKsSet);

        removeArticlePKsSet.removeAll(newArticlePKsSet);

        for (long removeArticlePK : removeArticlePKsSet) {
            reviewToArticleTableMapper.deleteTableMapping(pk, removeArticlePK);
        }

        newArticlePKsSet.removeAll(oldArticlePKsSet);

        for (long newArticlePK : newArticlePKsSet) {
            reviewToArticleTableMapper.addTableMapping(pk, newArticlePK);
        }
    }

    /**
     * Sets the articles associated with the review, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the review
     * @param articles the articles to be associated with the review
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void setArticles(long pk, List<com.mir.news.model.Article> articles)
        throws SystemException {
        try {
            long[] articlePKs = new long[articles.size()];

            for (int i = 0; i < articles.size(); i++) {
                com.mir.news.model.Article article = articles.get(i);

                articlePKs[i] = article.getPrimaryKey();
            }

            setArticles(pk, articlePKs);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(ReviewModelImpl.MAPPING_TABLE_DAILYMAIL_ARTICLES_REVIEWS_NAME);
        }
    }

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the review persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.mir.news.model.Review")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Review>> listenersList = new ArrayList<ModelListener<Review>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Review>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }

        reviewToArticleTableMapper = TableMapperFactory.getTableMapper("dailymail_Articles_Reviews",
                "reviewId", "articleId", this, articlePersistence);
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ReviewImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
