for _ in range(int(input())):
    n = int(input())
    cand = []
    sm = 0
    for i in range(n):
        votes = int(input())
        cand.append([votes, i+1])
        sm += votes
    cand.sort(reverse=True)
    if cand[0][0] > sm-cand[0][0]:
        print('majority winner', cand[0][1])
    elif cand[0][0] > cand[1][0]:
        print('minority winner', cand[0][1])
    else:
        print('no winner')
