/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipfxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author woon
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private Label l1;
    @FXML
    private Label l2;
    @FXML
    private Slider s1;
    @FXML
    private Button btn;
    @FXML
    private TextField tf1;
    @FXML
    private TextField tf2;
    @FXML
    private TextField tf3;
    @FXML
    private void press(){
       if(Double.parseDouble(tf1.getText())<0){
        Stage stage = new Stage();
        Label l = new Label("Error Input!");
        Button b1= new Button("OK");
    b1.setPrefSize(100, 20);
    AnchorPane ap =new AnchorPane();
    ap.setBottomAnchor(b1,10.0);
    ap.setRightAnchor(b1,10.0);
    ap.setRightAnchor(l,25.0);
    ap.setLeftAnchor(l,25.0);
    ap.setTopAnchor(l,25.0);
    ap.setBottomAnchor(l,25.0);
    l.setAlignment(Pos.CENTER);
    ap.getChildren().addAll(b1,l);
            Scene s = new Scene(ap);
            stage.setScene(s);
            stage.setWidth(250);
            stage.setHeight(200);
            
            stage.show();
            b1.setOnAction((k)->{
   
        stage.close();
    });
        
    }else{
    double temp1 = (s1.getValue()/100)*Double.parseDouble(tf1.getText());
double temp2 = Double.parseDouble(tf1.getText())+temp1;
tf2.textProperty().setValue(String.format("%.2f",temp1));
tf3.textProperty().setValue(String.format("%.2f",temp2));
    }


    }    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            DropShadow shadow = new DropShadow();
s1.valueProperty().addListener((e)->{
    l2.textProperty().setValue(String.valueOf((int)s1.getValue())+"%");
    });
btn.setOnMouseEntered((e)->{
btn.setEffect(shadow);
});
btn.setOnMouseExited((e)->{
btn.setEffect(null);
});
    }    
    
}
