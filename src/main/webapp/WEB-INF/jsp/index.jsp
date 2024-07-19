
<!DOCTYPE html>
<html>
<head>
    <title>Login | Resurv</title>
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

                                <form class="px-md-2" action="login" method="POST">
                                    <div class="h1 fw-bold mb-3 pb-1">ReSurv</div>
                                    <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Sign in to your account</h5>

                                    <div data-mdb-input-init class="form-outline mb-4">
                                        <input type="email" id="email" class="form-control" />
                                        <label class="form-label" for="email">Email</label>
                                    </div>
                                    <div data-mdb-input-init class="form-outline mb-4">
                                        <input type="password" id="password" class="form-control" />
                                        <label class="form-label" for="password">Password</label>
                                    </div>

                                    <div class="pt-1 mb-4">
                                        <button data-mdb-button-init data-mdb-ripple-init class="btn btn-dark btn-lg btn-block">Login</button>
                                    </div>
                                </form>

                                <form action="registerPage" method="POST">
                                    No Account? Register Here: <br>
                                    <button class="btn btn-block btn-secondary mt-3">Register</button>
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
