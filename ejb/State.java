package soc.cofc.edu.ejb;

public class State {
	
	private String code;
	
	@SuppressWarnings("javadoc")
	public State( String code ) throws Exception
	{
		code = code.toUpperCase().trim();
		
		if( isValidStateCode( code ))
			this.code = code;
		else
			throw new InvalidStateCodeException("state: " + code + " is invalid" );
	}
	
	@SuppressWarnings("javadoc")
	public String getCode()
	{
		return this.code;
	}
	
	public static String airportCodeToStateCode( String airportCode ) throws Exception
	{
		String rtnval = null;
		
		// call FAA Airport Code Service
		String stateName = RestfulServiceSupport.queryWithXMLReturn( "http://services.faa.gov/airport/status", 
				"/" + airportCode + "?format=application/xml", 
				"/AirportStatus/State" );
		
		rtnval = RestfulServiceSupport.queryWithXMLReturn("http://localhost:8880/exist/rest/db/simplefares", 
				"?_query=string(//state[@name='" + stateName + "']/@code)", 
				"//exist:value/text()" );
		
		return rtnval;
	}
	
	private static boolean isValidStateCode( String stateCode ) throws Exception
	{
		boolean isValid = false;
		
		if( RestfulServiceSupport.queryWithXMLReturn( "http://localhost:8880/exist/rest/db/simplefares", 
				"?_query=//state[@code='" + stateCode + "']", 
				"string(/exist:result/@exist:count)").equals("1"))
			isValid = true;
		
		return isValid;			
	}

	
	@SuppressWarnings("javadoc")
	public static void main( String args[]) throws Exception
	{
		if( State.isValidStateCode("NJ") )
			System.out.println( "State code is valid" );
		
		if( !State.isValidStateCode("BX"))
			System.out.println("State code is invalid" );
	}
}
