package fr.example.imt_atlantique.myfirstapplication;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class User implements Parcelable {

    private String firstName;
    private String lastName;
    private String city;
    private String birthdate;
    private List<String> phoneNumbers;

    private User(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        city = in.readString();
        birthdate = in.readString();

        phoneNumbers = new ArrayList<String>();
        in.readList(phoneNumbers, null); // alternative ClassLoader: String.class.getClassLoader()
    }

    public User(String firstName, String lastName, String city, String birthdate, List<String> phoneNumbers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.birthdate = birthdate;
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(city);
        dest.writeString(birthdate);
        dest.writeList(phoneNumbers);
        Log.i("user", "06-"+phoneNumbers.get(0));
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

}
