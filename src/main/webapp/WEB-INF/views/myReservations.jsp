<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>
<% response.setHeader("Pragma", "no-cache"); %>
<% response.setHeader("Expires", "0"); %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <title>My Reservations</title>
</head>
<body>

<div class="container">
    <header class="blog-header py-3">
        <div class="row flex-nowrap justify-content-between align-items-center">
            <div class="col-4 pt-1">${message}</div>
            <div class="col-4 text-center">
                <a class="blog-header-logo text-dark" href="#">ReSurv</a>
            </div>
            <div class="col-4 d-flex justify-content-end align-items-center">
                <a class="btn btn-sm btn-outline-secondary" href="logout">Log out</a>
            </div>
        </div>
    </header>

    <div class="nav-scroller py-1 mb-2">
        <nav class="nav d-flex justify-content-between">
            <a class="p-2 text-muted" href="home">Home</a>
            <a class="p-2 text-dark" href="myReservations">Booking</a>
            <a class="p-2 text-muted" href="#">History</a>
            <a class="p-2 text-muted" href="#">Contact Us</a>
        </nav>
    </div>

    <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col col-xl-10">
            <div class="card" style="border-radius: 1rem;">
                <div class="row g-0">
                    <div class="col-md-6 col-lg-7 d-flex align-items-center">
                        <div class="card-body p-4 p-lg-5 text-black">

                            <h3>${errorMsg}</h3>
                            <div class="h1 fw-bold mb-3 pb-1">My Reservations</div>
                            <table border="2" width="70%" cellpadding="2">
                                <tr>
                                    <th>Reference ID</th>
                                    <th>Table No.</th>
                                    <th>Pax</th>
                                    <th>Date and Time</th>
                                </tr>

                                <c:forEach var="reservation" items="${reservations}">
                                    <tr>
                                        <td>${reservation.reservation_id}</td>
                                        <td>${reservation.tableNo}</td>
                                        <td>${reservation.pax}</td>
                                        <td>${reservation.reservationTimestamp}</td>
                                        <td><a href="/myReservations/edit/${reservation.reservation_id}">Update</a></td>
                                        <td><a href="/myReservations/delete/${reservation.reservation_id}">Delete</a></td>
                                    </tr>
                                </c:forEach>

                            </table>
                            <form class="px-md-2" action="newReservation" method="POST">

                                <div class="pt-1 mb-4">
                                    <button data-mdb-button-init data-mdb-ripple-init class="btn btn-dark btn-lg btn-block">Book a Table</button>
                                </div>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>