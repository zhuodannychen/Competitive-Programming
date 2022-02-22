n, m = map(int, input().split())
if m > n:
    if abs(m-n) > 1:
        print(f"Dr. Chaz will have {m-n} pieces of chicken left over!")
    else:
        print(f"Dr. Chaz will have {m-n} piece of chicken left over!")
else:
    if abs(m-n) > 1:
        print(f"Dr. Chaz needs {n-m} more pieces of chicken!")
    else:
        print(f"Dr. Chaz needs {n-m} more piece of chicken!")
