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
		int bounds[] = new int[] {100,180,450,410};
		
		FrameGui frame = GuiActionRunner.execute(() -> new FrameGui(new StepByStepGui(x1,t1),bounds,true));
		frameFix = new FrameFixture(frame);
		r1 = new ArrayList<String>();
		//frameFix.show();
	}

	@After
	public void tearDown() throws Exception {
		frameFix.cleanUp();
	}

	@Test
	public void TestStepByStepBackButton() {
		frameFix.button("back").click();
		frameFix.panel("baseConverter").requireEnabled();
	}
	@Test
	public void TestStepByStepCloseButton() {
		frameFix.button("close").click();
		frameFix.requireNotVisible();
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
		frameFix.button("btnForwardX").click();
		frameFix.button("btnBackX").requireEnabled();
	}
	@Test
	public void testForwardXButtonChangeTextPane(){
		r1.add("simple text");
		when(x1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForwardX").click();
		frameFix.textBox("textPaneXtoTenResult").requireText("simple text\n");
	}

	@Test
	public void testForwardXButtonChangeTextPaneTwoString(){
		r1.add("simple text");
		r1.add("second simple text");
		when(x1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForwardX").click();
		frameFix.button("btnForwardX").click();
		frameFix.textBox("textPaneXtoTenResult").requireText("simple text\nsecond simple text\n");
	}
	@Test
	public void testForwardXButtonDisabledAfterShowAllSteps(){
		r1.add("simple text");
		when(x1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForwardX").click();
		frameFix.button("btnForwardX").requireDisabled();
	}
	
	@Test
	public void testBackButtonChangeTextPane(){
		r1.add("simple text");
		when(x1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForwardX").click();
		frameFix.button("btnBackX").click();
		frameFix.textBox("textPaneXtoTenResult").requireText("");
		
	}
	@Test
	public void testForwardXButtonDisabledMoreStep(){
		r1.add("simple text");
		r1.add("simple text2");
		when(x1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForwardX").click();
		frameFix.button("btnForwardX").click();
		frameFix.button("btnForwardX").requireDisabled();		
	}
	@Test
	public void testForwardXButtonAfterBackButtonx(){
		r1.add("simple text");
		r1.add("simple text2");
		when(x1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForwardX").click();
		frameFix.button("btnForwardX").click();
		frameFix.button("btnBackX").click();
		frameFix.button("btnForwardX").click();
		frameFix.button("btnForwardX").requireDisabled();		
	}
	@Test
	public void testBackXButtonEnabledAfterOneStep(){
		r1.add("simple text");
		r1.add("simple text2");
		when(x1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForwardX").click();
		frameFix.button("btnForwardX").click();
		frameFix.button("btnBackX").click();
		frameFix.button("btnBackX").requireEnabled();
}
	@Test
	public void testBackButtonChangeTextPaneTwoString(){
		r1.add("simple text");
		r1.add("second simple text");
		when(x1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForwardX").click();
		frameFix.button("btnForwardX").click();
		frameFix.button("btnBackX").click();
		frameFix.textBox("textPaneXtoTenResult").requireText("simple text\n");
	}
	@Test 
	public void testBackButtonChangeForwardStatus(){
		r1.add("simple text");
		r1.add("second simple text");
		when(x1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForwardX").click();
		frameFix.button("btnForwardX").click();
		frameFix.button("btnBackX").click();
		frameFix.button("btnForwardX").requireEnabled();
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
	public void TestAllXStepChangeBtnBackStatus(){
		frameFix.button("allStep").click();
		frameFix.button("btnBackX").requireEnabled();
	}
	@Test
	public void TestAllStepChangeBtnForwardStatus(){
		frameFix.button("allStep").click();
		frameFix.button("btnForwardX").requireDisabled();
	}
	
	
	//###################### END XtoTen Part ############################
	
	//####################### TenToX Part ###############################

	@Test
	public void testBtnBackTDisabletAtStart() {
		frameFix.button("btnBackT").requireDisabled();
	}
	@Test
	public void testForwardTButtonChangeBackButtonState(){
		r1.add("boh");
		when(t1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForwardT").click();
		frameFix.button("btnBackT").requireEnabled();
	}
	@Test
	public void testForwardTButtonChangeTextPane(){
		r1.add("simple text");
		when(t1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForwardT").click();
		frameFix.textBox("textPaneTenToXResult").requireText("simple text\n");
	}

	@Test
	public void testForwardTButtonChangeTextPaneTwoString(){
		r1.add("simple text");
		r1.add("second simple text");
		when(t1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForwardT").click();
		frameFix.button("btnForwardT").click();
		frameFix.textBox("textPaneTenToXResult").requireText("simple text\nsecond simple text\n");
	}
	@Test
	public void testForwardTButtonDisabledAfterShowAllSteps(){
		r1.add("simple text");
		when(t1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForwardT").click();
		frameFix.button("btnForwardT").requireDisabled();
	}
	
	@Test
	public void testBackTButtonChangeTextPane(){
		r1.add("simple text");
		when(t1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForwardT").click();
		frameFix.button("btnBackT").click();
		frameFix.textBox("textPaneTenToXResult").requireText("");
		
	}
	@Test
	public void testForwardTButtonDisabledMoreStep(){
		r1.add("simple text");
		r1.add("simple text2");
		when(t1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForwardT").click();
		frameFix.button("btnForwardT").click();
		frameFix.button("btnForwardT").requireDisabled();		
	}
	@Test
	public void testForwardTButtonAfterBackButtonx(){
		r1.add("simple text");
		r1.add("simple text2");
		when(t1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForwardT").click();
		frameFix.button("btnForwardT").click();
		frameFix.button("btnBackT").click();
		frameFix.button("btnForwardT").click();
		frameFix.button("btnForwardT").requireDisabled();		
	}
	@Test
	public void testBackTButtonEnabledAfterOneStep(){
		r1.add("simple text");
		r1.add("simple text2");
		when(t1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForwardT").click();
		frameFix.button("btnForwardT").click();
		frameFix.button("btnBackT").click();
		frameFix.button("btnBackT").requireEnabled();
}
	@Test
	public void testBackTButtonChangeTextPaneTwoString(){
		r1.add("simple text");
		r1.add("second simple text");
		when(t1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForwardT").click();
		frameFix.button("btnForwardT").click();
		frameFix.button("btnBackT").click();
		frameFix.textBox("textPaneTenToXResult").requireText("simple text\n");
	}
	@Test 
	public void testBackTButtonChangeForwardStatus(){
		r1.add("simple text");
		r1.add("second simple text");
		when(t1.getStepByStep()).thenReturn(r1);
		frameFix.button("btnForwardT").click();
		frameFix.button("btnForwardT").click();
		frameFix.button("btnBackT").click();
		frameFix.button("btnForwardT").requireEnabled();
	}
	@Test
	public void testAllStepT(){
		r1.add("simple text");
		r1.add("second simple text");
		when(t1.getStepByStep()).thenReturn(r1);
		frameFix.button("allStepT").click();
		frameFix.textBox("textPaneTenToXResult").requireText("simple text\nsecond simple text\n");
	}
	@Test
	public void TestAllTStepChangeBtnBackStatus(){
		frameFix.button("allStepT").click();
		frameFix.button("btnBackT").requireEnabled();
	}
	@Test
	public void TestAllStepChangebtnForwardTStatus(){
		frameFix.button("allStepT").click();
		frameFix.button("btnForwardT").requireDisabled();
	}
	
	
	
	
	
}
