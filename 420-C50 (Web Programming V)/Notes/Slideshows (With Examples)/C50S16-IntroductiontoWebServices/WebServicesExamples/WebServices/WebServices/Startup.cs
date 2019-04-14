using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(WebServices.Startup))]
namespace WebServices
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
