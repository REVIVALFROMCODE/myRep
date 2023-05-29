package main

import "fmt"

type OptFunc func(opt *Opts)
type Opts struct {
	name    string
	maxConn int
	tls     bool
}

func defaultOpt() Opts {
	return Opts{
		name:    "default",
		maxConn: 10,
		tls:     false,
	}
}
func withTls(opt *Opts) {
	opt.tls = true
}
func withName(name string) func(opt *Opts) {
	return func(opt *Opts) {
		opt.name = name
	}
}
func withMaxConn(connNum int) func(opt *Opts) {
	return func(opt *Opts) {
		opt.maxConn = connNum
	}
}

type Server struct {
	Opts
}

func NewServer(opts ...OptFunc) *Server {
	o := defaultOpt()
	for _, fun := range opts {
		fun(&o)
	}
	return &Server{Opts: o}
}

func main() {
	tlsServer := NewServer(withTls)
	nameServer := NewServer(withName("customerNameServer"))
	connServer := NewServer(withMaxConn(1000))
	fmt.Println(tlsServer, nameServer, connServer)
}
