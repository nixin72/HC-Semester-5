using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace LoginApi
{
	public enum Province {
		[Display(Name = "Ontario")]
		ON,
		[Display(Name = "New Brunswick")]
		NB,
		[Display(Name = "Nova Scotia")]
		NS,
		[Display(Name = "Quebec")]
		QC,
	}

	[WebService(Namespace = "http://cegep-heritage.qc.ca")]
	[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
	[System.ComponentModel.ToolboxItem(false)]
	public class MyFirst : System.Web.Services.WebService {
		[WebMethod(Description = "Calculates the tip for your bill")]
		public double TipCalculator(double totalCost, double tipAmount) {
			return round(totalCost * tipAmount / 100.0);
		}

		[WebMethod(Description = "Calculates how much each person pays for your bill")]
		public double MyShare(double totalCost, int numPeople, string tipAmount) {
			try {
				return round((totalCost + (totalCost * (Double.Parse(tipAmount) / 100.0))) / numPeople);
			}
			catch {
				return round(totalCost / numPeople);
			}			
		}

		[WebMethod(Description = "Calculates the taxes for your bill given a province")]
		public double AddTaxes(double totalCost, Province prov) {
			double afterTax = totalCost;
			switch ( prov ) {
				case Province.NB: {
						afterTax *= .13;
					}
					break;
				case Province.NS: {
						afterTax *= .15;
					}
					break;
				case Province.ON: {
						afterTax *= .13;
					}
					break;
				case Province.QC: {
						afterTax *= .135;
					}
					break;
			}

			return round(afterTax);
		}

		public double round(double n) {
			return Math.Round(n * 100) / 100;
		}
	}
}
