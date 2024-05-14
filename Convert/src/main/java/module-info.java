module br.com.currencyconvert.convert {
    requires javafx.controls;
    requires javafx.fxml;


    opens br.com.currencyconvert.convert to javafx.fxml;
    exports br.com.currencyconvert.convert;
}