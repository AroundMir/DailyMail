package com.mir.news.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.mir.news.service.http.ArticleServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.mir.news.service.http.ArticleServiceSoap
 * @generated
 */
public class ArticleSoap implements Serializable {
    private long _articleId;
    private long _authorId;
    private String _name;
    private String _text;
    private String _status;

    public ArticleSoap() {
    }

    public static ArticleSoap toSoapModel(Article model) {
        ArticleSoap soapModel = new ArticleSoap();

        soapModel.setArticleId(model.getArticleId());
        soapModel.setAuthorId(model.getAuthorId());
        soapModel.setName(model.getName());
        soapModel.setText(model.getText());
        soapModel.setStatus(model.getStatus());

        return soapModel;
    }

    public static ArticleSoap[] toSoapModels(Article[] models) {
        ArticleSoap[] soapModels = new ArticleSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ArticleSoap[][] toSoapModels(Article[][] models) {
        ArticleSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ArticleSoap[models.length][models[0].length];
        } else {
            soapModels = new ArticleSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ArticleSoap[] toSoapModels(List<Article> models) {
        List<ArticleSoap> soapModels = new ArrayList<ArticleSoap>(models.size());

        for (Article model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ArticleSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _articleId;
    }

    public void setPrimaryKey(long pk) {
        setArticleId(pk);
    }

    public long getArticleId() {
        return _articleId;
    }

    public void setArticleId(long articleId) {
        _articleId = articleId;
    }

    public long getAuthorId() {
        return _authorId;
    }

    public void setAuthorId(long authorId) {
        _authorId = authorId;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getText() {
        return _text;
    }

    public void setText(String text) {
        _text = text;
    }

    public String getStatus() {
        return _status;
    }

    public void setStatus(String status) {
        _status = status;
    }
}
