package edu.neu.madcourse.bundleandparcel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * The SenderActivity class is responsible for sending Person data to other activities using either
 * Bundle or Parcelable.
 */
public class SenderActivity extends AppCompatActivity {

    /**
     * This method is called when the activity is first created. It sets the layout of the activity
     * and initializes the Person object.
     *
     * @param savedInstanceState the saved instance state of the activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender);

        // Initialize the Person object, try changing these values as per your choice
        Person person = new Person("John Doe", 18);

        // Set the text of the personInfo TextView to display the name and age of the Person object
        TextView personInfo = findViewById(R.id.personInfo);
        personInfo.setText("Person Info:\nName=" + person.getName() + ", Age=" + person.getAge());

        // Set up the button to send the Person data using Bundle
        Button sendUsingBundle = findViewById(R.id.sendUsingBundle);
        sendUsingBundle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SenderActivity.this, ReceiverActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("PersonName", person.getName());
                bundle.putInt("PersonAge", person.getAge());
                // Here, you can see we are passing the data not in the form of Person Object but
                // in built data types like String, and Integer. This is one of the shortcomings of
                // Using bundles.
                intent.putExtra("PersonBundle", bundle);
                SenderActivity.this.startActivity(intent);
            }
        });

        // Set up the button to send the Person data using Parcelable
        Button sendUsingParcel = findViewById(R.id.sendUsingParcel);
        sendUsingParcel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SenderActivity.this, ReceiverActivity.class);
                // Here, we are passing the data of the person object as the object itself. This is
                // because our person Object implements the Parcelable Interface. You can only pass
                // custom objects if your object implements the Parcelable interface.
                intent.putExtra("PersonParcel", person);
                SenderActivity.this.startActivity(intent);
            }
        });

    }
}