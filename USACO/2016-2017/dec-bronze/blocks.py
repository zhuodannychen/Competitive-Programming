def get_number_of_blocks(word):
    blocks = [0] * 26
    for ch in word:
        val = ord(ch) - 97
        blocks[val] += 1
    return blocks


with open('blocks.in') as f:
    n = int(f.readline())
    result = [0] * 26
    for i in range(n):
        a, b = map(str, f.readline().split())

        la = get_number_of_blocks(a)
        lb = get_number_of_blocks(b)

        for j in range(26):
            if la[j] >= lb[j]:
                result[j] += la[j]
            else:
                result[j] += lb[j]
    pw = open('blocks.out', 'w')
    for i in result:
        print(i)
        pw.write(str(i)+'\n')
    pw.close()
