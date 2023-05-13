package main

import "fmt"

func fibonacci(c, quit chan int) {
	x, y := 0, 1
	for {
		select {//下面2个case,哪个能跑跑那个,抢占式
		case c <- x://向chan中发送,注意一定先跑go,这里才能发,一方面有激活的goroutine你才能向无buffer的chan发送.另一方面函数相当于在main中跑是顺序执行的.
			x, y = y, x+y
		case <-quit://quit没数据可输出时会阻塞.如果不用select,只用for,两个case会顺序执行,从quit取出必然发生在一次向c发送后.
			fmt.Println("quit")
			return
		}
	}
}

func main() {
	c := make(chan int)
	quit := make(chan int)

	go func() {
		for i := 0; i < 10; i++ {
			fmt.Println(<-c)//从chan中取,取够10个后向quit发送0,另一边select取到0会return
		}
		quit <- 0
	}()
	fibonacci(c, quit)//在函数中向chan发送,相当于在main中发送
}
