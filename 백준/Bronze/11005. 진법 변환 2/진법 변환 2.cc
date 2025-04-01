#include <bits/stdc++.h>
using namespace std;

// 입출력 최적화
void fast_io()
{
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
}

// 유틸리티 함수들
#define ll long long
#define ull unsigned long long
#define pii pair<int, int>
#define pll pair<ll, ll>
#define vi vector<int>
#define vll vector<ll>
#define vpii vector<pii>
#define vpll vector<pll>
#define pb push_back
#define mp make_pair
#define all(x) (x).begin(), (x).end()
#define sz(x) (int)(x).size()

// 디버깅용 매크로 (필요에 따라 주석 처리 가능)
#define debug(x) cerr << #x << " = " << (x) << endl

// 상수들
const int INF = 1e9;
const ll LINF = 1e18;
const int MOD = 1e9 + 7;

// 문제 해결 함수
void solve()
{
    int n,b;
    cin >> n >> b;
    string ans = "";
    while(n !=0){
        int remain = n%b;
        if(remain >= 10){
            ans = (char)(remain-10+'A') + ans;
        }else{
            ans = (char)(remain+'0') + ans;
        }
        n /= b;
    } 

    cout << ans;
}

int main()
{
  fast_io();

  int t=1;

  while (t--)
  {
    solve();
  }

  return 0;
}