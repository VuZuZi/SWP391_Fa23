<%-- 
    Document   : Login
    Created on : Oct 6, 2023, 1:42:37 PM
    Author     : ASUS
--%>


<!doctype html>
<html lang="en">

    <head>
        <title>JobC</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


        <link rel="stylesheet" href="css/custom-bs.css">
        <link rel="stylesheet" href="css/jquery.fancybox.min.css">
        <link rel="stylesheet" href="css/bootstrap-select.min.css">
        <link rel="stylesheet" href="fonts/icomoon/style.css">
        <link rel="stylesheet" href="fonts/line-icons/style.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/animate.min.css">
        <link rel="stylesheet" href="css/quill.snow.css">


        <!-- MAIN CSS -->
        <link rel="stylesheet" href="css/style.css">
    </head>

    <body id="top">

        <div id="overlayer"></div>
        <div class="loader">
            <div class="spinner-border text-primary" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>


        <div class="site-wrap">

            <div class="site-mobile-menu site-navbar-target">
                <div class="site-mobile-menu-header">
                    <div class="site-mobile-menu-close mt-3">
                        <span class="icon-close2 js-menu-toggle"></span>
                    </div>
                </div>
                <div class="site-mobile-menu-body"></div>
            </div> <!-- .site-mobile-menu -->


            <!-- NAVBAR -->
            <header class="site-navbar mt-3">
                <div class="container-fluid">
                    <div class="row align-items-center">
                        <div class="site-logo col-6"><a href="index.html">JobC</a></div>

                        <nav class="mx-auto site-navigation">
                            <ul class="site-menu js-clone-nav d-none d-xl-block ml-0 pl-0">
                                <li><a href="indexServlet" class="nav-link">Home</a></li>
                            </ul>
                        </nav>

                        <div class="right-cta-menu text-right d-flex aligin-items-center col-6">
                            <div class="ml-auto">
                                <a href="SignUpServlet" class="btn btn-primary border-width-2 d-none d-lg-inline-block"><span
                                        class="mr-2 icon-lock_outline"></span>Sign Up</a>
                            </div>
                        </div>

                    </div>
                </div>
            </header>

            <!-- HOME -->
            <section class="section-hero overlay inner-page bg-image" style="background-image: url('images/hero_1.jpg');"
                     id="home-section">
                <div class="container">
                    <div class="row">
                        <div class="col-md-7">
                            <h1 class="text-white font-weight-bold">Home/Login</h1>
                            <div class="custom-breadcrumbs">
                                <a href="indexServlet">Home</a> <span class="mx-2 slash">/</span>
                                <span class="text-white"><strong>Log In</strong></span>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

            <section class="site-section">
                <div class="container">
                    <div class="row">
                        <div class="offset-3 col-lg-6 mb-5">
                            <h2 class="mb-4">Log In To JobC</h2>
                            <div class="message-response h5 mt-3 " style="color: red">
                                ${inputError}
                            </div>
                            <form action="LoginServlet" method="POST" class="p-4 border rounded">
                                <div class="form-group mb-3">
                                    <label class="label" for="">Email</label>
                                    <input type="text" class="form-control" id="username-input" name="username-login" placeholder="Username">
                                    <span class="message-form"></span>
                                </div>
                                <div class="form-group mb-3">
                                    <label class="label" for="">Password</label>
                                    <input type="password" class="form-control" id="pass-input" name="pass-login" placeholder="Password">
                                    <span class="message-form"></span>
                                </div>

                                <div class="form-group mb-4">
                                    <label class="label" for="role">Role</label>
                                    <select class="form-control" name="role-login">
                                        <option value="User">User</option>
                                        <option value="Enterprise">Enterprise</option>

                                    </select>
                                </div>

                                <div class="form-group mb-4">
                                    <div class="row justify-content-center">
                                        <div class="form-check col-lg-6 text-center">
                                            <input class="form-check-input" type="checkbox" value="" name="remember" value="on" id="flexCheckDefault">
                                            <label class="form-check-label" for="flexCheckDefault">
                                                Remember me ?
                                            </label>
                                        </div>
                                        <div class="col-lg-6 text-center">
                                            <a class="form-check-label" href="ForgotPasswordServlet">
                                                Forgot Password
                                            </a>
                                        </div>
                                    </div>
                                </div>


                                <div class="row form-group">
                                    <div class="col-md-12 text-center">
                                        <button type="submit" class="btn px-5 btn-primary text-white">Login</button>
                                    </div>
                                </div>

                                <div class="text-center">
                                    <label> Or login with</label>
                                </div>

                                <form action="LoginGGServlet" method="GET" class="p-4 border rounded">
                                    <div class="d-flex form-group justify-content-between">
                                        <div class="col-md-6 text-center">
                                            <button href="https://accounts.google.com/o/oauth2/auth?scope=profile+email&redirect_uri=http://localhost:8080/SWP_JC/LoginGGServlet&response_type=code&client_id=311060052304-v29rma73e6ji73uaroul7b4nft79iods.apps.googleusercontent.com&approval_prompt=force" type="submit" class="btn px-4 btn-primary text-white">
                                                <span class="">
                                                    <i class="icon-google "></i>
                                                </span>
                                                Google Account
                                            </button>
                                        </div>
                                        <div class="col-md-6 text-center">
                                            <button type="submit" class="btn px-4 btn-primary text-white">
                                                <span class="">
                                                    <i class="icon-facebook "></i>
                                                </span>
                                                Facebook Account
                                            </button>
                                        </div>
                                    </div>
                                </form>

                            </form>
                        </div>
                    </div>
                </div>
            </section>
            <footer class="site-footer">

                <a href="#top" class="smoothscroll scroll-top">
                    <span class="icon-keyboard_arrow_up"></span>
                </a>

                <div class="container">
                    <div class="row mb-5">
                        <div class="col-6 col-md-3 mb-4 mb-md-0">
                            <h3>Search Trending</h3>
                            <ul class="list-unstyled">
                                <li><a href="#">Web Design</a></li>
                                <li><a href="#">Graphic Design</a></li>
                                <li><a href="#">Web Developers</a></li>
                                <li><a href="#">Python</a></li>
                                <li><a href="#">HTML5</a></li>
                                <li><a href="#">CSS3</a></li>
                            </ul>
                        </div>
                        <div class="col-6 col-md-3 mb-4 mb-md-0">
                            <h3>Company</h3>
                            <ul class="list-unstyled">
                                <li><a href="#">About Us</a></li>
                                <li><a href="#">Career</a></li>
                                <li><a href="#">Blog</a></li>
                                <li><a href="#">Resources</a></li>
                            </ul>
                        </div>
                        <div class="col-6 col-md-3 mb-4 mb-md-0">
                            <h3>Support</h3>
                            <ul class="list-unstyled">
                                <li><a href="#">Support</a></li>
                                <li><a href="#">Privacy</a></li>
                                <li><a href="#">Terms of Service</a></li>
                            </ul>
                        </div>
                        <div class="col-6 col-md-3 mb-4 mb-md-0">
                            <h3>Contact Us</h3>
                            <div class="footer-social">
                                <a href="#"><span class="icon-facebook"></span></a>
                                <a href="#"><span class="icon-twitter"></span></a>
                                <a href="#"><span class="icon-instagram"></span></a>
                                <a href="#"><span class="icon-linkedin"></span></a>
                            </div>
                        </div>
                    </div>

                    <div class="row text-center">
                        <div class="col-12">
                            <p class="copyright"><small>
                                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                    Copyright &copy;
                                    <script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made
                                    with <i class="icon-heart text-danger" aria-hidden="true"></i> by <a href="https://colorlib.com"
                                                                                                         target="_blank">Colorlib</a>
                                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                </small></p>
                        </div>
                    </div>
                </div>
            </footer>

        </div>

        <!-- SCRIPTS -->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="js/isotope.pkgd.min.js"></script>
        <script src="js/stickyfill.min.js"></script>
        <script src="js/jquery.fancybox.min.js"></script>
        <script src="js/jquery.easing.1.3.js"></script>

        <script src="js/jquery.waypoints.min.js"></script>
        <script src="js/jquery.animateNumber.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/quill.min.js"></script>


        <script src="js/bootstrap-select.min.js"></script>

        <script src="js/custom.js"></script>



    </body>

</html>