package main

import (
	"fmt"
)

func main() {
	jobs := make(chan int, 100)
	results := make(chan int, 100)
  
  //四个goRoutine,共享同一个管道jobs,jobs管道内每一项传进fib求一项值代表一件任务.4个routine抢占式执行,相当于4个cpu并行.由于其操作相当于取出数据,故无所谓先后,直到jobs被取空.
	go worker(jobs, results)
	go worker(jobs, results)
	go worker(jobs, results)
	go worker(jobs, results)
  
  //100件任务被装进jobs,一定是带buffer的.
	for i := 0; i < 100; i++ {
		jobs <- i
	}
  //任务全部装载完成,关闭jobs.
	close(jobs)
  
  //results与jobs同100 buffer.任务与结果映射
	for j := 0; j < 100; j++ {
		fmt.Println(<-results)
	}
}

//参数列表:jobs仅输出(只读)<-chan,results仅输入(只写)chan<-
func worker(jobs <-chan int, results chan<- int) {
	for n := range jobs {
		results <- fib(n)
	}
}

//stupid algorithm
func fib(n int) int {
	if n <= 1 {
		return n
	}

	return fib(n-1) + fib(n-2)
}
