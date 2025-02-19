package com.techzen.academy_n1224c1.employee;

import java.time.LocalDate;

public class Employee {
    private int id;
    private String ten;
    private LocalDate ngaysinh;
    private Gender gioitinh;
    private double luong;
    public enum Gender {
        Nam,
        Nữ,
        Khác
    }

    public Employee() {
    }

    public Employee(int id, String ten, LocalDate ngaysinh, Gender gioitinh, double luong) {
        this.id = id;
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.luong = luong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public LocalDate getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(LocalDate ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public Gender getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(Gender gioitinh) {
        this.gioitinh = gioitinh;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }
}
