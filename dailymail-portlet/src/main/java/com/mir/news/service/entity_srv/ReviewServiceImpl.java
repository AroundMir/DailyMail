package com.mir.news.service.entity_srv;

import java.util.Date;
import java.util.List;
import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
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

  /**
   * Create new Review
   */

  @Override
  public Review createReview(ActionRequest actionRequest) throws SystemException,
      NumberFormatException, PortalException {

    String reviewName = actionRequest.getParameter("name");
    String reviewText = actionRequest.getParameter("text");
    long articleId = ParamUtil.getLong(actionRequest, "articleId", 0);
    Review review = null;
    if (articleId != 0) {
      
      ThemeDisplay themeDisp = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
      long userID = themeDisp.getUserId();
      
      String userImgUrl = themeDisp.getUser().getPortraitURL(themeDisp);
      Date date = new Date();
      long reiviewId = CounterLocalServiceUtil.increment(Review.class.getName());
      review = ReviewLocalServiceUtil.createReview(reiviewId);

      review.setName(reviewName);
      review.setText(reviewText);
      review.setReviewerId(userID);
      review.setImgUrl(userImgUrl);
      review.setDate(date);
      review.getDate().toString();

      Article article = ArticleLocalServiceUtil.getArticle(articleId);
      review = ReviewLocalServiceUtil.addReview(review);
      ReviewLocalServiceUtil.addArticleReview(article.getArticleId(), review.getReviewId());
    }
    return review;
  }

  /**
   * Delete review by id
   */
  
  @Override
  public Review deleteReview(ActionRequest actionRequest) throws NumberFormatException,
      PortalException, SystemException {

    long reviewId = ParamUtil.getLong(actionRequest, "reviewId", 0);
    if (reviewId != 0) {
      Review review = ReviewLocalServiceUtil.deleteReview(reviewId);
      return review;
    }
    return null;
  }
  
  /**
   * Update review
   */

  @Override
  public Review updateReview(ActionRequest actionRequest) throws SystemException,
      NumberFormatException, PortalException {

    String reviewName = actionRequest.getParameter("name");
    String reviewText = actionRequest.getParameter("text");
    long reviewId = ParamUtil.getLong(actionRequest, "reviewId", 0);
    if (reviewId != 0) {
      Review review = ReviewLocalServiceUtil.getReview(reviewId);
      review.setName(reviewName);
      review.setText(reviewText);
      review = ReviewLocalServiceUtil.addReview(review);
      return review;
    }
    return null;
  }
  
  /**
   * Get review by Id
   */

  @Override
  public Review findReview(RenderRequest renderRequest) throws NumberFormatException,
      PortalException, SystemException {

    long reviewId = ParamUtil.getLong(renderRequest, "reviewId", 0);
    if (reviewId != 0) {
      Review review = ReviewLocalServiceUtil.getReview(reviewId);
      return review;
    }
    return null;
  }

  @Override
  public List<Review> findAllReviews() throws SystemException {

    long reviewCount = ReviewLocalServiceUtil.getReviewsCount();
    List<Review> reviews = ReviewLocalServiceUtil.getReviews(0, (int) reviewCount);
    return reviews;
  }
}
