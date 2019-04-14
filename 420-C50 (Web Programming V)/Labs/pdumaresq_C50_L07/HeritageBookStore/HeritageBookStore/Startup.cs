using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(HeritageBookStore.Startup))]
namespace HeritageBookStore
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
