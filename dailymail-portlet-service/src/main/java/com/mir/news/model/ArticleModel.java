package com.mir.news.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Article service. Represents a row in the &quot;article&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.mir.news.model.impl.ArticleModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.mir.news.model.impl.ArticleImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Article
 * @see com.mir.news.model.impl.ArticleImpl
 * @see com.mir.news.model.impl.ArticleModelImpl
 * @generated
 */
public interface ArticleModel extends BaseModel<Article> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a article model instance should use the {@link Article} interface instead.
     */

    /**
     * Returns the primary key of this article.
     *
     * @return the primary key of this article
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this article.
     *
     * @param primaryKey the primary key of this article
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the article ID of this article.
     *
     * @return the article ID of this article
     */
    public long getArticleId();

    /**
     * Sets the article ID of this article.
     *
     * @param articleId the article ID of this article
     */
    public void setArticleId(long articleId);

    /**
     * Returns the author ID of this article.
     *
     * @return the author ID of this article
     */
    public long getAuthorId();

    /**
     * Sets the author ID of this article.
     *
     * @param authorId the author ID of this article
     */
    public void setAuthorId(long authorId);

    /**
     * Returns the name of this article.
     *
     * @return the name of this article
     */
    @AutoEscape
    public String getName();

    /**
     * Sets the name of this article.
     *
     * @param name the name of this article
     */
    public void setName(String name);

    /**
     * Returns the text of this article.
     *
     * @return the text of this article
     */
    @AutoEscape
    public String getText();

    /**
     * Sets the text of this article.
     *
     * @param text the text of this article
     */
    public void setText(String text);

    /**
     * Returns the status of this article.
     *
     * @return the status of this article
     */
    @AutoEscape
    public String getStatus();

    /**
     * Sets the status of this article.
     *
     * @param status the status of this article
     */
    public void setStatus(String status);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(com.mir.news.model.Article article);

    @Override
    public int hashCode();

    @Override
    public CacheModel<com.mir.news.model.Article> toCacheModel();

    @Override
    public com.mir.news.model.Article toEscapedModel();

    @Override
    public com.mir.news.model.Article toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
