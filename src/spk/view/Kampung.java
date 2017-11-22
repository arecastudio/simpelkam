package spk.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import spk.ctrl.KampungModify;
import spk.ctrl.Statis;
import spk.model.DataKampung;

import java.util.Optional;

public class Kampung extends VBox {
    private TableView table;
    private Button button_tambah,button_hapus,button_ubah;
    private Label ket;
    private String tmp_id="";

    public Kampung() {
        Inits();

        HBox hbox=new HBox(button_tambah,button_ubah,new Separator(Orientation.VERTICAL),button_hapus);
        hbox.setSpacing(5);

        getChildren().addAll(new Judul("Data Pokok Kampung / Kelurahan"),new Separator(Orientation.HORIZONTAL),hbox,table,new HBox(new Label("Keterangan : "),ket));
    }

    private void Inits() {
        setSpacing(5);
        setPadding(new Insets(5,5,5,5));
        setMaxHeight(500);
        setMaxWidth(1042);
        setStyle(new Statis().getSTYLE_BOX());
        setAlignment(Pos.TOP_CENTER);

        ket=new Label();

        table=new TabelKampung();
        table.setItems(new KampungModify().GetTableItem());
        table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (table.getSelectionModel().getSelectedItem()!=null){
                    DataKampung dk=(DataKampung)table.getSelectionModel().getSelectedItem();
                    tmp_id=dk.getId();
                    ket.setText(dk.getDesa_kelurahan());
                }
            }
        });

        button_tambah=new Button("Tambah");
        button_tambah.setPrefWidth(100);
        button_tambah.setOnAction(e->{
            Dialog dialog=new KampungDialog(null);
            dialog.showAndWait();

            Refresh();
        });

        button_ubah=new Button("Ubah");
        button_ubah.setPrefWidth(100);
        button_ubah.setOnAction(e->{
            if (tmp_id!=""){
                DataKampung dk=new KampungModify().GetDataKampungById(tmp_id);

                Dialog dialog=new KampungDialog(dk);
                dialog.showAndWait();

                //table.setItems(new KampungModify().GetTableItem());
                Refresh();
            }
        });

        button_hapus=new Button("Hapus");
        button_hapus.setPrefWidth(100);
        button_hapus.setOnAction(e->{
            if (tmp_id!=""){
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Konfirmasi");
                alert.setHeaderText("Hapus ["+tmp_id+"]");
                alert.setContentText("Yakin untuk hapus data ini?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get()==ButtonType.OK){
                    new KampungModify().Hapus(tmp_id);
                }
                Refresh();
            }
        });
    }

    private void Refresh(){
        table.setItems(new KampungModify().GetTableItem());
        tmp_id="";
        ket.setText("");
    }
}
