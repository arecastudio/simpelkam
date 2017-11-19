package spk;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import spk.ctrl.Statis;
import spk.view.Kampung;
import spk.view.Login;

public class Main extends Application {
    public static Stage stage;
    public static BorderPane borderPane;
    private Scene scene;

    public static MenuBar menuBar;
    public static MenuItem pokok_kampung,pilih_kampung,log_out;
    public static MenuItem penggunaan_lahan,produksi_pertanian_perkebunan,kehutanan,peternakan,sumber_air,obyek_wisata,sumber_daya_mc;
    public static MenuItem rep_penggunaan_lahan,rep_produksi_pertanian_perkebunan,rep_kehutanan,rep_peternakan,rep_sumber_air,rep_obyek_wisata,rep_sumber_daya_mc;
    public static MenuItem set_user,set_role,set_db,manual_book,abouts;

    @Override
    public void start(Stage stage) throws Exception{
        this.stage=stage;
        this.stage.setTitle("Sistem Informasi Manajemen Pelaporan Kampung");

        SetMenu();

        borderPane=new BorderPane();
        borderPane.setStyle(new Statis().getSTYLE_MAIN());
        //borderPane.setTop(new Label("Aplikasi Kampung."));
        borderPane.setCenter(new Login());

        scene=new Scene(borderPane,1024,800);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    private void SetMenu() {
        menuBar = new MenuBar();

        Menu menuBerkas = new Menu("Berkas");
        pokok_kampung=new MenuItem("Profil Kampung");
        pilih_kampung=new MenuItem("Pilih Kampung");
        log_out=new MenuItem("Log out");
        menuBerkas.getItems().addAll(pokok_kampung,pilih_kampung,new SeparatorMenuItem(),log_out);


        menuBar.getMenus().addAll(menuBerkas);
        ClickMenu();
    }

    private void ClickMenu() {
        log_out.setOnAction(event -> {
            borderPane.setTop(null);
            borderPane.setCenter(new Login());
        });

        pokok_kampung.setOnAction(event -> {
            borderPane.setCenter(new Kampung());
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
