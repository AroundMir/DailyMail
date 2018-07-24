<%@ include file='/html/init.jsp'%>

<portlet:actionURL name="addArticle" var="addArticleURL">
</portlet:actionURL>

<portlet:renderURL var="backOnArticleViewURL">
</portlet:renderURL>

<h3>Article Add</h3>

<aui:form action="${addArticleURL}">
	<aui:input name="name" type="text" />
	<aui:input name="text" type="text" />
	<aui:input type="submit" value="Add Article" name=""></aui:input>
</aui:form>
<aui:button href="${backOnArticleViewURL}" value="Cancel" />