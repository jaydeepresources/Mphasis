<%@page import="com.crud.Post"%>
<%@page import="java.util.List"%>
<%@page import="dao.PostDAOImpl"%>
<html>
<head>
<link rel="stylesheet" href="./assets/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>

	<div class="container">
		<div class="jumbotron py-5">
			<h3 class="h3 mb-0">Showing all the Posts</h3>
		</div>

		<%
			PostDAOImpl impl = new PostDAOImpl();
		%>
		<%
			List<Post> list = impl.view();
		%>

		<%
			for (Post post : list) {
		%>

		<div class="card mt-2">
			<div class="card-body">
				<h4 class="card-title text-primary"><%= post.getTitle() %></h4>
				<p class="card-text"><%= post.getBody() %></p>
			</div>
		</div>

		<%
			}
		%>

	</div>

</body>
</html>
