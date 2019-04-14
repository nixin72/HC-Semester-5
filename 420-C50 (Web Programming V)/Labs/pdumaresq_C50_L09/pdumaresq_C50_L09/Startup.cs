using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(LoginApi.Startup))]
namespace LoginApi
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
