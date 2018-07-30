package com.mir.news.consts;

import java.util.ArrayList;
import java.util.List;

public enum ArticleStatus {
  PUBLISHED, EDITING, CONFIRMATION, NONE;

  public static ArticleStatus getStatusByString(String status) {
    for (ArticleStatus articleStatus : values()) {
      if (articleStatus.name().equalsIgnoreCase(status)) {
        return articleStatus;
      }
    }
    return NONE;
  }

  public static List<String> getStatusNames() {
    List<String> statusList = new ArrayList<String>();
    for (ArticleStatus test : values()) {
      statusList.add(test.toString());
    }
    return statusList;
  }
}
