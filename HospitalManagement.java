// ============================
// ABSTRACT BASE CLASS
// ============================
abstract class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    abstract void role();

    void displayDetails() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

// ============================
// SIMPLE INHERITANCE
// ============================
class Doctor extends Person {
    String specialty;

    Doctor(String name, int age, String specialty) {
        super(name, age);
        this.specialty = specialty;
    }

    @Override
    void role() {
        System.out.println(name + " is a doctor specialized in " + specialty + ".");
    }

    void treatPatient() {
        System.out.println(name + " is treating patients.");
    }
}

// ============================
// MULTILEVEL INHERITANCE
// ============================
class Surgeon extends Doctor {
    Surgeon(String name, int age, String specialty) {
        super(name, age, specialty);
    }

    void performSurgery() {
        System.out.println(name + " is performing surgery.");
    }

    @Override
    void treatPatient() {
        super.treatPatient();
        System.out.println(name + " also performs surgical treatment.");
    }
}

// ============================
// HIERARCHICAL INHERITANCE
// ============================
class Nurse extends Person {
    Nurse(String name, int age) {
        super(name, age);
    }

    @Override
    void role() {
        System.out.println(name + " is a nurse.");
    }

    void assistDoctor() {
        System.out.println(name + " is assisting a doctor.");
    }
}

class Patient extends Person {
    String disease;

    Patient(String name, int age, String disease) {
        super(name, age);
        this.disease = disease;
    }

    @Override
    void role() {
        System.out.println(name + " is a patient suffering from " + disease + ".");
    }
}

// ============================
// MULTIPLE INHERITANCE (via Interfaces)
// ============================
interface Researcher {
    void research();
}

interface Teacher {
    void teach();
}

class AcademicSurgeon extends Surgeon implements Researcher, Teacher {
    AcademicSurgeon(String name, int age, String specialty) {
        super(name, age, specialty);
    }

    @Override
    public void research() {
        System.out.println(name + " is researching new surgical techniques.");
    }

    @Override
    public void teach() {
        System.out.println(name + " is teaching medical students.");
    }
}

// ============================
// HYBRID INHERITANCE
// ============================
class Student extends Person {
    Student(String name, int age) {
        super(name, age);
    }

    void study() {
        System.out.println(name + " is studying medicine.");
    }

    @Override
    void role() {
        System.out.println(name + " is a medical student.");
    }
}

interface Worker {
    void work();
}

class Intern extends Student implements Worker {
    Intern(String name, int age) {
        super(name, age);
    }

    @Override
    public void work() {
        System.out.println(name + " is working as an intern in the hospital.");
    }

    @Override
    void role() {
        System.out.println(name + " is both a student and an intern.");
    }
}

// ============================
// FINAL CLASS
// ============================
final class HospitalPolicy {
    void displayPolicy() {
        System.out.println("Hospital Policy: Maintain hygiene and patient confidentiality.");
    }
}

// ============================
// MAIN APPLICATION
// ============================
public class HospitalManagement {
    public static void main(String[] args) {
        System.out.println("===== SIMPLE INHERITANCE =====");
        Doctor doc = new Doctor("Dr. Smith", 45, "Cardiology");
        doc.displayDetails();
        doc.role();
        doc.treatPatient();

        System.out.println("\n===== MULTILEVEL INHERITANCE =====");
        Surgeon surg = new Surgeon("Dr. Brown", 50, "Neurosurgery");
        surg.displayDetails();
        surg.role();
        surg.treatPatient();
        surg.performSurgery();

        System.out.println("\n===== HIERARCHICAL INHERITANCE =====");
        Nurse nurse = new Nurse("Alice", 30);
        Patient patient = new Patient("John Doe", 40, "Flu");
        nurse.displayDetails();
        nurse.role();
        nurse.assistDoctor();
        patient.displayDetails();
        patient.role();

        System.out.println("\n===== MULTIPLE INHERITANCE (via Interfaces) =====");
        AcademicSurgeon acadSurg = new AcademicSurgeon("Dr. Green", 55, "Orthopedics");
        acadSurg.displayDetails();
        acadSurg.role();
        acadSurg.treatPatient();
        acadSurg.performSurgery();
        acadSurg.research();
        acadSurg.teach();

        System.out.println("\n===== HYBRID INHERITANCE =====");
        Intern intern = new Intern("Emily", 24);
        intern.displayDetails();
        intern.role();
        intern.study();
        intern.work();

        System.out.println("\n===== FINAL CLASS =====");
        HospitalPolicy policy = new HospitalPolicy();
        policy.displayPolicy();
    }
}
