<%@ include file='/html/init.jsp'%>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">
	
</script>

<script type="text/javascript"
	src="//cdn.datatables.net/1.10.5/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="//cdn.datatables.net/1.10.5/css/jquery.dataTables.min.css">

<portlet:actionURL name="setEditingArticles" var="getEditingArticlesURL">
</portlet:actionURL>

<portlet:actionURL name="setPublishedArticles"
	var="getPublishedArticlesURL">
</portlet:actionURL>

<portlet:actionURL name="setConfirmationArticles"
	var="getConfirmationArticlesURL">
</portlet:actionURL>

<portlet:renderURL var="addArticleURL">
	<portlet:param name="pageChecker" value="/html/article/articleAdd.jsp" />
</portlet:renderURL>

<c:if test="${currentRole.equalsIgnoreCase(EDITOR)}">
	<a href="${getPublishedArticlesURL}">
		<button type="submit">
			<liferay-ui:message key="publishedArticles" />
		</button>
	</a>
	<a href="${getConfirmationArticlesURL}">
		<button type="submit">
			<liferay-ui:message key="confirmationArticles" />
		</button>
	</a>
</c:if>

<c:if test="${currentRole.equalsIgnoreCase(AUTHOR)}">
	<a href="${getPublishedArticlesURL}">
		<button type="submit">
			<liferay-ui:message key="publishedArticles" />
		</button>
	</a>
	<a href="${getEditingArticlesURL}">
		<button type="submit">
			<liferay-ui:message key="editingArticles" />
		</button>
	</a>
	<a href="${getConfirmationArticlesURL}">
		<button type="submit">
			<liferay-ui:message key="confirmationArticles" />
		</button>
	</a>
	<a href="${addArticleURL}">
		<button type="submit">
			<liferay-ui:message key="createArticle" />
		</button>
	</a>
</c:if>

<c:if test="${currentRole.equalsIgnoreCase(REVIEWER)}">
	<a href="${getPublishedArticlesURL}">
		<button type="submit">
			<liferay-ui:message key="publishedArticles" />
		</button>
	</a>
</c:if>

<table id="acticleTable" class="acticleTable">
	<thead>
		<tr>
			<th><liferay-ui:message key="articleTitle" /></th>
			<th><liferay-ui:message key="articleText" /></th>
			<th><liferay-ui:message key="articleStatus" /></th>
			<c:if test="${commentFlug.equalsIgnoreCase('true')}">
				<th><liferay-ui:message key="editorComment" /></th>
			</c:if>
			<th><liferay-ui:message key="actions" /></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${articles}" var="article" varStatus="loop">
			<tr>
				<td>${article.name}</td>
				<td>${article.text}</td>
				<td>${article.status}</td>
				<c:if test="${article.getStatus().equalsIgnoreCase('EDITING')}">
					<td>${article.editorComment}</td>
				</c:if>
				<td><%@ include file='/html/article/articleButtons.jsp'%></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<script>
	$(document).ready(function() {
		$('#acticleTable').DataTable();
	});
</script>