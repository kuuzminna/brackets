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