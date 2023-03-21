package lab1.ex2;


import java.util.Objects;

class Patient implements Comparable<Patient> {
    private final String name;
    private int priority;
    private long arrivalTime;

    public Patient(String name, int priority, long arrivalTime) {
        this.name = name;
        this.priority = priority;
        this.arrivalTime = arrivalTime;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", priority=" + priority +
                ", arrivalTime=" + arrivalTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return priority == patient.priority && arrivalTime == patient.arrivalTime && name.equals(patient.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, priority, arrivalTime);
    }

    @Override
    public int compareTo(Patient o) {
        int priorityDiff = Integer.compare(priority, o.getPriority());
        if (priorityDiff == 0) {
            return Long.compare(arrivalTime, o.getArrivalTime());
        }
        return priorityDiff;
    }

}
