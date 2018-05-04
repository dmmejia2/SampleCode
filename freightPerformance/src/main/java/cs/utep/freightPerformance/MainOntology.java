package cs.utep.freightPerformance;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.vocab.OWL2Datatype;

import uk.ac.manchester.cs.owl.owlapi.OWL2DatatypeImpl;public class MainOntology {

	public static void main( String[] args )
	{


		String ontFile = "FreightPerformanceUpdate7.owl";

		String prefix = "http://anonymous.org/resource/";


		URI basePhysicalURI = URI.create(prefix + ontFile.replace("\\", "/"));
		prefix="http://anonymous.org/resource/#";
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();

		try {
			OWLOntology ontology = manager.createOntology(IRI.create(basePhysicalURI));
			OWLDataFactory factory = manager.getOWLDataFactory();
			OWLClass performanceMetricsClass = factory.getOWLClass(IRI.create(prefix+ "PerformanceMetrics"));//
			OWLAxiom performanceMetricsClassAxiom = factory.getOWLDeclarationAxiom(performanceMetricsClass);
			manager.addAxiom(ontology, performanceMetricsClassAxiom);

			OWLClass safetyClass = factory.getOWLClass(IRI.create(prefix + "Safety"));//
			OWLAxiom safetyClassAxiom = factory.getOWLDeclarationAxiom(safetyClass);
			manager.addAxiom(ontology, safetyClassAxiom);

			OWLClass trafficCongestionClass = factory.getOWLClass(IRI.create(prefix  + "TrafficCongestion"));
			OWLAxiom trafficCongestionClassAxiom = factory.getOWLDeclarationAxiom(trafficCongestionClass);
			manager.addAxiom(ontology, trafficCongestionClassAxiom);

			OWLClass environmentalSustainabilityClass = factory.getOWLClass(IRI.create(prefix  + "EnvironmentalSustainability"));
			OWLAxiom environmentalSustainabilityClassAxiom = factory.getOWLDeclarationAxiom(environmentalSustainabilityClass);
			manager.addAxiom(ontology, environmentalSustainabilityClassAxiom);

			OWLClass mobilityClass = factory.getOWLClass(IRI.create(prefix  + "Mobility"));
			OWLAxiom mobilityClassAxiom = factory.getOWLDeclarationAxiom(mobilityClass);
			manager.addAxiom(ontology, mobilityClassAxiom);
			// Is indicator 
			OWLClass incidentClass = factory.getOWLClass(IRI.create(prefix  + "Incident"));//
			OWLAxiom incidentClassAxiom = factory.getOWLDeclarationAxiom(incidentClass);
			manager.addAxiom(ontology, incidentClassAxiom);

			OWLClass fatalIncidentsClass = factory.getOWLClass(IRI.create(prefix  + "FatalIncidents"));//
			OWLAxiom fatalIncidentsClassAxiom = factory.getOWLDeclarationAxiom(fatalIncidentsClass);
			manager.addAxiom(ontology, fatalIncidentsClassAxiom);

			OWLClass weatherRelatedIncidentsClass = factory.getOWLClass(IRI.create(prefix  + "WeatherRelatedIncidents"));//
			OWLAxiom weatherRelatedIncidentsClassAxiom = factory.getOWLDeclarationAxiom(weatherRelatedIncidentsClass);
			manager.addAxiom(ontology, weatherRelatedIncidentsClassAxiom);

			OWLClass dailyWeatherMetricClass = factory.getOWLClass(IRI.create(prefix  + "DailyWeatherMetric"));//
			OWLAxiom dailyWeatherMetricClassAxiom = factory.getOWLDeclarationAxiom(dailyWeatherMetricClass);
			manager.addAxiom(ontology, dailyWeatherMetricClassAxiom);
/*
			OWLClass dailyTemperatureClass = factory.getOWLClass(IRI.create(prefix  + "DailyTemperatureMetric"));//
			OWLAxiom dailyTemperatureClassAxiom = factory.getOWLDeclarationAxiom(dailyTemperatureClass);
			manager.addAxiom(ontology, dailyTemperatureClassAxiom);

			OWLClass dailyPrecipitationClass = factory.getOWLClass(IRI.create(prefix  + "DailyPrecipitationMetric"));//
			OWLAxiom dailyPrecipitationClassAxiom = factory.getOWLDeclarationAxiom(dailyPrecipitationClass);
			manager.addAxiom(ontology, dailyPrecipitationClassAxiom);
*/
			OWLClass responseTimeToIncidentsClass = factory.getOWLClass(IRI.create(prefix  + "ResponseTimeToIncidents"));//
			OWLAxiom responseTimeToIncidentsClassAxiom = factory.getOWLDeclarationAxiom(responseTimeToIncidentsClass);
			manager.addAxiom(ontology, responseTimeToIncidentsClassAxiom);

			OWLClass delayCausedByIncidentsClass = factory.getOWLClass(IRI.create(prefix  + "DelayCausedByIncidents"));//
			OWLAxiom delayCausedByIncidentstClassAxiom = factory.getOWLDeclarationAxiom(delayCausedByIncidentsClass);
			manager.addAxiom(ontology, delayCausedByIncidentstClassAxiom);

			OWLClass evacuationClearenceTimeClass = factory.getOWLClass(IRI.create(prefix  + "EvacuationClearenceTime"));//
			OWLAxiom evacuationClearenceTimeClassAxiom = factory.getOWLDeclarationAxiom(evacuationClearenceTimeClass);
			manager.addAxiom(ontology, evacuationClearenceTimeClassAxiom);

			OWLClass comercialVehicleSafetyViolationsClass = factory.getOWLClass(IRI.create(prefix  + "ComercialVehicleSafetyViolations"));//
			OWLAxiom comercialVehicleSafetyViolationsClassAxiom = factory.getOWLDeclarationAxiom(comercialVehicleSafetyViolationsClass);
			manager.addAxiom(ontology, comercialVehicleSafetyViolationsClassAxiom);

			OWLClass securityForHighwayAndTransitClass = factory.getOWLClass(IRI.create(prefix  + "SecurityForHighwayAndTransit"));//
			OWLAxiom securityForHighwayAndTransitClassAxiom = factory.getOWLDeclarationAxiom(securityForHighwayAndTransitClass);
			manager.addAxiom(ontology, securityForHighwayAndTransitClassAxiom);

			OWLClass averagePeakHourDelayClass = factory.getOWLClass(IRI.create(prefix  + "AveragePeakHourDelay"));//
			OWLAxiom averagePeakHourDelayClassAxiom = factory.getOWLDeclarationAxiom(averagePeakHourDelayClass);
			manager.addAxiom(ontology, averagePeakHourDelayClassAxiom);

			OWLClass recurringDelayClass = factory.getOWLClass(IRI.create(prefix  + "RecurringDelay"));//
			OWLAxiom recurringDelayClassAxiom = factory.getOWLDeclarationAxiom(recurringDelayClass);
			manager.addAxiom(ontology, recurringDelayClassAxiom);

			OWLClass congestionTimeClass = factory.getOWLClass(IRI.create(prefix  + "CongestionTime"));//
			OWLAxiom congestionTimeClassAxiom = factory.getOWLDeclarationAxiom(congestionTimeClass);
			manager.addAxiom(ontology, congestionTimeClassAxiom);


			OWLClass congestionCostClass = factory.getOWLClass(IRI.create(prefix  + "CongestionCost"));//
			OWLAxiom congestionCostClassAxiom = factory.getOWLDeclarationAxiom(congestionCostClass);
			manager.addAxiom(ontology, congestionCostClassAxiom);

			OWLClass percentOfSystemCongestedClass = factory.getOWLClass(IRI.create(prefix  + "PercentOfSystemCongestedClass"));//
			OWLAxiom percentOfSystemCongestedClassAxiom = factory.getOWLDeclarationAxiom(percentOfSystemCongestedClass);
			manager.addAxiom(ontology, percentOfSystemCongestedClassAxiom);

			OWLClass percentOfTravelCongestedClass = factory.getOWLClass(IRI.create(prefix  + "PercentOfTravelCongested"));//
			OWLAxiom percentOfTravelCongestedClassAxiom = factory.getOWLDeclarationAxiom(percentOfTravelCongestedClass);
			manager.addAxiom(ontology, percentOfTravelCongestedClassAxiom);


			//Environmental Sustainability
			OWLClass gasEmissionClass = factory.getOWLClass(IRI.create(prefix  + "GasEmission"));//
			OWLAxiom gasEmissionClassAxiom = factory.getOWLDeclarationAxiom(gasEmissionClass);
			manager.addAxiom(ontology, gasEmissionClassAxiom);

			OWLClass fuelPriceClass = factory.getOWLClass(IRI.create(prefix  + "FuelPrice"));//
			OWLAxiom fuelPriceClassAxiom = factory.getOWLDeclarationAxiom(fuelPriceClass);
			manager.addAxiom(ontology, fuelPriceClassAxiom);

			OWLClass gasolinePriceClass = factory.getOWLClass(IRI.create(prefix  + "GasolinePrice"));//
			OWLAxiom gasolinePriceClassAxiom = factory.getOWLDeclarationAxiom(gasolinePriceClass);
			manager.addAxiom(ontology, gasolinePriceClassAxiom);

			OWLClass dieselPriceClass = factory.getOWLClass(IRI.create(prefix  + "DieselPrice"));//
			OWLAxiom dieselPriceClassAxiom = factory.getOWLDeclarationAxiom(dieselPriceClass);
			manager.addAxiom(ontology, dieselPriceClassAxiom);

			OWLClass cOSO2NOXEmissionClass = factory.getOWLClass(IRI.create(prefix  + "COSO2NOXEmmission"));//
			OWLAxiom cOSO2NOXEmissionClassAxiom = factory.getOWLDeclarationAxiom(cOSO2NOXEmissionClass);
			manager.addAxiom(ontology, cOSO2NOXEmissionClassAxiom);

			OWLClass cO2EmissionClass = factory.getOWLClass(IRI.create(prefix  + "CO2Emission"));//
			OWLAxiom cO2EmissionClassAxiom = factory.getOWLDeclarationAxiom(cO2EmissionClass);
			manager.addAxiom(ontology, cO2EmissionClassAxiom);

			OWLClass geographicalAreaClass = factory.getOWLClass(IRI.create(prefix  + "GeographicalArea"));//
			OWLAxiom geographicalAreaAxiom = factory.getOWLDeclarationAxiom(geographicalAreaClass);
			manager.addAxiom(ontology, geographicalAreaAxiom);

			OWLClass averageResponseTimeClass = factory.getOWLClass(IRI.create(prefix  + "AverageResponseTime"));//
			OWLAxiom averageResponseTimeAxiom = factory.getOWLDeclarationAxiom(averageResponseTimeClass);
			manager.addAxiom(ontology, averageResponseTimeAxiom);
			//Mobility
			OWLClass levelOfServiceClass = factory.getOWLClass(IRI.create(prefix  + "LevelOfService"));//
			OWLAxiom levelOfServiceClassAxiom = factory.getOWLDeclarationAxiom(levelOfServiceClass);
			manager.addAxiom(ontology, levelOfServiceClassAxiom);

			OWLClass densityClass = factory.getOWLClass(IRI.create(prefix  + "Density"));//
			OWLAxiom densityAxiom = factory.getOWLDeclarationAxiom(densityClass);
			manager.addAxiom(ontology, densityAxiom);

			OWLClass speedClass = factory.getOWLClass(IRI.create(prefix  + "Speed"));//
			OWLAxiom speedAxiom = factory.getOWLDeclarationAxiom(speedClass);
			manager.addAxiom(ontology, speedAxiom);

			OWLClass trafficVolumeClass = factory.getOWLClass(IRI.create(prefix  + "TrafficVolume"));//
			OWLAxiom trafficVolumeAxiom = factory.getOWLDeclarationAxiom(trafficVolumeClass);
			manager.addAxiom(ontology, trafficVolumeAxiom);

			OWLClass travelTimeClass = factory.getOWLClass(IRI.create(prefix  + "TravelTime"));//
			OWLAxiom travelTimeAxiom = factory.getOWLDeclarationAxiom(travelTimeClass);
			manager.addAxiom(ontology, travelTimeAxiom);

			OWLClass vehicleMilesTraveledClass = factory.getOWLClass(IRI.create(prefix  + "VehicleMilesTraveled"));//
			OWLAxiom vehicleMilesTraveledAxiom = factory.getOWLDeclarationAxiom(vehicleMilesTraveledClass);
			manager.addAxiom(ontology, vehicleMilesTraveledAxiom);

			OWLClass travelTimeReliabilityClass = factory.getOWLClass(IRI.create(prefix  + "TravelTimeReliability"));//
			OWLAxiom travelTimeReliabilityAxiom = factory.getOWLDeclarationAxiom(travelTimeReliabilityClass);
			manager.addAxiom(ontology, travelTimeReliabilityAxiom);

			OWLClass travelTimeIndexClass = factory.getOWLClass(IRI.create(prefix  + "TravelTimeIndex"));//
			OWLAxiom travelTimeIndexAxiom = factory.getOWLDeclarationAxiom(travelTimeIndexClass);
			manager.addAxiom(ontology, travelTimeIndexAxiom);

			OWLClass commuterStressIndexClass = factory.getOWLClass(IRI.create(prefix  + "CommuterStressIndex"));//
			OWLAxiom commuterStressIndexAxiom = factory.getOWLDeclarationAxiom(commuterStressIndexClass);
			manager.addAxiom(ontology, commuterStressIndexAxiom);

			OWLClass travelCostsClass = factory.getOWLClass(IRI.create(prefix  + "TravelCosts"));//
			OWLAxiom travelCostsAxiom = factory.getOWLDeclarationAxiom(travelCostsClass);
			manager.addAxiom(ontology, travelCostsAxiom);

			OWLClass portOfEntryClass = factory.getOWLClass(IRI.create(prefix  + "PortOfEntry"));//
			OWLAxiom portOfEntryAxiom = factory.getOWLDeclarationAxiom(portOfEntryClass);
			manager.addAxiom(ontology, portOfEntryAxiom);

			OWLClass ysletaPortOfEntryClass = factory.getOWLClass(IRI.create(prefix  + "ysletaPortOfEntry"));//
			OWLAxiom ysletaPortOfEntryAxiom = factory.getOWLDeclarationAxiom(ysletaPortOfEntryClass);
			manager.addAxiom(ontology, ysletaPortOfEntryAxiom);

			OWLClass americasPortOfEntryClass = factory.getOWLClass(IRI.create(prefix  + "americasPortOfEntry"));//
			OWLAxiom americasPortOfEntryAxiom = factory.getOWLDeclarationAxiom(americasPortOfEntryClass);
			manager.addAxiom(ontology, americasPortOfEntryAxiom);

			OWLClass tollRevenueClass = factory.getOWLClass(IRI.create(prefix  + "TollRevenue"));//
			OWLAxiom tollRevenueAxiom = factory.getOWLDeclarationAxiom(tollRevenueClass);
			manager.addAxiom(ontology, tollRevenueAxiom);

			OWLClass valueOfTimeClass = factory.getOWLClass(IRI.create(prefix  + "ValueOfTime"));//
			OWLAxiom valueOfTimeAxiom = factory.getOWLDeclarationAxiom(valueOfTimeClass);
			manager.addAxiom(ontology, valueOfTimeAxiom);

			OWLClass truckCommodityValueClass = factory.getOWLClass(IRI.create(prefix  + "TruckCommodityValue"));//
			OWLAxiom truckCommodityValueAxiom = factory.getOWLDeclarationAxiom(truckCommodityValueClass);
			manager.addAxiom(ontology, truckCommodityValueAxiom);

			OWLClass vehicleOccupancyClass = factory.getOWLClass(IRI.create(prefix  + "VehicleOccupancy"));//
			OWLAxiom vehicleOccupancyAxiom = factory.getOWLDeclarationAxiom(vehicleOccupancyClass);
			manager.addAxiom(ontology, vehicleOccupancyAxiom);


			
			
			//OwlDataProperties Class IDs
			OWLDataProperty hasIncidentId = factory.getOWLDataProperty(IRI.create(prefix  + "hasIncident.id"));
			OWLDataProperty hasFatalIncidentId = factory.getOWLDataProperty(IRI.create(prefix  + "hasFatalIncident.id"));
			OWLDataProperty hasWeatherRelatedIncidentsId = factory.getOWLDataProperty(IRI.create(prefix  + "hasWeatherRelatedIncidents.id"));
			OWLDataProperty hasDailyWeatherMetricsId = factory.getOWLDataProperty(IRI.create(prefix  + "hasDailyWeatherMetricsId.id"));
			OWLDataProperty hasDailyPrecipitationId = factory.getOWLDataProperty(IRI.create(prefix  + "hasDailyPrecipitationId.id"));
			OWLDataProperty hasDailyTemperatureId = factory.getOWLDataProperty(IRI.create(prefix  + "hasDailyTemperatureId.id"));
			OWLDataProperty hasGeographicalAreaId = factory.getOWLDataProperty(IRI.create(prefix  + "hasGeographicalArea.id"));
			OWLDataProperty hasAverageResponseTimeId = factory.getOWLDataProperty(IRI.create(prefix  + "hasAverageResponseTime.id"));
			OWLDataProperty hasResponseTimeToIncidentsId = factory.getOWLDataProperty(IRI.create(prefix  + "hasResponseTimeToIncidents.id"));
			OWLDataProperty hasAveragePeakHourDelayId = factory.getOWLDataProperty(IRI.create(prefix  + "hasAveragePeakHourDelay.id"));
			OWLDataProperty hasCongestionCostId = factory.getOWLDataProperty(IRI.create(prefix  + "hasCongestionCost.id"));
			OWLDataProperty hasCongestionTimeId = factory.getOWLDataProperty(IRI.create(prefix  + "hasCongestionTime.id"));
			OWLDataProperty hasPercentOfSystemCongestedId = factory.getOWLDataProperty(IRI.create(prefix  + "hasPercentOfSystemCongested.id"));
			OWLDataProperty hasPercentOfTravelCongestedId = factory.getOWLDataProperty(IRI.create(prefix  + "hasPercentOfTravelCongested.id"));
			OWLDataProperty hasGasEmissionId = factory.getOWLDataProperty(IRI.create(prefix  + "hasGasEmission.id"));
			OWLDataProperty hasGasolinePriceId = factory.getOWLDataProperty(IRI.create(prefix  + "hasGasolinePrice.id"));
			OWLDataProperty hasCOSO2NOXEmissionId = factory.getOWLDataProperty(IRI.create(prefix  + "hasCOSO2NOXEmission.id"));
			OWLDataProperty hasDieselPriceId = factory.getOWLDataProperty(IRI.create(prefix  + "hasDieselPrice.id"));
			OWLDataProperty hasFuelPriceId = factory.getOWLDataProperty(IRI.create(prefix  + "hasFuelPrice.id"));
			OWLDataProperty hasCO2EmissionId = factory.getOWLDataProperty(IRI.create(prefix  + "hasCO2Emission.id"));
			OWLDataProperty hasTrafficVolumeId = factory.getOWLDataProperty(IRI.create(prefix  + "hasTrafficVolume.id"));
			OWLDataProperty hasTravelTimeIndexId = factory.getOWLDataProperty(IRI.create(prefix  + "hasTravelTimeIndex.id"));
			OWLDataProperty hasCommuterStressIndexId = factory.getOWLDataProperty(IRI.create(prefix  + "hasCommuterStressIndex.id"));
			OWLDataProperty hasPOEId = factory.getOWLDataProperty(IRI.create(prefix  + "hasPOE.id"));
			OWLDataProperty hasPOEYsletaBridgeId = factory.getOWLDataProperty(IRI.create(prefix  + "hasPOEYsletaBridge.id"));
			OWLDataProperty hasPOEAmericasBridgeId = factory.getOWLDataProperty(IRI.create(prefix  + "hasPOEAmericasBridge.id"));
			OWLDataProperty hasTollRevenueId = factory.getOWLDataProperty(IRI.create(prefix  + "hasTollRevenue.id"));
			OWLDataProperty hasValueOfTimeId = factory.getOWLDataProperty(IRI.create(prefix  + "hasValueOfTime.id"));




			//OWLDataProperty		
			OWLDataProperty hasGeographicalAreaCity = factory.getOWLDataProperty(IRI.create(prefix  + "hasGeographicalArea.City"));
			OWLDataProperty hasGeographicalAreaState = factory.getOWLDataProperty(IRI.create(prefix  + "hasGeographicalArea.State"));
			OWLDataProperty hasIncidentMainStreet = factory.getOWLDataProperty(IRI.create(prefix  + "hasIncident.MainStreet"));
			OWLDataProperty hasIncidentSecondaryStreet = factory.getOWLDataProperty(IRI.create(prefix  + "hasIncident.SecondaryStreet"));
			OWLDataProperty hasIncidentCrashTime = factory.getOWLDataProperty(IRI.create(prefix  + "hasIncident.CrashTime"));
			OWLDataProperty hasAverageResponseTimeAverageValue = factory.getOWLDataProperty(IRI.create(prefix  + "hasAverageResponseTime.AverageValue"));
			OWLDataProperty hasAverageResponseTimeUnit = factory.getOWLDataProperty(IRI.create(prefix  + "hasAverageResponseTime.Unit"));
			OWLDataProperty hasAverageResponseTimeYear = factory.getOWLDataProperty(IRI.create(prefix  + "hasAverageResponseTime.Year"));
			OWLDataProperty hasWeatherConditionSurfaceCondition = factory.getOWLDataProperty(IRI.create(prefix  + "hasWeatherCondition.SurfaceCondition"));
			OWLDataProperty hasDailyWeatherPrecipitation = factory.getOWLDataProperty(IRI.create(prefix  + "hasDailyWeather.Precipitation"));
			OWLDataProperty hasDailyWeatherTemperature = factory.getOWLDataProperty(IRI.create(prefix  + "hasDailyWeather.Temperature"));
			OWLDataProperty hasDailyWeatherDate = factory.getOWLDataProperty(IRI.create(prefix  + "hasDailyWeather.Date"));
			OWLDataProperty hasWeatherConditionCrashFactors = factory.getOWLDataProperty(IRI.create(prefix  + "hasWeatherCondition.CrashFactors"));
			OWLDataProperty hasWeatherConditionID = factory.getOWLDataProperty(IRI.create(prefix  + "hasWeatherConditionID.ID"));
			OWLDataProperty hasResponseTimeToIncidentsUnit = factory.getOWLDataProperty(IRI.create(prefix  + "hasResponseTimeToIncidents.Unit"));
			OWLDataProperty hasResponseTimeToIncidentsArrivalTime = factory.getOWLDataProperty(IRI.create(prefix  + "hasResponseTimeToIncidents.ArrivalTime"));
			OWLDataProperty hasResponseTimeToIncidentsFinalResponseTime= factory.getOWLDataProperty(IRI.create(prefix  + "hasResponseTimeToIncidents.FinalResponseTime"));
			OWLDataProperty hasResponseTimeToIncidentsNotifyTime = factory.getOWLDataProperty(IRI.create(prefix  + "hasResponseTimeToIncidents.NotifyTime"));
			OWLDataProperty hasAveragePeakHourDelayAveragePeakYear = factory.getOWLDataProperty(IRI.create(prefix  + "hasAveragePeakHourDelay.AveragePeakYear"));
			OWLDataProperty hasCongestionCost = factory.getOWLDataProperty(IRI.create(prefix  + "hasCongestionCost"));
			OWLDataProperty hasCongestionTimeRushHours = factory.getOWLDataProperty(IRI.create(prefix  + "hasCongestionTime.RushHours"));
			OWLDataProperty hasPercentOfSystemCongested = factory.getOWLDataProperty(IRI.create(prefix  + "hasPercentOfSystemCongested"));
			OWLDataProperty hasPercentOfTravelCongested = factory.getOWLDataProperty(IRI.create(prefix  + "hasPercentOfTravelCongested"));
			OWLDataProperty hasDieselPriceValue = factory.getOWLDataProperty(IRI.create(prefix  + "hasDieselPrice.Value"));
			OWLDataProperty hasGasolinePriceValue = factory.getOWLDataProperty(IRI.create(prefix  + "hasGasolinePrice.Value"));
			OWLDataProperty hasGasEmissionValue = factory.getOWLDataProperty(IRI.create(prefix  + "hasGasEmmission.Value"));
			OWLDataProperty hasCO2EmissionGasolineGallons = factory.getOWLDataProperty(IRI.create(prefix  + "hasCO2Emission.GasolineGallons"));
			OWLDataProperty hasCO2EmissionEquivalent = factory.getOWLDataProperty(IRI.create(prefix  + "hasCO2Emission.Equivalent"));
			OWLDataProperty hasTrafficVolumeVolume = factory.getOWLDataProperty(IRI.create(prefix  + "hasTrafficVolume.Volume"));
			OWLDataProperty hasTrafficVolumeIntersectionStreet = factory.getOWLDataProperty(IRI.create(prefix  + "hasTrafficVolume.IntersectionStreet"));
			OWLDataProperty hasTrafficVolumePrimaryStreet = factory.getOWLDataProperty(IRI.create(prefix  + "hasTrafficVolume.PrimaryStreet"));
			OWLDataProperty hasTravelTimeIndexValue = factory.getOWLDataProperty(IRI.create(prefix  + "hasTravelTimeIndex.Value"));
			OWLDataProperty hasCommuterStressIndexValue = factory.getOWLDataProperty(IRI.create(prefix  + "hasCommuterStressIndex.Value"));
			OWLDataProperty hasPOEMinutes = factory.getOWLDataProperty(IRI.create(prefix  + "hasPOE.Minutes"));
			OWLDataProperty hasPOEMonth = factory.getOWLDataProperty(IRI.create(prefix  + "hasPOE.Month"));
			OWLDataProperty hasTollRevenueValue = factory.getOWLDataProperty(IRI.create(prefix  + "hasTollRevenue.Value"));
			OWLDataProperty hasValueOfTimeValue = factory.getOWLDataProperty(IRI.create(prefix  + "hasValueOfTime.Value"));




			OWLDatatype integerOwlDataType =  OWL2DatatypeImpl.getDatatype(OWL2Datatype.XSD_INTEGER);
			OWLDatatype doubleOwlDataType =  OWL2DatatypeImpl.getDatatype(OWL2Datatype.XSD_DOUBLE);
			OWLDatatype stringOwlDataType =  OWL2DatatypeImpl.getDatatype(OWL2Datatype.XSD_STRING);
			OWLDatatype dateOwlDataType =  OWL2DatatypeImpl.getDatatype(OWL2Datatype.XSD_DATE_TIME);

			//OwlDataPropertyRangeAxioms
			//Geographical
			OWLDataPropertyRangeAxiom hasGeographicalAreaCityAxiom = factory.getOWLDataPropertyRangeAxiom(hasGeographicalAreaCity, stringOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasGeographicalAreaCityAxiom));
			OWLDataPropertyRangeAxiom hasGeographicalAreaStateAxiom = factory.getOWLDataPropertyRangeAxiom(hasGeographicalAreaState, stringOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasGeographicalAreaStateAxiom));		
			OWLDataPropertyRangeAxiom hasGeographicalAreaIdAxiom = factory.getOWLDataPropertyRangeAxiom(hasGeographicalAreaId, integerOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasGeographicalAreaIdAxiom));

			//Weather
			OWLDataPropertyRangeAxiom hasDailyWeatherMetricsIdAxiom = factory.getOWLDataPropertyRangeAxiom(hasDailyWeatherMetricsId, integerOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasDailyWeatherMetricsIdAxiom));
			OWLDataPropertyRangeAxiom hasDailyPrecipitationIdAxiom = factory.getOWLDataPropertyRangeAxiom(hasDailyPrecipitationId, integerOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasDailyPrecipitationIdAxiom));
			OWLDataPropertyRangeAxiom hasDailyTemperatureIdAxiom = factory.getOWLDataPropertyRangeAxiom(hasDailyTemperatureId, integerOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasDailyTemperatureIdAxiom));
			OWLDataPropertyRangeAxiom hasDailyWeatherPrecipitationAxiom = factory.getOWLDataPropertyRangeAxiom(hasDailyWeatherPrecipitation, doubleOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasDailyWeatherPrecipitationAxiom));
			OWLDataPropertyRangeAxiom hasDailyWeatherDateAxiom = factory.getOWLDataPropertyRangeAxiom(hasDailyWeatherDate, dateOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasDailyWeatherDateAxiom));
			OWLDataPropertyRangeAxiom hasDailyWeatherTemperatureAxiom = factory.getOWLDataPropertyRangeAxiom(hasDailyWeatherTemperature, doubleOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasDailyWeatherTemperatureAxiom));


			OWLDataPropertyRangeAxiom hasIncidentMainStreetAxiom = factory.getOWLDataPropertyRangeAxiom(hasIncidentMainStreet, stringOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasIncidentMainStreetAxiom));
			OWLDataPropertyRangeAxiom hasIncidentSecondaryStreetAxiom = factory.getOWLDataPropertyRangeAxiom(hasIncidentSecondaryStreet, stringOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasIncidentSecondaryStreetAxiom));
			OWLDataPropertyRangeAxiom hasIncidentCrashTimeAxiom = factory.getOWLDataPropertyRangeAxiom(hasIncidentCrashTime, dateOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasIncidentCrashTimeAxiom));
			OWLDataPropertyRangeAxiom hasIncidentIdAxiom = factory.getOWLDataPropertyRangeAxiom(hasIncidentId, integerOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasIncidentIdAxiom));

			OWLDataPropertyRangeAxiom hasAverageResponseTimeAverageValueAxiom = factory.getOWLDataPropertyRangeAxiom(hasAverageResponseTimeAverageValue, doubleOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasAverageResponseTimeAverageValueAxiom));
			OWLDataPropertyRangeAxiom hasAverageResponseTimeUnitAxiom = factory.getOWLDataPropertyRangeAxiom(hasAverageResponseTimeUnit, dateOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasAverageResponseTimeUnitAxiom));
			OWLDataPropertyRangeAxiom hasAverageResponseTimeYearAxiom = factory.getOWLDataPropertyRangeAxiom(hasAverageResponseTimeYear, integerOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasAverageResponseTimeYearAxiom));
			OWLDataPropertyRangeAxiom hasAverageResponseTimeIdAxiom = factory.getOWLDataPropertyRangeAxiom(hasAverageResponseTimeId, integerOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasAverageResponseTimeIdAxiom));

			OWLDataPropertyRangeAxiom hasFatalIncidentIdAxiom = factory.getOWLDataPropertyRangeAxiom(hasFatalIncidentId, integerOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasFatalIncidentIdAxiom));

			OWLDataPropertyRangeAxiom hasWeatherRelatedIncidentsIdAxiom = factory.getOWLDataPropertyRangeAxiom(hasWeatherRelatedIncidentsId, integerOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasWeatherRelatedIncidentsIdAxiom));
			OWLDataPropertyRangeAxiom hasWeatherConditionSurfaceConditionAxiom = factory.getOWLDataPropertyRangeAxiom(hasWeatherConditionSurfaceCondition, stringOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasWeatherConditionSurfaceConditionAxiom));
			OWLDataPropertyRangeAxiom hasWeatherConditionCrashFactorsAxiom = factory.getOWLDataPropertyRangeAxiom(hasWeatherConditionCrashFactors, stringOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasWeatherConditionCrashFactorsAxiom));
			OWLDataPropertyRangeAxiom hasWeatherConditionIDAxiom = factory.getOWLDataPropertyRangeAxiom(hasWeatherConditionID, stringOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasWeatherConditionIDAxiom));

			OWLDataPropertyRangeAxiom hasResponseTimeToIncidentsUnitAxiom = factory.getOWLDataPropertyRangeAxiom(hasResponseTimeToIncidentsUnit, stringOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasResponseTimeToIncidentsUnitAxiom));
			OWLDataPropertyRangeAxiom hasResponseTimeToIncidentsArrivalTimeAxiom = factory.getOWLDataPropertyRangeAxiom(hasResponseTimeToIncidentsArrivalTime, dateOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasResponseTimeToIncidentsArrivalTimeAxiom));
			OWLDataPropertyRangeAxiom hasResponseTimeToIncidentsNotifyTimeAxiom = factory.getOWLDataPropertyRangeAxiom(hasResponseTimeToIncidentsNotifyTime, dateOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasResponseTimeToIncidentsNotifyTimeAxiom));
			OWLDataPropertyRangeAxiom hasResponseTimeToIncidentsIdAxiom = factory.getOWLDataPropertyRangeAxiom(hasResponseTimeToIncidentsId,integerOwlDataType );
			manager.applyChange(new AddAxiom(ontology,hasResponseTimeToIncidentsIdAxiom));

			//This could be as an int but since the calculations where done on exel then we are just getting the results then String is good enough
			OWLDataPropertyRangeAxiom hasResponseTimeToIncidentsFinalResponseTimeAxiom = factory.getOWLDataPropertyRangeAxiom(hasResponseTimeToIncidentsFinalResponseTime, stringOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasResponseTimeToIncidentsFinalResponseTimeAxiom));

			OWLDataPropertyRangeAxiom hasAveragePeakHourDelayAveragePeakYearAxiom = factory.getOWLDataPropertyRangeAxiom(hasAveragePeakHourDelayAveragePeakYear, integerOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasAveragePeakHourDelayAveragePeakYearAxiom));
			OWLDataPropertyRangeAxiom hasAveragePeakHourDelayIdAxiom = factory.getOWLDataPropertyRangeAxiom(hasAveragePeakHourDelayId,integerOwlDataType);//
			manager.applyChange(new AddAxiom(ontology,hasAveragePeakHourDelayIdAxiom));

			OWLDataPropertyRangeAxiom hasCongestionCostIdAxiom = factory.getOWLDataPropertyRangeAxiom(hasCongestionCostId, integerOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasCongestionCostIdAxiom));
			OWLDataPropertyRangeAxiom hasCongestionCostAxiom = factory.getOWLDataPropertyRangeAxiom(hasCongestionCost, integerOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasCongestionCostAxiom));

			OWLDataPropertyRangeAxiom hasCongestionTimeIdAxiom = factory.getOWLDataPropertyRangeAxiom(hasCongestionTimeId, integerOwlDataType );
			manager.applyChange(new AddAxiom(ontology,hasCongestionTimeIdAxiom));
			OWLDataPropertyRangeAxiom hasCongestionTimeRushHoursAxiom = factory.getOWLDataPropertyRangeAxiom(hasCongestionTimeRushHours, doubleOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasCongestionTimeRushHoursAxiom));

			OWLDataPropertyRangeAxiom hasPercentOfSystemCongestedAxiom = factory.getOWLDataPropertyRangeAxiom(hasPercentOfSystemCongested, doubleOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasPercentOfSystemCongestedAxiom));
			OWLDataPropertyRangeAxiom hasPercentOfSystemCongestedIdAxiom = factory.getOWLDataPropertyRangeAxiom(hasPercentOfSystemCongestedId, integerOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasPercentOfSystemCongestedIdAxiom));

			OWLDataPropertyRangeAxiom hasPercentOfTravelCongestedAxiom = factory.getOWLDataPropertyRangeAxiom(hasPercentOfTravelCongested, doubleOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasPercentOfTravelCongestedAxiom));
			OWLDataPropertyRangeAxiom hasPercentOfTravelCongestedIdAxoim = factory.getOWLDataPropertyRangeAxiom(hasPercentOfTravelCongestedId, integerOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasPercentOfTravelCongestedIdAxoim));

			OWLDataPropertyRangeAxiom hasGasEmmissionIdAxiom = factory.getOWLDataPropertyRangeAxiom(hasGasEmissionId, integerOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasGasEmmissionIdAxiom));
			OWLDataPropertyRangeAxiom hasGasEmmissionValueAxiom = factory.getOWLDataPropertyRangeAxiom(hasGasEmissionValue, doubleOwlDataType );
			manager.applyChange(new AddAxiom(ontology,hasGasEmmissionValueAxiom));


			OWLDataPropertyRangeAxiom hasCO2EmissionGasolineGallonsAxiom = factory.getOWLDataPropertyRangeAxiom(hasCO2EmissionGasolineGallons, doubleOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasCO2EmissionGasolineGallonsAxiom));
			OWLDataPropertyRangeAxiom hasCO2EmissionEquivalentAxiom = factory.getOWLDataPropertyRangeAxiom(hasCO2EmissionEquivalent, doubleOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasCO2EmissionEquivalentAxiom));
			OWLDataPropertyRangeAxiom hasCO2EmissionIdAxiom = factory.getOWLDataPropertyRangeAxiom(hasCO2EmissionId, integerOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasCO2EmissionIdAxiom));

			OWLDataPropertyRangeAxiom hasGasolinePriceIdAxiom = factory.getOWLDataPropertyRangeAxiom(hasGasolinePriceId, integerOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasGasolinePriceIdAxiom));
			OWLDataPropertyRangeAxiom hasGasolinePriceValueAxiom = factory.getOWLDataPropertyRangeAxiom(hasGasolinePriceValue, doubleOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasGasolinePriceValueAxiom));

			OWLDataPropertyRangeAxiom hasDieselPriceIdAxiom= factory.getOWLDataPropertyRangeAxiom(hasDieselPriceId, integerOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasDieselPriceIdAxiom));
			OWLDataPropertyRangeAxiom hasDieselPriceValueAxiom= factory.getOWLDataPropertyRangeAxiom(hasDieselPriceValue, doubleOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasDieselPriceValueAxiom));

			OWLDataPropertyRangeAxiom hasTrafficVolumeVolumeAxiom= factory.getOWLDataPropertyRangeAxiom(hasTrafficVolumeVolume, integerOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasTrafficVolumeVolumeAxiom));
			OWLDataPropertyRangeAxiom hasTrafficVolumeIntersectionStreetAxiom= factory.getOWLDataPropertyRangeAxiom(hasTrafficVolumeIntersectionStreet, stringOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasTrafficVolumeIntersectionStreetAxiom));
			OWLDataPropertyRangeAxiom hasTrafficVolumePrimaryStreetAxiom= factory.getOWLDataPropertyRangeAxiom(hasTrafficVolumePrimaryStreet, stringOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasTrafficVolumePrimaryStreetAxiom));
			OWLDataPropertyRangeAxiom hasTrafficVolumeIdAxiom= factory.getOWLDataPropertyRangeAxiom(hasTrafficVolumeId, integerOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasTrafficVolumeIdAxiom));

			OWLDataPropertyRangeAxiom hasTravelTimeIndexValueAxiom= factory.getOWLDataPropertyRangeAxiom(hasTravelTimeIndexValue, doubleOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasTravelTimeIndexValueAxiom));
			OWLDataPropertyRangeAxiom hasTravelTimeIndexIdAxiom= factory.getOWLDataPropertyRangeAxiom(hasTravelTimeIndexId, integerOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasTravelTimeIndexIdAxiom));

			OWLDataPropertyRangeAxiom hasCommuterStressIndexIdAxiom= factory.getOWLDataPropertyRangeAxiom(hasCommuterStressIndexId, integerOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasCommuterStressIndexIdAxiom));
			OWLDataPropertyRangeAxiom hasCommuterStressIndexValueAxiom= factory.getOWLDataPropertyRangeAxiom(hasCommuterStressIndexValue, doubleOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasCommuterStressIndexValueAxiom));

			OWLDataPropertyRangeAxiom hasPOEMinutesAxiom= factory.getOWLDataPropertyRangeAxiom(hasPOEMinutes, integerOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasPOEMinutesAxiom));

			OWLDataPropertyRangeAxiom hasPOEMonthAxiom= factory.getOWLDataPropertyRangeAxiom(hasPOEMonth, dateOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasPOEMonthAxiom));

			OWLDataPropertyRangeAxiom hasPOEIdAxiom= factory.getOWLDataPropertyRangeAxiom(hasPOEId, integerOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasPOEIdAxiom));

			OWLDataPropertyRangeAxiom hasPOEYsletaBridgeIdAxiom= factory.getOWLDataPropertyRangeAxiom(hasPOEYsletaBridgeId, integerOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasPOEYsletaBridgeIdAxiom));

			OWLDataPropertyRangeAxiom hasPOEAmericasBridgeIdAxiom= factory.getOWLDataPropertyRangeAxiom(hasPOEAmericasBridgeId, integerOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasPOEAmericasBridgeIdAxiom));

			OWLDataPropertyRangeAxiom hasTollRevenueValueAxiom= factory.getOWLDataPropertyRangeAxiom(hasTollRevenueValue, doubleOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasTollRevenueValueAxiom));
			OWLDataPropertyRangeAxiom hasTollRevenueIdAxiom= factory.getOWLDataPropertyRangeAxiom(hasTollRevenueId, integerOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasTollRevenueIdAxiom));

			OWLDataPropertyRangeAxiom hasValueOfTimeIdAxiom= factory.getOWLDataPropertyRangeAxiom(hasValueOfTimeId, integerOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasValueOfTimeIdAxiom));
			OWLDataPropertyRangeAxiom hasValueOfTimeValueAxiom= factory.getOWLDataPropertyRangeAxiom(hasValueOfTimeValue, doubleOwlDataType);
			manager.applyChange(new AddAxiom(ontology,hasValueOfTimeValueAxiom));








			//Adding Object Property coversArea
			//CoversArea Object Property
			OWLObjectProperty isPartOfObjectProperty = factory.getOWLObjectProperty(IRI.create(prefix  + "isPartOf"));
			OWLObjectProperty isIndicatorOfObjectProperty = factory.getOWLObjectProperty(IRI.create(prefix  + "isIndicatorOf"));
			//OWLObjectProperty isTypeOfObjectProperty = factory.getOWLObjectProperty(IRI.create(prefix  + "isTypeOf"));
			OWLObjectProperty timeCausedByObjectProperty = factory.getOWLObjectProperty(IRI.create(prefix  + "TimeCausedBy"));
			OWLObjectProperty causeObjectProperty = factory.getOWLObjectProperty(IRI.create(prefix  + "cause"));
			OWLObjectProperty affectsObjectProperty = factory.getOWLObjectProperty(IRI.create(prefix  + "affects"));
			OWLObjectProperty calculatesObjectProperty = factory.getOWLObjectProperty(IRI.create(prefix  + "Calculates"));
			OWLObjectProperty usesObjectProperty = factory.getOWLObjectProperty(IRI.create(prefix  + "uses"));
			OWLObjectProperty multiplyByLengthObjectProperty = factory.getOWLObjectProperty(IRI.create(prefix  + "multiplyByLength"));
			OWLObjectProperty costOfObjectProperty = factory.getOWLObjectProperty(IRI.create(prefix  + "costOf"));
			OWLObjectProperty coversAreaObjectProperty = factory.getOWLObjectProperty(IRI.create(prefix  + "coversArea"));


			//Coverse Area
			//Safety
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyRangeAxiom(coversAreaObjectProperty, geographicalAreaClass)));		
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(coversAreaObjectProperty, incidentClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(coversAreaObjectProperty, weatherRelatedIncidentsClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(coversAreaObjectProperty, responseTimeToIncidentsClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(coversAreaObjectProperty, delayCausedByIncidentsClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(coversAreaObjectProperty, evacuationClearenceTimeClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(coversAreaObjectProperty, comercialVehicleSafetyViolationsClass)));





			//Traffic Congestion
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(coversAreaObjectProperty, averagePeakHourDelayClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(coversAreaObjectProperty, recurringDelayClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(coversAreaObjectProperty, congestionCostClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(coversAreaObjectProperty, congestionTimeClass)));		
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(coversAreaObjectProperty, percentOfSystemCongestedClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(coversAreaObjectProperty, percentOfTravelCongestedClass)));		
			//Environmental Sustainability
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(coversAreaObjectProperty, gasEmissionClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(coversAreaObjectProperty, gasolinePriceClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(coversAreaObjectProperty, dieselPriceClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(coversAreaObjectProperty, cO2EmissionClass)));
			//Mobility
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(coversAreaObjectProperty, levelOfServiceClass)));	
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(coversAreaObjectProperty, densityClass)));		
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(coversAreaObjectProperty, speedClass)));		
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(coversAreaObjectProperty, trafficVolumeClass)));		
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(coversAreaObjectProperty, travelTimeClass)));	
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(coversAreaObjectProperty, vehicleMilesTraveledClass)));		
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(coversAreaObjectProperty, travelTimeReliabilityClass)));		
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(coversAreaObjectProperty, travelTimeIndexClass)));		
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(coversAreaObjectProperty, commuterStressIndexClass)));		
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(coversAreaObjectProperty, travelCostsClass)));	
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(coversAreaObjectProperty, portOfEntryClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(coversAreaObjectProperty, tollRevenueClass)));		
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(coversAreaObjectProperty, valueOfTimeClass)));		


			//OWLDataPropertyDomainAxiom 
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasGeographicalAreaCity, geographicalAreaClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasGeographicalAreaState, geographicalAreaClass)));		
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasGeographicalAreaId, geographicalAreaClass)));		
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasIncidentId, incidentClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasIncidentMainStreet, incidentClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasIncidentSecondaryStreet, incidentClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasIncidentCrashTime, incidentClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasAverageResponseTimeAverageValue, averageResponseTimeClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasAverageResponseTimeUnit, averageResponseTimeClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasAverageResponseTimeYear, averageResponseTimeClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasAverageResponseTimeId, averageResponseTimeClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasWeatherConditionSurfaceCondition, weatherRelatedIncidentsClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasWeatherConditionCrashFactors, weatherRelatedIncidentsClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasWeatherRelatedIncidentsId, weatherRelatedIncidentsClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasResponseTimeToIncidentsUnit, responseTimeToIncidentsClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasResponseTimeToIncidentsArrivalTime, responseTimeToIncidentsClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasResponseTimeToIncidentsFinalResponseTime, responseTimeToIncidentsClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasResponseTimeToIncidentsNotifyTime, responseTimeToIncidentsClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasResponseTimeToIncidentsId, responseTimeToIncidentsClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasAveragePeakHourDelayAveragePeakYear, averagePeakHourDelayClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasAveragePeakHourDelayId, averagePeakHourDelayClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasCongestionCost,congestionCostClass )));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasCongestionTimeRushHours, congestionCostClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasPercentOfSystemCongested,percentOfSystemCongestedClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasPercentOfSystemCongestedId, percentOfSystemCongestedClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasPercentOfTravelCongestedId, percentOfTravelCongestedClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasPercentOfTravelCongested,percentOfTravelCongestedClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasDieselPriceValue,dieselPriceClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasDieselPriceId,dieselPriceClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasGasolinePriceValue,gasolinePriceClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasGasolinePriceId,gasolinePriceClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasCO2EmissionGasolineGallons,cO2EmissionClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasCO2EmissionEquivalent,cO2EmissionClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasCO2EmissionId,cO2EmissionClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasTrafficVolumeVolume,trafficVolumeClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasTrafficVolumeIntersectionStreet,trafficVolumeClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasTrafficVolumePrimaryStreet,trafficVolumeClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasTrafficVolumeId,trafficVolumeClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasTravelTimeIndexValue,travelTimeIndexClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasTravelTimeIndexId,travelTimeIndexClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasPOEMinutes,portOfEntryClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasPOEId,portOfEntryClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasPOEYsletaBridgeId,ysletaPortOfEntryClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasPOEAmericasBridgeId,americasPortOfEntryClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasTollRevenueValue,tollRevenueClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasTollRevenueId,tollRevenueClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasValueOfTimeValue,valueOfTimeClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasValueOfTimeId,valueOfTimeClass)));


			//Is Part Of
			//Safety
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyRangeAxiom(isPartOfObjectProperty, performanceMetricsClass)));		
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isPartOfObjectProperty, safetyClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isPartOfObjectProperty, trafficCongestionClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isPartOfObjectProperty, environmentalSustainabilityClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isPartOfObjectProperty, mobilityClass)));
			//Traffic Congestion
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyRangeAxiom(isPartOfObjectProperty, recurringDelayClass)));		
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isPartOfObjectProperty, averagePeakHourDelayClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyRangeAxiom(isPartOfObjectProperty, congestionCostClass)));		
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isPartOfObjectProperty, congestionTimeClass)));
			//Mobility
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyRangeAxiom(isPartOfObjectProperty, travelTimeClass)));		
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isPartOfObjectProperty, travelCostsClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyRangeAxiom(isPartOfObjectProperty, travelCostsClass)));	
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isPartOfObjectProperty, travelTimeClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isPartOfObjectProperty, portOfEntryClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isPartOfObjectProperty, tollRevenueClass)));

			//Is Indicator Of
			//Safety
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyRangeAxiom(isIndicatorOfObjectProperty, safetyClass)));		
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isIndicatorOfObjectProperty, incidentClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isIndicatorOfObjectProperty, fatalIncidentsClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isIndicatorOfObjectProperty, weatherRelatedIncidentsClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isIndicatorOfObjectProperty, responseTimeToIncidentsClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isIndicatorOfObjectProperty, delayCausedByIncidentsClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isIndicatorOfObjectProperty, evacuationClearenceTimeClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isIndicatorOfObjectProperty, comercialVehicleSafetyViolationsClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isIndicatorOfObjectProperty, securityForHighwayAndTransitClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isIndicatorOfObjectProperty, dailyWeatherMetricClass)));
			//manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isIndicatorOfObjectProperty, dailyTemperatureClass)));
			//manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isIndicatorOfObjectProperty, dailyPrecipitationClass)));



			//Traffic Congestion
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyRangeAxiom(isIndicatorOfObjectProperty, trafficCongestionClass)));		
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isIndicatorOfObjectProperty, averagePeakHourDelayClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isIndicatorOfObjectProperty, recurringDelayClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isIndicatorOfObjectProperty, congestionCostClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isIndicatorOfObjectProperty, congestionTimeClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isIndicatorOfObjectProperty, percentOfSystemCongestedClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isIndicatorOfObjectProperty, percentOfTravelCongestedClass)));
			//Environmental Sustainability
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyRangeAxiom(isIndicatorOfObjectProperty, environmentalSustainabilityClass)));		
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isIndicatorOfObjectProperty, gasEmissionClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isIndicatorOfObjectProperty, fuelPriceClass)));
			//Mobility
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyRangeAxiom(isIndicatorOfObjectProperty, mobilityClass)));		
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isIndicatorOfObjectProperty, levelOfServiceClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isIndicatorOfObjectProperty, densityClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isIndicatorOfObjectProperty, speedClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isIndicatorOfObjectProperty, trafficVolumeClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isIndicatorOfObjectProperty, travelTimeClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isIndicatorOfObjectProperty, vehicleMilesTraveledClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isIndicatorOfObjectProperty, travelTimeReliabilityClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isIndicatorOfObjectProperty, travelTimeIndexClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isIndicatorOfObjectProperty, commuterStressIndexClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isIndicatorOfObjectProperty, travelCostsClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isIndicatorOfObjectProperty, portOfEntryClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isIndicatorOfObjectProperty, tollRevenueClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(isIndicatorOfObjectProperty, valueOfTimeClass)));

			//Time Caused by
			//Safety
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyRangeAxiom(timeCausedByObjectProperty, incidentClass)));		
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(timeCausedByObjectProperty, responseTimeToIncidentsClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(timeCausedByObjectProperty, evacuationClearenceTimeClass)));

			//Cause
			//Safety
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyRangeAxiom(causeObjectProperty, delayCausedByIncidentsClass)));		
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(causeObjectProperty, incidentClass)));





			//SubClass Of
			manager.applyChange(new AddAxiom(ontology,factory.getOWLSubClassOfAxiom(fatalIncidentsClass,incidentClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLSubClassOfAxiom(weatherRelatedIncidentsClass,incidentClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLSubClassOfAxiom(cO2EmissionClass,gasEmissionClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLSubClassOfAxiom(cOSO2NOXEmissionClass,gasEmissionClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLSubClassOfAxiom(americasPortOfEntryClass,portOfEntryClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLSubClassOfAxiom(ysletaPortOfEntryClass,portOfEntryClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLSubClassOfAxiom(truckCommodityValueClass,mobilityClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLSubClassOfAxiom(vehicleOccupancyClass,mobilityClass)));
			//manager.applyChange(new AddAxiom(ontology,factory.getOWLSubClassOfAxiom(dailyTemperatureClass,dailyWeatherMetricClass)));
			//manager.applyChange(new AddAxiom(ontology,factory.getOWLSubClassOfAxiom(dailyPrecipitationClass,dailyWeatherMetricClass)));





			//Affects 
			//Environmental Sustainability
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyRangeAxiom(affectsObjectProperty, gasEmissionClass)));		
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(affectsObjectProperty, gasolinePriceClass)));
			//Mobility
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyRangeAxiom(affectsObjectProperty, tollRevenueClass)));		
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(affectsObjectProperty, trafficVolumeClass)));


			//Calculates
			//Mobility
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyRangeAxiom(calculatesObjectProperty, levelOfServiceClass)));		
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(calculatesObjectProperty, trafficVolumeClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(calculatesObjectProperty, travelTimeClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(calculatesObjectProperty, densityClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyRangeAxiom(calculatesObjectProperty, travelTimeReliabilityClass)));		
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyRangeAxiom(calculatesObjectProperty, travelTimeIndexClass)));		
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyRangeAxiom(calculatesObjectProperty, commuterStressIndexClass)));		

			//Uses
			//Mobility
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyRangeAxiom(usesObjectProperty, speedClass)));		
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(usesObjectProperty, levelOfServiceClass)));

			//Multiply by length
			//Mobility
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyRangeAxiom(multiplyByLengthObjectProperty, vehicleMilesTraveledClass)));		
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(multiplyByLengthObjectProperty, trafficVolumeClass)));

			//Cost Of
			//Mobility
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyRangeAxiom(costOfObjectProperty, travelTimeClass)));		
			manager.applyChange(new AddAxiom(ontology,factory.getOWLObjectPropertyDomainAxiom(costOfObjectProperty, valueOfTimeClass)));

			/**
			 * 
			 */
			try
			{
				int weatherIssues=0;
				int deathCount=0;
				double startTime=0.0;
				double endTime=0.0;
				double totalTime=0.0;
				double averageTime=0.0;
				double incidentCount=0.0;
				String csvFile = "/Users/danielmejia/Documents/workspace/freightPerformance/src/main/java/cs/utep/freightPerformance/cmv 2014 incidents.csv";
				String currentLine = "";
				BufferedReader reader = new BufferedReader(new FileReader(csvFile));
				List<String []> dataList = new ArrayList<String []>();
				//FileInputStream file = new FileInputStream(new File("C:\\Users\\dmmej_000\\workspace\\owlapitest2\\src\\main\\java\\cs\\utep\\owlapitest2\\cmv 2014 incidents.csv"));
				while((currentLine = reader.readLine())!=null){
					//System.out.println(currentLine);


					String [] items = currentLine.split(",");
					dataList.add(items);

				}
				List<Object []> indexList = new ArrayList<Object []>();
				for(int i=0;i<dataList.get(0).length;i++){
					//System.out.println("COLUMN NAME: "+dataList.get(0)[i]);

					String columnName = dataList.get(0)[i];
					Object [] metaData = new Object[2];//Crash_ID
					if(columnName.equals("Crash_ID")){
						metaData[0] = "Crash_ID";
						metaData[1] = i;
						indexList.add(metaData);
					}else if(columnName.equals("Crash_Date")){
						metaData[0] = "Crash_Date";
						metaData[1] = i;
						indexList.add(metaData);
					}else if(columnName.equals("Crash_Time")){
						metaData[0] = "Crash_Time";
						metaData[1] = i;
						indexList.add(metaData);
					}else if(columnName.equals("Death_Cnt")){
						metaData[0] = "Death_Cnt";
						metaData[1] = i;
						indexList.add(metaData);
					}else if(columnName.equals("Othr_Factr_ID")){
						metaData[0] = "Othr_Factr_ID";
						metaData[1] = i;
						indexList.add(metaData);
					}else if(columnName.equals("Wthr_Cond_ID")){
						metaData[0] = "Wthr_Cond_ID";
						metaData[1] = i;
						indexList.add(metaData);
					}else if(columnName.equals("Investigat_Notify_Time")){
						metaData[0] = "Investigat_Notify_Time";
						metaData[1] = i;
						indexList.add(metaData);
					}else if(columnName.equals("Investigat_Arrv_Time")){
						metaData[0] = "Investigat_Arrv_Time";
						metaData[1] = i;
						indexList.add(metaData);
					}else if(columnName.equals("Rpt_Street_Name")){
						metaData[0] = "Rpt_Street_Name";
						metaData[1] = i;
						indexList.add(metaData);
					}else if(columnName.equals("Rpt_Sec_Street_Name")){
						metaData[0] = "Rpt_Sec_Street_Name";
						metaData[1] = i;
						indexList.add(metaData);
					}	






				}
				List<IncidentObject> allIncidents = new ArrayList<IncidentObject>();
				for(int i=1;i<dataList.size();i++){
					incidentCount++;
					IncidentObject currentIncident = new IncidentObject();

					for(int j=0;j<indexList.size();j++){


						if(indexList.get(j)[0].equals("Crash_ID")){

							currentIncident.Crash_ID = Integer.parseInt(dataList.get(i)[(Integer) indexList.get(j)[1]]);
						}


						if(indexList.get(j)[0].equals("Crash_Date")){
							String date = dataList.get(i)[(Integer) indexList.get(j)[1]];
							String[] date2 = date.split("/");
							String month = date2[0];
							String day = date2[1];
							String year = date2[2];
							int tempDay = Integer.parseInt(day);
							int tempMonth = Integer.parseInt(month);
							if(tempDay<10){
								day = "0"+day;
							}
							if(tempMonth<10){
								month = "0"+month;
							}
							date = year+"-"+month+"-"+day;

							currentIncident.setCrashDate(date);

						}
						if(indexList.get(j)[0].equals("Crash_Time")){
							String time = dataList.get(i)[(Integer) indexList.get(j)[1]];
							String[] time2 = time.split(":");
							String hour = time2[0];
							int tempHour = Integer.parseInt(hour);
							if(tempHour<10){
								hour = "0"+hour;
							}
							time = hour+":"+time2[1];
							currentIncident.Crash_Time = time;
						}

						if(indexList.get(j)[0].equals(("Rpt_Street_Name"))){
							String mainStreet = dataList.get(i)[(Integer)indexList.get(j)[1]];
							if(mainStreet.contains("I10")||mainStreet.contains("I 10")||mainStreet.contains("IH 10")||mainStreet.contains("INTERSTATE 10")){
								mainStreet = "I 10";

							}
							if(mainStreet.contains("375")){
								mainStreet = "LOOP 375";

							}
							currentIncident.Rpt_Street_Name=mainStreet;

						}
						if(indexList.get(j)[0].equals(("Rpt_Sec_Street_Name"))){
							String secStreet = dataList.get(i)[(Integer)indexList.get(j)[1]];
							if(secStreet.contains("I10")||secStreet.contains("I 10")||secStreet.contains("IH 10")||secStreet.contains("INTERSTATE 10")){
								secStreet = "I 10";
							}
							if(secStreet.contains("375")){
								secStreet = "LOOP 375";

							}
							currentIncident.Rpt_Sec_Street_Name= secStreet;

						}
						//System.out.println(indexList.get(j)[0]);
						if(indexList.get(j)[0].equals("Death_Cnt")){
							deathCount+=Integer.parseInt(dataList.get(i)[(Integer)indexList.get(j)[1]]);
							currentIncident.Death_Cnt = Integer.parseInt(dataList.get(i)[(Integer)indexList.get(j)[1]]);

						}
						if(indexList.get(j)[0].equals("Othr_Factr_ID")){
							int weatherValue =Integer.parseInt(dataList.get(i)[(Integer)indexList.get(j)[1]]);
							if(weatherValue==1){
								weatherIssues++;
								currentIncident.Othr_Factr_ID = Integer.parseInt(dataList.get(i)[(Integer)indexList.get(j)[1]]);

							}
						}
						if(indexList.get(j)[0].equals("Wthr_Cond_ID")){
							int weatherValue =Integer.parseInt(dataList.get(i)[(Integer)indexList.get(j)[1]]);
							if(weatherValue==1||weatherValue==2||weatherValue==4||weatherValue==6){
								weatherIssues++;
								currentIncident.Wthr_Cond_ID = Integer.parseInt(dataList.get(i)[(Integer)indexList.get(j)[1]]);

							}
						}
						if(indexList.get(j)[0].equals("Investigat_Arrv_Time")&&indexList.get(j-1)[0].equals("Investigat_Notify_Time")){


							String arriveTime = dataList.get(i)[(Integer) indexList.get(j)[1]];
							String[] arriveTime2 = arriveTime.split(":");
							String arriveHour = arriveTime2[0];
							int arriveTempHour = Integer.parseInt(arriveHour);
							if(arriveTempHour<10){
								arriveHour = "0"+arriveHour;
							}
							String[] atime = arriveTime.split(" ");
							int ahour = Integer.parseInt(atime[0].split(":")[0]);
							int aminutes = Integer.parseInt(atime[0].split(":")[1]);
							if(atime[1].equals("PM")){
								ahour+=12;
							}
							arriveTime = arriveHour+":"+arriveTime2[1];

							endTime = (ahour*60)+aminutes;

							currentIncident.Investigat_Arrv_Time = arriveTime;

							currentIncident.endTime = endTime;

							//Notify Time
							String notifyTime = dataList.get(i)[(Integer) indexList.get(j-1)[1]];
							String[] notifyTime2 = notifyTime.split(":");
							String notifyHour = notifyTime2[0];
							int notifyTempHour = Integer.parseInt(notifyHour);
							if(notifyTempHour<10){
								notifyHour = "0"+notifyHour;
							}
							String[] ntime = arriveTime.split(" ");
							int nhour = Integer.parseInt(ntime[0].split(":")[0]);
							int nminutes = Integer.parseInt(ntime[0].split(":")[1]);
							if(ntime[1].equals("PM")){
								nhour+=12;
							}
							notifyTime = notifyHour+":"+notifyTime2[1];

							startTime = (nhour*60)+nminutes;
							currentIncident.Investigat_Notify_Time = notifyTime;
							currentIncident.startTime = startTime;

							totalTime+=endTime - startTime;
							currentIncident.totalTime = (endTime-startTime);



						}








					}
					allIncidents.add(currentIncident);
					//System.out.println(dataList.get(455)[(Integer) indexList.get(2)[1]]);
					//System.out.println("");




				}


				for(int i=0;i<allIncidents.size();i++){
					//System.out.println("allIncidents.get(i).Crash_ID: "+allIncidents.get(i).Crash_ID);
					//System.out.println("allIncidents.get(i).Crash_Date: "+allIncidents.get(i).Crash_Date);
					//System.out.println("allIncidents.get(i).Crash_Time: "+allIncidents.get(i).Crash_Time);
					//System.out.println("allIncidents.get(i).Death_Cnt: "+allIncidents.get(i).Death_Cnt);
					//System.out.println("allIncidents.get(i).Investigat_Arrv_Time: "+allIncidents.get(i).Investigat_Arrv_Time);
					//System.out.println("allIncidents.get(i).Investigat_Notify_Time: "+allIncidents.get(i).Investigat_Notify_Time);
					//System.out.println("allIncidents.get(i).Rpt_Sec_Street_Name: "+allIncidents.get(i).Rpt_Sec_Street_Name);
					//System.out.println("allIncidents.get(i).Rpt_Street_Name: "+allIncidents.get(i).Rpt_Street_Name);
					//System.out.println("allIncidents.get(i).Wthr_Cond_ID: "+allIncidents.get(i).Wthr_Cond_ID);//Weather
					//System.out.println("allIncidents.get(i).Othr_Factr_ID: "+allIncidents.get(i).Othr_Factr_ID);//Weather
					//System.out.println("allIncidents.get(i).startTime: "+allIncidents.get(i).startTime);
					//System.out.println("allIncidents.get(i).endTime: "+allIncidents.get(i).endTime);
					//System.out.println("allIncidents.get(i).totalTime: "+allIncidents.get(i).totalTime);
					/*manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasIncidentId, incidentClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasIncidentMainStreet, incidentClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasIncidentSecondaryStreet, incidentClass)));
			manager.applyChange(new AddAxiom(ontology,factory.getOWLDataPropertyDomainAxiom(hasIncidentCrashTime, incidentClass)));
			OWLDataProperty hasIncidentMainStreet = factory.getOWLDataProperty(IRI.create(prefix  + "#hasIncident.MainStreet"));
			OWLDataProperty hasIncidentSecondaryStreet = factory.getOWLDataProperty(IRI.create(prefix  + "#hasIncident.SecondaryStreet"));
			OWLDataProperty hasIncidentCrashTime = factory.getOWLDataProperty(IRI.create(prefix  + "#hasIncident.CrashTime"));
			OWLDataProperty hasAverageResponseTimeAverageValue = factory.getOWLDataProperty(IRI.create(prefix  + "#hasAverageResponseTime.AverageValue"));
			OWLDataProperty hasAverageResponseTimeUnit = factory.getOWLDataProperty(IRI.create(prefix  + "#hasAverageResponseTime.Unit"));
			OWLDataProperty hasAverageResponseTimeYear = factory.getOWLDataProperty(IRI.create(prefix  + "#hasAverageResponseTime.Year"));
			OWLDataProperty hasWeatherConditionSurfaceCondition = factory.getOWLDataProperty(IRI.create(prefix  + "#hasWeatherCondition.SurfaceCondition"));
			OWLDataProperty hasWeatherConditionCrashFactors = factory.getOWLDataProperty(IRI.create(prefix  + "#hasWeatherCondition.CrashFactors"));
			OWLDataProperty hasResponseTimeToIncidentsUnit = factory.getOWLDataProperty(IRI.create(prefix  + "#hasResponseTimeToIncidents.Unit"));
			OWLDataProperty hasResponseTimeToIncidentsArrivalTime = factory.getOWLDataProperty(IRI.create(prefix  + "#hasResponseTimeToIncidents.ArrivalTime"));
			OWLDataProperty hasResponseTimeToIncidentsFinalResponseTime= factory.getOWLDataProperty(IRI.create(prefix  + "#hasResponseTimeToIncidents.FinalResponseTime"));
			OWLDataProperty hasResponseTimeToIncidentsNotifyTime = factory.getOWLDataProperty(IRI.create(prefix  + "#hasResponseTimeToIncidents.NotifyTime"));
			OWLDataProperty hasAveragePeakHourDelayAveragePeakYear = factory.getOWLDataProperty(IRI.create(prefix + ontFile + "#hasAveragePeakHourDelay.AveragePeakYear"));
					 */

					if(allIncidents.get(i).Othr_Factr_ID>0 || allIncidents.get(i).Wthr_Cond_ID>0){
						OWLNamedIndividual weatherIncidentIndividual = factory.getOWLNamedIndividual(IRI.create("weather_incident_"+allIncidents.get(i).Crash_ID));
						OWLClassAssertionAxiom weatherIncidentClassAssertion = factory.getOWLClassAssertionAxiom(weatherRelatedIncidentsClass, weatherIncidentIndividual);
						manager.applyChange(new AddAxiom(ontology,weatherIncidentClassAssertion));

						OWLNamedIndividual incidentResponseIndividual = factory.getOWLNamedIndividual(IRI.create("weather_incidentResponseTime_"+allIncidents.get(i).Crash_ID));
						OWLClassAssertionAxiom incidentResponseClassAssertion = factory.getOWLClassAssertionAxiom(responseTimeToIncidentsClass, incidentResponseIndividual);
						manager.applyChange(new AddAxiom(ontology,incidentResponseClassAssertion));

						OWLAxiom hasMainStreetAxiom = factory.getOWLDataPropertyAssertionAxiom(hasIncidentMainStreet, weatherIncidentIndividual, allIncidents.get(i).Rpt_Street_Name);
						manager.applyChange(new AddAxiom(ontology, hasMainStreetAxiom));

						OWLAxiom hasSecStreetAxiom = factory.getOWLDataPropertyAssertionAxiom(hasIncidentSecondaryStreet, weatherIncidentIndividual, allIncidents.get(i).Rpt_Sec_Street_Name);
						manager.applyChange(new AddAxiom(ontology, hasSecStreetAxiom));

						int incidentID;
						if(allIncidents.get(i).Othr_Factr_ID>0){
							incidentID = allIncidents.get(i).Othr_Factr_ID;
						}else{
							incidentID = allIncidents.get(i).Wthr_Cond_ID;
						}

						OWLAxiom hasWeatherIDAxiom = factory.getOWLDataPropertyAssertionAxiom(hasWeatherRelatedIncidentsId, weatherIncidentIndividual, incidentID);
						manager.applyChange(new AddAxiom(ontology, hasWeatherIDAxiom));
						String date = allIncidents.get(i).Crash_Date;
						String time = allIncidents.get(i).Crash_Time;
						String notify = allIncidents.get(i).Investigat_Notify_Time;
						String arrive = allIncidents.get(i).Investigat_Arrv_Time;
						String month = date.split("-")[1];
						String day = date.split("-")[2];
						String year = date.split("-")[0];


						String[] myTime = time.split(" ");
						String hour = myTime[0].split(":")[0];
						int tempHour = Integer.parseInt(hour);
						String minutes = myTime[0].split(":")[1];
						if(myTime[1].equals("PM")){
							if(tempHour<12){
								tempHour+=12;
							}
							hour = Integer.toString(tempHour);

						}


						// 1st type of parsing
						String dateString = year+"-"+month+"-"+day+"T"+hour+":"+minutes+":00-07:00";
						OWLLiteral dateLiteral = factory.getOWLTypedLiteral(dateString, OWL2Datatype.XSD_DATE_TIME);

						OWLAxiom hasCrashTimeAxiom = factory.getOWLDataPropertyAssertionAxiom(hasIncidentCrashTime, weatherIncidentIndividual, dateLiteral);
						manager.applyChange(new AddAxiom(ontology, hasCrashTimeAxiom));


						String[] myNotify = notify.split(" ");
						String nhour = myNotify[0].split(":")[0];

						int tempnhour = Integer.parseInt(nhour);
						String nminutes = myNotify[0].split(":")[1];
						if(myNotify[1].equals("PM")){
							if(tempnhour<12){
								tempnhour+=12;
							}
							nhour = Integer.toString(tempnhour);

						}

						String[] myArrive = arrive.split(" ");
						String ahour = myArrive[0].split(":")[0];
						int tempahour = Integer.parseInt(ahour);
						String aminutes = myArrive[0].split(":")[1];
						if(myArrive[1].equals("PM")){
							if(tempahour<12){
								tempahour+=12;
							}
							ahour = Integer.toString(tempahour);
						}

						String notifyString = year+"-"+month+"-"+day+"T"+nhour+":"+nminutes+":00-07:00";
						OWLLiteral notifyLiteral = factory.getOWLTypedLiteral(notifyString, OWL2Datatype.XSD_DATE_TIME);
						OWLAxiom responseNotifyAxiom = factory.getOWLDataPropertyAssertionAxiom(hasResponseTimeToIncidentsNotifyTime, incidentResponseIndividual, notifyLiteral);
						manager.applyChange(new AddAxiom(ontology, responseNotifyAxiom));

						String arriveString = year+"-"+month+"-"+day+"T"+ahour+":"+aminutes+":00-07:00";
						OWLLiteral arriveLiteral = factory.getOWLTypedLiteral(arriveString, OWL2Datatype.XSD_DATE_TIME);
						OWLAxiom responseArriveAxiom = factory.getOWLDataPropertyAssertionAxiom(hasResponseTimeToIncidentsArrivalTime, incidentResponseIndividual, arriveLiteral);
						manager.applyChange(new AddAxiom(ontology, responseArriveAxiom));

					}else if(allIncidents.get(i).Death_Cnt>0){
						OWLNamedIndividual fatalIncidentIndividual = factory.getOWLNamedIndividual(IRI.create("fatal_incident_"+allIncidents.get(i).Crash_ID));
						OWLClassAssertionAxiom fatalIncidentClassAssertion = factory.getOWLClassAssertionAxiom(fatalIncidentsClass, fatalIncidentIndividual);
						manager.applyChange(new AddAxiom(ontology,fatalIncidentClassAssertion));

						OWLNamedIndividual incidentResponseIndividual = factory.getOWLNamedIndividual(IRI.create("fatal_incidentResponseTime_"+allIncidents.get(i).Crash_ID));
						OWLClassAssertionAxiom incidentResponseClassAssertion = factory.getOWLClassAssertionAxiom(responseTimeToIncidentsClass, incidentResponseIndividual);
						manager.applyChange(new AddAxiom(ontology,incidentResponseClassAssertion));

						OWLAxiom hasMainStreetAxiom = factory.getOWLDataPropertyAssertionAxiom(hasIncidentMainStreet, fatalIncidentIndividual, allIncidents.get(i).Rpt_Street_Name);
						manager.applyChange(new AddAxiom(ontology, hasMainStreetAxiom));

						OWLAxiom hasSecStreetAxiom = factory.getOWLDataPropertyAssertionAxiom(hasIncidentSecondaryStreet, fatalIncidentIndividual, allIncidents.get(i).Rpt_Sec_Street_Name);
						manager.applyChange(new AddAxiom(ontology, hasSecStreetAxiom));

						String date = allIncidents.get(i).Crash_Date;
						String time = allIncidents.get(i).Crash_Time;
						String notify = allIncidents.get(i).Investigat_Notify_Time;
						String arrive = allIncidents.get(i).Investigat_Arrv_Time;
						String month = date.split("-")[1];
						String day = date.split("-")[2];
						String year = date.split("-")[0];

						String[] myTime = time.split(" ");
						String hour = myTime[0].split(":")[0];
						int tempHour = Integer.parseInt(hour);
						String minutes = myTime[0].split(":")[1];
						if(myTime[1].equals("PM")){
							if(tempHour<12){
								tempHour+=12;
							}
							hour = Integer.toString(tempHour);
						}



						String dateString = year+"-"+month+"-"+day+"T"+hour+":"+minutes+":00-07:00";
						OWLLiteral dateLiteral = factory.getOWLTypedLiteral(dateString, OWL2Datatype.XSD_DATE_TIME);
						OWLAxiom hasCrashTimeAxiom = factory.getOWLDataPropertyAssertionAxiom(hasIncidentCrashTime, fatalIncidentIndividual, dateLiteral);
						manager.applyChange(new AddAxiom(ontology, hasCrashTimeAxiom));


						String[] myNotify = notify.split(" ");
						String nhour = myNotify[0].split(":")[0];

						int tempnhour = Integer.parseInt(nhour);
						String nminutes = myNotify[0].split(":")[1];
						if(myNotify[1].equals("PM")){
							if(tempnhour<12){
								tempnhour+=12;
							}
							nhour = Integer.toString(tempnhour);
						}

						String[] myArrive = arrive.split(" ");
						String ahour = myArrive[0].split(":")[0];
						int tempahour = Integer.parseInt(ahour);
						String aminutes = myArrive[0].split(":")[1];
						if(myArrive[1].equals("PM")){
							if(tempahour<12){
								tempahour+=12;
							}
							ahour = Integer.toString(tempahour);
						}


						String notifyString = year+"-"+month+"-"+day+"T"+nhour+":"+nminutes+":00-07:00";
						OWLLiteral notifyLiteral = factory.getOWLTypedLiteral(notifyString, OWL2Datatype.XSD_DATE_TIME);
						OWLAxiom responseNotifyAxiom = factory.getOWLDataPropertyAssertionAxiom(hasResponseTimeToIncidentsNotifyTime, incidentResponseIndividual, notifyLiteral);
						manager.applyChange(new AddAxiom(ontology, responseNotifyAxiom));

						String arriveString = year+"-"+month+"-"+day+"T"+ahour+":"+aminutes+":00-07:00";
						OWLLiteral arriveLiteral = factory.getOWLTypedLiteral(arriveString, OWL2Datatype.XSD_DATE_TIME);

						OWLAxiom responseArriveAxiom = factory.getOWLDataPropertyAssertionAxiom(hasResponseTimeToIncidentsArrivalTime, incidentResponseIndividual, arriveLiteral);
						manager.applyChange(new AddAxiom(ontology, responseArriveAxiom));

					}else if(allIncidents.get(i).Death_Cnt==0){

						OWLNamedIndividual incidentIndividual = factory.getOWLNamedIndividual(IRI.create("incident_"+allIncidents.get(i).Crash_ID));
						OWLClassAssertionAxiom incidentClassAssertion = factory.getOWLClassAssertionAxiom(incidentClass, incidentIndividual);
						manager.applyChange(new AddAxiom(ontology,incidentClassAssertion));

						OWLNamedIndividual incidentResponseIndividual = factory.getOWLNamedIndividual(IRI.create("incidentResponseTime_"+allIncidents.get(i).Crash_ID));
						OWLClassAssertionAxiom incidentResponseClassAssertion = factory.getOWLClassAssertionAxiom(responseTimeToIncidentsClass, incidentResponseIndividual);
						manager.applyChange(new AddAxiom(ontology,incidentResponseClassAssertion));

						OWLAxiom hasMainStreetAxiom = factory.getOWLDataPropertyAssertionAxiom(hasIncidentMainStreet, incidentIndividual, allIncidents.get(i).Rpt_Street_Name);
						manager.applyChange(new AddAxiom(ontology, hasMainStreetAxiom));

						OWLAxiom hasSecStreetAxiom = factory.getOWLDataPropertyAssertionAxiom(hasIncidentSecondaryStreet, incidentIndividual, allIncidents.get(i).Rpt_Sec_Street_Name);
						manager.applyChange(new AddAxiom(ontology, hasSecStreetAxiom));

						String date = allIncidents.get(i).Crash_Date;
						String time = allIncidents.get(i).Crash_Time;
						String notify = allIncidents.get(i).Investigat_Notify_Time;
						String arrive = allIncidents.get(i).Investigat_Arrv_Time;
						String month = date.split("-")[1];
						String day = date.split("-")[2];
						String year = date.split("-")[0];


						String[] myTime = time.split(" ");
						String hour = myTime[0].split(":")[0];
						int tempHour = Integer.parseInt(hour);
						String minutes = myTime[0].split(":")[1];
						if(myTime[1].equals("PM")){
							if(tempHour<12){
								tempHour+=12;
							}
							hour = Integer.toString(tempHour);
						}



						String dateString = year+"-"+month+"-"+day+"T"+hour+":"+minutes+":00-07:00";
						OWLLiteral dateLiteral = factory.getOWLTypedLiteral(dateString, OWL2Datatype.XSD_DATE_TIME);
						OWLDataPropertyAssertionAxiom hasCrashTimeAxiom = factory.getOWLDataPropertyAssertionAxiom(hasIncidentCrashTime, incidentIndividual, dateLiteral);
						manager.applyChange(new AddAxiom(ontology, hasCrashTimeAxiom));


						String[] myNotify = notify.split(" ");
						String nhour = myNotify[0].split(":")[0];

						int tempnhour = Integer.parseInt(nhour);
						String nminutes = myNotify[0].split(":")[1];
						if(myNotify[1].equals("PM")){
							if(tempnhour<12){
								tempnhour+=12;
							}
							nhour = Integer.toString(tempnhour);
						}

						String[] myArrive = arrive.split(" ");
						String ahour = myArrive[0].split(":")[0];
						int tempahour = Integer.parseInt(ahour);
						String aminutes = myArrive[0].split(":")[1];
						if(myArrive[1].equals("PM")){
							if(tempahour<12){
								tempahour+=12;
							}
							ahour = Integer.toString(tempahour);
						}

						String notifyString = year+"-"+month+"-"+day+"T"+nhour+":"+nminutes+":00-07:00";
						OWLLiteral notifyLiteral = factory.getOWLTypedLiteral(notifyString, OWL2Datatype.XSD_DATE_TIME);
						OWLAxiom responseNotifyAxiom = factory.getOWLDataPropertyAssertionAxiom(hasResponseTimeToIncidentsNotifyTime, incidentResponseIndividual, notifyLiteral);
						manager.applyChange(new AddAxiom(ontology, responseNotifyAxiom));

						String arriveString = year+"-"+month+"-"+day+"T"+ahour+":"+aminutes+":00-07:00";
						OWLLiteral arriveLiteral = factory.getOWLTypedLiteral(arriveString, OWL2Datatype.XSD_DATE_TIME);
						OWLAxiom responseArriveAxiom = factory.getOWLDataPropertyAssertionAxiom(hasResponseTimeToIncidentsArrivalTime, incidentResponseIndividual, arriveLiteral);
						manager.applyChange(new AddAxiom(ontology, responseArriveAxiom));

					}

					//System.out.println("");

				}


				String csvFile1 = "/Users/danielmejia/Documents/workspace/freightPerformance/src/main/java/cs/utep/freightPerformance/TTI UMR complete-dataELP.csv";
				String currentLine1 = "";
				BufferedReader reader1 = new BufferedReader(new FileReader(csvFile1));
				List<String []> dataList1 = new ArrayList<String []>();
				//FileInputStream file = new FileInputStream(new File("C:\\Users\\dmmej_000\\workspace\\owlapitest2\\src\\main\\java\\cs\\utep\\owlapitest2\\cmv 2014 incidents.csv"));
				while((currentLine1 = reader1.readLine())!=null){

					String [] items = currentLine1.split(",");

					if(items[0].equals("El Paso TX-NM")&&items[0]!=""){
						//System.out.println(currentLine);
						dataList1.add(items);
					}
				}
				double hourDelay = 0;
				double hourDelayCount=0;

				double congestionCost=0;
				double congestionCostCount = 0;

				double congestionTime = 0;
				double congestionTimeCount = 0;

				double percentSystem = 0;
				double percentSystemCount = 0;

				double percentTravel = 0;
				double percentTravelCount = 0;

				double gasPrice = 0;
				double gasPriceCount = 0;

				double dieselPrice = 0;
				double dieselPriceCount = 0;

				double travelTimeIndex = 0;
				double travelTimeIndexCount = 0;

				double comuterStress = 0;
				double comuterStressCount = 0;

				double valueTime = 0;
				double valueTimeCount = 0;


				for(int i=0;i<dataList1.size();i++){


					//Average Peak Hour Delay (Column V - 21)
					if(!dataList1.get(i)[21].equals("")){
						hourDelay += Double.parseDouble(dataList1.get(i)[21]);
						hourDelayCount++;

					}


					//Congestion Cost (Column AD - 29)
					if(!dataList1.get(i)[29].equals("")){
						congestionCost += Double.parseDouble(dataList1.get(i)[29]);
						congestionCostCount++;

					}

					//Congestion Time (Column O - 14)
					if(!dataList1.get(i)[14].equals("")){
						congestionTime += Double.parseDouble(dataList1.get(i)[14]);
						congestionTimeCount++;

					}


					//Percent of system congested (Column N - 13)
					if(!dataList1.get(i)[13].equals("")){
						percentSystem += Double.parseDouble(dataList1.get(i)[13]);
						percentSystemCount++;


					}

					//Percent of Travel Congested (Column M - 12)
					if(!dataList1.get(i)[12].equals("")){
						percentTravel += Double.parseDouble(dataList1.get(i)[12]);
						percentTravelCount++;				

					}


					//Gasoline Price (Column K - 10)
					if(!dataList1.get(i)[10].equals("")){
						gasPrice += Double.parseDouble(dataList1.get(i)[10]);
						gasPriceCount++;

					}

					//Diesel Price (Column L - 11)
					if(!dataList1.get(i)[11].equals("")){
						dieselPrice += Double.parseDouble(dataList1.get(i)[11]);
						dieselPriceCount++;
					}

					//Travel Time Index (Column X - 23)
					if(!dataList1.get(i)[23].equals("")){
						travelTimeIndex += Double.parseDouble(dataList1.get(i)[23]);
						travelTimeIndexCount++;

					}

					//Commuter Stress Index (Column Z - 25) 
					if(!dataList1.get(i)[25].equals("")){
						comuterStress += Double.parseDouble(dataList1.get(i)[25]);
						comuterStressCount++;

					}

					//Value of Time (Column I - 9)
					if(!dataList1.get(i)[9].equals("")){
						valueTime += Double.parseDouble(dataList1.get(i)[9]);
						valueTimeCount++;

					}
				}

				double averageDelay = hourDelay/hourDelayCount;
				double averageCongestionCost = congestionCost/congestionCostCount;
				double averageCongestionTime = congestionTime/congestionTimeCount;
				double averagePercentSystem = percentSystem/percentSystemCount;
				double averagePercentTravel = percentTravel/percentTravelCount;
				double averageGasPrice = gasPrice/gasPriceCount;
				double averageDieselPrice = dieselPrice/dieselPriceCount;
				double averageTravelTimeIndex = travelTimeIndex/travelTimeIndexCount;
				double averageComuterStress = comuterStress/comuterStressCount;
				double averageValueTime = valueTime/valueTimeCount;


				OWLNamedIndividual peakHourIndividual = factory.getOWLNamedIndividual(IRI.create(Double.toString(averageDelay)));
				OWLClassAssertionAxiom peakHourClassAssertion = factory.getOWLClassAssertionAxiom(averagePeakHourDelayClass, peakHourIndividual);
				manager.applyChange(new AddAxiom(ontology,peakHourClassAssertion));

				OWLNamedIndividual congestionCostIndividual = factory.getOWLNamedIndividual(IRI.create(Double.toString(averageCongestionCost)));
				OWLClassAssertionAxiom congestionCostClassAssertion = factory.getOWLClassAssertionAxiom(congestionCostClass, congestionCostIndividual);
				manager.applyChange(new AddAxiom(ontology,congestionCostClassAssertion));

				OWLNamedIndividual congestionTimeIndividual = factory.getOWLNamedIndividual(IRI.create(Double.toString(averageCongestionTime)));
				OWLClassAssertionAxiom congestionTimeClassAssertion = factory.getOWLClassAssertionAxiom(congestionTimeClass, congestionTimeIndividual);
				manager.applyChange(new AddAxiom(ontology,congestionTimeClassAssertion));

				OWLNamedIndividual percentSystemIndividual = factory.getOWLNamedIndividual(IRI.create(Double.toString(averagePercentSystem)));
				OWLClassAssertionAxiom percentSystemClassAssertion = factory.getOWLClassAssertionAxiom(percentOfSystemCongestedClass, percentSystemIndividual);
				manager.applyChange(new AddAxiom(ontology,percentSystemClassAssertion));

				OWLNamedIndividual percentTravelIndividual = factory.getOWLNamedIndividual(IRI.create(Double.toString(averagePercentTravel)));
				OWLClassAssertionAxiom percentTravelClassAssertion = factory.getOWLClassAssertionAxiom(percentOfTravelCongestedClass, percentTravelIndividual);
				manager.applyChange(new AddAxiom(ontology,percentTravelClassAssertion));

				OWLNamedIndividual gasPriceIndividual = factory.getOWLNamedIndividual(IRI.create(Double.toString(averageGasPrice)));
				OWLClassAssertionAxiom gasPriceClassAssertion = factory.getOWLClassAssertionAxiom(gasolinePriceClass, gasPriceIndividual);
				manager.applyChange(new AddAxiom(ontology,gasPriceClassAssertion));

				OWLNamedIndividual dieselPriceIndividual = factory.getOWLNamedIndividual(IRI.create(Double.toString(averageDieselPrice)));
				OWLClassAssertionAxiom dieselPriceClassAssertion = factory.getOWLClassAssertionAxiom(dieselPriceClass, dieselPriceIndividual);
				manager.applyChange(new AddAxiom(ontology,dieselPriceClassAssertion));

				OWLNamedIndividual timeIndexIndividual = factory.getOWLNamedIndividual(IRI.create(Double.toString(averageTravelTimeIndex)));
				OWLClassAssertionAxiom timeIndexClassAssertion = factory.getOWLClassAssertionAxiom(travelTimeIndexClass, timeIndexIndividual);
				manager.applyChange(new AddAxiom(ontology,timeIndexClassAssertion));

				OWLNamedIndividual stressIndividual = factory.getOWLNamedIndividual(IRI.create(Double.toString(averageComuterStress)));
				OWLClassAssertionAxiom stressClassAssertion = factory.getOWLClassAssertionAxiom(commuterStressIndexClass, stressIndividual);
				manager.applyChange(new AddAxiom(ontology,stressClassAssertion));

				OWLNamedIndividual valueIndividual = factory.getOWLNamedIndividual(IRI.create(Double.toString(averageValueTime)));
				OWLClassAssertionAxiom valueClassAssertion = factory.getOWLClassAssertionAxiom(valueOfTimeClass, valueIndividual);
				manager.applyChange(new AddAxiom(ontology,valueClassAssertion));

				/*
				System.out.println("delay: "+averageDelay);
				System.out.println("congestion: "+averageCongestionCost);
				System.out.println("cong Time: "+averageCongestionTime);
				System.out.println("perSyst: "+averagePercentSystem);
				System.out.println("perTrav: "+averagePercentTravel);
				System.out.println("avg gas: "+averageGasPrice);
				System.out.println("avg diesel: "+averageDieselPrice);
				System.out.println("avg TTI: "+averageTravelTimeIndex);
				System.out.println("avg comuterStress: "+averageComuterStress);
				System.out.println("avg ValTime: "+averageValueTime);
				 */


				try{
					String [] items = null;
					String csvFile2 = "TxDOT ADT Volume.csv";
					String currentLine2 = "";
					BufferedReader reader2 = new BufferedReader(new FileReader(csvFile2));
					List<String []> dataList2 = new ArrayList<String []>();
					//FileInputStream file = new FileInputStream(new File("C:\\Users\\dmmej_000\\workspace\\owlapitest2\\src\\main\\java\\cs\\utep\\owlapitest2\\cmv 2014 incidents.csv"));
					while((currentLine2 = reader2.readLine())!=null){

						items = currentLine2.split(",");
						dataList2.add(items);

						//System.out.println(currentLine);
					}

					List<ADTObject> ADTList = new ArrayList<ADTObject>();

					for(int i=1;i<dataList2.size();i++){
						ADTObject currentADT = new ADTObject();
						//System.out.println(dataList.get(i)[0]);
						currentADT.primaryStreet = dataList2.get(i)[0];
						currentADT.intersectionStreet = dataList2.get(i)[1];
						currentADT.locationFromIntersection = dataList2.get(i)[2];
						currentADT.volume = Integer.parseInt(dataList2.get(i)[3]);
						ADTList.add(currentADT);


					}

					for(int i=0;i<ADTList.size();i++){


						OWLNamedIndividual trafficVolumeIndividual = factory.getOWLNamedIndividual(IRI.create("ADT_"+i));
						OWLClassAssertionAxiom trafficVolumeClassAssertion = factory.getOWLClassAssertionAxiom(trafficVolumeClass, trafficVolumeIndividual);
						manager.applyChange(new AddAxiom(ontology,trafficVolumeClassAssertion));

						OWLAxiom hasPrimaryStreetAxiom = factory.getOWLDataPropertyAssertionAxiom(hasTrafficVolumePrimaryStreet, trafficVolumeIndividual, ADTList.get(i).primaryStreet);
						manager.applyChange(new AddAxiom(ontology, hasPrimaryStreetAxiom));

						OWLAxiom hasTrafficIntersectionAxiom = factory.getOWLDataPropertyAssertionAxiom(hasTrafficVolumeIntersectionStreet, trafficVolumeIndividual, ADTList.get(i).intersectionStreet);
						manager.applyChange(new AddAxiom(ontology, hasTrafficIntersectionAxiom));

						OWLAxiom hasVolumeAxiom = factory.getOWLDataPropertyAssertionAxiom(hasTrafficVolumeVolume, trafficVolumeIndividual, ADTList.get(i).volume);
						manager.applyChange(new AddAxiom(ontology, hasVolumeAxiom));

						/*
						System.out.println("Primary Street: "+ADTList.get(i).primaryStreet);
						System.out.println("Intersection: "+ADTList.get(i).intersectionStreet);
						System.out.println("Location: "+ADTList.get(i).locationFromIntersection);
						System.out.println("Volume: "+ADTList.get(i).volume);
						System.out.println("");
						 */

					}

				}catch(Exception e){}






				/* PDF Parsing */
				/** The original PDF that will be parsed. */
				String PDFFileName = "/Users/danielmejia/Documents/workspace/freightPerformance/src/main/java/cs/utep/freightPerformance/Fiscal Year 2014 Financial Report (toll revenue).pdf";
				ParsePDF pdfParser = new ParsePDF();
				pdfParser.parsePdf(PDFFileName);
				/* PDF parsing complete */
				//			/* PDF data insertion as individual start */

				OWLNamedIndividual tollRevenueIndividual = factory.getOWLNamedIndividual(IRI.create((pdfParser.tollrevenue)+""));
				OWLClassAssertionAxiom tollRevenueClassAssertion = factory.getOWLClassAssertionAxiom(tollRevenueClass, tollRevenueIndividual);
				manager.applyChange(new AddAxiom(ontology,tollRevenueClassAssertion));

				/* PDF data insertion as individual end */

				/* Parsing Avg. Crossing time data from website */
				// Ysleta Bridge, El Paso, TX : ZAR
				String urlYsletaBridge = "http://bcis.tamu.edu/request2.aspx?call=getMonthlyPerformanceIndicators&bridgeID@varchar=ZAR&timeFrom@varchar=01/01/2014%2000:00&timeTo@varchar=12/31/2014%2000:00"; 
				ParseWebsite websiteParserYsletaBridge = new ParseWebsite();
				websiteParserYsletaBridge.getHTML(urlYsletaBridge);
				String[] tempCrossDates = websiteParserYsletaBridge.portOfEntryDates;
				int[] tempCrossWait = websiteParserYsletaBridge.portOfEntryWait;

				for(int k=0;k<tempCrossDates.length;k++){
					OWLNamedIndividual bridgeCrossIndividual = factory.getOWLNamedIndividual(IRI.create("ysletaBridgeCrossIndividual_"+(k+1)));
					OWLClassAssertionAxiom ysletaPortOfEntryClassAssertion = factory.getOWLClassAssertionAxiom(ysletaPortOfEntryClass, bridgeCrossIndividual);
					manager.applyChange(new AddAxiom(ontology,ysletaPortOfEntryClassAssertion));

					String tempDateString = tempCrossDates[k];
					OWLLiteral crossingDateLiteral = factory.getOWLTypedLiteral(tempDateString, OWL2Datatype.XSD_DATE_TIME);

					OWLAxiom hasDateAxiom = factory.getOWLDataPropertyAssertionAxiom(hasPOEMonth, bridgeCrossIndividual, crossingDateLiteral);
					manager.applyChange(new AddAxiom(ontology, hasDateAxiom));

					OWLAxiom crossingTimeAxiom = factory.getOWLDataPropertyAssertionAxiom(hasPOEMinutes, bridgeCrossIndividual, tempCrossWait[k]);
					manager.applyChange(new AddAxiom(ontology, crossingTimeAxiom));
				}

				// Bridge of America's : BOTA
				String urlBridgeOfAmerica = "http://bcis.tamu.edu/request2.aspx?call=getMonthlyPerformanceIndicators&bridgeID@varchar=BOTA&timeFrom@varchar=01/01/2014%2000:00&timeTo@varchar=12/31/2014%2000:00"; 
				ParseWebsite websiteParserBOA = new ParseWebsite();
				websiteParserBOA.getHTML(urlBridgeOfAmerica);
				String[] americastempCrossDates = websiteParserBOA.portOfEntryDates;
				int[] americastempCrossWait = websiteParserBOA.portOfEntryWait;

				for(int k=0;k<tempCrossDates.length;k++){
					OWLNamedIndividual bridgeCrossIndividual = factory.getOWLNamedIndividual(IRI.create("americasBridgeCrossIndividual_"+(k+1)));
					OWLClassAssertionAxiom americasPortOfEntryClassAssertion = factory.getOWLClassAssertionAxiom(americasPortOfEntryClass, bridgeCrossIndividual);
					manager.applyChange(new AddAxiom(ontology,americasPortOfEntryClassAssertion));

					String tempDateString = americastempCrossDates[k];
					OWLLiteral crossingDateLiteral = factory.getOWLTypedLiteral(tempDateString, OWL2Datatype.XSD_DATE_TIME);

					OWLAxiom hasDateAxiom = factory.getOWLDataPropertyAssertionAxiom(hasPOEMonth, bridgeCrossIndividual, crossingDateLiteral);
					manager.applyChange(new AddAxiom(ontology, hasDateAxiom));

					OWLAxiom crossingTimeAxiom = factory.getOWLDataPropertyAssertionAxiom(hasPOEMinutes, bridgeCrossIndividual, americastempCrossWait[k]);
					manager.applyChange(new AddAxiom(ontology, crossingTimeAxiom));
				}

				/* Website data insertion as individual start */

				/*
				OWLNamedIndividual ysletaBridgeAvgWaitingTimeIndividual = factory.getOWLNamedIndividual(IRI.create((websiteParserYsletaBridge.averageCrossTime)+""));
				OWLClassAssertionAxiom ysletaBridgeAvgWaitingTimeClassAssertion = factory.getOWLClassAssertionAxiom(ysletaPortOfEntryClass, ysletaBridgeAvgWaitingTimeIndividual);
				manager.applyChange(new AddAxiom(ontology,ysletaBridgeAvgWaitingTimeClassAssertion));

				OWLNamedIndividual boaBridgeAvgWaitingTimeIndividual = factory.getOWLNamedIndividual(IRI.create((websiteParserBOA.averageCrossTime)+""));
				OWLClassAssertionAxiom boaBridgeAvgWaitingTimeClassAssertion = factory.getOWLClassAssertionAxiom(bridgeOfTheAmericasAverageWaitingTimeClass, boaBridgeAvgWaitingTimeIndividual);
				manager.applyChange(new AddAxiom(ontology,boaBridgeAvgWaitingTimeClassAssertion));
				 */
				double poeAvgWaitingTime = (websiteParserYsletaBridge.averageCrossTime + websiteParserBOA.averageCrossTime)/2;
				/*
				OWLNamedIndividual poeIndividual = factory.getOWLNamedIndividual(IRI.create((poeAvgWaitingTime)+""));
				OWLClassAssertionAxiom poeAvgWaitingTimeClassAssertion = factory.getOWLClassAssertionAxiom(portOfEntryClass, poeIndividual);
				manager.applyChange(new AddAxiom(ontology,poeAvgWaitingTimeClassAssertion));
				 */
				/* Website data insertion as individual end */


				double convertionUNIT = 0.008887;
				double gasolineAmount = 9360000;
				double co2EmissionValue = (convertionUNIT*gasolineAmount);
				OWLNamedIndividual cO2EmissionIndividual = factory.getOWLNamedIndividual(IRI.create((co2EmissionValue)+""));
				OWLClassAssertionAxiom cO2EmissionClassAssertion = factory.getOWLClassAssertionAxiom(cO2EmissionClass, cO2EmissionIndividual);
				manager.applyChange(new AddAxiom(ontology,cO2EmissionClassAssertion));



			}catch (Exception e){
				e.printStackTrace();
			}
			
			
			

			for(int k=0;k<366;k++){
				OWLNamedIndividual weatherMetricIndividual = factory.getOWLNamedIndividual(IRI.create("WeatherMetricIndividual_"+k));
				OWLClassAssertionAxiom dailyWeatherMetricClasssAssertion = factory.getOWLClassAssertionAxiom(dailyWeatherMetricClass, weatherMetricIndividual);
				manager.applyChange(new AddAxiom(ontology,dailyWeatherMetricClasssAssertion));


				String tempDateString = "2014-01-01T00:00:00-07:00";
				OWLLiteral weatherDateLiteral = factory.getOWLTypedLiteral(tempDateString, OWL2Datatype.XSD_DATE_TIME);

				OWLAxiom hasWeatherDateAxiom = factory.getOWLDataPropertyAssertionAxiom(hasDailyWeatherDate, weatherMetricIndividual, weatherDateLiteral);
				manager.applyChange(new AddAxiom(ontology, hasWeatherDateAxiom));

				OWLAxiom hasWeatherTemperatureAxiom = factory.getOWLDataPropertyAssertionAxiom(hasDailyWeatherTemperature, weatherMetricIndividual, 73.0);
				manager.applyChange(new AddAxiom(ontology, hasWeatherTemperatureAxiom));

				OWLAxiom hasWeatherPrecipitationAxiom = factory.getOWLDataPropertyAssertionAxiom(hasDailyWeatherPrecipitation, weatherMetricIndividual, 0.61);
				manager.applyChange(new AddAxiom(ontology, hasWeatherPrecipitationAxiom));

				//OWLDataProperty hasDailyWeatherPrecipitation = factory.getOWLDataProperty(IRI.create(prefix  + "hasDailyWeather.Precipitation"));
				//OWLDataProperty hasDailyWeatherTemperature = factory.getOWLDataProperty(IRI.create(prefix  + "hasDailyWeather.Temperature"));
				//OWLDataProperty hasDailyWeatherDate = factory.getOWLDataProperty(IRI.create(prefix  + "hasDailyWeather.Date"));
			}
			File file = new File(ontFile);
			file.createNewFile();

			FileOutputStream outputStream = new FileOutputStream(file);
			manager.saveOntology(ontology, outputStream);
			System.out.println("Done Saving");
		}
		catch (Exception e) {
			e.printStackTrace();
		}


	}
}
