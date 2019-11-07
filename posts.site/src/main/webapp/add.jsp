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
		<div class="jumbotron">
			<h3 class="h3">Add a new post !</h3>
			<hr/>
			
			<form action="add" method="get">
  				<fieldset>
  					<div class="form-group">
      					<label>Title</label>
      					<input type="text" name="title" class="form-control" placeholder="Enter Title">
    				</div>
    				<div class="form-group">
      					<label>Body</label>
      					<textarea placeholder="Enter Body" name="body" class="form-control" rows="3"></textarea>
    				</div>
    				<button type="submit" class="btn btn-primary">Submit</button>
  				</fieldset>
  			</form>
			
		</div>
	</div>

</body>
</html>
