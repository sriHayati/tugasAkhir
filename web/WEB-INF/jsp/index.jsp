<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Forms</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/datepicker3.css" rel="stylesheet">
        <link href="css/styles.css" rel="stylesheet">
        <link rel="shortcut icon" href="../favicon.ico" type="image/x-icon"/>
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <script src="js/cufon-yui.js" type="text/javascript"></script>
        <script src="js/ChunkFive_400.font.js" type="text/javascript"></script>
        <script type="text/javascript">
            Cufon.replace('h1', {textShadow: '1px 1px #fff'});
            Cufon.replace('h2', {textShadow: '1px 1px #fff'});
            Cufon.replace('h3', {textShadow: '1px 1px #000'});
            Cufon.replace('.back');
        </script>

        <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->

    </head>

    <body>	
        <div class="wrapper">
            <div class="content">
                <div id="form_wrapper" class="form_wrapper">

                    <form class="login active"  action="doLogin.htm" modelAttribute="formDto" method="POST"  role="form">
                        <h3>Login</h3>
                        <div>
                            <label>Username:</label>
                            <input class="form-control" placeholder="UserName" name="username" type="text" autofocus="">
                            <span class="error">This is an error</span>
                        </div>
                        <div>
                            <label>Password: <!-- <a href="forgot_password.html" rel="forgot_password" class="forgot linkform">Forgot your password?</a> --></label>
                            <input class="form-control" placeholder="Password" name="password" type="password" value="">
                            <span class="error">This is an error</span>
                        </div>
                        <div class="bottom">
                            
                            <input type="submit" value="Login"></input>
                            <!-- <a href="register.html" rel="register" class="linkform">You don't have an account yet? Register here</a> -->
                            <div class="clear"></div>
                        </div>
                    </form>
                </div>
                <div class="clear"></div>
            </div>

        </div>


        <script src="js/jquery-1.11.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/chart.min.js"></script>
        <script src="js/chart-data.js"></script>
        <script src="js/easypiechart.js"></script>
        <script src="js/easypiechart-data.js"></script>
        <script src="js/bootstrap-datepicker.js"></script>
        <script>
            !function ($) {
                $(document).on("click", "ul.nav li.parent > a > span.icon", function () {
                    $(this).find('em:first').toggleClass("glyphicon-minus");
                });
                $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
            }(window.jQuery);

            $(window).on('resize', function () {
                if ($(window).width() > 768)
                    $('#sidebar-collapse').collapse('show')
            })
            $(window).on('resize', function () {
                if ($(window).width() <= 767)
                    $('#sidebar-collapse').collapse('hide')
            })
        </script>


    </body>

</html>
