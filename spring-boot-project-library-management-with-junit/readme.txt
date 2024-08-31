ProjectName: Library-Management-System

Programming-Language: java,jdbc,servlet,spring-data-jpa,spring-boot-3.0
Database: MySQL
Tools: STS(Spring Tool Suits),Mysql-Workbench,Git-Bash,Post-Man-API

Introduction:

Library management application is used in library where student can take the book for study purpose only for 10 days
Here in this application you will get multiple features 

MainAdmin: he can able to add the librarian and can create the librariyan loginid and password
librarian: librarian can add the student and books but if he logged in then can able to work on those.he can issue the book to student 
librarian can see the student details who has taken the book.

How to Run The Application:

Admin:

localhost:8082/saveAdmin : Open Your PostManApi and paste this url and change port number according to you and save the admin details pass adminid,name,email,phone.

localhost:8082/loginAdmin/adminName/adminEmail: pass adminname and email to logged in with admin to create librarian.

localhost:8082/logoutAdmin: after loggedout from admin portal you can not add librarian.

SaveLibrarian:

localhost:8082/saveLibrarian: save the librarian details if admin loggedin

localhost:8082/updateLibrarian/librarianId: update librarian

localhost:8082/logLibrarian/librarianName/librarianEmail: logged in with librarian with email and name

localhost:8082/librarianLogout: logout librarian

Books:

localhost:8082/saveBook: save the book details if librarian logged in you can pass bookNumber,bookName,bookAuthor

localhost:8082/saveStudent: save the student details if librarian logged in you can pass studentId,studentName,studentEmail,studentPhone

IssueBooks:

localhost:8082/bookIssue/studentId/BookId: librarian can issue the book for particular student and automatic submission date will be genarted student can avail the book for 10 days free of cost.after 10 days per day 1 rupees fine.

localhost:8082/checkFine/bookId/studentId: librarian can check the fine of that issued book 

localhost:8082/submitBook/bookId/studentId: librarian can submit the book once he/she will submit the book all the details of issueBook table will get removed....



