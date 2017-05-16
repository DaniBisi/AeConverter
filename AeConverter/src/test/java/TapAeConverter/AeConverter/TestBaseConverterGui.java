package TapAeConverter.AeConverter;


import org.assertj.swing.core.Settings;


import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.assertj.swing.core.MouseClickInfo.leftButton;
public class TestBaseConverterGui {

	private FrameFixture frameFix;

	@BeforeClass
	  public static void setUpOnce() {
	    FailOnThreadViolationRepaintManager.install();
	    Settings s1 = new Settings();
	    s1.delayBetweenEvents(75); //default change this to change time between events
	  }

	@Before
	public void setUp() throws Exception {
		GuiFrame frame = GuiActionRunner.execute(() -> new GuiFrame());
		this.frameFix = new FrameFixture(frame);
		frameFix.show();
		frameFix.button("base_converter").click(leftButton().times(3));
		//frameFix.textBox("Number").deleteText();

	}

	@After
	public void tearDown() throws Exception {
		frameFix.cleanUp();

	}

	@Test
	public void testBaseConverterButtonChangePanel() {
		frameFix.panel("baseConverter");
	}

	//non worka non so perchè dovrebbe generare errore o fallire....
	@Test
	public void testBase_ConverterCloseButton() {
		frameFix.panel("baseConverter");
		frameFix.button("chiudi").click();
		frameFix.button("chiudi").click();
	}

	@Test
	public void TestBase_ConverterDisabledButtonText() {
		frameFix.panel("baseConverter");
		frameFix.textBox("Number").enterText("103");
		frameFix.button("Calcola").requireDisabled();
	}
	@Test
	public void TestBase_ConverterConversion() {
		frameFix.panel("baseConverter");
		frameFix.show();
		frameFix.textBox("Number").enterText("101");
		frameFix.button("Calcola").requireEnabled();
		frameFix.button("Calcola").focus();
		frameFix.button("Calcola").pressKey(13);
		frameFix.textBox("tpResult").requireText("5");
	}
	@Test
	public void TestBase_ConverterClearTextPaneDisabledButton() {
		frameFix.panel("baseConverter");
		frameFix.textBox("Number").enterText("103");
		frameFix.textBox("Number").pressAndReleaseKeys(8,8,8);
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
	public void TestBase_ConverterBase() {

		frameFix.show();
		frameFix.panel("baseConverter");
		frameFix.textBox("Number").enterText("10");
		frameFix.button("Calcola").requireEnabled();
		frameFix.button("Calcola").click();
		frameFix.textBox("tpResult").requireText("2");

		
	}
	@Test
	public void TestBase_converterBackButton(){
//		System.out.println(frameFix.panel("baseConverter").getClass());
//		System.out.println(frameFix.panel("baseConverter"));
		frameFix.button("indietro1").click(leftButton().times(3));
		frameFix.panel("makeChoise");
	}
	
}
