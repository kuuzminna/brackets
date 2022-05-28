
class Stack(private val size: Int){
	private val stackArray = ArrayList<Pair<Char, Int>>(size)
//	private val stackArray = CharArray(size)
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

fun main(){
	val enteredString : String = readLine()!!.toString()
	val stack = Stack(enteredString.length)
	var stop = false
	var i = 0
	for (c in enteredString) {
		i++
		when (c) {
			'[', '{', '(', '<' -> stack.push(c,i)
			']' -> if (stack.isEmpty()) stop = true else (if (stack.peek().first == '[' ) stack.pop() else stop = true)
			'}' -> if (stack.isEmpty()) stop = true else (if (stack.peek().first == '{' ) stack.pop() else stop = true)
			')' -> if (stack.isEmpty()) stop = true else (if (stack.peek().first == '(' ) stack.pop() else stop = true)
			'>' -> if (stack.isEmpty()) stop = true else (if (stack.peek().first == '<' ) stack.pop() else stop = true)
		}
		if (stop) {
			println(i)
			return
		}
	}
	if (stack.isEmpty()) println("Success") else println(stack.peek().second)
}