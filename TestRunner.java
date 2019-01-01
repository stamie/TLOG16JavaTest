
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

    public static void main(String[] args) {
        Result resultTask = JUnitCore.runClasses(TestTask.class);
        Result resultWorkDay = JUnitCore.runClasses(TestWorkDay.class);
        for (Failure failure : resultTask.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(resultTask.wasSuccessful());
        System.out.println(resultWorkDay.wasSuccessful());
    }
}
