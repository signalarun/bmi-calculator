/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bmicalculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Window;

import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author red
 */
public class BmiController implements Initializable {

    
    @FXML private TextField weight;

    
    @FXML private TextField height;
    
    
    @FXML private Label bmi;
    
    @FXML
    private Button calculateButton;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
    /**
     *
     * @param event
     */
    @FXML
    public void buttonClicked(ActionEvent event){
        
       Window owner = calculateButton.getScene().getWindow();
        
        String sWeight = weight.getText();
        String sHeight = height.getText();
       
        System.out.print(sWeight);
       
        if(sWeight.isEmpty()){
             AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", 
                    "Please enter your weights");
            return;
        }
        
        if(sHeight.isEmpty()){
             AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Wrong input!", 
                    "Please enter your weights");
            return;
        }
        
        float w = Float.parseFloat(sWeight);
        float h = Float.parseFloat(sHeight);
                
        float uBmi = (w/(h*h))*10000;
        /// ref : https://www.cdc.gov/obesity/adult/defining.html
        if(uBmi < 18.5){
            bmi.setText("Your BMI : " + String.valueOf(uBmi) + "\n" + "Underweight range");
        }else if(uBmi >=18.5 && uBmi < 25){
            bmi.setText("Your BMI : " + String.valueOf(uBmi) + "\n" + "Healthy weight range");
        }else if(uBmi >=25 && uBmi < 30){
            bmi.setText("Your BMI : " + String.valueOf(uBmi) + "\n" + "Over weight range");
        }else if(uBmi >= 30){
            if(uBmi >=30 && uBmi < 35)
              bmi.setText("Your BMI : " + String.valueOf(uBmi) + "\n" + "Obese range - Class 1" );
            else if(uBmi >=35 && uBmi < 40)
              bmi.setText("Your BMI : " + String.valueOf(uBmi) + "\n" + "Obese range - Class 2" );
            else if(uBmi >= 40)
              bmi.setText("Your BMI : " + String.valueOf(uBmi) + "\n" + "Obese range - Class 3" );
        }
        
        
        
        
        event.consume();
    }
}
