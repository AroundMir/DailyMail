<%@ include file='/html/init.jsp'%>

<portlet:actionURL name="updateArticle" var="editArticleURL">
	<portlet:param name="articleId" value="${article.getArticleId()}" />
</portlet:actionURL>

<portlet:renderURL var="backOnArticleViewURL">
</portlet:renderURL>

<h3>Article Edit</h3>


<aui:form action="${editArticleURL}">
	<aui:input name="name" value="${article.getName()}" type="text" />
	<aui:input name="text" value="${article.getText()}" type="text" />
	<aui:input type="submit" value="Save" name=""></aui:input>
</aui:form>
<aui:button href="${backOnArticleViewURL}" value="Cancel" />