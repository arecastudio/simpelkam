package spk.view;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import spk.model.DataKampung;

/**
 * Created by android on 11/20/17.
 */
public class KampungDialog extends Dialog {
    private Button button_save;
    private TextField text_pum,text_desa,text_camat,text_kab,text_prov,text_tahun,text_dasar_hukum;
    private TextField text_peta,text_lat,text_lon,text_utara,text_selatan,text_timur,text_barat;

    public KampungDialog(){
        Inits();
        text_pum.requestFocus();
    }

    private void Inits() {
        // Create the custom dialog.
        setTitle("Data Kampung");
        setHeaderText("Menambahkan Data Kampung");
        //setWidth(800);

        // Set the icon (must be included in the project).
        //Image imaji= new Image(getClass().getResourceAsStream("/spk/img/add-icon.png"));
        ImageView imageView=new ImageView(new Image(getClass().getResourceAsStream("/spk/img/add-icon.png")));
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);
        setGraphic(imageView);

        // Set the button types.
        ButtonType type_save = new ButtonType("Save", ButtonBar.ButtonData.OK_DONE);
        getDialogPane().getButtonTypes().addAll(type_save, ButtonType.CANCEL);

        text_pum=new TextField();
        text_desa=new TextField();
        text_camat=new TextField();
        text_kab=new TextField();
        text_prov=new TextField();
        text_tahun=new TextField();
        text_dasar_hukum=new TextField();
        text_peta=new TextField();
        text_lat=new TextField();
        text_lon=new TextField();
        text_utara=new TextField();
        text_selatan=new TextField();
        text_timur=new TextField();
        text_barat=new TextField();

        // Create the username and password labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        grid.add(new Label("Kode PUM"),0,0);
        grid.add(text_pum,1,0);

        grid.add(new Label("Kampung/Kelurahan"),0,1);
        grid.add(text_desa,1,1);

        grid.add(new Label("Kecamatan"),0,2);
        grid.add(text_camat,1,2);

        grid.add(new Label("Kabupaten"),0,3);
        grid.add(text_kab,1,3);

        grid.add(new Label("Provinsi"),0,4);
        grid.add(text_prov,1,4);

        grid.add(new Label("Thn. Bentuk"),0,5);
        grid.add(text_tahun,1,5);

        grid.add(new Label("Dasar Hukum"),0,6);
        grid.add(text_dasar_hukum,1,6);

        grid.add(new Label("Peta Wilayah"),0,7);
        grid.add(text_peta,1,7);

        grid.add(new Label("Latitude"),0,8);
        grid.add(text_lat,1,8);

        grid.add(new Label("Longitude"),0,9);
        grid.add(text_lon,1,9);

        grid.add(new Label("Batas Utara"),0,10);
        grid.add(text_utara,1,10);

        grid.add(new Label("Batas Selatan"),0,11);
        grid.add(text_selatan,1,11);

        grid.add(new Label("Batas Timur"),0,12);
        grid.add(text_timur,1,12);

        grid.add(new Label("Batas Barat"),0,13);
        grid.add(text_barat,1,13);




        button_save=(Button) getDialogPane().lookupButton(type_save);
        button_save.setOnAction(e->{
            //System.out.println("Simpan.....");
            DataKampung dk=new DataKampung();
            dk.setKode_desa_pum(text_pum.getText());
        });

        getDialogPane().setContent(grid);

    }
}
