package studentCoursesMgmt.driver;

import studentCoursesMgmt.util.StudentManagement;
import studentCoursesMgmt.util.FileDisplayInterface;
import studentCoursesMgmt.util.FileProcessor;
import studentCoursesMgmt.util.Results;

import java.util.List;
import studentCoursesMgmt.registration.Course;

/**
 * @author placeholder
 *
 */
public class Driver {

	public static void main(String[] args) {

		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */

		if (args.length != 5 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")
				|| args[3].equals("${arg3}") || args[4].equals("${arg4}")) {
			System.err.println("Error: Incorrect number of arguments. Program accepts 5 argumnets.");
			System.exit(0);
		}

		try {

			StudentManagement studentMgmnt = new StudentManagement();
			FileDisplayInterface result = new Results();

			FileProcessor fpIn = new FileProcessor(args[0], "in");
			FileProcessor fpIn1 = new FileProcessor(args[1], "in");
			FileProcessor fpOut = new FileProcessor(args[2], "out");
			FileProcessor fpOut1 = new FileProcessor(args[3], "out");
			FileProcessor fpOut2 = new FileProcessor(args[4], "out");

			List<List<Course>> listOfCoursesInfo = studentMgmnt.courseInfoProcessor(fpIn1);
			List<String> resultList = studentMgmnt.coursePrefProcessor(fpIn, listOfCoursesInfo, fpOut1, fpOut2);
			result.printResultToFile(resultList, fpOut);

			fpIn.closeFile(fpIn);
			fpIn1.closeFile(fpIn1);
			fpOut.closeFile(fpOut);
			fpOut1.closeFile(fpOut1);
			fpOut2.closeFile(fpOut2);

		} catch (Exception e) {
			System.err.println("Exception Occured in Driver" + e);
			System.exit(0);
		}

	}
}
