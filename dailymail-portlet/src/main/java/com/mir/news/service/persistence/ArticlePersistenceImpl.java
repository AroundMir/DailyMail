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

import com.mir.news.NoSuchArticleException;
import com.mir.news.model.Article;
import com.mir.news.model.impl.ArticleImpl;
import com.mir.news.model.impl.ArticleModelImpl;
import com.mir.news.service.persistence.ArticlePersistence;
import com.mir.news.service.persistence.ReviewPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the article service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ArticlePersistence
 * @see ArticleUtil
 * @generated
 */
public class ArticlePersistenceImpl extends BasePersistenceImpl<Article>
    implements ArticlePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ArticleUtil} to access the article persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ArticleImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ArticleModelImpl.ENTITY_CACHE_ENABLED,
            ArticleModelImpl.FINDER_CACHE_ENABLED, ArticleImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ArticleModelImpl.ENTITY_CACHE_ENABLED,
            ArticleModelImpl.FINDER_CACHE_ENABLED, ArticleImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ArticleModelImpl.ENTITY_CACHE_ENABLED,
            ArticleModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_ARTICLE = "SELECT article FROM Article article";
    private static final String _SQL_COUNT_ARTICLE = "SELECT COUNT(article) FROM Article article";
    private static final String _ORDER_BY_ENTITY_ALIAS = "article.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Article exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ArticlePersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "text", "date"
            });
    private static Article _nullArticle = new ArticleImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Article> toCacheModel() {
                return _nullArticleCacheModel;
            }
        };

    private static CacheModel<Article> _nullArticleCacheModel = new CacheModel<Article>() {
            @Override
            public Article toEntityModel() {
                return _nullArticle;
            }
        };

    @BeanReference(type = ReviewPersistence.class)
    protected ReviewPersistence reviewPersistence;
    protected TableMapper<Article, com.mir.news.model.Review> articleToReviewTableMapper;

    public ArticlePersistenceImpl() {
        setModelClass(Article.class);
    }

    /**
     * Caches the article in the entity cache if it is enabled.
     *
     * @param article the article
     */
    @Override
    public void cacheResult(Article article) {
        EntityCacheUtil.putResult(ArticleModelImpl.ENTITY_CACHE_ENABLED,
            ArticleImpl.class, article.getPrimaryKey(), article);

        article.resetOriginalValues();
    }

    /**
     * Caches the articles in the entity cache if it is enabled.
     *
     * @param articles the articles
     */
    @Override
    public void cacheResult(List<Article> articles) {
        for (Article article : articles) {
            if (EntityCacheUtil.getResult(
                        ArticleModelImpl.ENTITY_CACHE_ENABLED,
                        ArticleImpl.class, article.getPrimaryKey()) == null) {
                cacheResult(article);
            } else {
                article.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all articles.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ArticleImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ArticleImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the article.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Article article) {
        EntityCacheUtil.removeResult(ArticleModelImpl.ENTITY_CACHE_ENABLED,
            ArticleImpl.class, article.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Article> articles) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Article article : articles) {
            EntityCacheUtil.removeResult(ArticleModelImpl.ENTITY_CACHE_ENABLED,
                ArticleImpl.class, article.getPrimaryKey());
        }
    }

    /**
     * Creates a new article with the primary key. Does not add the article to the database.
     *
     * @param articleId the primary key for the new article
     * @return the new article
     */
    @Override
    public Article create(long articleId) {
        Article article = new ArticleImpl();

        article.setNew(true);
        article.setPrimaryKey(articleId);

        return article;
    }

    /**
     * Removes the article with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param articleId the primary key of the article
     * @return the article that was removed
     * @throws com.mir.news.NoSuchArticleException if a article with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Article remove(long articleId)
        throws NoSuchArticleException, SystemException {
        return remove((Serializable) articleId);
    }

    /**
     * Removes the article with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the article
     * @return the article that was removed
     * @throws com.mir.news.NoSuchArticleException if a article with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Article remove(Serializable primaryKey)
        throws NoSuchArticleException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Article article = (Article) session.get(ArticleImpl.class,
                    primaryKey);

            if (article == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchArticleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(article);
        } catch (NoSuchArticleException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Article removeImpl(Article article) throws SystemException {
        article = toUnwrappedModel(article);

        articleToReviewTableMapper.deleteLeftPrimaryKeyTableMappings(article.getPrimaryKey());

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(article)) {
                article = (Article) session.get(ArticleImpl.class,
                        article.getPrimaryKeyObj());
            }

            if (article != null) {
                session.delete(article);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (article != null) {
            clearCache(article);
        }

        return article;
    }

    @Override
    public Article updateImpl(com.mir.news.model.Article article)
        throws SystemException {
        article = toUnwrappedModel(article);

        boolean isNew = article.isNew();

        Session session = null;

        try {
            session = openSession();

            if (article.isNew()) {
                session.save(article);

                article.setNew(false);
            } else {
                session.merge(article);
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

        EntityCacheUtil.putResult(ArticleModelImpl.ENTITY_CACHE_ENABLED,
            ArticleImpl.class, article.getPrimaryKey(), article);

        return article;
    }

    protected Article toUnwrappedModel(Article article) {
        if (article instanceof ArticleImpl) {
            return article;
        }

        ArticleImpl articleImpl = new ArticleImpl();

        articleImpl.setNew(article.isNew());
        articleImpl.setPrimaryKey(article.getPrimaryKey());

        articleImpl.setArticleId(article.getArticleId());
        articleImpl.setAuthorId(article.getAuthorId());
        articleImpl.setName(article.getName());
        articleImpl.setText(article.getText());
        articleImpl.setDate(article.getDate());
        articleImpl.setStatus(article.getStatus());

        return articleImpl;
    }

    /**
     * Returns the article with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the article
     * @return the article
     * @throws com.mir.news.NoSuchArticleException if a article with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Article findByPrimaryKey(Serializable primaryKey)
        throws NoSuchArticleException, SystemException {
        Article article = fetchByPrimaryKey(primaryKey);

        if (article == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchArticleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return article;
    }

    /**
     * Returns the article with the primary key or throws a {@link com.mir.news.NoSuchArticleException} if it could not be found.
     *
     * @param articleId the primary key of the article
     * @return the article
     * @throws com.mir.news.NoSuchArticleException if a article with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Article findByPrimaryKey(long articleId)
        throws NoSuchArticleException, SystemException {
        return findByPrimaryKey((Serializable) articleId);
    }

    /**
     * Returns the article with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the article
     * @return the article, or <code>null</code> if a article with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Article fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Article article = (Article) EntityCacheUtil.getResult(ArticleModelImpl.ENTITY_CACHE_ENABLED,
                ArticleImpl.class, primaryKey);

        if (article == _nullArticle) {
            return null;
        }

        if (article == null) {
            Session session = null;

            try {
                session = openSession();

                article = (Article) session.get(ArticleImpl.class, primaryKey);

                if (article != null) {
                    cacheResult(article);
                } else {
                    EntityCacheUtil.putResult(ArticleModelImpl.ENTITY_CACHE_ENABLED,
                        ArticleImpl.class, primaryKey, _nullArticle);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(ArticleModelImpl.ENTITY_CACHE_ENABLED,
                    ArticleImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return article;
    }

    /**
     * Returns the article with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param articleId the primary key of the article
     * @return the article, or <code>null</code> if a article with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Article fetchByPrimaryKey(long articleId) throws SystemException {
        return fetchByPrimaryKey((Serializable) articleId);
    }

    /**
     * Returns all the articles.
     *
     * @return the articles
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Article> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<Article> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
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
    @Override
    public List<Article> findAll(int start, int end,
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

        List<Article> list = (List<Article>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_ARTICLE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_ARTICLE;

                if (pagination) {
                    sql = sql.concat(ArticleModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Article>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Article>(list);
                } else {
                    list = (List<Article>) QueryUtil.list(q, getDialect(),
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
     * Removes all the articles from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Article article : findAll()) {
            remove(article);
        }
    }

    /**
     * Returns the number of articles.
     *
     * @return the number of articles
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

                Query q = session.createQuery(_SQL_COUNT_ARTICLE);

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
     * Returns all the reviews associated with the article.
     *
     * @param pk the primary key of the article
     * @return the reviews associated with the article
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<com.mir.news.model.Review> getReviews(long pk)
        throws SystemException {
        return getReviews(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
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
    @Override
    public List<com.mir.news.model.Review> getReviews(long pk, int start,
        int end) throws SystemException {
        return getReviews(pk, start, end, null);
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
    @Override
    public List<com.mir.news.model.Review> getReviews(long pk, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        return articleToReviewTableMapper.getRightBaseModels(pk, start, end,
            orderByComparator);
    }

    /**
     * Returns the number of reviews associated with the article.
     *
     * @param pk the primary key of the article
     * @return the number of reviews associated with the article
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getReviewsSize(long pk) throws SystemException {
        long[] pks = articleToReviewTableMapper.getRightPrimaryKeys(pk);

        return pks.length;
    }

    /**
     * Returns <code>true</code> if the review is associated with the article.
     *
     * @param pk the primary key of the article
     * @param reviewPK the primary key of the review
     * @return <code>true</code> if the review is associated with the article; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    @Override
    public boolean containsReview(long pk, long reviewPK)
        throws SystemException {
        return articleToReviewTableMapper.containsTableMapping(pk, reviewPK);
    }

    /**
     * Returns <code>true</code> if the article has any reviews associated with it.
     *
     * @param pk the primary key of the article to check for associations with reviews
     * @return <code>true</code> if the article has any reviews associated with it; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    @Override
    public boolean containsReviews(long pk) throws SystemException {
        if (getReviewsSize(pk) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds an association between the article and the review. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the article
     * @param reviewPK the primary key of the review
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addReview(long pk, long reviewPK) throws SystemException {
        articleToReviewTableMapper.addTableMapping(pk, reviewPK);
    }

    /**
     * Adds an association between the article and the review. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the article
     * @param review the review
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addReview(long pk, com.mir.news.model.Review review)
        throws SystemException {
        articleToReviewTableMapper.addTableMapping(pk, review.getPrimaryKey());
    }

    /**
     * Adds an association between the article and the reviews. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the article
     * @param reviewPKs the primary keys of the reviews
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addReviews(long pk, long[] reviewPKs) throws SystemException {
        for (long reviewPK : reviewPKs) {
            articleToReviewTableMapper.addTableMapping(pk, reviewPK);
        }
    }

    /**
     * Adds an association between the article and the reviews. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the article
     * @param reviews the reviews
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addReviews(long pk, List<com.mir.news.model.Review> reviews)
        throws SystemException {
        for (com.mir.news.model.Review review : reviews) {
            articleToReviewTableMapper.addTableMapping(pk,
                review.getPrimaryKey());
        }
    }

    /**
     * Clears all associations between the article and its reviews. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the article to clear the associated reviews from
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void clearReviews(long pk) throws SystemException {
        articleToReviewTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
    }

    /**
     * Removes the association between the article and the review. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the article
     * @param reviewPK the primary key of the review
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeReview(long pk, long reviewPK) throws SystemException {
        articleToReviewTableMapper.deleteTableMapping(pk, reviewPK);
    }

    /**
     * Removes the association between the article and the review. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the article
     * @param review the review
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeReview(long pk, com.mir.news.model.Review review)
        throws SystemException {
        articleToReviewTableMapper.deleteTableMapping(pk, review.getPrimaryKey());
    }

    /**
     * Removes the association between the article and the reviews. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the article
     * @param reviewPKs the primary keys of the reviews
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeReviews(long pk, long[] reviewPKs)
        throws SystemException {
        for (long reviewPK : reviewPKs) {
            articleToReviewTableMapper.deleteTableMapping(pk, reviewPK);
        }
    }

    /**
     * Removes the association between the article and the reviews. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the article
     * @param reviews the reviews
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeReviews(long pk, List<com.mir.news.model.Review> reviews)
        throws SystemException {
        for (com.mir.news.model.Review review : reviews) {
            articleToReviewTableMapper.deleteTableMapping(pk,
                review.getPrimaryKey());
        }
    }

    /**
     * Sets the reviews associated with the article, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the article
     * @param reviewPKs the primary keys of the reviews to be associated with the article
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void setReviews(long pk, long[] reviewPKs) throws SystemException {
        Set<Long> newReviewPKsSet = SetUtil.fromArray(reviewPKs);
        Set<Long> oldReviewPKsSet = SetUtil.fromArray(articleToReviewTableMapper.getRightPrimaryKeys(
                    pk));

        Set<Long> removeReviewPKsSet = new HashSet<Long>(oldReviewPKsSet);

        removeReviewPKsSet.removeAll(newReviewPKsSet);

        for (long removeReviewPK : removeReviewPKsSet) {
            articleToReviewTableMapper.deleteTableMapping(pk, removeReviewPK);
        }

        newReviewPKsSet.removeAll(oldReviewPKsSet);

        for (long newReviewPK : newReviewPKsSet) {
            articleToReviewTableMapper.addTableMapping(pk, newReviewPK);
        }
    }

    /**
     * Sets the reviews associated with the article, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the article
     * @param reviews the reviews to be associated with the article
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void setReviews(long pk, List<com.mir.news.model.Review> reviews)
        throws SystemException {
        try {
            long[] reviewPKs = new long[reviews.size()];

            for (int i = 0; i < reviews.size(); i++) {
                com.mir.news.model.Review review = reviews.get(i);

                reviewPKs[i] = review.getPrimaryKey();
            }

            setReviews(pk, reviewPKs);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(ArticleModelImpl.MAPPING_TABLE_DAILYMAIL_ARTICLES_REVIEWS_NAME);
        }
    }

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the article persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.mir.news.model.Article")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Article>> listenersList = new ArrayList<ModelListener<Article>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Article>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }

        articleToReviewTableMapper = TableMapperFactory.getTableMapper("dailymail_Articles_Reviews",
                "articleId", "reviewId", this, reviewPersistence);
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ArticleImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
