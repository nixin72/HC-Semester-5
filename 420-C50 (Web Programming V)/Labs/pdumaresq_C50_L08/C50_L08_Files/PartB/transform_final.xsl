<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html"/>
	<xsl:template match="/">
		<html>
			<head>
				<title>
					<xsl:value-of select="//summary/heading"/>
				</title>
			</head>
			<body style="font-family:Times New Roman">
				<xsl:apply-templates select="//summary"/>
				<xsl:for-each select="//region">
					<xsl:sort order="ascending"/>
					<p style="color:green;">
						<xsl:value-of select="name"/>
					</p>
					<xsl:for-each select="quarter">
						<p>Quarter: 
						<xsl:value-of select="@number"/>
						Sales: 
						<xsl:value-of select="format-number(@books_sold, '$###,###')" />
							<xsl:choose>
								<xsl:when test="@books_sold &gt; 30000">
									<span style="color:black;"> Fantastic!</span>
								</xsl:when>
								<xsl:when test="@books_sold &gt; 20000">
									<span style="color:blue;"> Very good!</span>
								</xsl:when>
								<xsl:otherwise>
									<span style="color:red;"> Needs to improve.</span>
								</xsl:otherwise>
							</xsl:choose>
						</p>
					</xsl:for-each>
					<p>Total sales for region: 
						<xsl:value-of select="format-number(sum(quarter/@books_sold),'$###,###')"/>
					</p>
				</xsl:for-each>
			</body>
		</html>
	</xsl:template>
	<xsl:template match="//summary">
		<h1>
			<xsl:value-of select="//summary/heading"/>
		</h1>
		<h2>
			<xsl:value-of select="//summary/subhead"/>
		</h2>
		<p>
			<xsl:value-of select="//summary/description"/>
		</p>
	</xsl:template>
</xsl:stylesheet>
