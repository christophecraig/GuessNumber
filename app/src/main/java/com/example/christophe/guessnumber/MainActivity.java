package com.example.christophe.guessnumber;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    final int listeBouton[] = {
            R.id.button0,
            R.id.button1,
            R.id.button2,
            R.id.button3,
            R.id.button4,
            R.id.button5,
            R.id.button6,
            R.id.button7,
            R.id.button8,
            R.id.button9,
            R.id.result
    };
    int num = (int) Math.round(100 * Math.random());
    TextView display;
    TextView res;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.guess);
        display.setText("");
        res = findViewById(R.id.result);
        Log.d("LE FABULEUX NUM ---- ", String.valueOf(num));

        for (int b: listeBouton) {
            findViewById(b).setOnClickListener(this);
        }
    }

    public void onClick(View view) {
        Log.d(" TEST ", " DISPLAY : ----  " + display.getText());
        if ( view.getId() == R.id.result ) {
            display.setText("");
            res.setText("?");
        } else if (display.getText().length() < 2) {
            switch( view.getId() ) {
                case R.id.button0:
                    display.setText(display.getText() + "0");
                    break;
                case R.id.button1:
                    display.setText(display.getText()+"1");
                    break;
                case R.id.button2:
                    display.setText(display.getText()+"2");
                    break;
                case R.id.button3:
                    display.setText(display.getText()+"3");
                    break;
                case R.id.button4:
                    display.setText(display.getText()+"4");
                    break;
                case R.id.button5:
                    display.setText(display.getText()+"5");
                    break;
                case R.id.button6:
                    display.setText(display.getText()+"6");
                    break;
                case R.id.button7:
                    display.setText(display.getText()+"7");
                    break;
                case R.id.button8:
                    display.setText(display.getText()+"8");
                    break;
                case R.id.button9:
                    display.setText(display.getText()+"9");
                    break;
                default:
                    break;
            }
            res.setText(checkNumber((String) display.getText()));
        }
    }

    public String checkNumber (String number) {
        if (Integer.parseInt(number) < this.num) return "+";
        if (Integer.parseInt(number) > this.num) return "-";
        this.num = (int) Math.round(100 * Math.random());
        display.setText(" OUI FORMIDABLE EXCELLENT VOILA !!");
        return "=";
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
