/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Administrator
 */
public class ProductDTO {
    private String idSanPham;
    private String tenSanPham;
    private int tongSoLuong;
    private int giaBanDau;
    private int giaSanPham;
    private String anhMinhHoa;
    private String anhMoTa;
    private String moTaSanPham;
    private String thuongHieu;
    private String mauSac;
    private String idPhanLoai;
    private String tenPhanLoai;

    public ProductDTO(String idSanPham, String tenSanPham, int tongSoLuong, int giaBanDau, int giaSanPham, String anhMinhHoa, String anhMoTa, String moTaSanPham, String thuongHieu, String mauSac, String idPhanLoai, String tenPhanLoai) {
        this.idSanPham = idSanPham;
        this.tenSanPham = tenSanPham;
        this.tongSoLuong = tongSoLuong;
        this.giaBanDau = giaBanDau;
        this.giaSanPham = giaSanPham;
        this.anhMinhHoa = anhMinhHoa;
        this.anhMoTa = anhMoTa;
        this.moTaSanPham = moTaSanPham;
        this.thuongHieu = thuongHieu;
        this.mauSac = mauSac;
        this.idPhanLoai = idPhanLoai;
        this.tenPhanLoai = tenPhanLoai;
    }

    public ProductDTO() {
    }
    
    public String getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(String idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getTongSoLuong() {
        return tongSoLuong;
    }

    public void setTongSoLuong(int tongSoLuong) {
        this.tongSoLuong = tongSoLuong;
    }

    public int getGiaBanDau() {
        return giaBanDau;
    }

    public void setGiaBanDau(int giaBanDau) {
        this.giaBanDau = giaBanDau;
    }

    public int getGiaSanPham() {
        return giaSanPham;
    }

    public void setGiaSanPham(int giaSanPham) {
        this.giaSanPham = giaSanPham;
    }

    public String getAnhMinhHoa() {
        return anhMinhHoa;
    }

    public void setAnhMinhHoa(String anhMinhHoa) {
        this.anhMinhHoa = anhMinhHoa;
    }

    public String getAnhMoTa() {
        return anhMoTa;
    }

    public void setAnhMoTa(String anhMoTa) {
        this.anhMoTa = anhMoTa;
    }

    public String getMoTaSanPham() {
        return moTaSanPham;
    }

    public void setMoTaSanPham(String moTaSanPham) {
        this.moTaSanPham = moTaSanPham;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getIdPhanLoai() {
        return idPhanLoai;
    }

    public void setIdPhanLoai(String idPhanLoai) {
        this.idPhanLoai = idPhanLoai;
    }

    public String getTenPhanLoai() {
        return tenPhanLoai;
    }

    public void setTenPhanLoai(String tenPhanLoai) {
        this.tenPhanLoai = tenPhanLoai;
    }
    
    
}
