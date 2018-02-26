package tapaeconverter.aeconverter;

import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import tapaeconverter.aeconverter.FrameGui;
import tapaeconverter.aeconverter.StepByStepGui;
import tapaeconverter.aeconverter.TenToXConverterCore;
import tapaeconverter.aeconverter.XtoTenConverterCore;

import java.util.HashMap;
import java.util.Map;


public class TestIntegrationIT {
	private FrameGui frame;
	private FrameFixture frameFix;
	private XtoTenConverterCore x1;
	private TenToXConverterCore t1;
	private Map<String, Integer> dictionarySym;
	private Robot robot;

	public TestIntegrationIT() {
		dictionarySym = new HashMap<String, Integer>();
		dictionarySym.put("0", 0);
		dictionarySym.put("1", 1);
		dictionarySym.put("2", 2);
		dictionarySym.put("3", 3);
		dictionarySym.put("4", 4);
		dictionarySym.put("5", 5);
		dictionarySym.put("6", 6);
		dictionarySym.put("7", 7);
		dictionarySym.put("8", 8);
		dictionarySym.put("9", 9);
		dictionarySym.put("A", 10);
		dictionarySym.put("B", 11);
		dictionarySym.put("C", 12);
		dictionarySym.put("D", 13);
		dictionarySym.put("E", 14);
		dictionarySym.put("F", 15);
		robot = BasicRobot.robotWithNewAwtHierarchy();
		robot.settings().eventPostingDelay(100);
		robot.settings().delayBetweenEvents(100);
		robot.finder().includeHierarchyIfComponentNotFound(false);
	}

	@BeforeClass
	public static void setUpOnce() {
		FailOnThreadViolationRepaintManager.install();
	}

	private void initWithXConverter(int baseStart, String number) {

		x1 = new XtoTenConverterCore(baseStart, new CheckSymbolCore(dictionarySym));
		number = x1.deConvert(number);

		frame = GuiActionRunner.execute(() -> new FrameGui(new StepByStepGui(x1, null), true));
		frame.setAlwaysOnTop(true);
		frameFix = new FrameFixture(robot, frame);
		frameFix.show();
	}

	private void initWithTConverter(int baseDest, int number) {

		t1 = new TenToXConverterCore(baseDest);
		t1.convert(number);

		frame = GuiActionRunner.execute(() -> new FrameGui(new StepByStepGui(null, t1), true));
		frame.setAlwaysOnTop(true);
		frameFix = new FrameFixture(robot, frame);
		frameFix.show();
	}

	private void initWithNoConverter() {
		frame = GuiActionRunner.execute(() -> new FrameGui(new StepByStepGui(null, null), true));
		frame.setAlwaysOnTop(true);
		frameFix = new FrameFixture(robot, frame);
		frameFix.show();
	}

	@After
	public void tearDown() throws Exception {
		robot.cleanUp();
		frameFix.cleanUp();
	}

	// ###################### XtoTen Part ############################
	@Test
	public void testBtnBackDisabletAtStart() {
		initWithNoConverter();
		frameFix.button("btnBackX").requireDisabled();
	}

	@Test
	public void testForwardButtonChangeBackButtonState() {
		initWithXConverter(2, "1");
		frameFix.button("btnForwardX").click();
		frameFix.button("btnBackX").requireEnabled();
	}

	@Test
	public void testForwardXButtonChangeTextPane() {
		initWithXConverter(2, "1");
		frameFix.button("btnForwardX").click();
		frameFix.textBox("textPaneXtoTenResult").requireText("1*(2^0)\n");
	}

	@Test
	public void testForwardXButtonChangeTextPaneTwoString() {
		initWithXConverter(2, "10");
		frameFix.button("btnForwardX").click();
		frameFix.button("btnForwardX").click();
		frameFix.textBox("textPaneXtoTenResult").requireText("0*(2^0)\n1*(2^1)\n");
	}

	@Test
	public void testForwardXButtonDisabledAfterShowAllSteps() {

		initWithXConverter(2, "1");
		frameFix.button("btnForwardX").click();
		frameFix.button("btnForwardX").requireDisabled();
	}

	@Test
	public void testBackButtonChangeTextPane() {

		initWithXConverter(2, "1");
		frameFix.button("btnForwardX").click();
		frameFix.button("btnBackX").click();
		frameFix.textBox("textPaneXtoTenResult").requireText("");

	}

	@Test
	public void testForwardXButtonDisabledMoreStep() {

		initWithXConverter(2, "10");
		frameFix.button("btnForwardX").click();
		frameFix.button("btnForwardX").click();
		frameFix.button("btnForwardX").requireDisabled();
	}

	@Test
	public void testForwardXButtonAfterBackButtonx() {

		initWithXConverter(2, "10");
		frameFix.button("btnForwardX").click();
		frameFix.button("btnForwardX").click();
		frameFix.button("btnBackX").click();
		frameFix.button("btnForwardX").click();
		frameFix.button("btnForwardX").requireDisabled();
	}

	@Test
	public void testBackXButtonEnabledAfterOneStep() {

		initWithXConverter(2, "10");
		frameFix.button("btnForwardX").click();
		frameFix.button("btnForwardX").click();
		frameFix.button("btnBackX").click();
		frameFix.button("btnBackX").requireEnabled();
	}

