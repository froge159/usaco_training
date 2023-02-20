import sys
sys.stdin = open('speeding.in','r')
sys.stdout = open('speeding.out','w')
n, m = [int(x) for x in input().split()]
limitSpeed = []
besSpeed = []
speeding = 0

for _ in range(n):
    a, b = map(int, input().split())
    for _ in range(a):
        limitSpeed.append(b)
for _ in range(m):
    x, y = map(int, input().split())
    for _ in range(x):
        besSpeed.append(y)

for i in range(100):
    if besSpeed[i] > limitSpeed[i]:
        if speeding < besSpeed[i] - limitSpeed[i]:
            speeding = besSpeed[i] - limitSpeed[i]


print(speeding)
