<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css" integrity="sha256-2XFplPlrFClt0bIdPgpz8H7ojnk10H69xRqd9+uTShA=" crossorigin="anonymous" />
<title>Home</title>
</head>
<style>
body{margin-top:20px;}
.product-rating {
    line-height: 22px;
}
.product-rating i {
    color: #fc0;
    display: inline-block;
    margin-right: 2px;
    font-size: 14px;
}
@media screen and (max-width: 1199px) {
    .product-rating {
        margin-bottom: 5px;
        font-size: 15px;
    }
}
@media screen and (max-width: 767px) {
    .product-rating i {
        font-size: 13px;
    }
}
.text-secondary {
    color: #004975 !important;
}
.card-wrapper {
    position: relative;
    overflow: hidden;
}
.card-wrapper .card-img {
    text-align: center;
    position: relative;
    overflow: hidden;
    transition: all 0.3s ease-out;
}
.card-wrapper .card-img img {
    transition: all 0.3s ease-in-out;
    border-radius: 0.25rem;
    border-radius: 0.25rem;
}
.card-wrapper .card-body {
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    visibility: hidden;
    padding: 30px;
    text-align: center;
    display: flex;
    align-items: center;
    justify-content: center;
    border-radius: 0.25rem;
    transform: translateX(-100%);
    transition: 0.8s;
    z-index: 11;
}
.card-wrapper:before {
    content: "";
    width: 100%;
    position: absolute;
    height: 100%;
    top: 0;
    right: 100%;
    z-index: 9;
    transition: 0.8s;
    background: rgba(0, 186, 238, 0.82);
    border-radius: 0.25rem;
}
.card-wrapper:hover:before {
    right: 0;
}
.card-wrapper h3,
.card-wrapper p {
    color: #fff;
}
.card-wrapper .read-more {
    color: #fff;
}
.card-wrapper .read-more:after {
    color: #fff;
}
.card-wrapper:hover .card-body {
    visibility: visible;
    transform: translateX(0px);
}
.card-wrapper:hover .backgound-color {
    right: 0;
}
.ti-shopping-cart:before {
    content: "\e60d";
}
.mb-2-6, .my-2-6 {
    margin-bottom: 2.6rem;
}
.text-primary {
    color: #00baee !important;
}

</style>
<body>

