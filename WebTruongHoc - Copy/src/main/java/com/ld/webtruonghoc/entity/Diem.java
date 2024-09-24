package com.ld.webtruonghoc.entity;

import javax.persistence.*;

@Entity
@Table
public class Diem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Float toan;
    private Float anh;
    private Float van;
    private Float ly;
    private Float hoa;
    private Float sinh;
    private Float su;
    private Float dia;
    @OneToOne(mappedBy = "diem")
    private Hocsinh hocsinh;

    public Diem() {

    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public Float getToan() {

        return toan;
    }

    public void setToan(Float toan) {

        this.toan = toan;
    }

    public Float getAnh() {

        return anh;
    }

    public void setAnh(Float anh) {

        this.anh = anh;
    }

    public Float getVan() {

        return van;
    }

    public void setVan(Float van) {

        this.van = van;
    }

    public Hocsinh getHocsinh() {

        return hocsinh;
    }

    public void setHocsinh(Hocsinh hocsinh) {

        this.hocsinh = hocsinh;
    }

    public Float getLy() {
        return ly;
    }

    public void setLy(Float ly) {
        this.ly = ly;
    }

    public Float getHoa() {
        return hoa;
    }

    public void setHoa(Float hoa) {
        this.hoa = hoa;
    }

    public Float getSinh() {
        return sinh;
    }

    public void setSinh(Float sinh) {
        this.sinh = sinh;
    }

    public Float getSu() {
        return su;
    }

    public void setSu(Float su) {
        this.su = su;
    }

    public Float getDia() {
        return dia;
    }

    public void setDia(Float dia) {
        this.dia = dia;
    }
}
