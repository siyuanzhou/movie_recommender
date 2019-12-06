<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="header.jsp"%>

<!--  div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<form:form method="post" action="insertFilm"
				enctype="multipart/form-data">
				电影名：<input type="text" name="title">
				<br />
				发行日期：<input type="text" name="year">
				<br />
				海报：<input type="file" name="post" />
				<br />
				<input type="submit" value="添加" />
			</form:form>
		</div>
	</div>
</div-->
<div class="container-fluid">
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<div class="panel panel-default">
				<div class="panel-body">

					<div class="wrapper">
						<form:form method="post" action="insertFilm"
							enctype="multipart/form-data">
							<div class="input-group">
								<span class="input-group-addon">电影名：</span> <input type="text"
									name="title" class="form-control" required>
							</div>
							<br />
							<div class="input-group">
								<span class="input-group-addon">发行日期：</span> <input type="text"
									name="year" class="form-control" required>
							</div>
							<br />
							<div class="input-group">
								<span class="input-group-addon">海报：</span> <input type="text"
									name="post" class="form-control" required>
							</div>
							<br />
							<div class="input-group">
                                <span class="input-group-addon">简介：</span> <input type="text"
                                    name="description" class="form-control" required>
                            </div>
							<br />
							<div class="top5">
								<button type="submit"
									class="btn btn-success col-md-6 col-md-offset-3">添加</button>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="footer.jsp"%>
</body>
</html>