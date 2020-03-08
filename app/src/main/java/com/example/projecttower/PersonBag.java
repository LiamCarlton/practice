package com.example.projecttower;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PersonBag
{
    private Person[] Persons = new Person[0];



    public void delete(Person person){
        ArrayList<Person> arraylist = new ArrayList<Person>();
        for(Person p: Persons){
            arraylist.add(p);
        }
        if(arraylist.contains(person)){
            arraylist.remove(person);
            Persons = arraylist.toArray(new Person[arraylist.size()]);
            System.out.println("Removed: \t" +  person.getLastName() + " " + person.getId());
        }
        else{
            System.out.println("Person not in Personbag..");
        }


    }

    public void insert(Person person){
        Person[] temp = new Person[Persons.length + 1];
        for(int i = 0; i<Persons.length; i++){
            temp[i] = Persons[i];
        }
        temp[temp.length-1] = person;
        Persons = temp;
    }

    public void load(){
        ObjectInputStream OIS = null;
        System.out.println("Trying to load PersonBag.");
        try{
            try {
                OIS = new ObjectInputStream(new FileInputStream("PersonBag.dat"));
            } catch (IOException e) {
                System.out.println("Couldnt find PersonBag: " + e);
            }
            try {
                this.Persons= ((Person[])OIS.readObject());
            } catch (NullPointerException | ClassNotFoundException | IOException e) {
                System.out.println("Array couldn't be read from PersonBag: " + e);
            }
        }finally{
            System.out.println("PersonBag Successfully Loaded.");
            for(Person p: Persons){
                System.out.println("-" + p.getLastName() + " " + p.getId());
            }

        }

    }

    public void update(){
        //Update file that saves ArrayList of persons

        FileOutputStream FOS = null;
        ObjectOutputStream OOS = null;
        try {
            FOS = new FileOutputStream("PersonBag.dat");
        } catch (FileNotFoundException e) {
            // IF FILE ISNT FOUND
        }

        try {
            OOS = new ObjectOutputStream(FOS);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            OOS.writeObject(this.Persons);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            OOS.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("PersonBag successfully updated.");
    }

    public Person searchById(String id){
        for(Person p: Persons){
            if(p.getId().equals(id)){
                if(p instanceof Student){
                    return (Student) p;
                }
//                else{
//                    return (Faculty) p;
//                }
            }
        }
        return null;
    }

    public Person selectPerson(String id){
        for(Person p: Persons){
            if(p.getId().equals(id)){
                return p;
            }
        }
        System.out.println("selected person method failed");
        return null;

    }

    public void list(){
        System.out.println("Persons Loaded:");
        for(int i = 0; i<this.Persons.length; i++){
            System.out.println(Persons[i].getLastName() + Persons[i].getId());
        }
    }


    public Person[] getPersons() {
        return Persons;
    }





    private void sortStudentFile(String s){
        String[] student = s.split("/");
        String[] name = student[0].split(" ");
        String major = student[1];
        String[] address = student[2].split(",");
        Student Student = new Student(name[0],name[1]);
        Student.setMajor(major);

        //Student.setAddress(new Address(address[0],address[1],address[2],address[3],address[4]));

        //Demo.personbag.insert(Student);
        System.out.println("added: \t" + Student.getLastName()+Student.getId());
    }

}