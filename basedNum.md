#### HW03 -- Codify The Revisions / Gh-flavored Markdown / We are codifying our algorithms for binary to decimal conversion and vice versa through Gh-flavored markdown. 

#### *2021-09-24*

### Conversion of binary to decimal:

- Let *n* represent the position of the desired digit relative to the rightmost digit. The value of * n * for the rightmost digit would be 0. 
    - For example, the * n * value of the leftmost 1 in 1101 <sub> 2 </sub> would be 3 relative to the rightmost 1. 
- Multiply each desired digit with 2 <sup> n </sup> where *n* is the cooresponding position mentioned in #1.

    - In the above example, we would multiply 1x2<sup>3 </sup> since the cooresponding digit is 1 and *n=1* We then repeat this process for all other values.
- Sum the products evalutated at step 2.
    - Following step 2, we would then sum 8+4+1=13.
    
### Conversion of decimal to binary 
- Divide your decimal value by 2. 
- Keep note of your remainders, which should either be 0 or 1.
- If your quotient is not an integer value, round down. Use this new quotient value to divide by 2.
- Keep repeating these 3 steps until your quotient is / rounds down to 0. 
- Write your remainders starting from your last remainder to the first one from right to left. 

| Decimal | Quotient | Remainder |
| --- | --- | --- |
| 69 | 34.5 → 34 | 1 |
| 34 | 17 | 0 |
| 17 | 8.5 → 8 | 1| 
| 8 | 4 | 0 |
| 4 | 2 | 0|
| 2 | 1 | 0| 
| 1 | 0.5 → 0 | 1 |
> 69 in base 2 is therefore 1000101 <sub> 2 </sub>