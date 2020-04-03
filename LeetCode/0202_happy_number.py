# using floyd cycle detection
class Solution:
    def isHappy(self, n: int) -> bool:
        def next(n):
            ls = list(str(n))
            ls = list(map(int, [int(x) * int(x) for x in ls]))
            return sum(ls)

        tortoise = n
        hare = next(n)
        while tortoise != hare and hare != 1:
            tortoise = next(tortoise)
            hare = next(next(hare))
        return hare == 1 or tortoise != hare
