package utility;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class Report {

	private static ExtentReports reporter;

	public static synchronized ExtentReports getReporter() {
		if (reporter == null) {
			reporter = new ExtentReports("Execution Report.html", true, DisplayOrder.NEWEST_FIRST);
		}
		return reporter;
	}

	public static synchronized void closeReporter() {
		reporter.flush();
		reporter.close();
	}

}
