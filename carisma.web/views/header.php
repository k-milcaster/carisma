<html>
    <head>
        <title>Carisma Project | <?php echo $this->title; ?></title>
        <link href="<?php echo URL; ?>public/css/bootstrap.css" rel='stylesheet' type='text/css' />
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="<?php echo URL; ?>public/js/jquery.min.js"></script>
        <!-- Custom Theme files -->
        <link href="<?php echo URL; ?>public/css/style.css" rel='stylesheet' type='text/css' />
        <!-- Custom Theme files -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!---- start-smoth-scrolling---->
        <script type="text/javascript" src="<?php echo URL; ?>public/js/move-top.js"></script>
        <script type="text/javascript" src="<?php echo URL; ?>public/js/easing.js"></script>
        <script type="text/javascript">
            jQuery(document).ready(function ($) {
                $(".scroll").click(function (event) {
                    event.preventDefault();
                    $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1000);
                });
            });
        </script>
        <!---- start-smoth-scrolling---->
        <!----webfonts--->
        <link href='http://fonts.googleapis.com/css?family=Oswald:400,300,700' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
        <!---//webfonts--->
        <!----start-top-nav-script---->
        <script>
            $(function () {
                var pull = $('#pull');
                menu = $('nav ul');
                menuHeight = menu.height();
                $(pull).on('click', function (e) {
                    e.preventDefault();
                    menu.slideToggle();
                });
                $(window).resize(function () {
                    var w = $(window).width();
                    if (w > 320 && menu.is(':hidden')) {
                        menu.removeAttr('style');
                    }
                });
            });
        </script>
        <!----//End-top-nav-script---->
    </head>
    <body>
        <!----- start-header---->
        <div id="home" class="header">
            <div class="top-header">
                <div class="container">
                    <div class="logo">
                        <a href="#"><img src="<?php echo URL; ?>public/images/logo.png" title="doctor" /></a>
                    </div>
                    <!----start-top-nav---->
                    <nav class="top-nav">
                        <ul class="top-nav">
                            <li <?php if ($this->title == "Home") echo 'class="active"' ?>><a href="<?php echo URL; ?>">Home </a></li>
                            <li><a href="<?php echo URL; ?>index#about" <?php if ($this->title == "Home") echo 'class="scroll"' ?>>About us</a></li>
                            <li><a href="<?php echo URL; ?>index#services" <?php if ($this->title == "Home") echo 'class="scroll"' ?>>Services</a></li>
                            <li <?php if ($this->title == "Doctors") echo 'class="active"' ?>><a href="<?php echo URL; ?>index#team" <?php if ($this->title == "Home") echo 'class="scroll"' ?>>Doctors</a></li>
                            <li><a href="<?php echo URL; ?>index#contact" <?php if ($this->title == "Home") echo 'class="scroll"' ?>>Contact</a></li>
                            <li <?php if ($this->title == "Login") echo 'class="active"' ?>><a href="<?php echo URL; ?>login">Log In</a></li>
                        </ul>
                        <a href="#" id="pull"><img src="<?php echo URL; ?>public/images/menu-icon.png" title="menu" /></a>
                    </nav>
                    <div class="clearfix"> </div>
                </div>
            </div>
        </div>
        <!----- //End-header---->