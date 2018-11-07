#https://www.hackerrank.com/contests/frozen-eagle-2018-dry-runs/challenges

import re
pattern = '^(?=[MDCLXVI])M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$'

n=int(input())
for i in range(n):
    roman = str(input())    
    if re.search(pattern, roman):
        print('Yes')
    else:
        print('No')
