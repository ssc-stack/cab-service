<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">

	<h1>Enter Driver Details</h1>
	<form:form method="post" modelAttribute="driver">
		<fieldset class="mb-3">
			<form:label path="username">Username:</form:label>
			<form:input type="text" path="username" required="required"/>
			<form:errors path="username" cssClass="text-warning"/>
		</fieldset>

		<fieldset class="mb-3">
			<form:label path="assignedCarId">Assign CarId:</form:label>
			<form:input type="text" path="assignedCarId" required="required"/>
			<form:errors path="assignedCarId" cssClass="text-warning"/>
		</fieldset>

		<input type="submit" class="btn btn-success"/>

	</form:form>

</div>

<%@ include file="common/footer.jspf" %>

