using System;
using System.Collections.Generic;
using System.Web.Services;
using System.Net;
using System.Xml;


namespace SampleServices
{
    /// <summary>
    /// Summary description for Cities
    /// </summary>
    [WebService(Namespace = "http://cegep-heritage.qc.ca/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    [System.Web.Script.Services.ScriptService]
    public class Cities : System.Web.Services.WebService
    {


        [WebMethod(Description = "Get list of countries (two letter code) for all the cities in the database ")]
        public List<String> GetCountries()
        {
            List<String> countryList = new List<String>();
            SortedSet<String> countrySet = CityDatabase.Instance.GetCountriesSet();

            // convert to list for easy return type
            foreach (String country in countrySet)
            {
               countryList.Add(country);
            }
            

            return countryList;
        }


        [WebMethod(Description = "Get list of cities and details for provided two letter country code (i.e. CA = Canada)")]
        public List<CityDetail> GetCities(String _country, String _maxCount)
        {
            int maxCount = 0;

    
            List<CityDetail> cityList = CityDatabase.Instance.GetCitiesList(_country);

            if (!Int32.TryParse(_maxCount, out maxCount))
            {
                maxCount = cityList.Count;
            }
            return cityList.GetRange(0, maxCount);
        }


        [WebMethod(Description = "Get details for city, given the city ID")]
        public CityDetail GetCityDetail(int _id)
        {
            return CityDatabase.Instance.GetCityDetail(_id);
        }


        [WebMethod(Description = "Get weather for requested city, must specify by cityId (see GetCities())")]
        public XmlDocument GetCityWeather(int _cityId)
        {
            XmlDocument outDoc = new XmlDocument();
            string url = "http://api.openweathermap.org/data/2.5/weather?"+
                "id="+ _cityId +
                "&units=metric" + "&mode=xml" +
                "dummy App Key";


            using (WebClient client = new WebClient())
            {
                String s = client.DownloadString(url);

                outDoc.LoadXml(s);
                return outDoc;
            }
        }


        [WebMethod(Description = "Get distance in Kms between two cities ")]
        public double GetCitiesDistance(int _cityId1, int _cityId2)
        {
            CityDetail city1 = CityDatabase.Instance.GetCityDetail(_cityId1);
            CityDetail city2 = CityDatabase.Instance.GetCityDetail(_cityId2);

            double lat1 = city1.coord.lat;
            double lon1 = city1.coord.lon;
            double lat2 = city2.coord.lat;
            double lon2 = city2.coord.lon;
            
            // distance formula 
            double rlat1 = Math.PI * lat1 / 180;
            double rlat2 = Math.PI * lat2 / 180;
            double theta = lon1 - lon2;
            double rtheta = Math.PI * theta / 180;
            double dist =
                Math.Sin(rlat1) * Math.Sin(rlat2) + Math.Cos(rlat1) *
                Math.Cos(rlat2) * Math.Cos(rtheta);
            dist = Math.Acos(dist);
            dist = dist * 180 / Math.PI;
            dist = dist * 60 * 1.1515 * 1.609344; // in kms

            return dist;
        }



    }
}
