<%@ include file='/html/init.jsp'%>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">
	
</script>
<portlet:renderURL var="backOnArticleViewURL">
</portlet:renderURL>

<script type="text/javascript"
	src="//cdn.datatables.net/1.10.5/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="//cdn.datatables.net/1.10.5/css/jquery.dataTables.min.css">

<table id="reviewTable" class="reviewTable">
	<thead>
		<tr>
			<th></th>
			<th><liferay-ui:message key="reviewTitle" /></th>
			<th><liferay-ui:message key="reviewText" /></th>
			<th><liferay-ui:message key="date" /></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${reviews}" var="review" varStatus="loop">
			<portlet:actionURL var="deleteReviewURL" name="deleteReview">
				<portlet:param name="reviewId" value="${review.getReviewId()}" />
			</portlet:actionURL>
			<tr>
				<td><img src="${review.imgUrl}" alt="NONE"></td>
				<td>${review.name}</td>
				<td>${review.text}</td>
				<td>${review.getDate().toString()}</td>
				<c:if test="${currentRole.equalsIgnoreCase(EDITOR)}">
					<td><aui:button href="${deleteReviewURL}"
							value="Delete Review"></aui:button></td>
				</c:if>
			</tr>
		</c:forEach>
	</tbody>
</table>

<a href="${backOnArticleViewURL}">
	<button type="submit">
		<liferay-ui:message key="cancel" />
	</button>
</a>

<script>
	$(document).ready(function() {
		$('#reviewTable').DataTable();
	});
</script>