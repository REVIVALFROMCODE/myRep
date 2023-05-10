package main
import (
    "fmt"
    "log"
    "net/http"
    "time"
)
// $GOROOT/src/net/http/server.go
// http.Handler
type Handler interface {
    ServeHTTP(ResponseWriter, *Request)
}

// Implement上述Handler接口的函数类型,用作适配器Adapter
type HandlerFunc func(ResponseWriter, *Request)

func (f HandlerFunc) ServeHTTP(w ResponseWriter, r *Request) {
    f(w, r)
}

// 函数签名同上述HandlerFunc,届时可通过类型转换 Implement Handler接口
func greetings(w http.ResponseWriter, r *http.Request) {
    fmt.Fprintf(w, "Welcome!")
}

// 两个装饰器,接收Handler返回Handler
func logHandler(h http.Handler) http.Handler {
    return http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
        t := time.Now()
        log.Printf("[%s] %q %v\n", r.Method, r.URL.String(), t)
        h.ServeHTTP(w, r)
    })
}

func authHandler(h http.Handler) http.Handler {
    validateAuth := func(s string) error {
        if s != "123456" {
            return fmt.Errorf("%s", "bad auth token")
        }
        return nil
    }
    return http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
        err := validateAuth(r.Header.Get("auth"))
        if err != nil {
            http.Error(w, "bad auth param", http.StatusUnauthorized)
            return
        }
        h.ServeHTTP(w, r)
    })

}

//先用Adapter符合Handler接口,再用两次Decorator链式调用返回增加限制(功能)的Handler
func main() {
    http.ListenAndServe(":8080", logHandler(authHandler(http.HandlerFunc(greetings))))
}
