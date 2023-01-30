fin = open("mixmilk.in", 'r')
fout = open("mixmilk.out", 'w')
a, x = map(int, fin.readline().split())
b, y = map(int, fin.readline().split())
c, z = map(int, fin.readline().split())

pours = 0
buckets = [x, y, z]
limit = [a, b, c]
while pours < 100:
    for i in range(len(buckets)):
        if pours == 100:
            break
        if i == 2:
            buckets[0] += buckets[2]
            pours += 1
            if buckets[0] > limit[0]:
                buckets[2] = buckets[0] - limit[0]
                buckets[0] = limit[0]
                continue
            buckets[2] = 0
            continue
        else:
            buckets[i + 1] += buckets[i]
            pours += 1
            if buckets[i + 1] > limit[i + 1]:
                buckets[i] = buckets[i + 1] - limit[i + 1]
                buckets[i + 1] = limit[i + 1]
                continue
            buckets[i] = 0
            continue
for i in buckets:
    fout.write(str(i) + '\n')
fout.close()
