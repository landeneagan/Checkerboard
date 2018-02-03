/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author lande
 */
public class CheckerboardFXMLController implements Initializable, Startable {
    
    private Stage stage;
    
    private int numRows = 8; 
    private int numCols = 8; 
    private double boardWidth;
    private double boardHeight;
    
    private Board board;
    
    @FXML
    private VBox vBox;
    
    @FXML
    private void button16x16(ActionEvent event) {
        numRows = 16;
        numCols = 16;
        refresh();
    }
    
    @FXML
    private void button10x10(ActionEvent event) {
        numRows = 10;
        numCols = 10;
        refresh();
    }
    
    @FXML
    private void button8x8(ActionEvent event) {
        numRows = 8;
        numCols = 8;
        refresh();
    }
    
    @FXML
    private void button3x3(ActionEvent event) {
        numRows = 3;
        numCols = 3;
        refresh();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @Override
    public void start(Stage stage) {
        this.stage = stage;
        
        board = new Board(numRows, numCols, boardWidth, boardHeight);
        vBox.getChildren().add(board.getBoard());
        
        ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            refresh();
        };
        
        this.stage.widthProperty().addListener(lambdaChangeListener);
        this.stage.heightProperty().addListener(lambdaChangeListener);
        
        refresh();

        
    }
    
    private void refresh() {
        board.build(stage.getWidth(), stage.getHeight());
    }
    
}
