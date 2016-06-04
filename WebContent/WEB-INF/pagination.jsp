
<nav>
	<ul class="pagination">
		<c:if test="${page.previousPage>-1}">
			<li><a href="findStudent.do?ps=${page.previousPage}<c:if test="${not empty searchKey}">&search=${searchKey}</c:if>"
				aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
			</a></li>
		</c:if>
		<c:if test="${page.previousPage<=-1}">
			<li class="disabled"><span aria-label="Previous"> <span
					aria-hidden="true">&laquo;</span>
			</span></li>
		</c:if>

		<c:forEach var="i" begin="1" end="${page.totalPages}">
			<c:if test="${page.page==i}">
				<li class="active"><span><c:out value="${i}" /></span></li>
			</c:if>
			<c:if test="${page.page!=i}">
				<li><a
					href="findStudent.do?ps=<c:out value="${(i-1)*page.numPerPage}"/><c:if test="${not empty searchKey}">&search=${searchKey}</c:if>"><c:out
							value="${i}" /></a></li>
			</c:if>
		</c:forEach>


		<c:if test="${page.nextPage>-1}">
			<li><a href="findStudent.do?ps=${page.nextPage}<c:if test="${not empty searchKey}">&search=${searchKey}</c:if>"
				aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>
		</c:if>
		<c:if test="${page.nextPage<=-1}">
			<li class="disabled"><span aria-label="Next"> <span
					aria-hidden="true">&raquo;</span>
			</span></li>
		</c:if>

	</ul>
</nav>