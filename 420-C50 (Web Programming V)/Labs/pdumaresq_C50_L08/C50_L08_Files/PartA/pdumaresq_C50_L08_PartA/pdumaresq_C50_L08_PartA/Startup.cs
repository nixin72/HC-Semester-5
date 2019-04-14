using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(pdumaresq_C50_L08_PartA.Startup))]
namespace pdumaresq_C50_L08_PartA
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
