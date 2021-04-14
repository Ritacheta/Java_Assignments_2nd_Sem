//package java_assignments.assignment6;
import java.util.*;
class Doctor {
    ArrayList<Patient> patient_list =new ArrayList<>(1);
    String doctor_name,doctor_ID;
    static int last_id=0;
    Doctor(String n,int id)
    {
        doctor_name=new String(n);
        String sr = String.format("%03d", id);
        doctor_ID = new String(n + sr);
        System.out.println(doctor_name+"'s ID->"+doctor_ID);
    }
    public void showData() {
        System.out.println("Doctor Name :- " + doctor_name);
        System.out.println("Doctor Id :- " + doctor_ID);
    }
    int is_patient_present(String iD)
    {
        for(int i=0;i<patient_list.size();i++)
        {
            if(patient_list.get(i).id.equals(iD))
            {
                return i;
            }
        }
        return -1;
    }
    
    public void Search_patient(String pid) {
        int i=is_patient_present(pid);
        if(i!=-1){
            System.out.println(patient_list.get(i));
        }
        System.out.println("Patient not present");
    }
    void add_patient(Scanner s)
    {
        System.out.println("Name->");
        String pname=s.nextLine();
        System.out.println("Address->");
        String address=s.nextLine();
        System.out.println("age->");
        int age=s.nextInt();
        int l=last_id+1;
        Patient p=new Patient(l,doctor_name,pname,age,address);
        if(patient_list.size()==0 && is_patient_present(p.id)==-1)
        {
            last_id += 1;
            patient_list.add(p);
            System.out.println("assigned to -> Dr. " + doctor_name + "\nDoctor Id->" + doctor_ID);
            return;
        }
        else if(is_patient_present(p.id)==-1)
        {
            System.out.println("Cant add!! already present\n");
            return;
        }
        last_id+=1;
        patient_list.add(p);
        System.out.println("assigned to -> Dr. "+doctor_name+"\nDoctor Id->"+doctor_ID);
    }
    void Observe_patient(Scanner s,String id)
    {
        int i = is_patient_present(id);
        if (i != -1) 
        {
            System.out.println("Enter blood pressure->");
            int bp = s.nextInt();
            System.out.println("Enter temperature->");
            int temp = s.nextInt();
            patient_list.get(i).observe_patient(bp, temp);
            return;
        }
        System.out.println("Patient not present");
    }
    void discharge_patient(String id)
    {
        if(is_patient_present(id)!=-1)
        {
            int i=is_patient_present(id);
            patient_list.get(i).id=null;
            System.out.println("Patient discharged.\n");
            return;
        }
        else
        {
            System.out.println("Patient not present");
        }
    }
    void show_patients()
    {
        if(patient_list.size()!=0)
        {
            for(int i=0;i<patient_list.size();i++)
            {
                System.out.println(patient_list.get(i));
            }
        }
        else
        {
            System.out.println("No patient to show");
        }
    }
}
