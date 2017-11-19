package spk.view;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import spk.model.DataKampung;

public class TabelKampung extends TableView {

    public TabelKampung(){
        setEditable(false);
        setColumnResizePolicy((param) -> true );
        //this.getStyleClass().addAll("table");

        //id, kode_desa_pum, desa_kelurahan, kecamatan, kabupaten_kota, provinsi, tahun_bentuk

        TableColumn idCol = new TableColumn("ID");
        TableColumn pumCol = new TableColumn("Kode PUM");
        TableColumn namaCol = new TableColumn("Nama Desa/Kelurahan");
        TableColumn kecamatanCol = new TableColumn("Kecamatan");
        TableColumn kabkotaCol=new TableColumn("Kab./Kota");
        TableColumn provCol=new TableColumn("Provinsi");
        TableColumn tahunCol = new TableColumn("Tahun");

        getColumns().addAll(idCol,pumCol,namaCol,kecamatanCol,kabkotaCol,provCol,tahunCol);

        idCol.setCellValueFactory(new PropertyValueFactory<DataKampung,String>("id"));
        pumCol.setCellValueFactory(new PropertyValueFactory<DataKampung,String>("kode_desa_pum"));
        namaCol.setCellValueFactory(new PropertyValueFactory<DataKampung,String>("desa_kelurahan"));

        kecamatanCol.setCellValueFactory(new PropertyValueFactory<DataKampung,String>("kecamatan"));
        kabkotaCol.setCellValueFactory(new PropertyValueFactory<DataKampung,String>("kabupaten_kota"));
        provCol.setCellValueFactory(new PropertyValueFactory<DataKampung,String>("provinsi"));
        tahunCol.setCellValueFactory(new PropertyValueFactory<DataKampung,String>("tahun_bentuk"));

        kecamatanCol.setPrefWidth(200);
        namaCol.setPrefWidth(200);
        pumCol.setPrefWidth(200);
        kabkotaCol.setPrefWidth(200);
        provCol.setPrefWidth(100);
    }
}
