package tapaeconverter.aeconverter;

import java.awt.Color;

import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import tapaeconverter.aeconverter.BaseConverterGui;
import tapaeconverter.aeconverter.FrameGui;

public class TestBaseConverterGui {
	private FrameFixture frameFix;

	@BeforeClass
	public static void setUpOnce() {
		FailOnThreadViolationRepaintManager.install();
	}

	@Before
	public void setUp() throws Exception {
		int bounds[] = new int[] { 100, 180, 450, 390 };
		FrameGui frame = GuiActionRunner.execute(() -> new FrameGui(new BaseConverterGui(), bounds, true));
		frameFix = new FrameFixture(frame);

	}

	@After
	public void tearDown() throws Exception {
		frameFix.cleanUp();
	}

	@Test
	public void testBaseConverterButtonChangePanel() {
		frameFix.panel("baseConverter");
	}

	@Test
	public void testBaseConverterCalcDisabledDefault() {
		frameFix.button("calc").requireDisabled();
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
		frameFix.textBox("number").pressAndReleaseKeys(48);
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
		frameFix.button("back").click();
		frameFix.panel("makeChoise").requireEnabled();
	}

	@Test
	public void TestBase_converterChiudiButton() {
		frameFix.button("close").click();
		frameFix.requireNotVisible();
	}

	// ##################### INTERACTION WITH LABEL ######################
	@Test
	public void TestLabelChangeColorIfError() {
		frameFix.textBox("number").enterText("5");
		frameFix.label("enterTheNumber").foreground().requireEqualTo(new Color(255, 0, 0));
	}

	@Test
	public void TestLabelChangeTextIfError() {
		frameFix.textBox("number").enterText("5");
		frameFix.label("enterTheNumber").requireText("Number is not valid in selected base.");
	}

	@Test
	public void TestLabelTextReturnNormalIfErrorIsCorrected() {
		frameFix.textBox("number").enterText("5");
		frameFix.textBox("number").pressAndReleaseKeys(8, 8, 8);
		frameFix.label("enterTheNumber").requireText("Enter the number to convert");
	}

	@Test
	public void TestLabelColorReturnNormalIfErrorIsCorrected() {
		frameFix.textBox("number").enterText("5");
		frameFix.textBox("number").pressAndReleaseKeys(8, 8, 8);
		frameFix.label("enterTheNumber").foreground().requireEqualTo(new Color(0, 0, 0));
	}
	@Test
	public void TestLabelTextChangeWhenInsertNumber() {
		frameFix.textBox("number").enterText("1001");
		frameFix.label("enterTheNumber").requireText("Click convert to continue...");
	}

	@Test
	public void TestLabelTextChangeAfterChangingBaseStart() {
		frameFix.textBox("number").enterText("2002");
		frameFix.comboBox("baseStart").selectItem(2);
		frameFix.label("enterTheNumber").requireText("Click convert to continue...");
	}

}
