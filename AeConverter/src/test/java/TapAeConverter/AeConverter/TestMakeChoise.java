package TapAeConverter.AeConverter;

import static org.junit.Assert.*;

import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.collect.MapMaker;

public class TestMakeChoise {

	private FrameFixture frameFix;

	@BeforeClass
	  public static void setUpOnce() {
	    FailOnThreadViolationRepaintManager.install();
//	    Settings s1 = new Settings();
//	    s1.delayBetweenEvents(75); //default change this to change time between events
	  }

	@Before
	public void setUp() throws Exception {
		GuiFrame frame = GuiActionRunner.execute(() -> new GuiFrame(new MakeChoise()));
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

	@Test(expected = org.assertj.swing.exception.ComponentLookupException.class)
	public void testCloseButton() {
		frameFix.button("btnClose").click();
		frameFix.panel("makeChoise").requireVisible();
	}
	
}
