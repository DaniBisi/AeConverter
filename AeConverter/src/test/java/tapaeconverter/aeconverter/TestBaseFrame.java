package tapaeconverter.aeconverter;

import static org.junit.Assert.*;

import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.*;

public abstract class TestBaseFrame {

	protected FrameFixture frameFix;
//	private HomeGui b1;

//	@BeforeClass
//	public static void setUpOnce() {
//		FailOnThreadViolationRepaintManager.install();
//	}
//
//	@Before
//	public void setUp() throws Exception {
//		//b1 = new MakeChoiseGui();//= mock(MakeChoiseGui.class);
//		FrameGui frame = GuiActionRunner.execute(() -> new FrameGui(new HomeGui(), true));
//		frameFix = new FrameFixture(frame);
//
//	}
//
//	@After
//	public void tearDown() throws Exception {
//		frameFix.cleanUp();
//	}

	@Test
	public void testMenuFile() {
		frameFix.menuItem("File").requireEnabled();
	}
	@Test
	public void testMenuFileClose() {
		frameFix.menuItem("File").click();
		frameFix.menuItem("close").click();
		frameFix.requireNotVisible();
	}

	@Test
	public void testNewBaseConversion() {
		frameFix.menuItem("File").click();
		frameFix.menuItem("baseConversion").click();
		frameFix.panel("baseConverter").requireVisible();
	}

}
