package com.mir.news.service.entity_srv;

import java.util.Date;
import java.util.List;
import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.mir.news.model.Article;
import com.mir.news.model.Review;
import com.mir.news.service.ArticleLocalServiceUtil;
import com.mir.news.service.ReviewLocalServiceUtil;


public class ReviewServiceImpl implements ReviewSrv {

  private static ReviewServiceImpl reviewSrv = null;

  private ReviewServiceImpl() {}

  public static ReviewServiceImpl getInstance() {

    if (reviewSrv == null) {
      reviewSrv = new ReviewServiceImpl();
    }
    return reviewSrv;
  }

  @Override
  public Review create(ActionRequest actionRequest) throws SystemException, NumberFormatException,
      PortalException {

    String reviewName = actionRequest.getParameter("name");
    String reviewText = actionRequest.getParameter("text");
    String articleId = actionRequest.getParameter("articleId");

    ThemeDisplay themeDisp = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
    long userID = themeDisp.getUserId();
    String userImgUrl = themeDisp.getUser().getPortraitURL(themeDisp);
    Date date = new Date();
    
    long reiviewId = CounterLocalServiceUtil.increment(Review.class.getName());
    Review review = ReviewLocalServiceUtil.createReview(reiviewId);
    
    review.setName(reviewName);
    review.setText(reviewText);
    review.setReviewerId(userID);
    review.setImgUrl(userImgUrl);
    review.setDate(date);
    review.getDate().toString();
    
    Article article = ArticleLocalServiceUtil.getArticle(Long.parseLong(articleId));

    review = ReviewLocalServiceUtil.addReview(review);
    ReviewLocalServiceUtil.addArticleReview(article.getArticleId(), review.getReviewId());

    return review;
  }

  @Override
  public Review delete(ActionRequest actionRequest) throws NumberFormatException, PortalException,
      SystemException {
    String reviewId = actionRequest.getParameter("reviewId");
    // System.out.println(reviewId);
    if (reviewId != null) {
      Review review = ReviewLocalServiceUtil.deleteReview(Long.parseLong(reviewId));
      return review;
    }
    return null;
  }

  @Override
  public Review update(ActionRequest actionRequest) throws SystemException, NumberFormatException,
      PortalException {

    String reviewName = actionRequest.getParameter("name");
    String reviewText = actionRequest.getParameter("text");
    String reiviewId = actionRequest.getParameter("reiviewId");
    if (reiviewId != null) {
      Review review = ReviewLocalServiceUtil.getReview(Long.parseLong(reiviewId));
      review.setName(reviewName);
      review.setText(reviewText);
      review = ReviewLocalServiceUtil.addReview(review);
      return review;
    }
    return null;
  }

  @Override
  public Review find(RenderRequest renderRequest) throws NumberFormatException, PortalException,
      SystemException {

    String reiviewId = renderRequest.getParameter("reiviewId");
    if (reiviewId != null) {
      Review review = ReviewLocalServiceUtil.getReview(Long.parseLong(reiviewId));
      return review;
    }
    return null;
  }

  @Override
  public List<Review> findAll() throws SystemException {

    long reviewCount = ReviewLocalServiceUtil.getReviewsCount();
    List<Review> reviews = ReviewLocalServiceUtil.getReviews(0, (int) reviewCount);
    return reviews;
  }

  @Override
  public Review find(ActionRequest request) throws SystemException {
    return null;
  }
}
