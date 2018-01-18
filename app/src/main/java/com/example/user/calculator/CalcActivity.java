package com.example.user.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CalcActivity extends AppCompatActivity {

    TextView resultText;

    public enum Operation {
        ADD, SUBTRACT, DIVIDE, MULTIPLY, EQUAL
    }

    String runningNumber = "";
    String leftValueString = "";
    String rightValueString = "";
    Operation currentOperation;
    int result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        //Initialize and link buttons from UI to variables

        Button oneButton = (Button)findViewById(R.id.oneButton);
        Button twoButton = (Button)findViewById(R.id.twoButton);
        Button threeButton = (Button)findViewById(R.id.threeButton);
        Button fourButton = (Button)findViewById(R.id.fourButton);
        Button fiveButton = (Button)findViewById(R.id.fiveButton);
        Button sixButton = (Button)findViewById(R.id.sixButton);
        Button sevenButton = (Button)findViewById(R.id.sevenButton);
        Button eightButton = (Button)findViewById(R.id.eightButton);
        Button nineButton = (Button)findViewById(R.id.nineButton);
        Button zeroButton = (Button)findViewById(R.id.zeroButton);
        Button divideButton = (Button)findViewById(R.id.divideButton);
        Button multiplyButton = (Button)findViewById(R.id.multiplyButton);
        Button plusButton = (Button)findViewById(R.id.plusButton);
        Button minusButton = (Button)findViewById(R.id.minusButton);
        Button clearButton = (Button)findViewById(R.id.clearButton);

        ImageButton equalButton = (ImageButton)findViewById(R.id.equalButton);

        resultText = (TextView)findViewById(R.id.resultText);

        //Setting onClickListeners to Buttons

        resultText.setText(""); //Sets TextView to an empty string on start

        oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                numberPressed(1);
            }
        });

        twoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                numberPressed(2);
            }
        });

        threeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                numberPressed(3);
            }
        });

        fourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                numberPressed(4);
            }
        });

        fiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                numberPressed(5);
            }
        });

        sixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                numberPressed(6);
            }
        });

        sevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                numberPressed(7);
            }
        });

        eightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                numberPressed(8);
            }
        });

        nineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                numberPressed(9);
            }
        });

        zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                numberPressed(0);
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                processOperation(Operation.DIVIDE);
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                processOperation(Operation.MULTIPLY);
            }
        });

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                processOperation(Operation.ADD);
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                processOperation(Operation.SUBTRACT);
            }
        });

        //Clear button resets all values/strings to null & the result textView to 0
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                leftValueString = "";
                rightValueString = "";
                runningNumber = "";
                result = 0;
                currentOperation = null;
                resultText.setText("");
            }
        });

        equalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                processOperation(Operation.EQUAL);
            }
        });
    }

    void processOperation(Operation operation){
        //Checks to see if there is a current Operation
        if (currentOperation != null){
            //If the runningNumber is null, then it is the first calculation
            if (runningNumber != ""){
                rightValueString = runningNumber;
                runningNumber = "";
    
                //Based on the current operation, the switch statement will complete the math required
                switch (currentOperation) {
                    case ADD:
                        result = Integer.parseInt(leftValueString) + Integer.parseInt(rightValueString);
                        break;
                    case SUBTRACT:
                        result = Integer.parseInt(leftValueString) - Integer.parseInt(rightValueString);
                        break;
                    case MULTIPLY:
                        result = Integer.parseInt(leftValueString) * Integer.parseInt(rightValueString);
                        break;
                    case DIVIDE:
                        result = Integer.parseInt(leftValueString) / Integer.parseInt(rightValueString);
                        break;
                }

                leftValueString = String.valueOf(result);
                resultText.setText(leftValueString);
            }
        } else {
            //First calculation, therefore the program sets the leftValueString to the value stored in runningNumber
            leftValueString = runningNumber;
            runningNumber = "";
        }

        currentOperation = operation;
    }

    //Number pressed function adds the values pressed on the UI to the textView result
    void numberPressed(int number){
        runningNumber += String.valueOf(number);
        resultText.setText(runningNumber);
    }
}
