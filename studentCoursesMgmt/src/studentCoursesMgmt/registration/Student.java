package studentCoursesMgmt.registration;

public class Student {
    int studentId;
    String[] coursePreferences;

    /**
     * Gets the studentId
     *
     * @return The studentID.
     */

    public int getStudentId() {
        return studentId;
    }

    /**
     * Sets the studentID.
     *
     * @param studentId The studentID to set.
     */

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    /**
     * Gets the array of course prefrences for the student.
     *
     * @return The array of course preferences.
     */

    public String[] getCoursePreferences() {
        return coursePreferences;
    }

    /**
     * Sets the array of course prefernces for the student.
     *
     * @param coursePreferences The array of course preferencs to set.
     */

    public void setCoursePreferences(String[] coursePreferences) {
        this.coursePreferences = coursePreferences;
    }

    /**
     * Overrides the default toString() method to provide a custom string
     * represntation of the Student object.
     *
     * @return A string reprsentation of the Student object.
     */

    @Override
    public String toString() {
        return studentId + " ";
    }
}
