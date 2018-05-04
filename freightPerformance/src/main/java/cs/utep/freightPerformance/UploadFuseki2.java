package cs.utep.freightPerformance;



import java.io.InputStream;

import org.apache.jena.query.DatasetAccessor;
import org.apache.jena.query.DatasetAccessorFactory;


import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
public class UploadFuseki2 {
	public static void main(String[] args){
		
		
		
		String serviceURI = "http://localhost:3030/ds/data";
		DatasetAccessorFactory factory = null;
		DatasetAccessor accessor;
		accessor = factory.createHTTP(serviceURI);
		System.out.println("TEST");
		
		
		InputStream in = null;

		org.apache.jena.rdf.model.Model m = (org.apache.jena.rdf.model.Model) ModelFactory.createDefaultModel();
		String base = "FreightPerformancePopulate11a.rdf";
		m.read(in, base, "RDF/XML");
		accessor.putModel(m);
	}

}
