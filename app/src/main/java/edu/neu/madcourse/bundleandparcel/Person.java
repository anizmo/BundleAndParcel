package edu.neu.madcourse.bundleandparcel;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

/**
 * A class representing a Person with a name and an age.
 * Implements Parcelable to enable passing instances between activities.
 */
public class Person implements Parcelable {

    /**
     * The name of the Person.
     */
    private final String name;

    /**
     * The age of the Person.
     */
    private final int age;

    /**
     * Constructs a Person object with the given name and age.
     *
     * @param name The name of the Person.
     * @param age The age of the Person.
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Constructor used for creating a Person object from a Parcel.
     *
     * @param in The Parcel containing the Person object.
     */
    protected Person(Parcel in) {
        name = in.readString();
        age = in.readInt();
    }

    /**
     * A Creator object that is used to create a Person object from a Parcel.
     */
    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    /**
     * Returns the name of the Person.
     *
     * @return The name of the Person.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the age of the Person.
     *
     * @return The age of the Person.
     */
    public int getAge() {
        return age;
    }

    /**
     * Parcelable method - not used in this implementation.
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Writes the data of the Person object into a Parcel.
     *
     * @param parcel The Parcel to write the data to.
     * @param i An int representing any special flags.
     */
    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(age);
    }
}