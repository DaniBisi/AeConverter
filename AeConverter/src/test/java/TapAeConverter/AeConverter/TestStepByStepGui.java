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


import java.util.ArrayList;

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
	    FailOnThreadViolationRepaintManager.install();
	}

	@Before
	public void setUp() throws Exception {
//		StepByStep sbs = new StepByStep(x1,t1);
		GuiFrame frame = GuiActionRunner.execute(() -> new GuiFrame(new StepByStep(x1,t1)));
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
		r1.add("boh");
	when(x1.getStepByStep()).thenReturn(r1);
		frameFix.panel("stepByStep");
		frameFix.button("btnForward").click();
		frameFix.textBox("textPaneXtoTenResult").requireText("boh\n");
	}
	@Test
	public void testForwarButtonChangeBackButtonState(){
		frameFix.button("btnForward").click();
		frameFix.button("btnBack").requireEnabled();
	}
	@Test
	public void testForwarXButtonChangeTextPanetextPaneXtoTenResultState(){
		r1.add("simple text");
		when(x1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForward").click();
		frameFix.textBox("textPaneXtoTenResult").requireText("simple text\n");
	}
	@Test
	public void testForwarXButtonDisabledAfterShowAllSteps(){
		r1.add("simple text");
		when(x1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForward").click();
		frameFix.button("btnForward").requireDisabled();
	}
	@Test
	public void testForwarXButtonChangeTextPanetextPaneXtoTenResultStateTwoString(){
		r1.add("simple text");
		r1.add("second simple text");
		when(x1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForward").click();
		frameFix.button("btnForward").click();
		frameFix.textBox("textPaneXtoTenResult").requireText("simple text\nsecond simple text\n");
	}
	@Test
	public void testForwarXButtonChangeTextPanetextPaneXtoTenResultStateMoreClickThanStep(){
		r1.add("simple text");
		r1.add("second simple text");
		when(x1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForward").click();
		frameFix.button("btnForward").click();
		frameFix.button("btnForward").click();
		frameFix.textBox("textPaneXtoTenResult").requireText("simple text\nsecond simple text\n");
	}
	@Test
	public void testForwarTButtonDisabledAfterShowAllSteps(){
		r1.add("simple text");
		when(t1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForward_1").click();
		frameFix.button("btnForward_1").requireDisabled();
	}
	@Test
	public void testForwarTButtonChangeTextPanetextPaneXtoTenResultStateTwoString(){
		r1.add("simple text");
		r1.add("second simple text");
		when(t1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForward_1").click();
		frameFix.button("btnForward_1").click();
		frameFix.textBox("textPaneTenToXResult").requireText("simple text\nsecond simple text\n");
	}
}
