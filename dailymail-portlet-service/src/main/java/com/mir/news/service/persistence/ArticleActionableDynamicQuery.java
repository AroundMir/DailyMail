package com.mir.news.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.mir.news.model.Article;
import com.mir.news.service.ArticleLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class ArticleActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ArticleActionableDynamicQuery() throws SystemException {
        setBaseLocalService(ArticleLocalServiceUtil.getService());
        setClass(Article.class);

        setClassLoader(com.mir.news.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("articleId");
    }
}
