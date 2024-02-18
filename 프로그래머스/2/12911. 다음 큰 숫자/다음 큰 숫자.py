def solution(n):
    answer = n
    cnt = str(bin(n)).count('1')
    
    while(True):
        answer += 1
        if(str(bin(answer)).count('1')==cnt):
            break
    
    return answer