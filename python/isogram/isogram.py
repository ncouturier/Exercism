from collections import Counter

def is_isogram(string):
    if string=="":
      return True
    return Counter(list(string.replace(" ","").replace("-","").lower())).most_common(1)[0][1]==1