using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

using Newtonsoft.Json;
using System.IO;

namespace pdumaresq_C50_L08_PartA.Models {
	enum gender { Male = 0, Female = 1, Pangender = 2 }

	public class Person {
		public string Name { get; set; }
		public string Age { get; set; }
		public string Job { get; set; }
		public string Gender { get; set; }
	}

	public class PersonList {
		public List<Person> people;
		public static PersonList instance = null;

		public PersonList() {
			people = null;
		}

		public void UpdatePerson(string name, Person newBook) {
			people.Find(b => b.Name == name).Job = newBook.Job;
			people.Find(b => b.Name == name).Age = newBook.Age;
			people.Find(b => b.Name == name).Gender = newBook.Gender;
		}

		public void removeBook(string name) {
			people.Remove(people.Find(b => b.Name == name));
		}

		public void addBook(Person newBook) {
			people.Add(newBook);
		}


		public List<Person> GetList() {
			return people;
		}

		public static PersonList Instance {
			get {
				if ( instance == null ) {
					instance = new PersonList() {
						people = new List<Person>()
					};

					string jsonSTRING = File.ReadAllText(HttpContext.Current.Server.MapPath("~/App_Data/personJSON.json"));
					instance.people = JsonConvert.DeserializeObject<List<Person>>(jsonSTRING);
				}

				return instance;
			}
		}

		public void UpdateJson() {
			string json = JsonConvert.SerializeObject(instance.people);
			File.WriteAllText(HttpContext.Current.Server.MapPath("~/App_Data/personJSON.json"), json);
		}

	}
}