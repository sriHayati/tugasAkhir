/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri.pelatihan.java.springhibernate.tgs1.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;
import sri.pelatihan.java.springhibernate.tgs1.DTO.akun_dto;
import sri.pelatihan.java.springhibernate.tgs1.DTO.customer_dto;
import sri.pelatihan.java.springhibernate.tgs1.DTO.delivery_dto;
import sri.pelatihan.java.springhibernate.tgs1.DTO.kategori_produk_dto;
import sri.pelatihan.java.springhibernate.tgs1.DTO.login_dto;
import sri.pelatihan.java.springhibernate.tgs1.DTO.pengeluaran_dto;
import sri.pelatihan.java.springhibernate.tgs1.DTO.penjualan_dto;
import sri.pelatihan.java.springhibernate.tgs1.DTO.produk_dto;
import sri.pelatihan.java.springhibernate.tgs1.DTO.produksi_dto;
import sri.pelatihan.java.springhibernate.tgs1.DTO.stok_produk_dto;
import sri.pelatihan.java.springhibernate.tgs1.model.login_model;
import sri.pelatihan.java.springhibernate.tgs1.model.stok_produk;
import sri.pelatihan.java.springhibernate.tgs1.service.akun_service;
import sri.pelatihan.java.springhibernate.tgs1.service.customer_service;
import sri.pelatihan.java.springhibernate.tgs1.service.delivery_service;
import sri.pelatihan.java.springhibernate.tgs1.service.kategori_produk_service;
import sri.pelatihan.java.springhibernate.tgs1.service.login_service;
import sri.pelatihan.java.springhibernate.tgs1.service.nota_service;
import sri.pelatihan.java.springhibernate.tgs1.service.pengeluaran_service;
import sri.pelatihan.java.springhibernate.tgs1.service.penjualan_service;
import sri.pelatihan.java.springhibernate.tgs1.service.produk_service;
import sri.pelatihan.java.springhibernate.tgs1.service.produksi_service;
import sri.pelatihan.java.springhibernate.tgs1.service.stok_produk_service;

/**
 *
 * @author acer v5
 */
@Controller
public class projek_controller {

    login_dto dto = new login_dto();
    kategori_produk_dto kate = new kategori_produk_dto();
    login_model aModel = new login_model();
    HttpSession session;

    @Autowired
    login_service loginService;

    @Autowired
    kategori_produk_service kategoriService;

    @Autowired
    produk_service produkService;

    @Autowired
    stok_produk_service stokService;

    @Autowired
    produksi_service produksiService;

    @Autowired
    delivery_service deliveryService;

    @Autowired
    customer_service customerService;

    @Autowired
    penjualan_service penjualanService;

    @Autowired
    akun_service akunService;

    @Autowired
    pengeluaran_service pengeluaranService;

//    @Autowired
//    nota_service notaService;
    
