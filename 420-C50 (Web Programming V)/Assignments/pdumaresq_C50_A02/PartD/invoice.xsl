<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
	version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns="http://www.w3.org/1999/xhtml">

	<xsl:output method="xml" indent="yes" encoding="UTF-8"/>

	<xsl:template match="/">
		<html>
			<head> 
				<title>Testing XML Example</title> 
				<link rel="stylesheet" type="text/css" href="invoice.css" />
			</head>
			<body>
				<h1>Acme Web Programmers Inc.</h1>
				<div class="stuff">
					<div>
						<div class="invoiceInfo" style="display: flex;">
							<div style="text-align: right; font-weight: bold;">
								Invoice Number:<br />
								date: 
							</div>
							<div style="text-align: left;">
								<xsl:value-of select="//info/@invoice_number" /><br />
								<xsl:value-of select="//info/invoice_date" />
							</div>
						</div>
						
						<div class="clientInfo">
							<div style="text-align: right; font-weight: bold;">
								Client: <br />
								Contact: <br />
								Address: <br />
							</div>
							<div style="text-align: left;">
								<xsl:value-of select="//client/Client_Name" />
									<br />
								<xsl:value-of select="//client/Contact_Firstname" /> 
								<xsl:text> </xsl:text>
								<xsl:value-of select="//client/Contact_Lastname" />
									<br />
								<xsl:value-of select="//client/Client_Street" />
									<br />
								<xsl:value-of select="//client/Client_City" />, <xsl:value-of select="//client/Client_Province" />
									<br />
								<xsl:value-of select="//client/Client_Postalcode" />
							</div>
						</div>
					</div>
					
					<div>
						<table class="table">	
							<thead>
								<th>Date</th>
								<th>Work Description</th>
								<th>Billed Hours</th>
							</thead>
							<xsl:apply-templates select="//work_record" >
								<xsl:sort select="work_date" order="ascending"></xsl:sort>
							</xsl:apply-templates>
						</table>
					</div>
				</div>
			</body>
		</html>
	</xsl:template>

	<xsl:template name="record" match="work_record" >
		<xsl:for-each select="." >
			<tr>
				<td><xsl:value-of select="work_date" /></td>
				<td><xsl:value-of select="work_description" /></td>
				<td><xsl:value-of select="billed_hours" /></td>			
			</tr>		
		</xsl:for-each>
	</xsl:template>
</xsl:stylesheet>