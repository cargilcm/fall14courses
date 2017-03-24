package soc.cofc.edu.ejb;

//import javax.ejb.Stateless;

import com.whitestein.lsps.common.ErrorException;
import com.whitestein.lsps.engine.ExecutableTask;
import com.whitestein.lsps.engine.TerminationReason;
import com.whitestein.lsps.engine.ExecutableTask.Result;
import com.whitestein.lsps.engine.lang.TaskContext;
import com.whitestein.lsps.lang.exec.RecordHolder;

@SuppressWarnings("javadoc")
public class States implements ExecutableTask {

	@Override
	public Result start(TaskContext context) throws ErrorException {
		try {
			RecordHolder airportCodes = (RecordHolder)context.getParameter("airportCodes");
			String departureCode = (String)airportCodes.getProperty("departureCode");
			String arrivalCode = (String)airportCodes.getProperty("arrivalCode");

			RecordHolder zones = (RecordHolder)context.getParameter("states");
			zones.setProperty("departureState", State.airportCodeToStateCode(departureCode));
			zones.setProperty("arrivalState", State.airportCodeToStateCode(arrivalCode));
		
		} catch (Exception e) {
			throw new ErrorException("Exception coverting States to Zones", e);
		}
		return Result.FINISHED;
	}

	@Override
	public Result processInput(TaskContext arg0, Object arg1)
			throws ErrorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void terminate(TaskContext arg0, TerminationReason arg1)
			throws ErrorException {
		// TODO Auto-generated method stub
		
	}
	


}
