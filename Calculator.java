


package calculator;


//imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calculator implements ActionListener { //main method

    
    //arrays
    JFrame frame;                               // creating frame                                  
    JTextField textfield;                                                             
    JButton[] numberButtons = new JButton[10];     //10 number buttons #0-9
    JButton[] functionButtons = new JButton[9];           // buttons that will show us other function
    JButton addButton, subButton, mulButton, divButton;          //details of each button
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel; 
    
    Font myFont = new Font("Monospaced", Font.BOLD, 15);  // my font and size
    
    double num1=0, num2=0,result=0;  //double values
    char operator;                                       // char value to hold the equation's relation
    
    Calculator(){
        frame = new JFrame("Calculator");                                 //popup name
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     //close out of program
        frame.setSize(420, 550);   //size of popup
        frame.setLayout(null); 
        frame.setBackground(Color.PINK); // set color
        
        textfield = new JTextField();                       //      textbox      
        textfield.setBounds(50, 25, 300, 50);  //size
        textfield.setFont(myFont);          //same font
        textfield.setEditable(false); 
        
        addButton = new JButton("+");           // declaring what each function button will show
         subButton = new JButton("-");
          mulButton = new JButton("*");
           divButton = new JButton("/");
            decButton = new JButton(".");
             equButton = new JButton("=");
              delButton = new JButton("Delete");
               clrButton = new JButton("Clear");
             negButton = new JButton("(-)");
               
              
        functionButtons[0] = addButton;       // declaring what the function button will do 
         functionButtons[1] = subButton;
          functionButtons[2] = mulButton;
           functionButtons[3] = divButton;
            functionButtons[4] = decButton;
             functionButtons[5] = equButton;
              functionButtons[6] = delButton;
               functionButtons[7] = clrButton;
               functionButtons[8] = negButton;  
               
        for(int i =0;i<9;i++) {                           //for loop created for all function buttons                             
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
              
        }
        
         for(int i =0;i<10;i++) {                           //for loop created for all number buttons
        numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
           numberButtons[i].setFont(myFont);
          numberButtons[i].setFocusable(false);
        
         }
        
         negButton.setBounds(50,430,100,50);           //placement  for buttons
         delButton.setBounds(150, 430, 100, 50);
         clrButton.setBounds(250, 430, 100, 50);
         
         panel = new JPanel();                                                          //new panel for numbers
         panel.setBounds(50, 100, 300, 300);
         panel.setLayout(new GridLayout(4,4,10,10));              //grid layout
         panel.setBackground(Color.MAGENTA);                  //color 
         
         panel.add(numberButtons[1]);                    // adding numbers and functions on panel 
          panel.add(numberButtons[2]);
           panel.add(numberButtons[3]);
         panel.add(addButton);
          panel.add(numberButtons[4]);
          panel.add(numberButtons[5]);
           panel.add(numberButtons[6]);
         panel.add(subButton);
          panel.add(numberButtons[7]);
          panel.add(numberButtons[8]);
           panel.add(numberButtons[9]);
         panel.add(mulButton);
         panel.add(decButton);
          panel.add(numberButtons[0]);
           panel.add(equButton);
           panel.add(divButton);
           
          
          
          //list of functions on the frame 
         frame.add(panel);                                           
         frame.add(negButton);
         frame.add(delButton);
         frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        
         Calculator calc = new Calculator();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      //for loop created to make each button work (functionality)
        for(int i=0;i<10;i++)  {                                                                     
            if(e.getSource() == numberButtons[i] ) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
    if(e.getSource() == decButton) {
        textfield.setText(textfield.getText().concat("."));
    }
    
       
    if(e.getSource() == addButton) {
       num1 = Double.parseDouble(textfield.getText());
       operator ='+';
       textfield.setText(" ");
       
    }
    
      if(e.getSource() == subButton) {
       num1 = Double.parseDouble(textfield.getText());
       operator ='-';
       textfield.setText(" ");
       
    } 
       if(e.getSource() == mulButton) {
       num1 = Double.parseDouble(textfield.getText());
       operator ='*';
       textfield.setText(" ");
       
    }
       if(e.getSource() == divButton) {
       num1 = Double.parseDouble(textfield.getText());
       operator ='/';
       textfield.setText(" ");
       
    }
          if(e.getSource() == equButton) {
       num2 = Double.parseDouble(textfield.getText());
     
       
       //mathematical operation preformed
       
       switch(operator){
           case'+' :
               result=num1+num2;
               break; 
          case'-' :
               result=num1-num2;
               break;    
          case'*' :
               result=num1*num2;
               break;  
           case'/' :
               result=num1/num2;
               break;    
       }
       
       //declaring texfield 
       
       textfield.setText(String.valueOf(result));
       num1=result;
    }
          
          //clear button
      if(e.getSource() == clrButton) {
       
       textfield.setText(" ");
       
    } 
      
      //delete button 
   if(e.getSource() == delButton) {
       String string = textfield.getText();
       textfield.setText(" ");
       for(int i=0;i<string.length()-1;i++){
           textfield.setText(textfield.getText()+string.charAt(i));
       }
       
       //negative button 
      if(e.getSource() == negButton) {
      double temp = Double.parseDouble(textfield.getText());
      temp*=-1;
      textfield.setText(String.valueOf(temp));
       }
       
    }     
       
 //  {
  //      String digit = e.getActionCommand();
        //this is where we add to history
     //   history += digit;

     //   jtf.setText(display + digit );
       // display = jtf.getText();
      //  playSound("Click.wav");
//    }
       
       
       
       
       
    }
    
}
