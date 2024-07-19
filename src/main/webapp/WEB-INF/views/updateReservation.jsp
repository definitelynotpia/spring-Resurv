<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>
<% response.setHeader("Pragma", "no-cache"); %>
<% response.setHeader("Expires", "0"); %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <title>Make A Reservation</title>
</head>
<body>

<div class="container">
    <header class="blog-header py-3">
        <div class="row flex-nowrap justify-content-between align-items-center">
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
                    <div class="col-md-6 col-lg-5 d-none d-md-block">
                        <img src="https://img.freepik.com/free-photo/young-woman-enjoying-delicious-pizza_23-2149028534.jpg?t=st=1721381814~exp=1721385414~hmac=14204773a3cffbc0436c032e41cf5da8a9697c499fe4a5e6d2a924b2bbe25ca8&w=360"
                             alt="login form" class="img-fluid" style="border-radius: 1rem 0 0 1rem;" />
                    </div>
                    <div class="col-md-6 col-lg-7 d-flex align-items-center">
                        <div class="card-body p-4 p-lg-5 text-black">

                            <h3>${errorMsg}</h3>

                            <form class="px-md-2" action="/myReservations/edit/${id}" method="POST">
                                <div class="h1 fw-bold mb-3 pb-1">Update my Reservation</div>
                                <h2>${message}</h2>
                                <div data-mdb-input-init class="form-outline mb-4">
                                    <input type="number" id="tableNo" name="tableNo" class="form-control" />
                                    <label class="form-label" for="tableNo">Table no.</label>
                                </div>
                                <div data-mdb-input-init class="form-outline mb-4">
                                    <input type="number" id="pax" name="pax" class="form-control" min="2" max="10"/>
                                    <label class="form-label" for="pax">Number of guests</label>
                                </div>
                                <div data-mdb-input-init class="form-outline mb-4">
                                    <input type="datetime-local" id="reserveDate" name="reservationTimestamp" class="form-control"/>
                                    <label class="form-label" for="reserveDate">Reserved date and time</label>
                                </div>
                                <div class="pt-1 mb-4">
                                    <button data-mdb-button-init data-mdb-ripple-init class="btn btn-dark btn-lg btn-block">Confirm Booking</button>
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