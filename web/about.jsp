<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <meta name="author" content="Free-Template.co" />
    <link rel="shortcut icon" href="ftco-32x32.png">
    <link rel='stylesheet' href='css/jobDetail.css'>
    <link rel="stylesheet" href="css/custom-bs.css">
    <link rel="stylesheet" href="css/jquery.fancybox.min.css">
    <link rel="stylesheet" href="css/bootstrap-select.min.css">
    <link rel="stylesheet" href="fonts/icomoon/style.css">
    <link rel="stylesheet" href="fonts/line-icons/style.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/animate.min.css">
     <link rel="stylesheet" href="css/style.css">   
    <script src='main.js'></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
    <div>
<!--    <div class="site-mobile-menu site-navbar-target">
      <div class="site-mobile-menu-header">
        <div class="site-mobile-menu-close mt-3">
          <span class="icon-close2 js-menu-toggle"></span>
        </div>
      </div>
      <div class="site-mobile-menu-body"></div>
    </div>  .site-mobile-menu -->
    

    <!-- NAVBAR -->
    <header class="site-navbar mt-3">
      <div class="container-fluid">
        <div class="row align-items-center">
          <div class="site-logo col-6"><a href="index.html">JobBoard</a></div>

          <nav class="mx-auto site-navigation">
            <ul class="site-menu js-clone-nav d-none d-xl-block ml-0 pl-0">
              <li><a href="index.html" class="nav-link active">Home</a></li>
              <li><a href="about.html">About</a></li>
              <li class="has-children">
                <a href="job-listings.html">Job Listings</a>
                <ul class="dropdown">
                  <li><a href="job-single.html">Job Single</a></li>
                  <li><a href="post-job.html">Post a Job</a></li>
                </ul>
              </li>
              <li class="has-children">
                <a href="services.html">Pages</a>
                <ul class="dropdown">
                  <li><a href="services.html">Services</a></li>
                  <li><a href="service-single.html">Service Single</a></li>
                  <li><a href="blog-single.html">Blog Single</a></li>
                  <li><a href="portfolio.html">Portfolio</a></li>
                  <li><a href="portfolio-single.html">Portfolio Single</a></li>
                  <li><a href="testimonials.html">Testimonials</a></li>
                  <li><a href="faq.html">Frequently Ask Questions</a></li>
                  <li><a href="gallery.html">Gallery</a></li>
                </ul>
              </li>
              <li><a href="blog.html">Blog</a></li>
              <li><a href="contact.html">Contact</a></li>
              <li class="d-lg-none"><a href="post-job.html"><span class="mr-2">+</span> Post a Job</a></li>
              <li class="d-lg-none"><a href="login.html">Log In</a></li>
            </ul>
          </nav>
          
          <div class="right-cta-menu text-right d-flex aligin-items-center col-6">
            <div class="ml-auto">

              <a href="#" class="btn btn-outline-white border-width-2 d-none d-lg-inline-block"><span class="mr-2 icon-add"></span>Post a job</a>
              <div class="dropdown d-none d-lg-inline-block">
                <button class="btn btn-primary border-width-2  dropdown-toggle" type="button" id="signUp" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  Account
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                  <a class="dropdown-item" href="#">Log out</a>
                  
                </div>
              </div>
              
              <!-- <a href="login.html" class="btn btn-primary border-width-2 d-none d-lg-inline-block"><span class="mr-2 icon-lock_outline"></span>Log In</a> -->
            </div>
            <a href="#" class="site-menu-toggle js-menu-toggle d-inline-block d-xl-none mt-lg-2 ml-3"><span class="icon-menu h3 m-0 p-0 mt-2"></span></a>
          </div>

        </div>
      </div>
    </header>
    <div class="main">
    <div class="container">
        <div class="row">
            <div class="col-4 title" >Title</div>
            <div class="col-4"></div>
            <div class="col-4">type</div>
        </div>
        <div class="row">
            <div class="col-4" style="font-family: 'Courier New', Courier, monospace;">CompanyName</div>
        </div>
        <div class="row">
            <div class="col-4 location">Location</div>
            <div class="col-4"></div>
            <div class="col-4">Salary</div>
        </div>

        <!-- //text box descriptin -->
        <div class="row">
            <div class="col-1"></div>
            <div class="col-7 box-des"></div>
            <div class="col-3 box-skill">skill</div>
            <div class="col-1"></div>
        </div>
        <div class="row">
            <div class="col-1"></div>
            <div class="col-1">
                <button class="btn btn-link" style="border: none;">
                    <i class="fas fa-heart"></i>
                  </button>
            </div>
            <div class="col-1">
                <button class="btn btn-link" style="border: none;"><i class="fa-regular fa-comment"></i></button>
            </div>
            <div class="col-1"><button class="btn btn-link" style="border: none;"><i class="fa-solid fa-share"></i></button></div>
            <div class="col-4"></div>
            <div class="col-1">
                <button class="btn btn-link" style="border: none;"><i class="fa-regular fa-flag"></i></button>
            </div>
        </div>
        <div class="row">
            <div class="col-1"></div>
            <div class="col-9">
                <input type="text" id="newComment" placeholder="New comment" style="width: 100%;">
            </div>
            <div class="col-1"><button id="addButton"><i class="fa-brands fa-pushed"></i></button></div>
            <div class="col-"></div>
        </div>
        <script>
            document.getElementById("addButton").addEventListener("click", function() {
                var inputElement = document.getElementById("newComment");
                var comment = inputElement.value;
        
                if (comment) {
                    // Thêm mã để xử lý comment ở đây, ví dụ: thêm vào danh sách hiển thị
                    alert("Comment added: " + comment);
                    inputElement.value = ""; // Xóa nội dung trong ô input
                }
            });
        </script>
        
        
        <div class="media comment-media">
            <img src="https://images.unsplash.com/photo-1508919801845-fc2ae1bc2a28?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8aW1nfGVufDB8fDB8fHww&w=1000&q=80" alt="" class="mr-3 image comment-image">
            <div class="media-body comment-body">
              <h5 class="mt-0">Name</h5>
              <p>
                Comment content
              </p>
              
            </div>
          </div>
    </div>
    </div>
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
    
    <script src="js/bootstrap-select.min.js"></script>
    
    <script src="js/custom.js"></script>

</body>
</html>