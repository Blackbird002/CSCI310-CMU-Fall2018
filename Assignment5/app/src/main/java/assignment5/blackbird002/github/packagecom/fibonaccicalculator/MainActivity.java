package assignment5.blackbird002.github.packagecom.fibonaccicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public EditText inputN;
    public int nterm;
    public String strInput;
    public TextView Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find and assign the edit text and text view boxes
        inputN = findViewById(R.id.txtInput);
        Result = findViewById(R.id.txtResult);
    }

    //The fibonacci nth term calculator
    int calculateFib(int term){
        if(term <= 1)
            return term;
        else
            return calculateFib(term - 1) + calculateFib(term - 2);
    }

    public void calculateFibTerm(View v){
        strInput = inputN.getText().toString().trim();
        nterm = Integer.parseInt(strInput);
        Toast.makeText(this, "Calculating!", Toast.LENGTH_LONG).show();
        int result = calculateFib(nterm);
        Result.setText(Integer.toString(result));
    }
}
