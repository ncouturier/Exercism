

NUMBERS = ["a ","two ","three ","four ", "five ", "six ","seven ","eight ","nine ","ten ","eleven ","twelve ", "thirteen ", "fourteen ", "fifteen ","sixteen ","seventeen ", "eighteen ","nineteen "]
NUMERALS = ["first","second","third","fourth","fifth","sixth","seventh","eighth","ninth","tenth","eleventh","twelfth"]
OBJECTS = ["Partridge in a Pear Tree","Turtle Doves","French Hens","Calling Birds","Gold Rings","Geese-a-Laying","Swans-a-Swimming","Maids-a-Milking","Ladies Dancing","Lords-a-Leaping","Pipers Piping"]



def firstn(n):
    num = n
    yield  f"On the {NUMERALS[num-1]} day of Christmas my true love gave to me: "
    while num > 0:
        sep = "," if num >0 else "."
        prefix = "and " if (num ==0 and not n==1) else ""
        yield f"{prefix}{NUMBERS[num-1]} {OBJECTS[num-1]}{sep}"
        num -= 1

def recite(start_verse, end_verse):
    return [item for item in firstn(end_verse)][start_verse-1:]
