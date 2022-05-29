
//class Stack(size: Int){
//	private val stackArray = ArrayList<Pair<Char, Int>>(size)
//	private var top = -1
//
//	fun push(basket: Char, i: Int) {
//		stackArray.add(Pair(basket, i))
//		top++
//	}
//	fun pop():  Pair<Char, Int> {
//		return stackArray.removeAt(top--)
//
//	}
//	fun peek(): Pair<Char, Int> {
//		return stackArray[top]
//	}
//	fun isEmpty(): Boolean {
//		return top == -1
//	}
//}
//
//fun main(){
//	val enteredString : String = readLine()!!.toString()
//	val stack = Stack(enteredString.length)
//	var stop = false
//	var i = 0
//	for (c in enteredString) {
//		i++
//		when (c) {
//			'[', '{', '(', '<' -> stack.push(c,i)
//			']' -> if (stack.isEmpty()) stop = true else (if (stack.peek().first == '[' ) stack.pop() else stop = true)
//			'}' -> if (stack.isEmpty()) stop = true else (if (stack.peek().first == '{' ) stack.pop() else stop = true)
//			')' -> if (stack.isEmpty()) stop = true else (if (stack.peek().first == '(' ) stack.pop() else stop = true)
//			'>' -> if (stack.isEmpty()) stop = true else (if (stack.peek().first == '<' ) stack.pop() else stop = true)
//		}
//		if (stop) {
//			println(i)
//			return
//		}
//	}
//	if (stack.isEmpty()) println("Success") else println(stack.peek().second)
//}

class Stack(size: Int){
	private val stackArray = ArrayList<Pair<Char, Int>>(size)
	private var top = -1

	fun push(basket: Char, i: Int) {
		stackArray.add(Pair(basket, i))
		top++
	}
	fun pop():  Pair<Char, Int> {
		return stackArray.removeAt(top--)

	}
	fun peek(): Pair<Char, Int> {
		return stackArray[top]
	}
	fun isEmpty(): Boolean {
		return top == -1
	}
}

private fun checkBrackets(enteredString: String) : String {
	val stack = Stack(enteredString.length)
	val closedBrackets = charArrayOf(')', '}', ']', '>')
	val openedBrackets = charArrayOf('(', '{', '[', '<')
	var stop = false
	var i = 0
	for (c in enteredString) {
		i++
		var j = -1;
		for (k in openedBrackets)
			if (c == k) stack.push(c,i)
		for (i in closedBrackets)
		{
			j++
			if (c == i) {
				if (stack.isEmpty()) stop = true else (if (stack.peek().first == openedBrackets[j] ) stack.pop() else stop = true)
			}
		}
		if (stop) return i.toString()
	}
	return if (stack.isEmpty()) "Success" else stack.peek().second.toString()
}

fun main(){
	val enteredString : String = readLine()!!
//	val stack = Stack(enteredString.length)
//	var stop = false
//	var i = 0
//	val closedBrackets = charArrayOf(')', '}', ']', '>')
//	val openedBrackets = charArrayOf('(', '{', '[', '<')
//	for (c in enteredString) {
//		i++
//		var j = -1;
//		for (k in openedBrackets)
//			 if (c == k) stack.push(c,i)
//		for (i in closedBrackets)
//		{
//			j++
//			if (c == i) {
//				if (stack.isEmpty()) stop = true else (if (stack.peek().first == openedBrackets[j] ) stack.pop() else stop = true)
//			}
//		}
//		if (stop) {
//			println(i)
//			return
//		}
//	}
//	if (stack.isEmpty()) println("Success") else println(stack.peek().second)
	println (checkBrackets(enteredString))
}