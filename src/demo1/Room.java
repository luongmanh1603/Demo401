package demo1;

import javafx.scene.control.Button;

public class Room {
    int id;
    String name;
    String email;
    String date;
    String tel;
    Button edit ;

    public Room(int id, String name, String email, String date,String tel) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.email = email;
        this.tel = tel;
        this.edit = new Button("Edit");
    }

    public Room() {

    }

    public Room(String name, String email, String date, String tel) {
        this.name = name;
        this.date = date;
        this.email = email;
        this.tel = tel;
    }

    public Button getEdit() {
        return edit;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
