package com.mir.news.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.mir.news.model.Article;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Article in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Article
 * @generated
 */
public class ArticleCacheModel implements CacheModel<Article>, Externalizable {
    public long articleId;
    public long authorId;
    public String name;
    public String text;
    public long date;
    public String status;
    public String editorComment;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{articleId=");
        sb.append(articleId);
        sb.append(", authorId=");
        sb.append(authorId);
        sb.append(", name=");
        sb.append(name);
        sb.append(", text=");
        sb.append(text);
        sb.append(", date=");
        sb.append(date);
        sb.append(", status=");
        sb.append(status);
        sb.append(", editorComment=");
        sb.append(editorComment);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Article toEntityModel() {
        ArticleImpl articleImpl = new ArticleImpl();

        articleImpl.setArticleId(articleId);
        articleImpl.setAuthorId(authorId);

        if (name == null) {
            articleImpl.setName(StringPool.BLANK);
        } else {
            articleImpl.setName(name);
        }

        if (text == null) {
            articleImpl.setText(StringPool.BLANK);
        } else {
            articleImpl.setText(text);
        }

        if (date == Long.MIN_VALUE) {
            articleImpl.setDate(null);
        } else {
            articleImpl.setDate(new Date(date));
        }

        if (status == null) {
            articleImpl.setStatus(StringPool.BLANK);
        } else {
            articleImpl.setStatus(status);
        }

        if (editorComment == null) {
            articleImpl.setEditorComment(StringPool.BLANK);
        } else {
            articleImpl.setEditorComment(editorComment);
        }

        articleImpl.resetOriginalValues();

        return articleImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        articleId = objectInput.readLong();
        authorId = objectInput.readLong();
        name = objectInput.readUTF();
        text = objectInput.readUTF();
        date = objectInput.readLong();
        status = objectInput.readUTF();
        editorComment = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(articleId);
        objectOutput.writeLong(authorId);

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

        if (status == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(status);
        }

        if (editorComment == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(editorComment);
        }
    }
}
