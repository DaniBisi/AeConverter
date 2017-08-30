package tapaeconverter.aeconverter;

//import org.assertj.swing.*;
//
//import javax.swing.SwingUtilities;
//
//import org.assertj.swing.core.BasicRobot;
//import org.assertj.swing.core.Robot;
//import org.assertj.swing.core.Settings;
import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
//import org.assertj.swing.security.ExitCallHook;
//import org.assertj.swing.security.NoExitSecurityManager;
//import org.assertj.swing.security.NoExitSecurityManagerInstaller;
import org.junit.After;
//import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
//import org.junit.Ignore;
//import org.junit.Rule;
import org.junit.Test;
import tapaeconverter.aeconverter.BaseConverterGui;
import tapaeconverter.aeconverter.FrameGui;

//import static org.junit.Assert.assertEquals;

public class TestBaseConverterGui{
	//private static NoExitSecurityManagerInstaller noExitSecurityManagerInstaller;
	private FrameFixture frameFix;
	
	@BeforeClass
	public static void setUpOnce() {
//		ehwf = new exitHookWithFeedBack();
//		noExitSecurityManagerInstaller = NoExitSecurityManagerInstaller
//				.installNoExitSecurityManager(ehwf);
		FailOnThreadViolationRepaintManager.install();
	}

	@Before
	public void setUp() throws Exception {
		// Robot robot = BasicRobot.robotWithNewAwtHierarchy();
		// robot.settings().delayBetweenEvents(100);
		int bounds[] = new int[] {100,180,450,330};
		FrameGui frame = GuiActionRunner.execute(() -> new FrameGui(new BaseConverterGui(),bounds,true));
		// frameFix = new FrameFixture(robot, frame);
		frameFix = new FrameFixture(frame);

		// frameFix.button("base_converter").click();
		// frameFix.textBox("number").deleteText();
		// frameFix.show();
		// frameFix.show();

	}

	@After
	public void tearDown() throws Exception {
		frameFix.cleanUp();
	//	noExitSecurityManagerInstaller.uninstall();
	}

	@Test
	public void testBaseConverterButtonChangePanel() {
		frameFix.panel("baseConverter");
	}

	@Test
	public void TestBase_ConverterDisabledButtonText() {
		frameFix.panel("baseConverter");
		frameFix.textBox("number").enterText("103");
		frameFix.button("calc").requireDisabled();
	}

	@Test
	public void TestBase_ConverterConversionRequireEnabled() {
		frameFix.panel("baseConverter");
		frameFix.textBox("number").enterText("101");
		frameFix.button("calc").requireEnabled();
	}

	@Test
	public void TestBase_ConverterConversion() {
		// frameFix.show();
		frameFix.panel("baseConverter");
		frameFix.textBox("number").enterText("101");
		frameFix.button("calc").click();
		frameFix.show();
		frameFix.textBox("tpResult").requireText("5");
	}

	@Test
	public void TestBase_ConverterClearTextPaneDisabledButton() {
		frameFix.panel("baseConverter");
		frameFix.textBox("number").enterText("103");
		frameFix.textBox("number").pressAndReleaseKeys(8, 8, 8);
		frameFix.textBox("number").requireText("");
		frameFix.button("calc").requireDisabled();
	}

	@Test
	public void TestBase_ConverterEnabledButtonText() {
		frameFix.panel("baseConverter");
		frameFix.textBox("number").enterText("101");
		frameFix.button("calc").requireEnabled();

	}

	@Test
	public void TestBase_ConverterEnabledButtonTextAfterChangeBase() {
		frameFix.panel("baseConverter");
		frameFix.textBox("number").enterText("FFFF");
		frameFix.comboBox("baseStart").selectItem(14);
		frameFix.button("calc").requireEnabled();
	}

	@Test
	public void TestBase_ConverterUpperCase() {
		frameFix.panel("baseConverter");
		frameFix.textBox("number").enterText("ff");
		frameFix.comboBox("baseStart").selectItem(14);
		frameFix.button("calc").requireEnabled();
	}

	@Test
	public void TestBase_ConverterBase() {

		// frameFix.panel("baseConverter");
		frameFix.textBox("number").enterText("10");
		frameFix.button("calc").requireEnabled();
		frameFix.button("calc").click();
		frameFix.textBox("tpResult").requireText("2");

	}

	@Test
	public void TestStepByStepButtonChangePanel() {
		frameFix.textBox("number").enterText("10");
		frameFix.button("calc").requireEnabled();
		frameFix.button("calc").click();
		frameFix.button("btnStepByStep").click();
		frameFix.panel("stepByStep").requireEnabled();

	}

	@Test
	public void TestBase_converterBackButton() {
		// System.out.println(frameFix.panel("baseConverter").getClass());
		// System.out.println(frameFix.panel("baseConverter"));
		frameFix.button("back").click();
		frameFix.panel("makeChoise").requireEnabled();
	}
//
	@Test//(expected=org.junit.contrib.java.lang.system.internal.CheckExitCalled.class)
	public void TestBase_converterChiudiButton() {
		frameFix.button("close").click();
		frameFix.requireNotVisible();
	}
}
