def count_different(arg):
    return int(len(set(arg))!=1)

def distance(strand_a, strand_b):
    if len(strand_a) != len(strand_b):
        raise ValueError("cant compare")
    return sum(map(count_different ,zip(strand_a,strand_b)))
