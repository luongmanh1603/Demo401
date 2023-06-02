package demo1;

import database.Connecter;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddformController {

    public TextField txtId;
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtDate;
    public TextField txtTel;

    public void backList(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("room.fxml"));
        Main.mainStage.setScene(new Scene(root,600,400));

    }

    public void submit(ActionEvent actionEvent) throws Exception {
        try {
            String name = txtName.getText();
            String email = txtEmail.getText();
            String date = txtDate.getText();
            String tel = txtTel.getText();
            Room p = new Room(name, email, date, tel);
            Connection conn = new Connecter().getConn();
            String sql = "insert into room401(name,email,date,tel) values(?,?,?,?) ";
            PreparedStatement stt = conn.prepareStatement(sql);
            stt.setString(1, p.getName());
            stt.setString(2, p.getEmail());
            stt.setString(3, p.getDate());
            stt.setString(4, p.getTel());
            stt.executeUpdate();
            backList(null);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
}
