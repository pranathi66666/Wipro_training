import java.util.*;

class Patient {
    private int id;
    private String name;
    private int age;

    public Patient(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Patient[ID=" + id + ", Name=" + name + ", Age=" + age + "]";
    }
}

class Doctor {
    private int id;
    private String name;
    private String specialization;

    public Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public String toString() {
        return "Doctor[ID=" + id + ", Name=" + name + ", Specialization=" + specialization + "]";
    }
}

class Appointment {
    private Patient patient;
    private Doctor doctor;
    private String date;

    public Appointment(Patient patient, Doctor doctor, String date) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Appointment[Patient=" + patient.getName() + ", Doctor=" + doctor.getName() + ", Date=" + date + "]";
    }
}

public class HospitalManagementSystem {
    private List<Patient> patients = new ArrayList<>();
    private List<Doctor> doctors = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();

    public void addPatient(int id, String name, int age) {
        patients.add(new Patient(id, name, age));
    }

    public void addDoctor(int id, String name, String specialization) {
        doctors.add(new Doctor(id, name, specialization));
    }

    public void scheduleAppointment(int patientId, int doctorId, String date) {
        Patient patient = findPatientById(patientId);
        Doctor doctor = findDoctorById(doctorId);

        if (patient == null) {
            System.out.println("Error: Patient not found.");
            return;
        }

        if (doctor == null) {
            System.out.println("Error: Doctor not found.");
            return;
        }

        appointments.add(new Appointment(patient, doctor, date));
        System.out.println("Appointment scheduled successfully.");
    }

    public void displayPatients() {
        System.out.println("--- Patients List ---");
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    public void displayDoctors() {
        System.out.println("--- Doctors List ---");
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
    }

    public void displayAppointments() {
        System.out.println("--- Appointments List ---");
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }

    private Patient findPatientById(int id) {
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }

    private Doctor findDoctorById(int id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HospitalManagementSystem hms = new HospitalManagementSystem();

        hms.addPatient(1, "John Doe", 30);
        hms.addPatient(2, "Jane Smith", 25);

        hms.addDoctor(101, "Dr. Alice", "Cardiology");
        hms.addDoctor(102, "Dr. Bob", "Neurology");

        hms.displayPatients();
        hms.displayDoctors();

        hms.scheduleAppointment(1, 101, "2025-01-25");
        hms.scheduleAppointment(2, 102, "2025-01-26");
        hms.scheduleAppointment(3, 101, "2025-01-27"); // Invalid patient ID

        hms.displayAppointments();
    }
}
