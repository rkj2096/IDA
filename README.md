# IDA
It is implementation of Information Dispersal Algorithm.

**Information Dispersal Algorithm (IDA)**  which breaks a file _F_ of length L = |_F_| into _n_ pieces _F_  _i_ , 1 ≤ _i_ ≤ _n_, each of length |F _i_ | = _L/m_, so that every _m_ pieces suffice for reconstructing _F_.
>Source: [Michael O. Rabin, Efficient Dispersal of Information for Security](https://link.springer.com/chapter/10.1007/978-1-4612-3352-7_32)

## Encoding
Let F= b1,b2, ………..bN be a file that is string of character. 

The character bi may be considered as integers taken from a certain range[0………..p-1]. Now, F is a string of residues mod p, that is, a string of elements in the finite field Zp(p is a large prime number).

Choose n vectors ai = (ai1, . . . , aim,) € Zmp, 1<=i<=n, such that every subset of m different vectors are linearly independent. Alternatively, it will suffice to assume that with high probability, a randomly chosen subset of m vectors in (ai ,……..,an ) is linearly independent.

The file F is segmented into sequences of length m. Thus
F = (b1…………bm), (bm+1………..b2m) , ……..
Denote S = (b1,………bm), etc . For i=1,………..,n,
Fi = Ci1, Ci2,…….CiN/m,
Where Cik =ai.Sk=ai1.b(k-1)(m+1)+………..aim.bkm.
It follows that |Fi=|F|/m.|.

>For simplicity i have considered message consists of space separated integers.
## Decoding
If m pieces of F ,say F1, …….Fm are given, we reconstruct F as follows. Let A=(a _ij_ ) 1<=i,j<=m be the m*n matrix whose ith row is ai. It is radially seen that

A.[b1……..bm]^T^ =[C11………Cm1]^T^
And hence [b1………bm] ^T^= A-1.[C __……..Cm1]^T^.

## Preview

![enter image description here](https://lh3.googleusercontent.com/1nIa3sa0yYRTebJImKKsth-ZS1ODGzHOe4I5g9AF_IddPm5yhX9RSHqpWY2_zPavlEOi1JPUQ6_1)
>Note: Prime has no meaning.

