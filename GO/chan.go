package main

import (
	"fmt"
	"time"
)

func main() {
	c := make(chan string, 50)
	go count("sheep", c)

	for msg := range c { //use range channel but no need to comma ok ,it never cause panic.
		fmt.Println(msg)
	}
	/* equal as above,regular useway.
	for {
		msg, ok := <-c

		if !ok {
			break
		}

		fmt.Println(msg)
	}
	*/
}

func count(thing string, c chan string) {
	for i := 1; i <= 5; i++ {
		c <- thing
		time.Sleep(time.Millisecond * 500)
	}

	close(c)
}

func chanNoBufferExample() { //Assuming this case run in main(),will cause panic.
	c := make(chan string)
	c <- "hello" //put message in chan,but no goRountine running.message in,no way out,cause panic.
	msg := <-c   //get message from chan,it will auto wait.
}
