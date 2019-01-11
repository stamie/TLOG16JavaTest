
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

    public static void main(String[] args) {
//        Result resultTask = JUnitCore.runClasses(TestTask.class);
//        Result resultWorkDay = JUnitCore.runClasses(TestWorkDay.class);
//        Result resultWorkMonth = JUnitCore.runClasses(TestWorkMonth.class);
//        Result resultTimeLogger = JUnitCore.runClasses(TestTimeLogger.class);
        Result resultUtil = JUnitCore.runClasses(TestUtil.class);
        
//        for (Failure failure : resultTask.getFailures()) {
//            System.out.println(failure.toString());
//        }
//        System.out.println(resultTask.wasSuccessful());
//
//        for (Failure failure : resultWorkDay.getFailures()) {
//            System.out.println(failure.toString());
//        }
//        System.out.println(resultWorkDay.wasSuccessful());
//
//        for (Failure failure : resultWorkMonth.getFailures()) {
//            System.out.println(failure.toString());
//        }
//        System.out.println(resultWorkMonth.wasSuccessful());
//        
//        for (Failure failure : resultTimeLogger.getFailures()) {
//            System.out.println(failure.toString());
//        }
//        System.out.println(resultTimeLogger.wasSuccessful());
        
        for (Failure failure : resultUtil.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(resultUtil.wasSuccessful());
        
    }
}
