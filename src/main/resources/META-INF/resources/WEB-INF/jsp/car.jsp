<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">

	<h1>Enter Car Details</h1>

	<form:form method="post" modelAttribute="car">

		<fieldset class="mb-3">
			<form:label path="model">Model</form:label>
			<form:input type="text" path="model" required="required"/>
			<form:errors path="model" cssClass="text-warning"/>
		</fieldset>

		<fieldset class="mb-3">
			<form:label path="color">Color</form:label>
			<form:input type="text" path="color" required="required"/>
			<form:errors path="color" cssClass="text-warning"/>
		</fieldset>

		<fieldset class="mb-3">
        			<form:label path="seatingCapacity">Seating Capacity</form:label>
        			<form:input type="text" path="seatingCapacity" required="required"/>
        			<form:errors path="seatingCapacity" cssClass="text-warning"/>
        </fieldset>

		<input type="submit" class="btn btn-success"/>

	</form:form>

</div>

<%@ include file="common/footer.jspf" %>