    @RequestMapping(value = "/insertPenjualan", method = RequestMethod.GET)
    public String viewpenjualan(ModelMap model, penjualan_dto penjualanDto) {
        model.addAttribute("penjualanDto",penjualanDto);
        return "insertPenjualan";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String viewIndex() {
        return "index";
    }

    @RequestMapping(value = "/owner", method = RequestMethod.GET)
    public String viewMenu() {
        return "owner";
    }

    @RequestMapping(value = "/adminToko", method = RequestMethod.GET)
    public String viewAdminToko() {
        return "adminToko";
    }

    @RequestMapping(value = "/adminGudang", method = RequestMethod.GET)
    public String viewAdminGudang() {
        return "adminGudang";
    }

    @RequestMapping(value = "/adminWeb", method = RequestMethod.GET)
    public String viewAdminWeb() {
        return "adminWeb";
    }

    @RequestMapping(value = "/adminMarketPlace", method = RequestMethod.GET)
    public String viewAdminMarketPlace() {
        return "adminMarketPlace";
    }

    @RequestMapping(value = "/adminInstagram", method = RequestMethod.GET)
    public String viewAdminInstagram() {
        return "adminInstagram";
    }

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public void doLogin(login_dto formDto, ModelMap model, HttpServletResponse response, HttpServletRequest request) throws Exception {
        String u = null;
        dto = loginService.getListDataAdminLogin(formDto);
        model.addAttribute("loginDto", dto);
        if (dto.getListDataLogin().isEmpty()) {
            u = "index.htm";
        } else {
            aModel = dto.getListDataLogin().get(0);
            if (aModel.getUsername().equals(formDto.getUsername())) {
                if (aModel.getStatus().equalsIgnoreCase("owner")) {
                    u = "owner.htm";
                } else if (aModel.getStatus().equalsIgnoreCase("Admin Toko")) {
                    u = "adminToko.htm";
                } else if (aModel.getStatus().equalsIgnoreCase("Admin Gudang")) {
                    u = "adminGudang.htm";
                } else if (aModel.getStatus().equalsIgnoreCase("Admin Web")) {
                    u = "adminWeb.htm";
                } else if (aModel.getStatus().equalsIgnoreCase("Admin Mareket Place")) {
                    u = "adminMarketPlace.htm";
                } else if (aModel.getStatus().equalsIgnoreCase("Admin Instagram")) {
                    u = "adminInstagram.htm";
                }

            }
            session = request.getSession(true);
            session.setAttribute("username", dto.getUsername());
            session.setAttribute("password", dto.getPassword());
            session.setAttribute("status", dto.getStatus());
        }
        response.sendRedirect(u);
    }

    @RequestMapping(value = "/tabelKategori", method = RequestMethod.GET)
    public String viewKategori(ModelMap model) {
        try {
            List<kategori_produk_dto> listKategoriDto = kategoriService.getListKategori();
            model.addAttribute("listKategoriDto", listKategoriDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "tabelKategori";
    }

    @RequestMapping(value = "/dataProduk", method = RequestMethod.GET)
    public String viewDataProduk(ModelMap model) {
        try {
            List<produk_dto> listProdukDto = produkService.getListProduk();
            model.addAttribute("listProdukDto", listProdukDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "dataProduk";
    }

    @RequestMapping(value = "/tabelStok", method = RequestMethod.GET)
    public String viewStok(ModelMap model) {
        try {
            List<stok_produk_dto> listStokDto = stokService.getListStokProduk();
            model.addAttribute("listStokDto", listStokDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "tabelStok";
    }

    @RequestMapping(value = "/tabelProduksi", method = RequestMethod.GET)
    public String viewProduksi(ModelMap model) {
        try {
            List<produksi_dto> listProduksiDto = produksiService.getListProduksi();
            model.addAttribute("listProduksiDto", listProduksiDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "tabelProduksi";
    }

    @RequestMapping(value = "/tabelDelivery", method = RequestMethod.GET)
    public String viewDelivery(ModelMap model) {
        try {
            List<delivery_dto> listDeliveryDto = deliveryService.getListDelivery();
            model.addAttribute("listDeliveryDto", listDeliveryDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "tabelDelivery";
    }

    @RequestMapping(value = "/tabelAkun", method = RequestMethod.GET)
    public String viewAkun(ModelMap model) {
        try {
            List<akun_dto> listAkunDto = akunService.getListAkun();
            model.addAttribute("listAkunDto", listAkunDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "tabelAkun";
    }

    @RequestMapping(value = "/tabelPengeluaran", method = RequestMethod.GET)
    public String viewPengeluaran(ModelMap model) {
        try {
            List<pengeluaran_dto> listPengeluaranDto = pengeluaranService.getListPengeluaran();
            model.addAttribute("listPengeluaranDto", listPengeluaranDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "tabelPengeluaran";
    }

    @RequestMapping(value = "/deleteDataKategori", method = RequestMethod.GET)
    public String hapusDataKategori(String kode_kategori, ModelMap model) throws Exception {
        kategoriService.deleteDataKategori(kode_kategori);
        return "redirect:tabelKategori.htm";
    }

    @RequestMapping(value = "/deleteDataProduk", method = RequestMethod.GET)
    public String hapusDataProduk(String kode_produk, ModelMap model) throws Exception {
        produkService.deleteDataProduk(kode_produk);
        return "redirect:dataProduk.htm";
    }

    @RequestMapping(value = "/deleteDataProduksi", method = RequestMethod.GET)
    public String hapusDataProduksi(String kode_produksi, String kode_produk, int jumlah, ModelMap model) throws Exception {

        //  produksi_dto  produksiDto=new produksi_dto();
        stok_produk prd = stokService.getStokProdukById(kode_produk);
        int upst = prd.getStok_gudang() - jumlah;
        int uptst = prd.getTotal_stok() - jumlah;
        int sttk = prd.getStok_toko();
        stokService.doUpdateStok_produk(kode_produk, upst, sttk, uptst);
        produksiService.deleteDataProduksi(kode_produksi);
        return "redirect:tabelProduksi.htm";
    }

    @RequestMapping(value = "/deleteDataDelivery", method = RequestMethod.GET)
    public String hapusDataDelivery(String kode_delivery, String kode_produk, int jumlah, ModelMap model) throws Exception {
        stok_produk prd = stokService.getStokProdukById(kode_produk);
        int upst = prd.getStok_toko() - jumlah;
        int uptst = prd.getStok_gudang() + jumlah;
        int sttk = prd.getTotal_stok();
        stokService.doUpdateStok_produk(kode_produk, uptst, upst, sttk);

        deliveryService.deleteDataDelivery(kode_delivery);
        return "redirect:tabelDelivery.htm";
    }

    @RequestMapping(value = "/deleteDataAkun", method = RequestMethod.GET)
    public String hapusDataAkun(String kode_akun, ModelMap model) throws Exception {
        akunService.deleteDataAkun(kode_akun);
        return "redirect:tabelAkun.htm";
    }

    @RequestMapping(value = "/deleteDataPengeluaran", method = RequestMethod.GET)
    public String hapusDataPengeluaran(String kode_pengeluaran, ModelMap model) throws Exception {
        pengeluaranService.deleteDataPengeluaran(kode_pengeluaran);
        return "redirect:tabelPengeluaran.htm";
    }

    @RequestMapping(value = "/saveDataKategori", method = RequestMethod.POST)
    public String saveDataKategori(kategori_produk_dto kategoriDto, ModelMap model) throws Exception {
        ModelAndView mdl = new ModelAndView();
        kategoriService.saveDataKategori(kategoriDto);
        return "redirect:tabelKategori.htm";
    }

    @RequestMapping(value = "/doTambahDataKategori", method = RequestMethod.GET)
    public String doTambahDataKategori(ModelMap model) {
        kategori_produk_dto dto = null;

        try {
            dto = new kategori_produk_dto();
            model.addAttribute("kategoriDto", dto);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "insertKategori";
    }

    @RequestMapping(value = "/saveDataProduk", method = RequestMethod.POST)
    public String saveDataProduk(produk_dto produkDto, ModelMap model) throws Exception {
        ModelAndView mdl = new ModelAndView();
        stokService.saveDataStok_produk(produkDto.getKode_produk());
        produkService.saveDataProduk(produkDto);
        return "redirect:dataProduk.htm";
    }

    @RequestMapping(value = "/doTambahDataProduk", method = RequestMethod.GET)
    public String doTambahDataProduk(ModelMap model) {
        produk_dto dto = null;
        List<kategori_produk_dto> listKodeProduk = null;
        try {
            dto = new produk_dto();
            model.addAttribute("produkDto", dto);
            listKodeProduk = kategoriService.getListKategori();
            model.addAttribute("listKk", listKodeProduk);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "insertProduk";
    }

    @RequestMapping(value = "/saveDataProduksi", method = RequestMethod.POST)
    public String saveDataProduksi(produksi_dto produksiDto, ModelMap model) throws Exception {
        ModelAndView mdl = new ModelAndView();
        produksiService.saveDataProduksi(produksiDto);
        stok_produk prd = stokService.getStokProdukById(produksiDto.getKode_produk());
        int upst = prd.getStok_gudang() + produksiDto.getJumlah();
        int uptst = prd.getTotal_stok() + produksiDto.getJumlah();
        int sttk = prd.getStok_toko();
        stokService.doUpdateStok_produk(produksiDto.getKode_produk(), upst, sttk, uptst);
        return "redirect:tabelProduksi.htm";
    }

    @RequestMapping(value = "/doTambahDataProduksi", method = RequestMethod.GET)
    public String doTambahDataProduksi(ModelMap model) {
        produksi_dto dto = null;
        List<produk_dto> listKodeProduk = null;
        try {
            dto = new produksi_dto();
            model.addAttribute("produksiDto", dto);
            listKodeProduk = produkService.getListProduk();
            model.addAttribute("listKk", listKodeProduk);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "insertProduksi";
    }

    @RequestMapping(value = "/saveDataDelivery", method = RequestMethod.POST)
    public String saveDataDelivery(delivery_dto deliveryDto, ModelMap model) throws Exception {
        ModelAndView mdl = new ModelAndView();
        deliveryService.saveDataDelivery(deliveryDto);
        stok_produk prd = stokService.getStokProdukById(deliveryDto.getKode_produk());
        int upst = prd.getStok_gudang() - deliveryDto.getJumlah();
        int uptst = prd.getStok_toko() + deliveryDto.getJumlah();
        int sttk = prd.getTotal_stok();

        stokService.doUpdateStok_produk(deliveryDto.getKode_produk(), upst, uptst, sttk);
        return "redirect:tabelDelivery.htm";
    }

    @RequestMapping(value = "/doTambahDataDelivery", method = RequestMethod.GET)
    public String doTambahDataDelivery(ModelMap model) {
        delivery_dto dto = null;
        List<produk_dto> listKodeProduk = null;
        try {
            dto = new delivery_dto();
            model.addAttribute("deliveryDto", dto);
            listKodeProduk = produkService.getListProduk();
            model.addAttribute("listKk", listKodeProduk);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "insertDelivery";
    }
    String kode="";
    @RequestMapping(value = "/saveDataCustomer", method = RequestMethod.POST)
    public String saveDataCustomer(customer_dto customerDto, ModelMap model, HttpServletResponse response, HttpServletRequest request) throws Exception {
        ModelAndView mdl = new ModelAndView();
        customerService.saveDataCustomer(customerDto);
     
        kode=customerDto.getKode_customer();

        return "redirect:doTambahDataPenjualan.htm";
    }

    @RequestMapping(value = "/doTambahDataCustomer", method = RequestMethod.GET)
    public String doTambahDataCustomer(ModelMap model) {
        customer_dto dto = null;
        try {
            dto = new customer_dto();
            model.addAttribute("customerDto", dto);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "insertCustomer";
    }

    @RequestMapping(value = "/saveDataPenjualan", method = RequestMethod.POST)
    public String saveDataPenjualan(penjualan_dto penjualanDto, ModelMap model) throws Exception {
        ModelAndView mdl = new ModelAndView();
        stok_produk prd = stokService.getStokProdukById(penjualanDto.getKode_produk());
        int upst = prd.getStok_gudang();
        int uptst = prd.getStok_toko() - Integer.parseInt(penjualanDto.getQuantity());
        int sttk = prd.getTotal_stok() - Integer.parseInt(penjualanDto.getQuantity());;
        stokService.doUpdateStok_produk(penjualanDto.getKode_produk(), upst, uptst, sttk);

        model.addAttribute("penjualanDto", penjualanDto);
        penjualanService.saveDataPenjualan(penjualanDto);
        
        return "redirect:doTambahDataPenjualan.htm";
    }

    @RequestMapping(value = "/doTambahDataPenjualan", method = RequestMethod.GET)
    public String doTambahDataPenjualan(customer_dto customerDto, ModelMap model) throws Exception {
        penjualan_dto penjualanDto = null;
        penjualan_dto penjualanDtoo = null;
        
       // customer_dto dtoo = new customer_dto();
        List<produk_dto> listKodeProduk = null;

        try {
            penjualanDto = new penjualan_dto();
            penjualanDtoo = new penjualan_dto();
            model.addAttribute("penjualanDto", penjualanDto);
            listKodeProduk = produkService.getListProduk();
            model.addAttribute("listKk", listKodeProduk);
            penjualanDtoo.setKode_customer(kode);
            model.addAttribute("penjualanDtoo",penjualanDtoo );
            

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "insertPenjualan";
    }

    @RequestMapping(value = "/saveDataAkun", method = RequestMethod.POST)
    public String saveDataAkun(akun_dto akunDto, ModelMap model) throws Exception {
        ModelAndView mdl = new ModelAndView();
        akunService.saveDataAkun(akunDto);
        return "redirect:tabelAkun.htm";
    }

    @RequestMapping(value = "/doTambahDataAkun", method = RequestMethod.GET)
    public String doTambahDataAkun(ModelMap model) {
        akun_dto dto = null;

        try {
            dto = new akun_dto();
            model.addAttribute("akunDto", dto);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "insertAkun";
    }

    @RequestMapping(value = "/saveDataPengeluaran", method = RequestMethod.POST)
    public String saveDataPengeluaran(pengeluaran_dto pengeluaranDto, ModelMap model) throws Exception {
        ModelAndView mdl = new ModelAndView();
        pengeluaranService.saveDataPengeluaran(pengeluaranDto);
        return "redirect:tabelPengeluaran.htm";
    }

    @RequestMapping(value = "/doTambahDataPengeluaran", method = RequestMethod.GET)
    public String doTambahDataPengeluaran(ModelMap model) {
        pengeluaran_dto dto = null;
        List<akun_dto> listKodeAkun = null;
        try {
            dto = new pengeluaran_dto();
            model.addAttribute("pengeluaranDto", dto);
            listKodeAkun = akunService.getListAkun();
            model.addAttribute("listKk", listKodeAkun);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "insertPengeluaran";
    }

    @RequestMapping(value = "/updateKategori", method = RequestMethod.POST)
    public String editData(kategori_produk_dto kategoriDto) throws Exception {
        kategoriService.doUpdateDataKategori(kategoriDto);
        return "redirect:tabelKategori.htm";
    }

    @RequestMapping(value = "/getDataUpdateKategori", method = RequestMethod.GET)
    public String getUpdateDataKategori(String kode_kategori, ModelMap model) throws Exception {
        kategori_produk_dto kategoriDto = kategoriService.getUpdateDataKategori(kode_kategori);
        model.addAttribute("kategoriDto", kategoriDto);
        return "updateKategori";
    }

    @RequestMapping(value = "/updateDataProduk", method = RequestMethod.POST)
    public String editDataProduk(produk_dto produkDto) throws Exception {
        produkService.doUpdateDataProduk(produkDto);
        return "redirect:dataProduk.htm";
    }

    @RequestMapping(value = "/getDataUpdateProduk", method = RequestMethod.GET)
    public String getUpdateDataProduk(String kode_produk, ModelMap model) throws Exception {
        produk_dto produkDto = produkService.getUpdateDataProduk(kode_produk);
        model.addAttribute("produkDto", produkDto);
        List<kategori_produk_dto> kategoriDto1 = kategoriService.getListKategori();
        model.addAttribute("listkp", kategoriDto1);
        return "updateDataProduk";
    }

    @RequestMapping(value = "/updateDataProduksi", method = RequestMethod.POST)
    public String editDataProduksi(produksi_dto produksiDto, int jumlah) throws Exception {
        stok_produk prd = stokService.getStokProdukById(produksiDto.getKode_produk());
        int upst = prd.getStok_gudang() + (jumlah - produksiDto.getJumlah());
        int uptst = prd.getTotal_stok() + (jumlah - produksiDto.getJumlah());
        int sttk = prd.getStok_toko();
        stokService.doUpdateStok_produk(produksiDto.getKode_produk(), upst, sttk, uptst);

        produksiService.doUpdateDataProduksi(produksiDto);
        return "redirect:tabelProduksi.htm";
    }

    @RequestMapping(value = "/getDataUpdateProduksi", method = RequestMethod.GET)
    public String getUpdateDataProduksi(String kode_produksi, ModelMap model) throws Exception {
        produksi_dto produksiDto = produksiService.getUpdateDataProduksi(kode_produksi);
        model.addAttribute("produksiDto", produksiDto);
        List<produk_dto> produkDto1 = produkService.getListProduk();
        model.addAttribute("listkp", produkDto1);
        return "updateDataProduksi";
    }

    @RequestMapping(value = "/updateDataDelivery", method = RequestMethod.POST)
    public String editDataDelivery(delivery_dto deliveryDto) throws Exception {
        deliveryService.doUpdateDataDelivery(deliveryDto);
        return "redirect:tabelDelivery.htm";
    }

    @RequestMapping(value = "/getDataUpdateDelivery", method = RequestMethod.GET)
    public String getUpdateDataDelivery(String kode_delivery, ModelMap model) throws Exception {
        delivery_dto deliveryDto = deliveryService.getUpdateDataDelivery(kode_delivery);
        model.addAttribute("deliveryDto", deliveryDto);
        List<produk_dto> prod = produkService.getListProduk();
        model.addAttribute("listkp", prod);
        return "updateDataDelivery";
    }

    @RequestMapping(value = "/updateDataAkun", method = RequestMethod.POST)
    public String editData(akun_dto akunDto) throws Exception {
        akunService.doUpdateDataAkun(akunDto);
        return "redirect:tabelAkun.htm";
    }

    @RequestMapping(value = "/getDataUpdateAkun", method = RequestMethod.GET)
    public String getUpdateDataAkun(String kode_akun, ModelMap model) throws Exception {
        akun_dto akunDto = akunService.getUpdateDataAkun(kode_akun);
        model.addAttribute("akunDto", akunDto);
        return "updateDataAkun";
    }

    @RequestMapping(value = "/updateDataPengeluaran", method = RequestMethod.POST)
    public String editData(pengeluaran_dto pengeluaranDto) throws Exception {
        pengeluaranService.doUpdateDataPengeluaran(pengeluaranDto);
        return "redirect:tabelPengeluaran.htm";
    }

    @RequestMapping(value = "/getDataUpdatePengeluaran", method = RequestMethod.GET)
    public String getUpdateDataPengeluaran(String kode_pengeluaran, ModelMap model) throws Exception {
        pengeluaran_dto pengeluaranDto = pengeluaranService.getUpdateDataPengeluaran(kode_pengeluaran);
        model.addAttribute("pengeluaranDto", pengeluaranDto);
        List<akun_dto> akunDto1 = akunService.getListAkun();
        model.addAttribute("listkp", akunDto1);
        return "updateDataPengeluaran";
    }

}
