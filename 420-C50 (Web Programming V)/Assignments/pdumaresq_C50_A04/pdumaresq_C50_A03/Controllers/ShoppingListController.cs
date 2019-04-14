using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Microsoft.Ajax.Utilities;
using pdumaresq_C50_A03.Models;
using Newtonsoft.Json;

namespace pdumaresq_C50_A03.Controllers {
	public class ShoppingListController : Controller {
		// GET: ShoppingList
		public ActionResult Index() {
			return View(ShoppingList.Instance.GetList());
		}

        public String UniqueItemName() {
            return JsonConvert.SerializeObject(ShoppingList.Instance.GetList(), new Newtonsoft.Json.Converters.StringEnumConverter());
        }

		// GET: ShoppingList/Details/5
		public String Details(string name) {
            String json = JsonConvert.SerializeObject(ShoppingList.Instance.GetItem(name), new Newtonsoft.Json.Converters.StringEnumConverter());

            return json;
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
                    ItemCategory = (Category)Int16.Parse(collection["ItemCategory"]),
                    ItemQuantity = Int16.Parse(collection["ItemQuantity"]),
                    ItemPrice = Double.Parse(collection["ItemPrice"])
                };

                if (ShoppingList.Instance.CreateItem(item) == false) {
                    return View();
                }

                return RedirectToAction("Index");
            }
            catch {
                return View();
            }
        }

        // GET: ShoppingList/Edit/5
        public ActionResult Edit(string name) {
			return View(ShoppingList.Instance.GetItem(name));
		}

		// POST: ShoppingList/Edit/5
		[HttpPost]
		public ActionResult Edit(string name, FormCollection collection) {
			try {
				Item item = new Item() {
					ItemName = collection["ItemName"],
					ItemCategory = (Category) Int16.Parse(collection["ItemCategory"]),
					ItemQuantity = Int16.Parse(collection["ItemQuantity"]),
					ItemPrice = Double.Parse(collection["ItemPrice"])
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
            return PartialView("Delete", ShoppingList.Instance.GetItem(name));
		}
		
		public int Remove(string name, byte? _)
		{
			try
			{
				return ShoppingList.Instance.RemoveItem(name);				
			}
			catch
			{
				return -1;
			}			
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

		public ActionResult ShoppingCart() {
			return View("ShoppingCart", ShoppingList.Instance.GetList());
		}
	}
}
