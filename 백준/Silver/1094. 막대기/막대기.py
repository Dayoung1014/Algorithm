X = int(input())
arr = [1, 2, 4, 8, 16, 32, 64]
num = 0
cnt = 0

for n in arr[::-1]:
    if num + n <= X:
        num += n
        cnt += 1

    if num == X:
        break

print(cnt)

