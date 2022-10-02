#include <bits/stdc++.h>
using namespace std;


const int MX = 100005;
int dat[MX], pre[MX], nxt[MX];
int unused = 1;
void insert(int addr, int num){
  dat[unused] = num;
  pre[unused] = addr;
  nxt[unused] = nxt[addr];
  nxt[addr] = unused;
  if(nxt[addr] != -1)pre[nxt[addr]] = unused;
  unused++;
}
void erase(int addr){
  nxt[pre[addr]] = nxt[addr];
  if(nxt[addr] != -1) pre[nxt[addr]] = pre[addr];
}