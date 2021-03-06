package com.example.vuquyenlinh185106014860th5;
//ke thua lai interface parcel de nap du lieu cho ArrayList
import android.os.Parcel;
import android.os.Parcelable;

public class account implements Parcelable {
    // 2 thuoc tinh cua lop account
    String username,password;
    // cac constructor cua lop account
    public account(){}
    public  account(Parcel in){
        super();
        readFromParcel(in);
    }
    public void readFromParcel(Parcel in){
        username = in.readString();
        password = in.readString();
    }
    public static final Parcelable.Creator<account> CREATOR = new Parcelable.Creator<account>() {
        public account createFromParcel(Parcel in) {
            return new account(in);
        }

        public account[] newArray(int size) {

            return new account[size];
        }

    };

    public account(String u, String p){this.username = u;this.password=p;}
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String setUsername(String us){
        return this.username = us;
    }
    public String setPassword(String pa){
        return this.password = pa;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(password);
    }
}
