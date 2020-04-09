#include<bits/stdc++.h>
using namespace std;

int t, b, samepair, diffpair, ans[100];

int ask(int i) {
    cout << i+1 << "\n";
    int res;
    cin >> res;
    return res;
}

void change() {
    bool complement = false;
    if (samepair != -1 && ans[samepair] != ask(samepair))
        complement = true;
    if (samepair == -1)
        ask(0);
    bool reverse = complement;
    if (diffpair != -1 && ans[diffpair] != ask(diffpair))
        reverse = !complement;
    if (diffpair == -1)
        ask(0);

    if (complement) {
        for (int i = 0; i < b; i++)
            ans[i] = !ans[i];
    }
    if (reverse) {
        for (int i = 0; i < b / 2; i++) {
            swap(ans[i], ans[b-i-1]);
        }
    }
}

int main() {
    cin >> t >> b;
    while (t-- > 0) {
        samepair = -1;
        diffpair = -1;
        int count = 0;
        for (int i = 0; i < 5; i++) {
            ans[count] = ask(count);
            ans[b-count-1] = ask(b-count-1);
            if (samepair == -1 && ans[count] == ans[b-count-1])
                samepair = count;
            if (diffpair == -1 && ans[count] != ans[b-count-1])
                diffpair = count;
            count++;
        }

        change();
        while (count < b/2) {
            for (int i = 0; i < 4 && count < b/2; i++) {
                ans[count] = ask(count);
                ans[b-count-1] = ask(b-count-1);
                if (samepair == -1 && ans[count] == ans[b-count-1])
                    samepair = count;
                if (diffpair == -1 && ans[count] != ans[b-count-1])
                    diffpair = count;
                count++;
            }
            change();
        }
        for (int i = 0; i < b; i++) {
            cout << ans[i];
        }
        cout << "\n";
        char correct;
        cin >> correct;
        if (correct == 'N')
            return -1;
    }
}

