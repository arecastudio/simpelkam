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
}
