package net.attwoodthomas.rgbtohex;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends ActionBarActivity {

    // Declare Maps
    protected Map<String, Integer> lettersToNumbers = new HashMap<String, Integer>();
    protected Map<Integer, String> numbersToLetters = new HashMap<Integer, String>();

    // Declare Widgets
    protected EditText redInput;
    protected EditText greenInput;
    protected EditText blueInput;
    protected EditText hexInput;
    protected Button convertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // lettersToNumbers Setup
        lettersToNumbers.put("0", 0);
        lettersToNumbers.put("1", 1);
        lettersToNumbers.put("2", 2);
        lettersToNumbers.put("3", 3);
        lettersToNumbers.put("4", 4);
        lettersToNumbers.put("5", 5);
        lettersToNumbers.put("6", 6);
        lettersToNumbers.put("7", 7);
        lettersToNumbers.put("8", 8);
        lettersToNumbers.put("9", 9);
        lettersToNumbers.put("A", 10);
        lettersToNumbers.put("B", 11);
        lettersToNumbers.put("C", 12);
        lettersToNumbers.put("D", 13);
        lettersToNumbers.put("E", 14);
        lettersToNumbers.put("F", 15);

        // numbersToLetters Setup
        numbersToLetters.put(0, "0");
        numbersToLetters.put(1, "1");
        numbersToLetters.put(2, "2");
        numbersToLetters.put(3, "3");
        numbersToLetters.put(4, "4");
        numbersToLetters.put(5, "5");
        numbersToLetters.put(6, "6");
        numbersToLetters.put(7, "7");
        numbersToLetters.put(8, "8");
        numbersToLetters.put(9, "9");
        numbersToLetters.put(10, "A");
        numbersToLetters.put(11, "B");
        numbersToLetters.put(12, "C");
        numbersToLetters.put(13, "D");
        numbersToLetters.put(14, "E");
        numbersToLetters.put(15, "F");

        // Widget Setup
        redInput = (EditText) findViewById(R.id.redInput);
        greenInput = (EditText) findViewById(R.id.greenInput);
        blueInput = (EditText) findViewById(R.id.blueInput);
        hexInput = (EditText) findViewById(R.id.hexInput);
        convertButton = (Button) findViewById(R.id.convertButton);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Integer red = Integer.parseInt(redInput.getText().toString());
                Integer green = Integer.parseInt(greenInput.getText().toString());
                Integer blue = Integer.parseInt(blueInput.getText().toString());
                String redHex = fromDenary(red, 16);
                String greenHex = fromDenary(green, 16);
                String blueHex = fromDenary(blue, 16);

                hexInput.setText("#" + redHex + greenHex + blueHex);

            }
        });

    }

    private String fromDenary (Integer number, Integer base) {
        Integer div = -1;
        Integer remainder = 0; // Remainder variable
        List<String> remainders = new ArrayList<String>();

        String baseString = "";
        String newRemainder = "";

        while (div != 0) {
            div = number / base;
            remainder = number % base;
            newRemainder = numbersToLetters.get(remainder);
            remainders.add(newRemainder);
            number = div;
         }

        for (String item: remainders) {
            baseString = item + baseString;
        }

        return baseString;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
