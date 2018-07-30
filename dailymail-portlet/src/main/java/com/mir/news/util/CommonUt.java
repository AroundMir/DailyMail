package com.mir.news.util;

import java.util.List;
import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.mir.news.consts.Roles;
import com.mir.news.consts.Views;
import com.mir.news.model.Review;
import com.mir.news.portlet.DailyMail;
import com.mir.news.service.ReviewLocalServiceUtil;

public class CommonUt {
  private static final Log log = LogFactoryUtil.getLog(DailyMail.class);
  private static CommonUt commonUtil = null;

  public static CommonUt getInstance() {
    if (commonUtil == null) {
      commonUtil = new CommonUt();
    }
    return commonUtil;
  }

  /**
   * Get 'pageCheker' parameter. 'pageChecker' contain view directory to render.
   * 
   * @param renderRequest
   * @param renderResponse
   * @return
   */
  public String getViewPath(RenderRequest renderRequest, RenderResponse renderResponse) {

    String inputPage = renderRequest.getParameter("pageChecker");
    if (inputPage != null) {
      if (Views.REVIEWS_VIEW.equalsIgnoreCase(inputPage)) {
        List<Review> reviews = null;
        String articleId = renderRequest.getParameter("articleId");
        try {
          reviews = ReviewLocalServiceUtil.getArticleReviews(Long.parseLong(articleId));
        } catch (NumberFormatException e) {
          log.error(e.getMessage());
        } catch (SystemException e) {
          log.error(e.getMessage());
        }
        renderRequest.setAttribute("reviews", reviews);
        return inputPage;
      }
      return inputPage;
    }
    inputPage = Views.MAIN_VIEW;
    return inputPage;
  }

  /**
   * Set default roles in request attribute Set general user role ID to request attribute
   * 
   * @param renderRequest
   * @return
   */
  public void setCurrentUserRoleName(RenderRequest renderRequest) {

    renderRequest.setAttribute("AUTHOR", Roles.AUTHOR.toString());
    renderRequest.setAttribute("EDITOR", Roles.EDITOR.toString());
    renderRequest.setAttribute("REVIEWER", Roles.REVIEWER.toString());
    String roleName = getCurrentUserRole(renderRequest).toString();
    renderRequest.setAttribute("currentRole", roleName);

  }

  public Enum<Roles> getCurrentUserRole(ActionRequest actionRequest) {

    ThemeDisplay themeDisp = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
    User user = themeDisp.getUser();
    String authorRole = Roles.AUTHOR.toString();
    String editorRole = Roles.EDITOR.toString();
    String reviewerRole = Roles.REVIEWER.toString();
    try {
      for (Role role : user.getRoles()) {
        if (role.getName().equalsIgnoreCase(authorRole)) {
          return Roles.AUTHOR;
        } else if (role.getName().equalsIgnoreCase(editorRole)) {
          return Roles.EDITOR;
        } else if (role.getName().equalsIgnoreCase(reviewerRole)) {
          return Roles.REVIEWER;
        }
      }
    } catch (SystemException e) {
      log.error(e.getMessage());
    }
    return Roles.NONE;
  }

  public Enum<Roles> getCurrentUserRole(RenderRequest renderRequest) {

    ThemeDisplay themeDisp = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
    User user = themeDisp.getUser();
    String authorRole = Roles.AUTHOR.toString();
    String editorRole = Roles.EDITOR.toString();
    String reviewerRole = Roles.REVIEWER.toString();
    try {
      for (Role role : user.getRoles()) {
        if (role.getName().equalsIgnoreCase(authorRole)) {
          return Roles.AUTHOR;
        } else if (role.getName().equalsIgnoreCase(editorRole)) {
          return Roles.EDITOR;
        } else if (role.getName().equalsIgnoreCase(reviewerRole)) {
          return Roles.REVIEWER;
        }
      }
    } catch (SystemException e) {
      log.error(e.getMessage());
    }
    return Roles.NONE;
  }

  public long getCurrentUserId(RenderRequest renderRequest) {

    ThemeDisplay themeDisp = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
    long userID = themeDisp.getUserId();
    return userID;
  }

  public long getCurrentUserId(ActionRequest actionRequest) {

    ThemeDisplay themeDisp = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
    long userID = themeDisp.getUserId();
    return userID;
  }
}
