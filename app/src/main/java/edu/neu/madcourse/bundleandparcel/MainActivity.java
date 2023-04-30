package edu.neu.madcourse.bundleandparcel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


/**
 * This activity displays two buttons to open different examples, the first one demonstrates how
 * bundles can be used to save state of an activity through rotation of device.
 * The second example, demonstrates how you can use Bundles and Parcels to transfer data from one
 * activity to the other.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set click listener for the first button to open BundleSaveStateActivity
        Button openStatePersistenceExample = findViewById(R.id.openStatePersistenceExample);
        openStatePersistenceExample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BundleSaveStateActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        // Set click listener for the second button to open SenderActivity
        Button openDataTransferExample = findViewById(R.id.openDataTransferExample);
        openDataTransferExample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SenderActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }

}