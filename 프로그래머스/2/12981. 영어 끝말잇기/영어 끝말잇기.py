def solution(n, words):
    fail, cnt = 0, 0
    words_set = set()
    words_set.add(words[0])
    
    for i in range(1, len(words)):
        now = words[i]
        prev = words[i-1]
        
        if now in words_set or now[0] != prev[-1]:
            fail = i%n + 1 
            cnt = i//n + 1 
            break
        else:
            words_set.add(now)

    return [fail, cnt]