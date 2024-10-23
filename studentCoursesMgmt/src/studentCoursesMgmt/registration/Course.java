package studentCoursesMgmt.registration;

public class Course {

    private String courseName;
    private int courseCapacity;
    private int courseTime;

    /**
     * Constructs a Course object with the given attibutes.
     *
     * @param courseName     The name of the course.
     * @param courseCapacity The capacity of the course.
     * @param courseTime     The time of the course.
     */

    public Course(String courseName, int courseCapacity, int courseTime) {

        this.courseName = courseName;
        this.courseCapacity = courseCapacity;
        this.courseTime = courseTime;
    }

    /**
     * Retrieves the name of the course.
     *
     * @return The name of the course.
     */

    public String getcourseName() {
        return courseName;
    }

    /**
     * Sets the capacity of the course.
     *
     * @param courseCapacity The new capacity of the course.
     */

    public void setcourseCapacity(int courseCapacity) {
        this.courseCapacity = courseCapacity;
    }

    /**
     * Retrieves the capacity of the course.
     *
     * @return The capacity of the course.
     */

    public int getcourseCapacity() {
        return courseCapacity;
    }

    /**
     * Retrieves the time of the course.
     *
     * @return time of course.
     */

    public int getcourseTime() {
        return courseTime;
    }

    /**
     * Returns a string reprsentation of the Course objt.
     *
     * @return A string reprsentation containing course name, capacity, and time.
     */

    @Override
    public String toString() {
        return courseName + " " + courseCapacity + " " + courseTime;
    }
}
