# Roger Robertson
# Assignment 10: Prime Factors
# Difficulty: Standard

PRIMES = (2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31)

def main():

    # test cases
##    print('Test cases:')
##    factor(12)
##    factor(67)
##    factor(42)
##    factor(312)
##    factor(904)
##    factor(678)
##    factor(400)
##    factor(999)
   

    # user input
    num = int(input('Enter a number between 1 and 1,000: '))

    # input validation
    if 1 <= num <= 1000:
        factor(num)
    else:
        print('Error: Invalid value. Goodbye.')


def factor(num):

    output = []
    og = num
    outstring = ''


        # prime test
##        for p in PRIMES:
##            if num % p == 0:
##                output.append(p)

    # build list of primes
    for p in PRIMES:
        while p * p < num:
            while num % p == 0:
                output.append(p)
                num = num // p
                if num != 1:
                    output.append(num)
            p = num
            
    # clean output but still include final factor      
    for n in output:
        if n not in PRIMES and n != output[-1]:
            output.remove(n)

        # convert list to string for display
        outstring = ' '.join(str(y) for y in output)
        
    # output
    print('The factors of ', og, ': ', outstring, '\n', sep='')
               



            
main()
