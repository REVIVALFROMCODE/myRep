#!/bin/bash
echo '1
2
3
4
5'>input #输入5行存入input文件
sum=0
while read line
do      let sum=sum+line
done<input #以input为标准输入读入while read line
echo $sum

#input
#1
#2
#3
#4
#5

#ouput
#15
