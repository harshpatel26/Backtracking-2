
class Solution {  
    public List<List<String>> partition(String s) {  
        List<List<String>> results = new ArrayList<>();  
        int n = s.length();  
        int numOfSubsets = 1 << (n - 1);   
  
        for (int subsetMask = 0; subsetMask < numOfSubsets; subsetMask++) {  
            List<String> currentPartition = new ArrayList<>();  
            int start = 0;  
            boolean valid = true;  
  
            for (int i = 0; i < n - 1; i++) {   
                if ((subsetMask & (1 << i)) != 0) {  
                    String substring = s.substring(start, i + 1);  
                    if (isPalindrome(substring)) {  
                        currentPartition.add(substring);  
                        start = i + 1;  
                    } else {  
                        valid = false;  
                        break;  
                    }  
                }  
            }  
  
            if (valid) {  
                String substring = s.substring(start);  
                if (isPalindrome(substring)) {  
                    currentPartition.add(substring);  
                    results.add(currentPartition);  
                }  
            }  
        }  
  
        return results;  
    }  
  
    private static boolean isPalindrome(String s) {  
        int i = 0, j = s.length() - 1;  
        while (i < j) {  
            if (s.charAt(i++) != s.charAt(j--)) {  
                return false;  
            }  
        }  
        return true;  
    }  
}  
