import sys
sys.stdin = open('paint.in', 'r')
sys.stdout = open('paint.out', 'w')
a, b = map(int, input().split())
c, d = map(int, input().split())
if b > c and a < d:
    x = max(a, b, c, d)
    y = min(a, b, c, d)
    print(x - y)
else:
    print((b - a) + (d - c))
    
