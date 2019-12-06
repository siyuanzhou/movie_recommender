<%@ page session="false"%>
<%@include file="header.jsp"%>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="wrapper">
						<div class="container-fluid">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-user"></i></span> <input id="username"
									type="text" class="form-control" name="username"
									placeholder="Username" required>
							</div>
							<br />
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-lock"></i></span> <input id="password"
									type="password" class="form-control" name="password"
									placeholder="Password" required>
							</div>
							<br />
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-lock"></i></span> <input id="passwordC"
									type="password" class="form-control" name="passwordC"
									placeholder="Confirm Password" required>
							</div>
							<br />
							<div class="top5">
								<button type="submit"
									class="btn btn-success col-md-6 col-md-offset-3"
									onclick="register();">Register me</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<center>
	<div class="okBox" style="display: none">Success!</div>
	<br />
	<div class="alertBox" style="display: none">This username is
		invalid. Try another one!</div>
</center>

<%@include file="footer.jsp"%>
<script type="text/javascript"
	src="<c:url value="/resources/js/pages/registration.js"/>"></script>
</body>
</html>
