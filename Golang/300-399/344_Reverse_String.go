//Write a function that takes a string as input and returns the string reversed.
//
//
//Example:
//Given s = "hello", return "olleh".
//

func reverseString(s string) string {
    c := []rune(s)
    for i,j := 0,len(c)-1; i < j; i,j = i+1,j-1 {
        c[i],c[j] = c[j],c[i]
    }
    return string(c)
}