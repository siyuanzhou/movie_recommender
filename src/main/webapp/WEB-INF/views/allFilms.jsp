<%@include file="header.jsp"%>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<c:forEach var="film" items="${films}">
				<a href="<c:url value="/user/film/${film.id}"/>"
					style="color: black;" onMouseOver="this.style.color='#00008B';"
					onMouseOut="this.style.color='black';">
					<div class="col-md-2"
						style="text-align: center; padding-bottom: 30px; height: 300px;">
						<p>
							${film.title} (${film.year})<br />
							<c:choose>
								<c:when test="${film.avgRating > 0}">
									Average rating: <fmt:formatNumber value="${film.avgRating}"
										type="number" pattern="#.##" />
								</c:when>
								<c:otherwise>
		        					No ratings yet
								</c:otherwise>
							</c:choose>
						</p>
						<img src="${film.poster}" width="150px"
							height="200px" />
						<!-- <img src="data:image/jpg;base64,${film.poster}" width="85%" height="55%"/> -->
					</div>
				</a>
			</c:forEach>

		</div>
	</div>
</div>

<%@include file="footer.jsp"%>
</body>
</html>