using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(pdumaresq_C50_A03.Startup))]
namespace pdumaresq_C50_A03
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
