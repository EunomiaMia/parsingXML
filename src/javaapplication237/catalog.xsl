<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : catalog.xsl
    Created on : June 5, 2016, 8:37 PM
    Author     : Vanja
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
        <html>
            <head>
                <title>catalog.xsl</title>
            </head>
            <body>
                 <table border="1">
                <tr>
                    <td>Id</td>
                    <td>Author</td>
                    <td>Title</td>
                    <td>Genere</td>
                    <td>Price</td>
                    <td>Publish_date</td>
                    <td>Description</td>
                </tr>
                <xsl:for-each select="//book[price>10 and translate(publish_date, '-', '')> 20051231]">
                    <tr>
                        <td>
                            <xsl:apply-templates select="./@id"></xsl:apply-templates>
                        </td>
                        
                        <td>
                            <xsl:apply-templates select="./author"></xsl:apply-templates>
                        </td>
                        
                        <td>
                            <xsl:apply-templates select="./title"></xsl:apply-templates>
                        </td>
                        
                        <td>
                            <xsl:apply-templates select="./genre"></xsl:apply-templates>
                        </td>
                        
                        <td>
                            <xsl:apply-templates select="./price"></xsl:apply-templates>
                        </td>
                        
                        <td>
                            <xsl:apply-templates select="./publish_date"></xsl:apply-templates>
                        </td>
                        
                        <td>
                            <xsl:apply-templates select="./description"></xsl:apply-templates>
                        </td>
                    </tr>
                </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
