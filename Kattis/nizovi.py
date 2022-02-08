s = list(input())
stack = []
spaces = 0
seq = []
curr = ''
for i in range(len(s)):
    if s[i] == '{':
        seq.append('{')
    elif s[i] == '}':
        if len(curr) != 0:
            seq.append(curr)
            curr = ''
        seq.append('}')
    elif s[i] == ',':
        if len(curr) != 0:
            seq.append(curr)
        seq.append(',')
        curr = ''
    else:
        curr += s[i]

for i in range(len(seq)):
    if seq[i] == '{':
        print(' '*spaces + '{')
        spaces += 2
    elif seq[i] == '}':
        spaces -= 2
        if i > 0 and seq[i-1] == '{':
            print(' '*spaces + '}', end='')
        else:
            print('\n' + ' '*spaces + '}', end='')
    elif seq[i] == ',':
        print(',')
    else:
        print(' '*spaces + seq[i], end='')
print()


