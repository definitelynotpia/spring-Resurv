
<!DOCTYPE html>
<html>
<head>
    <title>ReSurv Login</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/login.css">
</head>
<body>

<div class="login-form">

    <div class="container-fluid">
        <h2>Login</h2>
        <form method="post">
            Email: <input class="form-control mt-3" type="text" name="email"
                          placeholder="Email"><br>
            Password: <input class="form-control mt-3" type="password" name="password" placeholder="Password"><br>
            <button class="btn btn-block btn-success mt-3">Login</button>


            <h3>${errorMsg}</h3>

            No Account? Register Here: <br>
            <button class="btn btn-block btn-secondary mt-3">Register</button>
        </form>
    </div>
</div>



</body>
</html>
