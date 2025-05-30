import exercise.StudentSolutionForExercise;
import exercise.StudentInformation;

import exercise_framework.StudentSolution;
import exercise.helper.ChainElement;
import exercise.helper.HashTable;
import exercise.helper.HashTableWithChaining;
import exercise.helper.Probe;

/**
 * A class intended for students to implement their solutions in.
 */
public class StudentSolutionForExerciseImplementation implements StudentSolutionForExercise {

    /**
     * Collects and returns information about the student working on solving the instance sets.
     * This method is called automatically.
     * @return First name, last name, and matriculation number collected in a {@link StudentInformation} instance.
     */
    public StudentInformation provideStudentInformation() {
        return new StudentInformation(
                "Yannick", // Vorname
                "Matousek", // Nachname
                "12005960" // Matrikelnummer
        );
    }

    // Implementieren Sie hier Ihre Lösung für Verkettung der Überläufer
    public void insertVerkettung(HashTableWithChaining t, ChainElement chainElement, int m) {

        // formel h(k) = k mod m
        int key = chainElement.getKey() % m;

        // Fall 1: Leere Position
        if (t.containsNoChainElement(key)) {
            t.insertChainElement(chainElement, key);
        }
        // Fall 2: nicht leer
        else {
            ChainElement firstElement = t.get(key);
            chainElement.setNext(firstElement);
            t.replaceChainElement(chainElement, key);
        }


    }

    // Implementieren Sie hier Ihre Lösung für die lineare Sondierung
    public int linearesSondieren(int key, int i, int m) {
        // formel h(k,i) = (h'(k) + i) mod m
        return ((key % m) + i) % m;
    }

    // Implementieren Sie hier Ihre Lösung für die quadratische Sondierung
    public int quadratischesSondieren(int key, int i, int m) {
        // formel h(k,i) = (h'(k) + c1*i + c2^i) mod m
        final double c = 0.5;
        int h1 = key % m;
        return (h1 + (int)((c * i) + (c * Math.pow(i,2)))) % m;

    }

    // Implementieren Sie hier Ihre Lösung für Double Hashing
    public int doubleHashing(int key, int i, int m) {
        // formel h(k,i) = (h1(k) + i * h2(k)) mod m
        int h1 = key % m;
        int h2 = 1 + (key % 5);
        return (h1 + i * h2) % m;
    }

    // Implementieren Sie hier Ihre Lösung für die Insert-Methode
    public void insert(HashTable t, Probe p, int key, int m) {
        int validPos = p.evaluate(key, 0);
        for (int i = 0; !t.isFree(validPos) ; i++) {
            validPos = p.evaluate(key,i);
        }

        t.insert(key, validPos);
    }

    // Implementieren Sie hier Ihre Lösung für Verbesserung nach Brent
    public void insertVerbesserungNachBrent(HashTable t, int key, int m) {


        // platz j
        int j = key % m;

        while (!t.isFree(j)) {
            // speicher den aktuellen Wert an ursprünglicher Position j
            int jKey = t.get(j);
            // berechne neue Positionen
            int j1 = (j + (1 +  key % 5)) % m;
            int j2 = (j + (1 + jKey % 5)) % m;

            // ist ersterer Platz frei -> setze neuen key auf j1
            if (t.isFree(j1) || !t.isFree(j2)) {
                j = j1;

            // ist zweiterer Platz frei und j1 besetzt -> setze ursprünglichen key auf j2 und neuen key auf j
            } else {
                t.replace(key, j);
                key = jKey;
                j = j2;
            }
        }
        t.insert(key, j);
    }
}
