package edu.illinois.cs.dt.tools.diagnosis;

import com.reedoei.eunomia.util.TestUtil;
import edu.washington.cs.dt.execution.JUnitTestExecution;
import edu.washington.cs.dt.main.ImpactMain;
import edu.washington.cs.dt.util.JUnitTestExecutor;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Optional;

public class StateDiffTest {
    private static final String TEST_CLASS_FQN = "edu.washington.cs.dt.samples.StateDiffSampleTest";
    private static final String TEST1_FQN = TEST_CLASS_FQN + ".test1";
    private boolean originalValue;

    @BeforeClass
    public static void beforeClass() {
    }

    @Before
    public void setUp() {
        originalValue = ImpactMain.captureState;
        ImpactMain.captureState = true;
    }

    @After
    public void tearDown() {
        ImpactMain.captureState = originalValue;
    }

    @Test
    public void testBasicDiffStaticState() throws Exception {

        final Optional<JUnitTestExecution> execution =
                JUnitTestExecutor.singleton(TEST1_FQN).execute();

        TestUtil.testThat(execution, e -> {
            if (!e.getStateDiffs().containsKey(TEST1_FQN)) {
                return false;
            }

            final Optional<DiffContainer.Diff> diff = e.getStateDiffs().get(TEST1_FQN).getDiff(TEST_CLASS_FQN + ".x");
            TestUtil.testThat(diff, d -> !d.getBefore().equals(d.getAfter()));

            return true;
        });
    }
}