package main

import (
	"fmt"
	"sort"
)

// prereqs记录了每个课程的前置课程
var prereqs = map[string][]string{
	"algorithms": {"data structures"},
	"calculus":   {"linear algebra"},
	"compilers": {
		"data structures",
		"formal languages",
		"computer organization",
	},
	"data structures":       {"discrete math"},
	"databases":             {"data structures"},
	"discrete math":         {"intro to programming"},
	"formal languages":      {"discrete math"},
	"networks":              {"operating systems"},
	"operating systems":     {"data structures", "computer organization"},
	"programming languages": {"data structures", "computer organization"},
}

func topoSort(m map[string][]string) []string {
	var order []string
	seen := make(map[string]bool)
	var visitAll func(items []string) //先声明后面匿名才能递归
	visitAll = func(items []string) { //最开始传入map中的keys
		for _, item := range items {
			if !seen[item] {
				seen[item] = true           //拿到一个key先标记
				visitAll(m[item])           //递归调用visitAll传入values即该key的前置课程
				order = append(order, item) //最后即递归返回后才将该key加入队列,这样其前置课程一定优先
			}
		}
	}
	var keys []string
	for key := range m {
		keys = append(keys, key)
	}
	sort.Strings(keys) //由于遍历map顺序不一样,排序后保证其结果唯一
	visitAll(keys)
	return order
}
func main() {
	for i, course := range topoSort(prereqs) {
		fmt.Printf("%d:\t%s\n", i+1, course)
	}
}
