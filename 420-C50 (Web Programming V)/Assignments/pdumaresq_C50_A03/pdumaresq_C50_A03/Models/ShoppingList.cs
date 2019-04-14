using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Xml;
using System.Xml.Linq;
using System.Web.Hosting;

namespace pdumaresq_C50_A03.Models {
	public class Item {
		public String ItemName { get; set; }
		public String ItemCategory { get; set; }
		public int ItemQuantity { get; set; }
		public string ItemPrice { get; set; }
	}

	public class ShoppingList {
		List<Item> Items;
		private static ShoppingList instance = null;

		private ShoppingList() {
			Items = null;
		}

		public List<Item> GetList() {
			return Items;
		}

		public static ShoppingList Instance {
			get {
				if (instance == null) {
					instance = new ShoppingList() {
						Items = new List<Item>()
					};

					XElement xml = XElement.Load(HostingEnvironment.MapPath("~/App_Data/ShoppingList.xml"));

					foreach (var item in xml.Descendants("ShoppingEntry")) {
						var itemname = item.Element("Product").Element("Name").Value;
						var itemprice = item.Element("Product").Element("Price").Value;
						var itemcat = item.Element("Product").Attribute("Category").Value;
						var itemquant = Int16.Parse(item.Element("Quantity").Value);

						Item i = new Item() {
							ItemName = itemname,
							ItemPrice = itemprice,
							ItemCategory = itemcat,
							ItemQuantity = itemquant
						};

						Instance.Items.Add(i);
					}

					//instance.Items.AddRange(xml.Descendants("ShoppingEntry").Select<XElement, Item>(item =>
					//	new Item() {
					//		ItemName = item.Element("Product").Element("Name").Value,
					//		ItemPrice = Double.Parse(item.Element("Product").Element("Price").Value),
					//		ItemCategory = item.Element("Product").Attribute("Category").Value,
					//		ItemQuantity = Int16.Parse(item.Element("Quantity").Value)
					//	}
					//).ToList());
				}

				return instance;
			}
		}

		public void EditList(string itemName, Item newItem) {
			Items.Find(i => i.ItemName.Equals(itemName)).ItemCategory = newItem.ItemCategory;
			Items.Find(i => i.ItemName.Equals(itemName)).ItemPrice = newItem.ItemPrice;
			Items.Find(i => i.ItemName.Equals(itemName)).ItemQuantity = newItem.ItemQuantity;

			UpdateXml();
		}

		public void RemoveItem(string itemName) {
			Items.Remove(Items.Find(i => i.ItemName.Equals(itemName)));

			UpdateXml();
		}

		public void CreateItem(Item newItem) {
			Items.Add(newItem);

			UpdateXml();
		}

		private void UpdateXml() {
			XDocument document = new XDocument(new XElement("ShoppingList"));
			Items.ForEach(item => {
				document.Root.Add(
					new XElement("ShoppingEntry",
						new XElement("Product", 
							new XAttribute("Category", item.ItemCategory),
							new XElement("Name", item.ItemName),
							new XElement("Price", item.ItemPrice)
						),
						new XElement("Quantity", item.ItemQuantity)
					)
				);
			});

			document.Save(HttpContext.Current.Server.MapPath("~/App_Data/ShoppingList.xml"));
		}
	}
}