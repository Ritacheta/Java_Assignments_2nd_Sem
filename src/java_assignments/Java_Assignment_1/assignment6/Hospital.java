//package java_assignments.assignment6;
import java.util.*;
public class Hospital {
    ArrayList<Doctor> doctor_list=new ArrayList<>(1);
    String Name;
    static int last_id=0;
    Hospital(String n)
    {
        Name=new String(n);
    }
    private int is_doctor_present(String id)
    {
        for(int i=0;i<last_id;i++)
        {
            if(doctor_list.get(i).doctor_ID.equals(id))
            {
                return i;
            }
        }
        return -1;
    }
    void add_doctor(Scanner s)
    {
        System.out.println("Enter details of the doctor\n");
        System.out.println("Name->");
        String name=s.nextLine();
        last_id+=1;
        Doctor d=new Doctor(name,last_id);
        doctor_list.add(d);
    }
    void admit_patient(Scanner s)
    {
        if(doctor_list.size()!=0)
        {
            System.out.println("enter doctor id to assign->");
            String doc_id=s.nextLine();
            int i=is_doctor_present(doc_id);
            if(i!=-1)
            {
                System.out.println("Enter patients details->\n");
                doctor_list.get(0).add_patient(s);
                return;
            }
            System.out.println("Doctor not found");
        }
        else
        {
            System.out.println("No doctor to assign");
        }
    }
    void observe(Scanner s, String id)
    { 
        for(int i=0;i<last_id;i++)
        {
            int j= doctor_list.get(i).is_patient_present(id);
            if(j!=-1)
            {
                doctor_list.get(i).Observe_patient(s, id);
                return;
            }
        }
        System.out.println("Patient not present");
    }
    void discharge_patient(Scanner s,String patient_id)
    {
        for (int i = 0; i < last_id; i++) {
            int j = doctor_list.get(i).is_patient_present(patient_id);
            if (j != -1) {
                doctor_list.get(i).discharge_patient(patient_id);
                return;
            }
        }
        System.out.println("Patient not found");
    }
    void display_patient_by_id(String id)
    {
        for (int i = 0; i < last_id; i++) {
            int j = doctor_list.get(i).is_patient_present(id);
            if (j != -1) {
                doctor_list.get(i).Search_patient(id);
                return;
            }
        }
        System.out.println("Patient not found");
    }
    void display_patient_under_dr(String doctor_id)
    {
        int i=is_doctor_present(doctor_id);
        if(i!=-1)
        {
            doctor_list.get(i).show_patients();
        }
    }
    void display_doctors(){
        if(doctor_list.size()!=0)
        {
            for(int i=0;i<doctor_list.size();i++)
            {
                doctor_list.get(i).showData();
            }
        }
        else
        {
            System.out.println("No doctor to show");
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter hospital name->");
        String hospital_name=sc.nextLine();
        Hospital h=new Hospital(hospital_name);
        int ch = 0;
        System.out.println("Welcome to "+hospital_name+" Hospital Management System");
        while(true)
        {
            System.out.print(
                    "\n\t1. Register Patient\n\t2. Register Doctor\n\t3. Remove Patient\n\t4. Observe a Patient\n\t5. Display Patient By Id\n\t6. Display All Doctors\n\t7. Display Patient's Under a Doctor\n\t8. exit\n\tEnter Choice :-");
            ch = sc.nextInt();
            sc.nextLine();
            switch (ch) {
            case 1:
            h.admit_patient(sc);
            break;
            case 2:
            h.add_doctor(sc);
            break;
            case 3:
            String pid;
            System.out.print("Enter the patient's Id :- ");
            pid = sc.nextLine();
            h.discharge_patient(sc, pid);
            break;
            case 4:
            String pid1 = new String();
            System.out.print("Enter the patient's Id :- ");
            pid1 = sc.next();
            h.observe(sc,pid1);
            break;
            case 5:
            String pid2 = new String();
            System.out.print("Enter the patient's Id :- ");
            pid2 = sc.next();
            h.display_patient_by_id(pid2);
            break;
            case 6:
            h.display_doctors();
            break;
            case 7:
            String docId = new String();
            System.out.print("Enter the doctor's Id :- ");
            docId = sc.next();
            h.display_patient_under_dr(docId);
            break;
            default:
            System.exit(0);
            }
        }
        //sc.close();
    }
}
