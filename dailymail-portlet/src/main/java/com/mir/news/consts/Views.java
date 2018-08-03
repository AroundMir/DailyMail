package com.mir.news.consts;

import java.util.ArrayList;
import java.util.List;

public class Views {
  public static final String REVIEWS_VIEW = "/html/review/reviewsView.jsp";
  public static final String ARTICLE_REJECT_VIEW = "/html/article/articleReject.jsp";
  public static final String MAIN_VIEW = "/html/view.jsp";
  public static final String ARTICLE_EDIT = "/html/article/articleEdit.jsp";
  public static final String ARTICLE_ADD = "/html/article/articleAdd.jsp";
  public static final String REVIEW_ADD = "/html/article/reviewAdd.jsp";

  public static List<String> getViews() {
    List<String> viewList = new ArrayList<String>();
    viewList = setViews(viewList);
    return viewList;
  }

  public static List<String> setViews(List<String> viewList) {
    viewList.add("/html/review/reviewsView.jsp");
    viewList.add("/html/article/articleReject.jsp");
    viewList.add("/html/view.jsp");
    viewList.add("/html/article/articleEdit.jsp");
    viewList.add("/html/article/articleAdd.jsp");
    viewList.add("/html/review/reviewAdd.jsp");
    return viewList;
  }
}
