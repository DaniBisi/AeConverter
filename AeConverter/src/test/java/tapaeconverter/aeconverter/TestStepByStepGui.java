package tapaeconverter.aeconverter;


import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import tapaeconverter.aeconverter.FrameGui;
import tapaeconverter.aeconverter.StepByStepGui;
import tapaeconverter.aeconverter.TenToXConverterCore;
import tapaeconverter.aeconverter.XtoTenConverterCore;

import static org.mockito.Mockito.*;


import java.util.ArrayList;

public class TestStepByStepGui{

	private FrameFixture frameFix;
	private XtoTenConverterCore x1;
	private TenToXConverterCore t1;
	private ArrayList <String> r1;
	
	public TestStepByStepGui() {
		
		x1 = mock(XtoTenConverterCore.class);
		t1 = mock(TenToXConverterCore.class);
	}
	@BeforeClass
	  public static void setUpOnce() {
	    FailOnThreadViolationRepaintManager.install();
	}

	@Before
	public void setUp() throws Exception {
//		StepByStep sbs = new StepByStep(x1,t1);
		FrameGui frame = GuiActionRunner.execute(() -> new FrameGui(new StepByStepGui(x1,t1)));
		frameFix = new FrameFixture(frame);
		r1 = new ArrayList<String>();
		//frameFix.show();
	}

	@After
	public void tearDown() throws Exception {
		frameFix.cleanUp();
	}

	//###################### XtoTen Part ############################
	@Test
	public void testBtnBackDisabletAtStart() {
		frameFix.button("btnBackX").requireDisabled();
	}
	@Test
	public void testForwardButtonChangeBackButtonState(){
		r1.add("boh");
		when(x1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForward").click();
		frameFix.button("btnBackX").requireEnabled();
	}
	@Test
	public void testForwardXButtonChangeTextPane(){
		r1.add("simple text");
		when(x1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForward").click();
		frameFix.textBox("textPaneXtoTenResult").requireText("simple text\n");
	}

	@Test
	public void testForwardXButtonChangeTextPaneTwoString(){
		r1.add("simple text");
		r1.add("second simple text");
		when(x1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForward").click();
		frameFix.button("btnForward").click();
		frameFix.textBox("textPaneXtoTenResult").requireText("simple text\nsecond simple text\n");
	}
	@Test
	public void testForwardXButtonDisabledAfterShowAllSteps(){
		r1.add("simple text");
		when(x1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForward").click();
		frameFix.button("btnForward").requireDisabled();
	}
	
	@Test
	public void testBackButtonChangeTextPane(){
		r1.add("simple text");
		when(x1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForward").click();
		frameFix.button("btnBackX").click();
		frameFix.textBox("textPaneXtoTenResult").requireText("");
		
	}
	@Test
	public void testForwardXButtonDisabledMoreStep(){
		r1.add("simple text");
		r1.add("simple text2");
		when(x1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForward").click();
		frameFix.button("btnForward").click();
		frameFix.button("btnForward").requireDisabled();		
	}
	@Test
	public void testForwardXButtonAfterBackButtonx(){
		r1.add("simple text");
		r1.add("simple text2");
		when(x1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForward").click();
		frameFix.button("btnForward").click();
		frameFix.button("btnBackX").click();
		frameFix.button("btnForward").click();
		frameFix.button("btnForward").requireDisabled();		
	}
	@Test
	public void testBackXButtonEnabledAfterOneStep(){
		r1.add("simple text");
		r1.add("simple text2");
		when(x1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForward").click();
		frameFix.button("btnForward").click();
		frameFix.button("btnBackX").click();
		frameFix.button("btnBackX").requireEnabled();
}
	@Test
	public void testBackButtonChangeTextPaneTwoString(){
		r1.add("simple text");
		r1.add("second simple text");
		when(x1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForward").click();
		frameFix.button("btnForward").click();
		frameFix.button("btnBackX").click();
		frameFix.textBox("textPaneXtoTenResult").requireText("simple text\n");
	}
	@Test 
	public void testBackButtonChangeForwardStatus(){
		r1.add("simple text");
		r1.add("second simple text");
		when(x1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForward").click();
		frameFix.button("btnForward").click();
		frameFix.button("btnBackX").click();
		frameFix.button("btnForward").requireEnabled();
	}
	@Test
	public void testAllStep(){
		r1.add("simple text");
		r1.add("second simple text");
		when(x1.getStepByStep()).thenReturn(r1);
		frameFix.button("allStep").click();
		frameFix.textBox("textPaneXtoTenResult").requireText("simple text\nsecond simple text\n");
	}
	@Test
	public void TestAllStepChangeBtnBackStatus(){
		frameFix.button("allStep").click();
		frameFix.button("btnBackX").requireEnabled();
	}
	@Test
	public void TestAllStepChangeBtnForwardStatus(){
		frameFix.button("allStep").click();
		frameFix.button("btnForward").requireDisabled();
	}
	
	
	//###################### END XtoTen Part ############################
	
	//####################### TenToX Part ###############################
	@Test
	public void testForwardTButtonDisabledAfterShowAllSteps(){
		r1.add("simple text");
		when(t1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForward_1").click();
		frameFix.button("btnForward_1").requireDisabled();
	}
	@Test
	public void testForwardTButtonChangeTextPanetextPaneXtoTenResultStateTwoString(){
		r1.add("simple text");
		r1.add("second simple text");
		when(t1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForward_1").click();
		frameFix.button("btnForward_1").click();
		frameFix.textBox("textPaneTenToXResult").requireText("simple text\nsecond simple text\n");
	}
	
	
	
	
}
