using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using pdumaresq_C50_A03.Cities;
using Newtonsoft.Json;

namespace pdumaresq_C50_A03.Controllers
{
    public class CitiesController : Controller
    {
		CitiesSoapClient c = new CitiesSoapClient();
        // GET: Cities
        public ActionResult Index()
        {
            return View();
        }

		public String GetCountryCodes()
		{
			CitiesSoapClient c = new CitiesSoapClient();
			return JsonConvert.SerializeObject(c.GetCountries().ToList());
		}

	    public String GetCities(string country, string max)
	    {
		    CitiesSoapClient c = new CitiesSoapClient();
		    return JsonConvert.SerializeObject(c.GetCities(country, max).ToList());
	    }

	    public String GetWeather(int id)
	    {
			CitiesSoapClient c = new CitiesSoapClient();
		    return JsonConvert.SerializeObject(c.GetCityWeather(id));
		}
	}
}