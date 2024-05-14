package br.com.currencyconvert.convert;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Button buttonConvert;

    @FXML
    private ComboBox<String> comboIN;

    @FXML
    private ComboBox<String> comboOUT;

    @FXML
    private TextField textIN;

    @FXML
    private TextField textOUT;

    @FXML
    void onConvert(ActionEvent event) {

        double[] rates = {1, 0.70, 0.20, 0.02, 1.3};
        if (!textIN.toString().isBlank() && !textOUT.toString().isBlank()) {

            int indexIN = comboIN.getSelectionModel().getSelectedIndex();
            int indexOUT = comboOUT.getSelectionModel().getSelectedIndex();

            double converted = Double.parseDouble(textIN.toString());
            if (rates[indexIN] < 1) {
                converted = converted * rates[indexIN];
            } else {
                converted = converted / rates[indexIN];
            }

            if (rates[indexOUT] < 1) {
                converted = converted / rates[indexOUT];
            } else {
                converted = converted * rates[indexOUT];
            }
            textOUT.setText(Double.toString(converted));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String [] items = {"USD","CAD","BRL","KNZ","EUR"};
        comboIN.getItems().addAll(items);
        comboOUT.getItems().addAll(items);
    }
}