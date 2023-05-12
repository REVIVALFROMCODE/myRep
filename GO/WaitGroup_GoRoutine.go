package main

import (
	"fmt"
	"sync"
	"time"
)

func main() {
	var wg sync.WaitGroup//use as a counter
	wg.Add(1)//counter+=1

	go func() {
		count("sheep")
		wg.Done()//counter--
	}()

  wg.Wait()//make main process wait for GoRoutines (that count in WaitGroup) as above.
  //If no wait,main function will exit.
}

func count(thing string) {
	for i := 1; i <= 5; i++ {
		fmt.Println(i, thing)
		time.Sleep(time.Millisecond * 500)
	}
}
