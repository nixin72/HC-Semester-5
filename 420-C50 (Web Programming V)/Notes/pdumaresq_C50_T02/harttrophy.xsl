<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" 
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" >
	
	<xsl:output method="html" />
	
	<xsl:template match="/" >
		<html>
			<head>
				<title>The Hart Trophy</title>
			</head>
			<body>
				<h1>Hart Trophy Winners</h1>
				
				<xsl:apply-templates select="//harttrophy" />
			</body>
		</html>
	</xsl:template>
	
	<xsl:template match="//harttrophy" >
		
		<table>
			<tbody>
				<tr>
					<th>Season</th>
					<th>Player</th>
					<th>Team</th>
					<th>Position</th>
				</tr>
			</tbody>
			<xsl:apply-templates select="winner" >
				<xsl:sort select="player" />
			</xsl:apply-templates>
		</table>
	</xsl:template>
	
	<xsl:template match="winner" >
		<tr>
			<xsl:if test="position() mod 2 = 0">
				<xsl:attribute name="bgcolor">gray</xsl:attribute>
			</xsl:if>
		
			<td><xsl:value-of select="season" /></td>
			<td><xsl:value-of select="player" /></td>
			<td><xsl:value-of select="team" /></td>
			<td>
				<xsl:choose>
					<xsl:when test="position = 'C'">Center</xsl:when>
					<xsl:when test="position = 'D'">Defense</xsl:when>
					<xsl:when test="position = 'G'">Goalie</xsl:when>
					<xsl:when test="position = 'RW'">Right Wing</xsl:when>
					<xsl:when test="position = 'LW'">Left Wing</xsl:when>
				</xsl:choose>
			</td>
		</tr>
		
	</xsl:template>
	
	
</xsl:stylesheet>
