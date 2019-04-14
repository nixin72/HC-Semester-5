using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Xml;
using System.Xml.Linq;
using System.Web.Hosting;
using System.Xml.Schema;
using System.ComponentModel.DataAnnotations;

namespace pdumaresq_C50_A03.Models {
    public enum Category {
        Other,
        Beverage,
        Bread,
        [Display(Name = "Canned Goods")]
        Canned_Goods,
        Dairy,
        [Display(Name = "Dry Goods")]
        Dry_Goods,
        [Display(Name = "Frozen Goods")]
        Frozen_Goods,
        Meat,
        Produce,
        Cleaners,
        [Display(Name = "Paper Goods")]
        Paper_Goods,
        [Display(Name = "Personal Care")]
        Personal_Care        
    }

    public class Item {
        [Required(ErrorMessage = "Name is required.")]
        [Display(Name = "Name")]
        [StringLength(50)]
        public String ItemName { get; set; }

        [Required(ErrorMessage = "Category is required.")]
        [Display(Name = "Category")]
        public Category ItemCategory { get; set; }

        [Required(ErrorMessage = "Quantity is required.")]
        [Display(Name = "Quantity")]
        [Range(1, 100)]
        public int ItemQuantity { get; set; }

        [Required(ErrorMessage = "Price is required.")]
        [Display(Name = "Price")]
        [Range(typeof(decimal), "0", "9999.99 ")]
        public double ItemPrice { get; set; }
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

        private static XElement RemoveAllNamespaces(XElement xmlDocument) {
            if (!xmlDocument.HasElements) {
                XElement xElement = new XElement(xmlDocument.Name.LocalName);
                xElement.Value = xmlDocument.Value;

                foreach (XAttribute attribute in xmlDocument.Attributes())
                    xElement.Add(attribute);

                return xElement;
            }
            return new XElement(xmlDocument.Name.LocalName, xmlDocument.Elements().Select(el => RemoveAllNamespaces(el)));
        }

        public static ShoppingList Instance {
            get {
                if (instance == null) {
                    instance = new ShoppingList() { Items = new List<Item>() };

                    if (!ValidateXml()) {
                        XElement xml = XElement.Load(HostingEnvironment.MapPath("~/App_Data/ShoppingList.xml"));

                        foreach (var item in xml.Descendants("ShoppingEntry")) {
                            instance.Items.Add(new Item() {
                                ItemName = item.Element("Product").Element("Name").Value,
                                ItemPrice = Double.Parse(item.Element("Product").Element("Price").Value),
                                ItemCategory = (Category) Enum.Parse(
                                    typeof(Category), 
                                    item.Element("Product").Attribute("Category").Value.Replace(' ', '_')
                                ),
                                ItemQuantity = Int16.Parse(item.Element("Quantity").Value)
                            });
                        }
                    }
                }

                return instance;
            }
        }

        public static Boolean ValidateXml() {
            XmlSchemaSet schema = new XmlSchemaSet();
            schema.Add("", HostingEnvironment.MapPath("~/App_Data/ShoppingList.xsd"));

            XDocument xml = XDocument.Load(HostingEnvironment.MapPath("~/App_Data/ShoppingList.xml"));
            Boolean isValid = false;
            xml.Validate(schema, (a, b) => { isValid = true; });

            return isValid;
        }

		public Item GetItem(string name)
		{
			return Items.Find(i => i.ItemName == name);
		}

        public void EditList(string itemName, Item newItem) {
            Items.Find(i => i.ItemName.Equals(itemName)).ItemCategory = newItem.ItemCategory;
            Items.Find(i => i.ItemName.Equals(itemName)).ItemPrice = newItem.ItemPrice;
            Items.Find(i => i.ItemName.Equals(itemName)).ItemQuantity = newItem.ItemQuantity;
            UpdateXml();
        }

        public int RemoveItem(string itemName) {
			try
			{
				var q = Items.Remove(Items.Find(i => i.ItemName.Equals(itemName)));
				return UpdateXml();
			}
			catch
			{
				return -1;
			}
            
        }

        public Boolean CreateItem(Item newItem) {
            bool isFound = false;
            Items.ForEach(i => {
                if (newItem.ItemName == i.ItemName) {
                    isFound = true;
                }
            });

            if (isFound)
                return false;
            
            Items.Add(newItem);
            UpdateXml();

            return true;
        }

        private int UpdateXml() {
	        try {
		        XDocument document = new XDocument(new XElement("ShoppingList"));
		        Items.ForEach(item => {
			        document.Root.Add(
				        new XElement("ShoppingEntry",
					        new XElement("Product",
						        new XAttribute("Category", item.ItemCategory.ToString().Replace('_', ' ')),
						        new XElement("Name", item.ItemName),
						        new XElement("Price", item.ItemPrice)
					        ),
					        new XElement("Quantity", item.ItemQuantity)
				        )
			        );
		        });

		        document.Save(HostingEnvironment.MapPath("~/App_Data/ShoppingList.xml"));
				return 0;
			}
	        catch {
				return -1;
			}
        }
    }
}