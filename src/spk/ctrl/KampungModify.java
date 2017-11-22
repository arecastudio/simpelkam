package spk.ctrl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import spk.model.DataKampung;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KampungModify {
    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;
    private DBHelper helper;
    private String sql="";

    public KampungModify(){
        conn=helper.Konek();
    }

    public ObservableList<DataKampung> GetTableItem(){
        ObservableList<DataKampung> data= FXCollections.observableArrayList();
        sql="SELECT id, kode_desa_pum, desa_kelurahan, kecamatan, kabupaten_kota, provinsi, tahun_bentuk, dasar_hukum, peta_resmi_wilayah, lat, lon, utara, selatan, timur, barat FROM pokok_desa ORDER BY desa_kelurahan ASC;";
        try {
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            while (rs.next()){
                DataKampung dk=new DataKampung();
                dk.setId(rs.getString(1));
                dk.setKode_desa_pum(rs.getString(2));
                dk.setDesa_kelurahan(rs.getString(3));
                dk.setKecamatan(rs.getString(4));
                dk.setKabupaten_kota(rs.getString(5));
                dk.setProvinsi(rs.getString(6));
                dk.setTahun_bentuk(rs.getString(7));
                data.add(dk);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public DataKampung GetDataKampungById(String id){
        DataKampung dk=new DataKampung();
        sql="SELECT id, kode_desa_pum, desa_kelurahan, kecamatan, kabupaten_kota, provinsi, tahun_bentuk, dasar_hukum, peta_resmi_wilayah, lat, lon, utara, selatan, timur, barat FROM pokok_desa WHERE id=? ORDER BY id ASC;";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1,id);
            rs=pst.executeQuery();
            if (rs.next()){
                dk.setId(rs.getString(1));
                dk.setKode_desa_pum(rs.getString(2));
                dk.setDesa_kelurahan(rs.getString(3));
                dk.setKecamatan(rs.getString(4));
                dk.setKabupaten_kota(rs.getString(5));
                dk.setProvinsi(rs.getString(6));
                dk.setTahun_bentuk(rs.getString(7));
                dk.setDasar_hukum(rs.getString(8));
                dk.setPeta_resmi_wilayah(rs.getString(9));
                dk.setLat(rs.getString(10));
                dk.setLon(rs.getString(11));
                dk.setUtara(rs.getString(12));
                dk.setSelatan(rs.getString(13));
                dk.setTimur(rs.getString(14));
                dk.setBarat(rs.getString(14));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dk;
    }

    public int Simpan(DataKampung dk){
        int ret=0;
        sql="INSERT IGNORE INTO pokok_desa(kode_desa_pum, desa_kelurahan, kecamatan, kabupaten_kota, provinsi, tahun_bentuk, dasar_hukum, peta_resmi_wilayah, lat, lon, utara, selatan, timur, barat)VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1,dk.getKode_desa_pum());
            pst.setString(2,dk.getDesa_kelurahan());
            pst.setString(3,dk.getKecamatan());
            pst.setString(4,dk.getKabupaten_kota());
            pst.setString(5,dk.getProvinsi());
            pst.setString(6,dk.getTahun_bentuk());

            pst.setString(7,dk.getDasar_hukum());
            pst.setString(8,dk.getPeta_resmi_wilayah());
            pst.setString(9,dk.getLat());
            pst.setString(10,dk.getLon());
            pst.setString(11,dk.getUtara());
            pst.setString(12,dk.getSelatan());
            pst.setString(13,dk.getTimur());
            pst.setString(14,dk.getBarat());

            ret=pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public int Ubah(DataKampung dk){
        int ret=0;
        sql="UPDATE pokok_desa SET kode_desa_pum=?, desa_kelurahan=?, kecamatan=?, kabupaten_kota=?, provinsi=?, tahun_bentuk=?, dasar_hukum=?, peta_resmi_wilayah=?, lat=?, lon=?, utara=?, selatan=?, timur=?, barat=? WHERE id=?;";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1,dk.getKode_desa_pum());
            pst.setString(2,dk.getDesa_kelurahan());
            pst.setString(3,dk.getKecamatan());
            pst.setString(4,dk.getKabupaten_kota());
            pst.setString(5,dk.getProvinsi());
            pst.setString(6,dk.getTahun_bentuk());

            pst.setString(7,dk.getDasar_hukum());
            pst.setString(8,dk.getPeta_resmi_wilayah());
            pst.setString(9,dk.getLat());
            pst.setString(10,dk.getLon());
            pst.setString(11,dk.getUtara());
            pst.setString(12,dk.getSelatan());
            pst.setString(13,dk.getTimur());
            pst.setString(14,dk.getBarat());

            pst.setInt(15,Integer.parseInt(dk.getId()));

            ret=pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public int Hapus(String id){
        int ret=0;
        sql="DELETE FROM pokok_desa WHERE id=?";
        try {
            pst=conn.prepareStatement(sql);
            pst.setInt(1,Integer.parseInt(id));
            ret=pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
