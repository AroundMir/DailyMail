<%@ include file='/html/init.jsp'%>

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.5/js/jquery.dataTables.min.js"></script>

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

<form>
	Name<input onclick="sendGet();" type=button value=Ajax id=ajaxId>
</form>

<div class="view">
	<c:if test="${currentRole.equalsIgnoreCase(EDITOR)}">
		<a href="${getPublishedArticlesURL}">
			<button class="circleButton" type="submit">
				<liferay-ui:message key="publishedArticles" />
			</button>
		</a>
		<a href="${getConfirmationArticlesURL}">
			<button class="circleButton" type="submit">
				<liferay-ui:message key="confirmationArticles" />
			</button>
		</a>
	</c:if>

	<c:if test="${currentRole.equalsIgnoreCase(AUTHOR)}">
		<a href="${getPublishedArticlesURL}">
			<button class="circleButton" type="submit">
				<liferay-ui:message key="publishedArticles" />
			</button>
		</a>
		<a href="${getEditingArticlesURL}">
			<button class="circleButton" type="submit">
				<liferay-ui:message key="editingArticles" />
			</button>
		</a>
		<a href="${getConfirmationArticlesURL}">
			<button class="circleButton" type="submit">
				<liferay-ui:message key="confirmationArticles" />
			</button>
		</a>
		<a href="${addArticleURL}">
			<button class="circleButton" type="submit">
				<liferay-ui:message key="createArticle" />
			</button>
		</a>
	</c:if>

	<c:if test="${currentRole.equalsIgnoreCase(REVIEWER)}">
		<a href="${getPublishedArticlesURL}">
			<button class="circleButton" type="submit">
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
	<div class="lorem">
		<b id="collapsible" ><liferay-ui:message key="license" /></b>
		<div class="content">
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
				do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
				enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi
				ut aliquip ex ea commodo consequat.</p>
		</div>
	</div>
</div>