package spk.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import spk.ctrl.KampungModify;
import spk.ctrl.Statis;

public class Kampung extends VBox {
    private TableView table;
    private Button button_tambah,button_hapus,button_ubah;
    private Label ket;

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

        button_tambah=new Button("Tambah");
        button_tambah.setPrefWidth(100);

        button_ubah=new Button("Ubah");
        button_ubah.setPrefWidth(100);

        button_hapus=new Button("Hapus");
        button_hapus.setPrefWidth(100);

        ket=new Label();

        table=new TabelKampung();
        table.setItems(new KampungModify().GetTableItem());
        table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

            }
        });
    }
}
