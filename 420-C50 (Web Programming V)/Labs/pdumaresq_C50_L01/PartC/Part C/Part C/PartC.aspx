<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="PartC.aspx.cs" Inherits="Part_C.PartC" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Part C</title>
</head>
<body>
    
    <form id="form1" runat="server">
        <asp:ValidationSummary runat="server" />
        <div>
            <asp:Label runat="server" ID="lblFirstName">First Name: </asp:Label>
                <asp:TextBox runat="server" ID="txtFirstName" />
                <asp:RequiredFieldValidator runat="server" 
                    ID="reqFirstName"
                    ControlToValidate="txtFirstName" 
                    Display="None" 
                    Text="*" 
                    ForeColor="Red"
                    ErrorMessage="Please enter a first name" />
                <asp:RegularExpressionValidator runat="server" 
                    ID="regFirstName"
                    ControlToValidate="txtFirstName"
                    Display="None"
                    Text="*" 
                    ForeColor="Red"
                    ErrorMessage="Please enter a valid first name" 
                    ValidationExpression="[a-zA-Z]+" />

            <br />
            <asp:Label runat="server" ID="lblAge">Age: </asp:Label>
                <asp:TextBox runat="server" ID="txtAge" />
                <asp:RequiredFieldValidator runat="server" 
                    ID="reqAge"
                    ControlToValidate="txtAge" 
                    Display="None" 
                    Text="*" 
                    ForeColor="Red"
                    ErrorMessage="Please enter an age" />
                <asp:CompareValidator runat="server" 
                    ID="comAge"
                    ControlToValidate="txtAge" 
                    Display="None"
                    Text="*" 
                    ForeColor="Red"
                    ErrorMessage="Please enter an age less than 100" 
                    ValueToCompare="100" 
                    Operator="GreaterThanEqual" />

            <br />
            <asp:Label runat="server" ID="lblEmail">Email Address: </asp:Label>
                <asp:TextBox runat="server" ID="txtEmail" />
                <asp:RequiredFieldValidator runat="server" 
                    ID="reqEmail"
                    ControlToValidate="txtEmail" 
                    Display="None" 
                    Text="*" 
                    ForeColor="Red"
                    ErrorMessage="Please enter an email address" />
                <asp:RegularExpressionValidator runat="server"
                    ID="regEmail" 
                    ControlToValidate="txtEmail" 
                    Display="None" 
                    Text="*" 
                    ForeColor="Red"
                    ErrorMessage="Please enter a valid email address" 
                    ValidationExpression="\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*" />

            <br />
            <asp:Button runat="server" ID="btnSubmit" Text="Submit" />
        </div>
    </form>
    <br />
    <div runat="server" id="divResult" ></div>

</body>
</html>
