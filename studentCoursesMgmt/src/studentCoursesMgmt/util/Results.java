package studentCoursesMgmt.util;

import java.util.List;

public class Results implements FileDisplayInterface {

    /**
     * Writes a list of results to a specified file using a FileProcessor.
     *
     * @param resultList The list of results to be written to the file.
     * @param fpOut      The FileProcessor object for writing to the file.
     * @return return type void
     */

    public void printResultToFile(List<String> resultList, FileProcessor fpOut) {
        try {
            if (fpOut != null) {
                for (String result : resultList) {
                    fpOut.writeLine(fpOut, result);
                }
            }

        } catch (Exception e) {
            System.err.println("Exception Occured in printResultToFile" + e);
            System.exit(0);
        }
    }

    /**
     * Prints a list of results to the standard output.
     *
     * @param resultList The list of results to be printed to the console.
     * @return return type void
     */

    public void printResultsToStdout(List<String> resultList) {

        for (String result : resultList)
            System.out.println(result);
    }

    /**
     * Writes an error message to a specified error log file using a FileProcessor.
     *
     * @param errorMsg   The error message to be written to the errorLog file.
     * @param fpOutError The FileProcessor object for writing to the errorLog file.
     * @return return type void
     */

    public void printErrorLogsToFile(String errorMsg, FileProcessor fpOutError) {
        try {
            if (fpOutError != null)
                fpOutError.writeLine(fpOutError, errorMsg);

        } catch (Exception e) {
            System.err.println("Exception Occured in results" + e);
            System.exit(0);
        }

    }

    /**
     * Prints an error message to the standard output.
     *
     * @param errorMsg The error message to be printed to the console.
     * @return return type void
     */

    public void printErrorLogsToStdOut(String errorMsg) {
        System.out.println(errorMsg);
    }

    /**
     * Writes a conflict message to a specified conflict log file using a
     * FileProcessor.
     *
     * @param conflictMsg   Conflict message to be written to conflictLogfile
     * @param fpOutConflict FileProcessor object for writing to conflictLogfile.
     * @return return type void
     */

    public void printConflictsToFile(String confilctMsg, FileProcessor fpOutConflict) {

        try {
            if (fpOutConflict != null)
                fpOutConflict.writeLine(fpOutConflict, confilctMsg);

        } catch (Exception e) {
            System.err.println("Exception Occured in results" + e);
            System.exit(0);
        }

    }

    /**
     * Prints a conflict message to the standard output.
     *
     * @param conflictMsg The conflict message to be printed to the standaerd out.
     * @return return type void
     * 
     */

    public void printConflictsToStdOut(String confilctMsg) {

        System.out.println(confilctMsg);

    }

}
