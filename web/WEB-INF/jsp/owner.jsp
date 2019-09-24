<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>owner</title>
        <!-- BOOTSTRAP STYLES-->
        <link href="assets/css/bootstrap.css" rel="stylesheet" />
        <!-- FONTAWESOME STYLES-->
        <link href="assets/css/font-awesome.css" rel="stylesheet" />
        <!-- MORRIS CHART STYLES-->
        <link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
        <link href="assets/css/custom.css" rel="stylesheet" />
        <!-- GOOGLE FONTS-->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    </head>
    <body>
        <div id="wrapper">
            <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.html" style="font-size: 25px">Sales & Inventory</a> 
                </div>
                <div style="color: white;
                     padding: 15px 50px 5px 50px;
                     float: right;
                     font-size: 16px;"> <a href="#" class="btn btn-danger square-btn-adjust">Logout</a> </div>
            </nav>   
            <!-- /. NAV TOP  -->
            <nav class="navbar-default navbar-side" role="navigation">
                <div class="sidebar-collapse">
                    <ul class="nav" id="main-menu">
                        <li class="text-center">
                            <img src="assets/img/find_user.png" class="user-image img-responsive"/>
                        </li>


                        <li>
                            <c:url var="kategoriUrl" value="tabelKategori.htm"></c:url>
                            <a class="active-menu"  href="${kategoriUrl}"><i class="fa fa-book fa-3x"></i> Kategori Produk</a>

                        </li>
                        <li>
                            <c:url var="produkUrl" value="dataProduk.htm"></c:url>
                            <a  href="${produkUrl}"><i class="fa fa-gift fa-3x"></i> Data Produk</a>
                        </li>
                        <li>
                            <c:url var="stokUrl" value="tabelStok.htm"></c:url>
                            <a  href="${stokUrl}"><i class="fa fa-archive fa-3x"></i> Stok Produk</a>
                        </li>
                        <li >
                            <c:url var="produksiUrl" value="tabelProduksi.htm"></c:url>
                            <a   href="${produksiUrl}"><i class="fa fa-medkit fa-3x"></i> Produksi</a>
                        </li>	
                        <li >
                            <c:url var="deliveryUrl" value="tabelDelivery.htm"></c:url>
                            <a   href="${deliveryUrl}"><i class="fa fa-medkit fa-3x"></i> Delivery Toko</a>
                        </li>
                        <li  >
                            
                            <a  href=""><i class="fa fa-shopping-cart fa-3x"></i> Penjualan</a>
                            <ul style="color: white" type='disc'>
                                <c:url var="tambahDataCustomerUrl" value="/doTambahDataCustomer.htm"></c:url>
                                <li><a href="${tambahDataCustomerUrl}" style="color: white"> <i class="fa-2x"></i>Penjualan Toko</a></li>
                                <li>
                                    <a href="" style="color: white"> <i class="fa-2x"></i>Penjualan Web</a></li>
                                <li><a href="" style="color: white"><i class="fa-2x"></i>Penjualan Marketplace</a></li>
                                <li><a href="" style="color: white"><i class="fa-2x"></i>Penjualan Instagram</a></li>

                            </ul>
                        </li>
                         <li  >
                             <c:url var="AkunUrl" value="/tabelAkun.htm"></c:url>
                            <a  href="${AkunUrl}" style="color: white"><i class="fa fa-minus-square fa-3x"></i> Akun</a>
                        </li>        
                        <li  >
                            <c:url var="pengeluaranUrl" value="/tabelPengeluaran.htm"></c:url>
                            <a  href="${pengeluaranUrl}" style="color: white"><i class="fa fa-minus-square fa-3x"></i> Pengeluaran</a>
                        </li>				
                        <li  >
                            <a  href="table.html"><i class="fa fa-money fa-3x"></i> Laba</a>
                        </li>

                    </ul>

                </div>

            </nav>  
            <!-- /. NAV SIDE  -->
            <div id="page-wrapper" >
                <div id="page-inner">
                    <div class="row">
                        <div class="col-md-12">
                            <h2>OWNER</h2>   
                            <h5>Welcome In This Page </h5>
                        </div>
                    </div>              
                    <!-- /. ROW  -->
                    <hr />
                    <div class="row">
                        <div class="col-md-3 col-sm-6 col-xs-6">           






                        </div>

                    </div>
                    <!-- /. ROW  -->


                </div>
                <!-- /. PAGE WRAPPER  -->
            </div>
            <!-- /. WRAPPER  -->
            <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
            <!-- JQUERY SCRIPTS -->
            <script src="assets/js/jquery-1.10.2.js"></script>
            <!-- BOOTSTRAP SCRIPTS -->
            <script src="assets/js/bootstrap.min.js"></script>
            <!-- METISMENU SCRIPTS -->
            <script src="assets/js/jquery.metisMenu.js"></script>
            <!-- MORRIS CHART SCRIPTS -->
            <script src="assets/js/morris/raphael-2.1.0.min.js"></script>
            <script src="assets/js/morris/morris.js"></script>
            <!-- CUSTOM SCRIPTS -->
            <script src="assets/js/custom.js"></script>


    </body>
</html>
