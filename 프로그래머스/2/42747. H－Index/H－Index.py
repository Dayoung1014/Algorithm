def solution(citations):
    citations.sort(reverse=True)
    for i in range(len(citations)):
        print(citations[i])
        print(i+1)
        print()
        if citations[i] <= i+1: 
            if citations[i] == i+1:
                return i+1
            else:
                return i
    return len(citations)