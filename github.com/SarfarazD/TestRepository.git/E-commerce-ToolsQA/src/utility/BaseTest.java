package utility;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import utility.Report2;

/*
 * This is a base Test class. All testng tests needs to inherited from
 * this class. It contains common reporting infra
 */
public class BaseTest {

	@BeforeMethod
	public void beforeMethod(Method caller) {
		Report2.getTest(caller.getName(), "This is a simple test from complex factory");
	}

	@AfterMethod
	public void afterMethod(Method caller) {
		Report2.closeTest(caller.getName());

	}

	/*
	 * After suite will be responsible to close the report properly at the end
	 * You an have another afterSuite as well in the derived class and this one
	 * will be called in the end making it the last method to be called in test exe
	 */
	@AfterSuite
	public void afterSuite() {
		Report2.closeReport();
	}

}
