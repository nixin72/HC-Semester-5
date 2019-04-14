using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Part_C {
    public partial class PartC : System.Web.UI.Page {
        protected void Page_PreRender(object sender, EventArgs e) {
            if (IsPostBack && Page.IsValid) {
                if (Page.IsValid) {
                    divResult.InnerText = "Hello " + txtFirstName.Text 
                        + ". You are currently " + txtAge.Text + " years old. You will turn 100 in " 
                        + (100-Int16.Parse(txtAge.Text)) + " years. I will email this report to "
                        + txtEmail.Text + ".";
                }
                else {
                    divResult.InnerText = "";
                }                
            }
        }        
    }
}