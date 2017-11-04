package tapaeconverter.aeconverter;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.awt.Color;
import java.util.ArrayList;

import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import tapaeconverter.aeconverter.BaseConverterGui;
import tapaeconverter.aeconverter.FrameGui;

public class TestBaseConverterGui extends TestBaseFrame {
	private XtoTenConverterCore x1;
	private TenToXConverterCore t1;
	private CheckSymbolCore c1;

		
	
	public TestBaseConverterGui() {
		super();
		x1 = mock(XtoTenConverterCore.class);
		t1 = mock(TenToXConverterCore.class);
		c1 = mock(CheckSymbolCore.class);
	}

	@BeforeClass
	public static void setUpOnce() {
		FailOnThreadViolationRepaintManager.install();
	}

	@Before
	public void setUp() throws Exception {
		FrameGui frame = GuiActionRunner.execute(() -> new FrameGui(new BaseConverterGui(c1,x1,t1), true));
		frameFix = new FrameFixture(frame);

	}

	@After
	public void tearDown() throws Exception {
		frameFix.cleanUp();
	}

	@Test
	public void testPanel() {
		frameFix.panel("baseConverter").requireVisible();
	}

	@Test
	public void testCalcDisabledDefault() {
		frameFix.button("calc").requireDisabled();
	}

	@Test
	public void testDisabledCalcButtonAfterWrongTextInserted() {
		frameFix.panel("baseConverter");
		frameFix.textBox("number").enterText("103");
		frameFix.button("calc").requireDisabled();
	}


	@Test
	public void testConversion() {

		when(c1.checkSymbols(anyString(),anyInt())).thenReturn(true,true,true);
		when(x1.deConvert(anyString())).thenReturn("5");
		when(t1.convert(anyInt())).thenReturn("5");
		frameFix.panel("baseConverter");
		frameFix.textBox("number").enterText("101");
		frameFix.button("calc").click();
		frameFix.textBox("tpResult").requireText("5");
	}

	@Test
	public void testClearTextPaneDisabledButton() {

		when(c1.checkSymbols(anyString(),anyInt())).thenReturn(true,true,true);
		frameFix.panel("baseConverter");
		frameFix.textBox("number").enterText("103");
		frameFix.textBox("number").pressAndReleaseKeys(8, 8, 8);
		frameFix.textBox("number").requireText("");
		frameFix.button("calc").requireDisabled();
	}


	@Test
	public void testEnabledButtonTextAfterChangeBase() {

		when(c1.checkSymbols(anyString(),anyInt())).thenReturn(false,false,false,false,true);
		frameFix.panel("baseConverter");
		frameFix.textBox("number").enterText("FFFF");
		frameFix.comboBox("baseStart").selectItem(14);
		frameFix.button("calc").requireEnabled();
	}


	@Test
	public void testStepByStepButtonChangePanel() {
		when(c1.checkSymbols(anyString(),anyInt())).thenReturn(true,true);	
		when(x1.deConvert(anyString())).thenReturn("2");
		when(t1.convert(anyInt())).thenReturn("2");
		frameFix.textBox("number").enterText("10");
		frameFix.button("calc").requireEnabled();
		frameFix.button("calc").click();
		frameFix.button("btnStepByStep").click();
		frameFix.panel("stepByStep").requireEnabled();

	}

	// ##################### INTERACTION WITH LABEL ######################
	@Test
	public void testLabelChangeColorIfError() {
		when(c1.checkSymbols(anyString(),anyInt())).thenReturn(false);	
		frameFix.textBox("number").enterText("5");
		frameFix.label("enterTheNumber").foreground().requireEqualTo(new Color(255, 0, 0));
	}

	@Test
	public void testLabelChangeTextIfError() {
		when(c1.checkSymbols(anyString(),anyInt())).thenReturn(false);	
		frameFix.textBox("number").enterText("5");
		frameFix.label("enterTheNumber").requireText("Number is not valid in selected base.");
	}

	@Test
	public void testLabelTextReturnNormalIfErrorIsCorrected() {
		when(c1.checkSymbols(anyString(),anyInt())).thenReturn(false,true);	
		frameFix.textBox("number").enterText("5");
		frameFix.textBox("number").pressAndReleaseKeys(8, 8, 8);
		frameFix.label("enterTheNumber").requireText("Enter the number to convert");
	}

	@Test
	public void testLabelColorReturnNormalIfErrorIsCorrected() {
		when(c1.checkSymbols(anyString(),anyInt())).thenReturn(false);	
		frameFix.textBox("number").enterText("5");
		frameFix.textBox("number").pressAndReleaseKeys(8, 8, 8);
		frameFix.label("enterTheNumber").foreground().requireEqualTo(new Color(0, 0, 0));
	}

	@Test
	public void testLabelTextChangeWhenInsertNumber() {
		when(c1.checkSymbols(anyString(),anyInt())).thenReturn(true,true,true,true);	
		frameFix.textBox("number").enterText("1001");
		frameFix.label("enterTheNumber").requireText("Click convert to continue...");
	}

	@Test
	public void testLabelTextChangeAfterChangingBaseStart() {
		when(c1.checkSymbols(anyString(),anyInt())).thenReturn(false,false,false,false,true);	
		frameFix.textBox("number").enterText("2002");
		frameFix.comboBox("baseStart").selectItem(2);
		frameFix.label("enterTheNumber").requireText("Click convert to continue...");
	}

}
