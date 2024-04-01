def solution(s):
    words = []
    for w in s.split(' '):
        if not w.strip():
            words.append(w)
            continue
        words.append(w[0].upper()+w[1:].lower() if not w[0].isdigit() else w[0]+w[1:].lower())
    return ' '.join(words)