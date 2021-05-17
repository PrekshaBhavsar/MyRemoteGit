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
<jsp:include page="Header.jsp"/>
<jsp:include page="Shoes.jsp"/>


</body>
</html>