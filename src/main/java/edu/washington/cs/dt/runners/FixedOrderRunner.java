/** Copyright 2012 University of Washington. All Rights Reserved.
 *  @author Sai Zhang
 */
package edu.washington.cs.dt.runners;

import java.util.List;
import java.util.Map;

import edu.washington.cs.dt.OneTestExecResult;
import edu.washington.cs.dt.TestExecResults;
import edu.washington.cs.dt.main.Main;
import edu.washington.cs.dt.util.TestExecUtils;

public class FixedOrderRunner extends AbstractTestRunner {
    private final String javaAgent;

    public FixedOrderRunner(List<String> tests) {
        super(tests);
        this.javaAgent = "";
    }
    //overloaded
    public FixedOrderRunner(List<String> tests, String tmpfilepath) {
        this(tests, tmpfilepath, "");
    }

    public FixedOrderRunner(String fileName) {
        this(fileName, "");
    }

    public FixedOrderRunner(String classpath, List<String> tests) {
        this(classpath, tests, "");
    }

    public FixedOrderRunner(List<String> tests, String tmpfilepath, String javaAgent) {
        super(tests, tmpfilepath);

        this.javaAgent = javaAgent;
    }

    public FixedOrderRunner(String fileName, String javaAgent) {
        super(fileName);

        this.javaAgent = javaAgent;
    }

    public FixedOrderRunner(String classpath, List<String> tests, String javaAgent) {
        super(classpath, tests);
        this.javaAgent = javaAgent;
    }

    @Override
    public TestExecResults run() {
		System.out.println("Executing fixed runner now.");

        TestExecResults result = TestExecResults.createInstance();
        //Map<String, OneTestExecResult> singleRun = TestExecUtils.executeTestsInFreshJVM(super.getClassPath(),
                //super.getTmpOutputFile(), super.junitTestList);

        TestExecUtils util = new TestExecUtils();
        Map<String, OneTestExecResult> singleRun = util.executeTestsInFreshJVM(super.getClassPath(),
                super.getTmpOutputFile(), super.junitTestList, super.getThreadnum(), javaAgent);

        result.addExecutionResults(singleRun);
        //check do we need to dump the fixed ordered results to an intermediate file
        if(Main.fixedOrderReport != null) {
            super.saveResultsToFile(singleRun, Main.fixedOrderReport);
        }
        return result;
    }
}
