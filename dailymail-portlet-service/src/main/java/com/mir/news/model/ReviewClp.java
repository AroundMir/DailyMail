package com.mir.news.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.mir.news.service.ClpSerializer;
import com.mir.news.service.ReviewLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class ReviewClp extends BaseModelImpl<Review> implements Review {
    private long _reviewId;
    private long _reviewerId;
    private String _name;
    private String _text;
    private BaseModel<?> _reviewRemoteModel;
    private Class<?> _clpSerializerClass = com.mir.news.service.ClpSerializer.class;

    public ReviewClp() {
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
    public long getPrimaryKey() {
        return _reviewId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setReviewId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _reviewId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("reviewId", getReviewId());
        attributes.put("reviewerId", getReviewerId());
        attributes.put("name", getName());
        attributes.put("text", getText());

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

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String text = (String) attributes.get("text");

        if (text != null) {
            setText(text);
        }
    }

    @Override
    public long getReviewId() {
        return _reviewId;
    }

    @Override
    public void setReviewId(long reviewId) {
        _reviewId = reviewId;

        if (_reviewRemoteModel != null) {
            try {
                Class<?> clazz = _reviewRemoteModel.getClass();

                Method method = clazz.getMethod("setReviewId", long.class);

                method.invoke(_reviewRemoteModel, reviewId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getReviewerId() {
        return _reviewerId;
    }

    @Override
    public void setReviewerId(long reviewerId) {
        _reviewerId = reviewerId;

        if (_reviewRemoteModel != null) {
            try {
                Class<?> clazz = _reviewRemoteModel.getClass();

                Method method = clazz.getMethod("setReviewerId", long.class);

                method.invoke(_reviewRemoteModel, reviewerId);
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

        if (_reviewRemoteModel != null) {
            try {
                Class<?> clazz = _reviewRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_reviewRemoteModel, name);
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

        if (_reviewRemoteModel != null) {
            try {
                Class<?> clazz = _reviewRemoteModel.getClass();

                Method method = clazz.getMethod("setText", String.class);

                method.invoke(_reviewRemoteModel, text);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getReviewRemoteModel() {
        return _reviewRemoteModel;
    }

    public void setReviewRemoteModel(BaseModel<?> reviewRemoteModel) {
        _reviewRemoteModel = reviewRemoteModel;
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

        Class<?> remoteModelClass = _reviewRemoteModel.getClass();

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

        Object returnValue = method.invoke(_reviewRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ReviewLocalServiceUtil.addReview(this);
        } else {
            ReviewLocalServiceUtil.updateReview(this);
        }
    }

    @Override
    public Review toEscapedModel() {
        return (Review) ProxyUtil.newProxyInstance(Review.class.getClassLoader(),
            new Class[] { Review.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ReviewClp clone = new ReviewClp();

        clone.setReviewId(getReviewId());
        clone.setReviewerId(getReviewerId());
        clone.setName(getName());
        clone.setText(getText());

        return clone;
    }

    @Override
    public int compareTo(Review review) {
        long primaryKey = review.getPrimaryKey();

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

        if (!(obj instanceof ReviewClp)) {
            return false;
        }

        ReviewClp review = (ReviewClp) obj;

        long primaryKey = review.getPrimaryKey();

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
        StringBundler sb = new StringBundler(9);

        sb.append("{reviewId=");
        sb.append(getReviewId());
        sb.append(", reviewerId=");
        sb.append(getReviewerId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", text=");
        sb.append(getText());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append("com.mir.news.model.Review");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>reviewId</column-name><column-value><![CDATA[");
        sb.append(getReviewId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>reviewerId</column-name><column-value><![CDATA[");
        sb.append(getReviewerId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>text</column-name><column-value><![CDATA[");
        sb.append(getText());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
