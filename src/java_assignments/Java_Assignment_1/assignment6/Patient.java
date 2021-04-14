//package java_assignments.assignment6;
import java.util.*;
class Patient {
    String name,id;
    Date admission_Date;
    String address;
    String doctor_name;
    int age;
    ArrayList<Observation> observations= new ArrayList<>(1);
    Patient(int i,String dr_name,String n,int a,String addr)
    {
        name =new String(n);
        doctor_name=new String(dr_name);
        address = new String(addr);
        admission_Date=new Date();
        age=a;
        int y = (admission_Date.getYear() + 1900) % 100;
        String sr = String.format("%03d", i);
        id = new String(doctor_name + sr);
        System.out.println("Patient ID->"+id);
    }
    public String toString()
    {
        return "Patient details->\n"+"Name->"+name+"\nID->"+id+"\naddmission date->"+admission_Date+"\nAddress->"+address+"\nAssigned to doctor->"+doctor_name;
    }
    void observe_patient(int bp,int temp)
    {
        Observation ob=new Observation(bp,temp);
        observations.add(ob);
    }
}
class Observation{
    int bloodpressure, temperature;
    Date check_up_date;
    Observation(int bp,int temp)
    {
        bloodpressure = bp;
        temperature = temp;
        check_up_date = new Date();
    }
}