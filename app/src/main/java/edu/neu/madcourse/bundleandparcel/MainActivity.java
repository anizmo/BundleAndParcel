package edu.neu.madcourse.bundleandparcel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * This class represents the main activity of the application.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * The current count of the number displayed on the screen.
     */
    private int counter = 0;

    /**
     * The TextView that displays the current count of the number.
     */
    private TextView numberCount;

    /**
     * The key used to save and retrieve the counter value in the saved instance state bundle.
     */
    private final String INCREMENT_BUTTON_KEY = "INCREMENT_BUTTON_KEY";

    /**
     * Called when the activity is starting.
     *
     * @param savedInstanceState a Bundle containing the data that was saved during the previous instance of the activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberCount = findViewById(R.id.numberCount);
        Button incrementButton = findViewById(R.id.incrementButton);

        incrementButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Called when the increment button is clicked.
             *
             * @param view the view that was clicked
             */
            @Override
            public void onClick(View view) {
                counter++;
                numberCount.setText(String.valueOf(counter));
            }
        });
    }

    /**
     * Called to restore the saved instance state of the activity.
     *
     * @param savedInstanceState a Bundle containing the data that was saved during the previous instance of the activity.
     */
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        counter = savedInstanceState.getInt(INCREMENT_BUTTON_KEY);
        numberCount.setText(String.valueOf(counter));
    }

    /**
     * Called to save the current state of the activity.
     *
     * @param outState a Bundle in which to place the saved data.
     */
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(INCREMENT_BUTTON_KEY, counter);
    }
}