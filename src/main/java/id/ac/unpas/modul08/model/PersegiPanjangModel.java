/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.modul08.model;

/**
 *
 * @author ROG STRIX
 */

public class PersegiPanjangModel {
    private double panjang;
    private double lebar;
    private double luas;
    private double keliling;

    public PersegiPanjangModel() {}

    public void setPanjang(double p) {
        this.panjang = p;
    }

    public void setLebar(double l) {
        this.lebar = l;
    }

    public void hitungLuas() {
        luas = panjang * lebar;
    }

    public void hitungKeliling() {
        keliling = 2 * (panjang + lebar);
    }

    public double getLuas() {
        return luas;
    }

    public double getKeliling() {
        return keliling;
    }
}

