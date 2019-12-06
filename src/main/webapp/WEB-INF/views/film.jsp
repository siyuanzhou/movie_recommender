<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="zh-CN">
<%@include file="header.jsp"%>


<div class="container-fluid">
	<div class="row" style="padding-top: 10px;">
		<div class="col-sm-5" style="text-align: center;">
			<img src="${film.poster}" width="400px"
				height="534px" />
		</div>
		<div class="col-sm-7" style="padding-top: 25px;">
			<div style="margin: auto;">
				<hr />
				<h2>
					Title: ${film.title}<br />
				</h2>
				<h3>Year: ${film.year}</h3>
				<h3>Description: ${film.description}</h3>
				<hr />
				<c:choose>
					<c:when test="${film.avgRating > 0}">
						<h3>Average Rating:</h3>
						<div class="row">
							<div class="col-sm-1">
								(
								<fmt:formatNumber value="${film.avgRating}" type="number"
									pattern="#.##" />
								)
							</div>
							<div class="col-sm-11">
								<input id="outputAvg" name="outputAvg" value="${film.avgRating}"
									class="rating rating-loading" data-size="md"
									data-show-clear="false" data-readonly="true" data-step="0.01" />
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<h3>No ratings yet</h3>
					</c:otherwise>
				</c:choose>
				<br />
				<c:choose>
					<c:when test="${film.exactUserRating > 0}">
						<h3>You have rated this film for:</h3>
						<div class="row">
							<div class="col-sm-1">
								(
								<fmt:formatNumber value="${film.exactUserRating}" type="number"
									pattern="#.##" />
								)
							</div>
							<div class="col-sm-11">
								<input id="outputUser" name="outputUser"
									value="${film.exactUserRating}" class="rating rating-loading"
									data-size="md" data-show-clear="false" data-readonly="true"
									data-step="0.1" />
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<h3>Rate this film</h3>
						<input id="input" class="rating rating-loading" data-min="0.5"
							data-max="5" data-step="0.5" data-size="lg"
							data-show-clear="false" />
						<button class="btn btn-success btn-md" onclick="rate(${film.id});">Rate!</button>
						<sec:authorize access="hasRole('ADMIN')">
						<button type="submit" class="btn btn-success btn-md" onclick="window.location='deleteFilm/${film.id}'">Delete!</button>
						</sec:authorize>
						<hr />
						<c:choose>
							<c:when test="${prediction > 0}">
								<h4>
									We predict:
									<fmt:formatNumber value="${prediction}" type="number"
										pattern="#.##" />
								</h4>
							</c:when>
							<c:otherwise>
								<h4>We can't predict your rating</h4>
							</c:otherwise>
						</c:choose>
					</c:otherwise>
				</c:choose>
				<hr />
			</div>
		</div>
	</div>
</div>

<div class="container">
    <h1>Please Add Comment!</h1>
    <hr/>
    <form:form method="post" action="addComment/${film.id}"
                            enctype="multipart/form-data">
        <div class="form-group">
            <label for="content">Content:</label>
            <textarea class="form-control" id="content" name="content" rows="3" placeholder="Please Input Content"></textarea>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-sm btn-success">add comment!</button>
        </div>
    </form:form>
</div>

<div class="container">

    <h3>All Comment:</h3>

    <!-- 如果评论列表为空 -->
    <c:if test="${empty comments}">
        <div class="alert alert-warning" role="alert">
            <span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>Comment表为空，请添加</a>
        </div>
    </c:if>

    <!-- 如果评论列表非空 -->
    <c:if test="${!empty comments}">
        <table class="table table-bordered table-striped">
            <tr>
                <th style="width:10%">userId</th>
                <th>Comment</th>
            </tr>

            <c:forEach items="${comments}" var="comment">
                <tr>
                    <td>${comment.idUser}</td>
                    <td>${comment.content}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<%@include file="footer.jsp"%>
<script type="text/javascript"
	src="<c:url value="/resources/js/pages/rateFilm.js"/>"></script>
</body>
</html>