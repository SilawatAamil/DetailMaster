package com.example.unitygames.detailmaster;

import android.os.Parcel;
import android.os.Parcelable;

public class Player implements Parcelable {

    private String name;
    private String pos;
    private int img;

    protected Player() {
        super();
    }
    public Player(Parcel parcel){
        this.name=parcel.readString();
        this.pos=parcel.readString();
        this.img=parcel.readInt();
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.pos);
        parcel.writeInt(this.img);
    }
}

