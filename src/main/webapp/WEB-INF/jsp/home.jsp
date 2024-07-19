<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
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
                    <a class="btn btn-sm btn-outline-secondary" href="#">Log out</a>
                </div>
            </div>
        </header>

        <div class="nav-scroller py-1 mb-2">
            <nav class="nav d-flex justify-content-between">
                <a class="p-2 text-dark" href="#">Home</a>
                <a class="p-2 text-muted" href="#">Booking</a>
                <a class="p-2 text-muted" href="#">History</a>
                <a class="p-2 text-muted" href="#">Contact Us</a>
            </nav>
        </div>

        <div class="jumbotron p-3 p-md-5 text-white rounded bg-dark">
            <div class="col-md-6 px-0">
                <h1 class="display-4 font-italic">Eat in comfort and style whenever you want.</h1>
                <p class="lead my-3">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus bibendum tellus a eleifend auctor. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae.</p>
                <p class="lead mb-0"><a href="#" class="text-white font-weight-bold">Continue reading...</a></p>
            </div>
        </div>

        <div class="row mb-2">
            <div class="col-md-6">
                <div class="card flex-md-row mb-4 box-shadow h-md-250">
                    <div class="card-body d-flex flex-column align-items-start">
                        <h3 class="mb-0 text-success">Want to dine with us?</h3>
                        <p class="card-text mb-auto">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus bibendum tellus a eleifend auctor. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae</p>
                        <a href="#">Book a table now.</a>
                    </div>
                    <img class="card-img-right flex-auto d-none d-md-block" data-src="holder.js/200x250?theme=thumb" alt="Thumbnail [200x250]" src="https://img.freepik.com/free-photo/traditional-nasi-lemak-meal-composition_23-2149056821.jpg?t=st=1721389455~exp=1721393055~hmac=7d5ba0fbd6c7acfe6ad36bd174a1f02a12e60655ca05c80575c25bb12c83689f&w=900" data-holder-rendered="true" style="width: 200px; height: 250px;">
                </div>
            </div>
            <div class="col-md-6">
                <div class="card flex-md-row mb-4 box-shadow h-md-250">
                    <div class="card-body d-flex flex-column align-items-start">
                        <h3 class="mb-0 text-primary">Need us to jog your memory?</h3>
                        <p class="card-text mb-auto">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus bibendum tellus a eleifend auctor. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae</p>
                        <a href="#">See our history</a>
                    </div>
                    <img class="card-img-right flex-auto d-none d-md-block" data-src="holder.js/200x250?theme=thumb" alt="Thumbnail [200x250]" src="https://img.freepik.com/free-photo/female-friends-eating-seafood-dish-with-salmon-together_23-2150463270.jpg?t=st=1721382980~exp=1721386580~hmac=0134b9e1c11e42e36b410641de67883d70ef9b1d02ea762ee08e3c6153851a6f&w=900" data-holder-rendered="true" style="width: 200px; height: 250px;">
                </div>
            </div>
        </div>
    </div>
</body>
</html>