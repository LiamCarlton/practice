package com.example.projecttower;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

public class idCreate implements Serializable {

    private int idCounter;

    public idCreate(){

    }
    public String createID(){

        try {
            getIDs();
        } catch (NullPointerException e) {
            System.out.println("idFactory: Creating New ID File");
        }
        idCounter++;
        saveFile();

        return String.format("%03d", idCounter);
    }

    public void getIDs(){
        FileInputStream FIS = null;
        try {
            FIS = new FileInputStream("id.dat");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DataInputStream OIS = new DataInputStream(FIS);
        try {
            idCounter = OIS.readInt();
        } catch (IOException e) {
            System.out.println("idFactory: Number wasn't read");
        }
    }


    public void saveFile(){
        FileOutputStream FOS = null;
        try {
            FOS = new FileOutputStream("id.dat");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DataOutputStream OOS = new DataOutputStream(FOS);
        try {
            OOS.writeInt(idCounter);
        } catch (IOException e) {
            System.out.println("idFactory: Number wasn't written");
        }

    }

}