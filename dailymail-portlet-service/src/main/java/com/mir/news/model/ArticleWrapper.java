package com.mir.news.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Article}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Article
 * @generated
 */
public class ArticleWrapper implements Article, ModelWrapper<Article> {
    private Article _article;

    public ArticleWrapper(Article article) {
        _article = article;
    }

    @Override
    public Class<?> getModelClass() {
        return Article.class;
    }

    @Override
    public String getModelClassName() {
        return Article.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("articleId", getArticleId());
        attributes.put("authorId", getAuthorId());
        attributes.put("name", getName());
        attributes.put("text", getText());
        attributes.put("status", getStatus());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long articleId = (Long) attributes.get("articleId");

        if (articleId != null) {
            setArticleId(articleId);
        }

        Long authorId = (Long) attributes.get("authorId");

        if (authorId != null) {
            setAuthorId(authorId);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String text = (String) attributes.get("text");

        if (text != null) {
            setText(text);
        }

        String status = (String) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }
    }

    /**
    * Returns the primary key of this article.
    *
    * @return the primary key of this article
    */
    @Override
    public long getPrimaryKey() {
        return _article.getPrimaryKey();
    }

    /**
    * Sets the primary key of this article.
    *
    * @param primaryKey the primary key of this article
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _article.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the article ID of this article.
    *
    * @return the article ID of this article
    */
    @Override
    public long getArticleId() {
        return _article.getArticleId();
    }

    /**
    * Sets the article ID of this article.
    *
    * @param articleId the article ID of this article
    */
    @Override
    public void setArticleId(long articleId) {
        _article.setArticleId(articleId);
    }

    /**
    * Returns the author ID of this article.
    *
    * @return the author ID of this article
    */
    @Override
    public long getAuthorId() {
        return _article.getAuthorId();
    }

    /**
    * Sets the author ID of this article.
    *
    * @param authorId the author ID of this article
    */
    @Override
    public void setAuthorId(long authorId) {
        _article.setAuthorId(authorId);
    }

    /**
    * Returns the name of this article.
    *
    * @return the name of this article
    */
    @Override
    public java.lang.String getName() {
        return _article.getName();
    }

    /**
    * Sets the name of this article.
    *
    * @param name the name of this article
    */
    @Override
    public void setName(java.lang.String name) {
        _article.setName(name);
    }

    /**
    * Returns the text of this article.
    *
    * @return the text of this article
    */
    @Override
    public java.lang.String getText() {
        return _article.getText();
    }

    /**
    * Sets the text of this article.
    *
    * @param text the text of this article
    */
    @Override
    public void setText(java.lang.String text) {
        _article.setText(text);
    }

    /**
    * Returns the status of this article.
    *
    * @return the status of this article
    */
    @Override
    public java.lang.String getStatus() {
        return _article.getStatus();
    }

    /**
    * Sets the status of this article.
    *
    * @param status the status of this article
    */
    @Override
    public void setStatus(java.lang.String status) {
        _article.setStatus(status);
    }

    @Override
    public boolean isNew() {
        return _article.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _article.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _article.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _article.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _article.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _article.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _article.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _article.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _article.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _article.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _article.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ArticleWrapper((Article) _article.clone());
    }

    @Override
    public int compareTo(com.mir.news.model.Article article) {
        return _article.compareTo(article);
    }

    @Override
    public int hashCode() {
        return _article.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.mir.news.model.Article> toCacheModel() {
        return _article.toCacheModel();
    }

    @Override
    public com.mir.news.model.Article toEscapedModel() {
        return new ArticleWrapper(_article.toEscapedModel());
    }

    @Override
    public com.mir.news.model.Article toUnescapedModel() {
        return new ArticleWrapper(_article.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _article.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _article.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _article.persist();
    }

    @Override
<<<<<<< HEAD
    public java.util.List<com.mir.news.model.Review> getReviews()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _article.getReviews();
    }

    @Override
=======
>>>>>>> 816e3130999f956bdec64fcf78b511dbf024c3e4
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ArticleWrapper)) {
            return false;
        }

        ArticleWrapper articleWrapper = (ArticleWrapper) obj;

        if (Validator.equals(_article, articleWrapper._article)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Article getWrappedArticle() {
        return _article;
    }

    @Override
    public Article getWrappedModel() {
        return _article;
    }

    @Override
    public void resetOriginalValues() {
        _article.resetOriginalValues();
    }
}
