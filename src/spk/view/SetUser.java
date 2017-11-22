package spk.view;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import spk.ctrl.Statis;

public class SetUser extends VBox {
    private GridPane grid;
    private TextField txId,txNama;

    public SetUser() {
        Inits();

        grid.add(new Label("ID"),0,0);
        grid.add(txId,1,0);

        grid.add(new Label("Nama"),0,1);
        grid.add(txNama,1,1);

        getChildren().addAll(new Judul("Pengaturan User"),new Separator(Orientation.HORIZONTAL),grid);
    }

    private void Inits() {

        setSpacing(5);
        setPadding(new Insets(5,5,5,5));
        setMaxHeight(500);
        setMaxWidth(1042);
        setStyle(new Statis().getSTYLE_BOX());
        setAlignment(Pos.TOP_CENTER);

        grid=new GridPane();
        grid.setHgap(5);grid.setVgap(5);

        txId=new TextField();
        txNama=new TextField();
    }
}
