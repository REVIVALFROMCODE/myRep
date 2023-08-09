func swapPairs(head *ListNode) *ListNode { //24
	if head == nil || head.Next == nil {
		return head
	}
	var dummyHead = &ListNode{0, head}
	cur := dummyHead
	for cur.Next != nil && cur.Next.Next != nil {
		cur.Next, cur.Next.Next, cur.Next.Next.Next, cur =
			cur.Next.Next, cur.Next.Next.Next, cur.Next, cur.Next
	}
	return dummyHead.Next
}
//The key is dummyHead 1st:reserve head. 2nd:determine for loop condition in only one state. 3rd:easy to reverse next two node.
//1st and 2nd is universal to all linkedList puzzles.3nd is particular in this puzzle.
//Explain 1st:If you directly use head,even you have cur or temp,after one loop, your head is second node,not first node,
//you just lost first node with no excuse.
//Explain 2nd:There is two conditions,odd numbers or evem numbers in List.
//Without dummyHead,your cur must point on first node that you want swap.
//Therefore,you may find two conditions can not conduct in only one statement in you loop condition.
//e.g. odds numbers:cur is valid,cur.Next is nil.The loop should be break. even numbers:cur is nil.The loop should be break.
//What's your statement on your loop?cur.Next!=nil?In the second condtion,programm will panic.You just try a nil.Next.
//cur!=nil?Can't break loop in first condition!
//Explain 3rd:Imagine LinkedList is a string.You wanna swap two nodes.Use one node just in front of two nodes.
//And hook the last one which hook first one which hook just behind two nodes.
//Finally,put that hook pointer just in front of next two nodes ready to swap and repeat this procedure.
//Additionally,hook will be hook.Next,rather than hook.Next.Next.It's all about address,not position.That's a trap on line 9.
