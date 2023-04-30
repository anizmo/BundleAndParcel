package edu.neu.madcourse.bundleandparcel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * An activity for receiving data from {@link SenderActivity} using Bundle or Parcel.
 */
public class ReceiverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);

        // Set up listener for "receiveUsingBundle" button
        Button receiveUsingBundle = findViewById(R.id.receiveUsingBundle);
        receiveUsingBundle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = getIntent().getBundleExtra("PersonBundle");
                if (bundle != null) {
                    String personName = bundle.getString("PersonName");
                    int personAge = bundle.getInt("PersonAge");
                    Person person = new Person(personName, personAge);
                    Toast.makeText(ReceiverActivity.this,
                            "Received Data using Bundle\nPerson: Name = "
                                    + person.getName() + ", Age = "
                                    + person.getAge(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ReceiverActivity.this,
                            "Did not find any Bundle, try receiving using Parcel",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set up listener for "receiveUsingParcel" button
        Button receiveUsingParcel = findViewById(R.id.receiveUsingParcel);
        receiveUsingParcel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Person person = getIntent().getParcelableExtra("PersonParcel");
                if (person != null) {
                    Toast.makeText(ReceiverActivity.this,
                            "Received Data using Parcel\nPerson: Name = "
                                    + person.getName() + ", Age = "
                                    + person.getAge(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ReceiverActivity.this,
                            "Did not find any Parcel, try receiving using Bundle",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}