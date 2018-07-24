package com.mir.news.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.mir.news.model.Review;
import com.mir.news.service.ReviewLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class ReviewActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ReviewActionableDynamicQuery() throws SystemException {
        setBaseLocalService(ReviewLocalServiceUtil.getService());
        setClass(Review.class);

        setClassLoader(com.mir.news.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("reviewId");
    }
}
