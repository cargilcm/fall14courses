package soc.cofc.edu.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.whitestein.lsps.common.ComponentServiceBase;
import com.whitestein.lsps.common.ComponentServiceLocal;
import com.whitestein.lsps.engine.ExecutableTask;


/**
 * The central class for registering custom EJB components (custom LSPS tasks and functions).
 * The components have to be registered inside {@link ComponentServiceBean#registerCustomComponents()} method.
 * See a commented snippet in the source code for an example. 
 * POJO implementations of tasks and functions do not have to be registered.
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ComponentServiceBean extends ComponentServiceBase implements ComponentServiceLocal {

	/*
	 * To register a custom EJB task (e.g. com.whitestein.lsps.custom.MyCustomTask)
	 * the target EJB has to be injected using its local interface ExecutableTask
	 * and specifying beanName attribute (which is by default non-qualified class name of its implementation). 
	 * The instance of the given EJB task must be then registered under its implementation class.
	 * The task is then referenced in the model by its fully qualified implementation task name.
	 * 
	 * To register custom EJB functions (e.g. com.whitestein.lsps.custom.MyCustomFunctions)
	 * the target EJB has to be injected using its local interface (the local interface must declare
	 * all the functions that will be used in the model).
	 * The instance of the given EJB must be then registered under its local interface class.
	 * The target function is then referenced in the model using its fully qualified local interface name and method name.
	 * 


	@EJB(beanName = "MyCustomTask")
	private ExecutableTask myCustomTask;

	@EJB
	private MyFunctions myFunctions;


	@Override
	protected void registerCustomComponents() {
		register(myCustomTask, MyCustomTask.class);
		register(myFunctions, MyFunctions.class);
	}
	
	@EJB(beanName = "statesToZones")
	private ExecutableTask statesToZones;
	@EJB(beanName = "airportCodesToStates")
	private ExecutableTask airportCodesToStates;
	
	@Override
	protected void registerCustomComponents() {
		register(statesToZones, Zone.class);
		register(airportCodesToStates, State.class);
	}
	
	*/
}
