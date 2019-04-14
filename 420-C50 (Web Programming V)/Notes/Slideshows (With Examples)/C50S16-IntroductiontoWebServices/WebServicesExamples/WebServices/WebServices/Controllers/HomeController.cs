using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using WebServices.ServiceReferenceCities;

namespace WebServices.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult About()
        {
            ViewBag.Message = "Your application description page.";
            CitiesSoapClient citiesClient = new CitiesSoapClient("CitiesSoap");
            CityDetail[] citiesArray;
            citiesArray = citiesClient.GetCities("CA", "20"); // get for Canada

            ViewBag.City = citiesArray;
            return View();
        }

        public ActionResult Cities()
        {
            
            CitiesSoapClient citiesClient = new CitiesSoapClient("CitiesSoap");
            CityDetail[] citiesArray;
            citiesArray = citiesClient.GetCities("CA", "200"); // get for Canada

            ViewBag.Title = "Cities in Canada";
            return View(citiesArray);
        }

        public ActionResult Contact()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        }
    }
}