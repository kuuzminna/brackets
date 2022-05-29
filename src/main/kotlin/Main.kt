fun checkBrackets(enteredString: String) : String {
	val stack = Stack(enteredString.length)
	val closedBrackets = charArrayOf(')', '}', ']', '>')
	val openedBrackets = charArrayOf('(', '{', '[', '<')
	var stop = false
	var i = 0
	for (c in enteredString) {
		i++
		var j = -1
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

	println (checkBrackets(enteredString))
}