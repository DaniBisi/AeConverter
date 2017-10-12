package tapaeconverter.aeconverter;

import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import tapaeconverter.aeconverter.FrameGui;
import tapaeconverter.aeconverter.HomeGui;

public class TestHomeGui extends TestBaseFrame {


	public TestHomeGui() {
		super();
	}

	@BeforeClass
	public static void setUpOnce() {
		FailOnThreadViolationRepaintManager.install();
	}

	@Before
	public void setUp() throws Exception {
		FrameGui frame = GuiActionRunner.execute(() -> new FrameGui(new HomeGui(), true));
		frameFix = new FrameFixture(frame);
	}

	@After
	public void tearDown() throws Exception {
		frameFix.cleanUp();

	}

	@Test
	public void testMakeChoiseVisibility() {
		frameFix.panel("homeGui").requireVisible();
	}

	@Test
	public void testLabelWellcome() {
		frameFix.label("lblWellcome").requireVisible();
	}

	@Test
	public void testLabelHelp() {
		frameFix.label("lblHelp").requireVisible();
	}

}
