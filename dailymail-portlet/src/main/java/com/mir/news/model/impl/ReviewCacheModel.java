package com.mir.news.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.mir.news.model.Review;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Review in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Review
 * @generated
 */
public class ReviewCacheModel implements CacheModel<Review>, Externalizable {
    public long reviewId;
    public long reviewerId;
    public String imgUrl;
    public String name;
    public String text;
    public long date;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{reviewId=");
        sb.append(reviewId);
        sb.append(", reviewerId=");
        sb.append(reviewerId);
        sb.append(", imgUrl=");
        sb.append(imgUrl);
        sb.append(", name=");
        sb.append(name);
        sb.append(", text=");
        sb.append(text);
        sb.append(", date=");
        sb.append(date);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Review toEntityModel() {
        ReviewImpl reviewImpl = new ReviewImpl();

        reviewImpl.setReviewId(reviewId);
        reviewImpl.setReviewerId(reviewerId);

        if (imgUrl == null) {
            reviewImpl.setImgUrl(StringPool.BLANK);
        } else {
            reviewImpl.setImgUrl(imgUrl);
        }

        if (name == null) {
            reviewImpl.setName(StringPool.BLANK);
        } else {
            reviewImpl.setName(name);
        }

        if (text == null) {
            reviewImpl.setText(StringPool.BLANK);
        } else {
            reviewImpl.setText(text);
        }

        if (date == Long.MIN_VALUE) {
            reviewImpl.setDate(null);
        } else {
            reviewImpl.setDate(new Date(date));
        }

        reviewImpl.resetOriginalValues();

        return reviewImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        reviewId = objectInput.readLong();
        reviewerId = objectInput.readLong();
        imgUrl = objectInput.readUTF();
        name = objectInput.readUTF();
        text = objectInput.readUTF();
        date = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(reviewId);
        objectOutput.writeLong(reviewerId);

        if (imgUrl == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(imgUrl);
        }

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        if (text == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(text);
        }

        objectOutput.writeLong(date);
    }
}
