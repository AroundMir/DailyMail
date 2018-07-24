package com.mir.news.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.mir.news.service.ArticleLocalServiceUtil;
import com.mir.news.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class ArticleClp extends BaseModelImpl<Article> implements Article {
    private long _articleId;
    private long _authorId;
    private String _name;
    private String _text;
    private String _status;
    private BaseModel<?> _articleRemoteModel;
    private Class<?> _clpSerializerClass = com.mir.news.service.ClpSerializer.class;

    public ArticleClp() {
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
    public long getPrimaryKey() {
        return _articleId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setArticleId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _articleId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public long getArticleId() {
        return _articleId;
    }

    @Override
    public void setArticleId(long articleId) {
        _articleId = articleId;

        if (_articleRemoteModel != null) {
            try {
                Class<?> clazz = _articleRemoteModel.getClass();

                Method method = clazz.getMethod("setArticleId", long.class);

                method.invoke(_articleRemoteModel, articleId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getAuthorId() {
        return _authorId;
    }

    @Override
    public void setAuthorId(long authorId) {
        _authorId = authorId;

        if (_articleRemoteModel != null) {
            try {
                Class<?> clazz = _articleRemoteModel.getClass();

                Method method = clazz.getMethod("setAuthorId", long.class);

                method.invoke(_articleRemoteModel, authorId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        _name = name;

        if (_articleRemoteModel != null) {
            try {
                Class<?> clazz = _articleRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_articleRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getText() {
        return _text;
    }

    @Override
    public void setText(String text) {
        _text = text;

        if (_articleRemoteModel != null) {
            try {
                Class<?> clazz = _articleRemoteModel.getClass();

                Method method = clazz.getMethod("setText", String.class);

                method.invoke(_articleRemoteModel, text);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getStatus() {
        return _status;
    }

    @Override
    public void setStatus(String status) {
        _status = status;

        if (_articleRemoteModel != null) {
            try {
                Class<?> clazz = _articleRemoteModel.getClass();

                Method method = clazz.getMethod("setStatus", String.class);

                method.invoke(_articleRemoteModel, status);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getArticleRemoteModel() {
        return _articleRemoteModel;
    }

    public void setArticleRemoteModel(BaseModel<?> articleRemoteModel) {
        _articleRemoteModel = articleRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _articleRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_articleRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ArticleLocalServiceUtil.addArticle(this);
        } else {
            ArticleLocalServiceUtil.updateArticle(this);
        }
    }

    @Override
    public Article toEscapedModel() {
        return (Article) ProxyUtil.newProxyInstance(Article.class.getClassLoader(),
            new Class[] { Article.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ArticleClp clone = new ArticleClp();

        clone.setArticleId(getArticleId());
        clone.setAuthorId(getAuthorId());
        clone.setName(getName());
        clone.setText(getText());
        clone.setStatus(getStatus());

        return clone;
    }

    @Override
    public int compareTo(Article article) {
        long primaryKey = article.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ArticleClp)) {
            return false;
        }

        ArticleClp article = (ArticleClp) obj;

        long primaryKey = article.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{articleId=");
        sb.append(getArticleId());
        sb.append(", authorId=");
        sb.append(getAuthorId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", text=");
        sb.append(getText());
        sb.append(", status=");
        sb.append(getStatus());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("com.mir.news.model.Article");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>articleId</column-name><column-value><![CDATA[");
        sb.append(getArticleId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>authorId</column-name><column-value><![CDATA[");
        sb.append(getAuthorId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>text</column-name><column-value><![CDATA[");
        sb.append(getText());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>status</column-name><column-value><![CDATA[");
        sb.append(getStatus());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
