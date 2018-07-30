package com.mir.news.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Review}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Review
 * @generated
 */
public class ReviewWrapper implements Review, ModelWrapper<Review> {
    private Review _review;

    public ReviewWrapper(Review review) {
        _review = review;
    }

    @Override
    public Class<?> getModelClass() {
        return Review.class;
    }

    @Override
    public String getModelClassName() {
        return Review.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("reviewId", getReviewId());
        attributes.put("reviewerId", getReviewerId());
        attributes.put("imgUrl", getImgUrl());
        attributes.put("name", getName());
        attributes.put("text", getText());
        attributes.put("date", getDate());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long reviewId = (Long) attributes.get("reviewId");

        if (reviewId != null) {
            setReviewId(reviewId);
        }

        Long reviewerId = (Long) attributes.get("reviewerId");

        if (reviewerId != null) {
            setReviewerId(reviewerId);
        }

        String imgUrl = (String) attributes.get("imgUrl");

        if (imgUrl != null) {
            setImgUrl(imgUrl);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String text = (String) attributes.get("text");

        if (text != null) {
            setText(text);
        }

        Date date = (Date) attributes.get("date");

        if (date != null) {
            setDate(date);
        }
    }

    /**
    * Returns the primary key of this review.
    *
    * @return the primary key of this review
    */
    @Override
    public long getPrimaryKey() {
        return _review.getPrimaryKey();
    }

    /**
    * Sets the primary key of this review.
    *
    * @param primaryKey the primary key of this review
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _review.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the review ID of this review.
    *
    * @return the review ID of this review
    */
    @Override
    public long getReviewId() {
        return _review.getReviewId();
    }

    /**
    * Sets the review ID of this review.
    *
    * @param reviewId the review ID of this review
    */
    @Override
    public void setReviewId(long reviewId) {
        _review.setReviewId(reviewId);
    }

    /**
    * Returns the reviewer ID of this review.
    *
    * @return the reviewer ID of this review
    */
    @Override
    public long getReviewerId() {
        return _review.getReviewerId();
    }

    /**
    * Sets the reviewer ID of this review.
    *
    * @param reviewerId the reviewer ID of this review
    */
    @Override
    public void setReviewerId(long reviewerId) {
        _review.setReviewerId(reviewerId);
    }

    /**
    * Returns the img url of this review.
    *
    * @return the img url of this review
    */
    @Override
    public java.lang.String getImgUrl() {
        return _review.getImgUrl();
    }

    /**
    * Sets the img url of this review.
    *
    * @param imgUrl the img url of this review
    */
    @Override
    public void setImgUrl(java.lang.String imgUrl) {
        _review.setImgUrl(imgUrl);
    }

    /**
    * Returns the name of this review.
    *
    * @return the name of this review
    */
    @Override
    public java.lang.String getName() {
        return _review.getName();
    }

    /**
    * Sets the name of this review.
    *
    * @param name the name of this review
    */
    @Override
    public void setName(java.lang.String name) {
        _review.setName(name);
    }

    /**
    * Returns the text of this review.
    *
    * @return the text of this review
    */
    @Override
    public java.lang.String getText() {
        return _review.getText();
    }

    /**
    * Sets the text of this review.
    *
    * @param text the text of this review
    */
    @Override
    public void setText(java.lang.String text) {
        _review.setText(text);
    }

    /**
    * Returns the date of this review.
    *
    * @return the date of this review
    */
    @Override
    public java.util.Date getDate() {
        return _review.getDate();
    }

    /**
    * Sets the date of this review.
    *
    * @param date the date of this review
    */
    @Override
    public void setDate(java.util.Date date) {
        _review.setDate(date);
    }

    @Override
    public boolean isNew() {
        return _review.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _review.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _review.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _review.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _review.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _review.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _review.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _review.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _review.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _review.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _review.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ReviewWrapper((Review) _review.clone());
    }

    @Override
    public int compareTo(com.mir.news.model.Review review) {
        return _review.compareTo(review);
    }

    @Override
    public int hashCode() {
        return _review.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.mir.news.model.Review> toCacheModel() {
        return _review.toCacheModel();
    }

    @Override
    public com.mir.news.model.Review toEscapedModel() {
        return new ReviewWrapper(_review.toEscapedModel());
    }

    @Override
    public com.mir.news.model.Review toUnescapedModel() {
        return new ReviewWrapper(_review.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _review.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _review.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _review.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ReviewWrapper)) {
            return false;
        }

        ReviewWrapper reviewWrapper = (ReviewWrapper) obj;

        if (Validator.equals(_review, reviewWrapper._review)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Review getWrappedReview() {
        return _review;
    }

    @Override
    public Review getWrappedModel() {
        return _review;
    }

    @Override
    public void resetOriginalValues() {
        _review.resetOriginalValues();
    }
}
