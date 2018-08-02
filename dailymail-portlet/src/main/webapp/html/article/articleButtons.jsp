<%@ include file='/html/init.jsp'%>

<portlet:actionURL var="publishArticleURL"
	name="setArticlePublishStatus">
	<portlet:param name="articleId" value="${article.getArticleId()}" />
</portlet:actionURL>

<portlet:renderURL var="rejectArticleURL">
	<portlet:param name="articleId" value="${article.getArticleId()}" />
	<portlet:param name="pageChecker"
		value="/html/article/articleReject.jsp" />
</portlet:renderURL>

<portlet:actionURL var="sendArticleOnConfirmationURL" name="setArticleConfirmationStatus">
	<portlet:param name="articleId" value="${article.getArticleId()}" />
</portlet:actionURL>

<portlet:actionURL var="deleteArticleURL" name="deleteArticle">
	<portlet:param name="articleId" value="${article.getArticleId()}" />
</portlet:actionURL>

<portlet:renderURL var="editArticleURL">
	<portlet:param name="articleId" value="${article.getArticleId()}" />
	<portlet:param name="pageChecker" value="/html/article/articleEdit.jsp" />
</portlet:renderURL>

<portlet:renderURL var="writeReviewURL">
	<portlet:param name="articleId" value="${article.getArticleId()}" />
	<portlet:param name="pageChecker" value="/html/review/reviewAdd.jsp" />
</portlet:renderURL>

<portlet:renderURL var="checkReviewsURL">
	<portlet:param name="articleId" value="${article.getArticleId()}" />
	<portlet:param name="pageChecker" value="/html/review/reviewsView.jsp" />
</portlet:renderURL>


<c:if test="${currentRole.equalsIgnoreCase(AUTHOR)}">
	<c:if test="${article.getStatus().equalsIgnoreCase('EDITING')}">
		<a href="${deleteArticleURL}">
			<button type="submit">
				<liferay-ui:message key="deleteArticle" />
			</button>
		</a>
		<a href="${editArticleURL}">
			<button type="submit">
				<liferay-ui:message key="editArticle" />
			</button>
		</a>
		<a href="${sendArticleOnConfirmationURL}">
			<button type="submit">
				<liferay-ui:message key="onConfirmation" />
			</button>
		</a>
	</c:if>

	<!-- P'U`B'L"ISHED -->
	<c:if test="${article.getStatus().equalsIgnoreCase('PUBLISHED')}">
		<a href="${checkReviewsURL}">
			<button type="submit">
				<liferay-ui:message key="checkReviews" />
			</button>
		</a>
	</c:if>
</c:if>

<c:if test="${currentRole.equalsIgnoreCase(EDITOR)}">
	<c:if test="${article.getStatus().equalsIgnoreCase('CONFIRMATION')}">
		<a href="${deleteArticleURL}">
			<button type="submit">
				<liferay-ui:message key="deleteArticle" />
			</button>
		</a>
		<a href="${publishArticleURL}">
			<button type="submit">
				<liferay-ui:message key="publishArticle" />
			</button>
		</a>
		<a href="${rejectArticleURL}">
			<button type="submit">
				<liferay-ui:message key="rejectArticle" />
			</button>
		</a>
	</c:if>
	<c:if test="${article.getStatus().equalsIgnoreCase('PUBLISHED')}">
		<a href="${checkReviewsURL}">
			<button type="submit">
				<liferay-ui:message key="checkReviews" />
			</button>
		</a>
		<a href="${rejectArticleURL}">
			<button type="submit">
				<liferay-ui:message key="rejectArticle" />
			</button>
		</a>
	</c:if>
</c:if>

<c:if test="${currentRole.equalsIgnoreCase('REVIEWER')}">
	<a href="${writeReviewURL}">
		<button type="submit">
			<liferay-ui:message key="writeReview" />
		</button>
	</a>
	<a href="${checkReviewsURL}">
		<button type="submit">
			<liferay-ui:message key="checkReviews" />
		</button>
	</a>
</c:if>