	@Test
	public void testBackButtonChangeTextPaneTwoString() {

		initWithXConverter(2, "10");
		frameFix.button("btnForwardX").click();
		frameFix.button("btnForwardX").click();
		frameFix.button("btnBackX").click();
		frameFix.textBox("textPaneXtoTenResult").requireText("0*(2^0)\n");
	}

	@Test
	public void testBackButtonChangeForwardStatus() {

		initWithXConverter(2, "10");
		frameFix.button("btnForwardX").click();
		frameFix.button("btnForwardX").click();
		frameFix.button("btnBackX").click();
		frameFix.button("btnForwardX").requireEnabled();
	}

	@Test
	public void testAllStep() {

		initWithXConverter(2, "10");
		frameFix.button("allStep").click();
		frameFix.textBox("textPaneXtoTenResult").requireText("0*(2^0)\n1*(2^1)\n");
	}

	@Test
	public void TestAllXStepChangeBtnBackStatus() {
		initWithXConverter(2, "10");
		frameFix.button("allStep").click();
		frameFix.button("btnBackX").requireEnabled();
	}

	@Test
	public void TestAllStepChangeBtnForwardStatus() {
		initWithXConverter(2, "10");
		frameFix.button("allStep").click();
		frameFix.button("btnForwardX").requireDisabled();
	}

	// ###################### END XtoTen Part ############################

	// ####################### TenToX Part ###############################
	@Test
	public void testBtnBackTDisabletAtStart() {

		initWithNoConverter();
		frameFix.button("btnBackT").requireDisabled();

	}

	@Test
	public void testForwardTButtonChangeBackButtonState() {

		initWithTConverter(5, 1);
		frameFix.button("btnForwardT").click();
		frameFix.button("btnBackT").requireEnabled();

	}

	@Test
	public void testForwardTButtonChangeTextPane() {

		initWithTConverter(5, 1);
		frameFix.button("btnForwardT").click();
		frameFix.textBox("textPaneTenToXResult").requireText("1%5 = 1\n");

	}

	@Test
	public void testForwardTButtonChangeTextPaneTwoString() {

		initWithTConverter(5, 10);
		frameFix.button("btnForwardT").click();
		frameFix.button("btnForwardT").click();
		frameFix.textBox("textPaneTenToXResult").requireText("10%5 = 0\n2%5 = 2\n");

	}

	@Test
	public void testForwardTButtonDisabledAfterShowAllSteps() {

		initWithTConverter(5, 1);
		frameFix.button("btnForwardT").click();
		frameFix.button("btnForwardT").requireDisabled();

	}

	@Test
	public void testBackTButtonChangeTextPane() {

		initWithTConverter(5, 1);
		frameFix.button("btnForwardT").click();
		frameFix.button("btnBackT").click();
		frameFix.textBox("textPaneTenToXResult").requireText("");

	}

	@Test
	public void testForwardTButtonDisabledMoreStep() {

		initWithTConverter(5, 10);
		frameFix.button("btnForwardT").click();
		frameFix.button("btnForwardT").click();
		frameFix.button("btnForwardT").requireDisabled();

	}

	@Test
	public void testForwardTButtonAfterBackButtonx() {

		initWithTConverter(5, 10);
		frameFix.button("btnForwardT").click();
		frameFix.button("btnForwardT").click();
		frameFix.button("btnBackT").click();
		frameFix.button("btnForwardT").click();
		frameFix.button("btnForwardT").requireDisabled();

	}

	@Test
	public void testBackTButtonEnabledAfterOneStep() {

		initWithTConverter(5, 10);
		frameFix.button("btnForwardT").click();
		frameFix.button("btnForwardT").click();
		frameFix.button("btnBackT").click();
		frameFix.button("btnBackT").requireEnabled();

	}

	@Test
	public void testBackTButtonChangeTextPaneTwoString() {

		initWithTConverter(5, 10);
		frameFix.button("btnForwardT").click();
		frameFix.button("btnForwardT").click();
		frameFix.button("btnBackT").click();
		frameFix.textBox("textPaneTenToXResult").requireText("10%5 = 0\n");

	}

	@Test
	public void testBackTButtonChangeForwardStatus() {

		initWithTConverter(5, 10);
		frameFix.button("btnForwardT").click();
		frameFix.button("btnForwardT").click();
		frameFix.button("btnBackT").click();
		frameFix.button("btnForwardT").requireEnabled();

	}

	@Test
	public void testAllStepT() {

		initWithTConverter(5, 10);
		frameFix.button("allStepT").click();
		frameFix.textBox("textPaneTenToXResult").requireText("10%5 = 0\n2%5 = 2\n");

	}

	@Test
	public void TestAllTStepChangeBtnBackStatus() {

		initWithTConverter(5, 10);
		frameFix.button("allStepT").click();
		frameFix.button("btnBackT").requireEnabled();

	}

	@Test
	public void TestAllStepChangebtnForwardTStatus() {

		initWithTConverter(5, 10);
		frameFix.button("allStepT").click();
		frameFix.button("btnForwardT").requireDisabled();

	}

}
