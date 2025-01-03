nCnt, mCnt = map(int, input().split(' '))
s = set()
for n in range(nCnt):
    s.add(input())

cnt = 0
for m in range(mCnt):
    word = input()
    if word in s:
        cnt += 1

print(cnt)