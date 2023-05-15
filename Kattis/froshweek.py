def mergesort(arr):
    inversions = 0
    if len(arr) > 1:
        mid = len(arr) // 2
        left = arr[:mid]
        right = arr[mid:]
        inversions += mergesort(left);
        inversions += mergesort(right);

        i = j = k = 0
        while i < len(left) and j < len(right):
            if left[i] < right[j]:
                arr[k] = left[i]
                i += 1
            else:
                arr[k] = right[j]
                j += 1
                inversions += len(left) - i
            k += 1
        while i < len(left):
            arr[k] = left[i]
            i += 1
            k += 1
        while j < len(right):
            arr[k] = right[j]
            j += 1
            k += 1

    return inversions

n = int(input())
nums = []
for i in range(n):
    nums.append(int(input()))
print(mergesort(nums))

"""
Solve with fenwick tree
class FenwickTree {
public:
    vll arr;
    int n;
    FenwickTree(int sz) {
        arr.assign(sz, 0);
        n = sz;
    }

    void update(int idx, int val) {
        while (idx < n) {
            arr[idx] += val;
            idx += (idx & -idx);
        }
    }

    ll sum(int idx) {
        ll ans = 0;
        while (idx > 0) {
            ans += arr[idx];
            idx -= (idx & -idx);
        }
        return ans;
    }
};


int main() {
    fastio;
    int n; cin >> n;
    vi arr(n), arr1(n);
    f0r (i, n) {
        cin >> arr[i];
        arr1[i] = arr[i];
    }
    sort(all(arr1));

    FenwickTree ft(n+1);
    ll swaps = 0;
    f0r (i, n) {
        int idx = lower_bound(all(arr1), arr[i]) - arr1.begin() + 1;    
        ft.update(idx, 1); 
        swaps += ft.sum(n) - ft.sum(idx);
    }
    cout << swaps << endl;
}

"""
