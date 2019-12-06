<%@ page session="false"%>
<%@include file="header.jsp"%>
<!-- Resolves issues when user press "Back" button after Logging in -->
<script type="text/javascript">
jQuery(document).ready(function($) {
	  if (window.history && window.history.pushState) {
	    window.history.pushState('forward', null, './#forward');
	    $(window).on('popstate', function() {
	      alert('Back button was pressed.');
	    });
	  }
	});
</script>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="wrapper">
						<form name='loginForm'
							action="<c:url value='j_spring_security_check' />" method='POST'>
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
								<div class="top5">
									<button type="submit"
										class="btn btn-success col-md-6 col-md-offset-3">Login</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="col-md-4 col-md-offset-4">
	<c:if test="${param.error == 'true'}">
		<div class="alert alert-danger">
			<strong>Error!</strong> Username or password is incorrect or there
			are no such user.
		</div>
	</c:if>

	<div class="alert alert-info">
		<center>
			Click <strong><a href="<c:url value="/registration"/>">here</a></strong>
			to register
		</center>
	</div>
</div>

<%@include file="footer.jsp"%>
</body>
</html>