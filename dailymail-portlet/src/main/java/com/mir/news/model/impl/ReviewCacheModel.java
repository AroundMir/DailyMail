package com.mir.news.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.mir.news.model.Review;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

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
    public String name;
    public String text;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{reviewId=");
        sb.append(reviewId);
        sb.append(", reviewerId=");
        sb.append(reviewerId);
        sb.append(", name=");
        sb.append(name);
        sb.append(", text=");
        sb.append(text);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Review toEntityModel() {
        ReviewImpl reviewImpl = new ReviewImpl();

        reviewImpl.setReviewId(reviewId);
        reviewImpl.setReviewerId(reviewerId);

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

        reviewImpl.resetOriginalValues();

        return reviewImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        reviewId = objectInput.readLong();
        reviewerId = objectInput.readLong();
        name = objectInput.readUTF();
        text = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(reviewId);
        objectOutput.writeLong(reviewerId);

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
    }
}
