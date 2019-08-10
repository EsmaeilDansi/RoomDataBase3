package com.example.mypc.roobdatabase;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "information")
public class Information
{
    @PrimaryKey(autoGenerate = true)
    private  int id;

    @ColumnInfo(name="name")
    private String name;

    @ColumnInfo(name="last_nmae")
     private String last_name;

     @ColumnInfo(name="phonenumber")
     private String phonenumber;

    public Information(String name, String last_name, String phonenumber) {
        this.name = name;
        this.last_name = last_name;
        this.phonenumber = phonenumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}


