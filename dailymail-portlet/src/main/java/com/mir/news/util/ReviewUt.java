package com.mir.news.util;

import com.mir.news.service.entity_srv.ReviewServiceImpl;
import com.mir.news.service.entity_srv.ReviewSrv;

public class ReviewUt {
	private final ReviewSrv articleService = ReviewServiceImpl.getInstance();
	private static ReviewUt reviewUt = null;

	public static ReviewUt getInstance() {
		if (reviewUt == null) {
			reviewUt = new ReviewUt();
		}
		return reviewUt;
	}
}
