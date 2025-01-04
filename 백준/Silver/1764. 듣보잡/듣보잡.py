inputN, inputM = map(int, input().split(' '))
set1 = set()
set2 = set()
for n in range(inputN):
    set1.add(input())

for m in range(inputM):
    set2.add(input())

result = sorted(list(set1&set2))
print(len(result))
for n in result:
    print(n)