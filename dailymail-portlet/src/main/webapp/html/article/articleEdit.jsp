<%@ include file='/html/init.jsp'%>

<portlet:actionURL name="updateArticle" var="editArticleURL">
	<portlet:param name="articleId" value="${article.articleId}" />
</portlet:actionURL>

<portlet:renderURL var="backOnArticleViewURL">
	<portlet:param name="pageChecker" value="/html/view.jsp" />
</portlet:renderURL>

<h3>
	<liferay-ui:message key="editArticle" />
</h3>


<aui:form action="${editArticleURL}">
	<aui:input name="name" value="${article.getName()}" type="text" />
	<aui:input name="text" value="${article.getText()}" type="text" />
	<aui:button type="submit">
	</aui:button>
</aui:form>
<a href="${backOnArticleViewURL}">
	<button type="submit">
		<liferay-ui:message key="cancel" />
	</button>
</a>