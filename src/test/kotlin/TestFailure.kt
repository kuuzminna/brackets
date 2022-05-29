import junit.framework.TestCase.assertEquals
import org.junit.Test

class TestFailure {
	@Test
	fun testCase1() {
		assertEquals(checkBrackets("foo(bar[i);"), "10")
	}
	@Test
	fun testCase2() {
		assertEquals(checkBrackets("()[]}"), "5")
	}
	@Test
	fun testCase3() {
		assertEquals(checkBrackets("{{[()]]"), "7")
	}
	@Test
	fun testCase4() {
		assertEquals(checkBrackets("(]"), "2")
	}
	@Test
	fun testCase5() {
		assertEquals(checkBrackets("hey]]]"), "4")
	}
	@Test
	fun testCase6() {
		assertEquals(checkBrackets("[()]}}()"), "5")
	}
	@Test
	fun testCase7() {
		assertEquals(checkBrackets(")([](){([])})"), "1")
	}
	@Test
	fun testCase8() {
		assertEquals(checkBrackets("()}()"), "3")
	}
	@Test
	fun testOpenedBracket1() {
		assertEquals(checkBrackets("{"), "1")
	}
	@Test
	fun testOpenedBracket2() {
		assertEquals(checkBrackets("{()"), "1")
	}
	@Test
	fun testOpenedBracket3() {
		assertEquals(checkBrackets("(){()"), "3")
	}
	@Test
	fun testOpenedBracket4() {
		assertEquals(checkBrackets("(((("), "4")
	}
	@Test
	fun testOpenedBracket5() {
		assertEquals(checkBrackets("{{{[][][]"), "3")
	}
	@Test
	fun testOpenedBracket6() {
		assertEquals(checkBrackets("{()}{"), "5")
	}
	@Test
	fun testOpenedBracket7() {
		assertEquals(checkBrackets("{{{{{{{((()))}"), "6")
	}
}