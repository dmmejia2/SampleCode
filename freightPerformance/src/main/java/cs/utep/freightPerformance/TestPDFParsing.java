package cs.utep.freightPerformance;

import java.io.IOException;
import java.text.ParseException;

public class TestPDFParsing {
	public static void main(String[] args) throws Exception {
		/* PDF Parsing */
		/** The original PDF that will be parsed. */
	    String PDFFileName = "/Users/danielmejia/Documents/workspace/freightPerformance/src/main/java/cs/utep/freightPerformance/Fiscal Year 2014 Financial Report (toll revenue).pdf";
	    //"Fiscal Year 2014 Financial Report (toll revenue).pdf";
	    ParsePDF pdfParser = new ParsePDF();
	    pdfParser.parsePdf(PDFFileName);
	    
	    System.out.println("toll revenue : " + pdfParser.tollrevenue);
	    
	    // Ysleta Bridge, El Paso, TX : ZAR
	    String urlYsletaBridge = "http://bcis.tamu.edu/request2.aspx?call=getMonthlyPerformanceIndicators&bridgeID@varchar=ZAR&timeFrom@varchar=01/01/2014%2000:00&timeTo@varchar=12/31/2014%2000:00"; 
	    ParseWebsite websiteParserYsletaBridge = new ParseWebsite();
	    websiteParserYsletaBridge.getHTML(urlYsletaBridge);
	    
	    // Bridge of America's : BOTA
	    String urlBridgeOfAmerica = "http://bcis.tamu.edu/request2.aspx?call=getMonthlyPerformanceIndicators&bridgeID@varchar=BOTA&timeFrom@varchar=01/01/2014%2000:00&timeTo@varchar=12/31/2014%2000:00"; 
	    ParseWebsite websiteParserBOA = new ParseWebsite();
	    websiteParserBOA.getHTML(urlBridgeOfAmerica);
	    
	    double co2EmissionValue = (0.008887*9360000);
	    System.out.println("CO2 emission : " + co2EmissionValue + " metric ton");
		/* PDF parsing complete */
    }
}
