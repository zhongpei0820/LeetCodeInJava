// // Implement atoi to convert a string to an integer.

// // Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

// // Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

// Requirements for atoi:
// The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

// The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

// If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

// If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.

// Solution:
// Key to this problem is to consider all possible input cases according to the requirement.

// 1. Elminate all the spaces before the first non-space character.
// 2. Check whether the first non-space character is '+' or '-', and set the sign.
// 3. Check the following characters, if it is non-integer, the break.
// 4. Check the overflow


public class Solution {
    public int myAtoi(String str) {
        int i = 0,sign = 1,ret = 0;
        while(i < str.length() && str.charAt(i) == ' ') i++;        
        if(i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-')){ sign = str.charAt(i) == '+' ? 1 : -1; i++;}        
        while(i < str.length()){
            int digit = str.charAt(i) - '0';
            if(digit < 0 || digit > 9) break;
            if((Integer.MAX_VALUE - digit) / 10 < ret) return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;           
            ret = ret * 10 + digit;
            i++;            
        }
        return ret * sign;        
    }
}