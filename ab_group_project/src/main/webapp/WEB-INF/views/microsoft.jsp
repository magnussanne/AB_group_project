<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Microsoft</title>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="shortcut icon" href="image/favicon.png" type="image/x-icon">
  <!-- Bootstrap , fonts & icons  -->
  <link rel="stylesheet" href="css/bootstrap.css">
  <link rel="stylesheet" href="fonts/icon-font/css/style.css">
  <link rel="stylesheet" href="fonts/typography-font/typo.css">
  <link rel="stylesheet" href="fonts/fontawesome-5/css/all.css">
  <link href="https://fonts.googleapis.com/css2?family=Karla:wght@300;400;500;600;700;800&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Gothic+A1:wght@400;500;700;900&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Work+Sans:wght@400;500;600;700;800;900&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Rubik:wght@400;500;600;700;800;900&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700;800;900&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@400;600;700;800;900&display=swap" rel="stylesheet">
  <!-- Plugin'stylesheets  -->
  <link rel="stylesheet" href="plugins/aos/aos.min.css">
  <link rel="stylesheet" href="plugins/slick/slick.min.css">
  <!-- Vendor stylesheets  -->
  <link rel="stylesheet" href="css/main.css">
   <link rel="stylesheet" href="stockDetails.css">
</head>
<body>
<header class="site-header site-header--menu-left landing-11-menu site-header--absolute site-header--sticky">
      <div class="container">
        <nav class="navbar site-navbar">
          <!-- Brand Logo-->
          <div class="brand-logo">
            <a href="/">
              <!-- light version logo (logo must be black)-->
              MNS Trading
              <!-- Dark version logo (logo must be White)-->
            </a>
          </div>
          <div class="menu-block-wrapper">
            <div class="menu-overlay"></div>
            <nav class="menu-block" id="append-menu-header">
              <div class="mobile-menu-head">
                <div class="go-back">
                  <i class="fa fa-angle-left"></i>
                </div>
                <div class="current-menu-title"></div>
                <div class="mobile-menu-close">&times;</div>
              </div>
              <ul class="site-menu-main">
                
                <li class="nav-item">
                  <a href="https://www.investopedia.com/articles/basics/06/invest1000.asp" class="nav-link-item">Help with stocks</a>
                </li>
              </ul>
            </nav>
          </div>
          <div class="header-btns  header-btn-l11 ms-auto d-none d-xs-inline-flex align-items-center">
            <a class="download-trail-btn btn focus-reset" href="/useraccount">
            <!-- NEED TO CONNECT TO USER DB -->
              User
            </a>
            <a class="btn log-in-btn focus-reset" onClick="logout()">
              Log out
            </a>
          </div>
          <!-- mobile menu trigger -->
          <div class="mobile-menu-trigger">
            <span></span>
          </div>
          <!--/.Mobile Menu Hamburger Ends-->
        </nav>
      </div>
    </header>
    <div class="info">
    <div class="images">
    <img src="microsoft.png" style="height: 200px; width: 200px; ">
	<p>Microsoft is a software company.</p>
	<button>Buy</button>
	<button>Sell</button>
	</div>
	</div>
</body>
</html>