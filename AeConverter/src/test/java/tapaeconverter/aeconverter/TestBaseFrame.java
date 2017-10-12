package tapaeconverter.aeconverter;

import org.assertj.swing.fixture.FrameFixture;
import org.junit.Test;

public abstract class TestBaseFrame {

	protected FrameFixture frameFix;

	@Test
	public void testMenuFile() {
		frameFix.menuItem("File").requireEnabled();
	}

	@Test
	public void testMenuFileClose() {
		frameFix.menuItem("File").click();
		frameFix.menuItem("close").click();
		frameFix.requireNotVisible();
	}

	@Test
	public void testNewBaseConversion() {
		frameFix.menuItem("File").click();
		frameFix.menuItem("baseConversion").click();
		frameFix.panel("baseConverter").requireVisible();
	}

}
