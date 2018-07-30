package com.mir.news.model.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.mir.news.service.ReviewLocalServiceUtil;
import com.mir.news.model.Review;

/**
 * The extended model implementation for the Article service. Represents a row in the &quot;article&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.mir.news.model.Article} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @param <Review>
 */
public class ArticleImpl extends ArticleBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. All methods that expect a article model instance should use the {@link com.mir.news.model.Article} interface instead.
     */
	
	public List<Review> getReviews() throws SystemException {
	    List<Review> articleReviews = ReviewLocalServiceUtil.getArticleReviews(getArticleId());
	    return articleReviews;
	}
	
    public ArticleImpl() {
    }
}
