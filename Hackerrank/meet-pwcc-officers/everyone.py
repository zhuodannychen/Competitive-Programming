keys = {'0' : 'marksturtevant',
        '1' : 'dannychen',
        '2' : 'jimmyding',
        '3' : 'anhnguyen',
        '4' : 'robinbailey',
        '5' : 'collinjakubik',
        '6' : 'ericzhang',
        '7' : 'aaronchang',
        '8' : 'maxwelljiang',
        '9' : 'saibommisetty',
       }

alpha = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '&']
key = '-1'

n = int(input())
for i in range(n):
    flag = False
    strr = ''
    if i == 0:
        strr = input()
        for j in range(len(strr)):
            if strr[j:j+1] == '&':
                flag = True
                key = strr[j+1:j+2]
                break
        if not flag:
            print(strr)
            break
    else:
        strr = input()
        if key == '-1':
            print(strr)
        else:
            final_str = ''
            key_list = list(keys[key])
            key_count = 0
            for ch in strr:
                if ch not in alpha:
                    final_str += ch
                else:
                    if key_count >= len(keys[key]):
                        key_count = 0
                    diff = alpha.index(ch) - (ord(key_list[key_count]) - 97)
                    # print('TEST', ch, key_list[key_count], diff)
                    final_str += alpha[diff]
                    key_count += 1
            if '&' in final_str:
                x = final_str.index('&') + 1
                key = final_str[x]
                continue
            else:
                print(final_str)
                break
