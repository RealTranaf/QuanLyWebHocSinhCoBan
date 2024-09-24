package com.ld.webtruonghoc.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Hocsinh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String hoten;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GioiTinh gioitinh;

    @Column(nullable = false, length = 50)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date ngaysinh;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 11)
    private String sdt;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Lop lop;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diem_id")
    private Diem diem;

    public Hocsinh() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public GioiTinh getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(GioiTinh gioitinh) {
        this.gioitinh = gioitinh;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Lop getLop() {
        return lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }

    public Diem getDiem() {
        return diem;
    }

    public void setDiem(Diem diem) {
        this.diem = diem;
    }
}
