package cs.utep.freightPerformance;

import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

public class ParsePDF {

	public double tollrevenue;
    
    /**
     * Parses a PDF to a plain text file.
     * @param pdf the original PDF
     * @param txt the resulting text
     * @throws IOException
     * @throws ParseException 
     */
    public void parsePdf(String pdfFileName) throws IOException, ParseException {
        PdfReader reader = new PdfReader(pdfFileName);
        PdfReaderContentParser parser = new PdfReaderContentParser(reader);
        TextExtractionStrategy strategy;
        
        for (int i = 1; i <= reader.getNumberOfPages(); i++) {
            strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
            String str = strategy.getResultantText();
            
            String[] sentence = str.split("\\s+");
            int index = 0;
            for(String word: sentence)
            {
                if(word.equals("Chavez")){
                	int tempIndex = index + 1;
                	if(sentence[tempIndex].equals("Toll"))
                	{
                		tempIndex++;
                		if(sentence[tempIndex].equals("Revenue"))
                			tollrevenue = NumberFormat.getNumberInstance(Locale.US).parse(sentence[++tempIndex]).doubleValue();
                	    	//System.out.println("PDF data parsed : Toll Revenue = " + tollrevenue);
                	}
                }
                index++;
            }
        }
    }
}