<section>
    <div class="container">
        <div class="row">
            <div class="col-sm-6 col-lg-3 mb-2-6">
                <div class="card-wrapper mb-4">
                    <div class="card-img"><img src="/Images/Bata-240.jpg" alt="..."></div>
                    <div class="card-body">
                        <div>
                            <a href="#"><i class="bg-white p-3 rounded-circle ti-shopping-cart font-weight-600"></i></a>
                        </div>
                    </div>
                </div>
                <div class="text-center">
                    <h4 class="h5 mb-2"><a href="#" class="text-secondary">Bata</a></h4>
                    <div class="product-rating mb-2">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star mr-0"></i>
                    </div>
                    <h5 class="mb-0 text-primary">3000 Rs</h5>
                </div>
            </div>
            <div class="col-sm-6 col-lg-3 mb-2-6">
                <div class="card-wrapper mb-4">
                    <div class="card-img"><img src="/Images/adidas1-240.jpg" alt="..."></div>
                    <div class="card-body">
                        <div>
                            <a href="#"><i class="bg-white p-3 rounded-circle ti-shopping-cart font-weight-600"></i></a>
                        </div>
                    </div>
                </div>
                <div class="text-center">
                    <h4 class="h5 mb-2"><a href="#" class="text-secondary">Adidas</a></h4>
                    <div class="product-rating mb-2">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star mr-0"></i>
                    </div>
                    <h5 class="mb-0 text-primary">2000 Rs</h5>
                </div>
            </div>
            <div class="col-sm-6 col-lg-3 mb-2-6">
                <div class="card-wrapper mb-4">
                    <div class="card-img"><img src="/Images/puma1_240.jpg" alt="..."></div>
                    <div class="card-body">
                        <div>
                            <a href="#"><i class="bg-white p-3 rounded-circle ti-shopping-cart font-weight-600"></i></a>
                        </div>
                    </div>
                </div>
                <div class="text-center">
                    <h4 class="h5 mb-2"><a href="#" class="text-secondary">Puma</a></h4>
                    <div class="product-rating mb-2">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star mr-0"></i>
                    </div>
                    <h5 class="mb-0 text-primary">1500 Rs</h5>
                </div>
            </div>
            <div class="col-sm-6 col-lg-3 mb-2-6">
                <div class="card-wrapper mb-4">
                    <div class="card-img"><img src="/Images/sneak1_240.jpg" alt="..."></div>
                    <div class="card-body">
                        <div>
                            <a href="#"><i class="bg-white p-3 rounded-circle ti-shopping-cart font-weight-600"></i></a>
                        </div>
                    </div>
                </div>
                <div class="text-center">
                    <h4 class="h5 mb-2"><a href="#" class="text-secondary">Sketcher</a></h4>
                    <div class="product-rating mb-2">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star mr-0"></i>
                    </div>
                    <h5 class="mb-0 text-primary">3000 Rs</h5>
                </div>
            </div>
            <div class="col-sm-6 col-lg-3 mb-2-6 mb-lg-0">
                <div class="card-wrapper mb-4">
                    <div class="card-img"><img src="/Images/sneak2_240.jpg" alt="..."></div>
                    <div class="card-body">
                        <div>
                            <a href="#"><i class="bg-white p-3 rounded-circle ti-shopping-cart font-weight-600"></i></a>
                        </div>
                    </div>
                </div>
                <div class="text-center">
                    <h4 class="h5 mb-2"><a href="#" class="text-secondary">Sketcher</a></h4>
                    <div class="product-rating mb-2">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star mr-0"></i>
                    </div>
                    <h5 class="mb-0 text-primary">2000 Rs</h5>
                </div>
            </div>
            <div class="col-sm-6 col-lg-3 mb-2-6 mb-lg-0">
                <div class="card-wrapper mb-4">
                    <div class="card-img"><img src="/Images/nike1_240.jpg" alt="..."></div>
                    <div class="card-body">
                        <div>
                            <a href="#"><i class="bg-white p-3 rounded-circle ti-shopping-cart font-weight-600"></i></a>
                        </div>
                    </div>
                </div>
                <div class="text-center">
                    <h4 class="h5 mb-2"><a href="#" class="text-secondary">Nike</a></h4>
                    <div class="product-rating mb-2">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star mr-0"></i>
                    </div>
                    <h5 class="mb-0 text-primary">2000 Rs</h5>
                </div>
            </div>
            <div class="col-sm-6 col-lg-3 mb-2-6 mb-sm-0">
                <div class="card-wrapper mb-4">
                    <div class="card-img"><img src="/Images/sneakers1-240.jpg" alt="..."></div>
                    <div class="card-body">
                        <div>
                            <a href="#"><i class="bg-white p-3 rounded-circle ti-shopping-cart font-weight-600"></i></a>
                        </div>
                    </div>
                </div>
                <div class="text-center">
                    <h4 class="h5 mb-2"><a href="#" class="text-secondary">Sneaker</a></h4>
                    <div class="product-rating mb-2">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star mr-0"></i>
                    </div>
                    <h5 class="mb-0 text-primary">3500 Rs</h5>
                </div>
            </div>
            <div class="col-sm-6 col-lg-3">
                <div class="card-wrapper mb-4">
                    <div class="card-img"><img src="/Images/addi.jpg" alt="..."></div>
                    <div class="card-body">
                        <div>
                            <a href="#"><i class="bg-white p-3 rounded-circle ti-shopping-cart font-weight-600"></i></a>
                        </div>
                    </div>
                </div>
                <div class="text-center">
                    <h4 class="h5 mb-2"><a href="#" class="text-secondary">Adidas</a></h4>
                    <div class="product-rating mb-2">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star mr-0"></i>
                    </div>
                    <h5 class="mb-0 text-primary">2000 Rs</h5>
                </div>
            </div>
        </div>
    </div>
</section>

</body>
</html>