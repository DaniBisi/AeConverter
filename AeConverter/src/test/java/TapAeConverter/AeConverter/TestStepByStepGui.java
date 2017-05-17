package TapAeConverter.AeConverter;


import org.assertj.swing.core.Settings;


import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.*;

import static org.assertj.swing.core.MouseClickInfo.leftButton;

import java.util.ArrayList;

import javax.swing.JFrame;
public class TestStepByStepGui{

	private FrameFixture frameFix;
	private XtoTenConverter x1;
	private TenToXConverter t1;
	private ArrayList <String> r1;
	
	public TestStepByStepGui() {
		r1 = new ArrayList<String>();
		x1 = mock(XtoTenConverter.class);
		t1 = mock(TenToXConverter.class);
	}
	@BeforeClass
	  public static void setUpOnce() {
	    //FailOnThreadViolationRepaintManager.install();
	    Settings s1 = new Settings();
	    s1.delayBetweenEvents(75); //default change this to change time between events
	  }

	@Before
	public void setUp() throws Exception {
		StepByStep sbs = new StepByStep(x1,t1);
		GuiFrame frame = GuiActionRunner.execute(() -> new GuiFrame(sbs));
		frameFix = new FrameFixture(frame);
		//frameFix.show();
	}

	@After
	public void tearDown() throws Exception {
		frameFix.cleanUp();

	}

	@Test
	public void testBtnBackDisabletAtStart() {
		frameFix.panel("stepByStep");
		frameFix.button("btnBack").requireDisabled();
	}
	@Test
	public void testF() {
		frameFix.panel("stepByStep");
		frameFix.button("btnForward").click();
		frameFix.textBox("dividend").requireText("boh");
	}
	@Test
	public void testForwarButtonChangeBackButtonState(){
		frameFix.button("btnForward").click();
		frameFix.button("btnBack").requireEnabled();
	}
	@Test
	public void testForwarXButtonChangeTextPaneDividendState(){
		r1.add("simple text");
		when(x1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForward").click();
		frameFix.textBox("dividend").requireText("simple text");
	}
	@Test
	public void testForwarXButtonChangeTextPaneDividendStateTwoString(){
		r1.add("simple text");
		r1.add("second simple text");
		when(x1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForward").click();
		frameFix.button("btnForward").click();
		frameFix.textBox("dividend").requireText("simple text\nsecond simple text\n");
	}
	@Test
	public void testForwarXButtonChangeTextPaneDividendStateMoreClickThanStep(){
		r1.add("simple text");
		r1.add("second simple text");
		when(x1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForward").click();
		frameFix.button("btnForward").click();
		frameFix.button("btnForward").click();
		frameFix.textBox("dividend").requireText("simple text\nsecond simple text\n");
	}
	@Test
	public void testForwarTButtonChangeTextPaneDividendStateTwoString(){
		r1.add("simple text");
		r1.add("second simple text");
		when(x1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForward").click();
		frameFix.button("btnForward").click();
		frameFix.textBox("dividend").requireText("simple text\nsecond simple text\n");
	}
}
