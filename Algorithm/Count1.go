//1010 1111 1000 x&(x-1)->x, 1000,1110,0000
//1010 & 1001 = 1000 & 0111 = 0000
func hammingWeight(num uint32) int {
    count:=0
    for num!=0{
        count++
        num=(num)&(num-1)
    }
    return count
}

/*
(x>>) ^ ((x-1)>>)
(1011>>) ^ (1010>>) = 000 -> count++
(101>>) ^ (100>>) = 00 -> count++
(10>>) ^ (01>>) = 1 -> not 1
(1>>) ^ (0>>) = 0^0 = 0 -> count++  
func hammingWeight(num uint32) int {
    count:=0
    for num!=0{
        less:=num-1
        num,less=(num>>1),(less>>1)
        if result:=num^less;result==uint32(0){
            count++
        }
    }
    return count
}
*/
