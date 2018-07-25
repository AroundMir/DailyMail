<%@ include file='/html/init.jsp'%>

<portlet:actionURL name="addArticle" var="addArticleURL">
</portlet:actionURL>

<portlet:renderURL var="backOnArticleViewURL">
</portlet:renderURL>

<h3>
	<liferay-ui:message key="articleAdd" />
</h3>

<aui:form action="${addArticleURL}">
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