package TapAeConverter.AeConverter;

import org.assertj.swing.*;

import javax.swing.SwingUtilities;

import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.core.Settings;
import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.security.ExitCallHook;
import org.assertj.swing.security.NoExitSecurityManager;
import org.assertj.swing.security.NoExitSecurityManagerInstaller;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import static org.junit.Assert.assertEquals;

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
		GuiFrame frame = GuiActionRunner.execute(() -> new GuiFrame(new BaseConverter()));
		// frameFix = new FrameFixture(robot, frame);
		frameFix = new FrameFixture(frame);

		// frameFix.button("base_converter").click();
		// frameFix.textBox("Number").deleteText();
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
		frameFix.textBox("Number").enterText("103");
		frameFix.button("Calcola").requireDisabled();
	}

	@Test
	public void TestBase_ConverterConversionRequireEnabled() {
		frameFix.panel("baseConverter");
		frameFix.textBox("Number").enterText("101");
		frameFix.button("Calcola").requireEnabled();
	}

	@Test
	public void TestBase_ConverterConversion() {
		// frameFix.show();
		frameFix.panel("baseConverter");
		frameFix.textBox("Number").enterText("101");
		frameFix.button("Calcola").click();
		frameFix.show();
		frameFix.textBox("tpResult").requireText("5");
	}

	@Test
	public void TestBase_ConverterClearTextPaneDisabledButton() {
		frameFix.panel("baseConverter");
		frameFix.textBox("Number").enterText("103");
		frameFix.textBox("Number").pressAndReleaseKeys(8, 8, 8);
		frameFix.textBox("Number").requireText("");
		frameFix.button("Calcola").requireDisabled();
	}

	@Test
	public void TestBase_ConverterEnabledButtonText() {
		frameFix.panel("baseConverter");
		frameFix.textBox("Number").enterText("101");
		frameFix.button("Calcola").requireEnabled();

	}

	@Test
	public void TestBase_ConverterEnabledButtonTextAfterChangeBase() {
		frameFix.panel("baseConverter");
		frameFix.textBox("Number").enterText("FFFF");
		frameFix.comboBox("baseStart").selectItem(14);
		frameFix.button("Calcola").requireEnabled();
	}

	@Test
	public void TestBase_ConverterUpperCase() {
		frameFix.panel("baseConverter");
		frameFix.textBox("Number").enterText("ff");
		frameFix.comboBox("baseStart").selectItem(14);
		frameFix.button("Calcola").requireEnabled();
	}

	@Test
	public void TestBase_ConverterBase() {

		// frameFix.panel("baseConverter");
		frameFix.textBox("Number").enterText("10");
		frameFix.button("Calcola").requireEnabled();
		frameFix.button("Calcola").click();
		frameFix.textBox("tpResult").requireText("2");

	}

	@Test
	public void TestStepByStepButtonChangePanel() {
		frameFix.textBox("Number").enterText("10");
		frameFix.button("Calcola").requireEnabled();
		frameFix.button("Calcola").click();
		frameFix.button("btnStepByStep").click();
		frameFix.panel("stepByStep").requireEnabled();

	}

	@Test
	public void TestBase_converterBackButton() {
		// System.out.println(frameFix.panel("baseConverter").getClass());
		// System.out.println(frameFix.panel("baseConverter"));
		frameFix.button("indietro1").click();
		frameFix.panel("makeChoise").requireEnabled();
	}
//
	@Test//(expected=org.junit.contrib.java.lang.system.internal.CheckExitCalled.class)
	public void TestBase_converterChiudiButton() {
		frameFix.button("Chiudi").click();
		frameFix.requireNotVisible();
	}
}
