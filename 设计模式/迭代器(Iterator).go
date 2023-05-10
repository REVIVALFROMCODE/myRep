//最顶层有两个接口 集合+迭代器
type Collection interface {
    createIterator() Iterator
}

type Iterator interface {
    hasNext() bool
    getNext() *User
}

//要迭代的结构体形如User
type User struct {
    name string
    age  int
}

//为User定义 具体的 集合+迭代器
type UserCollection struct {
    users []*User
}
func (u *UserCollection) createIterator() Iterator {
    return &UserIterator{
        users: u.users,
    }
}

type UserIterator struct {
    index int
    users []*User //具体集合与具体迭代器共享一个slice
}
func (u *UserIterator) hasNext() bool {
    if u.index < len(u.users) {
        return true
    }
    return false

}
func (u *UserIterator) getNext() *User {
    if u.hasNext() {
        user := u.users[u.index]
        u.index++
        return user
    }
    return nil
}

//测试
package main

import "fmt"

func main() {

    user1 := &User{
        name: "a",
        age:  30,
    }
    user2 := &User{
        name: "b",
        age:  20,
    }
    //实例化具体集合与具体迭代器
    userCollection := &UserCollection{
        users: []*User{user1, user2},
    }

    iterator := userCollection.createIterator()

    for iterator.hasNext() {
        user := iterator.getNext()
        fmt.Printf("User is %+v\n", user)
    }
}
