Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in studentCoursesMgmt/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile studentCoursesMgmt/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile studentCoursesMgmt/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command:  

ant -buildfile studentCoursesMgmt/src/build.xml run -Darg0=coursePrefs.txt -Darg1=courseInfo.txt -Darg2=regResults.txt -Darg3=regConflicts.txt -Darg4=errorLog.txt


Note: Arguments accept the absolute path of the files.

-----------------------------------------------------------------------
## Description:

Quality of Solution and Data structues used:

I'm using ArrayList to store the courseInfo details and to store the registeration results as we don't know how many course preferences are there in file. ArrayList can dynamically resize itself. It automatically grows or shrinks as elements are added or removed, eliminating the need to manually manage the array size. ArrayList maintains the order of elements. Elements are stored in the same order they are added, and you can access them by their index. It supports the generic type in our case Type Course (courseName, Time, Capacity) and Type Students (studentId, coursepreferences[]). for insertion it takes O(1) time complexity and O(1) space complexity. Accessing any element at a particular index can be done in O(1) time. To search for specific course within the ArrayList can take O(n) time in the worst case since it requires iterating through the list.  Iterating through each line of coursePrefs (reading line by line) as a string and processing for the registration. I’m not storing the entire coursePref file in any data structure.

I’m using a brute force algorithm to allocate the courses to students based on their preferences on First come first serve basis. The allocation of courses to students is done in a brute-force manner based on their preferences. For each student, you iterate through their preferences N (N * M, where M is the number of courses) and check course availability. Therefore, the time complexity for allocating courses to one student could be done in O(M*N) and for allocating to all the could be done in O(N * T * M). Overall, the time complexity for allocating the courses to all the students could take O(M*N) * O(T), where T is the number of students. and I'm keeping the track of each students satisfaction rate (individual) 
in a ArrayList to calculate the Avarage satisfaction rate in corresponding to all the students which could be done in O(N) where N is the total number of students.

After the registration process completes, I’m storing the results into an ArrayList and printing it to a file by calling the method in results. It takes O(N) to write all the contents for the ArrayList in the output file where N is the size of the ArrayList. 



