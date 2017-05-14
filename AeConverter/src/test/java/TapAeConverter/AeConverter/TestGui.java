package TapAeConverter.AeConverter;


import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

//@RunWith(GUITestRunner.class)
//@GUITest
public class TestGui {

	private FrameFixture frameFix;

	@BeforeClass
	public static void setUpOnce() {
		FailOnThreadViolationRepaintManager.install();
	}

	@Before
	public void setUp() throws Exception {
		MakeChoise frame = GuiActionRunner.execute(() -> new MakeChoise());
		this.frameFix = new FrameFixture(frame);
		frameFix.show();

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBaseConverterButtonChangePanel() {
		frameFix.button("base_converter").click();
		frameFix.panel("baseConverter");
	}

}
