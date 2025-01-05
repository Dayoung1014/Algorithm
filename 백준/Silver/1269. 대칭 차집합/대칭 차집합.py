cntA, cntB = map(int, input().split(' '))
arrA = set(input().split(' '))
arrB = set(input().split(' '))
print(len(arrA-arrB) + len(arrB-arrA))