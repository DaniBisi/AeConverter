package tapaeconverter.aeconverter;

import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import tapaeconverter.aeconverter.FrameGui;
import tapaeconverter.aeconverter.MakeChoiseGui;

public class TestMakeChoiseGui {

	private FrameFixture frameFix;

	@BeforeClass
	  public static void setUpOnce() {
	    FailOnThreadViolationRepaintManager.install();
//	    Settings s1 = new Settings();
//	    s1.delayBetweenEvents(75); //default change this to change time between events
	  }

	@Before
	public void setUp() throws Exception {
		FrameGui frame = GuiActionRunner.execute(() -> new FrameGui(new MakeChoiseGui()));
		frameFix = new FrameFixture(frame);
    	//frameFix.show();
		//frameFix.button("base_converter").click();
		//frameFix.textBox("Number").deleteText();
		//frameFix.show();

	}
	@After
	public void tearDown() throws Exception {
		frameFix.cleanUp();

	}

	@Test public void testMakeChoiseVisibility() {
		frameFix.panel("makeChoise").requireVisible();	
	}
	@Test
	public void testBaseConvmakeChoiseerterButtonChangePanel() {
		frameFix.button("base_converter").click();
		frameFix.panel("baseConverter").requireVisible();
	}

	@Test
	public void TestBase_converterChiudiButton() {
		frameFix.button("Chiudi").click();
		frameFix.requireNotVisible();
	}
	
}
