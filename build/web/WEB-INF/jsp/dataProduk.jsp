<%-- 
    Document   : dataProduk
    Created on : Jul 7, 2019, 4:11:09 PM
    Author     : acer v5
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Data Produk</title>
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
                font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            #customers td, #customers th {
                border: 1px solid #ddd;
                padding: 8px;
            }

            #customers tr:nth-child(even){background-color: #f2f2f2;}

            #customers tr:hover {background-color: #ddd;}

            #customers th {
                padding-top: 12px;
                padding-bottom: 12px;
                text-align: center;
                background-color: #4CAF50;
                color: white;
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
                                  <c:url var="tambahDataCustomerUrl" value="/doTambahDataCustomer.htm"></c:url>
                                <li><a href="${tambahDataCustomerUrl}" style="color: white"> <i class="fa-2x"></i>Penjualan Toko</a></li>
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
                            <center><h2 > Data Produk</h2>   </center>

                        </div>
                    </div> 
                    <!-- /. ROW  -->
                    <hr />
                    <div class="row">
                        <div class="col-md-12">

                            <center>
                                <c:url var="tambahDataProduk" value="/doTambahDataProduk.htm">        
                                </c:url>
                                <a href="${tambahDataProduk}">Tambah</a>    
                                <table id="customers">
                                    <tr>
                                        <th>No</th> 
                                        <th>Kode Produk</th>            
                                        <th>Kode Kategori</th> 
                                        <th>Nama Produk</th>
                                        <th>Harga Jual</th>
                                        <th>Stok Minimum</th>
                                        <th>Keterangan</th>

                                        <th colspan="2">action</th>
                                    </tr>        
                                    <c:set var="index" value="1"/>
                                    <c:forEach var="listProduk" items="${listProdukDto}">
                                        <tr>  
                                            <td>${index}</td>
                                            <td>${listProduk.kode_produk}</td>
                                            <td>${listProduk.kode_kategori}</td>
                                            <td>${listProduk.nama_produk}</td>
                                            <td>${listProduk.harga_jual}</td>
                                            <td>${listProduk.stok_minimum}</td>
                                            <td>${listProduk.keterangan}</td>

                                            <c:url var="deleteProduk" value="/deleteDataProduk.htm">
                                                <c:param name="kode_produk" value="${listProduk.kode_produk}"/>
                                            </c:url>
                                            <c:url var="updateProduk" value="/getDataUpdateProduk.htm">
                                                <c:param name="kode_produk" value="${listProduk.kode_produk}"/>
                                            </c:url>
                                            <td><a href="${deleteProduk}">delete</a></td>
                                            <td><a href="${updateProduk}">update</a></td>
                                        </tr>            
                                        <c:set var="index" value="${index+1}"/>
                                    </c:forEach>
                                </table>
                                <br> <br>
                                <c:url var="indexUrl" value="/index.htm">        
                                </c:url>
                                <a href="${indexUrl}"><button>Menu</button></a>  
                            </center>
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
