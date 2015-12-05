package edu.jiangxin.tools;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Decimal2ChineseCharacterTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testConvert() {
		String decimal = "123.45";
		Assert.assertEquals("壹佰贰拾叁元肆角伍分", Decimal2ChineseCharacter.convert(decimal));

		decimal = "1005423.45";
		Assert.assertEquals("壹佰万伍仟肆佰贰拾叁元肆角伍分", Decimal2ChineseCharacter.convert(decimal));
	}

}
