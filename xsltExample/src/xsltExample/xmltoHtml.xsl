<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
  
  <h2>People's Details</h2>
  <table border="1">
    <tr bgcolor="#9acd32">
      <th>Gender</th>
      <th>FirstName</th>
      <th>LastName</th>
    </tr>
    <xsl:for-each select="people/person">
    <tr>
      <td><xsl:value-of select="gender"/></td>
      <td><xsl:value-of select="firstname"/></td>
      <td><xsl:value-of select="lastname"/></td>
      <td><xsl:value-of select="age"/></td>
    </tr>
    </xsl:for-each>
  </table>
  
</xsl:template>
</xsl:stylesheet>