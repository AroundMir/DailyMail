<%@ include file='/html/init.jsp'%>

<portlet:actionURL name="updateArticle" var="rejectArticleURL">
	<portlet:param name="articleId" value="${article.getArticleId()}" />
</portlet:actionURL>

<portlet:renderURL var="backOnArticleViewURL">
	<portlet:param name="pageChecker" value="/html/view.jsp" />
</portlet:renderURL>

<h3>
	<liferay-ui:message key="reject" />
</h3>

<aui:form action="${rejectArticleURL}">
	<aui:input name="editorComment" type="text" />
	<aui:button type="submit">
	</aui:button>
</aui:form>

<a href="${backOnArticleViewURL}">
	<button type="submit">
		<liferay-ui:message key="cancel" />
	</button>
</a>