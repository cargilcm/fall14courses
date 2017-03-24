package soc.cofc.edu.ejb;

//import javax.ejb.Stateless;

import com.whitestein.lsps.common.ErrorException;
import com.whitestein.lsps.engine.ExecutableTask;
import com.whitestein.lsps.engine.TerminationReason;
import com.whitestein.lsps.engine.lang.TaskContext;
import com.whitestein.lsps.lang.exec.RecordHolder;


@SuppressWarnings("javadoc")
//@Stateless
public class Zones implements ExecutableTask {

	@Override
	public Result start(TaskContext context) throws ErrorException {
		try {
			RecordHolder stateCodes = (RecordHolder)context.getParameter("states");
			String departure = (String)stateCodes.getProperty("departureState");
			String arrival = (String)stateCodes.getProperty("arrivalState");

			RecordHolder zones = (RecordHolder)context.getParameter("zones");
			zones.setProperty("departureZone", Zone.stateToZone(departure));
			zones.setProperty("arrivalZone", Zone.stateToZone(arrival));
		
		} catch (Exception e) {
			throw new ErrorException("Exception coverting States to Zones", e);
		}
		return Result.FINISHED;
	}

	@Override
	public Result processInput(TaskContext context, Object input) {
		return null;
	}

	@Override
	public void terminate(TaskContext context, TerminationReason reason) {
		// do nothing
	}
}
