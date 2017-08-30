package tapaeconverter.aeconverter;

import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import tapaeconverter.aeconverter.FrameGui;
import tapaeconverter.aeconverter.MakeChoiseGui;

import static org.mockito.Mockito.*;

public class TestFrame {

	private FrameFixture frameFix;
	private int dBound[];

	public TestFrame() {
		dBound = new int[4];
		dBound[0] = 100;
		dBound[1] = 100;
		dBound[2] = 450;
		dBound[3] = 330;
	}

	@BeforeClass
	public static void setUpOnce() {
		FailOnThreadViolationRepaintManager.install();
	}

	 @Before
	 public void setUp() throws Exception {
		 FrameGui frame = GuiActionRunner.execute(() -> 
			new FrameGui(new MakeChoiseGui(),dBound,true));
	 frameFix = new FrameFixture(frame);
	 }
	@After
	public void tearDown() throws Exception {
		frameFix.cleanUp();

	}

	@Test
	public void testNewFrameWithNoParam() {
		
		frameFix.requireEnabled();
	}

	@Test
	public void test() {

		frameFix.button("baseConverter").click();
		frameFix.panel("baseConverter").requireVisible();
	}

	@Test
	public void TestBase_converterChiudiButton() {
		frameFix.button("close").click();
		frameFix.requireNotVisible();
	}

}
