# COMP354-Team-Project

## Pseudocode
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


- square root
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
