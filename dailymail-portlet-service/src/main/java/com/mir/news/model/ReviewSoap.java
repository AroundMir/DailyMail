package com.mir.news.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.mir.news.service.http.ReviewServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.mir.news.service.http.ReviewServiceSoap
 * @generated
 */
public class ReviewSoap implements Serializable {
    private long _reviewId;
    private long _reviewerId;
    private String _imgUrl;
    private String _name;
    private String _text;
    private Date _date;

    public ReviewSoap() {
    }

    public static ReviewSoap toSoapModel(Review model) {
        ReviewSoap soapModel = new ReviewSoap();

        soapModel.setReviewId(model.getReviewId());
        soapModel.setReviewerId(model.getReviewerId());
        soapModel.setImgUrl(model.getImgUrl());
        soapModel.setName(model.getName());
        soapModel.setText(model.getText());
        soapModel.setDate(model.getDate());

        return soapModel;
    }

    public static ReviewSoap[] toSoapModels(Review[] models) {
        ReviewSoap[] soapModels = new ReviewSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ReviewSoap[][] toSoapModels(Review[][] models) {
        ReviewSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ReviewSoap[models.length][models[0].length];
        } else {
            soapModels = new ReviewSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ReviewSoap[] toSoapModels(List<Review> models) {
        List<ReviewSoap> soapModels = new ArrayList<ReviewSoap>(models.size());

        for (Review model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ReviewSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _reviewId;
    }

    public void setPrimaryKey(long pk) {
        setReviewId(pk);
    }

    public long getReviewId() {
        return _reviewId;
    }

    public void setReviewId(long reviewId) {
        _reviewId = reviewId;
    }

    public long getReviewerId() {
        return _reviewerId;
    }

    public void setReviewerId(long reviewerId) {
        _reviewerId = reviewerId;
    }

    public String getImgUrl() {
        return _imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        _imgUrl = imgUrl;
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

    public Date getDate() {
        return _date;
    }

    public void setDate(Date date) {
        _date = date;
    }
}
