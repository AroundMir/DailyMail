<%@ include file='/html/init.jsp'%>

<portlet:actionURL name="addReview" var="addReviewURL">
	<portlet:param name="articleId" value="${article.articleId}" />
</portlet:actionURL>

<portlet:renderURL var="backOnArticleViewURL">
<portlet:param name="pageChecker" value="/html/view.jsp" />
</portlet:renderURL>

>
<h3><liferay-ui:message key="reviewAdd" /></h3>

<aui:form action="${addReviewURL}">
	<aui:input name="name" type="text" />
	<aui:input name="text" type="text" />
	<aui:button type="submit">
	</aui:button>
</aui:form>

<a href="${backOnArticleViewURL}">
	<button type="submit">
		<liferay-ui:message key="cancel" />
	</button>
</a>