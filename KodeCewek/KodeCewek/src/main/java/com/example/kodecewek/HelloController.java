package com.example.kodecewek;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.application.Platform;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private VBox chatContainer;

    @FXML
    private HBox choiceContainer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Tambahkan chat pertama
        tampilkanChat("Cewek", "Aku nggak apa-apa kok 😊", false);

        // Tambahkan pilihan jawaban
        String[] pilihan = new String[3];
        pilihan[0] = "Oke deh";
        pilihan[1] = "Beneran?";
        pilihan[2] = "Aku temenin ya...";

        tampilkanPilihan(pilihan);
    }

    private void tampilkanChat(String nama, String pesan, boolean dariUser) {
        Label label = new Label(nama + ": " + pesan);
        label.setStyle("-fx-background-color: " + (dariUser ? "lightblue" : "lightgray") +
                "; -fx-padding: 10; -fx-background-radius: 10;");
        label.setWrapText(true);

        HBox bubble = new HBox(label);
        bubble.setAlignment(dariUser ? Pos.CENTER_RIGHT : Pos.CENTER_LEFT);
        chatContainer.getChildren().add(bubble);

        // Scroll otomatis ke bawah
        Platform.runLater(() -> chatContainer.layout());
    }

    private void tampilkanPilihan(String[] pilihan) {
        choiceContainer.getChildren().clear();

        int i = 0;
        while (i < pilihan.length) {
            String opsi = pilihan[i];

            Button btn = new Button(opsi);
            btn.setOnAction(e -> {
                tampilkanChat("Kamu", opsi, true);
                responCewek(opsi);
            });

            choiceContainer.getChildren().add(btn);
            i++;
        }
    }

    private void responCewek(String jawaban) {
        choiceContainer.getChildren().clear();

        if (jawaban.equals("Aku temenin ya...")) {
            tampilkanChat("Cewek", "Awww... makasih ya! ❤️", false);
        } else {
            tampilkanChat("Cewek", "Yaudah deh. 😐", false);
        }
    }
}
