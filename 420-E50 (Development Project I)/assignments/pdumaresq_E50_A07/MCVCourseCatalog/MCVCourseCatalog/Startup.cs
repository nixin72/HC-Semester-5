using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(MCVCourseCatalog.Startup))]
namespace MCVCourseCatalog
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
