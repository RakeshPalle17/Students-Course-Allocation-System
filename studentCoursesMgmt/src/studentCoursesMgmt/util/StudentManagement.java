package studentCoursesMgmt.util;

import java.util.ArrayList;
import java.util.List;

import studentCoursesMgmt.registration.Course;
import studentCoursesMgmt.registration.Student;
import studentCoursesMgmt.registration.StudentRegistration;

public class StudentManagement {

    public List<List<Course>> courseInfoProcessor(FileProcessor fpIn1) {

        List<Course> courses = new ArrayList<>();
        List<List<Course>> courseList = new ArrayList<>();
        String oneCourseInfo = null;
        try {
            while ((oneCourseInfo = fpIn1.readLine(fpIn1)) != null && !oneCourseInfo.isEmpty()) {
                courses = parseCourseInfoProcessor(oneCourseInfo);
                courseList.add(courses);
            }
        } catch (Exception e) {
            System.err.println("Exception in StudentManagement"+e);
        }

        return courseList;
    }

    private static List<Course> parseCourseInfoProcessor(String str) {

        List<Course> courses = new ArrayList<>();
        try {
            String[] tokens = str.split(":");
            if (tokens.length == 3) {
                String name = tokens[0].trim();
                int capacity = Integer.parseInt(tokens[1].trim());
                int time = Integer.parseInt(tokens[2].trim());
                Course course = new Course(name, capacity, time);
                courses.add(course);
            } else {
                System.err.println("Invalid line: " + str);
            }
        } catch (Exception ex) {
            System.err.println("Exception in StudentManagement"+ex);
        }

        return courses;
    }

    public List<String> coursePrefProcessor(FileProcessor fpIn, List<List<Course>> listOfCoursesInfo,
            FileProcessor fpOut1, FileProcessor fpOut2) {

        Student student = new Student();
        StudentRegistration registration = new StudentRegistration();
        List<String> listOfRegistrationResult = new ArrayList<>();
        String onePref = null;

        try {
            while ((onePref = fpIn.readLine(fpIn)) != null && !onePref.isEmpty()) {
                student = parseCoursePrefProcessor(onePref);
                String registionComplete = registration.courseRegistrationProcessing(listOfCoursesInfo, student, fpOut1,
                        fpOut2);
                if (registionComplete != null)
                    listOfRegistrationResult.add(registionComplete);
            }
        } catch (NullPointerException e) {
            System.err.println("Exception in StudentManagement"+e);
        }
        catch (Exception e) {
            System.err.println("Exception in StudentManagement"+e);
        }
        double avg = registration.calculatingAvgSatisfactionRate();
        if (!Double.isNaN(avg)) {
            String calculatedAvgSatisfaction = "AverageSatisfactionRating=" + avg;
            listOfRegistrationResult.add(calculatedAvgSatisfaction);
        }

        return listOfRegistrationResult;
    }

    private static Student parseCoursePrefProcessor(String str) {

        Student student = new Student();
        try {
            str = str.replaceAll(";", "");
            student.setCoursePreferences(str.split(" "));
            student.setStudentId(Integer.parseInt(str.substring(0, 3)));

        } catch (StringIndexOutOfBoundsException e) {
            System.err.println("Exception in StudentManagement"+e);
        }
         catch (Exception e) {
            System.err.println("Exception in StudentManagement"+e);
        }

        return student;
    }
}
