<%@ include file='/html/init.jsp'%>


<portlet:actionURL var="publishArticleURL"
	name="setArticlePublishStatus">
	<portlet:param name="articleId" value="${article.getArticleId()}" />
</portlet:actionURL>

<portlet:actionURL var="rejectArticleURL" name="setArticleEditStatus">
	<portlet:param name="articleId" value="${article.getArticleId()}" />
</portlet:actionURL>

<portlet:actionURL var="sendArticleOnConfirmationURL"
	name="setArticleConfirmationStatus">
	<portlet:param name="articleId" value="${article.getArticleId()}" />
</portlet:actionURL>

<portlet:actionURL var="deleteArticleURL" name="deleteArticle">
	<portlet:param name="articleId" value="${article.getArticleId()}" />
</portlet:actionURL>

<portlet:renderURL var="editArticleURL">
	<portlet:param name="articleId" value="${article.getArticleId()}" />
	<portlet:param name="pageChecker"
		value="/html/article/articleEdit.jsp" />
</portlet:renderURL>

<portlet:renderURL var="writeReviewURL">
	<portlet:param name="articleId" value="${article.getArticleId()}" />
	<portlet:param name="pageChecker" value="/html/review/reviewAdd.jsp" />
</portlet:renderURL>

<portlet:renderURL var="checkReviewsURL">
	<portlet:param name="articleId" value="${article.getArticleId()}" />
	<portlet:param name="pageChecker"
		value="/html/review/reviewsView.jsp" />
</portlet:renderURL>


<c:if test="${currentRole.equalsIgnoreCase(AUTHOR)}">
	<c:if test="${article.getStatus().equalsIgnoreCase('EDITING')}">
		<aui:button href="${deleteArticleURL}" value="Delete Article"></aui:button>
		<aui:button href="${editArticleURL}" value="Edit Article"></aui:button>
		<aui:button href="${sendArticleOnConfirmationURL}"
			value="Send Article On Confirmation"></aui:button>
	</c:if>
	<c:if test="${article.getStatus().equalsIgnoreCase('PUBLISHED')}">
		<aui:button href="${checkReviewsURL}" value="Check Reviews"></aui:button>
	</c:if>
</c:if>

<c:if test="${currentRole.equalsIgnoreCase(EDITOR)}">
	<c:if test="${article.getStatus().equalsIgnoreCase('CONFIRMATION')}">
		<aui:button href="${deleteArticleURL}" value="Delete Article"></aui:button>
		<aui:button href="${publishArticleURL}" value="Publish Article"></aui:button>
		<aui:button href="${rejectArticleURL}" value="Reject Article"></aui:button>
	</c:if>
	<c:if test="${article.getStatus().equalsIgnoreCase('PUBLISHED')}">
		<aui:button href="${checkReviewsURL}" value="Check Reviews"></aui:button>
		<aui:button href="${rejectArticleURL}" value="Reject Article"></aui:button>
	</c:if>
</c:if>

<c:if test="${currentRole.equalsIgnoreCase(REVIEWER)}">
	<aui:button href="${writeReviewURL}" value="Write Review"></aui:button>
	<aui:button href="${checkReviewsURL}" value="Check Reviews"></aui:button>
</c:if>
