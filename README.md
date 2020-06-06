# COMP354-Team-Project

## Standard Deviation
- square
```
input: a double n, a double i, a double j
output: a double of squared value of n

mid <- (i + j)/2
mult <- mid * mid

if mult == n || abs(mult - n) < 0.00001 do:
  return mid
else if mult < n do:
  return square(n, mid, j)
else do:
  return square(n, i, mid)
```

- square root
```
input: a double num
output: a double of the square root value of num

i <- 1
res <- 0
found <- false

while not found do:
  if i * i == num do:
    found <- true
  else if i * i > num do:
    res <- square(num, i - 1, i)
    found <- true
  i <- i + 1
end while

return res
```

- variance
```
input: an array of doubles arr, an integer n
output: a double for the variance of the array arr of length n

sum <- 0

for i <- 0 to n do:
  sum = sum + arr[i]
end for
  
mean <- sum / n
sqdiff <- 0

for i <- 0 to n do:
  sqdiff <- sqdiff + (arr[i] - mean) * (arr[i] - mean)
end for

return variance(arr, n)
```

- standard deviation
```
input: an array of doubles arr, an integer n
output: a double of the square root value for the variance of the array arr of length n

return sqrt(variance(arr, n))
```

## Design Choice
Arraylist was used when prompting for user input, as it is a dynamic data structure and is perfect for storing user input. In our case, user can also decide how many numbers they would like to enter into the calculator, without being restricted by the input size.

Exponentiation currently round down all decimal numbers, where future interations will focus on improving handling decimal numbers.

## e^x
1. Exp-Horner(x,n) 	n indicates how many terms to calculate up to
2. P_n = 1 + x/n
3. for i = 1 to n - 1
4.   P_n = 1 + x/(n-i)P_n
5. return P_n
```
1. Exp(x)
2.   return Exp-Horner(x,1000)     n = 1000 gives good accuracy
```
## Absolute Deviation (MAD)

 - sum
```
input: an array of doubles arr
output: the sum of the numbers in the array arr

sum <- 0

for i <-0 to n do:
  sum = sum + arr[i]
end for

return sum
```
 - absolute
```
input: a number n
output: positive n

if n < 0 
  return -n
else 
  return n
end if
```
 - mean absolute deviation
```
input: an array of doubles arr and an integer n
output: the mean absolute deviation of the array arr of length n

mean <- sum(arr) / n
abdiff <- 0

for i <- 0 to n do:
  abdiff = abdiff + abs(arr[i] - mean);
end for

abdiff = abdiff / n

return abdiff
```

## π^x
 - powersOfPi
```
Input: a double exp
Output: a double ofπraised to the power of exp

protoPi <- 0
sign <- 1
limit <- 100000000

for i <- 1 to i < limit do:
  protoPi <- protoPi + (sign/i)
  sign <- -1*sign
end for

pi <- protoPi*4

return power(pi, exp)
```

- power
```
Input: a double base, a double exp
Output: a double of the base raised to the power of exp

nthRoot <- 1
isNegative <- exp < 0
exp <-  isNegative ?  exp*(-1) :  exp

while exp%1 != 0 do:
  exp <- exp * 10
  nthRoot <- nthRoot*10
end while

base <- root(base, nthRoot)
powerResult <- 1
newExp <- exp

powerResult <- quickPower(base, newExp)
return isNegative ?  1/powerResult :  powerResult
```

- nthRoot
```
Input: a double base, a long nthRoot
Output: a double of the nthRoot of base

if nthRoot == 1 do:
  return base

upperRoot <- 1
lowerRoot <- 0
baseApproximation <- 1

for root <- 1 to baseApproximation < base do:
  baseApproximation *= quickPower(root, nthRoot)

  if baseApproximation == base do:
    return root
  upperRoot <- root
end for

lowerRoot <- upperRoot - 1

return bisectionMethod(upperRoot, lowerRoot, base, nthRoot)
```

- bisectionMethod
```
Input: a double upperRoot, a double lowerRoot, a double base, a long nthRoot
Output: a double of an approximation of the nth root of base

estimatedRoot <- 1
count <- 0

while upperRoot - lowerRoot > EPSILON OR count < 100000 do:
  middleBaseApproximation <- 1
  middleRoot <- (upperRoot + lowerRoot)/2
  
  middleApproximation = quickPower(middleRoot, nthRoot)
  
  if middleBaseApproximation > base do:
    upperRoot <- middleRoot
  else do:
    lowerRoot <- middleRoot  
estimatedRoot <- middleRoot
  count <- count + 1
end while

return estimatedRoot
```

- quickPower
```
Input: a double base, a long exp
Output: a double of the power of base to the exponent

if exp == 0 do:
  return 1

temp <- quickPower(base, exp/2)

if exp%2 == 0 do:
  return temp*temp
else do:
  return base*temp*temp
```

## Data Structures
For the function pi^x, no data structures were needed. In order to create this function, power; nthRoot; and bisection method functions were made. Since an iterative approach was taken, previous values stored were replaced, thus making variables sufficient. 
