def solution(s): 
    num=0
    for p in s:
        num+= 1 if p=='(' else -1
        if(num<0):
            return False
            
    if(num>0):
        return False
        
    return True