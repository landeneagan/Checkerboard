/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.awt.Color;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author lande
 */
public class Board {
    private int numRows;
    private int numCols;
    private double boardWidth;
    private double boardHeight;
    private Color lightColor;
    private Color darkColor;
    private double rectangleWidth;
    private double rectangleHeight;
    private AnchorPane anchorPane;
    
    private javafx.scene.paint.Color[] colors = {javafx.scene.paint.Color.RED, javafx.scene.paint.Color.BLACK};
    
     public Board(int numRows, int numCols, double boardWidth, double boardHeight) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        
       
        anchorPane = new AnchorPane();
    }
     
     public Board(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor) {
         
     }
     
     public AnchorPane build(double width, double height) {
        clear();
        this.boardWidth = width;
        this.boardHeight = height;
        rectangleWidth = Math.ceil(width / (double)numCols);
        rectangleHeight = Math.ceil(height / (double)numRows);
        anchorPane.setPrefWidth(width);
        anchorPane.setPrefHeight(height);
        
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                javafx.scene.paint.Color color = colors[col % 1];
                Rectangle rect = new Rectangle(rectangleWidth, rectangleHeight, color);
                
                anchorPane.getChildren().add(col, rect);
            }
        }
        
        return anchorPane;
    }
     
     public AnchorPane getBoard() {
        return anchorPane;
    }
     
      public void clear() {
        anchorPane.getChildren().clear();
    }
     
     public int getNumRows() {
        return numRows;
    }
     
    public int getNumCols() {
        return numCols;
    }
    
    public double getWidth() {
        return boardWidth;
    }
    
    public double getHeight() {
        return boardHeight;
    }
    
    public Color getLightColor() {
        return lightColor;
    }
    
    public Color getDarkColor() {
        return darkColor;
    }
    
    public double getRectangleWidth() {
        return rectangleWidth;
    }
    
    public double getRectangleHeight() {
        return rectangleHeight;
    }
}
