package TapAeConverter.AeConverter;

import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestbaseConverterGui {

	private FrameFixture frameFix;

	@BeforeClass
	public static void setUpOnce() {
		FailOnThreadViolationRepaintManager.install();
	}

	@Before
	public void setUp() throws Exception {
		GuiFrame frame = GuiActionRunner.execute(() -> new GuiFrame());
		this.frameFix = new FrameFixture(frame);
		frameFix.show();
		frameFix.button("base_converter").click();
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
}
