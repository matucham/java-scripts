package lab1.ex2;

public class Main {
    public static void main(String[] args) {
        EmergencyRoom emergencyRoom = new EmergencyRoom();
        Patient patient1 = new Patient("Mike", 1, System.currentTimeMillis());
        Patient patient2 = new Patient("Jesse", 2, System.currentTimeMillis());
        Patient patient3 = new Patient("Saul", 1, System.currentTimeMillis());
        Patient patient4 = new Patient("Walter", 4, System.currentTimeMillis());
        Patient patient5 = new Patient("Skyler", 3, System.currentTimeMillis());
        Patient patient6 = new Patient("Greta", 3, System.currentTimeMillis());
        Patient patient7 = new Patient("Summer", 4, System.currentTimeMillis());

        emergencyRoom.addPatient(patient1);
        emergencyRoom.addPatient(patient2);
        emergencyRoom.addPatient(patient3);
        emergencyRoom.addPatient(patient4);
        emergencyRoom.addPatient(patient5);
        emergencyRoom.addPatient(patient6);
        emergencyRoom.addPatient(patient7);

        System.out.println(emergencyRoom);

        Patient patient8 = new Patient("Jacob", 1, System.currentTimeMillis());
        emergencyRoom.addPatient(patient8);
        Patient nextPatient = emergencyRoom.getNextPatient();
        System.out.println("Next patient: " + nextPatient.getName());

        System.out.println(emergencyRoom);
    }
}