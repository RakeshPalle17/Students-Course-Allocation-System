package studentCoursesMgmt.registration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import studentCoursesMgmt.util.FileDisplayInterface;
import studentCoursesMgmt.util.FileProcessor;
import studentCoursesMgmt.util.Results;

public class StudentRegistration {

    public static final int COURSES_ASSINGED = 3;
    List<Double> AvgSatisfactionRate = new ArrayList<>();
    List<Integer> regTrack = new ArrayList<>();

    /**
     * Processes course registration for a student and returns a status message.
     *
     * @param listOfCoursesInfo A list of course information.
     * @param student           The student for whom registration is processed.
     * @param fpOutConflict     The FileProcessor for writing conflict messages.
     * @param fpOutError        The FileProcessor for writing error messages.
     * @return A status message indicating the result of the course registration.
     */

    public String courseRegistrationProcessing(List<List<Course>> listOfCoursesInfo, Student student,
            FileProcessor fpOutConflict, FileProcessor fpOutError) {

        FileDisplayInterface result = new Results();

        boolean timeConflict = false, alreadyRegistered = false;
        List<Double> satisfaction = new ArrayList<>();
        int[] courseTime = new int[COURSES_ASSINGED];
        StringBuilder registerBuilder = new StringBuilder();
        HashMap<Integer, String> map = new HashMap<>();
        int courseCount = 0;

        try {
            alreadyRegistered = checkRegistrationStatus(student.getStudentId(), regTrack, fpOutError, result);
            regTrack.add(student.getStudentId());

            if (!alreadyRegistered) {
                int k = 0;
                String CName = null;
                registerBuilder.append(student.getStudentId());
                for (int i = 1; i < student.coursePreferences.length; i++) {
                    for (List<Course> course : listOfCoursesInfo) {

                        if (course.get(k).getcourseName().equals(student.coursePreferences[i])
                                && course.get(k).getcourseCapacity() == 0) {
                            String msg = student.getStudentId() + " student requested for course "
                                    + course.get(k).getcourseName()
                                    + " has no space, Filled !!";
                            result.printErrorLogsToFile(msg, fpOutError);

                        } else if (course.get(k).getcourseName().equals(student.coursePreferences[i])
                                && course.get(k).getcourseCapacity() != 0
                                && courseCount <= 2) {

                            for (int j = 0; j < COURSES_ASSINGED; j++) {
                                CName = map.get(courseTime[j]);
                                if (map.containsKey(courseTime[j]) && courseTime[j] == course.get(k).getcourseTime()) {
                                    String msg = student.getStudentId() + "" + " has time conflicting between "
                                            + CName + " and " + course.get(k).getcourseName();
                                    timeConflict = true;

                                    result.printConflictsToFile(msg, fpOutConflict);

                                }
                            }

                            if (!timeConflict) {
                                courseTime[courseCount] = course.get(k).getcourseTime();
                                map.put(course.get(k).getcourseTime(), course.get(k).getcourseName());
                                satisfaction.add((double) (student.coursePreferences.length - i));
                                int c = course.get(k).getcourseCapacity() - 1;
                                registerBuilder.append(":");
                                registerBuilder.append(course.get(k).getcourseName());
                                course.get(k).setcourseCapacity(c);
                                courseCount++;
                            }
                        }
                        timeConflict = false;
                    }
                }

                String satisfactionRate = calculateSatisfactionOfEachStudent(satisfaction);
                AvgSatisfactionRate.add(Double.parseDouble(satisfactionRate));
                registerBuilder.append("::");
                registerBuilder.append("SatisfactionRating=");
                registerBuilder.append(satisfactionRate);

                return registerBuilder.toString();
            }
        } catch (Exception ex) {
            System.err.println("Exception in Registration" + ex);
            result.printErrorLogsToFile(ex.toString(), fpOutError);

        }
        return null;

    }

    public static boolean checkRegistrationStatus(int studentId, List<Integer> regTrack, FileProcessor fpOutError,
            FileDisplayInterface result) {
        for (int track : regTrack) {
            if (track == studentId) {
                String msg = "Error: " + studentId + " is already registered !!!";
                result.printErrorLogsToFile(msg, fpOutError);
                return true;
            }
        }
        return false;

    }

    /**
     * Calculates the satisfaction rate for each student based on a list of
     * satisfaction values.
     *
     * @param satisfaction A list of satisfaction values for students.
     * @return The satisfaction rate calculated for each student.
     */

    private static String calculateSatisfactionOfEachStudent(List<Double> satisfaction) {
        String sRate = null;
        try {
            double satisfactionRate = 0;
            for (double i : satisfaction) {
                satisfactionRate = i + satisfactionRate;
            }

            satisfactionRate = satisfactionRate / COURSES_ASSINGED;
            sRate = String.format("%.2f", satisfactionRate);
            satisfactionRate = Double.parseDouble(sRate);
        } catch (Exception e) {
            System.err.println("Exception in Registration" + e);

        }
        return sRate;

    }

    /**
     * Calculates and returns the average satisfaction rate.
     *
     * @return The average satisfaction rate for all students.
     */

    public double calculatingAvgSatisfactionRate() {

        double avgTotal = 0;
        try {
            if (AvgSatisfactionRate != null) {
                for (double avg : AvgSatisfactionRate) {
                    avgTotal = avg + avgTotal;
                }
                avgTotal = avgTotal / AvgSatisfactionRate.size();
                avgTotal = Double.parseDouble(String.format("%.2f", avgTotal));
            }
        } catch (Exception e) {
            System.err.println("Exception in Registration" + e);
        }
        return avgTotal;

    }
}