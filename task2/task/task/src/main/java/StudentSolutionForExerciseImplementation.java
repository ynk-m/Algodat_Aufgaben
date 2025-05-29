import exercise.StudentSolutionForExercise;
import exercise.StudentInformation;
import exercise_framework.util.solver.Solver;

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

    // Implementieren Sie hier Ihre Lösung mit der Polynomialzeitreduktion.
    public boolean findExactCover(boolean[][] sets, Solver solver, boolean[] chosenSets) {
        return false;
    }    
}
