# ArcTanPiApproximator
This project demonstrates the mathematical technique of using arctangent series to approximate the value of π

## Overview
This project demonstrates the mathematical technique of using arctangent series to approximate the value of π. The implementation includes:

Calculation of arctangent using alternating series
Methods to determine the minimum number of terms needed for a specific error margin
Verification routines to validate the calculations
Different approaches to estimate π using arctangent identities

Mathematical Background
The project is based on the following mathematical principles:

The arctangent function can be represented as an alternating series:
arctan(x) = x - x³/3 + x⁵/5 - x⁷/7 + ... for |x| ≤ 1

Mathematical identities relating arctangent to π:

π/6 = arctan(1/√3)
π/4 = arctan(1)
π/3 = arctan(√3)


The implementation uses these identities along with series convergence analysis to approximate π with controlled error margins.

### Features

arctanAltSeries(): Calculates arctangent using alternating series with a specified number of terms
findN(): Determines the smallest N such that |b_{N+1}| ≤ given error
findM(): Finds the smallest M such that |S_M - π/4| ≤ given error
findV(): Finds the smallest V for arctangent approximation of √3
Verification methods to confirm calculations match expected values

### Error Analysis
The code includes routines to verify the accuracy of calculations by:

Comparing calculated values to known mathematical constants
Computing the absolute difference between approximations and actual values
Determining the minimum number of terms required for desired accuracy levels

### Usage
To run the program:
bashjavac ArctanSeriesFINAL.java
java ArctanSeriesFINAL
The program will output:

Approximation of arctan(1/√3)
Verification tables for different term counts
Minimum terms needed for specified error margins
Estimation of π using arctangent of √3

Example Output
Step 2: Express arctan(1/sqrt(3)) as an alternating series
arctan(1/sqrt(3)) = 0.5235987755982988
Smallest N such that |b_{N+1}| <= 10^-6: 6

Step 3: Verify the work in part 2
n	Sn		|Sn - pi/6|
1	0.5773502692	0.0537514936
2	0.5224025425	0.0011962331
3	0.5238690996	0.0002713240
4	0.5235615582	0.0000362174
5	0.5236032425	0.0000044669
6	0.5235982269	0.0000005487
7	0.5235988624	0.0000000868
8	0.5235987619	0.0000000137
...

### Mathematical Extensions
The code explores different methods for approximating π:

Using the identity π = 6 * arctan(1/√3)
Using the identity π = 4 * arctan(1)
Using the identity π = 3 * arctan(√3)

Each approach has different convergence characteristics which are analyzed in the implementation.
