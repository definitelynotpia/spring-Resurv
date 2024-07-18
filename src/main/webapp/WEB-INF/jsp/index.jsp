
<!DOCTYPE html>
<html>
<head>
    <title>ReSurv Login</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<h2>Login</h2>
<div class="login-form">
    <form method="post">
        Email: <input class="form-control" type="text" name="email" placeholder="Email"><br>
        Password: <input class="form-control" type="password" name="password" placeholder="Password"><br>
        <button>Login</button>

        <h3>${errorMsg}</h3>
    </form>
</div>


No Account? Register Here:
<input type="submit" value="Register">
</body>
</html>
