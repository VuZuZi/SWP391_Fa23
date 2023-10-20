<%-- 
    Document   : managerPost
    Created on : 19-10-2023, 23:20:50
    Author     : dinhv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <meta name="author" content="Free-Template.co" />
    <link rel="shortcut icon" href="ftco-32x32.png">
    
    <link rel="stylesheet" href="css/custom-bs.css">
    <link rel="stylesheet" href="css/jquery.fancybox.min.css">
    <link rel="stylesheet" href="css/bootstrap-select.min.css">
    <link rel="stylesheet" href="fonts/icomoon/style.css">
    <link rel="stylesheet" href="fonts/line-icons/style.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/animate.min.css">
    <link rel="stylesheet" href="css/jobDetail.css">
    <link rel="stylesheet" href="css/jobManager.css">


    <!-- <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css"> -->

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">




    <!-- MAIN CSS -->
    <link rel="stylesheet" href="css/style.css">    
    </head>
    <body>
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
    
    <section class="home-section section-hero overlay bg-image" style="background-image: url('images/hero_1.jpg');;" id="home-section">
        <div class="container">
            <div class="row">
                <div class="col-3">
                  <div class="sidebar">
                    <ul>
                        <li onclick="show(1)"><a href="#">Post by cpmpany good check</a></li>
                        <li onclick="show(2)"><a href="#">Post by company nun-check</a></li>
                        <li onclick="show(3)"><a href="#">Manager Job</a></li>
                        <li onclick="show(4)"><a href="#">Manager Blocked</a></li>
                    </ul>
                </div>
                <div class="content">
                    <!-- Your page content goes here -->
                </div>
                </div>
                <div class="col-9">
                    <table id="table_goodC" style="display: none;">
                        <tr>
                            <th colspan="12">Post by company good check</th>
                        </tr>
                        <tr>
                            <td>Company Name</td>
                            <td>Report</td>
                            <td>Been Report</td>
                            <td>Type</td>
                            <td>Title</td>
                            <td>description</td>
                            <td>Skill</td>
                            <td>Location</td>
                            <td>Date</td>
                            <td>Accept</td>
                            <td>Reject</td>
                            <td>Block</td>
                        </tr>
                        <tr>
                            <td>Company Name 1</td>
                            <td>3</td>
                            <td>2</td>
                            <td>Full Time</td>
                            <td></td>
                            <td>Description 1</td>
                            <td>Skill 1</td>
                            <td>Location 1</td>
                            <td>2023-09-05</td>
                            <td id="button"><button><i class="fa-solid fa-check"></i></button></td>
                            <td id="button"><button><i class="fa-solid fa-xmark"></i></button></td>
                            <td id="button"><button><i class="fa-solid fa-ban"></i></button></td>
                        </tr>
                        <tr>
                            <td>Company Name 2</td>
                            <td>1</td>
                            <td>4</td>
                            <td>Part Time</td>
                            <td></td>
                            <td>Description 2</td>
                            <td>Skill 2</td>
                            <td>Location 2</td>
                            <td>2023-09-06</td>
                            <td id="button"><button><i class="fa-solid fa-check"></i></button></td>
                            <td id="button"><button><i class="fa-solid fa-xmark"></i></button></td>
                            <td id="button"><button><i class="fa-solid fa-ban"></i></button></td>
                        </tr>
                    </table>
                    <table id="table_nunC" style="display: none;">
                        <tr>
                            <th colspan="11">Post by company good check</th>
                        </tr>
                        <tr>
                            <td>Company Name</td>
                            <td>Report</td>
                            <td>Been Report</td>
                            <td>Type</td>
                            <td>description</td>
                            <td>Skill</td>
                            <td>Location</td>
                            <td>Date</td>
                            <td>Accept</td>
                            <td>Reject</td>
                            <td>Block</td>
                        </tr>
                        <tr>
                            <td>Company Name 1</td>
                            <td>3</td>
                            <td>2</td>
                            <td>Full Time</td>
                            <td>Description 1</td>
                            <td>Skill 1</td>
                            <td>Location 1</td>
                            <td>2023-09-05</td>
                            <td id="button"><button><i class="fa-solid fa-check"></i></button></td>
                            <td id="button"><button><i class="fa-solid fa-xmark"></i></button></td>
                            <td id="button"><button><i class="fa-solid fa-ban"></i></button></td>
                        </tr>
                        <tr>
                            <td>Company Name 2</td>
                            <td>1</td>
                            <td>4</td>
                            <td>Part Time</td>
                            <td>Description 2</td>
                            <td>Skill 2</td>
                            <td>Location 2</td>
                            <td>2023-09-06</td>
                            <td id="button"><button><i class="fa-solid fa-check"></i></button></td>
                            <td id="button"><button><i class="fa-solid fa-xmark"></i></button></td>
                            <td id="button"><button><i class="fa-solid fa-ban"></i></button></td>
                        </tr>
                    </table>

                    <table id="table_report" style="display: none;">
                        <tr>
                            <th colspan="9">Manager Job</th>
                        </tr>
                        <tr>
                            <td>Job Title</td>
                            <td>Company</td>
                            <td>Type</td>
                            <td>Report Title</td>
                            <td>description</td>
                            <td>War sent to company</td>
                            <td>Warming</td>
                            <td>Block Job</td>
                            <td>Block Company</td>
                            
                        </tr>
                        <tr>
                            <td>Job 1</td>
                            <td>Company A</td>
                            <td>Full Time</td>
                            <td>Report 1</td>
                            <td>Description 1 </td>
                            <td>Yes</td>
                            <td><button><i class="fa-solid fa-square-arrow-up-right"></i></button></td>
                            <td><button><i class="fa-solid fa-ban"></i></button></td>
                            <td><button><i class="fa-solid fa-lock"></i></i></button></td>
                        </tr>
                        <tr>
                            <td>Job 2</td>
                            <td>Company B</td>
                            <td>Part Time</td>
                            <td>Report 2</td>
                            <td>Description 2 </td>
                            <td>No</td>
                            <td><button><i class="fa-solid fa-square-arrow-up-right"></i></button></td>
                            <td><button><i class="fa-solid fa-ban"></i></button></td>
                            <td><button><i class="fa-solid fa-lock"></i></button></td>
                        </tr>
                    </table>
                    <table id="history" style="display: none;">
                      <tr>
                        <th colspan="9">Blocked</th>
                    </tr>
                    <tr>
                        <td>Job Title</td>
                        <td>Company</td>
                        <td>Type</td>
                        <td>Report Title</td>
                        <td>description</td>
                        <td>Time block job</td>
                        <td>Repost</td>
                        <td>Time blcok company</td>
                        <td>Unlock</td>
                    </tr>
                    <tr>
                      <td>Job 1</td>
                            <td>Company A</td>
                            <td>Full Time</td>
                            <td>Report 1</td>
                            <td>Description 1 </td>
                            <td>11/11/23</td>
                            <td><button><i class="fa-solid fa-lock-open"></i></button></td>
                            <td>11/11/23</td>
                            <td><button><i class="fa-solid fa-lock-open"></i></button></td>
                    </tr>

                    </table>
                    
                </div>
            </div>
          </div>
    </section>
    

    
  
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
      </script> -->
      <script>
        function show(x){
          if(x==1){
            document.getElementById("table_goodC").style.display="block";
            document.getElementById("history").style.display="none";
            document.getElementById("table_nunC").style.display="none";
            document.getElementById("table_report").style.display="none";
          }
          if(x==2){
            document.getElementById("table_goodC").style.display="none";
            document.getElementById("history").style.display="none";
            document.getElementById("table_nunC").style.display="block";
            document.getElementById("table_report").style.display="none";
          }
          if(x==3){
            document.getElementById("table_goodC").style.display="none";
            document.getElementById("history").style.display="none";
            document.getElementById("table_nunC").style.display="none";
            document.getElementById("table_report").style.display="block";
          }
          if(x==4){
            document.getElementById("table_goodC").style.display="none";
            document.getElementById("history").style.display="block";
            document.getElementById("table_nunC").style.display="none";
            document.getElementById("table_report").style.display="none";
          }
        }
      </script>

    
      
      


     
  </body>
</html>
