package spk.view;

import com.sun.istack.internal.Nullable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import spk.ctrl.KampungModify;
import spk.model.DataKampung;

/**
 * Created by android on 11/20/17.
 */
public class KampungDialog extends Dialog {
    private Button button_save;
    private TextField text_pum,text_desa,text_camat,text_kab,text_prov,text_tahun,text_dasar_hukum;
    private TextField text_peta,text_lat,text_lon,text_utara,text_selatan,text_timur,text_barat;
    private DataKampung dataKampung;
    private String tmp_id="";

    public KampungDialog(@Nullable DataKampung dataKampung){
        this.dataKampung=dataKampung;
        Inits();
        text_pum.requestFocus();
    }

    private void Inits() {
        // Create the custom dialog.
        setTitle("Data Kampung");
        setHeaderText("Menambah Data Kampung");
        if (dataKampung!=null)setHeaderText("Mengubah Data Kampung");

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

        if (dataKampung!=null){
            tmp_id=dataKampung.getId();
            text_pum.setText(dataKampung.getKode_desa_pum());
            text_pum.setDisable(true);
            text_desa.setText(dataKampung.getDesa_kelurahan());
            text_camat.setText(dataKampung.getKecamatan());
            text_kab.setText(dataKampung.getKabupaten_kota());
            text_prov.setText(dataKampung.getProvinsi());

            text_tahun.setText(dataKampung.getTahun_bentuk());
            text_dasar_hukum.setText(dataKampung.getDasar_hukum());
            text_peta.setText(dataKampung.getPeta_resmi_wilayah());
            text_lat.setText(dataKampung.getLat());
            text_lon.setText(dataKampung.getLon());
            text_utara.setText(dataKampung.getUtara());
            text_selatan.setText(dataKampung.getSelatan());
            text_timur.setText(dataKampung.getTimur());
            text_barat.setText(dataKampung.getBarat());
        }

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

            if(text_pum.getText().trim().length()>0 && text_desa.getText().trim().length()>0 && text_camat.getText().trim().length()>0 && text_kab.getText().trim().length()>0 && text_prov.getText().trim().length()>0 && text_tahun.getText().trim().length()>0 && text_dasar_hukum.getText().trim().length()>0 && text_peta.getText().trim().length()>0 && text_lat.getText().trim().length()>0 && text_lon.getText().trim().length()>0 && text_utara.getText().trim().length()>0 && text_selatan.getText().trim().length()>0 && text_timur.getText().trim().length()>0 && text_barat.getText().trim().length()>0)
            {
                DataKampung dk=new DataKampung();

                dk.setKode_desa_pum(text_pum.getText().trim());
                dk.setDesa_kelurahan(text_desa.getText().trim());
                dk.setKecamatan(text_camat.getText().trim());
                dk.setKabupaten_kota(text_kab.getText().trim());
                dk.setProvinsi(text_prov.getText().trim());
                dk.setTahun_bentuk(text_tahun.getText().trim());
                dk.setDasar_hukum(text_dasar_hukum.getText().trim());
                dk.setPeta_resmi_wilayah(text_peta.getText().trim());
                dk.setLat(text_lat.getText().trim());
                dk.setLon(text_lon.getText().trim());
                dk.setUtara(text_utara.getText().trim());
                dk.setSelatan(text_selatan.getText().trim());
                dk.setTimur(text_timur.getText().trim());
                dk.setBarat(text_barat.getText().trim());

                if (tmp_id!="" && dataKampung!=null){
                    //Update
                    dk.setId(tmp_id);
                    new KampungModify().Ubah(dk);
                }else{
                    //Insert
                    new KampungModify().Simpan(dk);
                }
            }

        });

        getDialogPane().setContent(grid);

    }
}
