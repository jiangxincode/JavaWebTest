<xsl:transform xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="1.0">
	<xsl:variable name="nodes" select="//node" />
	<xsl:template match="list">
		<html>
			<body>
				<h1>名单</h1>
				<table cellpadding="5">
					<tr>
						<td>姓名</td>
						<td>博客</td>
					</tr>
					<xsl:for-each select="$nodes">
						<tr>
							<td>
								<xsl:value-of select="./name" />
								(
								<xsl:value-of select="./name/@alias" />
								)
							</td>
							<td>
								<xsl:value-of select="./space" />
							</td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:transform>