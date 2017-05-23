package TapAeConverter.AeConverter;

import org.assertj.swing.*;

import javax.swing.SwingUtilities;

import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.core.Settings;
import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class TestBaseConverterGui {

	private FrameFixture frameFix;

	@BeforeClass
	public static void setUpOnce() {
		FailOnThreadViolationRepaintManager.install();
	}

	@Before
	public void setUp() throws Exception {
		Robot robot = BasicRobot.robotWithNewAwtHierarchy();
		robot.settings().delayBetweenEvents(150);
		GuiFrame frame = GuiActionRunner.execute(() -> new GuiFrame(new BaseConverter()));
		frameFix = new FrameFixture(robot, frame);


		// frameFix.button("base_converter").click();
		// frameFix.textBox("Number").deleteText();
		// frameFix.show();

	}

	@After
	public void tearDown() throws Exception {
		frameFix.cleanUp();

	}

	@Test
	public void testBaseConverterButtonChangePanel() {
		frameFix.panel("baseConverter");
	}

	// non worka non so perchè dovrebbe generare errore o fallire....
	@Ignore
	public void testBase_ConverterCloseButton() {
		frameFix.panel("baseConverter");
		frameFix.button("chiudi").click();
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
	public void TestBase_converterBackButton() {
		// System.out.println(frameFix.panel("baseConverter").getClass());
		// System.out.println(frameFix.panel("baseConverter"));
		frameFix.button("indietro1").click();
		frameFix.panel("makeChoise");
	}

}
