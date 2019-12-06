<%@include file="header.jsp"%>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
		
          <div class="col-md-12">
                <br />
                <h4>Default: Here is a list of top rated films you havn't seen yet</h4>
                <hr />
                <c:forEach var="film" items="${filmsByAvgRating}">
                    <a href="<c:url value="/user/film/${film.id}"/>"
                        style="color: black;" onMouseOver="this.style.color='#00008B';"
                        onMouseOut="this.style.color='black';">
                        <div class="col-md-2"
                            style="text-align: center; padding-bottom: 30px; height: 300px;">
                            <p>${film.title}
                                (${film.year})<br /> Average rating:
                                <fmt:formatNumber value="${film.avgRating}" type="number"
                                    pattern="#.##" />
                                <br /> <img src="${film.poster}"
                                    width="150px" height="200px" />
                        </div>
                    </a>
                </c:forEach>
            </div>           

			<c:if test="${not empty films}" var="flag">
				<div class="col-md-12">
				    <br />
                       <h4>UserBased: Here is a list of recommended for you films. It's based on
                       Users who has the same preferences as you.</h4>
                       <hr />
					<c:forEach var="film" items="${films}">
						<a href="<c:url value="/user/film/${film.id}"/>"
							style="color: black;" onMouseOver="this.style.color='#00008B';"
							onMouseOut="this.style.color='black';">
							<div class="col-md-2" style="text-align: center; padding-bottom: 30px; height: 300px;">
								<p>${film.title}
									(${film.year})<br /> Average rating:
									<fmt:formatNumber value="${film.avgRating}" type="number"
										pattern="#.##" />
									<br /> Prediction for you:
									<fmt:formatNumber value="${film.exactUserPrediction}"
										type="number" pattern="#.##" />
								</p>
								<img src="${film.poster}" width="150px"
									height="200px" />
							</div>
						</a>
					</c:forEach>
				</div>
			</c:if>
				
			<c:if test="${not empty itemfilms}" var="flag">
               <div class="col-md-12">
                       <br />
                       <h4>ItemBased: Here is a list of recommended for you films. It's based on
                       the films you liked before.</h4>
                       <hr />
                       <c:forEach var="film" items="${itemfilms}">
                           <a href="<c:url value="/user/film/${film.id}"/>"
                               style="color: black;" onMouseOver="this.style.color='#00008B';"
                               onMouseOut="this.style.color='black';">
                               <div class="col-md-2" style="text-align: center; padding-bottom: 30px; height: 300px;">
	                                <p>${film.title}
	                                    (${film.year})<br /> Average rating:
	                                    <fmt:formatNumber value="${film.avgRating}" type="number"
	                                        pattern="#.##" />
	                                    <br /> Prediction for you:
	                                    <fmt:formatNumber value="${film.exactUserPrediction}"
	                                        type="number" pattern="#.##" />
	                                </p>
	                                <img src="${film.poster}" width="150px"
	                                    height="200px" />
                               </div>
                           </a>
                       </c:forEach>
                </div>
            </c:if>
								
			<c:if test="${not flag}">
				<h3>
					Sorry,The movie data you scored is too small. We can't give you personalized recommendations. Try to rate
					more films. <br /> 
				</h3>
				<hr />					
			</c:if>
			
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>
</body>
</html>