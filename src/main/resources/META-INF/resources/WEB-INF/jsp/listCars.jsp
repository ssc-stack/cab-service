
	<%@ include file="common/header.jspf" %>
    <%@ include file="common/navigation.jspf" %>
		<div class="container">
			<h1>List of Cars</h1>
			<table class="table">
				<thead>
					<tr>
						<th>Car Id</th>
						<th>Model</th>
						<th>Color</th>
						<th>Seating Capacity</th>
						<th>Available For Booking?</th>
						<th>DriverId</th>
                        <th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cars}" var="car">
						<tr>
							<td>${car.id}</td>
							<td>${car.model}</td>
							<td>${car.color}</td>
							<td>${car.seatingCapacity}</td>
							<td>${car.availableForBooking}</td>
							<td>${car.driverId}</td>
                            <td><a href="delete-car?id=${car.id}" class="btn btn-warning">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="add-car" class="btn btn-success">Add Car</a>
		</div>
		<%@ include file="common/footer.jspf" %>
