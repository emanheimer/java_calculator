import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.math.BigDecimal;
 
public class CalculatorFX extends Application {
    Button btnDivide;
    Button btnMultiply;
    Button btnAddition;
    Button btnSubtraction;
    Button btnClear;
    Button btnEqual;
    Button btnDecimal;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;
    Button b0;
    Button bNeg;
    Label lblAnswer;
    Label lblnums;
    Label lblo;
    double num1;
    double num2;
    double answer;  
    String enteredNums = "";
    String operation = ""; 
    
    @Override
    public void start(Stage primaryStage) { 
        b1 = new Button("1"); 
        b2 = new Button("2");
        b3 = new Button("3");
        b4 = new Button("4");
        b5 = new Button("5");
        b6 = new Button("6");
        b7 = new Button("7");
        b8 = new Button("8");
        b9 = new Button("9");
        b0 = new Button("0");
        bNeg = new Button("+/");
        
        btnDivide = new Button("/");
        btnMultiply = new Button("*");
        btnAddition = new Button("+");
        btnSubtraction = new Button("-");
        btnClear = new Button("C");
        btnEqual = new Button("=");
        btnDecimal = new Button(".");
        lblnums = new Label(""); 
        lblo = new Label(""); 
        lblAnswer = new Label("");
         
        lblAnswer.setAlignment(Pos.CENTER);
        lblAnswer.setStyle("-fx-border-color: #000; -fx-padding: 5px;");
         
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
         
        root.setHgap(15);
        root.setVgap(15);
         
        root.add(b1, 1, 1);
        root.add(b2, 2, 1);
        root.add(b3, 3, 1);
        root.add(b4, 1, 2);
        root.add(b5, 2, 2);
        root.add(b6, 3, 2);
        root.add(b7, 1, 3);
        root.add(b8, 2, 3);
        root.add(b9, 3, 3);
        root.add(b0, 2, 4);
        root.add(btnAddition, 4, 1);
        root.add(btnSubtraction, 4, 2);
        root.add(btnMultiply, 4, 3);
        root.add(btnDivide, 4, 4); 
        root.add(btnEqual, 1, 4, 2, 1);
        root.add(btnClear, 3, 4);
        root.add(btnDecimal, 4,5);
        root.add(bNeg, 5, 6); 
        root.add(lblnums, 5, 4);
        root.add(lblo, 5, 5);
        
        root.add(lblAnswer, 1, 5, 2, 1);
  
        bCode();
         
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 
    public void bCode() {
        //have each button run this when clicked
        btnAddition.setOnAction(e -> btncode2(e));
        btnSubtraction.setOnAction(e -> btncode2(e));
        btnMultiply.setOnAction(e -> btncode2(e));
        btnDivide.setOnAction(e -> btncode2(e));
        btnEqual.setOnAction(e-> btncode3(e));
        btnClear.setOnAction(e -> btncode4(e));
        btnDecimal.setOnAction(e-> btncode1(e));
        bNeg.setOnAction(e-> btncode2(e)); 
        b1.setOnAction(e-> btncode1(e)); 
        b2.setOnAction(e-> btncode1(e));
        b3.setOnAction(e-> btncode1(e));
        b4.setOnAction(e-> btncode1(e));
        b5.setOnAction(e-> btncode1(e));
        b6.setOnAction(e-> btncode1(e));
        b7.setOnAction(e-> btncode1(e));
        b8.setOnAction(e-> btncode1(e));
        b9.setOnAction(e-> btncode1(e));
        b0.setOnAction(e-> btncode1(e));
    }
 
    public void btncode1(ActionEvent e) {//getting numbers from buttons
        String s; 
        s = ((Button)e.getSource()).getText();
        enteredNums += s; 
        lblnums.setText(enteredNums); 
        lblo.setText("");
    }

    public void btncode2(ActionEvent e)//operator buttons
    {
        String t = ((Button)e.getSource()).getText();
        if(t.equals("+/") && enteredNums.equals(""))
            {
                num1 = num1*(-1);
            }
        if(enteredNums.equals(""))
            {
                num1 = 0; 
            }
        else if(enteredNums.equals("."))
            {
                num1 = 0;
            }
        else
            {
                Double convertedNums = Double.parseDouble(enteredNums);   
                num1 = num1 + convertedNums;
            }  
        operation = t;//save operation
        lblo.setText(t);//show operation
        enteredNums = "";//clearing entered numbers
        lblAnswer.setText(String.valueOf(num1));//showing num1 
    }

    public void btncode3(ActionEvent e)//equals button
    {
       if(enteredNums.equals("") )
            {
                num1 = 0;
            }
       else if(enteredNums.equals("."))
            {
                num1 = 0;
            }
       else if(enteredNums.equals("/"))
            {
                num1 = 0; 
            }
       else
            {
                Double convertedNums = Double.parseDouble(enteredNums);//".=" error
                num2 = convertedNums;
            }
       
       if (operation.equals("+"))
            {
                num1 = num1 + num2;
            }
       else if (operation.equals("-"))
       {
            if(enteredNums.equals(""))
                {
                    num1 = num1*-1;
                }
                
                num1 = num1 - num2;
       }   
       else if (operation.equals("*"))
            {
                num1 = num1 * num2;
            }
       else if (operation.equals("/"))
            {
                num1 = num1 / num2;
            }
       else if (operation.equals(""))
            {
                num1 = Double.parseDouble(enteredNums); 
                lblAnswer.setText(String.valueOf(num1)); 
            }
      
       double inf = Double.POSITIVE_INFINITY;//anything divided by 0 = Error
       if (num1 == inf)
            {
                lblAnswer.setText("Error"); 
                return;
            }
       
       lblAnswer.setText(String.valueOf(num1));
       
       if(BigDecimal.valueOf(num1).scale() > 4)//rounding long decimals
            {
                lblAnswer.setText(String.format("%.4g%n", num1));
            }
      
       lblnums.setText("");
       lblo.setText("");
    }
    
    public void btncode4(ActionEvent e)//cear button
    {
        lblnums.setText("");
        lblo.setText("");
        lblAnswer.setText("");
        operation = ""; 
        num1 = 0;
        num2 = 0; 
        enteredNums = ""; 
    }

    public static void main(String[] args) {
        launch(args);
    }
}