using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using pdumaresq_C50_L08_PartA.Models;

namespace pdumaresq_C50_L08_PartA.Controllers {
	public class PersonController : Controller {
		List<Person> people = PersonList.Instance.GetList();

		public ActionResult Index() {
			return View(people);
		}

		public ActionResult UpdateJson() {			
			PersonList.Instance.UpdateJson();
			return RedirectToAction("Index");
		}

		public ActionResult Details(string name) {
			return View(people.Find(p => p.Name == name));
		}

		public ActionResult Create() {
			return View();
		}

		[HttpPost]
		public ActionResult Create(FormCollection collection) {
			try {
				Person newPerson = new Person() {
					Name = collection["Name"],
					Age = collection["Age"],
					Job = collection["Job"],
					Gender = collection["Gender"],
				};

				PersonList.Instance.addBook(newPerson);

				return RedirectToAction("Index");
			}
			catch {
				return View();
			}
		}

		public ActionResult Edit(string name) {
			return View(people.Find(p => p.Name == name));
		}

		[HttpPost]
		public ActionResult Edit(string name, FormCollection collection) {
			try {
				Person newPerson = new Person() {
					Name = collection["Name"],
					Age = collection["Age"],
					Job = collection["Job"],
					Gender = collection["Gender"],
				};

				PersonList.Instance.UpdatePerson(name, newPerson);
				return RedirectToAction("Index");
			}
			catch {
				return View();
			}
		}

		public ActionResult Delete(string name) {
			return View(people.Find(p => p.Name == name));
		}

		[HttpPost]
		public ActionResult Delete(string name, FormCollection collection) {
			try {
				PersonList.Instance.removeBook(name);
				return RedirectToAction("Index");
			}
			catch {
				return View();
			}
		}
	}
}
