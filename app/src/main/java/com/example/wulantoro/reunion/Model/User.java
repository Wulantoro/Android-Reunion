package com.example.wulantoro.reunion.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable
{

    private String id_user;
    private String name_user;
    private String email_user;
    private String pass_user;
    public final static Parcelable.Creator<User> CREATOR = new Creator<User>() {


        @SuppressWarnings({
                "unchecked"
        })
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return (new User[size]);
        }

    }
            ;

    protected User(Parcel in) {
        this.id_user = ((String) in.readValue((String.class.getClassLoader())));
        this.name_user = ((String) in.readValue((String.class.getClassLoader())));
        this.email_user = ((String) in.readValue((String.class.getClassLoader())));
        this.pass_user = ((String) in.readValue((String.class.getClassLoader())));
    }

    public User() {
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getName_user() {
        return name_user;
    }

    public void setName_user(String name_user) {
        this.name_user = name_user;
    }

    public String getEmail_user() {
        return email_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

    public String getPass_user() {
        return pass_user;
    }

    public void setPass_user(String pass_user) {
        this.pass_user = pass_user;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id_user);
        dest.writeValue(name_user);
        dest.writeValue(email_user);
        dest.writeValue(pass_user);
    }

    public int describeContents() {
        return 0;
    }

}
