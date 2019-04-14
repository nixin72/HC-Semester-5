using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using pdumaresq_C50_A03.Models;

namespace pdumaresq_C50_A03.Controllers {
	public class ShoppingListController : Controller {
		List<Item> shoppingList = ShoppingList.Instance.GetList();

		// GET: ShoppingList
		public ActionResult Index() {
			return View(shoppingList);
		}

		// GET: ShoppingList/Details/5
		public ActionResult Details(string name) {
			return View(shoppingList.Find(i => i.ItemName.Equals(name)));
		}

		// GET: ShoppingList/Create
		public ActionResult Create() {
			return View();
		}

		// POST: ShoppingList/Create
		[HttpPost]
		public ActionResult Create(FormCollection collection) {
			try {
				Item item = new Item() {
					ItemName = collection["ItemName"],
					ItemCategory = collection["ItemName"],
					ItemQuantity = Int16.Parse(collection["ItemName"]),
					ItemPrice = collection["ItemName"]
				};

				ShoppingList.Instance.CreateItem(item);
				return RedirectToAction("Index");
			}
			catch {
				return View();
			}
		}

		// GET: ShoppingList/Edit/5
		public ActionResult Edit(string name) {
			return View(shoppingList.Find(i => i.ItemName.Equals(name)));
		}

		// POST: ShoppingList/Edit/5
		[HttpPost]
		public ActionResult Edit(string name, FormCollection collection) {
			try {
				Item item = new Item() {
					ItemName = collection["ItemName"],
					ItemCategory = collection["ItemName"],
					ItemQuantity = Int16.Parse(collection["ItemName"]),
					ItemPrice = collection["ItemName"]
				};

				ShoppingList.Instance.EditList(name, item);
				return RedirectToAction("Index");
			}
			catch {
				return View();
			}
		}

		// GET: ShoppingList/Delete/5
		public ActionResult Delete(string name) {
			return View(shoppingList.Find(i => i.ItemName.Equals(name)));
		}

		// POST: ShoppingList/Delete/5
		[HttpPost]
		public ActionResult Delete(string name, FormCollection collection) {
			try {
				ShoppingList.Instance.RemoveItem(name);
				return RedirectToAction("Index");
			}
			catch {
				return View();
			}
		}
	}
}
