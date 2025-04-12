For now, because you haven't published the module yet, you need to adapt the example.com/hello module so it can find the example.com/greetings code on your local file system.

```go mod edit -replace example.com/greetings=../greetings```

run the **go mod tidy** command to synchronize the example.com/hello module's dependencies

