file=open("symbols.txt",mode="r")
map=input("mapping: ")
#map2=map.split(',')
#print(map2[0])
str="*#@$"
for line in file:
    name = line.strip()
    i=len(name)
    while(i>0):
        if(name.find(str[0])!=-1):
            print(map[2], end = '')
        elif (name.find(str[1])!=-1):
            print(map[6], end = '')
        elif (name.find(str[2])!=-1):
            print(map[10], end = '')
        elif (name.find(str[3])!=-1):
            print(map[14], end = '')
        i-=1
    print("\n", end = '')
file.close()