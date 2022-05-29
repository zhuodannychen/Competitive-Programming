days = int(input())
val = 100
prices = []
for i in range(days):
    prices.append(int(input()))
# handle case for 1 day
for i in range(1, days):
    profit = prices[i] - prices[i-1]
    if profit <= 0:
        continue
    buys = val // prices[i-1]
    buys = min(100000, buys)
    val += buys * profit
print(val)



