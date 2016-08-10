#!/usr/bin/env python
# Fibonacci numbers module

# write Fibonacci series up to n
def fib(n):
    a, b = 0, 1
    while b < n:
        print b,
        a, b = b, a+b

# return Fibonacci series up to n
def fib2(n):
    result = []
    a, b = 0, 1
    while b < n:
        result.append(b)
        a, b = b, a+b
    return result

if __name__ == "__main__":
    import sys
    for arg in sys.argv:
        print arg,
    fib(int(sys.argv[1]))
