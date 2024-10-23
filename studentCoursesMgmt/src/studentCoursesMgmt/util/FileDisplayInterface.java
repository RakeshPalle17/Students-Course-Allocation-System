package studentCoursesMgmt.util;

import java.util.List;

public interface FileDisplayInterface {

    public void printResultsToStdout(List<String> resultList);

    public void printResultToFile(List<String> rslt, FileProcessor fpOut);

    public void printErrorLogsToStdOut(String errorMsg);

    public void printErrorLogsToFile(String errorMsg, FileProcessor fpOutError);

    public void printConflictsToStdOut(String confilctMsg);

    public void printConflictsToFile(String confilctMsg, FileProcessor fpOutError);

}
