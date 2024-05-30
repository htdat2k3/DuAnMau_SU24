package com.example.duanmau_ph20511.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context){
        super(context,"QUANLYTHUVIEN",null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //tao bang LoaiSach
        String tLoaiSach = "CREATE TABLE LOAISACH(maloai integer primary key autoincrement,tenloai text)";
        db.execSQL(tLoaiSach);
        //data mau cua LoaiSach
        db.execSQL("INSERT INTO LOAISACH VALUES(1,'thieu nhi'),(2,'tinhcam'),(3,'hanhdong')");
//        db.execSQL("INSERT INTO LOAISACH(maloaisach,tenloai) VALUES(1,'thieunhi')");

        //tao bang Sach
        String tSach ="CREATE TABLE SACH(masach integer primary key autoincrement,tensach text,tacgia text,giaban integer,maLoai integer references LOAISACH(maloai))";
        db.execSQL(tSach);
        //data mau Sach
        db.execSQL("INSERT INTO SACH VALUES(1,'Ke cho em nghe','Nguyen Nhat Anh',15000,1),(2,'Trang Quynh','Kim Dong',5000,1)");


        String tNguoiDung ="CREATE TABLE NGUOIDUNG(mand integer primary key autoincrement ,tennd text,sodienthoai text,diachi text,tendangnhap text,matkhau text,role integer)";
        db.execSQL(tNguoiDung);
        //data
        db.execSQL("INSERT INTO NGUOIDUNG VALUES(1,'Hoang Tien Dat','0384081841','HaNoi','datht','123',1),(2,'Nguyen Quoc Doan','0384328512','Thai Binh','doannq','123',2),(3,'DANG MINH QUAN','0383285712','Ha Tay','quandm','123',3)");

        String tPhieuMuon ="CREATE TABLE PHIEUMUON(mapm integer primary key autoincrement,ngaymuon text, ngaytra text,mand integer references NGUOIDUNG(mand))";
        db.execSQL(tPhieuMuon);
        //data
        db.execSQL("INSERT INTO PHIEUMUON VALUES(1,'20/9/2023','26/9/2023',1)");

        String tCTPM ="CREATE TABLE CTPM(mapm integer primary key references PHIEUMUON(mapm),maSach integer primary key references SACH(masach),soluong integer)";
        db.execSQL(tCTPM);
        //data
        db.execSQL("INSERT INTO CTPM VALUES(1,1,2),(1,2,1)");
        /*
        role:
        1- nguoi dung
        2- thu thu
        3- admin
         */
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
