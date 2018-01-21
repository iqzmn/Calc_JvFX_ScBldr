package com.thorus;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    private String inStr = "0";
    public char lastOperator = ' ';
    private double result = 0;

    @FXML
    public TextField tfDisplay;

    private void compute() {
        double inNum = Double.parseDouble(inStr);
        inStr = "0";
        if (lastOperator == ' ') {
            result = inNum;
        } else if (lastOperator == '+') {
            result += inNum;
        } else if (lastOperator == '-') {
            result -= inNum;
        } else if (lastOperator == '*') {
            result *= inNum;
        } else if (lastOperator == '/') {
            result /= inNum;
        }else if (lastOperator == '=') {
            // Keep the result for the next operation\
        }
        zeroCheck(String.valueOf(result));
    }

    private void zeroCheck(String s){
            if (s.endsWith("0")&(s.contains("."))){
                tfDisplay.setText((int)result + "");
            }else
        tfDisplay.setText(result + "");
    }

    EventHandler handler = this::handle;

    @FXML
    private void handle(Event evt) {
        String currentBtnLabel = ((Button) evt.getSource()).getText();
        switch (currentBtnLabel) {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case ".":
                if (inStr.equals("0")) {
                    inStr = currentBtnLabel;
                } else {
                    inStr += currentBtnLabel;
                }
                tfDisplay.setText(inStr);
                if (lastOperator == '=' ) {
                    result = 0;
                    lastOperator = ' ';
                }
                break;

            case "+":
                compute();
                lastOperator = '+';
                break;
            case "-":
                compute();
                lastOperator = '-';
                break;
            case "x":
                compute();
                lastOperator = '*';
                break;
            case "/":
                compute();
                lastOperator = '/';
                break;
            case "=":
                compute();
                lastOperator = '=';
                break;
            case "√":
                result = Math.sqrt(Double.parseDouble(inStr));
                zeroCheck(result+"");
                lastOperator = '=';
                inStr = "0";
                break;
            case "%":
                result = result*Double.parseDouble(inStr)/100;
                zeroCheck(result + "");
                lastOperator = '=';
                inStr = "0";
                break;
            case "DEL":
                if(tfDisplay.getText().length()>0) {
                    tfDisplay.setText(tfDisplay.getText(0, tfDisplay.getText().length() - 1));
                }
                inStr = tfDisplay.getText();
                result = Double.parseDouble(inStr);
                break;
            // Clear button
            case "C":
                result = 0;
                inStr = "0";
                lastOperator = ' ';
                tfDisplay.setText("0");
                break;
        }
    }
}