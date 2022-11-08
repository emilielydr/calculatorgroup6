package com.example.mycalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;

import javax.script.ScriptException;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2, btn_clear, btn_plus, btn_equal;
    Button btn3, btn4,btn5, btn6;
    Button btn7, btn8, btn9, btnMinus;
    Button btn0, btnMulti;
    Button btnDiv;
    Button btn_dot;

    TextView text_display;

    // This is to evaluate the math expression
    //ScriptEngine engine;

    //Reference to Evaluate class
    Evaluate evaluate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //engine = new ScriptEngineManager().getEngineByName("rhino");

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_equal = (Button) findViewById(R.id.btn_equal);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        text_display = (TextView) findViewById(R.id.textview_input_display);

        //buttons 3456
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);

         //buttons 789-
        btn7 = (Button) findViewById(R.id.button9);
        btn8 = (Button) findViewById(R.id.button10);
        btn9 = (Button) findViewById(R.id.button11);
        btnMinus = (Button) findViewById(R.id.btn_minus);

        btn0 = (Button) findViewById(R.id.btn0);
        btnMulti = (Button) findViewById(R.id.btnMulti);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btn_dot = (Button) findViewById(R.id.btn_dot);

        setClickListeners();
    }

    private void setClickListeners() {
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btnMulti.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btn_dot.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn0:
                addNumber("0");
                break;
            case R.id.btn1:
                addNumber("1");
                break;
            case R.id.btn2:
                addNumber("2");
                break;
            case R.id.btn3:
                addNumber("3");
                break;
            case R.id.btn4:
                addNumber("4");
                break;
            case R.id.btn5:
                addNumber("5");
                break;
            case R.id.btn6:
                addNumber("6");
                break;
            case R.id.button9:
                addNumber("7");
                break;
            case R.id.button10:
                addNumber("8");
                break;
            case R.id.button11:
                addNumber("9");
                break;
            case R.id.btn_minus:
                addNumber(" - ");
                break;
            case R.id.btn_plus:
                addNumber(" + ");
                break;
            case R.id.btnDiv:
                addNumber("/");
                break;
            case R.id.btnMulti:
                addNumber(" * ");
                break;
            case R.id.btn_equal:
                String result = null;
                try {
                    result = evaluate(text_display.getText().toString());
                    text_display.setText(result);
                } catch (ScriptException e) {
                    text_display.setText("Error");
                }
                break;
            case R.id.btn_clear:
                clear_display();
                break;
            case R.id.btn_dot:
                addNumber(".");
                break;
        }
    }

    private String evaluate(String expression) throws ScriptException {
       // String result = engine.eval(expression).toString();
        //Round up decimal
        //BigDecimal decimal = new BigDecimal(result);

        BigDecimal decimal = evaluate.evaluate(expression);
        return decimal.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
    }



    private void addNumber(String number) {
        text_display.setText(text_display.getText() + number);
    }

    private void clear_display() {
        text_display.setText("");
    }
}