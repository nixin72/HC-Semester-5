using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
//include
using System.IO;
using Newtonsoft.Json;


/*
 * In this example, we demonstrate how to:
 * 1) Read in a JSON file and convert it into a C# object. (de-serialize)
 * 2) Write out an object in JSON format
 * 3) you will find the input and output files in the bin\Debug subdirectory from this project
 * 4) put a breakpoint after the Console.writeln() to see the output
 * 5) also shows enum to string mapping
 * 
 * Note that we are using the Newtonsoft.Json open source package which is a popular
 * package that is supposedly faster than the JavaScriptSerializer and has
 * the following additional features:
 * 1) higher performance (250% faster than JavaScriptSerializer)
 * 2) converts JSON <-> XML
 * 3) JSON path - query JSON with XPath-like syntax
 */
namespace JSONNETExample
{

    class Person
    {
        public string name { get; set; }
        public int age { get; set; }
        public enum GenderEnum { Male, Female, NOYGDB };

        public GenderEnum gender { get; set; }

        public override string ToString()
        {
            return string.Format("Name: {0} \nAge: {1} \nGender: {2}", name, age, gender.ToString());
        }
    }

    class Program
    {
        static void Main(string[] args)
        {


            // deserialize JSON directly from a file
            
            String JSONstring = File.ReadAllText("JSON.json");
            Person p1 = JsonConvert.DeserializeObject<Person>(JSONstring, new Newtonsoft.Json.Converters.StringEnumConverter());
            Console.WriteLine(p1);

            // output JSON file

            Person p2 = new Person { name = "ben", age = 46, gender = Person.GenderEnum.Male };
            // convert object to JSON string
            string outputJSON = JsonConvert.SerializeObject(p2, new Newtonsoft.Json.Converters.StringEnumConverter());

            // write it out to a file
            File.WriteAllText("Output.json", outputJSON);
        }
    }
}
