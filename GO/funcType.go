package main

import (
	"crypto/sha256"
	"encoding/hex"
	"fmt"
)

type TransformFunc func(string) string //指不指定参数变量名无所谓,仅有可读性,不具备约束性
type Server struct {
	//fileTransformFunc TransformFunc 这样写可读性差,下面使用匿名类型无需变量名.我们只关注类型
	TransformFunc
}

func (s *Server) handleRequest(filename string) error {
	newFileName := s.TransformFunc(filename)//TransformFunc作为一种映射,string->string,这里的过程可以是hash 拼接等等...
	fmt.Println(newFileName)
	return nil
}
func hashFileName(filename string) string {
	hash := sha256.Sum256([]byte(filename))
	newFileName := hex.EncodeToString(hash[:])
	return newFileName
}
func PrefixFileName(prefix string) TransformFunc {//需求:TransformFunc只接收一个string,那拼接不同的形态就要写不同的TransformFunc,接收两个参数却不符合签名,故归纳出该函数接收Prefix返回TransformFunc
	return func(filename string) string { return prefix + filename } //这里变量名filename是别的也可以,函数签名不要求参数名,只要求参数类型.
}//延伸思考:想指定插入prefix的位置怎么实现?::func PrefixFileName(prefix string,point int) TransformFunc,完全可以接受两个参数,因为我们是赋值TransformFunc,返回值对应函数签名即可.
func main() {
	s := &Server{
		TransformFunc: PrefixFileName("prefix_"), //函数名后有圆括号就被调用了,这里执行后返回一个func,签名同TransformFunc故可以被赋值.
	}
	s.handleRequest("myFileName")
	s.TransformFunc = hashFileName
	s.handleRequest("myFileName")
}
