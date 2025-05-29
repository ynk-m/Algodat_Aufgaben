import exercise.StudentSolutionForExercise;
import exercise.StudentInformation;
import exercise.CLCSInstance;
import exercise.DynamicProgrammingTable;

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
                "", // Vorname
                "", // Nachname
                "" // Matrikelnummer
        );
    }

    // Implementieren Sie hier Ihre Lösung für isFeasible()
    public boolean isFeasible(CLCSInstance instance, char[] solution) {
        return false;
    }


    // Implementieren Sie hier Ihre Lösung für die Erstellung der Tabelle für die Dynamische Programmierung
    public void computeDynamicProgrammingTable(CLCSInstance instance, DynamicProgrammingTable table) {
        
    }


    // Implementieren Sie hier Ihre Lösung für das Backtracking im CLCS
    public char[] backtrackingCLCS(CLCSInstance instance, DynamicProgrammingTable table) {
        return null;
    }


    // Implementieren Sie hier Ihre Lösung für das Backtracking im LCS
    public char[] backtrackingLCS(CLCSInstance instance, DynamicProgrammingTable table) {
        return null;
    }
}
