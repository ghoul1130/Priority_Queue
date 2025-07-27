import java.util.PriorityQueue;

class Patient implements Comparable<Patient> {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    public int compareTo(Patient other) {
        return Integer.compare(other.severity, this.severity);
    }

    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

class EmergencyRoom {

    private PriorityQueue<Patient> queue = new PriorityQueue<>();

    public void addPatient(String name, int severity) {
        long start = System.nanoTime();
        queue.add(new Patient(name, severity)); // O(log n)
        long end = System.nanoTime();
        System.out.println("Add Patient: "+ name +" - Time: " + (end - start) + " ns, Complexity: O(log n)");
        System.out.println();
    }

    public void treatNext() {
        long start = System.nanoTime();
        Patient p = queue.poll(); // O(log n)
        System.out.println("Treating: " + (p != null ? p : "None"));
        long end = System.nanoTime();
        System.out.println("Get Next Patient - Time: " + (end - start) + " ns, Complexity: O(log n)");
        System.out.println();
    }

    public void displayPatients() {
        long start = System.nanoTime();
        queue.stream().sorted().forEach(System.out::println); // O(n log n)
        long end = System.nanoTime();
        System.out.println("Display Patients - Time: " + (end - start) + " ns, Complexity: O(n log n)");
        System.out.println();
    }
}

public class EmergencyPriorityQueue {
    public static void main(String[] args) {
        EmergencyRoom er = new EmergencyRoom();

        er.addPatient("Alice", 2);
        er.addPatient("Bob", 5);
        er.addPatient("Charlie", 3);
        er.displayPatients();

        er.treatNext();
        er.displayPatients();
    }
}

---OUTPUT---
Add Patient: Alice - Time: 730900 ns, Complexity: O(log n)
Add Patient: Bob - Time: 8100 ns, Complexity: O(log n)
Add Patient: Charlie - Time: 1700 ns, Complexity: O(log n)

Bob (Severity: 5)
Charlie (Severity: 3)
Alice (Severity: 2)
Display Patients - Time: 8020600 ns, Complexity: O(n log n)

Treating: Bob (Severity: 5)
Get Next Patient - Time: 493600 ns, Complexity: O(log n)

Charlie (Severity: 3)
Alice (Severity: 2)
Display Patients - Time: 63700 ns, Complexity: O(n log n)
