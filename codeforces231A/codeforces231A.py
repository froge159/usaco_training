fin = open("Input.txt", 'r')
fout = open("Output.txt", 'w')
problems = int(fin.readline())
implemented = 0
yes = 0
for _ in range(problems):
    x = [int(i) for i in fin.readline().split()]
    for j in x:
        if j == 1:
            yes += 1
        if yes > 2 or yes == 2:
            implemented += 1
            yes = 0
fout.write(str(implemented) + '\n')
fout.close()
