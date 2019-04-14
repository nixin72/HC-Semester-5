using System.Web;
using System.Web.Mvc;

namespace pdumaresq_C50_L08_PartA {
	public class FilterConfig {
		public static void RegisterGlobalFilters(GlobalFilterCollection filters) {
			filters.Add(new HandleErrorAttribute());
		}
	}
}
