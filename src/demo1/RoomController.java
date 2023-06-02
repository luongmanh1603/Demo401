package demo1;

import java.io.IOException;
import java.sql.*;

import database.Connecter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
public class RoomController implements Initializable {

    public TableView<Room> tbR;
    public TableColumn<Room,Integer> tcID;
    public TableColumn<Room,String> tcName;
    public TableColumn<Room,String> tcEmail;
    public TableColumn<Room,String> tcDate;
    public TableColumn<Room,String> tcTel;
    public TableColumn<Room, Button> tcEit;

    public void gotoFormAdd(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addform.fxml"));
        Main.mainStage.setScene(new Scene(root,600,400));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
          tcID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tcDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        tcTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        tcEit.setCellValueFactory(new PropertyValueFactory<>("edit"));
        try {
            Connection conn = new Connecter().getConn();

            //query
            Statement stt = conn.createStatement();
            String sql = "select * from room401";
            ResultSet rs = stt.executeQuery(sql);
            ObservableList<Room> people = FXCollections.observableArrayList();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String date = rs.getString("date");
                String tel = rs.getString("tel");
                Room p = new Room(id,name,email,date,tel);
                people.add(p);



            }
            tbR.setItems(people);
        } catch (Exception e) {
            System.out.println("error"+ e.getMessage());

        }
    }
}
