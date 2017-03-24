package soc.cofc.edu.ejb;

@SuppressWarnings("javadoc")
public class Zone {
	
	@SuppressWarnings("javadoc")
	public static String stateToZone( String stateCode ) throws Exception
	{
		State state = new State( stateCode );
		
		return RestfulServiceSupport.queryWithXMLReturn("http://localhost:8880/exist/rest/db/simplefares", 
				"?_query=string(//zone[state[@code='" + state.getCode() + "']]/@id)", 
				"//exist:value/text()" );
	}
}
