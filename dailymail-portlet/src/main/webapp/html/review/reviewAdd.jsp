<%@ include file='/html/init.jsp'%>

<portlet:actionURL name="addReview" var="addReviewURL">
	<portlet:param name="articleId" value="${article.articleId}" />
</portlet:actionURL>

<portlet:renderURL var="backOnReviewsViewURL">
</portlet:renderURL>

<h3>Review Add</h3>

<aui:form action="${addReviewURL}">
	<aui:input name="name" type="text" />
	<aui:input name="text" type="text" />
	<aui:input type="submit" value="Add Review" name=""></aui:input>
</aui:form>
<aui:button href="${backOnReviewsViewURL}" value="Cancel" />