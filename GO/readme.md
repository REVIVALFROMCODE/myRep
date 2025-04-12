Create a greetings directory for your Go module source code.

```
mkdir greetings
cd greetings
```

Run the go mod init command, giving it your module path -- here, use example.com/greetings.

The go mod init command creates a go.mod file to track your code's dependencies. 

```
$ go mod init example.com/greetings
go: creating new go.mod: module example.com/greetings
```

```
package greetings

import "fmt"

// Hello returns a greeting for the named person.
func Hello(name string) string {
    // Return a greeting that embeds the name in a message.
    message := fmt.Sprintf("Hi, %v. Welcome!", name)
    return message
}
```

In this code, you:

Declare a greetings package to collect related functions.
Implement a Hello function to return the greeting.

Function:a function whose name starts with a capital letter can be called by a function not in the same package. This is known in Go as an exported name.

![image](https://github.com/user-attachments/assets/f74780f1-d543-4d88-81f5-36947992ab7a)


Create a hello directory for your Go module source code. 

```
cd ..
mkdir hello
cd hello
```

You should have both a hello and a greetings directory at the same level in the hierarchy, like so:

```
<home>/
 |-- greetings/
 |-- hello/
```

Write code to call the Hello function, then print the function's return value.

```
package main

import (
    "fmt"

    "example.com/greetings"
)

func main() {
    // Get a greeting message and print it.
    message := greetings.Hello("Gladys")
    fmt.Println(message)
}
```

For now, because you haven't published the module yet, you need to adapt the example.com/hello module so it can find the example.com/greetings code on your local file system.

```go mod edit -replace example.com/greetings=../greetings```

After you run the command, the go.mod file in the hello directory should include a replace directive:

```
module example.com/hello

go 1.16

replace example.com/greetings => ../greetings
```

run the **go mod tidy** command to synchronize the example.com/hello module's dependencies

After the command completes, the example.com/hello module's go.mod file should look like this:

```
module example.com/hello

go 1.16

replace example.com/greetings => ../greetings

require example.com/greetings v0.0.0-00010101000000-000000000000
```

At the command prompt in the hello directory, run your code to confirm that it works.

```
$ go run .
Hi, Gladys. Welcome!
```

