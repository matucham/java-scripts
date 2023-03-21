package lab1.ex2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmergencyRoomTest {

    @Test
    void testAddPatient() {
        EmergencyRoom er = new EmergencyRoom();

        Patient p1 = new Patient("Joe", 2, System.currentTimeMillis());
        Patient p2 = new Patient("Sarah", 1, System.currentTimeMillis());
        Patient p3 = new Patient("Bob", 3, System.currentTimeMillis());

        er.addPatient(p1);
        er.addPatient(p2);
        er.addPatient(p3);

        assertEquals(p2, er.getNextPatient());
        assertEquals(p1, er.getNextPatient());
        assertEquals(p3, er.getNextPatient());
    }

    @Test
    void testGetNextPatient() {
        EmergencyRoom er = new EmergencyRoom();
        assertNull(er.getNextPatient());
    }

    @Test
    void testToString() {
        EmergencyRoom er = new EmergencyRoom();

        Patient p1 = new Patient("Joe", 2, System.currentTimeMillis());
        Patient p2 = new Patient("Sarah", 1, System.currentTimeMillis());
        Patient p3 = new Patient("Bob", 3, System.currentTimeMillis());

        er.addPatient(p1);
        er.addPatient(p2);
        er.addPatient(p3);

        String expected = "EmergencyRoom{ \n" +
                "Patient{name='Sarah', priority=1, arrivalTime=" + p2.getArrivalTime() + "}\n" +
                "Patient{name='Joe', priority=2, arrivalTime=" + p1.getArrivalTime() + "}\n" +
                "Patient{name='Bob', priority=3, arrivalTime=" + p3.getArrivalTime() + "}\n" +
                "}";

        assertEquals(expected, er.toString());
    }
}
