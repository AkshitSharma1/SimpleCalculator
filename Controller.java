/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.awt.Font;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

/**
 *
 * @author Akshit
 */
public class Controller implements Initializable {
    
    @FXML
    private Text output;
    private long n1,n2;
    boolean position = false; // False -> N1, True -> N2
    String op = "";
    String value = "";
    void addText(String toadd) {
        if(!position) {
            String temp = String.valueOf(n1);
            temp = temp.concat(toadd);
            n1 = Integer.valueOf(temp);
        } else if(position) {
            String temp = String.valueOf(n2);
            temp = temp.concat(toadd);
            n2 = Integer.valueOf(temp);
        }
        value = value.concat(toadd);
        displayText();
    }
    void displayText() {
        output.setText(value);
    }
    @FXML
    void divide() {
        value = value.concat(" / ");
        position = true;
        op = "DIV";
        displayText();
    }

    @FXML
    void eight() {
      addText("8");
    }

    @FXML
    void equal() {
        if(n1==0&&n2==0) {
            output.setText("ERROR: No value");
        }
       switch(op) {
           case "DIV":
               if(n2==0) { output.setText("ERR: Div. error"); break; }
               long d = n1 / n2;
               
               value = String.valueOf(d);
               displayText();
               n1 = 0;
               n2 = 0;
               break;
            case "MUL":
               long m = n1 * n2;
               value = String.valueOf(m);
               displayText();
               n1 = m;
               n2 = 0;
               break;
            case "ADD":
                long a = n1 + n2;
                value = String.valueOf(a);
                displayText();
                n1 = a;
                n2 = 0;
                break;
            case "SUB":
                long s = n1 - n2;
                value = String.valueOf(s);
                displayText();
                n1 = s;
                n2 = 0;
       }
       position = false;
    }

    @FXML
    void five() {
    addText("5");
    }

    @FXML
    void four() {
    addText("4");
    }

    @FXML
    void minus() {
        value = value.concat(" - ");
        position = true;
        op = "SUB";
        displayText();
    }

    @FXML
    void multiply() {
        value = value.concat(" X ");
        position = true;
        op = "MUL";
        displayText();
    }
    
    @FXML
    void bugs() {
        output.setText("3 bugs known so far.");
       
                }

    @FXML
    void nine() {
        addText("9");
    }

    @FXML
    void one() {
        addText("1");
    }

    @FXML
    void plus() {
    value = value.concat(" + ");
        position = true;
        op = "ADD";
        displayText();
    }

    @FXML
    void seven() {
        addText("7");
    }

    @FXML
    void six() {
        addText("6");
    }

    @FXML
    void three() {
        addText("3");
    }

    @FXML
    void two() {
        addText("2");
    }
    @FXML
    void exit() {
        System.exit(0);
    }
    @FXML
    void zero() {
        addText("0");
    }
    @FXML
    void keypressed(KeyEvent event) {
     
        if (event.getCode() == KeyCode.DIGIT8 && event.isShiftDown()) { 
            multiply(); } else {
    
        switch (event.getCode()) {
            case DIGIT1:
                one();
                break;
            case DIGIT0:
                zero();
                break;
            case DIGIT2:
                two();
                break;
            case DIGIT3:
                three();
                break;
            case DIGIT4:
                four();
                break;
            case DIGIT5:
                five();
                break;
            case DIGIT6:
                six();
                break;
            case DIGIT7:
                seven();
                break;
            case DIGIT8:
                eight();
                break;
            case DIGIT9:
                nine();
                break;
            case EQUALS:
                plus();
                break;
            case ENTER:
                equal();
                break;
            case MINUS:
                minus();
                break;
           
            case SLASH:
                divide();
                break;
        }
          // 8 and 9      
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
