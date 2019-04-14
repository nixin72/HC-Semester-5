using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(L09_Client.Startup))]
namespace L09_Client
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
