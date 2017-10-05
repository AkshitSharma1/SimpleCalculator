/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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
    void divide(ActionEvent event) {
        value = value.concat(" / ");
        position = true;
        op = "DIV";
        displayText();
    }

    @FXML
    void eight(ActionEvent event) {
      addText("8");
    }

    @FXML
    void equal(ActionEvent event) {
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
    void five(ActionEvent event) {
    addText("5");
    }

    @FXML
    void four(ActionEvent event) {
    addText("4");
    }

    @FXML
    void minus(ActionEvent event) {
        value = value.concat(" - ");
        position = true;
        op = "SUB";
        displayText();
    }

    @FXML
    void multiply(ActionEvent event) {
        value = value.concat(" X ");
        position = true;
        op = "MUL";
        displayText();
    }

    @FXML
    void nine(ActionEvent event) {
        addText("9");
    }

    @FXML
    void one(ActionEvent event) {
        addText("1");
    }

    @FXML
    void plus(ActionEvent event) {
    value = value.concat(" + ");
        position = true;
        op = "ADD";
        displayText();
    }

    @FXML
    void seven(ActionEvent event) {
        addText("7");
    }

    @FXML
    void six(ActionEvent event) {
        addText("6");
    }

    @FXML
    void three(ActionEvent event) {
        addText("3");
    }

    @FXML
    void two(ActionEvent event) {
        addText("2");
    }

    @FXML
    void zero(ActionEvent event) {
        addText("0");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
