package main

import (
	"fmt"
)

func fibonacci(n int, c chan int) {
	x, y := 0, 1
	for i := 0; i < n; i++ {
		c <- x//发送到chan
		x, y = y, x+y
	}
	close(c)//在接收端关闭chan
}

func main() {
	c := make(chan int, 10)
	go fibonacci(cap(c), c)
	for i := range c {//for从chan接收,发送端不关闭会fatal error.
		fmt.Println(i)
	}
}
