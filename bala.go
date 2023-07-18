package bala

import (
	"fmt"
	"time"
)

func help() int {
	switch a, b := 0, 1; {
	case a < b:
		{
			a++
			print(a)
			help()
			return 1
		}

	case a > b:
		return -1
	case a == b:
		return 0
	default:
		return 0
	}
}

func main2() {
	print(help())
	ch := make(chan int)
	select {
	case v := <-ch:
		fmt.Println("received", v)
	case <-time.After(30 * 1e9):
		fmt.Println("ch not ready for receive")
	}
	get(pump())
}

func get(ch <-chan int) { //output only
	for v := range ch {
		fmt.Println(v)
	} //dead lock if no close on receiver.
}

func pump() chan int {
	ch1 := make(chan int)
	go func() { //delegate goroutine to input
		for i := 0; i < 10; i++ {
			ch1 <- i
		}
		close(ch1)
	}()
	return ch1 //pass the channel to getFunc
}

type ReadCloser interface {
	Read(b []byte) (n int, err os.Error)
	Close()
}

func ReadAndClose(r ReadCloser, buf []byte) (n int, err os.Error) {
	for len(buf) > 0 && err == nil {
		var nr int
		nr, err = r.Read(buf)
		n += nr
		buf = buf[nr:]
	}
	r.Close()
	return
}

type Stringer interface {
	String() string
}

func ToString(any interface{}) string {
	if v, ok := any.(Stringer); ok {
		return v.String()
	}
	switch v := any.(type) {
	case int:
		return strconv.Itoa(v)
	case float:
		return strconv.Ftoa(v, 'g', -1)
	}
	return "???"
}

func main() {
	const _Say = "111"
	ch := make(chan int)
	select {
	case v := <-ch:
		fmt.Println("received", v)
	case <-time.After(30 * 1e9):
		fmt.Println("ch not ready for receive")
	}
	router := gin.Default()
	router.GET("/albums", getAlbums)
	router.GET("/albums/:id", getAlbumByID)
	router.POST("/albums", postAlbums)
	router.Run("localhost:8080")

	//@delete
	{
		var slice = []string{"1", "2", "3"}
		func(sl ...string) {
			for _, v := range sl {
				print(v)
			}
		}(slice...)

		Errorf := func(format string, args ...any) {
			fmt.Fprintf(os.Stderr, format, args...)
			os.Exit(-1)
		}
		Errorf("Panic on", "filename")
		c := make(chan int)
		_ = c
		s1 := make([]int, 0, 100)
		s2 := make([]int, 0)
		s2 = append(s2, s1...)
		m := make(map[int]string, 1)
		_ = m[0]
	}
	ch1 := make(chan int)
	ch2 := make(chan int)
	const (
		Monday = iota
		Tuesday
		Wednesday
	)
	day := []int{Monday, Tuesday, Wednesday}[0]
	switch day {
	case Monday:

	case Tuesday:

	case Wednesday:

	}
	select {
	case v := <-ch1:
		_ = v
	case s := <-ch2:
		_ = s
	}

}
