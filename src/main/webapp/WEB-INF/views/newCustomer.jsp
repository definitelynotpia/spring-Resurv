<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>
<% response.setHeader("Pragma", "no-cache"); %>
<% response.setHeader("Expires", "0"); %>

<!DOCTYPE html>
<html>
<head>
    <title>ReSurv Customer Registration</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col col-xl-10">
            <div class="card" style="border-radius: 1rem;">
                <div class="row g-0">
                    <div class="col-md-6 col-lg-5 d-none d-md-block">
                        <img src="https://img.freepik.com/free-photo/top-view-eid-al-fitr-celebration-with-delicious-food_23-2151205107.jpg?t=st=1721388046~exp=1721391646~hmac=e30daf5b3c318be95e054fda101449d3429b8625040c97f9e1568211e184ea4a&w=360"
                             alt="login form" class="img-fluid" style="border-radius: 1rem 0 0 1rem;" />
                    </div>
                    <div class="col-md-6 col-lg-7 d-flex align-items-center">
                        <div class="card-body p-4 p-lg-5 text-black">

                            <h3>${errorMsg}</h3>

                            <form class="px-md-2" action="result" method="POST">
                                <div class="h1 fw-bold mb-3 pb-1">ReSurv</div>
                                <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Sign in to your account</h5>

                                <div data-mdb-input-init class="form-outline mb-4">
                                    <label class="form-label" for="fname">First Name</label>
                                    <input class="form-control mt-3" type="text" id="fname" name="fname" placeholder="First Name"/>
                                </div>
                                <div data-mdb-input-init class="form-outline mb-4">
                                    <label class="form-label" for="lname">Last Name</label>
                                    <input class="form-control mt-3" type="text" id="lname" name="lname" placeholder="Last Name"/>
                                </div>

                                <div data-mdb-input-init class="form-outline mb-4">
                                    <label class="form-label" for="email">Email</label>
                                    <input type="email" id="email" name="email" class="form-control" />
                                </div>
                                <div data-mdb-input-init class="form-outline mb-4">
                                    <label class="form-label" for="password">Password</label>
                                    <input type="password" id="password" name="password" class="form-control" />
                                </div>

                                <div class="pt-1 mb-4">
                                    <button data-mdb-button-init data-mdb-ripple-init class="btn btn-dark btn-lg btn-block">Register</button>
                                </div>
                            </form>

                            <form action="backToLogin" method="POST">
                                Already have an account?<br>
                                <button class="btn btn-block btn-secondary mt-3">Login</button>
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