def solution(s):
    answer = [int(ans) for ans in s.split(' ')] 
    return str(min(answer)) + ' ' + str(max(answer))