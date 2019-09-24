<%-- 
    Document   : updateDataDelivery
    Created on : Jul 27, 2019, 9:12:05 AM
    Author     : acer v5
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title>update delivery</title>
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

        <style>
            #customers {
                font-family: "Trebuchet MS", "Myriad Pro", sans-serif;
                font-weight: bold;
                font-size: 16px;
                border-collapse: collapse;
                width: 50%;
            }

            #customers td, #customers th {
                border: 1px solid #ddd;
                padding: 8px;
            }

            #customers tr:nth-child(even){background-color: #f2f2f2;}

            #customers input{
                background: #e3e3e3;
                border: 1px solid #ccc;
                color: #333;
                font-family: "Trebuchet MS", "Myriad Pro", sans-serif;
                font-size: 14px;
                font-weight: bold;
                padding: 8px 0 9px;
                text-align: center;
                width: 200px;
                cursor:pointer;
                float:right;
                margin:10px 10px 10px 10px;
                text-shadow: 0px 1px 0px #fff;
                -moz-border-radius: 4px;
                -webkit-border-radius: 4px;
                border-radius: 4px;
                -moz-box-shadow: 0px 0px 2px #fff inset;
                -webkit-box-shadow: 0px 0px 2px #fff inset;
                box-shadow: 0px 0px 2px #fff inset;
            }

            #customers th {
                padding-top: 12px;
                padding-bottom: 12px;
                text-align: center;
                background-color: #4CAF50;
                color: white;
            }
            #customers button:hover {
                display:block;
                clear:both;
                padding:10px 30px;
                text-align:right;
                color:#ffa800;
                text-shadow:1px 1px 1px #000;
            }


        </style>
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
                            <a  href="table.html"><i class="fa fa-shopping-cart fa-3x"></i> Penjualan</a>
                            <ul style="color: white" type='disc'>
                                <li><a href="" style="color: white"> <i class="fa-2x"></i>Penjualan Toko</a></li>
                                <li>
                                    <a href="" style="color: white"> <i class="fa-2x"></i>Penjualan Web</a></li>
                                <li><a href="" style="color: white"><i class="fa-2x"></i>Penjualan Marketplace</a></li>
                                <li><a href="" style="color: white"><i class="fa-2x"></i>Penjualan Instagram</a></li>

                            </ul>
                        </li>
                        <li  >
                            <a  href="table.html"><i class="fa fa-minus-square fa-3x"></i> Pengeluaran</a>
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
                            <center><h2 > Tambah Data Pengeluaran</kh2>   </center>

                        </div>
                    </div> 
                    <!-- /. ROW  -->
                    <hr />
                    <div class="row">
                        <div class="col-md-12">

                            <form:form id="dataDeliveryUpdate" action="updateDataDelivery.htm" modelAttribute="deliveryDto"  method="POST">
                                <form:hidden path="kode_delivery" value="${deliveryDto.kode_delivery}" />
                                <br><br><br><br>
                                <center><h1>Form Update Data Delivery Toko</h1></center>
                                <br><br>
                                <center><table id="customers">
                                        <tr>
                                            <td> Kode Delivery:</td>
                                            <td> ${deliveryDto.kode_delivery}</td>             
                                        </tr>
                                        <tr>
                                            <td>Tanggal delivery :</td>
                                            <td><form:input path="tanggal_delivery" value="${deliveryDto.tanggal_delivery}" /></td>            
                                        </tr> 
                                        <tr>
                                            <td>Keterangan :</td>
                                            <td><form:input path="keterangan" value="${deliveryDto.keterangan}" /></td>            
                                        </tr>
                                        <tr>
                                            <td>Kode Produk :</td>
                                            <td><form:select path="kode_produk" value="${deliveryDto.kode_produk}">
                                                    <form:option value="" class="validate validate[required]" id="kode_delivery" selected="true" disabled="true">Pilih Kode Produk</form:option>
                                                    <c:forEach var="kk" items="${listkp}">
                                                        <form:option value="${kk.kode_produk}">${kk.kode_produk}</form:option>
                                                    </c:forEach>
                                                </form:select></td>
                                        </tr>
                                        <tr>
                                            <td>Jumlah :</td>
                                            <td><form:input path="jumlah" value="${deliveryDto.jumlah}" /></td>            
                                        </tr>  


                                        <tr>
                                            <td colspan="2">
                                                <form:button type="submit" id="update">Update</form:button>
                                                </td>
                                            </tr>
                                        </table>
                                    </center>
                            </form:form>
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


</html>
