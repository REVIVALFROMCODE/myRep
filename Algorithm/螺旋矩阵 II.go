func generateMatrix(n int) [][]int {//leetcode 0059
	num := make([][]int, n)
	for i := 0; i < n; i++ {
		num[i] = make([]int, n)
	}
	startX, startY, offset, j, k, cnt := 0, 0, 0, 0, 0, 1
	for i := 0; i < n/2; i++ {
		for j = startX; j < n-offset-1; j++ {
			num[offset][j] = cnt
			cnt++
		}
		for k = startY; k < n-offset-1; k++ {
			num[k][j] = cnt
			cnt++
		}
		for ; j > startX; j-- {
			num[k][j] = cnt
			cnt++
		}
		for ; k > startY; k-- {
			num[k][j] = cnt
			cnt++
		}
		offset++
		startX++
		startY++
	}
	if mid:=n/2;n%2!=0{
		num[mid][mid]=cnt
	}
	fmt.Println(num)
	return num
}
