using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace MVC_BasicTutorials.Models
{
    public class Student
    {
        public int StudentId { get; set; }
        public string StudentName { get; set; }
        public int Age { get; set; }
    }


    public class StudentList
    {
        // singleton pattern, not thread safe but good enough for this demo (single server solution, single threaded)
        // this is all just to fake out not having a database for now
        List<Student> myList_mv;
        private static StudentList instance = null;
        private StudentList()
        {
            myList_mv = null; // empty
        }

        public List<Student> GetList()
        {
            return myList_mv;
        }

        public static StudentList Instance // my singleton of a student list
        {
            get
            {
                if (instance == null)
                {
                    instance = new StudentList();
                    // populate with dummy data the first time this is referenced
                    instance.myList_mv = new List<Student>{
                            new Student() { StudentId = 1, StudentName = "John", Age = 18 } ,
                            new Student() { StudentId = 2, StudentName = "Steve",  Age = 21 } ,
                            new Student() { StudentId = 3, StudentName = "Bill",  Age = 25 } ,
                            new Student() { StudentId = 4, StudentName = "Ram" , Age = 20 } ,
                            new Student() { StudentId = 5, StudentName = "Ron" , Age = 31 } ,
                            new Student() { StudentId = 6, StudentName = "Chris" , Age = 17 } ,
                            new Student() { StudentId = 7, StudentName = "Rob" , Age = 19 }
                        };
                    // Get the students from the database in the real application 

                } // end if first time

                return instance;
            }
        }

    } // end StudentList

}