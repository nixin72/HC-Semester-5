<?xml version="1.0" encoding="UTF-8"?>
<!--
	Author name: 	Philip Dumaresq
	Date:			11/10/2017
	Description:	
		Transform messier.xml into an XHTML document. 
-->

<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns="http://www.w3.org/1999/xhtml">
	<xsl:output method="html"/>
	
	<xsl:template match="/">
		<html>
			<head>
				<title>The Messier Objects</title>
				<link href="skyweb.css" rel="stylesheet" type="text/css" />
			</head>
			<body>
				<h1 id="logo"><img src="skyweb.jpg" alt="SkyWeb" /></h1>
			</body>
		</html>
	</xsl:template>
	
	<xsl:template match="data" >
		<div>
			<h2>
				<xsl:value-of select="name" /> 
				(<xsl:value-of select="@id"/>)
			</h2>
			<xsl:for-each select="description/p[1]">
				<p>
					<xsl:element name="img">
						<xsl:complexType>
							<xsl:attribute name="src" type="xs:string" >
								<xsl:value-of select="../../@id"/>
							</xsl:attribute>
						</xsl:complexType>
					</xsl:element>
				</p>
			</xsl:for-each>
			<xsl:apply-template select="data" />
		</div>
	</xsl:template>
	<xsl:template match="data">
		<table>
			<tr>
				<td>Distance (light years)</td>
				<td>Size (arc min)</td>
				<td>Magnitude</td>
				<td>Right Ascension</td>
				<td>Declination</td>
			</tr>
			<tr>
				<xsl:apply-template select="//object/data" />
			</tr>
		
		</table>
	</xsl:template>
	<xsl:template match="//object/data">
		<td><xsl:value-of select="distance" /></td>
		<td><xsl:value-of select="size" /></td>
		<td><xsl:value-of select="mag" /></td>
		<td><xsl:value-of select="ra" /></td>
		<td><xsl:value-of select="dec" /></td>	
	</xsl:template>
  
</xsl:stylesheet>