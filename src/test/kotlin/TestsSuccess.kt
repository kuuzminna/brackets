import junit.framework.TestCase.assertEquals
import org.junit.Test


class TestsSuccess {
	@Test
	fun testWithTheFirstBracket() {
		assertEquals( checkBrackets("{}"), "Success")
	}
	@Test
	fun testWithTheSecondBracket() {
		assertEquals( checkBrackets("()"), "Success")
	}
	@Test
	fun testWithTheThirdBracket() {
		assertEquals( checkBrackets("<>"), "Success")
	}
	@Test
	fun testWithTheFourthBracket() {
		assertEquals( checkBrackets("<>"), "Success")
	}
	@Test
	fun testWithOtherCharacters () {
		assertEquals(checkBrackets("foo(bar);"), "Success")
	}
	@Test
	fun testWithConsecutiveBrackets() {
		assertEquals( checkBrackets("{}(){}<>[]"), "Success")
	}
	@Test
	fun testWithInconsistentBrackets1() {
		assertEquals(checkBrackets("({})"), "Success")
	}
	@Test
	fun testWithOtherCharactersAndInconsistentBrackets() {
		assertEquals(checkBrackets("({12}(po1)<12>)"), "Success")
	}
	@Test
	fun testWithOtherCharactersAndConsecutiveBrackets() {
		assertEquals(checkBrackets("foo(bar);{04}.(as)"), "Success")
	}
	@Test
	fun testWithInconsistentBrackets2() {
		assertEquals(checkBrackets("([](){([])})"), "Success")
	}
	@Test
	fun testWithoutBrackets() {
		assertEquals(checkBrackets("allow"), "Success")
	}
	@Test
	fun testWithoutBracketsAndCharacters() {
		assertEquals(checkBrackets(""), "Success")
	}
	@Test
	fun testWithBracketsAndCharacters() {
		assertEquals(checkBrackets("(aa)"), "Success")
	}
}
