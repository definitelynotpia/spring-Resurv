<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>
<% response.setHeader("Pragma", "no-cache"); %>
<% response.setHeader("Expires", "0"); %>

<html>
<head>
    <title> Result</title>
</head>
<body>
<div class="login-form">

    <div class="container-fluid">
        <h2>${message}</h2>
        <form action="backToLogin" method="POST">
            <button class="btn btn-block btn-secondary mt-3">Back to Login</button>
        </form>
    </div>
</div>



</body>
</html>